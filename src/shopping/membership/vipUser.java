package shopping.membership;

import shopping.membership.membership;

public class vipUser implements MembershipUser {
    private String discount;
    private String [] ArrayDiscount = new String[2];
    private String [] ArrayUser = new String[3];

    @Override
    public String[] dicount(double total) {
        total = total*1;
        discount = " (no discount)";
        ArrayDiscount[0] = Double.toString(total);
        ArrayDiscount[1] = discount;
        return ArrayDiscount;
    }

    @Override
    public String[] generate() {
        ArrayUser[0] = "VIP_user";
        ArrayUser[1] = "VIP";
        ArrayUser[2] = "2";
        return ArrayUser;
    }
}
