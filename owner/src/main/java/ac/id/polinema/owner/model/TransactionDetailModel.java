package ac.id.polinema.owner.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TransactionDetailModel {

    @SerializedName("id_harga")
    @Expose
    private int idHarga;

    @SerializedName("id_user")
    @Expose
    private int bobot;

    @SerializedName("status")
    @Expose
    private String status;

    public TransactionDetailModel() {
    }

    public TransactionDetailModel(int idHarga, int bobot, String status) {
        this.idHarga = idHarga;
        this.bobot = bobot;
        this.status = status;
    }

    public int getIdHarga() {
        return idHarga;
    }

    public void setIdHarga(int idHarga) {
        this.idHarga = idHarga;
    }

    public int getBobot() {
        return bobot;
    }

    public void setBobot(int bobot) {
        this.bobot = bobot;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
