package shopping.membership;

public class VIPAdapter implements Discount{
    MembershipUser membershipUser;
    private String discount;
    private String [] ArrayDiscount = new String[2];
    private String [] ArrayUser = new String[3];
    public VIPAdapter(String membershipType){
        if(membershipType.equalsIgnoreCase("VIP") ){
            membershipUser = new vipUser();
        } else if (membershipType.equalsIgnoreCase("Gold")){
            membershipUser = new goldUser();
        }
        else if (membershipType.equalsIgnoreCase("Supreme")){
            membershipUser = new supremeUser();
        }
    }

    @Override
    public String [] discount(String membershipType, double total) {
        if(membershipType.equalsIgnoreCase("VIP") ){
            ArrayDiscount = membershipUser.dicount(total);
        } else if (membershipType.equalsIgnoreCase("Gold")){
            ArrayDiscount = membershipUser.dicount(total);
        }
        else if (membershipType.equalsIgnoreCase("Supreme")){
            ArrayDiscount = membershipUser.dicount(total);
        }
        return ArrayDiscount;
    }

    @Override
    public String[] generate() {
        return new String[0];
    }
}
