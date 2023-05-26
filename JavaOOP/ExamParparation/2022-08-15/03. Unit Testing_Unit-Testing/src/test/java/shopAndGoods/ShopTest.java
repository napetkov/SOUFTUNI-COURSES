package shopAndGoods;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.Map;

public class ShopTest {
    private Shop shop;
    private Goods goods;
    private Goods goods2;

    @Before
    public void setup() {
        this.shop = new Shop();
        this.goods = new Goods("LDPE", "00101");
        this.goods2 = new Goods("PPH", "00102");
    }

    @Test
    public void testGetShelvesShouldReturnUnmodifiableCollection() {
        Map<String, Goods> shelves = shop.getShelves();
        Assert.assertEquals("UnmodifiableMap", shelves.getClass().getSimpleName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddGoodsWithMissingShelf() throws OperationNotSupportedException {
        shop.addGoods("Test shelves", goods);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddGoodsToFullShelf() throws OperationNotSupportedException {
        shop.addGoods("Shelves1", goods);
        shop.addGoods("Shelves1", goods);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddGoodsIfGoodsAlreadyExist() throws OperationNotSupportedException {
        shop.addGoods("Shelves1", goods);
        shop.addGoods("Shelves2", goods);
    }

    @Test
    public void testAddGoodsShouldAdd() throws OperationNotSupportedException {
        String output = shop.addGoods("Shelves1", goods);
        Assert.assertEquals(goods, shop.getShelves().get("Shelves1"));
    }

    @Test
    public void testAddGoodsShouldAddAndReturnCorrectMassage() throws OperationNotSupportedException {
        String output = shop.addGoods("Shelves1", goods);
        Assert.assertEquals(output, String.format("Goods: %s is placed successfully!", goods.getGoodsCode()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveGoodsWithMissingShelf() throws OperationNotSupportedException {
        shop.removeGoods("Test", goods);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveGoodsWithDifferentGoods() throws OperationNotSupportedException {
        shop.addGoods("Shelves1", goods);
        shop.removeGoods("Shelves1", goods2);
    }

    @Test
    public void testRemoveGoodsShouldRemove() throws OperationNotSupportedException {
        shop.addGoods("Shelves1", goods);
        shop.addGoods("Shelves2", goods2);

        shop.removeGoods("Shelves1", goods);
        shop.addGoods("Shelves1", goods);
    }

    @Test
    public void testRemoveGoodsShouldReturnCorrectMassage() throws OperationNotSupportedException {
        shop.addGoods("Shelves1",goods);
        String output = shop.removeGoods("Shelves1", goods);
        Assert.assertEquals(output,String.format("Goods: %s is removed successfully!", goods.getGoodsCode()));

    }
}