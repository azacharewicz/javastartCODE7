package pl.javastart.couponscalc;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class PriceCalculator {

    public double calculatePrice(List<Product> products, List<Coupon> coupons) {
        return sum(products, coupons);
    }

    private double sum(List<Product> products, List<Coupon> coupons) {

        if (products == null) {
            return 0;
        }

        double sum = 0;
        for (Product product : products) {
            double discount = getDiscountForCategory(product.getCategory(), coupons);
            sum = sum + (addDiscountToPrice(product.getPrice(), discount));
        }
        return round(sum);
    }

    private int getDiscountForCategory(Category category, List<Coupon> coupons) {
        if (coupons != null) {
            for (Coupon coupon : coupons) {
                if (category == coupon.getCategory()) {
                    return coupon.getDiscountValueInPercents();
                }
            }
        }

        if (checkIfOneCouponWithNoCategory(coupons)) {
            return coupons.get(0).getDiscountValueInPercents();
        }

        return 0;
    }

    private double addDiscountToPrice(double price, double discount) {
        return price - price * (discount / 100);
    }

    private double round(double price) {
        BigDecimal roundPrice = new BigDecimal(Double.toString(price));
        roundPrice = roundPrice.setScale(2, RoundingMode.HALF_UP);
        return roundPrice.doubleValue();
    }

    private boolean checkIfOneCouponWithNoCategory(List<Coupon> coupons) {
        return coupons != null && coupons.size() == 1 && coupons.get(0).getCategory() == null;
    }
}
