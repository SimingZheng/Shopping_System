package shopping.bundling;
import java.util.ArrayList;
import java.util.List;
//Create a bundleProduct class with the bundlingItem object defined above.
public class bundleProduct {
    private List<bundlingItem> items = new ArrayList<bundlingItem>();

    public void addItem(bundlingItem item){
        items.add(item);
    }

    public float getCost(){
        float cost = 0;
        for (bundlingItem item : items) {
            cost += item.price();
        }
        return cost;
    }

    public void showItems(){
        for (bundlingItem item : items) {
            System.out.print("Item : "+item.name());
            System.out.print(", Packing : "+item.packing().bundle());
            System.out.println(", Price : "+item.price());
        }
    }
}