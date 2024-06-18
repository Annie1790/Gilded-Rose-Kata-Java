package gildedrose;

public class FabergeStrategy implements Strategy {
    @Override
    public Item handle(Item item) {
        return item;
    }

    @Override
    public boolean isQualityNotMinus(Item item) {
        return true;
    }

    @Override
    public boolean isQualityNoMoreThan50(Item item) {
        return true;
    }

    @Override
    public int increaseQuality(Item item) {
        return 1;
    }

    @Override
    public int decreaseSellIn(Item item) {
        return 1;
    }
}
