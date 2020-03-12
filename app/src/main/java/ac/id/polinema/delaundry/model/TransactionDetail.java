package ac.id.polinema.delaundry.model;

import com.google.gson.annotations.SerializedName;

public class TransactionDetail {

    @SerializedName("id_harga")
    private int idHarga;

    @SerializedName("id_user")
    private int bobot;

    @SerializedName("status")
    private String status;

    public TransactionDetail() {
    }

    public TransactionDetail(int idHarga, int bobot, String status) {
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
