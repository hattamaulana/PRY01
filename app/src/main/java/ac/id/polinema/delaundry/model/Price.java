package ac.id.polinema.delaundry.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "prices")
public class Price {

    @SerializedName("id_harga")
    @PrimaryKey
    @ColumnInfo(name = "id_harga")
    private int idHarga;

    @SerializedName("kelas")
    @ColumnInfo(name = "kelas")
    private String kelas;

    @SerializedName("tipe")
    @ColumnInfo(name = "tipe")
    private String type;

    @SerializedName("harga")
    @ColumnInfo(name = "harga")
    private Long price;

    public Price() {
    }

    public Price(int idHarga, String kelas, String type, Long price) {
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
