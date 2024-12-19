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
