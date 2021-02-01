package com.ruoyi.system.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.system.api.RemoteUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.PreAuthorize;
import com.ruoyi.system.domain.EduUser;
import com.ruoyi.system.service.IEduUserService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 用户信息Controller
 * 
 * @author huangcankun
 * @date 2021-01-25
 */
@RestController
@RequestMapping(value = {"/appUser"})
public class EduUserController extends BaseController
{
    @Autowired
    private IEduUserService eduUserService;
    @Autowired
    private RemoteUserService remoteUserService;
    /**
     * 查询用户信息列表
     */
    @PreAuthorize(hasPermi = "school:appUser:list")
    @GetMapping("/list")
    public TableDataInfo list(EduUser eduUser)
    {
        startPage();
        List<EduUser> list = eduUserService.selectEduUserList(eduUser);
        return getDataTable(list);
    }

    /**
     * 导出用户信息列表
     */
    @PreAuthorize(hasPermi = "school:appUser:export")
    @Log(title = "用户信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EduUser eduUser) throws IOException
    {
        List<EduUser> list = eduUserService.selectEduUserList(eduUser);
        ExcelUtil<EduUser> util = new ExcelUtil<EduUser>(EduUser.class);
        util.exportExcel(response, list, "appUser");
    }

    /**
     * 获取用户信息详细信息
     */
    @PreAuthorize(hasPermi = "school:appUser:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(eduUserService.selectEduUserById(id));
    }

    /**
     * 新增用户信息
     */
    @PreAuthorize(hasPermi = "school:appUser:add")
    @Log(title = "用户信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EduUser eduUser)
    {
        return toAjax(eduUserService.insertEduUser(eduUser));
    }

    /**
     * 修改用户信息
     */
    @PreAuthorize(hasPermi = "school:appUser:edit")
    @Log(title = "用户信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EduUser eduUser)
    {
        return toAjax(eduUserService.updateEduUser(eduUser));
    }

    /**
     * 删除用户信息
     */
    @PreAuthorize(hasPermi = "school:appUser:remove")
    @Log(title = "用户信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(eduUserService.deleteEduUserByIds(ids));
    }
}
