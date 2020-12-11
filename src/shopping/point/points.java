package shopping.point;

// Create an abstract decoration class that implements the pointSettor interface
public class points implements pointSettor{

    private pointSettor user;

    public points(pointSettor user){
        this.user = user;
    }

    @Override
    public void addPoint() {
        if (user != null){
            user.addPoint();
        }
    }
}
