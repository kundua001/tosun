package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.EduSchoolMapper;
import com.ruoyi.system.domain.EduSchool;
import com.ruoyi.system.service.IEduSchoolService;

/**
 * 学校Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-01-24
 */
@Service
public class EduSchoolServiceImpl implements IEduSchoolService 
{
    @Autowired
    private EduSchoolMapper eduSchoolMapper;

    /**
     * 查询学校
     * 
     * @param id 学校ID
     * @return 学校
     */
    @Override
    public EduSchool selectEduSchoolById(Long id)
    {
        return eduSchoolMapper.selectEduSchoolById(id);
    }
    /**
     * 查询学校列表
     * 
     * @param eduSchool 学校
     * @return 学校
     */
    @Override
    public List<EduSchool> selectEduSchoolList(EduSchool eduSchool)
    {
        return eduSchoolMapper.selectEduSchoolList(eduSchool);
    }

    /**
     * 新增学校
     * 
     * @param eduSchool 学校
     * @return 结果
     */
    @Override
    public int insertEduSchool(EduSchool eduSchool)
    {
        eduSchool.setCreateTime(DateUtils.getNowDate());
        return eduSchoolMapper.insertEduSchool(eduSchool);
    }

    /**
     * 修改学校
     * 
     * @param eduSchool 学校
     * @return 结果
     */
    @Override
    public int updateEduSchool(EduSchool eduSchool)
    {
        eduSchool.setUpdateTime(DateUtils.getNowDate());
        return eduSchoolMapper.updateEduSchool(eduSchool);
    }

    /**
     * 批量删除学校
     * 
     * @param ids 需要删除的学校ID
     * @return 结果
     */
    @Override
    public int deleteEduSchoolByIds(Long[] ids)
    {
        return eduSchoolMapper.deleteEduSchoolByIds(ids);
    }

    /**
     * 删除学校信息
     * 
     * @param id 学校ID
     * @return 结果
     */
    @Override
    public int deleteEduSchoolById(Long id)
    {
        return eduSchoolMapper.deleteEduSchoolById(id);
    }
}
