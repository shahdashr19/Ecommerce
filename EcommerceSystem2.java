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
    

