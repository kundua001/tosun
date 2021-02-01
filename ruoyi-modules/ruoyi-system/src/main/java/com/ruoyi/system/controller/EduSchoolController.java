package com.ruoyi.system.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
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
import com.ruoyi.system.domain.EduSchool;
import com.ruoyi.system.service.IEduSchoolService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 学校Controller
 * 
 * @author ruoyi
 * @date 2021-01-24
 */
@RestController
@RequestMapping("/school")
public class EduSchoolController extends BaseController
{
    @Autowired
    private IEduSchoolService eduSchoolService;

    /**
     * 查询学校列表
     */
    @PreAuthorize(hasPermi = "school:school:list")
    @GetMapping("/list")
    public TableDataInfo list(EduSchool eduSchool)
    {
        startPage();
        List<EduSchool> list = eduSchoolService.selectEduSchoolList(eduSchool);
        return getDataTable(list);
    }

    /**
     * 导出学校列表
     */
    @PreAuthorize(hasPermi = "school:school:export")
    @Log(title = "学校", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EduSchool eduSchool) throws IOException
    {
        List<EduSchool> list = eduSchoolService.selectEduSchoolList(eduSchool);
        ExcelUtil<EduSchool> util = new ExcelUtil<EduSchool>(EduSchool.class);
        util.exportExcel(response, list, "school");
    }

    /**
     * 获取学校详细信息
     */
    @PreAuthorize(hasPermi = "school:school:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(eduSchoolService.selectEduSchoolById(id));
    }

    /**
     * 新增学校
     */
    @PreAuthorize(hasPermi = "school:school:add")
    @Log(title = "学校", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EduSchool eduSchool)
    {
        return toAjax(eduSchoolService.insertEduSchool(eduSchool));
    }

    /**
     * 修改学校
     */
    @PreAuthorize(hasPermi = "school:school:edit")
    @Log(title = "学校", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EduSchool eduSchool)
    {
        return toAjax(eduSchoolService.updateEduSchool(eduSchool));
    }

    /**
     * 删除学校
     */
    @PreAuthorize(hasPermi = "school:school:remove")
    @Log(title = "学校", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(eduSchoolService.deleteEduSchoolByIds(ids));
    }
}
