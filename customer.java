public class customer {
    private int customerid;//private عشان في customer id في كلاس تاتي 
    private String name;//w name
    private String address;

    public customer(int customerid, String name, String address) {
        this.customerid = customerid;
        this.name = name;
        this.address = address;
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid =Math.abs(customerid);//positive value
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
}
