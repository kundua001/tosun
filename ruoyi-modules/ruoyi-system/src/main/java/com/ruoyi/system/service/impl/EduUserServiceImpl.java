package com.ruoyi.system.service.impl;

import java.util.Collections;
import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.EduUserMapper;
import com.ruoyi.system.domain.EduUser;
import com.ruoyi.system.service.IEduUserService;

/**
 * 用户信息Service业务层处理
 * 
 * @author huangcankun
 * @date 2021-01-25
 */
@Service
public class EduUserServiceImpl implements IEduUserService 
{
    @Autowired
    private EduUserMapper eduUserMapper;

    /**
     * 查询用户信息
     * 
     * @param id 用户信息ID
     * @return 用户信息
     */
    @Override
    public EduUser selectEduUserById(Long id)
    {
        return eduUserMapper.selectEduUserById(id);
    }
    /**
     * 查询用户信息
     *
     * @param id 用户信息ID
     * @return 用户信息
     */
    @Override
    public EduUser selectEduUserByUserId(Long id)
    {
        EduUser eduUser = new EduUser();
        eduUser.setUserId(id);
        List<EduUser> eduUsers = eduUserMapper.selectEduUserList(eduUser);
        if(null != eduUsers){
            return eduUsers.get(0);
        }
        return null;
    }
    /**
     * 查询用户信息列表
     * 
     * @param eduUser 用户信息
     * @return 用户信息
     */
    @Override
    public List<EduUser> selectEduUserList(EduUser eduUser)
    {
        return eduUserMapper.selectEduUserList(eduUser);
    }

    /**
     * 新增用户信息
     * 
     * @param eduUser 用户信息
     * @return 结果
     */
    @Override
    public int insertEduUser(EduUser eduUser)
    {
        eduUser.setCreateTime(DateUtils.getNowDate());
        return eduUserMapper.insertEduUser(eduUser);
    }

    /**
     * 修改用户信息
     * 
     * @param eduUser 用户信息
     * @return 结果
     */
    @Override
    public int updateEduUser(EduUser eduUser)
    {
        eduUser.setUpdateTime(DateUtils.getNowDate());
        return eduUserMapper.updateEduUser(eduUser);
    }

    /**
     * 批量删除用户信息
     * 
     * @param ids 需要删除的用户信息ID
     * @return 结果
     */
    @Override
    public int deleteEduUserByIds(Long[] ids)
    {
        return eduUserMapper.deleteEduUserByIds(ids);
    }

    /**
     * 删除用户信息信息
     * 
     * @param id 用户信息ID
     * @return 结果
     */
    @Override
    public int deleteEduUserById(Long id)
    {
        return eduUserMapper.deleteEduUserById(id);
    }
}
