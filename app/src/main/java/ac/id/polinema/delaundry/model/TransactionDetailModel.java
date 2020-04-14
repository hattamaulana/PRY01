package ac.id.polinema.delaundry.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TransactionDetailModel {

    @SerializedName("id_harga")
    @Expose
    private int idHarga;

    @SerializedName("bobot")
    @Expose
    private int bobot;

    @SerializedName("status")
    @Expose
    private boolean status;

    public TransactionDetailModel() {
    }

    public TransactionDetailModel(int idHarga, int bobot, boolean status) {
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

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getStatusString() {
        return (status) ? "DONE" : "PROGGRESS";
    }
}
