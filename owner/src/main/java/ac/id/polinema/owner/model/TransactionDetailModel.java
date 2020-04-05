package ac.id.polinema.owner.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "detail_transactions")
public class TransactionDetailModel {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "id_harga")
    @SerializedName("id_harga")
    @Expose
    private int idHarga;

    @ColumnInfo(name = "id_user")
    @SerializedName("id_user")
    @Expose
    private int bobot;

    @ColumnInfo(name = "status")
    @SerializedName("status")
    @Expose
    private String status;

    public TransactionDetailModel() {
    }

    public TransactionDetailModel(int id, int idHarga, int bobot, String status) {
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
