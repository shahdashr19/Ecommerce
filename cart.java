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
