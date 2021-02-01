package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.EduTeacherMapper;
import com.ruoyi.system.domain.EduTeacher;
import com.ruoyi.system.service.IEduTeacherService;

/**
 * 老师Service业务层处理
 * 
 * @author huangcankun
 * @date 2021-01-24
 */
@Service
public class EduTeacherServiceImpl implements IEduTeacherService 
{
    @Autowired
    private EduTeacherMapper eduTeacherMapper;

    /**
     * 查询老师
     * 
     * @param id 老师ID
     * @return 老师
     */
    @Override
    public EduTeacher selectEduTeacherById(Long id)
    {
        return eduTeacherMapper.selectEduTeacherById(id);
    }
    /**
     * 查询老师
     *
     * @param userId 老师ID
     * @return 老师
     */
    @Override
    public EduTeacher selectEduTeacherByUserId(Long userId)
    {
        EduTeacher teacher = new EduTeacher();
        teacher.setUserId(userId);
        List<EduTeacher> eduTeachers = eduTeacherMapper.selectEduTeacherList(teacher);
        if(null != eduTeachers && eduTeachers.size() > 0){
            return eduTeachers.get(0);
        }
        return null;
    }
    /**
     * 查询老师列表
     * 
     * @param eduTeacher 老师
     * @return 老师
     */
    @Override
    public List<EduTeacher> selectEduTeacherList(EduTeacher eduTeacher)
    {
        return eduTeacherMapper.selectEduTeacherList(eduTeacher);
    }

    /**
     * 新增老师
     * 
     * @param eduTeacher 老师
     * @return 结果
     */
    @Override
    public int insertEduTeacher(EduTeacher eduTeacher)
    {
        eduTeacher.setCreateTime(DateUtils.getNowDate());
        return eduTeacherMapper.insertEduTeacher(eduTeacher);
    }

    /**
     * 修改老师
     * 
     * @param eduTeacher 老师
     * @return 结果
     */
    @Override
    public int updateEduTeacher(EduTeacher eduTeacher)
    {
        eduTeacher.setUpdateTime(DateUtils.getNowDate());
        return eduTeacherMapper.updateEduTeacher(eduTeacher);
    }

    /**
     * 批量删除老师
     * 
     * @param ids 需要删除的老师ID
     * @return 结果
     */
    @Override
    public int deleteEduTeacherByIds(Long[] ids)
    {
        return eduTeacherMapper.deleteEduTeacherByIds(ids);
    }

    /**
     * 删除老师信息
     * 
     * @param id 老师ID
     * @return 结果
     */
    @Override
    public int deleteEduTeacherById(Long id)
    {
        return eduTeacherMapper.deleteEduTeacherById(id);
    }
}
