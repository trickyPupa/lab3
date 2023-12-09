package characters;

import other.Legs;
import other.Place;
import technical.Status;

public class MainCharacter extends Gnome{
    protected Legs legs;
    public MainCharacter(){
        super("Знайка", Place.UPPER_FLOOR, 20, 15);
        this.legs = new Legs(this, 30);
    }

    @Override
    public void move(Place loc) {
        do_smth(Gnome.FLY);
        if (status != Status.INJURED) {
            System.out.println(this + " двигается из " + this.location.toString() + " в " + loc.toString());
            this.location = loc;
        } else if (Math.random() < 0.4){
            System.out.println(this + " с трудом перемеш=щается из " + this.location.toString() + " в " + loc.toString());
            this.location = loc;
        } else {
            System.out.println(this + " не хватает сил переместиться из " + this.location.toString() + " в " + loc.toString());
        }
    }

    @Override
    public void flip() {
        super.flip();
        legs.flip();
        if (Math.random() < 0.3) legs.crash();
    }

    @Override
    public void floating() {
//        super.floating();
        is_floating = true;
        System.out.println(this + " плавает в воздухе");
//        legs.floating();
        if (Math.random() < 0.3) this.flip();
        if (Math.random() < 0.3) legs.crash();
        if (Math.random() < 0.3) this.crash();
    }

    @Override
    public void crash() {
//        super.crash();
        is_floating = false;
        String message = this + " врезается во что-то";
        if (Math.random() < 0.1) {
            takeDamage(1);
            message += " и получает 1 урон";
        }
        System.out.println(message);
    }

    public void think(){
        do_smth(THINK);
    }

    @Override
    public void takeDamage(int d) {
        super.takeDamage(d);

        if (d > 6 && Math.random() < (0.3 + 0.05 * (d - 10))){
            legs.injure();
        }
    }

    public void fail(){
        System.out.println(this.getName() + " не справился. Сцена окончена.");
    }

//    @Override
//    public String toString() {
//        return "коротышка по имени " + this.getName() + " со своими ногами";
//    }
}
