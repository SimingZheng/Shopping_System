package shopping.deliverFee;

public class nofee implements deliverFee{
    private String[] Array_DeliverFee = new String[2];
    String deliverFee;
    @Override
    public String [] setdeliverFee(double total) {
        deliverFee = "Free";
        Array_DeliverFee[0] = Double.toString(total);
        Array_DeliverFee[1] = deliverFee;
        return Array_DeliverFee;
    }
}
