package indi.baojie.supervision.domain;

public class MatterTask {
    private Integer id;

    private Integer processInstanceId;

    private Integer matterId;

    private String code;

    private String target;

    private String leaderIds;

    private String leaderNames;

    private String organizerIds;

    private String organizerNames;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(Integer processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public Integer getMatterId() {
        return matterId;
    }

    public void setMatterId(Integer matterId) {
        this.matterId = matterId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target == null ? null : target.trim();
    }

    public String getLeaderIds() {
        return leaderIds;
    }

    public void setLeaderIds(String leaderIds) {
        this.leaderIds = leaderIds == null ? null : leaderIds.trim();
    }

    public String getLeaderNames() {
        return leaderNames;
    }

    public void setLeaderNames(String leaderNames) {
        this.leaderNames = leaderNames == null ? null : leaderNames.trim();
    }

    public String getOrganizerIds() {
        return organizerIds;
    }

    public void setOrganizerIds(String organizerIds) {
        this.organizerIds = organizerIds == null ? null : organizerIds.trim();
    }

    public String getOrganizerNames() {
        return organizerNames;
    }

    public void setOrganizerNames(String organizerNames) {
        this.organizerNames = organizerNames == null ? null : organizerNames.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}