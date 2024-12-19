public class ClothingProduct extends product {
      protected String size;
      protected String fabric;

    public ClothingProduct(String size, String fabric, int productid, String name, float price) {
        super(productid, name, price);//inhereted from product
        this.size = size;
        this.fabric = fabric;
    }
    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }

    public String getFabric() {
        return fabric;
    }

    public void setFabric(String fabric) {
        this.fabric = fabric;
    }
}
