package fairyShop.models;

public class ShopImpl implements Shop {
    private int brokenInstruments;

    public ShopImpl() {
    }

    @Override
    public void craft(Present present, Helper helper) {

        if (helper.canWork()) {
            for (Instrument instrument : helper.getInstruments()) {
                while (!instrument.isBroken()) {
                    if (!present.isDone()) {
                        present.getCrafted();
                        helper.work();
                        instrument.use();
                    } else {
                        break;
                    }
                }
            }
        }


    }
}
