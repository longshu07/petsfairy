package com.longshu.petsfairy.entity;

import java.math.BigDecimal;
import java.util.Date;

public class PetsInfo {
    private String petsInfoId;

    private String petsNameCn;

    private String petsNameEn;

    private String nickname;

    private String birthPlace;

    private BigDecimal lowestPrice;

    private BigDecimal hightPrice;

    private Double lowestWeight;

    private Double hightWeight;

    private String nature;

    private String interest;

    private String shape;

    private String hairLength;

    private String history;

    private String formCharacter;

    private String standard;

    private String lifeHabit;

    private String characterTraits;

    private String diet;

    private String tips;

    private String domesticateMethod;

    private String disease;

    private Date updateTime;

    private String petsPhotos;

    private String categoryId;

    private String udateAdmin;

    public String getPetsInfoId() {
        return petsInfoId;
    }

    public void setPetsInfoId(String petsInfoId) {
        this.petsInfoId = petsInfoId == null ? null : petsInfoId.trim();
    }

    public String getPetsNameCn() {
        return petsNameCn;
    }

    public void setPetsNameCn(String petsNameCn) {
        this.petsNameCn = petsNameCn == null ? null : petsNameCn.trim();
    }

    public String getPetsNameEn() {
        return petsNameEn;
    }

    public void setPetsNameEn(String petsNameEn) {
        this.petsNameEn = petsNameEn == null ? null : petsNameEn.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace == null ? null : birthPlace.trim();
    }

    public BigDecimal getLowestPrice() {
        return lowestPrice;
    }

    public void setLowestPrice(BigDecimal lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    public BigDecimal getHightPrice() {
        return hightPrice;
    }

    public void setHightPrice(BigDecimal hightPrice) {
        this.hightPrice = hightPrice;
    }

    public Double getLowestWeight() {
        return lowestWeight;
    }

    public void setLowestWeight(Double lowestWeight) {
        this.lowestWeight = lowestWeight;
    }

    public Double getHightWeight() {
        return hightWeight;
    }

    public void setHightWeight(Double hightWeight) {
        this.hightWeight = hightWeight;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature == null ? null : nature.trim();
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest == null ? null : interest.trim();
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape == null ? null : shape.trim();
    }

    public String getHairLength() {
        return hairLength;
    }

    public void setHairLength(String hairLength) {
        this.hairLength = hairLength == null ? null : hairLength.trim();
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history == null ? null : history.trim();
    }

    public String getFormCharacter() {
        return formCharacter;
    }

    public void setFormCharacter(String formCharacter) {
        this.formCharacter = formCharacter == null ? null : formCharacter.trim();
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard == null ? null : standard.trim();
    }

    public String getLifeHabit() {
        return lifeHabit;
    }

    public void setLifeHabit(String lifeHabit) {
        this.lifeHabit = lifeHabit == null ? null : lifeHabit.trim();
    }

    public String getCharacterTraits() {
        return characterTraits;
    }

    public void setCharacterTraits(String characterTraits) {
        this.characterTraits = characterTraits == null ? null : characterTraits.trim();
    }

    public String getDiet() {
        return diet;
    }

    public void setDiet(String diet) {
        this.diet = diet == null ? null : diet.trim();
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips == null ? null : tips.trim();
    }

    public String getDomesticateMethod() {
        return domesticateMethod;
    }

    public void setDomesticateMethod(String domesticateMethod) {
        this.domesticateMethod = domesticateMethod == null ? null : domesticateMethod.trim();
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease == null ? null : disease.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getPetsPhotos() {
        return petsPhotos;
    }

    public void setPetsPhotos(String petsPhotos) {
        this.petsPhotos = petsPhotos == null ? null : petsPhotos.trim();
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId == null ? null : categoryId.trim();
    }

    public String getUdateAdmin() {
        return udateAdmin;
    }

    public void setUdateAdmin(String udateAdmin) {
        this.udateAdmin = udateAdmin == null ? null : udateAdmin.trim();
    }
}