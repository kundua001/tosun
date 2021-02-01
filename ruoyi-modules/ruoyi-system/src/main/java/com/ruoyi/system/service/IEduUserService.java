package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.EduUser;

/**
 * 用户信息Service接口
 * 
 * @author huangcankun
 * @date 2021-01-25
 */
public interface IEduUserService 
{
    /**
     * 查询用户信息
     * 
     * @param id 用户信息ID
     * @return 用户信息
     */
    public EduUser selectEduUserById(Long id);

    public EduUser selectEduUserByUserId(Long userId);

    /**
     * 查询用户信息列表
     * 
     * @param eduUser 用户信息
     * @return 用户信息集合
     */
    public List<EduUser> selectEduUserList(EduUser eduUser);

    /**
     * 新增用户信息
     * 
     * @param eduUser 用户信息
     * @return 结果
     */
    public int insertEduUser(EduUser eduUser);

    /**
     * 修改用户信息
     * 
     * @param eduUser 用户信息
     * @return 结果
     */
    public int updateEduUser(EduUser eduUser);

    /**
     * 批量删除用户信息
     * 
     * @param ids 需要删除的用户信息ID
     * @return 结果
     */
    public int deleteEduUserByIds(Long[] ids);

    /**
     * 删除用户信息信息
     * 
     * @param id 用户信息ID
     * @return 结果
     */
    public int deleteEduUserById(Long id);
}
