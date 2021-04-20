package shopping.membership;

public class supremeUser implements MembershipUser {
    private String discount;
    private String [] ArrayDiscount = new String[2];
    private String [] ArrayUser = new String[3];

    @Override
    public String[] dicount(double total) {
        total *= 0.8;
        discount = " (20% discount)";
        ArrayDiscount[0] = Double.toString(total);
        ArrayDiscount[1] = discount;
        return ArrayDiscount;
    }

    @Override
    public String[] generate() {
        ArrayUser[0] = "Supreme_user";
        ArrayUser[1] = "Supreme";
        ArrayUser[2] = "2";
        return ArrayUser;
    }
}
