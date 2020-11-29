package com.longshu.petsfairy.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PersonPetExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PersonPetExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andPetIdIsNull() {
            addCriterion("pet_id is null");
            return (Criteria) this;
        }

        public Criteria andPetIdIsNotNull() {
            addCriterion("pet_id is not null");
            return (Criteria) this;
        }

        public Criteria andPetIdEqualTo(String value) {
            addCriterion("pet_id =", value, "petId");
            return (Criteria) this;
        }

        public Criteria andPetIdNotEqualTo(String value) {
            addCriterion("pet_id <>", value, "petId");
            return (Criteria) this;
        }

        public Criteria andPetIdGreaterThan(String value) {
            addCriterion("pet_id >", value, "petId");
            return (Criteria) this;
        }

        public Criteria andPetIdGreaterThanOrEqualTo(String value) {
            addCriterion("pet_id >=", value, "petId");
            return (Criteria) this;
        }

        public Criteria andPetIdLessThan(String value) {
            addCriterion("pet_id <", value, "petId");
            return (Criteria) this;
        }

        public Criteria andPetIdLessThanOrEqualTo(String value) {
            addCriterion("pet_id <=", value, "petId");
            return (Criteria) this;
        }

        public Criteria andPetIdLike(String value) {
            addCriterion("pet_id like", value, "petId");
            return (Criteria) this;
        }

        public Criteria andPetIdNotLike(String value) {
            addCriterion("pet_id not like", value, "petId");
            return (Criteria) this;
        }

        public Criteria andPetIdIn(List<String> values) {
            addCriterion("pet_id in", values, "petId");
            return (Criteria) this;
        }

        public Criteria andPetIdNotIn(List<String> values) {
            addCriterion("pet_id not in", values, "petId");
            return (Criteria) this;
        }

        public Criteria andPetIdBetween(String value1, String value2) {
            addCriterion("pet_id between", value1, value2, "petId");
            return (Criteria) this;
        }

        public Criteria andPetIdNotBetween(String value1, String value2) {
            addCriterion("pet_id not between", value1, value2, "petId");
            return (Criteria) this;
        }

        public Criteria andPetNameIsNull() {
            addCriterion("pet_name is null");
            return (Criteria) this;
        }

        public Criteria andPetNameIsNotNull() {
            addCriterion("pet_name is not null");
            return (Criteria) this;
        }

        public Criteria andPetNameEqualTo(String value) {
            addCriterion("pet_name =", value, "petName");
            return (Criteria) this;
        }

        public Criteria andPetNameNotEqualTo(String value) {
            addCriterion("pet_name <>", value, "petName");
            return (Criteria) this;
        }

        public Criteria andPetNameGreaterThan(String value) {
            addCriterion("pet_name >", value, "petName");
            return (Criteria) this;
        }

        public Criteria andPetNameGreaterThanOrEqualTo(String value) {
            addCriterion("pet_name >=", value, "petName");
            return (Criteria) this;
        }

        public Criteria andPetNameLessThan(String value) {
            addCriterion("pet_name <", value, "petName");
            return (Criteria) this;
        }

        public Criteria andPetNameLessThanOrEqualTo(String value) {
            addCriterion("pet_name <=", value, "petName");
            return (Criteria) this;
        }

        public Criteria andPetNameLike(String value) {
            addCriterion("pet_name like", value, "petName");
            return (Criteria) this;
        }

        public Criteria andPetNameNotLike(String value) {
            addCriterion("pet_name not like", value, "petName");
            return (Criteria) this;
        }

        public Criteria andPetNameIn(List<String> values) {
            addCriterion("pet_name in", values, "petName");
            return (Criteria) this;
        }

        public Criteria andPetNameNotIn(List<String> values) {
            addCriterion("pet_name not in", values, "petName");
            return (Criteria) this;
        }

        public Criteria andPetNameBetween(String value1, String value2) {
            addCriterion("pet_name between", value1, value2, "petName");
            return (Criteria) this;
        }

        public Criteria andPetNameNotBetween(String value1, String value2) {
            addCriterion("pet_name not between", value1, value2, "petName");
            return (Criteria) this;
        }

        public Criteria andPetPhotoIsNull() {
            addCriterion("pet_photo is null");
            return (Criteria) this;
        }

        public Criteria andPetPhotoIsNotNull() {
            addCriterion("pet_photo is not null");
            return (Criteria) this;
        }

        public Criteria andPetPhotoEqualTo(String value) {
            addCriterion("pet_photo =", value, "petPhoto");
            return (Criteria) this;
        }

        public Criteria andPetPhotoNotEqualTo(String value) {
            addCriterion("pet_photo <>", value, "petPhoto");
            return (Criteria) this;
        }

        public Criteria andPetPhotoGreaterThan(String value) {
            addCriterion("pet_photo >", value, "petPhoto");
            return (Criteria) this;
        }

        public Criteria andPetPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("pet_photo >=", value, "petPhoto");
            return (Criteria) this;
        }

        public Criteria andPetPhotoLessThan(String value) {
            addCriterion("pet_photo <", value, "petPhoto");
            return (Criteria) this;
        }

        public Criteria andPetPhotoLessThanOrEqualTo(String value) {
            addCriterion("pet_photo <=", value, "petPhoto");
            return (Criteria) this;
        }

        public Criteria andPetPhotoLike(String value) {
            addCriterion("pet_photo like", value, "petPhoto");
            return (Criteria) this;
        }

        public Criteria andPetPhotoNotLike(String value) {
            addCriterion("pet_photo not like", value, "petPhoto");
            return (Criteria) this;
        }

        public Criteria andPetPhotoIn(List<String> values) {
            addCriterion("pet_photo in", values, "petPhoto");
            return (Criteria) this;
        }

        public Criteria andPetPhotoNotIn(List<String> values) {
            addCriterion("pet_photo not in", values, "petPhoto");
            return (Criteria) this;
        }

        public Criteria andPetPhotoBetween(String value1, String value2) {
            addCriterion("pet_photo between", value1, value2, "petPhoto");
            return (Criteria) this;
        }

        public Criteria andPetPhotoNotBetween(String value1, String value2) {
            addCriterion("pet_photo not between", value1, value2, "petPhoto");
            return (Criteria) this;
        }

        public Criteria andPetGenderIsNull() {
            addCriterion("pet_gender is null");
            return (Criteria) this;
        }

        public Criteria andPetGenderIsNotNull() {
            addCriterion("pet_gender is not null");
            return (Criteria) this;
        }

        public Criteria andPetGenderEqualTo(Integer value) {
            addCriterion("pet_gender =", value, "petGender");
            return (Criteria) this;
        }

        public Criteria andPetGenderNotEqualTo(Integer value) {
            addCriterion("pet_gender <>", value, "petGender");
            return (Criteria) this;
        }

        public Criteria andPetGenderGreaterThan(Integer value) {
            addCriterion("pet_gender >", value, "petGender");
            return (Criteria) this;
        }

        public Criteria andPetGenderGreaterThanOrEqualTo(Integer value) {
            addCriterion("pet_gender >=", value, "petGender");
            return (Criteria) this;
        }

        public Criteria andPetGenderLessThan(Integer value) {
            addCriterion("pet_gender <", value, "petGender");
            return (Criteria) this;
        }

        public Criteria andPetGenderLessThanOrEqualTo(Integer value) {
            addCriterion("pet_gender <=", value, "petGender");
            return (Criteria) this;
        }

        public Criteria andPetGenderIn(List<Integer> values) {
            addCriterion("pet_gender in", values, "petGender");
            return (Criteria) this;
        }

        public Criteria andPetGenderNotIn(List<Integer> values) {
            addCriterion("pet_gender not in", values, "petGender");
            return (Criteria) this;
        }

        public Criteria andPetGenderBetween(Integer value1, Integer value2) {
            addCriterion("pet_gender between", value1, value2, "petGender");
            return (Criteria) this;
        }

        public Criteria andPetGenderNotBetween(Integer value1, Integer value2) {
            addCriterion("pet_gender not between", value1, value2, "petGender");
            return (Criteria) this;
        }

        public Criteria andPetVarietyIsNull() {
            addCriterion("pet_variety is null");
            return (Criteria) this;
        }

        public Criteria andPetVarietyIsNotNull() {
            addCriterion("pet_variety is not null");
            return (Criteria) this;
        }

        public Criteria andPetVarietyEqualTo(String value) {
            addCriterion("pet_variety =", value, "petVariety");
            return (Criteria) this;
        }

        public Criteria andPetVarietyNotEqualTo(String value) {
            addCriterion("pet_variety <>", value, "petVariety");
            return (Criteria) this;
        }

        public Criteria andPetVarietyGreaterThan(String value) {
            addCriterion("pet_variety >", value, "petVariety");
            return (Criteria) this;
        }

        public Criteria andPetVarietyGreaterThanOrEqualTo(String value) {
            addCriterion("pet_variety >=", value, "petVariety");
            return (Criteria) this;
        }

        public Criteria andPetVarietyLessThan(String value) {
            addCriterion("pet_variety <", value, "petVariety");
            return (Criteria) this;
        }

        public Criteria andPetVarietyLessThanOrEqualTo(String value) {
            addCriterion("pet_variety <=", value, "petVariety");
            return (Criteria) this;
        }

        public Criteria andPetVarietyLike(String value) {
            addCriterion("pet_variety like", value, "petVariety");
            return (Criteria) this;
        }

        public Criteria andPetVarietyNotLike(String value) {
            addCriterion("pet_variety not like", value, "petVariety");
            return (Criteria) this;
        }

        public Criteria andPetVarietyIn(List<String> values) {
            addCriterion("pet_variety in", values, "petVariety");
            return (Criteria) this;
        }

        public Criteria andPetVarietyNotIn(List<String> values) {
            addCriterion("pet_variety not in", values, "petVariety");
            return (Criteria) this;
        }

        public Criteria andPetVarietyBetween(String value1, String value2) {
            addCriterion("pet_variety between", value1, value2, "petVariety");
            return (Criteria) this;
        }

        public Criteria andPetVarietyNotBetween(String value1, String value2) {
            addCriterion("pet_variety not between", value1, value2, "petVariety");
            return (Criteria) this;
        }

        public Criteria andPetBirthdayIsNull() {
            addCriterion("pet_birthday is null");
            return (Criteria) this;
        }

        public Criteria andPetBirthdayIsNotNull() {
            addCriterion("pet_birthday is not null");
            return (Criteria) this;
        }

        public Criteria andPetBirthdayEqualTo(Date value) {
            addCriterion("pet_birthday =", value, "petBirthday");
            return (Criteria) this;
        }

        public Criteria andPetBirthdayNotEqualTo(Date value) {
            addCriterion("pet_birthday <>", value, "petBirthday");
            return (Criteria) this;
        }

        public Criteria andPetBirthdayGreaterThan(Date value) {
            addCriterion("pet_birthday >", value, "petBirthday");
            return (Criteria) this;
        }

        public Criteria andPetBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterion("pet_birthday >=", value, "petBirthday");
            return (Criteria) this;
        }

        public Criteria andPetBirthdayLessThan(Date value) {
            addCriterion("pet_birthday <", value, "petBirthday");
            return (Criteria) this;
        }

        public Criteria andPetBirthdayLessThanOrEqualTo(Date value) {
            addCriterion("pet_birthday <=", value, "petBirthday");
            return (Criteria) this;
        }

        public Criteria andPetBirthdayIn(List<Date> values) {
            addCriterion("pet_birthday in", values, "petBirthday");
            return (Criteria) this;
        }

        public Criteria andPetBirthdayNotIn(List<Date> values) {
            addCriterion("pet_birthday not in", values, "petBirthday");
            return (Criteria) this;
        }

        public Criteria andPetBirthdayBetween(Date value1, Date value2) {
            addCriterion("pet_birthday between", value1, value2, "petBirthday");
            return (Criteria) this;
        }

        public Criteria andPetBirthdayNotBetween(Date value1, Date value2) {
            addCriterion("pet_birthday not between", value1, value2, "petBirthday");
            return (Criteria) this;
        }

        public Criteria andPetComeDatetimeIsNull() {
            addCriterion("pet_come_datetime is null");
            return (Criteria) this;
        }

        public Criteria andPetComeDatetimeIsNotNull() {
            addCriterion("pet_come_datetime is not null");
            return (Criteria) this;
        }

        public Criteria andPetComeDatetimeEqualTo(Date value) {
            addCriterion("pet_come_datetime =", value, "petComeDatetime");
            return (Criteria) this;
        }

        public Criteria andPetComeDatetimeNotEqualTo(Date value) {
            addCriterion("pet_come_datetime <>", value, "petComeDatetime");
            return (Criteria) this;
        }

        public Criteria andPetComeDatetimeGreaterThan(Date value) {
            addCriterion("pet_come_datetime >", value, "petComeDatetime");
            return (Criteria) this;
        }

        public Criteria andPetComeDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pet_come_datetime >=", value, "petComeDatetime");
            return (Criteria) this;
        }

        public Criteria andPetComeDatetimeLessThan(Date value) {
            addCriterion("pet_come_datetime <", value, "petComeDatetime");
            return (Criteria) this;
        }

        public Criteria andPetComeDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("pet_come_datetime <=", value, "petComeDatetime");
            return (Criteria) this;
        }

        public Criteria andPetComeDatetimeIn(List<Date> values) {
            addCriterion("pet_come_datetime in", values, "petComeDatetime");
            return (Criteria) this;
        }

        public Criteria andPetComeDatetimeNotIn(List<Date> values) {
            addCriterion("pet_come_datetime not in", values, "petComeDatetime");
            return (Criteria) this;
        }

        public Criteria andPetComeDatetimeBetween(Date value1, Date value2) {
            addCriterion("pet_come_datetime between", value1, value2, "petComeDatetime");
            return (Criteria) this;
        }

        public Criteria andPetComeDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("pet_come_datetime not between", value1, value2, "petComeDatetime");
            return (Criteria) this;
        }

        public Criteria andPetSterilizationIsNull() {
            addCriterion("pet_sterilization is null");
            return (Criteria) this;
        }

        public Criteria andPetSterilizationIsNotNull() {
            addCriterion("pet_sterilization is not null");
            return (Criteria) this;
        }

        public Criteria andPetSterilizationEqualTo(Integer value) {
            addCriterion("pet_sterilization =", value, "petSterilization");
            return (Criteria) this;
        }

        public Criteria andPetSterilizationNotEqualTo(Integer value) {
            addCriterion("pet_sterilization <>", value, "petSterilization");
            return (Criteria) this;
        }

        public Criteria andPetSterilizationGreaterThan(Integer value) {
            addCriterion("pet_sterilization >", value, "petSterilization");
            return (Criteria) this;
        }

        public Criteria andPetSterilizationGreaterThanOrEqualTo(Integer value) {
            addCriterion("pet_sterilization >=", value, "petSterilization");
            return (Criteria) this;
        }

        public Criteria andPetSterilizationLessThan(Integer value) {
            addCriterion("pet_sterilization <", value, "petSterilization");
            return (Criteria) this;
        }

        public Criteria andPetSterilizationLessThanOrEqualTo(Integer value) {
            addCriterion("pet_sterilization <=", value, "petSterilization");
            return (Criteria) this;
        }

        public Criteria andPetSterilizationIn(List<Integer> values) {
            addCriterion("pet_sterilization in", values, "petSterilization");
            return (Criteria) this;
        }

        public Criteria andPetSterilizationNotIn(List<Integer> values) {
            addCriterion("pet_sterilization not in", values, "petSterilization");
            return (Criteria) this;
        }

        public Criteria andPetSterilizationBetween(Integer value1, Integer value2) {
            addCriterion("pet_sterilization between", value1, value2, "petSterilization");
            return (Criteria) this;
        }

        public Criteria andPetSterilizationNotBetween(Integer value1, Integer value2) {
            addCriterion("pet_sterilization not between", value1, value2, "petSterilization");
            return (Criteria) this;
        }

        public Criteria andPetMasterIdIsNull() {
            addCriterion("pet_master_id is null");
            return (Criteria) this;
        }

        public Criteria andPetMasterIdIsNotNull() {
            addCriterion("pet_master_id is not null");
            return (Criteria) this;
        }

        public Criteria andPetMasterIdEqualTo(String value) {
            addCriterion("pet_master_id =", value, "petMasterId");
            return (Criteria) this;
        }

        public Criteria andPetMasterIdNotEqualTo(String value) {
            addCriterion("pet_master_id <>", value, "petMasterId");
            return (Criteria) this;
        }

        public Criteria andPetMasterIdGreaterThan(String value) {
            addCriterion("pet_master_id >", value, "petMasterId");
            return (Criteria) this;
        }

        public Criteria andPetMasterIdGreaterThanOrEqualTo(String value) {
            addCriterion("pet_master_id >=", value, "petMasterId");
            return (Criteria) this;
        }

        public Criteria andPetMasterIdLessThan(String value) {
            addCriterion("pet_master_id <", value, "petMasterId");
            return (Criteria) this;
        }

        public Criteria andPetMasterIdLessThanOrEqualTo(String value) {
            addCriterion("pet_master_id <=", value, "petMasterId");
            return (Criteria) this;
        }

        public Criteria andPetMasterIdLike(String value) {
            addCriterion("pet_master_id like", value, "petMasterId");
            return (Criteria) this;
        }

        public Criteria andPetMasterIdNotLike(String value) {
            addCriterion("pet_master_id not like", value, "petMasterId");
            return (Criteria) this;
        }

        public Criteria andPetMasterIdIn(List<String> values) {
            addCriterion("pet_master_id in", values, "petMasterId");
            return (Criteria) this;
        }

        public Criteria andPetMasterIdNotIn(List<String> values) {
            addCriterion("pet_master_id not in", values, "petMasterId");
            return (Criteria) this;
        }

        public Criteria andPetMasterIdBetween(String value1, String value2) {
            addCriterion("pet_master_id between", value1, value2, "petMasterId");
            return (Criteria) this;
        }

        public Criteria andPetMasterIdNotBetween(String value1, String value2) {
            addCriterion("pet_master_id not between", value1, value2, "petMasterId");
            return (Criteria) this;
        }

        public Criteria andPetWeightIsNull() {
            addCriterion("pet_weight is null");
            return (Criteria) this;
        }

        public Criteria andPetWeightIsNotNull() {
            addCriterion("pet_weight is not null");
            return (Criteria) this;
        }

        public Criteria andPetWeightEqualTo(Double value) {
            addCriterion("pet_weight =", value, "petWeight");
            return (Criteria) this;
        }

        public Criteria andPetWeightNotEqualTo(Double value) {
            addCriterion("pet_weight <>", value, "petWeight");
            return (Criteria) this;
        }

        public Criteria andPetWeightGreaterThan(Double value) {
            addCriterion("pet_weight >", value, "petWeight");
            return (Criteria) this;
        }

        public Criteria andPetWeightGreaterThanOrEqualTo(Double value) {
            addCriterion("pet_weight >=", value, "petWeight");
            return (Criteria) this;
        }

        public Criteria andPetWeightLessThan(Double value) {
            addCriterion("pet_weight <", value, "petWeight");
            return (Criteria) this;
        }

        public Criteria andPetWeightLessThanOrEqualTo(Double value) {
            addCriterion("pet_weight <=", value, "petWeight");
            return (Criteria) this;
        }

        public Criteria andPetWeightIn(List<Double> values) {
            addCriterion("pet_weight in", values, "petWeight");
            return (Criteria) this;
        }

        public Criteria andPetWeightNotIn(List<Double> values) {
            addCriterion("pet_weight not in", values, "petWeight");
            return (Criteria) this;
        }

        public Criteria andPetWeightBetween(Double value1, Double value2) {
            addCriterion("pet_weight between", value1, value2, "petWeight");
            return (Criteria) this;
        }

        public Criteria andPetWeightNotBetween(Double value1, Double value2) {
            addCriterion("pet_weight not between", value1, value2, "petWeight");
            return (Criteria) this;
        }

        public Criteria andPetComePetsfairyIsNull() {
            addCriterion("pet_come_petsfairy is null");
            return (Criteria) this;
        }

        public Criteria andPetComePetsfairyIsNotNull() {
            addCriterion("pet_come_petsfairy is not null");
            return (Criteria) this;
        }

        public Criteria andPetComePetsfairyEqualTo(Date value) {
            addCriterion("pet_come_petsfairy =", value, "petComePetsfairy");
            return (Criteria) this;
        }

        public Criteria andPetComePetsfairyNotEqualTo(Date value) {
            addCriterion("pet_come_petsfairy <>", value, "petComePetsfairy");
            return (Criteria) this;
        }

        public Criteria andPetComePetsfairyGreaterThan(Date value) {
            addCriterion("pet_come_petsfairy >", value, "petComePetsfairy");
            return (Criteria) this;
        }

        public Criteria andPetComePetsfairyGreaterThanOrEqualTo(Date value) {
            addCriterion("pet_come_petsfairy >=", value, "petComePetsfairy");
            return (Criteria) this;
        }

        public Criteria andPetComePetsfairyLessThan(Date value) {
            addCriterion("pet_come_petsfairy <", value, "petComePetsfairy");
            return (Criteria) this;
        }

        public Criteria andPetComePetsfairyLessThanOrEqualTo(Date value) {
            addCriterion("pet_come_petsfairy <=", value, "petComePetsfairy");
            return (Criteria) this;
        }

        public Criteria andPetComePetsfairyIn(List<Date> values) {
            addCriterion("pet_come_petsfairy in", values, "petComePetsfairy");
            return (Criteria) this;
        }

        public Criteria andPetComePetsfairyNotIn(List<Date> values) {
            addCriterion("pet_come_petsfairy not in", values, "petComePetsfairy");
            return (Criteria) this;
        }

        public Criteria andPetComePetsfairyBetween(Date value1, Date value2) {
            addCriterion("pet_come_petsfairy between", value1, value2, "petComePetsfairy");
            return (Criteria) this;
        }

        public Criteria andPetComePetsfairyNotBetween(Date value1, Date value2) {
            addCriterion("pet_come_petsfairy not between", value1, value2, "petComePetsfairy");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}