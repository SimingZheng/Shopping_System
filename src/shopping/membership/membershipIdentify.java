package shopping.membership;

public class membershipIdentify {
    private String [] ArrayDiscount = new String[2];
    private String [] ArrayUser = new String[3];
    public String [] getDiscount(double total, String membership) {
        generalUser generalUser = new generalUser();
        vipUser vipUser = new vipUser();
        goldUser goldUser = new goldUser();
        supremeUser supremeUser = new supremeUser();
        switch (membership) {
            case "VIP":
                ArrayDiscount = vipUser.discount(total);
                break;
            case "Gold":
                ArrayDiscount = goldUser.discount(total);
                break;
            case "Supreme":
                ArrayDiscount = supremeUser.discount(total);
                break;
            default:
                ArrayDiscount = generalUser.discount(total);
                break;
        }
        return ArrayDiscount;
    }

    public String [] getUserMembership(String membership) {
        generalUser generalUser = new generalUser();
        vipUser vipUser = new vipUser();
        goldUser goldUser = new goldUser();
        supremeUser supremeUser = new supremeUser();
        switch (membership) {
            case "VIP":
                return new vipUser().generate();
            case "Gold":
                return new goldUser().generate();
            case "Supreme":
                return new supremeUser().generate();
            default:
                return new generalUser().generate();
        }
    }
}
