
package Utils;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Module {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("access")
    @Expose
    private List<String> access = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAccess() {
        return access;
    }

    public void setAccess(List<String> access) {
        this.access = access;
    }

    @Override
    public String toString() {
        return "Module{" +
                "name='" + name + '\'' +
                ", access=" + access +
                '}';
    }
}
