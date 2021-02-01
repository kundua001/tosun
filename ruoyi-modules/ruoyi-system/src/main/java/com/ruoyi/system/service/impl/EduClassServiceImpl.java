package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.EduClassMapper;
import com.ruoyi.system.domain.EduClass;
import com.ruoyi.system.service.IEduClassService;

/**
 * 班级Service业务层处理
 * 
 * @author huangcankun
 * @date 2021-01-24
 */
@Service
public class EduClassServiceImpl implements IEduClassService 
{
    @Autowired
    private EduClassMapper eduClassMapper;

    /**
     * 查询班级
     * 
     * @param id 班级ID
     * @return 班级
     */
    @Override
    public EduClass selectEduClassById(Long id)
    {
        return eduClassMapper.selectEduClassById(id);
    }

    /**
     * 查询班级列表
     * 
     * @param eduClass 班级
     * @return 班级
     */
    @Override
    public List<EduClass> selectEduClassList(EduClass eduClass)
    {
        return eduClassMapper.selectEduClassList(eduClass);
    }

    /**
     * 新增班级
     * 
     * @param eduClass 班级
     * @return 结果
     */
    @Override
    public int insertEduClass(EduClass eduClass)
    {
        eduClass.setCreateTime(DateUtils.getNowDate());
        return eduClassMapper.insertEduClass(eduClass);
    }

    /**
     * 修改班级
     * 
     * @param eduClass 班级
     * @return 结果
     */
    @Override
    public int updateEduClass(EduClass eduClass)
    {
        eduClass.setUpdateTime(DateUtils.getNowDate());
        return eduClassMapper.updateEduClass(eduClass);
    }

    /**
     * 批量删除班级
     * 
     * @param ids 需要删除的班级ID
     * @return 结果
     */
    @Override
    public int deleteEduClassByIds(Long[] ids)
    {
        return eduClassMapper.deleteEduClassByIds(ids);
    }

    /**
     * 删除班级信息
     * 
     * @param id 班级ID
     * @return 结果
     */
    @Override
    public int deleteEduClassById(Long id)
    {
        return eduClassMapper.deleteEduClassById(id);
    }
}
