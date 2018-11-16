package org.zheng.sand.category.entity;

import java.util.Date;

public class Category {
    private String caid;

    private String caName;

    private String caDetail;

    private String parentId;

    private Date createTime;

    public String getCaid() {
        return caid;
    }

    public void setCaid(String caid) {
        this.caid = caid;
    }

    public String getCaName() {
        return caName;
    }

    public void setCaName(String caName) {
        this.caName = caName;
    }

    public String getCaDetail() {
        return caDetail;
    }

    public void setCaDetail(String caDetail) {
        this.caDetail = caDetail;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}