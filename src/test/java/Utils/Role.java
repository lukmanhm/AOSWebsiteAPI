
package Utils;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Role {

    @SerializedName("createdDate")
    @Expose
    private String createdDate;
    @SerializedName("lastUpdate")
    @Expose
    private String lastUpdate;
    @SerializedName("approvalRequestUUID")
    @Expose
    private String approvalRequestUUID;
    @SerializedName("isNeedApproval")
    @Expose
    private Boolean isNeedApproval;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("parentId")
    @Expose
    private Integer parentId;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("module")
    @Expose
    private List<Module> module = null;
    @SerializedName("parentTitle")
    @Expose
    private String parentTitle;

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getApprovalRequestUUID() {
        return approvalRequestUUID;
    }

    public void setApprovalRequestUUID(String approvalRequestUUID) {
        this.approvalRequestUUID = approvalRequestUUID;
    }

    public Boolean getIsNeedApproval() {
        return isNeedApproval;
    }

    public void setIsNeedApproval(Boolean isNeedApproval) {
        this.isNeedApproval = isNeedApproval;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Module> getModule() {
        return module;
    }

    public void setModule(List<Module> module) {
        this.module = module;
    }

    public String getParentTitle() {
        return parentTitle;
    }

    public void setParentTitle(String parentTitle) {
        this.parentTitle = parentTitle;
    }

}
