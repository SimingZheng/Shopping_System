package shopping.deliverFee;

public class contextFee {
    private deliverFee deliverfee;

    public contextFee(deliverFee deliverfee){
        this.deliverfee = deliverfee;
    }

    public String [] executeFee(double total) {
        return deliverfee.setdeliverFee(total);
    }
}
