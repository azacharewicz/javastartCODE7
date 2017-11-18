package pl.javastart.couponscalc;

import java.util.List;

public class PriceCalculator {

    List<Product> products = null;
    List<Coupon> coupons = null;
    double totalPrice = 0.00;


    public double calculatePrice(List<Product> products, List<Coupon> coupons) {
        if((products == null) && (coupons == null)) {
            return totalPrice;
        }
        if(coupons == null){
               for (Product product: products) {
               return totalPrice = totalPrice + product.getPrice();
            }
        }
        return totalPrice;
    }
}
