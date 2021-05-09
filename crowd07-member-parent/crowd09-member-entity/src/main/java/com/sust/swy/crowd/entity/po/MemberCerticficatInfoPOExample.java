package com.sust.swy.crowd.entity.po;

import java.util.ArrayList;
import java.util.List;

public class MemberCerticficatInfoPOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MemberCerticficatInfoPOExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMemberidIsNull() {
            addCriterion("memberid is null");
            return (Criteria) this;
        }

        public Criteria andMemberidIsNotNull() {
            addCriterion("memberid is not null");
            return (Criteria) this;
        }

        public Criteria andMemberidEqualTo(Integer value) {
            addCriterion("memberid =", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidNotEqualTo(Integer value) {
            addCriterion("memberid <>", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidGreaterThan(Integer value) {
            addCriterion("memberid >", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidGreaterThanOrEqualTo(Integer value) {
            addCriterion("memberid >=", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidLessThan(Integer value) {
            addCriterion("memberid <", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidLessThanOrEqualTo(Integer value) {
            addCriterion("memberid <=", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidIn(List<Integer> values) {
            addCriterion("memberid in", values, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidNotIn(List<Integer> values) {
            addCriterion("memberid not in", values, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidBetween(Integer value1, Integer value2) {
            addCriterion("memberid between", value1, value2, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidNotBetween(Integer value1, Integer value2) {
            addCriterion("memberid not between", value1, value2, "memberid");
            return (Criteria) this;
        }

        public Criteria andRealnameIsNull() {
            addCriterion("realname is null");
            return (Criteria) this;
        }

        public Criteria andRealnameIsNotNull() {
            addCriterion("realname is not null");
            return (Criteria) this;
        }

        public Criteria andRealnameEqualTo(String value) {
            addCriterion("realname =", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotEqualTo(String value) {
            addCriterion("realname <>", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameGreaterThan(String value) {
            addCriterion("realname >", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameGreaterThanOrEqualTo(String value) {
            addCriterion("realname >=", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLessThan(String value) {
            addCriterion("realname <", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLessThanOrEqualTo(String value) {
            addCriterion("realname <=", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLike(String value) {
            addCriterion("realname like", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotLike(String value) {
            addCriterion("realname not like", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameIn(List<String> values) {
            addCriterion("realname in", values, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotIn(List<String> values) {
            addCriterion("realname not in", values, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameBetween(String value1, String value2) {
            addCriterion("realname between", value1, value2, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotBetween(String value1, String value2) {
            addCriterion("realname not between", value1, value2, "realname");
            return (Criteria) this;
        }

        public Criteria andCardnumIsNull() {
            addCriterion("cardnum is null");
            return (Criteria) this;
        }

        public Criteria andCardnumIsNotNull() {
            addCriterion("cardnum is not null");
            return (Criteria) this;
        }

        public Criteria andCardnumEqualTo(String value) {
            addCriterion("cardnum =", value, "cardnum");
            return (Criteria) this;
        }

        public Criteria andCardnumNotEqualTo(String value) {
            addCriterion("cardnum <>", value, "cardnum");
            return (Criteria) this;
        }

        public Criteria andCardnumGreaterThan(String value) {
            addCriterion("cardnum >", value, "cardnum");
            return (Criteria) this;
        }

        public Criteria andCardnumGreaterThanOrEqualTo(String value) {
            addCriterion("cardnum >=", value, "cardnum");
            return (Criteria) this;
        }

        public Criteria andCardnumLessThan(String value) {
            addCriterion("cardnum <", value, "cardnum");
            return (Criteria) this;
        }

        public Criteria andCardnumLessThanOrEqualTo(String value) {
            addCriterion("cardnum <=", value, "cardnum");
            return (Criteria) this;
        }

        public Criteria andCardnumLike(String value) {
            addCriterion("cardnum like", value, "cardnum");
            return (Criteria) this;
        }

        public Criteria andCardnumNotLike(String value) {
            addCriterion("cardnum not like", value, "cardnum");
            return (Criteria) this;
        }

        public Criteria andCardnumIn(List<String> values) {
            addCriterion("cardnum in", values, "cardnum");
            return (Criteria) this;
        }

        public Criteria andCardnumNotIn(List<String> values) {
            addCriterion("cardnum not in", values, "cardnum");
            return (Criteria) this;
        }

        public Criteria andCardnumBetween(String value1, String value2) {
            addCriterion("cardnum between", value1, value2, "cardnum");
            return (Criteria) this;
        }

        public Criteria andCardnumNotBetween(String value1, String value2) {
            addCriterion("cardnum not between", value1, value2, "cardnum");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhotoHandIsNull() {
            addCriterion("photo_hand is null");
            return (Criteria) this;
        }

        public Criteria andPhotoHandIsNotNull() {
            addCriterion("photo_hand is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoHandEqualTo(String value) {
            addCriterion("photo_hand =", value, "photoHand");
            return (Criteria) this;
        }

        public Criteria andPhotoHandNotEqualTo(String value) {
            addCriterion("photo_hand <>", value, "photoHand");
            return (Criteria) this;
        }

        public Criteria andPhotoHandGreaterThan(String value) {
            addCriterion("photo_hand >", value, "photoHand");
            return (Criteria) this;
        }

        public Criteria andPhotoHandGreaterThanOrEqualTo(String value) {
            addCriterion("photo_hand >=", value, "photoHand");
            return (Criteria) this;
        }

        public Criteria andPhotoHandLessThan(String value) {
            addCriterion("photo_hand <", value, "photoHand");
            return (Criteria) this;
        }

        public Criteria andPhotoHandLessThanOrEqualTo(String value) {
            addCriterion("photo_hand <=", value, "photoHand");
            return (Criteria) this;
        }

        public Criteria andPhotoHandLike(String value) {
            addCriterion("photo_hand like", value, "photoHand");
            return (Criteria) this;
        }

        public Criteria andPhotoHandNotLike(String value) {
            addCriterion("photo_hand not like", value, "photoHand");
            return (Criteria) this;
        }

        public Criteria andPhotoHandIn(List<String> values) {
            addCriterion("photo_hand in", values, "photoHand");
            return (Criteria) this;
        }

        public Criteria andPhotoHandNotIn(List<String> values) {
            addCriterion("photo_hand not in", values, "photoHand");
            return (Criteria) this;
        }

        public Criteria andPhotoHandBetween(String value1, String value2) {
            addCriterion("photo_hand between", value1, value2, "photoHand");
            return (Criteria) this;
        }

        public Criteria andPhotoHandNotBetween(String value1, String value2) {
            addCriterion("photo_hand not between", value1, value2, "photoHand");
            return (Criteria) this;
        }

        public Criteria andPhotoOnIsNull() {
            addCriterion("photo_on is null");
            return (Criteria) this;
        }

        public Criteria andPhotoOnIsNotNull() {
            addCriterion("photo_on is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoOnEqualTo(String value) {
            addCriterion("photo_on =", value, "photoOn");
            return (Criteria) this;
        }

        public Criteria andPhotoOnNotEqualTo(String value) {
            addCriterion("photo_on <>", value, "photoOn");
            return (Criteria) this;
        }

        public Criteria andPhotoOnGreaterThan(String value) {
            addCriterion("photo_on >", value, "photoOn");
            return (Criteria) this;
        }

        public Criteria andPhotoOnGreaterThanOrEqualTo(String value) {
            addCriterion("photo_on >=", value, "photoOn");
            return (Criteria) this;
        }

        public Criteria andPhotoOnLessThan(String value) {
            addCriterion("photo_on <", value, "photoOn");
            return (Criteria) this;
        }

        public Criteria andPhotoOnLessThanOrEqualTo(String value) {
            addCriterion("photo_on <=", value, "photoOn");
            return (Criteria) this;
        }

        public Criteria andPhotoOnLike(String value) {
            addCriterion("photo_on like", value, "photoOn");
            return (Criteria) this;
        }

        public Criteria andPhotoOnNotLike(String value) {
            addCriterion("photo_on not like", value, "photoOn");
            return (Criteria) this;
        }

        public Criteria andPhotoOnIn(List<String> values) {
            addCriterion("photo_on in", values, "photoOn");
            return (Criteria) this;
        }

        public Criteria andPhotoOnNotIn(List<String> values) {
            addCriterion("photo_on not in", values, "photoOn");
            return (Criteria) this;
        }

        public Criteria andPhotoOnBetween(String value1, String value2) {
            addCriterion("photo_on between", value1, value2, "photoOn");
            return (Criteria) this;
        }

        public Criteria andPhotoOnNotBetween(String value1, String value2) {
            addCriterion("photo_on not between", value1, value2, "photoOn");
            return (Criteria) this;
        }

        public Criteria andPhotoOffIsNull() {
            addCriterion("photo_off is null");
            return (Criteria) this;
        }

        public Criteria andPhotoOffIsNotNull() {
            addCriterion("photo_off is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoOffEqualTo(String value) {
            addCriterion("photo_off =", value, "photoOff");
            return (Criteria) this;
        }

        public Criteria andPhotoOffNotEqualTo(String value) {
            addCriterion("photo_off <>", value, "photoOff");
            return (Criteria) this;
        }

        public Criteria andPhotoOffGreaterThan(String value) {
            addCriterion("photo_off >", value, "photoOff");
            return (Criteria) this;
        }

        public Criteria andPhotoOffGreaterThanOrEqualTo(String value) {
            addCriterion("photo_off >=", value, "photoOff");
            return (Criteria) this;
        }

        public Criteria andPhotoOffLessThan(String value) {
            addCriterion("photo_off <", value, "photoOff");
            return (Criteria) this;
        }

        public Criteria andPhotoOffLessThanOrEqualTo(String value) {
            addCriterion("photo_off <=", value, "photoOff");
            return (Criteria) this;
        }

        public Criteria andPhotoOffLike(String value) {
            addCriterion("photo_off like", value, "photoOff");
            return (Criteria) this;
        }

        public Criteria andPhotoOffNotLike(String value) {
            addCriterion("photo_off not like", value, "photoOff");
            return (Criteria) this;
        }

        public Criteria andPhotoOffIn(List<String> values) {
            addCriterion("photo_off in", values, "photoOff");
            return (Criteria) this;
        }

        public Criteria andPhotoOffNotIn(List<String> values) {
            addCriterion("photo_off not in", values, "photoOff");
            return (Criteria) this;
        }

        public Criteria andPhotoOffBetween(String value1, String value2) {
            addCriterion("photo_off between", value1, value2, "photoOff");
            return (Criteria) this;
        }

        public Criteria andPhotoOffNotBetween(String value1, String value2) {
            addCriterion("photo_off not between", value1, value2, "photoOff");
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