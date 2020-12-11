package shopping.deliverFee;

public class fee implements deliverFee{
    private String[] Array_DeliverFee = new String[2];
    String deliverFee;
    @Override
    public String [] setdeliverFee(double total) {
        total += 5;
        deliverFee = "5";
        Array_DeliverFee[0] = Double.toString(total);
        Array_DeliverFee[1] = deliverFee;
        return Array_DeliverFee;
    }
}
