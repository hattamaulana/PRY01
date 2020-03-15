package ac.id.polinema.owner.api;

import com.google.gson.annotations.SerializedName;

public class Response<T> {

    @SerializedName("status")
    private int status;

    @SerializedName("message")
    private int message;

    @SerializedName("data")
    private T data;

    public Response() {
    }

    public Response(int status, int message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getMessage() {
        return message;
    }

    public void setMessage(int message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
