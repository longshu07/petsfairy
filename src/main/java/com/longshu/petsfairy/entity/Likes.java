package com.longshu.petsfairy.entity;

import java.util.Date;

public class Likes extends LikesKey {
    private Integer isDelete;

    private Date createtime;

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "Likes{" +
                "isDelete=" + isDelete +
                ", createtime=" + createtime +
                '}';
    }
}