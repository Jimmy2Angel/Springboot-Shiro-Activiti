package indi.baojie.demo.supervision.domain;

import org.activiti.engine.runtime.ProcessInstance;

public class Matter {
    private Integer id;

    private String serviceCode;

    private String oldCode;

    private Integer type;

    private Integer category;

    private String title;

    private String summary;

    private Integer requireInstruction;

    private Integer attachmentId;

    private String remark;

    private String unitIds;

    private String unitNames;

    private String deadline;

    private Integer registrant;

    private String regTime;

    private Integer state;

    private Integer deleted;

    private String processInstanceId;

    private ProcessInstance processInstance;

    public ProcessInstance getProcessInstance() {
        return processInstance;
    }

    public void setProcessInstance(ProcessInstance processInstance) {
        this.processInstance = processInstance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode == null ? null : serviceCode.trim();
    }

    public String getOldCode() {
        return oldCode;
    }

    public void setOldCode(String oldCode) {
        this.oldCode = oldCode == null ? null : oldCode.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public Integer getRequireInstruction() {
        return requireInstruction;
    }

    public void setRequireInstruction(Integer requireInstruction) {
        this.requireInstruction = requireInstruction;
    }

    public Integer getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(Integer attachmentId) {
        this.attachmentId = attachmentId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getUnitIds() {
        return unitIds;
    }

    public void setUnitIds(String unitIds) {
        this.unitIds = unitIds == null ? null : unitIds.trim();
    }

    public String getUnitNames() {
        return unitNames;
    }

    public void setUnitNames(String unitNames) {
        this.unitNames = unitNames == null ? null : unitNames.trim();
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline == null ? null : deadline.trim();
    }

    public Integer getRegistrant() {
        return registrant;
    }

    public void setRegistrant(Integer registrant) {
        this.registrant = registrant;
    }

    public String getRegTime() {
        return regTime;
    }

    public void setRegTime(String regTime) {
        this.regTime = regTime == null ? null : regTime.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId == null ? null : processInstanceId.trim();
    }
}