package shopping.membership;

public interface Discount {
    public String [] discount(String membershipType, double total);
    public String[] generate();
}