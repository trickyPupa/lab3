package characters;

import other.Place;

public class SimpleGnome extends Gnome{
    public SimpleGnome(String nm) {
        super(nm, Place.DINING_ROOM, 80, 10);
    }

    @Override
    public void move(Place loc) {
        floating();
        flip();
        System.out.println(this + " передвигается из " + this.location.toString() + " в " + loc.toString());
        this.location = loc;
    }

    @Override
    public void fail() {
        System.out.println(this.getName() + " мёртв, ничего страшного.");
    }

//    @Override
//    public void do_smth(String verb) {
//
//    }
//
//    @Override
//    public void do_smth_with(String verb, Item item) {
//
//    }
//
//    @Override
//    public void do_with_chance(String verb, Item item, int chance) {
//
//    }
}
