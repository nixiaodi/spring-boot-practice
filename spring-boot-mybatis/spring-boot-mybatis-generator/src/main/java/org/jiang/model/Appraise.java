package org.jiang.model;

import java.io.Serializable;
import java.util.Date;

public class Appraise implements Serializable {
    private Integer id;

    private Integer eid;

    private Date appdate;

    private String appresult;

    private String appcontent;

    private String remark;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Date getAppdate() {
        return appdate;
    }

    public void setAppdate(Date appdate) {
        this.appdate = appdate;
    }

    public String getAppresult() {
        return appresult;
    }

    public void setAppresult(String appresult) {
        this.appresult = appresult;
    }

    public String getAppcontent() {
        return appcontent;
    }

    public void setAppcontent(String appcontent) {
        this.appcontent = appcontent;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", eid=").append(eid);
        sb.append(", appdate=").append(appdate);
        sb.append(", appresult=").append(appresult);
        sb.append(", appcontent=").append(appcontent);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}