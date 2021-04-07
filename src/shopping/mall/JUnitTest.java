package shopping.mall;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import shopping.bundling.bundleBuilder;
import shopping.bundling.bundleProduct;
import shopping.composite.compositeOperating;
import shopping.composite.leafEletricProduct;
import shopping.composite.leafFurniture;
import shopping.membership.membershipIdentify;
import shopping.point.normalPoint;
import shopping.point.pointSettor;
import shopping.point.points;
import shopping.point.userPoint;

public class JUnitTest {
    String [] Array_MembershipDiscount;
    @Test
    void testMembershipDiscount(){
        membershipIdentify membershipIdentify = new membershipIdentify();
        Array_MembershipDiscount = membershipIdentify.getDiscount(100, "General");
        Assertions.assertEquals(" (no discount)", Array_MembershipDiscount[1]);
        System.out.println("Membership discount test :" + Array_MembershipDiscount[1]);
        Assertions.assertEquals( 100.0 , Double.parseDouble(Array_MembershipDiscount[0]));
        System.out.println("discount test :" + Array_MembershipDiscount[0]);

        Array_MembershipDiscount = membershipIdentify.getDiscount(100, "VIP");
        Assertions.assertEquals(" (5% discount)", Array_MembershipDiscount[1]);
        System.out.println("Membership discount test :" + Array_MembershipDiscount[1]);
        Assertions.assertEquals( 95.0 , Double.parseDouble(Array_MembershipDiscount[0]));
        System.out.println("discount test :" + Array_MembershipDiscount[0]);
    }
    @Test
    void testPoint(){
        pointSettor userPoint = new userPoint("User_Name");
        points Points = new points(userPoint);
        points normal_point = new normalPoint(Points, 10, "User_Name");
        normal_point.addPoint();
    }
    @Test
    void testBundling(){
        bundleBuilder builder = new bundleBuilder();
        bundleProduct furniture = builder.prepareFurniture();
        System.out.println("furniture bundling");
        furniture.showItems();
        System.out.println("Total Cost: " + furniture.getCost());

        bundleProduct mobile = builder.prepareElectricalProduct();
        System.out.println("\n\nmobile bundling");
        mobile.showItems();
        System.out.println("Total Cost: " + mobile.getCost());
    }
    @Test
    void testComposite(){
        bundleBuilder builder = new bundleBuilder();
        bundleProduct furniture = builder.prepareFurniture();
        compositeOperating operating = new compositeOperating(0,"operating");
        leafFurniture Furniture = new leafFurniture(furniture.getCost(), "Furniture Bundling");
        operating.addProduct(Furniture);
        operating.printProduct();

        bundleProduct mobile = builder.prepareElectricalProduct();
        leafEletricProduct EletricProduct = new leafEletricProduct(mobile.getCost(),
                "Electric Product Bundling");
        operating.addProduct(EletricProduct);
        operating.printProduct();
    }
}
