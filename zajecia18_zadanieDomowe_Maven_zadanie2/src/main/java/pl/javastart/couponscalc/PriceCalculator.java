package pl.javastart.couponscalc;

import java.util.ArrayList;
import java.util.List;

public class PriceCalculator {

    Product product = null;
    Coupon coupon =  null;
    List<Product> products = null;
    List<Coupon> coupons = null;
    double totalPrice = 0.00;
    int discount = 0;


    public double calculatePrice(List<Product> products, List<Coupon> coupons) {
        if((products == null) && (coupons == null)) {
            return totalPrice;
        }
        if(coupons == null){
               for (Product product: products) {
               totalPrice = totalPrice + product.getPrice();
            }
            return totalPrice;
        }
        if (coupons.size() == 1){
            for (Product product: products) {
                Coupon coupon =  new Coupon(product.getCategory(), discount);
                discount = coupon.getDiscountValueInPercents();
                totalPrice = totalPrice + (product.getPrice() * (100 - discount)/100);
            }
            return totalPrice;
        }
        return totalPrice;
    }
}


//    @Test
//    public void shouldReturnPriceForSingleProductAndOneCoupon() {
//
//        // given
//        PriceCalculator priceCalculator = new PriceCalculator();
//        List<Product> products = new ArrayList<>();
//        products.add(new Product("Masło", 5.99, Category.FOOD));
//
//        List<Coupon> coupons = new ArrayList<>();
//        coupons.add(new Coupon(Category.FOOD, 20));
//
//        // when
//        double result = priceCalculator.calculatePrice(products, coupons);
//
//        // then
//        assertThat(result, is(4.79));
//    }