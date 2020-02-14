package Utils;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Menu {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("rc")
    @Expose
    private String rc;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("menu")
    @Expose
    private List<String> menu = null;

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

    public List<String> getMenu() {
        return menu;
    }

    public void setMenu(List<String> menu) {
        this.menu = menu;
    }

}