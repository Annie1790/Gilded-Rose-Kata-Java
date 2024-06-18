package gildedrose;

public class PassStrategy implements Strategy{
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
        if (!isQualityNoMoreThan50(item)) {
            return item.quality = 50;
        }
        if (!isQualityNotMinus(item)) {
            return item.quality = 0;
        }
        if (isSellInBetween(item, 5, 10)) {
            return item.quality += 2;
        }

        if (isSellInBetween(item, 1, 5)) {
            return item.quality += 3;
        }

        return item.quality += 1;
    }

    @Override
    public int decreaseSellIn(Item item) {
        return item.sellIn -= 1;
    }

    private boolean isSellInBetween(Item item, int num1, int num2) {
        return item.sellIn >= num1 && item.sellIn <= num2;
    }
}
