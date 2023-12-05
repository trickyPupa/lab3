package characters;

import other.Item;
import other.Place;
import technical.Floatable;
import technical.IDoWithSmth;

import java.lang.reflect.Array;

public class GnomesGroup implements IDoWithSmth, Floatable {
    private SimpleGnome[] gnomes;
    static String[] names = {"Незнайка", "Винтик", "Пилюлькин", "Тюбик", "Сиропчик", "Шпунтик", "Растеряйка",
            "Торопыжка", "Ворчун", "Пончик"};

    public GnomesGroup(String[] names){
        int n = names.length;
        gnomes = new SimpleGnome[n];
        for (int i = 0; i < n; i++) {
            gnomes[i] = new SimpleGnome(names[i]);
        }
    }

    public GnomesGroup(int n){
        gnomes = new SimpleGnome[n];
        for (int i = 0; i < n; i++) {
            gnomes[i] = new SimpleGnome(names[(int) (Math.random() * names.length)]);
        }
    }

    @Override
    public void do_smth(String verb) {
        for (SimpleGnome i : gnomes){
            i.presentation();
            i.do_smth(verb);
        }
    }

    @Override
    public void do_smth(String verb, boolean randAd) {
        for (SimpleGnome i : gnomes){
            i.presentation();
            i.do_smth(verb, randAd);
        }
    }

    @Override
    public void do_smth_with(String verb, Item item, boolean randAd) {
        for (SimpleGnome i : gnomes){
            i.presentation();
            i.do_smth_with(verb, item, randAd);
        }
    }

    @Override
    public void do_smth_with(String verb, Item item) {
        for (SimpleGnome i : gnomes){
            i.presentation();
            i.do_smth_with(verb, item);
        }
    }

    @Override
    public void do_with_chance(String verb, Item item, int chance) {
        for (SimpleGnome i : gnomes){
            i.presentation();
            i.do_with_chance(verb, item, chance);
        }
    }

    @Override
    public void do_with_chance(String verb, Item item, int chance, boolean randAd) {
        for (SimpleGnome i : gnomes){
            i.presentation();
            i.do_with_chance(verb, item, chance, randAd);
        }
    }

    public void move(Place loc) {
        for (SimpleGnome i : gnomes) {
            i.floating();
            i.flip();
            System.out.println(this + " передвигается из " + i.location.toString() + " в " + loc.toString());
            i.location = loc;
        }
    }

    @Override
    public String toString() {
        String[] a = new String[gnomes.length];
        for (int i = 0; i < gnomes.length; i++){
            a[i] = "\"" + gnomes[i].getName() + "\"";
        }
        return "[" + String.join("' ", a) + "]";
    }

    @Override
    public void floating(){

    }

    @Override
    public void flip() {

    }
}
