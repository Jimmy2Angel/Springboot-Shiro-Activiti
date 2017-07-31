package indi.baojie.supervision.domain;

import java.io.Serializable;

public class Group implements Serializable{
    private Integer id;

    private String orgName;

    private String orgCode;

    private String orgSortCode;

    private String parentCode;

    private String orgPostalcode;

    private String orgPhone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    public String getOrgSortCode() {
        return orgSortCode;
    }

    public void setOrgSortCode(String orgSortCode) {
        this.orgSortCode = orgSortCode == null ? null : orgSortCode.trim();
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode == null ? null : parentCode.trim();
    }

    public String getOrgPostalcode() {
        return orgPostalcode;
    }

    public void setOrgPostalcode(String orgPostalcode) {
        this.orgPostalcode = orgPostalcode == null ? null : orgPostalcode.trim();
    }

    public String getOrgPhone() {
        return orgPhone;
    }

    public void setOrgPhone(String orgPhone) {
        this.orgPhone = orgPhone == null ? null : orgPhone.trim();
    }

    public Group(){

    }

    public Group( String orgName, String orgCode, String orgSortCode, String parentCode, String orgPostalcode, String orgPhone) {
        this.orgName = orgName;
        this.orgCode = orgCode;
        this.orgSortCode = orgSortCode;
        this.parentCode = parentCode;
        this.orgPostalcode = orgPostalcode;
        this.orgPhone = orgPhone;
    }

    public Group(String orgName, String orgCode, String orgSortCode, String parentCode) {
        this.orgName = orgName;
        this.orgCode = orgCode;
        this.orgSortCode = orgSortCode;
        this.parentCode = parentCode;
    }
}