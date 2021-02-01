package com.ruoyi.auth.controller;

import com.ruoyi.auth.form.LoginBody;
import com.ruoyi.auth.service.SysLoginService;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.utils.StringUtils;
import com.ruoyi.common.redis.service.RedisService;
import com.ruoyi.common.security.service.TokenService;
import com.ruoyi.system.api.model.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/**
 * token 控制
 * 
 * @author ruoyi
 */
@RestController
public class TokenController
{
    @Autowired
    private TokenService tokenService;

    @Autowired
    private SysLoginService sysLoginService;
    @Resource
    private RedisService redisService;

    private final static long codeExpiredTime = 90;

    private final static long codeLife = 600;

    private final static String codeKey = "code";
    private final static String codeExpiredKey = "expired";

    @PostMapping("login")
    public R<?> login(@RequestBody LoginBody form)
    {
        // 用户登录
        LoginUser userInfo = sysLoginService.login(form.getUsername(), form.getPassword());
        // 获取登录token
        return R.ok(tokenService.createToken(userInfo));
    }
    @PostMapping("appLogin")
    public R<?> loginApp(@RequestBody LoginBody form)
    {
        if(null == form.getMobile() || null == form.getCode()){
            return R.fail("请输入正确的手机号和验证码！");
        }
        if(!validateMobilePhone(form.getMobile())){
            return R.fail("请输入正确的手机号！");
        }
        String code = this.redisService.getCacheObject(form.getMobile() + codeKey);
        if(!form.getCode().equals(code)){
            return R.fail("验证码错误！");
        }
        // 用户登录
        LoginUser userInfo = sysLoginService.loginApp(form.getMobile(), form.getCode());
        // 获取登录token
        return R.ok(tokenService.createToken(userInfo));
    }
    public static boolean validateMobilePhone(String in) {
        Pattern pattern = Pattern.compile("^[1]\\d{10}$");
        return pattern.matcher(in).matches();
    }
    @GetMapping("code")
    public R<?> code(@RequestParam(required = true) String mobile)
    {
        if(!validateMobilePhone(mobile)){
            return R.fail("请输入正确的手机号！");
        }
        if(null != this.redisService.getCacheObject(mobile+codeExpiredKey)){
            return R.fail("90秒内不能重复获取验证码！");
        }
        Random random = new Random();
        int nextInt = random.nextInt(999999);
        this.redisService.setCacheObject(mobile+codeExpiredKey,nextInt,codeExpiredTime, TimeUnit.SECONDS);
        this.redisService.setCacheObject(mobile+codeKey,Integer.toString(nextInt),codeLife, TimeUnit.SECONDS);
        return R.ok(nextInt);
    }
    @DeleteMapping("logout")
    public R<?> logout(HttpServletRequest request)
    {
        LoginUser loginUser = tokenService.getLoginUser(request);
        if (StringUtils.isNotNull(loginUser))
        {
            String username = loginUser.getUsername();
            // 删除用户缓存记录
            tokenService.delLoginUser(loginUser.getToken());
            // 记录用户退出日志
            sysLoginService.logout(username);
        }
        return R.ok();
    }

    @PostMapping("refresh")
    public R<?> refresh(HttpServletRequest request)
    {
        LoginUser loginUser = tokenService.getLoginUser(request);
        if (StringUtils.isNotNull(loginUser))
        {
            // 刷新令牌有效期
            tokenService.refreshToken(loginUser);
            return R.ok();
        }
        return R.ok();
    }
}
