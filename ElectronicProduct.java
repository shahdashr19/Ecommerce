public class ElectronicProduct extends product {
     protected String brand;
     protected int warrantyperiod;

    public ElectronicProduct(String brand, int warrantyperiod, int productid, String name, float price) {
        super(productid, name, price);//inhereted from product
        this.brand = brand;
        this.warrantyperiod = warrantyperiod;
    }
    
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getWarrantyperiod() {
        return warrantyperiod;
    }

    public void setWarrantyperiod(int warrantyperiod) {
       this.warrantyperiod = Math.abs(warrantyperiod);//to always get a positive value
    }
    
}
