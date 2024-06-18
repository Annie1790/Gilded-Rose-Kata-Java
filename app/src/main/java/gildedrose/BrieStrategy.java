package gildedrose;

public class BrieStrategy implements Strategy{
    @Override
    public Item handle(Item item) {
        return new Item(
                item.name,
                decreaseSellIn(item),
                increaseQuality(item)
        );
    }

    @Override
    public boolean isQualityNotMinus(Item item) {
        return item.quality >= 0;
    }

    @Override
    public boolean isQualityNoMoreThan50(Item item) {
        return item.quality <= 50;
    }

    @Override
    public int increaseQuality(Item item) {
        if (isQualityNoMoreThan50(item)) {
            return item.quality += 1;
        }

        if (!isQualityNotMinus(item)) {
            return item.quality += 2;
        }
        return item.quality;
    }

    @Override
    public int decreaseSellIn(Item item) {
        return item.sellIn -= 1;
    }

}
