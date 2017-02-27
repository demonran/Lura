package com.lura.portal.model.http;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 01182799 on 2017/2/24.
 */
public class HRequirements {

    private int status;

    private List<Requirement> requirements = new ArrayList<>();

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

    public HRequirements addRequirement(List<Requirement> requirement) {
        requirements.addAll(requirement);
        return this;
    }

    public static class Requirement{

        private Long id;

        private String name;

        private String detail;

        private String sysCode;

        private Date expectedUpdateTime;

        private String submitter;

        private Date developTime;

        private String developer;

        private Date testTime;

        private String tester;

        private String remarks;

        private String status;


        public Requirement() {
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
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

        public Date getTestTime() {
            return testTime;
        }

        public void setTestTime(Date testTime) {
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

        @Override
        public String toString() {
            return "Requirement{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", detail='" + detail + '\'' +
                    ", sysCode='" + sysCode + '\'' +
                    ", expectedUpdateTime=" + expectedUpdateTime +
                    ", submitter='" + submitter + '\'' +
                    ", developTime=" + developTime +
                    ", developer='" + developer + '\'' +
                    ", testTime=" + testTime +
                    ", tester='" + tester + '\'' +
                    ", remarks='" + remarks + '\'' +
                    ", status='" + status + '\'' +
                    '}';
        }
    }


}
