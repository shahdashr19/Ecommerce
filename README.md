# Ecommerce
import javax.swing.JOptionPane;
public class EcommerceSystem2 {
    public static void main(String[] args) {
        String name=JOptionPane.showInputDialog("Enter your name");
        JOptionPane.showMessageDialog(null,"Hello "+name+" to the Ecommerce system!");
        String address =JOptionPane.showInputDialog("Please "+name+" Enter your address ");
        int id =Integer.parseInt(JOptionPane.showInputDialog("please "+name+" Enter your id: "));
        
        customer  k = new customer (id,name,address);
        ElectronicProduct e = new ElectronicProduct("samsung",1,1,"smart phone",599.9f);
        ClothingProduct c = new ClothingProduct("medium","fabric",2,"t-shirt",19.99f);
        BookProduct b = new BookProduct("O'reilly","X publisher",3,"OOP",39.99f);
        int nproduct =Integer.parseInt(JOptionPane.showInputDialog("How many many products you want to add to your cart? "));
        cart cart = new cart();
        cart.setCustomerid(k.getCustomerid());
        cart.setNproduct(nproduct);
        for (int i = 0; i < nproduct; i++) {
       int ARRAY=Integer.parseInt(JOptionPane.showInputDialog("Which product would you like to add?1-Smart Phone  2-T-Shirt  3-OOP"));
            switch (ARRAY) {
                case 1:
                    cart.addProduct(e);
                    break;
                case 2:
                    cart.addProduct(c);
                    break;
                case 3:
                    cart.addProduct(b);
                    break;
                default:
                    System.out.println("invalid choice!");
            }
        }
         JOptionPane.showMessageDialog(null,"your total is: "+cart.calculateprice());
         int choice =Integer.parseInt(JOptionPane.showInputDialog( "Do you want to place the order?1.yes 2.no "));
         cart.placeorder(choice);
        if (choice == 1) {
            order o = new order(cart);
             o.printorderinfo();
              JOptionPane.showMessageDialog(null,"Thank you "+name+" to use our Ecommerce system!");
        } else if (choice == 2) {
             JOptionPane.showMessageDialog(null,"your cart is Empty now.\nThank you"+name+"for using our Ecommerce system!");
        } else {
            JOptionPane.showMessageDialog(null,"invalid input");
        }
    }   
    }
    


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
import javax.swing.JOptionPane;
public class order {
      private  int customerid;
    private  int orderid;
    private  product[]arr;
    private  float totalprice;
    static int number ;

    public order(cart c ) {//association
        number ++;
        this.customerid = c.getCustomerid();
        this.orderid = number;
        this.arr = c.getArr();
        this.totalprice = c.calculateprice();
    }

    public void printorderinfo(){
        JOptionPane.showMessageDialog(null,"Here's your order's summary: \n"+"Order id: "+orderid+"\nCustomer id: "+customerid+"\ntotal price: "+totalprice+"\nordered products: ");
        for (int i = 0;i <arr.length; i++) {
            if(arr[i]!=null){
               JOptionPane.showMessageDialog(null,"name : "+ arr[i].getName()+"\nprice : "+ arr[i].getPrice());
            }
        }
    }
}
import javax.swing.JOptionPane;
public class cart {
     private int customerid;
     private int nproduct;
     protected product[]arr;
     
     public product[] getArr() {//constructor
        
        return arr;
    }
    public void setArr(product[] arr) {//can be removed
       this.arr = new product[nproduct];
    }
    

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
         this.customerid= customerid ;
    }

    public  int getNproduct() {
        return nproduct;
    }

    public void setNproduct(int nproduct) {
        this.nproduct=Math.abs(nproduct);
        arr = new product[this.nproduct];
    }
 public  void addProduct(product product){
     for (int i = 0; i < nproduct; i++) {  // 0 1 2 3  size/nproduct : 4
      if(arr[i]==null){                    // *   
          arr[i] = product;//add product mn elmain to the array and exit the fuction then enters the fuction again and checks if arr[0]==null?no then i++..
          return;//exit function after every iteration
      }
      }
         JOptionPane.showMessageDialog(null,"the cart is full,can not add more products.");

 }
    public void removeproduct(int in){
         if(in>=0&&in<nproduct){
             arr[in]=null;
         } else{  JOptionPane.showMessageDialog(null,"invalid index,cannot remove product.");  
         }}
    public  float calculateprice(){
   float total=0;
   for(int i=0;i<nproduct;i++){  
       if(arr[i]!=null){
       total+=arr[i].getPrice();}
    }return total;
}
public  void placeorder(int n){
    switch(n){
        case 1:JOptionPane.showMessageDialog(null,"your order has been successfully confirmed.");
        break;
        case 2:for (int i = 0; i < arr.length; i++) {
               arr[i]=null; 
            }break;
    } 
}
}
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
public class BookProduct extends product{
   protected String author;
   protected String publisher;

    public BookProduct(String author, String publisher, int productid, String name, float price) {
        super(productid, name, price);//inhereted from product
        this.author = author;
        this.publisher = publisher;
    }

 
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
      
}
import javax.swing.JOptionPane;
public class order {
      private  int customerid;
    private  int orderid;
    private  product[]arr;
    private  float totalprice;
    static int number ;

    public order(cart c ) {//association
        number ++;
        this.customerid = c.getCustomerid();
        this.orderid = number;
        this.arr = c.getArr();
        this.totalprice = c.calculateprice();
    }

    public void printorderinfo(){
        JOptionPane.showMessageDialog(null,"Here's your order's summary: \n"+"Order id: "+orderid+"\nCustomer id: "+customerid+"\ntotal price: "+totalprice+"\nordered products: ");
        for (int i = 0;i <arr.length; i++) {
            if(arr[i]!=null){
               JOptionPane.showMessageDialog(null,"name : "+ arr[i].getName()+"\nprice : "+ arr[i].getPrice());
            }
        }
    }
}

