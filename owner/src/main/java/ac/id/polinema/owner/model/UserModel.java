package ac.id.polinema.owner.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserModel {

    @SerializedName("id_user")
    @Expose
    private String idUser;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("no_handphone")
    @Expose
    private String noHandphone;

    @SerializedName("address")
    @Expose
    private String address;

    public UserModel() {
    }

    public UserModel(String idUser, String name, String noHandphone, String address) {
        this.idUser = idUser;
        this.name = name;
        this.noHandphone = noHandphone;
        this.address = address;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNoHandphone() {
        return noHandphone;
    }

    public void setNoHandphone(String noHandphone) {
        this.noHandphone = noHandphone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
