package indi.baojie.supervision.domain;

import java.util.ArrayList;
import java.util.List;

public class MatterTaskResultExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MatterTaskResultExample() {
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

        public Criteria andTaskIdIsNull() {
            addCriterion("task_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNotNull() {
            addCriterion("task_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskIdEqualTo(Integer value) {
            addCriterion("task_id =", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotEqualTo(Integer value) {
            addCriterion("task_id <>", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThan(Integer value) {
            addCriterion("task_id >", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_id >=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThan(Integer value) {
            addCriterion("task_id <", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThanOrEqualTo(Integer value) {
            addCriterion("task_id <=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIn(List<Integer> values) {
            addCriterion("task_id in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotIn(List<Integer> values) {
            addCriterion("task_id not in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdBetween(Integer value1, Integer value2) {
            addCriterion("task_id between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotBetween(Integer value1, Integer value2) {
            addCriterion("task_id not between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andMatterIdIsNull() {
            addCriterion("matter_id is null");
            return (Criteria) this;
        }

        public Criteria andMatterIdIsNotNull() {
            addCriterion("matter_id is not null");
            return (Criteria) this;
        }

        public Criteria andMatterIdEqualTo(Integer value) {
            addCriterion("matter_id =", value, "matterId");
            return (Criteria) this;
        }

        public Criteria andMatterIdNotEqualTo(Integer value) {
            addCriterion("matter_id <>", value, "matterId");
            return (Criteria) this;
        }

        public Criteria andMatterIdGreaterThan(Integer value) {
            addCriterion("matter_id >", value, "matterId");
            return (Criteria) this;
        }

        public Criteria andMatterIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("matter_id >=", value, "matterId");
            return (Criteria) this;
        }

        public Criteria andMatterIdLessThan(Integer value) {
            addCriterion("matter_id <", value, "matterId");
            return (Criteria) this;
        }

        public Criteria andMatterIdLessThanOrEqualTo(Integer value) {
            addCriterion("matter_id <=", value, "matterId");
            return (Criteria) this;
        }

        public Criteria andMatterIdIn(List<Integer> values) {
            addCriterion("matter_id in", values, "matterId");
            return (Criteria) this;
        }

        public Criteria andMatterIdNotIn(List<Integer> values) {
            addCriterion("matter_id not in", values, "matterId");
            return (Criteria) this;
        }

        public Criteria andMatterIdBetween(Integer value1, Integer value2) {
            addCriterion("matter_id between", value1, value2, "matterId");
            return (Criteria) this;
        }

        public Criteria andMatterIdNotBetween(Integer value1, Integer value2) {
            addCriterion("matter_id not between", value1, value2, "matterId");
            return (Criteria) this;
        }

        public Criteria andExecutionIdIsNull() {
            addCriterion("execution_id is null");
            return (Criteria) this;
        }

        public Criteria andExecutionIdIsNotNull() {
            addCriterion("execution_id is not null");
            return (Criteria) this;
        }

        public Criteria andExecutionIdEqualTo(Integer value) {
            addCriterion("execution_id =", value, "executionId");
            return (Criteria) this;
        }

        public Criteria andExecutionIdNotEqualTo(Integer value) {
            addCriterion("execution_id <>", value, "executionId");
            return (Criteria) this;
        }

        public Criteria andExecutionIdGreaterThan(Integer value) {
            addCriterion("execution_id >", value, "executionId");
            return (Criteria) this;
        }

        public Criteria andExecutionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("execution_id >=", value, "executionId");
            return (Criteria) this;
        }

        public Criteria andExecutionIdLessThan(Integer value) {
            addCriterion("execution_id <", value, "executionId");
            return (Criteria) this;
        }

        public Criteria andExecutionIdLessThanOrEqualTo(Integer value) {
            addCriterion("execution_id <=", value, "executionId");
            return (Criteria) this;
        }

        public Criteria andExecutionIdIn(List<Integer> values) {
            addCriterion("execution_id in", values, "executionId");
            return (Criteria) this;
        }

        public Criteria andExecutionIdNotIn(List<Integer> values) {
            addCriterion("execution_id not in", values, "executionId");
            return (Criteria) this;
        }

        public Criteria andExecutionIdBetween(Integer value1, Integer value2) {
            addCriterion("execution_id between", value1, value2, "executionId");
            return (Criteria) this;
        }

        public Criteria andExecutionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("execution_id not between", value1, value2, "executionId");
            return (Criteria) this;
        }

        public Criteria andOrganizerIdIsNull() {
            addCriterion("organizer_id is null");
            return (Criteria) this;
        }

        public Criteria andOrganizerIdIsNotNull() {
            addCriterion("organizer_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizerIdEqualTo(Integer value) {
            addCriterion("organizer_id =", value, "organizerId");
            return (Criteria) this;
        }

        public Criteria andOrganizerIdNotEqualTo(Integer value) {
            addCriterion("organizer_id <>", value, "organizerId");
            return (Criteria) this;
        }

        public Criteria andOrganizerIdGreaterThan(Integer value) {
            addCriterion("organizer_id >", value, "organizerId");
            return (Criteria) this;
        }

        public Criteria andOrganizerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("organizer_id >=", value, "organizerId");
            return (Criteria) this;
        }

        public Criteria andOrganizerIdLessThan(Integer value) {
            addCriterion("organizer_id <", value, "organizerId");
            return (Criteria) this;
        }

        public Criteria andOrganizerIdLessThanOrEqualTo(Integer value) {
            addCriterion("organizer_id <=", value, "organizerId");
            return (Criteria) this;
        }

        public Criteria andOrganizerIdIn(List<Integer> values) {
            addCriterion("organizer_id in", values, "organizerId");
            return (Criteria) this;
        }

        public Criteria andOrganizerIdNotIn(List<Integer> values) {
            addCriterion("organizer_id not in", values, "organizerId");
            return (Criteria) this;
        }

        public Criteria andOrganizerIdBetween(Integer value1, Integer value2) {
            addCriterion("organizer_id between", value1, value2, "organizerId");
            return (Criteria) this;
        }

        public Criteria andOrganizerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("organizer_id not between", value1, value2, "organizerId");
            return (Criteria) this;
        }

        public Criteria andOrganizerNameIsNull() {
            addCriterion("organizer_name is null");
            return (Criteria) this;
        }

        public Criteria andOrganizerNameIsNotNull() {
            addCriterion("organizer_name is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizerNameEqualTo(String value) {
            addCriterion("organizer_name =", value, "organizerName");
            return (Criteria) this;
        }

        public Criteria andOrganizerNameNotEqualTo(String value) {
            addCriterion("organizer_name <>", value, "organizerName");
            return (Criteria) this;
        }

        public Criteria andOrganizerNameGreaterThan(String value) {
            addCriterion("organizer_name >", value, "organizerName");
            return (Criteria) this;
        }

        public Criteria andOrganizerNameGreaterThanOrEqualTo(String value) {
            addCriterion("organizer_name >=", value, "organizerName");
            return (Criteria) this;
        }

        public Criteria andOrganizerNameLessThan(String value) {
            addCriterion("organizer_name <", value, "organizerName");
            return (Criteria) this;
        }

        public Criteria andOrganizerNameLessThanOrEqualTo(String value) {
            addCriterion("organizer_name <=", value, "organizerName");
            return (Criteria) this;
        }

        public Criteria andOrganizerNameLike(String value) {
            addCriterion("organizer_name like", value, "organizerName");
            return (Criteria) this;
        }

        public Criteria andOrganizerNameNotLike(String value) {
            addCriterion("organizer_name not like", value, "organizerName");
            return (Criteria) this;
        }

        public Criteria andOrganizerNameIn(List<String> values) {
            addCriterion("organizer_name in", values, "organizerName");
            return (Criteria) this;
        }

        public Criteria andOrganizerNameNotIn(List<String> values) {
            addCriterion("organizer_name not in", values, "organizerName");
            return (Criteria) this;
        }

        public Criteria andOrganizerNameBetween(String value1, String value2) {
            addCriterion("organizer_name between", value1, value2, "organizerName");
            return (Criteria) this;
        }

        public Criteria andOrganizerNameNotBetween(String value1, String value2) {
            addCriterion("organizer_name not between", value1, value2, "organizerName");
            return (Criteria) this;
        }

        public Criteria andSignPersonIdIsNull() {
            addCriterion("sign_person_id is null");
            return (Criteria) this;
        }

        public Criteria andSignPersonIdIsNotNull() {
            addCriterion("sign_person_id is not null");
            return (Criteria) this;
        }

        public Criteria andSignPersonIdEqualTo(Integer value) {
            addCriterion("sign_person_id =", value, "signPersonId");
            return (Criteria) this;
        }

        public Criteria andSignPersonIdNotEqualTo(Integer value) {
            addCriterion("sign_person_id <>", value, "signPersonId");
            return (Criteria) this;
        }

        public Criteria andSignPersonIdGreaterThan(Integer value) {
            addCriterion("sign_person_id >", value, "signPersonId");
            return (Criteria) this;
        }

        public Criteria andSignPersonIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sign_person_id >=", value, "signPersonId");
            return (Criteria) this;
        }

        public Criteria andSignPersonIdLessThan(Integer value) {
            addCriterion("sign_person_id <", value, "signPersonId");
            return (Criteria) this;
        }

        public Criteria andSignPersonIdLessThanOrEqualTo(Integer value) {
            addCriterion("sign_person_id <=", value, "signPersonId");
            return (Criteria) this;
        }

        public Criteria andSignPersonIdIn(List<Integer> values) {
            addCriterion("sign_person_id in", values, "signPersonId");
            return (Criteria) this;
        }

        public Criteria andSignPersonIdNotIn(List<Integer> values) {
            addCriterion("sign_person_id not in", values, "signPersonId");
            return (Criteria) this;
        }

        public Criteria andSignPersonIdBetween(Integer value1, Integer value2) {
            addCriterion("sign_person_id between", value1, value2, "signPersonId");
            return (Criteria) this;
        }

        public Criteria andSignPersonIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sign_person_id not between", value1, value2, "signPersonId");
            return (Criteria) this;
        }

        public Criteria andSignPersonNameIsNull() {
            addCriterion("sign_person_name is null");
            return (Criteria) this;
        }

        public Criteria andSignPersonNameIsNotNull() {
            addCriterion("sign_person_name is not null");
            return (Criteria) this;
        }

        public Criteria andSignPersonNameEqualTo(String value) {
            addCriterion("sign_person_name =", value, "signPersonName");
            return (Criteria) this;
        }

        public Criteria andSignPersonNameNotEqualTo(String value) {
            addCriterion("sign_person_name <>", value, "signPersonName");
            return (Criteria) this;
        }

        public Criteria andSignPersonNameGreaterThan(String value) {
            addCriterion("sign_person_name >", value, "signPersonName");
            return (Criteria) this;
        }

        public Criteria andSignPersonNameGreaterThanOrEqualTo(String value) {
            addCriterion("sign_person_name >=", value, "signPersonName");
            return (Criteria) this;
        }

        public Criteria andSignPersonNameLessThan(String value) {
            addCriterion("sign_person_name <", value, "signPersonName");
            return (Criteria) this;
        }

        public Criteria andSignPersonNameLessThanOrEqualTo(String value) {
            addCriterion("sign_person_name <=", value, "signPersonName");
            return (Criteria) this;
        }

        public Criteria andSignPersonNameLike(String value) {
            addCriterion("sign_person_name like", value, "signPersonName");
            return (Criteria) this;
        }

        public Criteria andSignPersonNameNotLike(String value) {
            addCriterion("sign_person_name not like", value, "signPersonName");
            return (Criteria) this;
        }

        public Criteria andSignPersonNameIn(List<String> values) {
            addCriterion("sign_person_name in", values, "signPersonName");
            return (Criteria) this;
        }

        public Criteria andSignPersonNameNotIn(List<String> values) {
            addCriterion("sign_person_name not in", values, "signPersonName");
            return (Criteria) this;
        }

        public Criteria andSignPersonNameBetween(String value1, String value2) {
            addCriterion("sign_person_name between", value1, value2, "signPersonName");
            return (Criteria) this;
        }

        public Criteria andSignPersonNameNotBetween(String value1, String value2) {
            addCriterion("sign_person_name not between", value1, value2, "signPersonName");
            return (Criteria) this;
        }

        public Criteria andSignTimeIsNull() {
            addCriterion("sign_time is null");
            return (Criteria) this;
        }

        public Criteria andSignTimeIsNotNull() {
            addCriterion("sign_time is not null");
            return (Criteria) this;
        }

        public Criteria andSignTimeEqualTo(String value) {
            addCriterion("sign_time =", value, "signTime");
            return (Criteria) this;
        }

        public Criteria andSignTimeNotEqualTo(String value) {
            addCriterion("sign_time <>", value, "signTime");
            return (Criteria) this;
        }

        public Criteria andSignTimeGreaterThan(String value) {
            addCriterion("sign_time >", value, "signTime");
            return (Criteria) this;
        }

        public Criteria andSignTimeGreaterThanOrEqualTo(String value) {
            addCriterion("sign_time >=", value, "signTime");
            return (Criteria) this;
        }

        public Criteria andSignTimeLessThan(String value) {
            addCriterion("sign_time <", value, "signTime");
            return (Criteria) this;
        }

        public Criteria andSignTimeLessThanOrEqualTo(String value) {
            addCriterion("sign_time <=", value, "signTime");
            return (Criteria) this;
        }

        public Criteria andSignTimeLike(String value) {
            addCriterion("sign_time like", value, "signTime");
            return (Criteria) this;
        }

        public Criteria andSignTimeNotLike(String value) {
            addCriterion("sign_time not like", value, "signTime");
            return (Criteria) this;
        }

        public Criteria andSignTimeIn(List<String> values) {
            addCriterion("sign_time in", values, "signTime");
            return (Criteria) this;
        }

        public Criteria andSignTimeNotIn(List<String> values) {
            addCriterion("sign_time not in", values, "signTime");
            return (Criteria) this;
        }

        public Criteria andSignTimeBetween(String value1, String value2) {
            addCriterion("sign_time between", value1, value2, "signTime");
            return (Criteria) this;
        }

        public Criteria andSignTimeNotBetween(String value1, String value2) {
            addCriterion("sign_time not between", value1, value2, "signTime");
            return (Criteria) this;
        }

        public Criteria andFeedbackPersonIdIsNull() {
            addCriterion("feedback_person_id is null");
            return (Criteria) this;
        }

        public Criteria andFeedbackPersonIdIsNotNull() {
            addCriterion("feedback_person_id is not null");
            return (Criteria) this;
        }

        public Criteria andFeedbackPersonIdEqualTo(Integer value) {
            addCriterion("feedback_person_id =", value, "feedbackPersonId");
            return (Criteria) this;
        }

        public Criteria andFeedbackPersonIdNotEqualTo(Integer value) {
            addCriterion("feedback_person_id <>", value, "feedbackPersonId");
            return (Criteria) this;
        }

        public Criteria andFeedbackPersonIdGreaterThan(Integer value) {
            addCriterion("feedback_person_id >", value, "feedbackPersonId");
            return (Criteria) this;
        }

        public Criteria andFeedbackPersonIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("feedback_person_id >=", value, "feedbackPersonId");
            return (Criteria) this;
        }

        public Criteria andFeedbackPersonIdLessThan(Integer value) {
            addCriterion("feedback_person_id <", value, "feedbackPersonId");
            return (Criteria) this;
        }

        public Criteria andFeedbackPersonIdLessThanOrEqualTo(Integer value) {
            addCriterion("feedback_person_id <=", value, "feedbackPersonId");
            return (Criteria) this;
        }

        public Criteria andFeedbackPersonIdIn(List<Integer> values) {
            addCriterion("feedback_person_id in", values, "feedbackPersonId");
            return (Criteria) this;
        }

        public Criteria andFeedbackPersonIdNotIn(List<Integer> values) {
            addCriterion("feedback_person_id not in", values, "feedbackPersonId");
            return (Criteria) this;
        }

        public Criteria andFeedbackPersonIdBetween(Integer value1, Integer value2) {
            addCriterion("feedback_person_id between", value1, value2, "feedbackPersonId");
            return (Criteria) this;
        }

        public Criteria andFeedbackPersonIdNotBetween(Integer value1, Integer value2) {
            addCriterion("feedback_person_id not between", value1, value2, "feedbackPersonId");
            return (Criteria) this;
        }

        public Criteria andFeedbackPersonNameIsNull() {
            addCriterion("feedback_person_name is null");
            return (Criteria) this;
        }

        public Criteria andFeedbackPersonNameIsNotNull() {
            addCriterion("feedback_person_name is not null");
            return (Criteria) this;
        }

        public Criteria andFeedbackPersonNameEqualTo(String value) {
            addCriterion("feedback_person_name =", value, "feedbackPersonName");
            return (Criteria) this;
        }

        public Criteria andFeedbackPersonNameNotEqualTo(String value) {
            addCriterion("feedback_person_name <>", value, "feedbackPersonName");
            return (Criteria) this;
        }

        public Criteria andFeedbackPersonNameGreaterThan(String value) {
            addCriterion("feedback_person_name >", value, "feedbackPersonName");
            return (Criteria) this;
        }

        public Criteria andFeedbackPersonNameGreaterThanOrEqualTo(String value) {
            addCriterion("feedback_person_name >=", value, "feedbackPersonName");
            return (Criteria) this;
        }

        public Criteria andFeedbackPersonNameLessThan(String value) {
            addCriterion("feedback_person_name <", value, "feedbackPersonName");
            return (Criteria) this;
        }

        public Criteria andFeedbackPersonNameLessThanOrEqualTo(String value) {
            addCriterion("feedback_person_name <=", value, "feedbackPersonName");
            return (Criteria) this;
        }

        public Criteria andFeedbackPersonNameLike(String value) {
            addCriterion("feedback_person_name like", value, "feedbackPersonName");
            return (Criteria) this;
        }

        public Criteria andFeedbackPersonNameNotLike(String value) {
            addCriterion("feedback_person_name not like", value, "feedbackPersonName");
            return (Criteria) this;
        }

        public Criteria andFeedbackPersonNameIn(List<String> values) {
            addCriterion("feedback_person_name in", values, "feedbackPersonName");
            return (Criteria) this;
        }

        public Criteria andFeedbackPersonNameNotIn(List<String> values) {
            addCriterion("feedback_person_name not in", values, "feedbackPersonName");
            return (Criteria) this;
        }

        public Criteria andFeedbackPersonNameBetween(String value1, String value2) {
            addCriterion("feedback_person_name between", value1, value2, "feedbackPersonName");
            return (Criteria) this;
        }

        public Criteria andFeedbackPersonNameNotBetween(String value1, String value2) {
            addCriterion("feedback_person_name not between", value1, value2, "feedbackPersonName");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeIsNull() {
            addCriterion("feedback_time is null");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeIsNotNull() {
            addCriterion("feedback_time is not null");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeEqualTo(String value) {
            addCriterion("feedback_time =", value, "feedbackTime");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeNotEqualTo(String value) {
            addCriterion("feedback_time <>", value, "feedbackTime");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeGreaterThan(String value) {
            addCriterion("feedback_time >", value, "feedbackTime");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeGreaterThanOrEqualTo(String value) {
            addCriterion("feedback_time >=", value, "feedbackTime");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeLessThan(String value) {
            addCriterion("feedback_time <", value, "feedbackTime");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeLessThanOrEqualTo(String value) {
            addCriterion("feedback_time <=", value, "feedbackTime");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeLike(String value) {
            addCriterion("feedback_time like", value, "feedbackTime");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeNotLike(String value) {
            addCriterion("feedback_time not like", value, "feedbackTime");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeIn(List<String> values) {
            addCriterion("feedback_time in", values, "feedbackTime");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeNotIn(List<String> values) {
            addCriterion("feedback_time not in", values, "feedbackTime");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeBetween(String value1, String value2) {
            addCriterion("feedback_time between", value1, value2, "feedbackTime");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeNotBetween(String value1, String value2) {
            addCriterion("feedback_time not between", value1, value2, "feedbackTime");
            return (Criteria) this;
        }

        public Criteria andReportPersonIdIsNull() {
            addCriterion("report_person_id is null");
            return (Criteria) this;
        }

        public Criteria andReportPersonIdIsNotNull() {
            addCriterion("report_person_id is not null");
            return (Criteria) this;
        }

        public Criteria andReportPersonIdEqualTo(Integer value) {
            addCriterion("report_person_id =", value, "reportPersonId");
            return (Criteria) this;
        }

        public Criteria andReportPersonIdNotEqualTo(Integer value) {
            addCriterion("report_person_id <>", value, "reportPersonId");
            return (Criteria) this;
        }

        public Criteria andReportPersonIdGreaterThan(Integer value) {
            addCriterion("report_person_id >", value, "reportPersonId");
            return (Criteria) this;
        }

        public Criteria andReportPersonIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("report_person_id >=", value, "reportPersonId");
            return (Criteria) this;
        }

        public Criteria andReportPersonIdLessThan(Integer value) {
            addCriterion("report_person_id <", value, "reportPersonId");
            return (Criteria) this;
        }

        public Criteria andReportPersonIdLessThanOrEqualTo(Integer value) {
            addCriterion("report_person_id <=", value, "reportPersonId");
            return (Criteria) this;
        }

        public Criteria andReportPersonIdIn(List<Integer> values) {
            addCriterion("report_person_id in", values, "reportPersonId");
            return (Criteria) this;
        }

        public Criteria andReportPersonIdNotIn(List<Integer> values) {
            addCriterion("report_person_id not in", values, "reportPersonId");
            return (Criteria) this;
        }

        public Criteria andReportPersonIdBetween(Integer value1, Integer value2) {
            addCriterion("report_person_id between", value1, value2, "reportPersonId");
            return (Criteria) this;
        }

        public Criteria andReportPersonIdNotBetween(Integer value1, Integer value2) {
            addCriterion("report_person_id not between", value1, value2, "reportPersonId");
            return (Criteria) this;
        }

        public Criteria andReportPersonNameIsNull() {
            addCriterion("report_person_name is null");
            return (Criteria) this;
        }

        public Criteria andReportPersonNameIsNotNull() {
            addCriterion("report_person_name is not null");
            return (Criteria) this;
        }

        public Criteria andReportPersonNameEqualTo(String value) {
            addCriterion("report_person_name =", value, "reportPersonName");
            return (Criteria) this;
        }

        public Criteria andReportPersonNameNotEqualTo(String value) {
            addCriterion("report_person_name <>", value, "reportPersonName");
            return (Criteria) this;
        }

        public Criteria andReportPersonNameGreaterThan(String value) {
            addCriterion("report_person_name >", value, "reportPersonName");
            return (Criteria) this;
        }

        public Criteria andReportPersonNameGreaterThanOrEqualTo(String value) {
            addCriterion("report_person_name >=", value, "reportPersonName");
            return (Criteria) this;
        }

        public Criteria andReportPersonNameLessThan(String value) {
            addCriterion("report_person_name <", value, "reportPersonName");
            return (Criteria) this;
        }

        public Criteria andReportPersonNameLessThanOrEqualTo(String value) {
            addCriterion("report_person_name <=", value, "reportPersonName");
            return (Criteria) this;
        }

        public Criteria andReportPersonNameLike(String value) {
            addCriterion("report_person_name like", value, "reportPersonName");
            return (Criteria) this;
        }

        public Criteria andReportPersonNameNotLike(String value) {
            addCriterion("report_person_name not like", value, "reportPersonName");
            return (Criteria) this;
        }

        public Criteria andReportPersonNameIn(List<String> values) {
            addCriterion("report_person_name in", values, "reportPersonName");
            return (Criteria) this;
        }

        public Criteria andReportPersonNameNotIn(List<String> values) {
            addCriterion("report_person_name not in", values, "reportPersonName");
            return (Criteria) this;
        }

        public Criteria andReportPersonNameBetween(String value1, String value2) {
            addCriterion("report_person_name between", value1, value2, "reportPersonName");
            return (Criteria) this;
        }

        public Criteria andReportPersonNameNotBetween(String value1, String value2) {
            addCriterion("report_person_name not between", value1, value2, "reportPersonName");
            return (Criteria) this;
        }

        public Criteria andReportTimeIsNull() {
            addCriterion("report_time is null");
            return (Criteria) this;
        }

        public Criteria andReportTimeIsNotNull() {
            addCriterion("report_time is not null");
            return (Criteria) this;
        }

        public Criteria andReportTimeEqualTo(String value) {
            addCriterion("report_time =", value, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeNotEqualTo(String value) {
            addCriterion("report_time <>", value, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeGreaterThan(String value) {
            addCriterion("report_time >", value, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeGreaterThanOrEqualTo(String value) {
            addCriterion("report_time >=", value, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeLessThan(String value) {
            addCriterion("report_time <", value, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeLessThanOrEqualTo(String value) {
            addCriterion("report_time <=", value, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeLike(String value) {
            addCriterion("report_time like", value, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeNotLike(String value) {
            addCriterion("report_time not like", value, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeIn(List<String> values) {
            addCriterion("report_time in", values, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeNotIn(List<String> values) {
            addCriterion("report_time not in", values, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeBetween(String value1, String value2) {
            addCriterion("report_time between", value1, value2, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeNotBetween(String value1, String value2) {
            addCriterion("report_time not between", value1, value2, "reportTime");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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