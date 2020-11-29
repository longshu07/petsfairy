package com.longshu.petsfairy.entity;

import java.util.Date;

public class Invitation {
    private String invitationId;

    private String invitationContent;

    private String invitationPhoto;

    private Date createTime;

    private String invitationMasterId;

    private Integer deleteFlag;

    private String personPetsId;

//   一对多，增加一个用户对象
    private Customer customer;

    public String getInvitationId() {
        return invitationId;
    }

    public void setInvitationId(String invitationId) {
        this.invitationId = invitationId == null ? null : invitationId.trim();
    }

    public String getInvitationContent() {
        return invitationContent;
    }

    public void setInvitationContent(String invitationContent) {
        this.invitationContent = invitationContent == null ? null : invitationContent.trim();
    }

    public String getInvitationPhoto() {
        return invitationPhoto;
    }

    public void setInvitationPhoto(String invitationPhoto) {
        this.invitationPhoto = invitationPhoto == null ? null : invitationPhoto.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getInvitationMasterId() {
        return invitationMasterId;
    }

    public void setInvitationMasterId(String invitationMasterId) {
        this.invitationMasterId = invitationMasterId == null ? null : invitationMasterId.trim();
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getPersonPetsId() {
        return personPetsId;
    }

    public void setPersonPetsId(String personPetsId) {
        this.personPetsId = personPetsId == null ? null : personPetsId.trim();
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Invitation{" +
                "invitationId='" + invitationId + '\'' +
                ", invitationContent='" + invitationContent + '\'' +
                ", invitationPhoto='" + invitationPhoto + '\'' +
                ", createTime=" + createTime +
                ", invitationMasterId='" + invitationMasterId + '\'' +
                ", deleteFlag=" + deleteFlag +
                ", personPetsId='" + personPetsId + '\'' +
                ", customer=" + customer +
                '}';
    }
}