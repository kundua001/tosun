package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.EduClass;

/**
 * 班级Service接口
 * 
 * @author huangcankun
 * @date 2021-01-24
 */
public interface IEduClassService 
{
    /**
     * 查询班级
     * 
     * @param id 班级ID
     * @return 班级
     */
    public EduClass selectEduClassById(Long id);

    /**
     * 查询班级列表
     * 
     * @param eduClass 班级
     * @return 班级集合
     */
    public List<EduClass> selectEduClassList(EduClass eduClass);

    /**
     * 新增班级
     * 
     * @param eduClass 班级
     * @return 结果
     */
    public int insertEduClass(EduClass eduClass);

    /**
     * 修改班级
     * 
     * @param eduClass 班级
     * @return 结果
     */
    public int updateEduClass(EduClass eduClass);

    /**
     * 批量删除班级
     * 
     * @param ids 需要删除的班级ID
     * @return 结果
     */
    public int deleteEduClassByIds(Long[] ids);

    /**
     * 删除班级信息
     * 
     * @param id 班级ID
     * @return 结果
     */
    public int deleteEduClassById(Long id);
}
