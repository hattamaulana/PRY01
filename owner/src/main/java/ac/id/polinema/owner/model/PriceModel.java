package ac.id.polinema.owner.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "prices")
public class PriceModel {

    @SerializedName("id_harga")
    @Expose
    @PrimaryKey
    @ColumnInfo(name = "id_harga")
    private int idHarga;

    @SerializedName("kelas")
    @Expose
    @ColumnInfo(name = "kelas")
    private String kelas;

    @SerializedName("tipe")
    @Expose
    @ColumnInfo(name = "tipe")
    private String type;

    @SerializedName("harga")
    @Expose
    @ColumnInfo(name = "harga")
    private Long price;

    public PriceModel() {
    }

    public PriceModel(int idHarga, String kelas, String type, Long price) {
        this.idHarga = idHarga;
        this.kelas = kelas;
        this.type = type;
        this.price = price;
    }

    public int getIdHarga() {
        return idHarga;
    }

    public void setIdHarga(int idHarga) {
        this.idHarga = idHarga;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
