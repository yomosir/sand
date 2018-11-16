package org.zheng.sand.comment.entity;

import java.util.Date;

public class Comment {
    private String cid;

    private String cusNickname;

    private String comContent;

    private String parent;

    private Date createTime;

    private String aid;

    private Integer comPraPoint;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCusNickname() {
        return cusNickname;
    }

    public void setCusNickname(String cusNickname) {
        this.cusNickname = cusNickname;
    }

    public String getComContent() {
        return comContent;
    }

    public void setComContent(String comContent) {
        this.comContent = comContent;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public Integer getComPraPoint() {
        return comPraPoint;
    }

    public void setComPraPoint(Integer comPraPoint) {
        this.comPraPoint = comPraPoint;
    }
}