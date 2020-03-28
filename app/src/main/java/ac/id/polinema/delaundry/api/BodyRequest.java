package ac.id.polinema.delaundry.api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BodyRequest {

    public static class Order {

        @SerializedName("id_user")
        private String idUser;

        @SerializedName("id_harga")
        private List<Integer> idPrices;

        public Order(){
        }

        public Order(String idUser, List<Integer> idPrices) {
            this.idUser = idUser;
            this.idPrices = idPrices;
        }

        public String getIdUser() {
            return idUser;
        }

        public void setIdUser(String idUser) {
            this.idUser = idUser;
        }

        public List<Integer> getIdPrices() {
            return idPrices;
        }

        public void setIdPrices(List<Integer> idPrices) {
            this.idPrices = idPrices;
        }
    }
    /* End Class Order */
}
