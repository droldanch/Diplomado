
package irolso.com.lifesadventure.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("paternalsurname")
    @Expose
    private String paternalsurname;
    @SerializedName("maternalsurname")
    @Expose
    private String maternalsurname;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("salt")
    @Expose
    private String salt;
    @SerializedName("roles")
    @Expose
    private String roles;
    @SerializedName("lastUpdate")
    @Expose
    private LastUpdate lastUpdate;
    @SerializedName("serviceProvider")
    @Expose
    private Object serviceProvider;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPaternalsurname() {
        return paternalsurname;
    }

    public void setPaternalsurname(String paternalsurname) {
        this.paternalsurname = paternalsurname;
    }

    public String getMaternalsurname() {
        return maternalsurname;
    }

    public void setMaternalsurname(String maternalsurname) {
        this.maternalsurname = maternalsurname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public LastUpdate getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LastUpdate lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Object getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(Object serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

}
