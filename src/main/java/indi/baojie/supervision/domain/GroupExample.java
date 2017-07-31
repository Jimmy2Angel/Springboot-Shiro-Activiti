package indi.baojie.supervision.domain;

import java.util.ArrayList;
import java.util.List;

public class GroupExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GroupExample() {
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

        public Criteria andOrgNameIsNull() {
            addCriterion("org_name is null");
            return (Criteria) this;
        }

        public Criteria andOrgNameIsNotNull() {
            addCriterion("org_name is not null");
            return (Criteria) this;
        }

        public Criteria andOrgNameEqualTo(String value) {
            addCriterion("org_name =", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotEqualTo(String value) {
            addCriterion("org_name <>", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameGreaterThan(String value) {
            addCriterion("org_name >", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameGreaterThanOrEqualTo(String value) {
            addCriterion("org_name >=", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameLessThan(String value) {
            addCriterion("org_name <", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameLessThanOrEqualTo(String value) {
            addCriterion("org_name <=", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameLike(String value) {
            addCriterion("org_name like", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotLike(String value) {
            addCriterion("org_name not like", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameIn(List<String> values) {
            addCriterion("org_name in", values, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotIn(List<String> values) {
            addCriterion("org_name not in", values, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameBetween(String value1, String value2) {
            addCriterion("org_name between", value1, value2, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotBetween(String value1, String value2) {
            addCriterion("org_name not between", value1, value2, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgCodeIsNull() {
            addCriterion("org_code is null");
            return (Criteria) this;
        }

        public Criteria andOrgCodeIsNotNull() {
            addCriterion("org_code is not null");
            return (Criteria) this;
        }

        public Criteria andOrgCodeEqualTo(String value) {
            addCriterion("org_code =", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeNotEqualTo(String value) {
            addCriterion("org_code <>", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeGreaterThan(String value) {
            addCriterion("org_code >", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeGreaterThanOrEqualTo(String value) {
            addCriterion("org_code >=", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeLessThan(String value) {
            addCriterion("org_code <", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeLessThanOrEqualTo(String value) {
            addCriterion("org_code <=", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeLike(String value) {
            addCriterion("org_code like", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeNotLike(String value) {
            addCriterion("org_code not like", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeIn(List<String> values) {
            addCriterion("org_code in", values, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeNotIn(List<String> values) {
            addCriterion("org_code not in", values, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeBetween(String value1, String value2) {
            addCriterion("org_code between", value1, value2, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeNotBetween(String value1, String value2) {
            addCriterion("org_code not between", value1, value2, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgSortCodeIsNull() {
            addCriterion("org_sort_code is null");
            return (Criteria) this;
        }

        public Criteria andOrgSortCodeIsNotNull() {
            addCriterion("org_sort_code is not null");
            return (Criteria) this;
        }

        public Criteria andOrgSortCodeEqualTo(String value) {
            addCriterion("org_sort_code =", value, "orgSortCode");
            return (Criteria) this;
        }

        public Criteria andOrgSortCodeNotEqualTo(String value) {
            addCriterion("org_sort_code <>", value, "orgSortCode");
            return (Criteria) this;
        }

        public Criteria andOrgSortCodeGreaterThan(String value) {
            addCriterion("org_sort_code >", value, "orgSortCode");
            return (Criteria) this;
        }

        public Criteria andOrgSortCodeGreaterThanOrEqualTo(String value) {
            addCriterion("org_sort_code >=", value, "orgSortCode");
            return (Criteria) this;
        }

        public Criteria andOrgSortCodeLessThan(String value) {
            addCriterion("org_sort_code <", value, "orgSortCode");
            return (Criteria) this;
        }

        public Criteria andOrgSortCodeLessThanOrEqualTo(String value) {
            addCriterion("org_sort_code <=", value, "orgSortCode");
            return (Criteria) this;
        }

        public Criteria andOrgSortCodeLike(String value) {
            addCriterion("org_sort_code like", value, "orgSortCode");
            return (Criteria) this;
        }

        public Criteria andOrgSortCodeNotLike(String value) {
            addCriterion("org_sort_code not like", value, "orgSortCode");
            return (Criteria) this;
        }

        public Criteria andOrgSortCodeIn(List<String> values) {
            addCriterion("org_sort_code in", values, "orgSortCode");
            return (Criteria) this;
        }

        public Criteria andOrgSortCodeNotIn(List<String> values) {
            addCriterion("org_sort_code not in", values, "orgSortCode");
            return (Criteria) this;
        }

        public Criteria andOrgSortCodeBetween(String value1, String value2) {
            addCriterion("org_sort_code between", value1, value2, "orgSortCode");
            return (Criteria) this;
        }

        public Criteria andOrgSortCodeNotBetween(String value1, String value2) {
            addCriterion("org_sort_code not between", value1, value2, "orgSortCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeIsNull() {
            addCriterion("parent_code is null");
            return (Criteria) this;
        }

        public Criteria andParentCodeIsNotNull() {
            addCriterion("parent_code is not null");
            return (Criteria) this;
        }

        public Criteria andParentCodeEqualTo(String value) {
            addCriterion("parent_code =", value, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeNotEqualTo(String value) {
            addCriterion("parent_code <>", value, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeGreaterThan(String value) {
            addCriterion("parent_code >", value, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeGreaterThanOrEqualTo(String value) {
            addCriterion("parent_code >=", value, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeLessThan(String value) {
            addCriterion("parent_code <", value, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeLessThanOrEqualTo(String value) {
            addCriterion("parent_code <=", value, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeLike(String value) {
            addCriterion("parent_code like", value, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeNotLike(String value) {
            addCriterion("parent_code not like", value, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeIn(List<String> values) {
            addCriterion("parent_code in", values, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeNotIn(List<String> values) {
            addCriterion("parent_code not in", values, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeBetween(String value1, String value2) {
            addCriterion("parent_code between", value1, value2, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeNotBetween(String value1, String value2) {
            addCriterion("parent_code not between", value1, value2, "parentCode");
            return (Criteria) this;
        }

        public Criteria andOrgPostalcodeIsNull() {
            addCriterion("org_postalcode is null");
            return (Criteria) this;
        }

        public Criteria andOrgPostalcodeIsNotNull() {
            addCriterion("org_postalcode is not null");
            return (Criteria) this;
        }

        public Criteria andOrgPostalcodeEqualTo(String value) {
            addCriterion("org_postalcode =", value, "orgPostalcode");
            return (Criteria) this;
        }

        public Criteria andOrgPostalcodeNotEqualTo(String value) {
            addCriterion("org_postalcode <>", value, "orgPostalcode");
            return (Criteria) this;
        }

        public Criteria andOrgPostalcodeGreaterThan(String value) {
            addCriterion("org_postalcode >", value, "orgPostalcode");
            return (Criteria) this;
        }

        public Criteria andOrgPostalcodeGreaterThanOrEqualTo(String value) {
            addCriterion("org_postalcode >=", value, "orgPostalcode");
            return (Criteria) this;
        }

        public Criteria andOrgPostalcodeLessThan(String value) {
            addCriterion("org_postalcode <", value, "orgPostalcode");
            return (Criteria) this;
        }

        public Criteria andOrgPostalcodeLessThanOrEqualTo(String value) {
            addCriterion("org_postalcode <=", value, "orgPostalcode");
            return (Criteria) this;
        }

        public Criteria andOrgPostalcodeLike(String value) {
            addCriterion("org_postalcode like", value, "orgPostalcode");
            return (Criteria) this;
        }

        public Criteria andOrgPostalcodeNotLike(String value) {
            addCriterion("org_postalcode not like", value, "orgPostalcode");
            return (Criteria) this;
        }

        public Criteria andOrgPostalcodeIn(List<String> values) {
            addCriterion("org_postalcode in", values, "orgPostalcode");
            return (Criteria) this;
        }

        public Criteria andOrgPostalcodeNotIn(List<String> values) {
            addCriterion("org_postalcode not in", values, "orgPostalcode");
            return (Criteria) this;
        }

        public Criteria andOrgPostalcodeBetween(String value1, String value2) {
            addCriterion("org_postalcode between", value1, value2, "orgPostalcode");
            return (Criteria) this;
        }

        public Criteria andOrgPostalcodeNotBetween(String value1, String value2) {
            addCriterion("org_postalcode not between", value1, value2, "orgPostalcode");
            return (Criteria) this;
        }

        public Criteria andOrgPhoneIsNull() {
            addCriterion("org_phone is null");
            return (Criteria) this;
        }

        public Criteria andOrgPhoneIsNotNull() {
            addCriterion("org_phone is not null");
            return (Criteria) this;
        }

        public Criteria andOrgPhoneEqualTo(String value) {
            addCriterion("org_phone =", value, "orgPhone");
            return (Criteria) this;
        }

        public Criteria andOrgPhoneNotEqualTo(String value) {
            addCriterion("org_phone <>", value, "orgPhone");
            return (Criteria) this;
        }

        public Criteria andOrgPhoneGreaterThan(String value) {
            addCriterion("org_phone >", value, "orgPhone");
            return (Criteria) this;
        }

        public Criteria andOrgPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("org_phone >=", value, "orgPhone");
            return (Criteria) this;
        }

        public Criteria andOrgPhoneLessThan(String value) {
            addCriterion("org_phone <", value, "orgPhone");
            return (Criteria) this;
        }

        public Criteria andOrgPhoneLessThanOrEqualTo(String value) {
            addCriterion("org_phone <=", value, "orgPhone");
            return (Criteria) this;
        }

        public Criteria andOrgPhoneLike(String value) {
            addCriterion("org_phone like", value, "orgPhone");
            return (Criteria) this;
        }

        public Criteria andOrgPhoneNotLike(String value) {
            addCriterion("org_phone not like", value, "orgPhone");
            return (Criteria) this;
        }

        public Criteria andOrgPhoneIn(List<String> values) {
            addCriterion("org_phone in", values, "orgPhone");
            return (Criteria) this;
        }

        public Criteria andOrgPhoneNotIn(List<String> values) {
            addCriterion("org_phone not in", values, "orgPhone");
            return (Criteria) this;
        }

        public Criteria andOrgPhoneBetween(String value1, String value2) {
            addCriterion("org_phone between", value1, value2, "orgPhone");
            return (Criteria) this;
        }

        public Criteria andOrgPhoneNotBetween(String value1, String value2) {
            addCriterion("org_phone not between", value1, value2, "orgPhone");
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