package com.longshu.petsfairy.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InvitationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InvitationExample() {
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

        public Criteria andInvitationIdIsNull() {
            addCriterion("invitation_id is null");
            return (Criteria) this;
        }

        public Criteria andInvitationIdIsNotNull() {
            addCriterion("invitation_id is not null");
            return (Criteria) this;
        }

        public Criteria andInvitationIdEqualTo(String value) {
            addCriterion("invitation_id =", value, "invitationId");
            return (Criteria) this;
        }

        public Criteria andInvitationIdNotEqualTo(String value) {
            addCriterion("invitation_id <>", value, "invitationId");
            return (Criteria) this;
        }

        public Criteria andInvitationIdGreaterThan(String value) {
            addCriterion("invitation_id >", value, "invitationId");
            return (Criteria) this;
        }

        public Criteria andInvitationIdGreaterThanOrEqualTo(String value) {
            addCriterion("invitation_id >=", value, "invitationId");
            return (Criteria) this;
        }

        public Criteria andInvitationIdLessThan(String value) {
            addCriterion("invitation_id <", value, "invitationId");
            return (Criteria) this;
        }

        public Criteria andInvitationIdLessThanOrEqualTo(String value) {
            addCriterion("invitation_id <=", value, "invitationId");
            return (Criteria) this;
        }

        public Criteria andInvitationIdLike(String value) {
            addCriterion("invitation_id like", value, "invitationId");
            return (Criteria) this;
        }

        public Criteria andInvitationIdNotLike(String value) {
            addCriterion("invitation_id not like", value, "invitationId");
            return (Criteria) this;
        }

        public Criteria andInvitationIdIn(List<String> values) {
            addCriterion("invitation_id in", values, "invitationId");
            return (Criteria) this;
        }

        public Criteria andInvitationIdNotIn(List<String> values) {
            addCriterion("invitation_id not in", values, "invitationId");
            return (Criteria) this;
        }

        public Criteria andInvitationIdBetween(String value1, String value2) {
            addCriterion("invitation_id between", value1, value2, "invitationId");
            return (Criteria) this;
        }

        public Criteria andInvitationIdNotBetween(String value1, String value2) {
            addCriterion("invitation_id not between", value1, value2, "invitationId");
            return (Criteria) this;
        }

        public Criteria andInvitationContentIsNull() {
            addCriterion("invitation_content is null");
            return (Criteria) this;
        }

        public Criteria andInvitationContentIsNotNull() {
            addCriterion("invitation_content is not null");
            return (Criteria) this;
        }

        public Criteria andInvitationContentEqualTo(String value) {
            addCriterion("invitation_content =", value, "invitationContent");
            return (Criteria) this;
        }

        public Criteria andInvitationContentNotEqualTo(String value) {
            addCriterion("invitation_content <>", value, "invitationContent");
            return (Criteria) this;
        }

        public Criteria andInvitationContentGreaterThan(String value) {
            addCriterion("invitation_content >", value, "invitationContent");
            return (Criteria) this;
        }

        public Criteria andInvitationContentGreaterThanOrEqualTo(String value) {
            addCriterion("invitation_content >=", value, "invitationContent");
            return (Criteria) this;
        }

        public Criteria andInvitationContentLessThan(String value) {
            addCriterion("invitation_content <", value, "invitationContent");
            return (Criteria) this;
        }

        public Criteria andInvitationContentLessThanOrEqualTo(String value) {
            addCriterion("invitation_content <=", value, "invitationContent");
            return (Criteria) this;
        }

        public Criteria andInvitationContentLike(String value) {
            addCriterion("invitation_content like", value, "invitationContent");
            return (Criteria) this;
        }

        public Criteria andInvitationContentNotLike(String value) {
            addCriterion("invitation_content not like", value, "invitationContent");
            return (Criteria) this;
        }

        public Criteria andInvitationContentIn(List<String> values) {
            addCriterion("invitation_content in", values, "invitationContent");
            return (Criteria) this;
        }

        public Criteria andInvitationContentNotIn(List<String> values) {
            addCriterion("invitation_content not in", values, "invitationContent");
            return (Criteria) this;
        }

        public Criteria andInvitationContentBetween(String value1, String value2) {
            addCriterion("invitation_content between", value1, value2, "invitationContent");
            return (Criteria) this;
        }

        public Criteria andInvitationContentNotBetween(String value1, String value2) {
            addCriterion("invitation_content not between", value1, value2, "invitationContent");
            return (Criteria) this;
        }

        public Criteria andInvitationPhotoIsNull() {
            addCriterion("invitation_photo is null");
            return (Criteria) this;
        }

        public Criteria andInvitationPhotoIsNotNull() {
            addCriterion("invitation_photo is not null");
            return (Criteria) this;
        }

        public Criteria andInvitationPhotoEqualTo(String value) {
            addCriterion("invitation_photo =", value, "invitationPhoto");
            return (Criteria) this;
        }

        public Criteria andInvitationPhotoNotEqualTo(String value) {
            addCriterion("invitation_photo <>", value, "invitationPhoto");
            return (Criteria) this;
        }

        public Criteria andInvitationPhotoGreaterThan(String value) {
            addCriterion("invitation_photo >", value, "invitationPhoto");
            return (Criteria) this;
        }

        public Criteria andInvitationPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("invitation_photo >=", value, "invitationPhoto");
            return (Criteria) this;
        }

        public Criteria andInvitationPhotoLessThan(String value) {
            addCriterion("invitation_photo <", value, "invitationPhoto");
            return (Criteria) this;
        }

        public Criteria andInvitationPhotoLessThanOrEqualTo(String value) {
            addCriterion("invitation_photo <=", value, "invitationPhoto");
            return (Criteria) this;
        }

        public Criteria andInvitationPhotoLike(String value) {
            addCriterion("invitation_photo like", value, "invitationPhoto");
            return (Criteria) this;
        }

        public Criteria andInvitationPhotoNotLike(String value) {
            addCriterion("invitation_photo not like", value, "invitationPhoto");
            return (Criteria) this;
        }

        public Criteria andInvitationPhotoIn(List<String> values) {
            addCriterion("invitation_photo in", values, "invitationPhoto");
            return (Criteria) this;
        }

        public Criteria andInvitationPhotoNotIn(List<String> values) {
            addCriterion("invitation_photo not in", values, "invitationPhoto");
            return (Criteria) this;
        }

        public Criteria andInvitationPhotoBetween(String value1, String value2) {
            addCriterion("invitation_photo between", value1, value2, "invitationPhoto");
            return (Criteria) this;
        }

        public Criteria andInvitationPhotoNotBetween(String value1, String value2) {
            addCriterion("invitation_photo not between", value1, value2, "invitationPhoto");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andInvitationMasterIdIsNull() {
            addCriterion("invitation_master_id is null");
            return (Criteria) this;
        }

        public Criteria andInvitationMasterIdIsNotNull() {
            addCriterion("invitation_master_id is not null");
            return (Criteria) this;
        }

        public Criteria andInvitationMasterIdEqualTo(String value) {
            addCriterion("invitation_master_id =", value, "invitationMasterId");
            return (Criteria) this;
        }

        public Criteria andInvitationMasterIdNotEqualTo(String value) {
            addCriterion("invitation_master_id <>", value, "invitationMasterId");
            return (Criteria) this;
        }

        public Criteria andInvitationMasterIdGreaterThan(String value) {
            addCriterion("invitation_master_id >", value, "invitationMasterId");
            return (Criteria) this;
        }

        public Criteria andInvitationMasterIdGreaterThanOrEqualTo(String value) {
            addCriterion("invitation_master_id >=", value, "invitationMasterId");
            return (Criteria) this;
        }

        public Criteria andInvitationMasterIdLessThan(String value) {
            addCriterion("invitation_master_id <", value, "invitationMasterId");
            return (Criteria) this;
        }

        public Criteria andInvitationMasterIdLessThanOrEqualTo(String value) {
            addCriterion("invitation_master_id <=", value, "invitationMasterId");
            return (Criteria) this;
        }

        public Criteria andInvitationMasterIdLike(String value) {
            addCriterion("invitation_master_id like", value, "invitationMasterId");
            return (Criteria) this;
        }

        public Criteria andInvitationMasterIdNotLike(String value) {
            addCriterion("invitation_master_id not like", value, "invitationMasterId");
            return (Criteria) this;
        }

        public Criteria andInvitationMasterIdIn(List<String> values) {
            addCriterion("invitation_master_id in", values, "invitationMasterId");
            return (Criteria) this;
        }

        public Criteria andInvitationMasterIdNotIn(List<String> values) {
            addCriterion("invitation_master_id not in", values, "invitationMasterId");
            return (Criteria) this;
        }

        public Criteria andInvitationMasterIdBetween(String value1, String value2) {
            addCriterion("invitation_master_id between", value1, value2, "invitationMasterId");
            return (Criteria) this;
        }

        public Criteria andInvitationMasterIdNotBetween(String value1, String value2) {
            addCriterion("invitation_master_id not between", value1, value2, "invitationMasterId");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIsNull() {
            addCriterion("delete_flag is null");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIsNotNull() {
            addCriterion("delete_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagEqualTo(Integer value) {
            addCriterion("delete_flag =", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotEqualTo(Integer value) {
            addCriterion("delete_flag <>", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagGreaterThan(Integer value) {
            addCriterion("delete_flag >", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("delete_flag >=", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLessThan(Integer value) {
            addCriterion("delete_flag <", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLessThanOrEqualTo(Integer value) {
            addCriterion("delete_flag <=", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIn(List<Integer> values) {
            addCriterion("delete_flag in", values, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotIn(List<Integer> values) {
            addCriterion("delete_flag not in", values, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagBetween(Integer value1, Integer value2) {
            addCriterion("delete_flag between", value1, value2, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("delete_flag not between", value1, value2, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andPersonPetsIdIsNull() {
            addCriterion("person_pets_id is null");
            return (Criteria) this;
        }

        public Criteria andPersonPetsIdIsNotNull() {
            addCriterion("person_pets_id is not null");
            return (Criteria) this;
        }

        public Criteria andPersonPetsIdEqualTo(String value) {
            addCriterion("person_pets_id =", value, "personPetsId");
            return (Criteria) this;
        }

        public Criteria andPersonPetsIdNotEqualTo(String value) {
            addCriterion("person_pets_id <>", value, "personPetsId");
            return (Criteria) this;
        }

        public Criteria andPersonPetsIdGreaterThan(String value) {
            addCriterion("person_pets_id >", value, "personPetsId");
            return (Criteria) this;
        }

        public Criteria andPersonPetsIdGreaterThanOrEqualTo(String value) {
            addCriterion("person_pets_id >=", value, "personPetsId");
            return (Criteria) this;
        }

        public Criteria andPersonPetsIdLessThan(String value) {
            addCriterion("person_pets_id <", value, "personPetsId");
            return (Criteria) this;
        }

        public Criteria andPersonPetsIdLessThanOrEqualTo(String value) {
            addCriterion("person_pets_id <=", value, "personPetsId");
            return (Criteria) this;
        }

        public Criteria andPersonPetsIdLike(String value) {
            addCriterion("person_pets_id like", value, "personPetsId");
            return (Criteria) this;
        }

        public Criteria andPersonPetsIdNotLike(String value) {
            addCriterion("person_pets_id not like", value, "personPetsId");
            return (Criteria) this;
        }

        public Criteria andPersonPetsIdIn(List<String> values) {
            addCriterion("person_pets_id in", values, "personPetsId");
            return (Criteria) this;
        }

        public Criteria andPersonPetsIdNotIn(List<String> values) {
            addCriterion("person_pets_id not in", values, "personPetsId");
            return (Criteria) this;
        }

        public Criteria andPersonPetsIdBetween(String value1, String value2) {
            addCriterion("person_pets_id between", value1, value2, "personPetsId");
            return (Criteria) this;
        }

        public Criteria andPersonPetsIdNotBetween(String value1, String value2) {
            addCriterion("person_pets_id not between", value1, value2, "personPetsId");
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