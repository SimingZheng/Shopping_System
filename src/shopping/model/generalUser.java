package shopping.model;

public class generalUser implements membership {
    private String discount;
    private String [] ArrayDiscount = new String[2];
    @Override
    public String [] discount(double total) {
        total = total*1;
        discount = " (no discount)";
        ArrayDiscount[0] = Double.toString(total);
        ArrayDiscount[1] = discount;
        return ArrayDiscount;
    }
}
