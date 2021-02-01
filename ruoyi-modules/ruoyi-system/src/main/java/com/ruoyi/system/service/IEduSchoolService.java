package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.EduSchool;

/**
 * 学校Service接口
 * 
 * @author ruoyi
 * @date 2021-01-24
 */
public interface IEduSchoolService 
{
    /**
     * 查询学校
     * 
     * @param id 学校ID
     * @return 学校
     */
    public EduSchool selectEduSchoolById(Long id);

    /**
     * 查询学校列表
     * 
     * @param eduSchool 学校
     * @return 学校集合
     */
    public List<EduSchool> selectEduSchoolList(EduSchool eduSchool);

    /**
     * 新增学校
     * 
     * @param eduSchool 学校
     * @return 结果
     */
    public int insertEduSchool(EduSchool eduSchool);

    /**
     * 修改学校
     * 
     * @param eduSchool 学校
     * @return 结果
     */
    public int updateEduSchool(EduSchool eduSchool);

    /**
     * 批量删除学校
     * 
     * @param ids 需要删除的学校ID
     * @return 结果
     */
    public int deleteEduSchoolByIds(Long[] ids);

    /**
     * 删除学校信息
     * 
     * @param id 学校ID
     * @return 结果
     */
    public int deleteEduSchoolById(Long id);
}
