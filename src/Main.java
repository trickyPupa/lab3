import characters.SimpleGnome;
import characters.Znaika;
import other.Item;
import other.Place;

public class Main {
    public static void main(String[] args) {
        actions();
    }

    public static void actions() {
        // инциализация переменных
        Znaika gg = new Znaika();

        String[] names = {"Незнайка", "Винтик", "Пилюлькин", "Тюбик", "Сиропчик"};
        SimpleGnome[] gnomes = new SimpleGnome[5];
        for (int i = 0; i < 5; i++) {
            gnomes[i] = new SimpleGnome(names[i]);
        }

//        GnomesGroup gnomes = new GnomesGroup(names);

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
//        gnomes.do_smth("встревожен");

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
    }
}