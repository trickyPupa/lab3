import characters.Gnome;
import characters.SimpleGnome;
import characters.MainCharacter;
import other.Item;
import other.Place;
import technical.Action;
import technical.Status;

/*В конце концов Знайка все же придумал хороший способ. Дотянувшись до перил, он стал спускаться,
цепляясь за перила руками. Наверно, со стороны это выглядело очень смешно, потому что Знайкины ноги
болтались в воздухе, как у комара, и по мере того как он опускался все ниже, ноги его задирались
все выше и он все больше перевертывался вниз головой. Спустившись таким оригинальным способом с
лестницы, Знайка очутился в коридоре перед дверью в столовую. Из-за двери доносились какие-то
приглушенные крики. Знайка прислушался и понял, что находившиеся в столовой коротышки чем-то
встревожены. После нескольких неудачных попыток Знайка отворил дверь и очутился в столовой. То, что
он увидел, привело его в изумление. Коротышки, собравшиеся в столовой, не сидели, как всегда, за
столом, а плавали в различных позах по воздуху. Вокруг них плавали стулья, скамейки, миски, тарелки,
ложки. Тут же плавала большая алюминиевая кастрюля, наполненная манной кашей.*/


public class Main {
    public static void main(String[] args) {
        scene2();
    }

/*    public static void actions() {
        // инциализация переменных
        MainCharacter gg = new MainCharacter();

        String[] names = {"Незнайка", "Винтик", "Пилюлькин", "Тюбик", "Сиропчик"};
        SimpleGnome[] gnomes = new SimpleGnome[5];
        for (int i = 0; i < 5; i++) {
            gnomes[i] = new SimpleGnome(names[i]);
        }

        Item railings = Item.RAILING;
        Item door = Item.DOOR;
        Item shouts = Item.SHOUTS;
        Item[] scrap = {Item.BOWL, Item.BENCH, Item.CHAIR, Item.PAN_WITH_PORRIDGE, Item.PLATE,
                Item.SPOON, Item.TABLE};

        // начало действия
        gg.floating();
        gg.think();
        gg.do_smth_with("тянется к", railings);
        gg.do_smth_with("цепляется за", railings);
        gg.move(Place.STAIRS);
        gg.do_smth("спускается");
        gg.move(Place.HALL);
        door.do_smth("находится рядом");
        shouts.do_smth("доносятся");
        gg.do_smth("прислушался");
        gg.do_smth("понял");

        for (SimpleGnome i : gnomes){
            System.out.print("\t");
            i.do_smth("встревожен", false);
        }

        gg.do_with_chance("открывает", door, 0);
        gg.move(Place.DINING_ROOM);
        gg.do_smth("увидел и удивился", false);

        for (SimpleGnome i : gnomes){
            System.out.println(i + ", находящийся в" + i.getLocation());
            i.do_smth("не сидит", false);
            i.floating();
            if(Math.random() > 0.5) i.flip();
        }

        for (Item i: scrap){
            i.floating();
        }
    }*/

    public static void scene2() {
        MainCharacter zn = new MainCharacter();

//        SimpleGnome g1 = new SimpleGnome("Незнайка");
//        SimpleGnome g2 = new SimpleGnome("Винтик");
//        SimpleGnome g3 = new SimpleGnome("Сиропчик");
        SimpleGnome[] gnomes = {new SimpleGnome("Незнайка"), new SimpleGnome("Винтик"), new SimpleGnome("Сиропчик")};
        Item door = new Item("дверь", 2);
        Item railings = new Item("перила", 2);
        Item[] kitchen_items = {new Item("стул", 0), new Item("скамья", 0), new Item("миска", 0),
                new Item("тарелка", 0), new Item("ложка", 0), new Item("кастрюля с кашей", 0)};
        boolean flag;

        zn.do_smth(Gnome.FLY);
        zn.think();

        flag = zn.do_smth(new Action("тянется", Status.NO, railings.getForce(), true), railings);

        if (flag) {
            zn.move(Place.STAIRS);
            flag = zn.do_smth(new Action("открывает"), door);
        } else {
            zn.fail();
            return;
        }

        if (flag) {
            zn.move(Place.HALL);
            for (SimpleGnome i : gnomes){
                i.simple_action("тревожится");
            }
            flag = zn.do_smth(new Action("открывает"), door);
        } else {
            zn.fail();
            return;
        }

        if (flag) {
            zn.move(Place.DINING_ROOM);
            for (SimpleGnome i : gnomes){
                i.floating();
                zn.do_smth(new Action("видит"), i);
                i.do_smth(new Action("удивляет", Status.ASTONISHMENT, 2, false), zn);
            }
            for(Item i : kitchen_items){
                i.floating();
            }

            Item temp = new Item("молчание", 0);
            temp.simple_action("повисло");

            for (SimpleGnome i : gnomes){
                i.do_smth(Gnome.ATTACK, zn);
            }
            flag = zn.getStatus() != Status.DEAD;
        } else {
            zn.fail();
            return;
        }

        if (flag){
            zn.do_smth(new Action("лечит"), zn);
            zn.do_smth(new Action("спасается бегством"));
            zn.move(Place.HALL);
        }
        System.out.println();
        System.out.println("Главный герой - " + zn.presentation());
        System.out.println("Конец");
    }
}