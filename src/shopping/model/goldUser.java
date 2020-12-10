package shopping.model;

public class goldUser implements membership{
    private String discount;
    private String [] ArrayDiscount = new String[2];
    private String [] ArrayUser = new String[3];
    @Override
    public String [] discount(double total) {
        total *= 0.9;
        discount = " (10% discount)";
        ArrayDiscount[0] = Double.toString(total);
        ArrayDiscount[1] = discount;
        return ArrayDiscount;
    }

    @Override
    public String[] generate() {
        ArrayUser[0] = "Gold_user";
        ArrayUser[1] = "Gold";
        ArrayUser[2] = "2";
        return ArrayUser;
    }
}
