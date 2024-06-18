package gildedrose;

public interface Strategy {

    public Item handle(Item item);

    public boolean isQualityNotMinus(Item item);

    public boolean isQualityNoMoreThan50(Item item);

    public int increaseQuality(Item item);

    public int decreaseSellIn(Item item);

    }
