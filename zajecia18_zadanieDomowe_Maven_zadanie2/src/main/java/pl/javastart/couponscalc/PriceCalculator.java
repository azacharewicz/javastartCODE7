package pl.javastart.couponscalc;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class PriceCalculator {

    public double calculatePrice(List<Product> products, List<Coupon> coupons) {

        if(checkIfNoCoupons(products, coupons)) {
            return sum(products);
        } else if(checkIfOneCouponWithNoCategory(coupons)) {
            double sum = sum(products);
            return addDiscount(sum, coupons);
        } else if(checkIfOneCoupon(coupons)) {
            double sum = sum(products);
            return addDiscount(sum, coupons);
        }

        return 0;
    }

   /* private List<ProductCategorySumAndDiscount> sumProductsByCategory(
    		List<Product> products, List<Coupon> coupons){
    	List<ProductCategorySumAndDiscount> sumProducts = new ArrayList<>();
    	for (Product product : products) {
		}

    	return sumProducts;
    }*/

    private double sum(List<Product> products) {
        double sum = 0;
        for (Product product : products) {
            sum = sum + product.getPrice();
        }
        return sum;
    }

    private double addDiscount(double sum, List<Coupon> coupons) {
        double discount = coupons.get(0).getDiscountValueInPercents();
        double price = sum - sum*(discount/100);
        return round(price);
    }

    private static double round(double price) {
        BigDecimal roundPrice = new BigDecimal(Double.toString(price));
        roundPrice = roundPrice.setScale(2, RoundingMode.HALF_UP);
        return roundPrice.doubleValue();
    }

    private boolean checkIfNoCoupons(
            List<Product> products, List<Coupon> coupons) {
        return (coupons==null && products!=null)
                || (coupons !=null && coupons.isEmpty());
    }

    private boolean checkIfOneCouponWithNoCategory(List<Coupon> coupons) {
        return coupons != null && coupons.size() == 1 && coupons.get(0).getCategory() == null;
    }

    private boolean checkIfOneCoupon(List<Coupon> coupons) {
        return coupons != null && coupons.size() == 1 && coupons.get(0).getCategory() != null;
    }
}

