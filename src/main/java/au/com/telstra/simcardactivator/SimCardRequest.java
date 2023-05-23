package au.com.telstra.simcardactivator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class SimCardRequest {
    private String iccid;
    private String custEmailId;

    public SimCardRequest() {
    }

    public SimCardRequest(String iccid, String custEmailId) {

        this.iccid = iccid;
        this.custEmailId = custEmailId;
    }

    public SimCardRequest(String iccid) {
        this.iccid = iccid;
    }
    public String getIccid() {
        return this.iccid;
    }
    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    public String getCustEmailId() {
        return this.custEmailId;
    }
    public void setCustEmailId(String custEmailId) {
        this.custEmailId = custEmailId;
    }

    public String toString() {
        String retStr = "SimCard {iccid=" + this.iccid + ", custEmailId=" + this.custEmailId + "}";
        return retStr;
    }
}
