package shopping.membership;

import shopping.membership.membership;

public class generalUser implements Discount{
    VIPAdapter vipAdapter;
    private String discount;
    private String [] ArrayDiscount = new String[2];
    private String [] ArrayUser = new String[3];

    @Override
    public String[] discount(String membershipType, double total) {
        if(membershipType.equalsIgnoreCase("General") ){
            total = total*1;
            discount = " (no discount)";
            ArrayDiscount[0] = Double.toString(total);
            ArrayDiscount[1] = discount;
        } else if(membershipType.equalsIgnoreCase("VIP")
                || membershipType.equalsIgnoreCase("Gold")
                || membershipType.equalsIgnoreCase("Supreme")){
            vipAdapter = new VIPAdapter(membershipType);
            ArrayDiscount = vipAdapter.discount(membershipType,total);
        }
        return ArrayDiscount;
    }

    @Override
    public String[] generate() {
        ArrayUser[0] = "General_user";
        ArrayUser[1] = "General";
        ArrayUser[2] = "2";
        return ArrayUser;
    }
}
