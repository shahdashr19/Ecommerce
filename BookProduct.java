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
