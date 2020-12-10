package shopping.point;

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
