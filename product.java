public class product {
    protected int productid;
    protected  String name;
    protected  float price;

    public product(int productid, String name, float price) {
        this.productid = productid;
        this.name = name;
        this.price = price;
    }
    public int getProductid() {
        return productid;
    }
    public void setProductid(int productid) {
        this.productid= Math.abs(productid);//to get a positive value
    }
    public  String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public float getPrice() {   
        return price;
    }
    
    public void setPrice(float price) {
       this.price=Math.abs(price);//to get a positive value
    }
}
