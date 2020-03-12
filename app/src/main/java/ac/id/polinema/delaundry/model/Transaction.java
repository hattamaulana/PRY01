package ac.id.polinema.delaundry.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Transaction {

    @SerializedName("no_nota")
    private int noNota;

    @SerializedName("status_pembayaran")
    private String statusPayment;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("detail_transaction")
    private List<TransactionDetail> transactions;

    public Transaction() {
    }

    public Transaction(int noNota, String statusPayment, String updatedAt, String createdAt, List<TransactionDetail> transactions) {
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

    public List<TransactionDetail> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionDetail> transactions) {
        this.transactions = transactions;
    }
}
