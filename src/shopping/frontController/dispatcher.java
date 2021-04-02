package shopping.frontController;

public class dispatcher {
    private vip vip;
    private gold gold;
    private supreme supreme;
    private general general;
    public dispatcher(){
        vip = new vip();
        gold = new gold();
        supreme = new supreme();
        general = new general();
    }

    public void dispatch(String membership){
        if(membership.equalsIgnoreCase("VIP"))
            vip.generate();
        else if (membership.equalsIgnoreCase("Gold"))
            gold.generate();
        else if (membership.equalsIgnoreCase("Supreme"))
            supreme.generate();
        else if (membership.equalsIgnoreCase("General"))
            general.generate();
    }
}