package au.com.telstra.simcardactivator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class SimCardRequestStatus {
    private boolean success;

    public SimCardRequestStatus() {
    }

    public SimCardRequestStatus(boolean success) {
        this.success = success;
    }

    public boolean getsuccess() {
        return this.success;
    }

    public void setsuccess(boolean success) {
        this.success = success;
    }

    public String toString() {
        return "SimCardRequestStatus {success=" + this.success + "}";
    }
}
