package indi.baojie.supervision.domain;

public class MatterTaskResult {
    private Integer id;

    private Integer taskId;

    private Integer matterId;

    private Integer executionId;

    private Integer organizerId;

    private String organizerName;

    private Integer signPersonId;

    private String signPersonName;

    private String signTime;

    private Integer feedbackPersonId;

    private String feedbackPersonName;

    private String feedbackTime;

    private Integer reportPersonId;

    private String reportPersonName;

    private String reportTime;

    private String remark;

    private Matter matter;

    private MatterTask matterTask;

    private Feedback feedback;

    private Report report;

    private Integer state;

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }

    public MatterTask getMatterTask() {
        return matterTask;
    }

    public void setMatterTask(MatterTask matterTask) {
        this.matterTask = matterTask;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Integer getMatterId() {
        return matterId;
    }

    public void setMatterId(Integer matterId) {
        this.matterId = matterId;
    }

    public Integer getOrganizerId() {
        return organizerId;
    }

    public void setOrganizerId(Integer organizerId) {
        this.organizerId = organizerId;
    }

    public String getOrganizerName() {
        return organizerName;
    }

    public void setOrganizerName(String organizerName) {
        this.organizerName = organizerName == null ? null : organizerName.trim();
    }

    public Integer getSignPersonId() {
        return signPersonId;
    }

    public void setSignPersonId(Integer signPersonId) {
        this.signPersonId = signPersonId;
    }

    public String getSignPersonName() {
        return signPersonName;
    }

    public void setSignPersonName(String signPersonName) {
        this.signPersonName = signPersonName == null ? null : signPersonName.trim();
    }

    public String getSignTime() {
        return signTime;
    }

    public void setSignTime(String signTime) {
        this.signTime = signTime == null ? null : signTime.trim();
    }

    public Integer getFeedbackPersonId() {
        return feedbackPersonId;
    }

    public void setFeedbackPersonId(Integer feedbackPersonId) {
        this.feedbackPersonId = feedbackPersonId;
    }

    public String getFeedbackPersonName() {
        return feedbackPersonName;
    }

    public void setFeedbackPersonName(String feedbackPersonName) {
        this.feedbackPersonName = feedbackPersonName == null ? null : feedbackPersonName.trim();
    }

    public String getFeedbackTime() {
        return feedbackTime;
    }

    public void setFeedbackTime(String feedbackTime) {
        this.feedbackTime = feedbackTime == null ? null : feedbackTime.trim();
    }

    public Integer getReportPersonId() {
        return reportPersonId;
    }

    public void setReportPersonId(Integer reportPersonId) {
        this.reportPersonId = reportPersonId;
    }

    public String getReportPersonName() {
        return reportPersonName;
    }

    public void setReportPersonName(String reportPersonName) {
        this.reportPersonName = reportPersonName == null ? null : reportPersonName.trim();
    }

    public String getReportTime() {
        return reportTime;
    }

    public void setReportTime(String reportTime) {
        this.reportTime = reportTime == null ? null : reportTime.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getExecutionId() {
        return executionId;
    }

    public void setExecutionId(Integer executionId) {
        this.executionId = executionId;
    }

    public Matter getMatter() {
        return matter;
    }

    public void setMatter(Matter matter) {
        this.matter = matter;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}