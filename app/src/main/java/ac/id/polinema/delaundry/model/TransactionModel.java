package ac.id.polinema.delaundry.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TransactionModel {

    @SerializedName("no_nota")
    @Expose
    private int noNota;

    @SerializedName("status_pembayaran")
    @Expose
    private String statusPayment;

    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    @SerializedName("created_at")
    @Expose
    private String createdAt;

    @SerializedName("detail_transaction")
    @Expose
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
