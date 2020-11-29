package com.longshu.petsfairy.entity;

public class PetCategory {
    private String categoryId;

    private String name;

    private String description;

    private String categoryPhotos;

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId == null ? null : categoryId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getCategoryPhotos() {
        return categoryPhotos;
    }

    public void setCategoryPhotos(String categoryPhotos) {
        this.categoryPhotos = categoryPhotos == null ? null : categoryPhotos.trim();
    }
}