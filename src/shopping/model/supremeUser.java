package shopping.model;

public class supremeUser implements membership{
    private String discount;
    private String [] ArrayDiscount = new String[2];
    @Override
    public String [] discount(double total) {
        total *= 0.8;
        discount = " (20% discount)";
        ArrayDiscount[0] = Double.toString(total);
        ArrayDiscount[1] = discount;
        return ArrayDiscount;
    }
}
