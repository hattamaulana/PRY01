package ac.id.polinema.owner.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(tableName = "transactions")
public class TransactionModel {

    @PrimaryKey
    @ColumnInfo(name = "no_nota")
    @SerializedName("no_nota")
    @Expose
    private int noNota;

    @ColumnInfo(name = "status_pembayaran")
    @SerializedName("status_pembayaran")
    @Expose
    private String statusPayment;

    @ColumnInfo(name = "updated_at")
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    @ColumnInfo(name = "created_at")
    @SerializedName("created_at")
    @Expose
    private String createdAt;

    @SerializedName("detail_transaction")
    @Expose
    @Ignore
    private List<TransactionDetailModel> transactions;

    public TransactionModel() {
    }

    public TransactionModel(int noNota, String statusPayment, String updatedAt, String createdAt, List<TransactionDetailModel> transactions) {
        this.noNota = noNota;
        this.statusPayment = statusPayment;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
        this.transactions = transactions;
    }

    public int getNoNota() {
        return noNota;
    }

    public void setNoNota(int noNota) {
        this.noNota = noNota;
    }

    public String getStatusPayment() {
        return statusPayment;
    }

    public void setStatusPayment(String statusPayment) {
        this.statusPayment = statusPayment;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public List<TransactionDetailModel> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionDetailModel> transactions) {
        this.transactions = transactions;
    }
}
