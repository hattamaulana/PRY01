package ac.id.polinema.delaundry.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TransactionModel {

    @SerializedName("no_nota")
    @Expose
    private String noNota;

    @SerializedName("status_pembayaran")
    @Expose
    private boolean statusPayment;

    @SerializedName("updatedAt")
    @Expose
    private String updatedAt;

    @SerializedName("createdAt")
    @Expose
    private String createdAt;

    @SerializedName("detail_transactions")
    @Expose
    private List<TransactionDetailModel> transactions;

    public TransactionModel() {
    }

    public TransactionModel(String noNota, boolean statusPayment, String updatedAt, String createdAt,
                            List<TransactionDetailModel> transactions) {
        this.noNota = noNota;
        this.statusPayment = statusPayment;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
        this.transactions = transactions;
    }

    public String getNoNota() {
        return noNota;
    }

    public void setNoNota(String noNota) {
        this.noNota = noNota;
    }

    public boolean getStatusPayment() {
        return statusPayment;
    }

    public String getStatusPaymentString() {
        return statusPayment ? "LUNAS" : "BELUM LUNAS";
    }

    public void setStatusPayment(boolean statusPayment) {
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
