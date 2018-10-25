package us.ncrespo.fruit.model;

import java.util.ArrayList;
import java.util.List;

public class FruitCatalog {

    List<FruitItems> fruit = new ArrayList<>();
    private int itemID = 1;

public List<FruitItems> getFruitItems() {
    fruit.add(new FruitItems(itemID++,
            "Apple",
            8.95,
            "./Includes/image/apple.jpg",
            "Our apples are freshly picked from the finest orchards. All naturally grown with no added preservatives. Enjoy a delicious crisp and juicy taste with each bite." ));
    fruit.add(new FruitItems(itemID++,
            "Orange",
            9.95,
            "./Includes/image/orange.jpg",
            "Who doesn't love oranges. Our oranges are organic and offer the most nutritious and citrus taste that your mouth will love."));
    fruit.add(new FruitItems(itemID++,
            "Lemon",
            5.95,
            "./Includes/image/lemon.jpg",
            "Do you enjoy a nice lemon? Oh come on, who really eats them. But maybe you need them for that company picnic with the open bar? Or maybe a company party at the office. These will add a nice garnish to any drink."));
    fruit.add(new FruitItems(itemID++,
            "Pear",
            9.95,
            "./Includes/image/pear.jpg",
            "The wonderful magic that a pear can bring. Our pears offer the sweetest of tastes and will leave you wanting more with each bite."));
    fruit.add(new FruitItems(itemID++,
            "Peach",
            7.95,
            "./Includes/image/peach.jpg",
            "The best thing about a peach is that first bite that makes your mouth go crazy. After that it just wont stop until it is all gone. Our peaches are guaranteed to be the freshest and sweetest taste around."));
    fruit.add(new FruitItems(itemID++,
            "Cantaloupe",
            9.95,
            "./Includes/image/cantaloupe.jpg",
            " Can't order a fruit cart wihout some cantaloupe. Our cantaloupe are shaved off the rind and packaged so that you arent left with a soggy mess like some other companies do. They are sure to give you that sweet, fresh taste every time."));
    fruit.add(new FruitItems(itemID++,
            "Honey Dew",
            9.95,
            ".Includes/image/melon.png",
            "Ah the honey dew. Always so sweet and usually the first to go with any fruit tray. Our melons taste incredibly sweet and are soft to each bite, leaving that juicy and exhilarating taste."));
    fruit.add(new FruitItems(itemID++,
            "Plum",
            6.95,
            ".Includes/image/plum.jpg",
            "They always say that a good plum will make your pallet go numb...I think? Probably because they are one of the best fruits around for you and ours offer some of the most delicious and unique tastes to any other fruit around."));
    fruit.add(new FruitItems(itemID++,
            "Red Cherry",
            12.95,
            "./Includes/image/cherry.jpg",
            "Cherries are always a party favorite. Mainly because they offer a sweet and fun taste. Which obviously ours provide the most fun and the best flavor. But we also know it's because people like to try tying knots with their tongues."));
    return fruit;
}

    public FruitItems getSingleItem(int itemNum) {
        FruitItems fruit=null;

        for(FruitItems i: getFruitItems()) {
            if (i.getID() == itemNum) {
                return i;
            }
        }
        return fruit;
    }

}
