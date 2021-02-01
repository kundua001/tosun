package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

import java.util.List;

/**
 * 学校对象 edu_school
 * 
 * @author ruoyi
 * @date 2021-01-24
 */
public class EduSchool extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    private Long userId;

    private List<Long> ids;
    /** 学校名称 */
    @Excel(name = "学校名称")
    private String name;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 地址 */
    @Excel(name = "地址")
    private String address;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String mobile;

    /** 联系人 */
    @Excel(name = "联系人")
    private String contact;

    /** logo图片的url */
    @Excel(name = "logo图片的url")
    private String logoUrl;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;

    /** 学校类型
0：幼儿园
1：小学
2：托管机构
3：培训机构 */
    @Excel(name = "学校类型")
    private Long type;

    /** 班级数量 */
    @Excel(name = "班级数量")
    private Long classNum;

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
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setType(Long type) 
    {
        this.type = type;
    }

    public Long getType() 
    {
        return type;
    }
    public void setClassNum(Long classNum) 
    {
        this.classNum = classNum;
    }

    public Long getClassNum() 
    {
        return classNum;
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
            .append("email", getEmail())
            .append("type", getType())
            .append("classNum", getClassNum())
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
