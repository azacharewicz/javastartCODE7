package pl.javastart.couponscalc;

        import org.junit.Test;
        import java.util.ArrayList;
        import java.util.List;
        import static org.hamcrest.CoreMatchers.is;
        import static org.junit.Assert.*;

public class PriceCalculatorTest {

    @Test
    public void shouldReturnZeroForNoProducts() {
        // given
        PriceCalculator priceCalculator = new PriceCalculator();

        // when
        double result = priceCalculator.calculatePrice(null, null);

        // then
        assertThat(result, is(0.));
    }

    @Test
    public void shouldReturnPriceForSingleProductAndNoCoupons() {

        // given
        PriceCalculator priceCalculator = new PriceCalculator();
        List<Product> products = new ArrayList<>();
        products.add(new Product("Masło", 5.99, Category.FOOD));

        // when
        double result = priceCalculator.calculatePrice(products, null);

        // then
        assertThat(result, is(5.99));
    }

    @Test
    public void shouldReturnPriceForSingleProductAndOneCoupon() {

        // given
        PriceCalculator priceCalculator = new PriceCalculator();
        List<Product> products = new ArrayList<>();
        products.add(new Product("Masło", 5.99, Category.FOOD));

        List<Coupon> coupons = new ArrayList<>();
        coupons.add(new Coupon(Category.FOOD, 20));

        // when
        double result = priceCalculator.calculatePrice(products, coupons);

        // then
        assertThat(result, is(4.79));
    }

    @Test
    public void shouldReturnPriceForSingleProductAndOneCouponWithNoCategory() {

        // given
        PriceCalculator priceCalculator = new PriceCalculator();
        List<Product> products = new ArrayList<>();
        products.add(new Product("Masło", 5.99, Category.FOOD));

        List<Coupon> coupons = new ArrayList<>();
        coupons.add(new Coupon(null, 20));

        // when
        double result = priceCalculator.calculatePrice(products, coupons);

        // then
        assertThat(result, is(4.79));
    }

    @Test
    public void shouldReturnPriceMoreProductsAndOneCoupon() {

        // given
        PriceCalculator priceCalculator = new PriceCalculator();
        List<Product> products = new ArrayList<>();
        products.add(new Product("Masło", 5.99, Category.FOOD));
        products.add(new Product("Bułka", 1.99, Category.FOOD));
        products.add(new Product("Żarówka", 1.99, Category.HOME));

        List<Coupon> coupons = new ArrayList<>();
        coupons.add(new Coupon(Category.FOOD, 20));

        // when
        double result = priceCalculator.calculatePrice(products, coupons);

        // then
        assertThat(result, is(8.37));
    }

    @Test
    public void shouldReturnPriceMoreProductsAndMoreCoupon() {

        // given
        PriceCalculator priceCalculator = new PriceCalculator();
        List<Product> products = new ArrayList<>();
        products.add(new Product("Masło", 5.99, Category.FOOD));
        products.add(new Product("Bułka", 1.99, Category.FOOD));
        products.add(new Product("Żarówka", 1.99, Category.HOME));

        List<Coupon> coupons = new ArrayList<>();
        coupons.add(new Coupon(Category.FOOD, 20));

        // when
        double result = priceCalculator.calculatePrice(products, coupons);

        // then
        assertThat(result, is(8.37));
    }

    //------------------------------------------------------------------------------
    ////    Więcej niż jeden kod rabatowy:
////        • kody rabatowe nie łączą się, a w przypadku zastosowania więcej niż jednego
////        sklep idzie zawsze na rękę klientowi i wybiera najkorzystniejszy rabat.
//
////        przykład 1:
////        masło za 6zł i opony za 100zł, oraz kody rabatowe na jedzenie o wartości 50% i na art. samochodowe 10%
////        - wybrany zostanie kupon na art samochodowe ponieważ obniżka ot 10zł, a spożywczy dałby zniżkę 3zł.
//    @Test
//    public void shouldReturnPriceForTwoProductsAndCouponsOnCategory() {
//
//        // given
//        PriceCalculator priceCalculator = new PriceCalculator();
//        List<Product> products = new ArrayList<>();
//        products.add(new Product("Masło", 6.00, Category.FOOD));
//        products.add(new Product("Opony", 100.00, Category.CAR));
//
//        List<Coupon> coupons = new ArrayList<>();
//        coupons.add(new Coupon(Category.FOOD, 50));
//        coupons.add(new Coupon(Category.CAR, 10));
//
//        // when
//        double result = priceCalculator.calculatePrice(products, coupons);
//
//        // then
//        assertThat(result, is(96.00));
//    }
//
//
////        przykład 2:
////        rabat na wszystko w wysokości 10% oraz rabat na jedzenie w wysokości 50%
////        - klient kupuje tylko artykuły spożywcze
////        - powinien zostać zastosowany rabat na jedzenie
//    @Test
//    public void shouldReturnPriceForTwoProductsAndCouponOnCategoryAndCouponOnAllProducts() {
//
//        // given
//        PriceCalculator priceCalculator = new PriceCalculator();
//        List<Product> products = new ArrayList<>();
//        products.add(new Product("Cukierki", 7.00, Category.FOOD));
//        products.add(new Product("Mleko", 3.00, Category.FOOD));
//
//        List<Coupon> coupons = new ArrayList<>();
//        coupons.add(new Coupon(Category.FOOD, 50));
//        coupons.add(new Coupon(null, 10));
//
//        // when
//        double result = priceCalculator.calculatePrice(products, coupons);
//
//        // then
//        assertThat(result, is(5.00));
//    }
//

}


























