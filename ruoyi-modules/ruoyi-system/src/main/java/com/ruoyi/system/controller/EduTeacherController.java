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
import com.ruoyi.system.domain.EduTeacher;
import com.ruoyi.system.service.IEduTeacherService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 老师Controller
 * 
 * @author huangcankun
 * @date 2021-01-24
 */
@RestController
@RequestMapping("/teacher")
public class EduTeacherController extends BaseController
{
    @Autowired
    private IEduTeacherService eduTeacherService;

    /**
     * 查询老师列表
     */
    @PreAuthorize(hasPermi = "school:teacher:list")
    @GetMapping("/list")
    public TableDataInfo list(EduTeacher eduTeacher)
    {
        startPage();
        List<EduTeacher> list = eduTeacherService.selectEduTeacherList(eduTeacher);
        return getDataTable(list);
    }

    /**
     * 导出老师列表
     */
    @PreAuthorize(hasPermi = "school:teacher:export")
    @Log(title = "老师", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EduTeacher eduTeacher) throws IOException
    {
        List<EduTeacher> list = eduTeacherService.selectEduTeacherList(eduTeacher);
        ExcelUtil<EduTeacher> util = new ExcelUtil<EduTeacher>(EduTeacher.class);
        util.exportExcel(response, list, "teacher");
    }

    /**
     * 获取老师详细信息
     */
    @PreAuthorize(hasPermi = "school:teacher:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(eduTeacherService.selectEduTeacherById(id));
    }

    /**
     * 新增老师
     */
    @PreAuthorize(hasPermi = "school:teacher:add")
    @Log(title = "老师", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EduTeacher eduTeacher)
    {
        return toAjax(eduTeacherService.insertEduTeacher(eduTeacher));
    }

    /**
     * 修改老师
     */
    @PreAuthorize(hasPermi = "school:teacher:edit")
    @Log(title = "老师", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EduTeacher eduTeacher)
    {
        return toAjax(eduTeacherService.updateEduTeacher(eduTeacher));
    }

    /**
     * 删除老师
     */
    @PreAuthorize(hasPermi = "school:teacher:remove")
    @Log(title = "老师", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(eduTeacherService.deleteEduTeacherByIds(ids));
    }
}
