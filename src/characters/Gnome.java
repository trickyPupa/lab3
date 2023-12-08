package characters;

import other.Place;
import technical.*;

import java.util.Objects;

public abstract class Gnome extends Statused implements Floatable, IDoSmth {
    static final Action THINK = new Action("думает", Status.CONFUSED, 0, true);
    static final Action FLY = new Action("летит", Status.NO, 0, true);
    static final Action JUMP = new Action("прыгает", Status.NO, 5, true);
    static final Action ASK = new Action("спрашивает", Status.NO, 3, false);
    //static final Action OPEN = new Action("открывает", Status.NO, 3, false);


    protected Place location;
    protected boolean is_floating = false;

    public Gnome(String nm, Place loc, int hp){
        super(nm, hp);
        this.location = loc;
    }

    public String getLocation(){
        return this.location.toString();
    }

    public abstract void move(Place loc);

    @Override
    public void flip(){
        if(is_floating) System.out.println(this + " переворачивается в воздухе головой");
    }

    public void presentation(){
        System.out.println(this + ", находящийся в " + this.getLocation() + " в статусе " + status.getLabel());
    }

    @Override
    public String toString() {
//        return this.getName();
        return "коротышка по имени " + this.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gnome gn = (Gnome) o;
        return Objects.equals(getName(), gn.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name) + Objects.hash(status.getLabel()) + hp + force;
    }

    @Override
    public void floating() {
        is_floating = true;
        System.out.println(this + " плавает в воздухе");
        if (Math.random() < 0.3) this.flip();
        if (Math.random() < 0.3) this.crash();
    }

    @Override
    public void crash() {
        is_floating = false;
        String message = this + " врезается во что-то";
        if (Math.random() < 0.1) {
            takeDamage(1);
            message += " и получает 1 урон";
        }
        System.out.println(message);
    }

    @Override
    public boolean do_smth(Action action) {
        if (action.check(force)){
//            System.out.println(this + " успешно " + action.getStatement());

            setStatus(action.getEffect());

            switch (action.getLabel()){
                case "думает":
                    System.out.println(this + action.getStatement());
                case "летит":
                    if(!is_floating){
                        System.out.println(this + " взлетает ");
                        floating();
                        break;
                    }
                default:
                    System.out.println(this + " успешно " + action.getStatement());
            }
            return true;
        } else{
            System.out.println(this + " безуспешно " + action.getStatement());
            return false;
        }
    }

    @Override
    public boolean do_smth(Action action, Statused target) {
        String message;
        if (action.check(force)){
            //setStatus(action.getEffect());

            switch (action.getLabel()){
                case "наносит урон":
                    System.out.println(this + " успешно " + action.getStatement());
                    target.takeDamage(1 + (int) (Math.random() * 50));
                    break;
                case "спрашивает":
                    System.out.println(this + action.getStatement() + " у " + target);
                    if (target.getStatus() == Status.CONFUSED) {
                        target.takeDamage(1 + (int) (Math.random() * 5));
                    }
                    break;
                default:
                    System.out.println(this + " успешно " + action.getStatement() + " с " + target);
            }

//            System.out.println(message);
            target.setStatus(action.getEffect());
            return true;
        } else{
            System.out.println(this + " безуспешно " + action.getStatement());
            return false;
        }
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

    }

    @Override
    public void heal() {
        hp += 10;
    }

    @Override
    public void setStatus(Status st) {
        if (st.getType() != EntityType.ITEM && status != Status.DEAD){
            status = st;
            System.out.println("Статус " + this + " изменился на " + status.getLabel());
        }
    }

    public void simple_action(String label){
        Action simple_act = new Action(label);
        do_smth(simple_act);
    }
}
