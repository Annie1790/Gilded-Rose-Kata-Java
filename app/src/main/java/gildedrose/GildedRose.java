package gildedrose;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class GildedRose {
    List<Item> items;

    final String BRIE = "Aged Brie";
    final String PASS = "Backstage passes to a Coldplay concert";
    final String EGG = "Fabergé egg";

    Map<String, Strategy> itemStrategies = Map.of(
            BRIE, new BrieStrategy(),
            EGG, new FabergeStrategy(),
            PASS, new PassStrategy()
    );

    public GildedRose(List<Item> items) {
        this.items = items;
    }

    public void applyStrategy() {
        items = items
                .stream()
                .map(item -> Map.entry(item, findItemWithStrategy(item)))
                .map(itemStrategyEntry ->
                        itemStrategyEntry.getValue().handle(
                                itemStrategyEntry.getKey()
                        ))
                .toList();
    }

    public Strategy findItemWithStrategy(Item item) {
        return (itemStrategies.containsKey(item.name))
                ? itemStrategies.get(item.name)
                : new AnyItemStrategy();
    }

    public void updateQuality() {
        applyStrategy();
//        for (int i = 0; i < items.size(); i++) {
//            if (!items.get(i).name.equals("Aged Brie")
//                    && !items.get(i).name.equals("Backstage passes to a Coldplay concert")) {
//                if (items.get(i).quality > 0) {
//                    if (!items.get(i).name.equals("Fabergé egg")) {
//                        items.get(i).quality = items.get(i).quality - 1;
//                    }
//                }
//            } else {
//                if (items.get(i).quality < 50) {
//                    items.get(i).quality = items.get(i).quality + 1;
//
//                    if (items.get(i).name.equals("Backstage passes to a Coldplay concert")) {
//                        if (items.get(i).sellIn < 11) {
//                            if (items.get(i).quality < 50) {
//                                items.get(i).quality = items.get(i).quality + 1;
//                            }
//                        }
//
//                        if (items.get(i).sellIn < 6) {
//                            if (items.get(i).quality < 50) {
//                                items.get(i).quality = items.get(i).quality + 1;
//                            }
//                        }
//                    }
//                }
//            }
//
//            if (!items.get(i).name.equals("Fabergé egg")) {
//                items.get(i).sellIn = items.get(i).sellIn - 1;
//            }
//
//            if (items.get(i).sellIn < 0) {
//                if (!items.get(i).name.equals("Aged Brie")) {
//                    if (!items.get(i).name.equals("Backstage passes to a Coldplay concert")) {
//                        if (items.get(i).quality > 0) {
//                            if (!items.get(i).name.equals("Fabergé egg")) {
//                                items.get(i).quality = items.get(i).quality - 1;
//                            }
//                        }
//                    } else {
//                        items.get(i).quality = items.get(i).quality - items.get(i).quality;
//                    }
//                } else {
//                    if (items.get(i).quality < 50) {
//                        items.get(i).quality = items.get(i).quality + 1;
//                    }
//                }
//            }
//        }
    }
    
   @Override
   public String toString() {
        var output = "";
        for (var i = 0; i < items.size(); i++)
        {
            if (output.length() > 0)
            {
                output += ", ";
            }
            output += items.get(i).toString();
        }
        return output;
    }
}