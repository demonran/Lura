package com.lura.portal.model.http;

import java.util.Date;
import java.util.List;

/**
 * Created by 01182799 on 2017/2/24.
 */
public class HRequirements {

    private int status;

    private List<Requirement> requirements;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Requirement> getRequirements() {
        return requirements;
    }

    public void setRequirements(List<Requirement> requirements) {
        this.requirements = requirements;
    }

    public HRequirements addRequirement(Requirement requirement) {
        requirements.add(requirement);
        return this;
    }

    public static class Requirement{

        private int id;

        private String name;

        private String detail;

        private String sysCode;

        private Date expectedUpdateTime;

        private String submitter;

        private Date developTime;

        private String developer;

        private String testTime;

        private String tester;

        private String remarks;

        private String status;

    public Requirement(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }



        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public String getSysCode() {
            return sysCode;
        }

        public void setSysCode(String sysCode) {
            this.sysCode = sysCode;
        }

        public Date getExpectedUpdateTime() {
            return expectedUpdateTime;
        }

        public void setExpectedUpdateTime(Date expectedUpdateTime) {
            this.expectedUpdateTime = expectedUpdateTime;
        }

        public String getSubmitter() {
            return submitter;
        }

        public void setSubmitter(String submitter) {
            this.submitter = submitter;
        }

        public Date getDevelopTime() {
            return developTime;
        }

        public void setDevelopTime(Date developTime) {
            this.developTime = developTime;
        }

        public String getDeveloper() {
            return developer;
        }

        public void setDeveloper(String developer) {
            this.developer = developer;
        }

        public String getTestTime() {
            return testTime;
        }

        public void setTestTime(String testTime) {
            this.testTime = testTime;
        }

        public String getTester() {
            return tester;
        }

        public void setTester(String tester) {
            this.tester = tester;
        }

        public String getRemarks() {
            return remarks;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

    }


}
