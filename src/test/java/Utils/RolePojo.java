
package Utils;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RolePojo {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("rc")
    @Expose
    private String rc;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("role")
    @Expose
    private Role role;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRc() {
        return rc;
    }

    public void setRc(String rc) {
        this.rc = rc;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
