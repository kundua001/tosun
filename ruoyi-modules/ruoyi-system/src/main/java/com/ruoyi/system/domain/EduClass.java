package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

import java.util.List;

/**
 * 班级对象 edu_class
 * 
 * @author huangcankun
 * @date 2021-01-24
 */
public class EduClass extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    private Long userId;

    private List<Long> ids;
    /**
     * 所属学校id
     *
     */
    private Long schoolId;

    private String schoolIdLabel;
    /** 班级名称 */
    @Excel(name = "班级名称")
    private String name;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 地址 */
    @Excel(name = "地址")
    private String address;

    /** 班主任联系电话 */
    @Excel(name = "班主任联系电话")
    private String mobile;

    /** 班主任 */
    @Excel(name = "班主任")
    private String contact;

    /** logo图片的url */
    @Excel(name = "logo图片的url")
    private String logoUrl;

    /** 学生数量 */
    @Excel(name = "学生数量")
    private Long studentNum;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public List<Long> getIds() {
        return ids;
    }
    public void setIds(List<Long> ids) {
        this.ids = ids;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setMobile(String mobile) 
    {
        this.mobile = mobile;
    }

    public String getMobile() 
    {
        return mobile;
    }
    public void setContact(String contact) 
    {
        this.contact = contact;
    }

    public String getContact() 
    {
        return contact;
    }
    public void setLogoUrl(String logoUrl) 
    {
        this.logoUrl = logoUrl;
    }

    public String getLogoUrl() 
    {
        return logoUrl;
    }
    public void setStudentNum(Long studentNum) 
    {
        this.studentNum = studentNum;
    }

    public Long getStudentNum() 
    {
        return studentNum;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }
    public Long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }
    public String getSchoolIdLabel() {
        return schoolIdLabel;
    }

    public void setSchoolIdLabel(String schoolIdLabel) {
        this.schoolIdLabel = schoolIdLabel;
    }
    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("status", getStatus())
            .append("address", getAddress())
            .append("mobile", getMobile())
            .append("contact", getContact())
            .append("logoUrl", getLogoUrl())
            .append("studentNum", getStudentNum())
            .append("remark", getRemark())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
