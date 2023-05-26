package gifts;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

public class GiftFactoryTests {
    private GiftFactory giftFactory;
    private Gift giftArrow;
    private Gift giftHummer;

    @Before
    public void setup() {
        giftFactory = new GiftFactory();
        giftArrow = new Gift("Arrow", 15.50);
        giftHummer = new Gift("GoldenHummer", 105.20);
    }

    @Test
    public void testConstructor() {
        Assert.assertEquals(0, giftFactory.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateGiftShouldThrowWhenHaveASameType() {
        giftFactory.createGift(giftArrow);
        Assert.assertEquals(1, giftFactory.getCount());
        Gift giftWhitSameType = new Gift("Arrow", 3.00);
        giftFactory.createGift(giftWhitSameType);
    }

    @Test
    public void testCreateGiftShouldCreate() {
        Assert.assertEquals(0, giftFactory.getCount());
        giftFactory.createGift(giftArrow);
        Assert.assertEquals(1, giftFactory.getCount());
        giftFactory.createGift(giftHummer);
        Assert.assertEquals(2, giftFactory.getCount());

    }

    @Test(expected = NullPointerException.class)
    public void testRemoveGiftWithNullNameShouldThrow() {
        giftFactory.createGift(giftArrow);
        giftFactory.removeGift(null);
    }

    @Test(expected = NullPointerException.class)
    public  void testRemoveGiftWithEmptyNameShouldThrow(){
        giftFactory.createGift(giftArrow);
        giftFactory.removeGift("  ");
    }

    @Test
    public void testRemoveGiftShouldRemove(){
        giftFactory.createGift(giftArrow);
        giftFactory.createGift(giftHummer);
        Assert.assertEquals(2,giftFactory.getCount());
        giftFactory.removeGift("Arrow");
        Assert.assertEquals(1,giftFactory.getCount());
    }

    @Test
    public void testGetPresentWithLeastMagicShouldGet(){
        Assert.assertNull(giftFactory.getPresentWithLeastMagic());
        giftFactory.createGift(giftArrow);
        giftFactory.createGift(giftHummer);
        Gift gift = giftFactory.getPresentWithLeastMagic();

        Assert.assertEquals(giftArrow,gift);
    }

    @Test
    public void testGetPresentsShouldReturnUnmodifiableCollection(){
        giftFactory.createGift(giftArrow);
        giftFactory.createGift(giftHummer);

        Collection<Gift> gifts = giftFactory.getPresents();

        Assert.assertEquals("UnmodifiableCollection", gifts.getClass().getSimpleName());
        Assert.assertEquals(gifts.size(),giftFactory.getCount());
    }

    @Test
    public void testGetPresentShouldGetPresentByName(){
        giftFactory.createGift(giftArrow);
        giftFactory.createGift(giftHummer);

        Gift gift = giftFactory.getPresent("Arrow");

        Assert.assertEquals(giftArrow,gift);
    }
    
    @Test
    public void testGetPresentWithMissingNameShouldReturnNull(){
        giftFactory.createGift(giftArrow);
        Gift gift = giftFactory.getPresent("Pesho");
        Assert.assertNull(gift);
    }
}
