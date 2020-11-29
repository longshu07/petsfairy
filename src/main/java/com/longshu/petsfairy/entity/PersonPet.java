package com.longshu.petsfairy.entity;

import java.util.Date;

public class PersonPet {
    private String petId;

    private String petName;

    private String petPhoto;

    private Integer petGender;

    private String petVariety;

    private Date petBirthday;

    private Date petComeDatetime;

    private Integer petSterilization;

    private String petMasterId;

    private Double petWeight;

    private Date petComePetsfairy;

    public String getPetId() {
        return petId;
    }

    public void setPetId(String petId) {
        this.petId = petId == null ? null : petId.trim();
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName == null ? null : petName.trim();
    }

    public String getPetPhoto() {
        return petPhoto;
    }

    public void setPetPhoto(String petPhoto) {
        this.petPhoto = petPhoto == null ? null : petPhoto.trim();
    }

    public Integer getPetGender() {
        return petGender;
    }

    public void setPetGender(Integer petGender) {
        this.petGender = petGender;
    }

    public String getPetVariety() {
        return petVariety;
    }

    public void setPetVariety(String petVariety) {
        this.petVariety = petVariety == null ? null : petVariety.trim();
    }

    public Date getPetBirthday() {
        return petBirthday;
    }

    public void setPetBirthday(Date petBirthday) {
        this.petBirthday = petBirthday;
    }

    public Date getPetComeDatetime() {
        return petComeDatetime;
    }

    public void setPetComeDatetime(Date petComeDatetime) {
        this.petComeDatetime = petComeDatetime;
    }

    public Integer getPetSterilization() {
        return petSterilization;
    }

    public void setPetSterilization(Integer petSterilization) {
        this.petSterilization = petSterilization;
    }

    public String getPetMasterId() {
        return petMasterId;
    }

    public void setPetMasterId(String petMasterId) {
        this.petMasterId = petMasterId == null ? null : petMasterId.trim();
    }

    public Double getPetWeight() {
        return petWeight;
    }

    public void setPetWeight(Double petWeight) {
        this.petWeight = petWeight;
    }

    public Date getPetComePetsfairy() {
        return petComePetsfairy;
    }

    public void setPetComePetsfairy(Date petComePetsfairy) {
        this.petComePetsfairy = petComePetsfairy;
    }
}