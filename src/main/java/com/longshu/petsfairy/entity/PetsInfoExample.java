package com.longshu.petsfairy.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PetsInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PetsInfoExample() {
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

        public Criteria andPetsInfoIdIsNull() {
            addCriterion("pets_info_id is null");
            return (Criteria) this;
        }

        public Criteria andPetsInfoIdIsNotNull() {
            addCriterion("pets_info_id is not null");
            return (Criteria) this;
        }

        public Criteria andPetsInfoIdEqualTo(String value) {
            addCriterion("pets_info_id =", value, "petsInfoId");
            return (Criteria) this;
        }

        public Criteria andPetsInfoIdNotEqualTo(String value) {
            addCriterion("pets_info_id <>", value, "petsInfoId");
            return (Criteria) this;
        }

        public Criteria andPetsInfoIdGreaterThan(String value) {
            addCriterion("pets_info_id >", value, "petsInfoId");
            return (Criteria) this;
        }

        public Criteria andPetsInfoIdGreaterThanOrEqualTo(String value) {
            addCriterion("pets_info_id >=", value, "petsInfoId");
            return (Criteria) this;
        }

        public Criteria andPetsInfoIdLessThan(String value) {
            addCriterion("pets_info_id <", value, "petsInfoId");
            return (Criteria) this;
        }

        public Criteria andPetsInfoIdLessThanOrEqualTo(String value) {
            addCriterion("pets_info_id <=", value, "petsInfoId");
            return (Criteria) this;
        }

        public Criteria andPetsInfoIdLike(String value) {
            addCriterion("pets_info_id like", value, "petsInfoId");
            return (Criteria) this;
        }

        public Criteria andPetsInfoIdNotLike(String value) {
            addCriterion("pets_info_id not like", value, "petsInfoId");
            return (Criteria) this;
        }

        public Criteria andPetsInfoIdIn(List<String> values) {
            addCriterion("pets_info_id in", values, "petsInfoId");
            return (Criteria) this;
        }

        public Criteria andPetsInfoIdNotIn(List<String> values) {
            addCriterion("pets_info_id not in", values, "petsInfoId");
            return (Criteria) this;
        }

        public Criteria andPetsInfoIdBetween(String value1, String value2) {
            addCriterion("pets_info_id between", value1, value2, "petsInfoId");
            return (Criteria) this;
        }

        public Criteria andPetsInfoIdNotBetween(String value1, String value2) {
            addCriterion("pets_info_id not between", value1, value2, "petsInfoId");
            return (Criteria) this;
        }

        public Criteria andPetsNameCnIsNull() {
            addCriterion("pets_name_cn is null");
            return (Criteria) this;
        }

        public Criteria andPetsNameCnIsNotNull() {
            addCriterion("pets_name_cn is not null");
            return (Criteria) this;
        }

        public Criteria andPetsNameCnEqualTo(String value) {
            addCriterion("pets_name_cn =", value, "petsNameCn");
            return (Criteria) this;
        }

        public Criteria andPetsNameCnNotEqualTo(String value) {
            addCriterion("pets_name_cn <>", value, "petsNameCn");
            return (Criteria) this;
        }

        public Criteria andPetsNameCnGreaterThan(String value) {
            addCriterion("pets_name_cn >", value, "petsNameCn");
            return (Criteria) this;
        }

        public Criteria andPetsNameCnGreaterThanOrEqualTo(String value) {
            addCriterion("pets_name_cn >=", value, "petsNameCn");
            return (Criteria) this;
        }

        public Criteria andPetsNameCnLessThan(String value) {
            addCriterion("pets_name_cn <", value, "petsNameCn");
            return (Criteria) this;
        }

        public Criteria andPetsNameCnLessThanOrEqualTo(String value) {
            addCriterion("pets_name_cn <=", value, "petsNameCn");
            return (Criteria) this;
        }

        public Criteria andPetsNameCnLike(String value) {
            addCriterion("pets_name_cn like", value, "petsNameCn");
            return (Criteria) this;
        }

        public Criteria andPetsNameCnNotLike(String value) {
            addCriterion("pets_name_cn not like", value, "petsNameCn");
            return (Criteria) this;
        }

        public Criteria andPetsNameCnIn(List<String> values) {
            addCriterion("pets_name_cn in", values, "petsNameCn");
            return (Criteria) this;
        }

        public Criteria andPetsNameCnNotIn(List<String> values) {
            addCriterion("pets_name_cn not in", values, "petsNameCn");
            return (Criteria) this;
        }

        public Criteria andPetsNameCnBetween(String value1, String value2) {
            addCriterion("pets_name_cn between", value1, value2, "petsNameCn");
            return (Criteria) this;
        }

        public Criteria andPetsNameCnNotBetween(String value1, String value2) {
            addCriterion("pets_name_cn not between", value1, value2, "petsNameCn");
            return (Criteria) this;
        }

        public Criteria andPetsNameEnIsNull() {
            addCriterion("pets_name_en is null");
            return (Criteria) this;
        }

        public Criteria andPetsNameEnIsNotNull() {
            addCriterion("pets_name_en is not null");
            return (Criteria) this;
        }

        public Criteria andPetsNameEnEqualTo(String value) {
            addCriterion("pets_name_en =", value, "petsNameEn");
            return (Criteria) this;
        }

        public Criteria andPetsNameEnNotEqualTo(String value) {
            addCriterion("pets_name_en <>", value, "petsNameEn");
            return (Criteria) this;
        }

        public Criteria andPetsNameEnGreaterThan(String value) {
            addCriterion("pets_name_en >", value, "petsNameEn");
            return (Criteria) this;
        }

        public Criteria andPetsNameEnGreaterThanOrEqualTo(String value) {
            addCriterion("pets_name_en >=", value, "petsNameEn");
            return (Criteria) this;
        }

        public Criteria andPetsNameEnLessThan(String value) {
            addCriterion("pets_name_en <", value, "petsNameEn");
            return (Criteria) this;
        }

        public Criteria andPetsNameEnLessThanOrEqualTo(String value) {
            addCriterion("pets_name_en <=", value, "petsNameEn");
            return (Criteria) this;
        }

        public Criteria andPetsNameEnLike(String value) {
            addCriterion("pets_name_en like", value, "petsNameEn");
            return (Criteria) this;
        }

        public Criteria andPetsNameEnNotLike(String value) {
            addCriterion("pets_name_en not like", value, "petsNameEn");
            return (Criteria) this;
        }

        public Criteria andPetsNameEnIn(List<String> values) {
            addCriterion("pets_name_en in", values, "petsNameEn");
            return (Criteria) this;
        }

        public Criteria andPetsNameEnNotIn(List<String> values) {
            addCriterion("pets_name_en not in", values, "petsNameEn");
            return (Criteria) this;
        }

        public Criteria andPetsNameEnBetween(String value1, String value2) {
            addCriterion("pets_name_en between", value1, value2, "petsNameEn");
            return (Criteria) this;
        }

        public Criteria andPetsNameEnNotBetween(String value1, String value2) {
            addCriterion("pets_name_en not between", value1, value2, "petsNameEn");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNull() {
            addCriterion("nickname is null");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNotNull() {
            addCriterion("nickname is not null");
            return (Criteria) this;
        }

        public Criteria andNicknameEqualTo(String value) {
            addCriterion("nickname =", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotEqualTo(String value) {
            addCriterion("nickname <>", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThan(String value) {
            addCriterion("nickname >", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("nickname >=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThan(String value) {
            addCriterion("nickname <", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThanOrEqualTo(String value) {
            addCriterion("nickname <=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLike(String value) {
            addCriterion("nickname like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotLike(String value) {
            addCriterion("nickname not like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameIn(List<String> values) {
            addCriterion("nickname in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotIn(List<String> values) {
            addCriterion("nickname not in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameBetween(String value1, String value2) {
            addCriterion("nickname between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotBetween(String value1, String value2) {
            addCriterion("nickname not between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceIsNull() {
            addCriterion("birth_place is null");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceIsNotNull() {
            addCriterion("birth_place is not null");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceEqualTo(String value) {
            addCriterion("birth_place =", value, "birthPlace");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceNotEqualTo(String value) {
            addCriterion("birth_place <>", value, "birthPlace");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceGreaterThan(String value) {
            addCriterion("birth_place >", value, "birthPlace");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("birth_place >=", value, "birthPlace");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceLessThan(String value) {
            addCriterion("birth_place <", value, "birthPlace");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceLessThanOrEqualTo(String value) {
            addCriterion("birth_place <=", value, "birthPlace");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceLike(String value) {
            addCriterion("birth_place like", value, "birthPlace");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceNotLike(String value) {
            addCriterion("birth_place not like", value, "birthPlace");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceIn(List<String> values) {
            addCriterion("birth_place in", values, "birthPlace");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceNotIn(List<String> values) {
            addCriterion("birth_place not in", values, "birthPlace");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceBetween(String value1, String value2) {
            addCriterion("birth_place between", value1, value2, "birthPlace");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceNotBetween(String value1, String value2) {
            addCriterion("birth_place not between", value1, value2, "birthPlace");
            return (Criteria) this;
        }

        public Criteria andLowestPriceIsNull() {
            addCriterion("lowest_price is null");
            return (Criteria) this;
        }

        public Criteria andLowestPriceIsNotNull() {
            addCriterion("lowest_price is not null");
            return (Criteria) this;
        }

        public Criteria andLowestPriceEqualTo(BigDecimal value) {
            addCriterion("lowest_price =", value, "lowestPrice");
            return (Criteria) this;
        }

        public Criteria andLowestPriceNotEqualTo(BigDecimal value) {
            addCriterion("lowest_price <>", value, "lowestPrice");
            return (Criteria) this;
        }

        public Criteria andLowestPriceGreaterThan(BigDecimal value) {
            addCriterion("lowest_price >", value, "lowestPrice");
            return (Criteria) this;
        }

        public Criteria andLowestPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("lowest_price >=", value, "lowestPrice");
            return (Criteria) this;
        }

        public Criteria andLowestPriceLessThan(BigDecimal value) {
            addCriterion("lowest_price <", value, "lowestPrice");
            return (Criteria) this;
        }

        public Criteria andLowestPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("lowest_price <=", value, "lowestPrice");
            return (Criteria) this;
        }

        public Criteria andLowestPriceIn(List<BigDecimal> values) {
            addCriterion("lowest_price in", values, "lowestPrice");
            return (Criteria) this;
        }

        public Criteria andLowestPriceNotIn(List<BigDecimal> values) {
            addCriterion("lowest_price not in", values, "lowestPrice");
            return (Criteria) this;
        }

        public Criteria andLowestPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("lowest_price between", value1, value2, "lowestPrice");
            return (Criteria) this;
        }

        public Criteria andLowestPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("lowest_price not between", value1, value2, "lowestPrice");
            return (Criteria) this;
        }

        public Criteria andHightPriceIsNull() {
            addCriterion("hight_price is null");
            return (Criteria) this;
        }

        public Criteria andHightPriceIsNotNull() {
            addCriterion("hight_price is not null");
            return (Criteria) this;
        }

        public Criteria andHightPriceEqualTo(BigDecimal value) {
            addCriterion("hight_price =", value, "hightPrice");
            return (Criteria) this;
        }

        public Criteria andHightPriceNotEqualTo(BigDecimal value) {
            addCriterion("hight_price <>", value, "hightPrice");
            return (Criteria) this;
        }

        public Criteria andHightPriceGreaterThan(BigDecimal value) {
            addCriterion("hight_price >", value, "hightPrice");
            return (Criteria) this;
        }

        public Criteria andHightPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hight_price >=", value, "hightPrice");
            return (Criteria) this;
        }

        public Criteria andHightPriceLessThan(BigDecimal value) {
            addCriterion("hight_price <", value, "hightPrice");
            return (Criteria) this;
        }

        public Criteria andHightPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hight_price <=", value, "hightPrice");
            return (Criteria) this;
        }

        public Criteria andHightPriceIn(List<BigDecimal> values) {
            addCriterion("hight_price in", values, "hightPrice");
            return (Criteria) this;
        }

        public Criteria andHightPriceNotIn(List<BigDecimal> values) {
            addCriterion("hight_price not in", values, "hightPrice");
            return (Criteria) this;
        }

        public Criteria andHightPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hight_price between", value1, value2, "hightPrice");
            return (Criteria) this;
        }

        public Criteria andHightPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hight_price not between", value1, value2, "hightPrice");
            return (Criteria) this;
        }

        public Criteria andLowestWeightIsNull() {
            addCriterion("lowest_weight is null");
            return (Criteria) this;
        }

        public Criteria andLowestWeightIsNotNull() {
            addCriterion("lowest_weight is not null");
            return (Criteria) this;
        }

        public Criteria andLowestWeightEqualTo(Double value) {
            addCriterion("lowest_weight =", value, "lowestWeight");
            return (Criteria) this;
        }

        public Criteria andLowestWeightNotEqualTo(Double value) {
            addCriterion("lowest_weight <>", value, "lowestWeight");
            return (Criteria) this;
        }

        public Criteria andLowestWeightGreaterThan(Double value) {
            addCriterion("lowest_weight >", value, "lowestWeight");
            return (Criteria) this;
        }

        public Criteria andLowestWeightGreaterThanOrEqualTo(Double value) {
            addCriterion("lowest_weight >=", value, "lowestWeight");
            return (Criteria) this;
        }

        public Criteria andLowestWeightLessThan(Double value) {
            addCriterion("lowest_weight <", value, "lowestWeight");
            return (Criteria) this;
        }

        public Criteria andLowestWeightLessThanOrEqualTo(Double value) {
            addCriterion("lowest_weight <=", value, "lowestWeight");
            return (Criteria) this;
        }

        public Criteria andLowestWeightIn(List<Double> values) {
            addCriterion("lowest_weight in", values, "lowestWeight");
            return (Criteria) this;
        }

        public Criteria andLowestWeightNotIn(List<Double> values) {
            addCriterion("lowest_weight not in", values, "lowestWeight");
            return (Criteria) this;
        }

        public Criteria andLowestWeightBetween(Double value1, Double value2) {
            addCriterion("lowest_weight between", value1, value2, "lowestWeight");
            return (Criteria) this;
        }

        public Criteria andLowestWeightNotBetween(Double value1, Double value2) {
            addCriterion("lowest_weight not between", value1, value2, "lowestWeight");
            return (Criteria) this;
        }

        public Criteria andHightWeightIsNull() {
            addCriterion("hight_weight is null");
            return (Criteria) this;
        }

        public Criteria andHightWeightIsNotNull() {
            addCriterion("hight_weight is not null");
            return (Criteria) this;
        }

        public Criteria andHightWeightEqualTo(Double value) {
            addCriterion("hight_weight =", value, "hightWeight");
            return (Criteria) this;
        }

        public Criteria andHightWeightNotEqualTo(Double value) {
            addCriterion("hight_weight <>", value, "hightWeight");
            return (Criteria) this;
        }

        public Criteria andHightWeightGreaterThan(Double value) {
            addCriterion("hight_weight >", value, "hightWeight");
            return (Criteria) this;
        }

        public Criteria andHightWeightGreaterThanOrEqualTo(Double value) {
            addCriterion("hight_weight >=", value, "hightWeight");
            return (Criteria) this;
        }

        public Criteria andHightWeightLessThan(Double value) {
            addCriterion("hight_weight <", value, "hightWeight");
            return (Criteria) this;
        }

        public Criteria andHightWeightLessThanOrEqualTo(Double value) {
            addCriterion("hight_weight <=", value, "hightWeight");
            return (Criteria) this;
        }

        public Criteria andHightWeightIn(List<Double> values) {
            addCriterion("hight_weight in", values, "hightWeight");
            return (Criteria) this;
        }

        public Criteria andHightWeightNotIn(List<Double> values) {
            addCriterion("hight_weight not in", values, "hightWeight");
            return (Criteria) this;
        }

        public Criteria andHightWeightBetween(Double value1, Double value2) {
            addCriterion("hight_weight between", value1, value2, "hightWeight");
            return (Criteria) this;
        }

        public Criteria andHightWeightNotBetween(Double value1, Double value2) {
            addCriterion("hight_weight not between", value1, value2, "hightWeight");
            return (Criteria) this;
        }

        public Criteria andNatureIsNull() {
            addCriterion("nature is null");
            return (Criteria) this;
        }

        public Criteria andNatureIsNotNull() {
            addCriterion("nature is not null");
            return (Criteria) this;
        }

        public Criteria andNatureEqualTo(String value) {
            addCriterion("nature =", value, "nature");
            return (Criteria) this;
        }

        public Criteria andNatureNotEqualTo(String value) {
            addCriterion("nature <>", value, "nature");
            return (Criteria) this;
        }

        public Criteria andNatureGreaterThan(String value) {
            addCriterion("nature >", value, "nature");
            return (Criteria) this;
        }

        public Criteria andNatureGreaterThanOrEqualTo(String value) {
            addCriterion("nature >=", value, "nature");
            return (Criteria) this;
        }

        public Criteria andNatureLessThan(String value) {
            addCriterion("nature <", value, "nature");
            return (Criteria) this;
        }

        public Criteria andNatureLessThanOrEqualTo(String value) {
            addCriterion("nature <=", value, "nature");
            return (Criteria) this;
        }

        public Criteria andNatureLike(String value) {
            addCriterion("nature like", value, "nature");
            return (Criteria) this;
        }

        public Criteria andNatureNotLike(String value) {
            addCriterion("nature not like", value, "nature");
            return (Criteria) this;
        }

        public Criteria andNatureIn(List<String> values) {
            addCriterion("nature in", values, "nature");
            return (Criteria) this;
        }

        public Criteria andNatureNotIn(List<String> values) {
            addCriterion("nature not in", values, "nature");
            return (Criteria) this;
        }

        public Criteria andNatureBetween(String value1, String value2) {
            addCriterion("nature between", value1, value2, "nature");
            return (Criteria) this;
        }

        public Criteria andNatureNotBetween(String value1, String value2) {
            addCriterion("nature not between", value1, value2, "nature");
            return (Criteria) this;
        }

        public Criteria andInterestIsNull() {
            addCriterion("interest is null");
            return (Criteria) this;
        }

        public Criteria andInterestIsNotNull() {
            addCriterion("interest is not null");
            return (Criteria) this;
        }

        public Criteria andInterestEqualTo(String value) {
            addCriterion("interest =", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestNotEqualTo(String value) {
            addCriterion("interest <>", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestGreaterThan(String value) {
            addCriterion("interest >", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestGreaterThanOrEqualTo(String value) {
            addCriterion("interest >=", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestLessThan(String value) {
            addCriterion("interest <", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestLessThanOrEqualTo(String value) {
            addCriterion("interest <=", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestLike(String value) {
            addCriterion("interest like", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestNotLike(String value) {
            addCriterion("interest not like", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestIn(List<String> values) {
            addCriterion("interest in", values, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestNotIn(List<String> values) {
            addCriterion("interest not in", values, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestBetween(String value1, String value2) {
            addCriterion("interest between", value1, value2, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestNotBetween(String value1, String value2) {
            addCriterion("interest not between", value1, value2, "interest");
            return (Criteria) this;
        }

        public Criteria andShapeIsNull() {
            addCriterion("shape is null");
            return (Criteria) this;
        }

        public Criteria andShapeIsNotNull() {
            addCriterion("shape is not null");
            return (Criteria) this;
        }

        public Criteria andShapeEqualTo(String value) {
            addCriterion("shape =", value, "shape");
            return (Criteria) this;
        }

        public Criteria andShapeNotEqualTo(String value) {
            addCriterion("shape <>", value, "shape");
            return (Criteria) this;
        }

        public Criteria andShapeGreaterThan(String value) {
            addCriterion("shape >", value, "shape");
            return (Criteria) this;
        }

        public Criteria andShapeGreaterThanOrEqualTo(String value) {
            addCriterion("shape >=", value, "shape");
            return (Criteria) this;
        }

        public Criteria andShapeLessThan(String value) {
            addCriterion("shape <", value, "shape");
            return (Criteria) this;
        }

        public Criteria andShapeLessThanOrEqualTo(String value) {
            addCriterion("shape <=", value, "shape");
            return (Criteria) this;
        }

        public Criteria andShapeLike(String value) {
            addCriterion("shape like", value, "shape");
            return (Criteria) this;
        }

        public Criteria andShapeNotLike(String value) {
            addCriterion("shape not like", value, "shape");
            return (Criteria) this;
        }

        public Criteria andShapeIn(List<String> values) {
            addCriterion("shape in", values, "shape");
            return (Criteria) this;
        }

        public Criteria andShapeNotIn(List<String> values) {
            addCriterion("shape not in", values, "shape");
            return (Criteria) this;
        }

        public Criteria andShapeBetween(String value1, String value2) {
            addCriterion("shape between", value1, value2, "shape");
            return (Criteria) this;
        }

        public Criteria andShapeNotBetween(String value1, String value2) {
            addCriterion("shape not between", value1, value2, "shape");
            return (Criteria) this;
        }

        public Criteria andHairLengthIsNull() {
            addCriterion("hair_length is null");
            return (Criteria) this;
        }

        public Criteria andHairLengthIsNotNull() {
            addCriterion("hair_length is not null");
            return (Criteria) this;
        }

        public Criteria andHairLengthEqualTo(String value) {
            addCriterion("hair_length =", value, "hairLength");
            return (Criteria) this;
        }

        public Criteria andHairLengthNotEqualTo(String value) {
            addCriterion("hair_length <>", value, "hairLength");
            return (Criteria) this;
        }

        public Criteria andHairLengthGreaterThan(String value) {
            addCriterion("hair_length >", value, "hairLength");
            return (Criteria) this;
        }

        public Criteria andHairLengthGreaterThanOrEqualTo(String value) {
            addCriterion("hair_length >=", value, "hairLength");
            return (Criteria) this;
        }

        public Criteria andHairLengthLessThan(String value) {
            addCriterion("hair_length <", value, "hairLength");
            return (Criteria) this;
        }

        public Criteria andHairLengthLessThanOrEqualTo(String value) {
            addCriterion("hair_length <=", value, "hairLength");
            return (Criteria) this;
        }

        public Criteria andHairLengthLike(String value) {
            addCriterion("hair_length like", value, "hairLength");
            return (Criteria) this;
        }

        public Criteria andHairLengthNotLike(String value) {
            addCriterion("hair_length not like", value, "hairLength");
            return (Criteria) this;
        }

        public Criteria andHairLengthIn(List<String> values) {
            addCriterion("hair_length in", values, "hairLength");
            return (Criteria) this;
        }

        public Criteria andHairLengthNotIn(List<String> values) {
            addCriterion("hair_length not in", values, "hairLength");
            return (Criteria) this;
        }

        public Criteria andHairLengthBetween(String value1, String value2) {
            addCriterion("hair_length between", value1, value2, "hairLength");
            return (Criteria) this;
        }

        public Criteria andHairLengthNotBetween(String value1, String value2) {
            addCriterion("hair_length not between", value1, value2, "hairLength");
            return (Criteria) this;
        }

        public Criteria andHistoryIsNull() {
            addCriterion("history is null");
            return (Criteria) this;
        }

        public Criteria andHistoryIsNotNull() {
            addCriterion("history is not null");
            return (Criteria) this;
        }

        public Criteria andHistoryEqualTo(String value) {
            addCriterion("history =", value, "history");
            return (Criteria) this;
        }

        public Criteria andHistoryNotEqualTo(String value) {
            addCriterion("history <>", value, "history");
            return (Criteria) this;
        }

        public Criteria andHistoryGreaterThan(String value) {
            addCriterion("history >", value, "history");
            return (Criteria) this;
        }

        public Criteria andHistoryGreaterThanOrEqualTo(String value) {
            addCriterion("history >=", value, "history");
            return (Criteria) this;
        }

        public Criteria andHistoryLessThan(String value) {
            addCriterion("history <", value, "history");
            return (Criteria) this;
        }

        public Criteria andHistoryLessThanOrEqualTo(String value) {
            addCriterion("history <=", value, "history");
            return (Criteria) this;
        }

        public Criteria andHistoryLike(String value) {
            addCriterion("history like", value, "history");
            return (Criteria) this;
        }

        public Criteria andHistoryNotLike(String value) {
            addCriterion("history not like", value, "history");
            return (Criteria) this;
        }

        public Criteria andHistoryIn(List<String> values) {
            addCriterion("history in", values, "history");
            return (Criteria) this;
        }

        public Criteria andHistoryNotIn(List<String> values) {
            addCriterion("history not in", values, "history");
            return (Criteria) this;
        }

        public Criteria andHistoryBetween(String value1, String value2) {
            addCriterion("history between", value1, value2, "history");
            return (Criteria) this;
        }

        public Criteria andHistoryNotBetween(String value1, String value2) {
            addCriterion("history not between", value1, value2, "history");
            return (Criteria) this;
        }

        public Criteria andFormCharacterIsNull() {
            addCriterion("form_character is null");
            return (Criteria) this;
        }

        public Criteria andFormCharacterIsNotNull() {
            addCriterion("form_character is not null");
            return (Criteria) this;
        }

        public Criteria andFormCharacterEqualTo(String value) {
            addCriterion("form_character =", value, "formCharacter");
            return (Criteria) this;
        }

        public Criteria andFormCharacterNotEqualTo(String value) {
            addCriterion("form_character <>", value, "formCharacter");
            return (Criteria) this;
        }

        public Criteria andFormCharacterGreaterThan(String value) {
            addCriterion("form_character >", value, "formCharacter");
            return (Criteria) this;
        }

        public Criteria andFormCharacterGreaterThanOrEqualTo(String value) {
            addCriterion("form_character >=", value, "formCharacter");
            return (Criteria) this;
        }

        public Criteria andFormCharacterLessThan(String value) {
            addCriterion("form_character <", value, "formCharacter");
            return (Criteria) this;
        }

        public Criteria andFormCharacterLessThanOrEqualTo(String value) {
            addCriterion("form_character <=", value, "formCharacter");
            return (Criteria) this;
        }

        public Criteria andFormCharacterLike(String value) {
            addCriterion("form_character like", value, "formCharacter");
            return (Criteria) this;
        }

        public Criteria andFormCharacterNotLike(String value) {
            addCriterion("form_character not like", value, "formCharacter");
            return (Criteria) this;
        }

        public Criteria andFormCharacterIn(List<String> values) {
            addCriterion("form_character in", values, "formCharacter");
            return (Criteria) this;
        }

        public Criteria andFormCharacterNotIn(List<String> values) {
            addCriterion("form_character not in", values, "formCharacter");
            return (Criteria) this;
        }

        public Criteria andFormCharacterBetween(String value1, String value2) {
            addCriterion("form_character between", value1, value2, "formCharacter");
            return (Criteria) this;
        }

        public Criteria andFormCharacterNotBetween(String value1, String value2) {
            addCriterion("form_character not between", value1, value2, "formCharacter");
            return (Criteria) this;
        }

        public Criteria andStandardIsNull() {
            addCriterion("standard is null");
            return (Criteria) this;
        }

        public Criteria andStandardIsNotNull() {
            addCriterion("standard is not null");
            return (Criteria) this;
        }

        public Criteria andStandardEqualTo(String value) {
            addCriterion("standard =", value, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardNotEqualTo(String value) {
            addCriterion("standard <>", value, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardGreaterThan(String value) {
            addCriterion("standard >", value, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardGreaterThanOrEqualTo(String value) {
            addCriterion("standard >=", value, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardLessThan(String value) {
            addCriterion("standard <", value, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardLessThanOrEqualTo(String value) {
            addCriterion("standard <=", value, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardLike(String value) {
            addCriterion("standard like", value, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardNotLike(String value) {
            addCriterion("standard not like", value, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardIn(List<String> values) {
            addCriterion("standard in", values, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardNotIn(List<String> values) {
            addCriterion("standard not in", values, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardBetween(String value1, String value2) {
            addCriterion("standard between", value1, value2, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardNotBetween(String value1, String value2) {
            addCriterion("standard not between", value1, value2, "standard");
            return (Criteria) this;
        }

        public Criteria andLifeHabitIsNull() {
            addCriterion("life_habit is null");
            return (Criteria) this;
        }

        public Criteria andLifeHabitIsNotNull() {
            addCriterion("life_habit is not null");
            return (Criteria) this;
        }

        public Criteria andLifeHabitEqualTo(String value) {
            addCriterion("life_habit =", value, "lifeHabit");
            return (Criteria) this;
        }

        public Criteria andLifeHabitNotEqualTo(String value) {
            addCriterion("life_habit <>", value, "lifeHabit");
            return (Criteria) this;
        }

        public Criteria andLifeHabitGreaterThan(String value) {
            addCriterion("life_habit >", value, "lifeHabit");
            return (Criteria) this;
        }

        public Criteria andLifeHabitGreaterThanOrEqualTo(String value) {
            addCriterion("life_habit >=", value, "lifeHabit");
            return (Criteria) this;
        }

        public Criteria andLifeHabitLessThan(String value) {
            addCriterion("life_habit <", value, "lifeHabit");
            return (Criteria) this;
        }

        public Criteria andLifeHabitLessThanOrEqualTo(String value) {
            addCriterion("life_habit <=", value, "lifeHabit");
            return (Criteria) this;
        }

        public Criteria andLifeHabitLike(String value) {
            addCriterion("life_habit like", value, "lifeHabit");
            return (Criteria) this;
        }

        public Criteria andLifeHabitNotLike(String value) {
            addCriterion("life_habit not like", value, "lifeHabit");
            return (Criteria) this;
        }

        public Criteria andLifeHabitIn(List<String> values) {
            addCriterion("life_habit in", values, "lifeHabit");
            return (Criteria) this;
        }

        public Criteria andLifeHabitNotIn(List<String> values) {
            addCriterion("life_habit not in", values, "lifeHabit");
            return (Criteria) this;
        }

        public Criteria andLifeHabitBetween(String value1, String value2) {
            addCriterion("life_habit between", value1, value2, "lifeHabit");
            return (Criteria) this;
        }

        public Criteria andLifeHabitNotBetween(String value1, String value2) {
            addCriterion("life_habit not between", value1, value2, "lifeHabit");
            return (Criteria) this;
        }

        public Criteria andCharacterTraitsIsNull() {
            addCriterion("character_traits is null");
            return (Criteria) this;
        }

        public Criteria andCharacterTraitsIsNotNull() {
            addCriterion("character_traits is not null");
            return (Criteria) this;
        }

        public Criteria andCharacterTraitsEqualTo(String value) {
            addCriterion("character_traits =", value, "characterTraits");
            return (Criteria) this;
        }

        public Criteria andCharacterTraitsNotEqualTo(String value) {
            addCriterion("character_traits <>", value, "characterTraits");
            return (Criteria) this;
        }

        public Criteria andCharacterTraitsGreaterThan(String value) {
            addCriterion("character_traits >", value, "characterTraits");
            return (Criteria) this;
        }

        public Criteria andCharacterTraitsGreaterThanOrEqualTo(String value) {
            addCriterion("character_traits >=", value, "characterTraits");
            return (Criteria) this;
        }

        public Criteria andCharacterTraitsLessThan(String value) {
            addCriterion("character_traits <", value, "characterTraits");
            return (Criteria) this;
        }

        public Criteria andCharacterTraitsLessThanOrEqualTo(String value) {
            addCriterion("character_traits <=", value, "characterTraits");
            return (Criteria) this;
        }

        public Criteria andCharacterTraitsLike(String value) {
            addCriterion("character_traits like", value, "characterTraits");
            return (Criteria) this;
        }

        public Criteria andCharacterTraitsNotLike(String value) {
            addCriterion("character_traits not like", value, "characterTraits");
            return (Criteria) this;
        }

        public Criteria andCharacterTraitsIn(List<String> values) {
            addCriterion("character_traits in", values, "characterTraits");
            return (Criteria) this;
        }

        public Criteria andCharacterTraitsNotIn(List<String> values) {
            addCriterion("character_traits not in", values, "characterTraits");
            return (Criteria) this;
        }

        public Criteria andCharacterTraitsBetween(String value1, String value2) {
            addCriterion("character_traits between", value1, value2, "characterTraits");
            return (Criteria) this;
        }

        public Criteria andCharacterTraitsNotBetween(String value1, String value2) {
            addCriterion("character_traits not between", value1, value2, "characterTraits");
            return (Criteria) this;
        }

        public Criteria andDietIsNull() {
            addCriterion("diet is null");
            return (Criteria) this;
        }

        public Criteria andDietIsNotNull() {
            addCriterion("diet is not null");
            return (Criteria) this;
        }

        public Criteria andDietEqualTo(String value) {
            addCriterion("diet =", value, "diet");
            return (Criteria) this;
        }

        public Criteria andDietNotEqualTo(String value) {
            addCriterion("diet <>", value, "diet");
            return (Criteria) this;
        }

        public Criteria andDietGreaterThan(String value) {
            addCriterion("diet >", value, "diet");
            return (Criteria) this;
        }

        public Criteria andDietGreaterThanOrEqualTo(String value) {
            addCriterion("diet >=", value, "diet");
            return (Criteria) this;
        }

        public Criteria andDietLessThan(String value) {
            addCriterion("diet <", value, "diet");
            return (Criteria) this;
        }

        public Criteria andDietLessThanOrEqualTo(String value) {
            addCriterion("diet <=", value, "diet");
            return (Criteria) this;
        }

        public Criteria andDietLike(String value) {
            addCriterion("diet like", value, "diet");
            return (Criteria) this;
        }

        public Criteria andDietNotLike(String value) {
            addCriterion("diet not like", value, "diet");
            return (Criteria) this;
        }

        public Criteria andDietIn(List<String> values) {
            addCriterion("diet in", values, "diet");
            return (Criteria) this;
        }

        public Criteria andDietNotIn(List<String> values) {
            addCriterion("diet not in", values, "diet");
            return (Criteria) this;
        }

        public Criteria andDietBetween(String value1, String value2) {
            addCriterion("diet between", value1, value2, "diet");
            return (Criteria) this;
        }

        public Criteria andDietNotBetween(String value1, String value2) {
            addCriterion("diet not between", value1, value2, "diet");
            return (Criteria) this;
        }

        public Criteria andTipsIsNull() {
            addCriterion("tips is null");
            return (Criteria) this;
        }

        public Criteria andTipsIsNotNull() {
            addCriterion("tips is not null");
            return (Criteria) this;
        }

        public Criteria andTipsEqualTo(String value) {
            addCriterion("tips =", value, "tips");
            return (Criteria) this;
        }

        public Criteria andTipsNotEqualTo(String value) {
            addCriterion("tips <>", value, "tips");
            return (Criteria) this;
        }

        public Criteria andTipsGreaterThan(String value) {
            addCriterion("tips >", value, "tips");
            return (Criteria) this;
        }

        public Criteria andTipsGreaterThanOrEqualTo(String value) {
            addCriterion("tips >=", value, "tips");
            return (Criteria) this;
        }

        public Criteria andTipsLessThan(String value) {
            addCriterion("tips <", value, "tips");
            return (Criteria) this;
        }

        public Criteria andTipsLessThanOrEqualTo(String value) {
            addCriterion("tips <=", value, "tips");
            return (Criteria) this;
        }

        public Criteria andTipsLike(String value) {
            addCriterion("tips like", value, "tips");
            return (Criteria) this;
        }

        public Criteria andTipsNotLike(String value) {
            addCriterion("tips not like", value, "tips");
            return (Criteria) this;
        }

        public Criteria andTipsIn(List<String> values) {
            addCriterion("tips in", values, "tips");
            return (Criteria) this;
        }

        public Criteria andTipsNotIn(List<String> values) {
            addCriterion("tips not in", values, "tips");
            return (Criteria) this;
        }

        public Criteria andTipsBetween(String value1, String value2) {
            addCriterion("tips between", value1, value2, "tips");
            return (Criteria) this;
        }

        public Criteria andTipsNotBetween(String value1, String value2) {
            addCriterion("tips not between", value1, value2, "tips");
            return (Criteria) this;
        }

        public Criteria andDomesticateMethodIsNull() {
            addCriterion("domesticate_method is null");
            return (Criteria) this;
        }

        public Criteria andDomesticateMethodIsNotNull() {
            addCriterion("domesticate_method is not null");
            return (Criteria) this;
        }

        public Criteria andDomesticateMethodEqualTo(String value) {
            addCriterion("domesticate_method =", value, "domesticateMethod");
            return (Criteria) this;
        }

        public Criteria andDomesticateMethodNotEqualTo(String value) {
            addCriterion("domesticate_method <>", value, "domesticateMethod");
            return (Criteria) this;
        }

        public Criteria andDomesticateMethodGreaterThan(String value) {
            addCriterion("domesticate_method >", value, "domesticateMethod");
            return (Criteria) this;
        }

        public Criteria andDomesticateMethodGreaterThanOrEqualTo(String value) {
            addCriterion("domesticate_method >=", value, "domesticateMethod");
            return (Criteria) this;
        }

        public Criteria andDomesticateMethodLessThan(String value) {
            addCriterion("domesticate_method <", value, "domesticateMethod");
            return (Criteria) this;
        }

        public Criteria andDomesticateMethodLessThanOrEqualTo(String value) {
            addCriterion("domesticate_method <=", value, "domesticateMethod");
            return (Criteria) this;
        }

        public Criteria andDomesticateMethodLike(String value) {
            addCriterion("domesticate_method like", value, "domesticateMethod");
            return (Criteria) this;
        }

        public Criteria andDomesticateMethodNotLike(String value) {
            addCriterion("domesticate_method not like", value, "domesticateMethod");
            return (Criteria) this;
        }

        public Criteria andDomesticateMethodIn(List<String> values) {
            addCriterion("domesticate_method in", values, "domesticateMethod");
            return (Criteria) this;
        }

        public Criteria andDomesticateMethodNotIn(List<String> values) {
            addCriterion("domesticate_method not in", values, "domesticateMethod");
            return (Criteria) this;
        }

        public Criteria andDomesticateMethodBetween(String value1, String value2) {
            addCriterion("domesticate_method between", value1, value2, "domesticateMethod");
            return (Criteria) this;
        }

        public Criteria andDomesticateMethodNotBetween(String value1, String value2) {
            addCriterion("domesticate_method not between", value1, value2, "domesticateMethod");
            return (Criteria) this;
        }

        public Criteria andDiseaseIsNull() {
            addCriterion("disease is null");
            return (Criteria) this;
        }

        public Criteria andDiseaseIsNotNull() {
            addCriterion("disease is not null");
            return (Criteria) this;
        }

        public Criteria andDiseaseEqualTo(String value) {
            addCriterion("disease =", value, "disease");
            return (Criteria) this;
        }

        public Criteria andDiseaseNotEqualTo(String value) {
            addCriterion("disease <>", value, "disease");
            return (Criteria) this;
        }

        public Criteria andDiseaseGreaterThan(String value) {
            addCriterion("disease >", value, "disease");
            return (Criteria) this;
        }

        public Criteria andDiseaseGreaterThanOrEqualTo(String value) {
            addCriterion("disease >=", value, "disease");
            return (Criteria) this;
        }

        public Criteria andDiseaseLessThan(String value) {
            addCriterion("disease <", value, "disease");
            return (Criteria) this;
        }

        public Criteria andDiseaseLessThanOrEqualTo(String value) {
            addCriterion("disease <=", value, "disease");
            return (Criteria) this;
        }

        public Criteria andDiseaseLike(String value) {
            addCriterion("disease like", value, "disease");
            return (Criteria) this;
        }

        public Criteria andDiseaseNotLike(String value) {
            addCriterion("disease not like", value, "disease");
            return (Criteria) this;
        }

        public Criteria andDiseaseIn(List<String> values) {
            addCriterion("disease in", values, "disease");
            return (Criteria) this;
        }

        public Criteria andDiseaseNotIn(List<String> values) {
            addCriterion("disease not in", values, "disease");
            return (Criteria) this;
        }

        public Criteria andDiseaseBetween(String value1, String value2) {
            addCriterion("disease between", value1, value2, "disease");
            return (Criteria) this;
        }

        public Criteria andDiseaseNotBetween(String value1, String value2) {
            addCriterion("disease not between", value1, value2, "disease");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andPetsPhotosIsNull() {
            addCriterion("pets_photos is null");
            return (Criteria) this;
        }

        public Criteria andPetsPhotosIsNotNull() {
            addCriterion("pets_photos is not null");
            return (Criteria) this;
        }

        public Criteria andPetsPhotosEqualTo(String value) {
            addCriterion("pets_photos =", value, "petsPhotos");
            return (Criteria) this;
        }

        public Criteria andPetsPhotosNotEqualTo(String value) {
            addCriterion("pets_photos <>", value, "petsPhotos");
            return (Criteria) this;
        }

        public Criteria andPetsPhotosGreaterThan(String value) {
            addCriterion("pets_photos >", value, "petsPhotos");
            return (Criteria) this;
        }

        public Criteria andPetsPhotosGreaterThanOrEqualTo(String value) {
            addCriterion("pets_photos >=", value, "petsPhotos");
            return (Criteria) this;
        }

        public Criteria andPetsPhotosLessThan(String value) {
            addCriterion("pets_photos <", value, "petsPhotos");
            return (Criteria) this;
        }

        public Criteria andPetsPhotosLessThanOrEqualTo(String value) {
            addCriterion("pets_photos <=", value, "petsPhotos");
            return (Criteria) this;
        }

        public Criteria andPetsPhotosLike(String value) {
            addCriterion("pets_photos like", value, "petsPhotos");
            return (Criteria) this;
        }

        public Criteria andPetsPhotosNotLike(String value) {
            addCriterion("pets_photos not like", value, "petsPhotos");
            return (Criteria) this;
        }

        public Criteria andPetsPhotosIn(List<String> values) {
            addCriterion("pets_photos in", values, "petsPhotos");
            return (Criteria) this;
        }

        public Criteria andPetsPhotosNotIn(List<String> values) {
            addCriterion("pets_photos not in", values, "petsPhotos");
            return (Criteria) this;
        }

        public Criteria andPetsPhotosBetween(String value1, String value2) {
            addCriterion("pets_photos between", value1, value2, "petsPhotos");
            return (Criteria) this;
        }

        public Criteria andPetsPhotosNotBetween(String value1, String value2) {
            addCriterion("pets_photos not between", value1, value2, "petsPhotos");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNull() {
            addCriterion("category_id is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNotNull() {
            addCriterion("category_id is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdEqualTo(String value) {
            addCriterion("category_id =", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotEqualTo(String value) {
            addCriterion("category_id <>", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThan(String value) {
            addCriterion("category_id >", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThanOrEqualTo(String value) {
            addCriterion("category_id >=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThan(String value) {
            addCriterion("category_id <", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThanOrEqualTo(String value) {
            addCriterion("category_id <=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLike(String value) {
            addCriterion("category_id like", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotLike(String value) {
            addCriterion("category_id not like", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIn(List<String> values) {
            addCriterion("category_id in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotIn(List<String> values) {
            addCriterion("category_id not in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdBetween(String value1, String value2) {
            addCriterion("category_id between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotBetween(String value1, String value2) {
            addCriterion("category_id not between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andUdateAdminIsNull() {
            addCriterion("udate_admin is null");
            return (Criteria) this;
        }

        public Criteria andUdateAdminIsNotNull() {
            addCriterion("udate_admin is not null");
            return (Criteria) this;
        }

        public Criteria andUdateAdminEqualTo(String value) {
            addCriterion("udate_admin =", value, "udateAdmin");
            return (Criteria) this;
        }

        public Criteria andUdateAdminNotEqualTo(String value) {
            addCriterion("udate_admin <>", value, "udateAdmin");
            return (Criteria) this;
        }

        public Criteria andUdateAdminGreaterThan(String value) {
            addCriterion("udate_admin >", value, "udateAdmin");
            return (Criteria) this;
        }

        public Criteria andUdateAdminGreaterThanOrEqualTo(String value) {
            addCriterion("udate_admin >=", value, "udateAdmin");
            return (Criteria) this;
        }

        public Criteria andUdateAdminLessThan(String value) {
            addCriterion("udate_admin <", value, "udateAdmin");
            return (Criteria) this;
        }

        public Criteria andUdateAdminLessThanOrEqualTo(String value) {
            addCriterion("udate_admin <=", value, "udateAdmin");
            return (Criteria) this;
        }

        public Criteria andUdateAdminLike(String value) {
            addCriterion("udate_admin like", value, "udateAdmin");
            return (Criteria) this;
        }

        public Criteria andUdateAdminNotLike(String value) {
            addCriterion("udate_admin not like", value, "udateAdmin");
            return (Criteria) this;
        }

        public Criteria andUdateAdminIn(List<String> values) {
            addCriterion("udate_admin in", values, "udateAdmin");
            return (Criteria) this;
        }

        public Criteria andUdateAdminNotIn(List<String> values) {
            addCriterion("udate_admin not in", values, "udateAdmin");
            return (Criteria) this;
        }

        public Criteria andUdateAdminBetween(String value1, String value2) {
            addCriterion("udate_admin between", value1, value2, "udateAdmin");
            return (Criteria) this;
        }

        public Criteria andUdateAdminNotBetween(String value1, String value2) {
            addCriterion("udate_admin not between", value1, value2, "udateAdmin");
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