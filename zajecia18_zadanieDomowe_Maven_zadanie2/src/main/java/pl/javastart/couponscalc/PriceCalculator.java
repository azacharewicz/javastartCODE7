package pl.javastart.couponscalc;

import java.util.List;

public class PriceCalculator {

    List<Product> products = null;
    List<Coupon> coupons = null;
    double totalPrice = 0.;

    public double calculatePrice(List<Product> products, List<Coupon> coupons) {

//        for (Product product: products) {
//            if(coupons == null) {
//                totalPrice = totalPrice + product.getPrice();
//            }
//        }
        return totalPrice;
    }

}
