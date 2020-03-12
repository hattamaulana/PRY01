package ac.id.polinema.delaundry.model;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("id_user")
    private String idUser;

    @SerializedName("name")
    private String name;

    @SerializedName("no_handphone")
    private String noHandphone;

    @SerializedName("address")
    private String address;

    public User() {
    }

    public User(String idUser, String name, String noHandphone, String address) {
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
