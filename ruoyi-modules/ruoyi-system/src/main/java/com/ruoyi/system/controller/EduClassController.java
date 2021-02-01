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
import com.ruoyi.system.domain.EduClass;
import com.ruoyi.system.service.IEduClassService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 班级Controller
 * 
 * @author huangcankun
 * @date 2021-01-24
 */
@RestController
@RequestMapping("/class")
public class EduClassController extends BaseController
{
    @Autowired
    private IEduClassService eduClassService;

    /**
     * 查询班级列表
     */
    @PreAuthorize(hasPermi = "school:class:list")
    @GetMapping("/list")
    public TableDataInfo list(EduClass eduClass)
    {
        startPage();
        List<EduClass> list = eduClassService.selectEduClassList(eduClass);
        return getDataTable(list);
    }

    /**
     * 导出班级列表
     */
    @PreAuthorize(hasPermi = "school:class:export")
    @Log(title = "班级", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EduClass eduClass) throws IOException
    {
        List<EduClass> list = eduClassService.selectEduClassList(eduClass);
        ExcelUtil<EduClass> util = new ExcelUtil<EduClass>(EduClass.class);
        util.exportExcel(response, list, "class");
    }

    /**
     * 获取班级详细信息
     */
    @PreAuthorize(hasPermi = "school:class:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(eduClassService.selectEduClassById(id));
    }

    /**
     * 新增班级
     */
    @PreAuthorize(hasPermi = "school:class:add")
    @Log(title = "班级", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EduClass eduClass)
    {
        return toAjax(eduClassService.insertEduClass(eduClass));
    }

    /**
     * 修改班级
     */
    @PreAuthorize(hasPermi = "school:class:edit")
    @Log(title = "班级", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EduClass eduClass)
    {
        return toAjax(eduClassService.updateEduClass(eduClass));
    }

    /**
     * 删除班级
     */
    @PreAuthorize(hasPermi = "school:class:remove")
    @Log(title = "班级", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(eduClassService.deleteEduClassByIds(ids));
    }
}
