import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class InstockTest {

    private ProductStock instock;
    private Product product;

    @Before
    public void setup() {
        this.instock = new Instock();
        this.product = new Product("test_product", 13.00, 10);
    }

    @Test
    public void testAddInStockContainsThatProduct() {
        instock.add(product);
        assertTrue(instock.contains(product));
    }

    @Test
    public void testContainsShouldReturnFalseProductIsMissing() {
        assertFalse(instock.contains(product));
    }

    @Test
    public void testCountShouldReturnTheCountOfProducts() {
        assertEquals(0, instock.getCount());

        instock.add(product);

        assertEquals(1, instock.getCount());

        instock.add(new Product("test_two", 10, 13));

        assertEquals(2, instock.getCount());
    }

    @Test
    public void testFindShouldReturnTheCorrectNthProduct() {
        List<Product> products = addMultipleProducts();

        int productIndex = 3;

        Product expected = products.get(productIndex);

        Product actual = instock.find(productIndex);

        assertNotNull(actual);
        assertEquals(expected.getLabel(), actual.getLabel());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindIndexOutOfRangeShouldThrow() {
        List<Product> products = addMultipleProducts();
        instock.find(products.size());
    }

    @Test
    public void testChangeQuantityShouldUpdateProductQuantity() {
        instock.add(product);
        int expectedQuantity = product.getQuantity() + 13;
        instock.changeQuantity(product.getLabel(), expectedQuantity);
        assertEquals(expectedQuantity, product.getQuantity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeQuantityShouldFailIfProductIsMissing() {
        instock.changeQuantity("missing_label", 13);
    }

    @Test
    public void testFindByLabelShouldReturnTheProductWithSameLabel() {
        List<Product> products = addMultipleProducts();
        instock.add(product);

        Product actual = instock.findByLabel(product.getLabel());

        assertNotNull(actual);
        assertEquals(product.getLabel(), product.getLabel());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindByLabelShouldFailWhenProductWithLAbelMissing() {
        instock.findByLabel("missing_label");
    }
    /*
     * findFirstByAlphabeticalOrder
     *       case 1: must return n products
     *       case 2: must return products ordered by label
     *       case 3: must return empry collection if not enough products
     */

    @Test
    public void testFindFirstByAlphabeticalOrderShouldReturnCorrectNumberOfProducts() {
        List<Product> products = addMultipleProducts();
        int expectedCount = 3;
        List<Product> actual = iterableToList(instock.findFirstByAlphabeticalOrder(expectedCount));
        assertEquals(expectedCount, actual.size());
    }

    @Test
    public void testFindFirstByAlphabeticalOrderShouldReturnTheProductsOrderedByLabel() {
        List<Product> products = addMultipleProducts().stream().
                sorted(Comparator.comparing(Product::getLabel))
                .toList();

        int expectedCount = products.size();

        List<Product> actual = iterableToList(instock.findFirstByAlphabeticalOrder(expectedCount));

        assertEquals(expectedCount, actual.size());

        for (int i = 0; i < products.size(); i++) {
            String expectedLabel = products.get(i).getLabel();
            String actualLabel = actual.get(i).getLabel();

            assertEquals(expectedLabel, actualLabel);
        }
    }

    @Test
    public void testFindFirstByAlphabeticalOrderShouldReturnEmptyCollectionWhenNotEnoughProducts() {
        int size = addMultipleProducts().size();

        List<Product> products = iterableToList(instock.findFirstByAlphabeticalOrder(size + 1));

        assertEquals(0, products.size());
    }

    @Test
    public void testFindFirstByAlphabeticalOrderShouldReturnEmptyCollectionWhenCountIsZero() {
        addMultipleProducts().size();

        List<Product> products = iterableToList(instock.findFirstByAlphabeticalOrder(0));

        assertEquals(0, products.size());
    }

    @Test
    public void testFindAllInRangeShouldReturnTheCorrectRange() {
        List<Product> expected = addMultipleProducts()
                .stream().filter(p -> p.getPrice() > 2 && p.getPrice() <= 13)
                .toList();

        final int beginRange = 2;
        final int endRange = 13;
        List<Product> actual = iterableToList(instock.findAllInRange(beginRange, endRange));

        assertEquals(expected.size(), actual.size());

        boolean hasNotOfRangePrices = actual.stream()
                .map(Product::getPrice)
                .noneMatch(p -> p <= beginRange || p > endRange);

        assertTrue(hasNotOfRangePrices);

    }

    @Test
    public void testFindAllInRangeShouldReturnOrderedProductByPriceDescending() {
        List<Product> expected = addMultipleProducts()
                .stream().filter(p -> p.getPrice() > 2 && p.getPrice() <= 13)
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .toList();

        final int beginRange = 2;
        final int endRange = 13;
        List<Product> actual = iterableToList(instock.findAllInRange(beginRange, endRange));

        assertEquals(expected.size(), actual.size());

        for (int i = 0; i < expected.size(); i++) {
            double expectedPrice = expected.get(i).getPrice();
            double actualPrice = actual.get(i).getPrice();
            assertEquals(expectedPrice, actualPrice, 0.00);
        }
    }

    @Test
    public void testFindAllByPriceShouldReturnMatchingPriceProducts() {
        addMultipleProducts();

        int expectedPrice = 5;
        List<Product> products = iterableToList(instock.findAllByPrice(expectedPrice));

        for (Product p : products) {
            assertEquals(expectedPrice, p.getPrice(), 0.00);
        }
    }

    @Test
    public void testFindAllByPriceShouldReturnEmptyCollectionsWhenNoneMatches() {
        addMultipleProducts();

        List<Product> products = iterableToList(instock.findAllByPrice(-1.00));

        assertEquals(0, products.size());
    }

    @Test
    public void testFindFirstMostExpensiveProductsShouldShouldReturnTheCorrectMostExpensiveProduct() {
        int productsToTake = 5;
        List<Product> expected = addMultipleProducts()
                .stream()
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .limit(productsToTake)
                .collect(Collectors.toList());
        List<Product> actual = iterableToList(instock.findFirstMostExpensiveProducts(productsToTake));

        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindFirstMostExpensiveProductsShouldFailWhenThereAreLessProductInStock() {
        int size = addMultipleProducts().size();

        instock.findFirstMostExpensiveProducts(size+1);
    }

    @Test
    public void testFindAllByQuantityShouldReturnMatchingPriceProducts() {
        addMultipleProducts();

        int expectedQuantity = 7;
        List<Product> products = iterableToList(instock.findAllByQuantity(expectedQuantity));

        for (Product p : products) {
            assertEquals(expectedQuantity, p.getQuantity());
        }
    }

    @Test
    public void testFindAllByQuantityeShouldReturnEmptyCollectionsWhenNoneMatches() {
        addMultipleProducts();

        List<Product> products = iterableToList(instock.findAllByQuantity(-10));

        assertEquals(0, products.size());
    }

    @Test
    public void testIteratorShouldReturnAllTheProductsInStock(){
        List<Product> expected = addMultipleProducts();

        Iterator<Product> iterator = instock.iterator();

        List<Product> actual = new ArrayList<>();

        iterator.forEachRemaining(actual::add);

        assertEquals(expected,actual);
    }

    private List<Product> addMultipleProducts() {
        List<Product> products = List.of(
                new Product("label_1", 5, 3),
                new Product("label_5", 3, 7),
                new Product("label_3", 5, 7),
                new Product("label_7", 21, 7),
                new Product("label_2", 3, 7),
                new Product("label_4", 2, 4),
                new Product("label_6", 13, 8),
                new Product("label_8", 7, 13)
        );
        products.forEach(instock::add);
        return products;
    }

    private List<Product> iterableToList(Iterable<Product> iterable) {
        assertNotNull(iterable);

        List<Product> products = new ArrayList<>();

        iterable.forEach(products::add);

        return products;
    }
}