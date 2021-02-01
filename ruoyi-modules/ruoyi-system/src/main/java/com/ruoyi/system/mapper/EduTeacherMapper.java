package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.EduTeacher;

/**
 * 老师Mapper接口
 * 
 * @author huangcankun
 * @date 2021-01-24
 */
public interface EduTeacherMapper 
{
    /**
     * 查询老师
     * 
     * @param id 老师ID
     * @return 老师
     */
    public EduTeacher selectEduTeacherById(Long id);

    /**
     * 查询老师列表
     * 
     * @param eduTeacher 老师
     * @return 老师集合
     */
    public List<EduTeacher> selectEduTeacherList(EduTeacher eduTeacher);

    /**
     * 新增老师
     * 
     * @param eduTeacher 老师
     * @return 结果
     */
    public int insertEduTeacher(EduTeacher eduTeacher);

    /**
     * 修改老师
     * 
     * @param eduTeacher 老师
     * @return 结果
     */
    public int updateEduTeacher(EduTeacher eduTeacher);

    /**
     * 删除老师
     * 
     * @param id 老师ID
     * @return 结果
     */
    public int deleteEduTeacherById(Long id);

    /**
     * 批量删除老师
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteEduTeacherByIds(Long[] ids);
}
