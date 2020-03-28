package ac.id.polinema.delaundry.model;

import java.util.List;

public class PriceList {

    String kelas;
    List<PriceModel> priceModels;

    public PriceList(String kelas, List<PriceModel> priceModels) {
        this.kelas = kelas;
        this.priceModels = priceModels;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public List<PriceModel> getPriceModels() {
        return priceModels;
    }

    public void setPriceModels(List<PriceModel> priceModels) {
        this.priceModels = priceModels;
    }
}
