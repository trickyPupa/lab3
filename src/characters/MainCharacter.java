package characters;

import other.Legs;
import other.Place;
import technical.Status;

public class MainCharacter extends Gnome{
    protected Legs legs;
    public MainCharacter(){
        super("Знайка", Place.UPPER_FLOOR, 100);
        this.legs = new Legs(this, 30);
    }

    @Override
    public void move(Place loc) {
        floating();
        System.out.println(this + " двигается из " + this.location.toString() + " в " + loc.toString());
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

    @Override
    public void crash() {
        super.crash();
        legs.crash();
    }

    public void think(){
        do_smth(THINK);
    }

    @Override
    public void takeDamage(int d) {
        if (d < hp && d > 0){
            hp -= d;
            if(hp < 10){
                setStatus(Status.ANXIETY);
            }
        } else if (d >= hp){
            hp = 0;
            setStatus(Status.DEAD);
        }

        if (d > 10 && Math.random() < (0.3 + 0.1 * (d - 10))){
            legs.injure();
        }
    }

//    @Override
//    public String toString() {
//        return "коротышка по имени " + this.getName() + " со своими ногами";
//    }
}
