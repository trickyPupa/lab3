package characters;

import other.Item;
import other.Place;

public class Znaika extends Gnome{
    protected Legs legs;
    public Znaika(){
        super("Знайка", Place.UPPER_FLOOR);
        this.legs = new Legs(this);
    }

    @Override
    public void move(Place loc) {
        floating();
        flip();
        System.out.println(this + " передвигается из " + this.location.toString() + " в " + loc.toString());
        this.location = loc;
    }

    @Override
    public void flip() {
        super.flip();
        legs.flip();
    }

    @Override
    public void floating() {
        super.floating();
        legs.floating();
    }

    public void think(){
        do_smth_with("думает о", Item.METHOD);
    }

    //    @Override
//    public void do_smth(String verb) {
//        System.out.println(this + " " + verb);
//    }
//
//    @Override
//    public void do_smth_with(String verb, Item item) {
//        System.out.println(this + " " + verb + " " + item);
//    }
//
//    @Override
//    public void do_with_chance(String verb, Item item, int chance) {
//        if (Math.random() >= chance / 100.0){
//            System.out.println(this + " наконец " + verb + " " + item);
//        } else {
//            System.out.println(this + " пытается " + verb + " " + item + ", но не выходит");
//        }
//    }
}
