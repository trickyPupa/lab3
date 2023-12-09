package characters;

import other.Place;
import technical.*;

import java.util.Objects;

public abstract class Gnome extends Statused implements Floatable, IDoSmth {
    public static final Action THINK = new Action("думает", Status.CONFUSED, 0, true);
    public static final Action FLY = new Action("летит", Status.NO, 0, true);
    public static final Action ASK = new Action("спрашивает", Status.NO, 3, false);
    public static final Action ATTACK = new Action("атакует", Status.SCARE, 5, false);
    //static final Action OPEN = new Action("открывает", Status.NO, 3, false);


    protected Place location;
    protected boolean is_floating = false;

    public Gnome(String nm, Place loc, int hp, int force){
        super(nm, hp, force);
        this.location = loc;
    }

    public String getLocation(){
        return this.location.toString();
    }

    public abstract void move(Place loc);
    public abstract void fail();

    @Override
    public void flip(){
        System.out.println(this + " переворачивается в воздухе");
    }

    public String presentation(){
        return this + ", находящийся в " + this.getLocation() + ",\tстатус: " + status.getLabel() + ",\tколичество здоровья: " + hp;
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

            switch (action.getLabel()){
                case "думает":
                    System.out.println(this + action.getStatement());
                    break;
                case "летит":
                    if(!is_floating){
                        System.out.println(this + " взлетает");
                        floating();
                        break;
                    }
                default:
                    System.out.println(this + " успешно" + action.getStatement());
            }
            setStatus(action.getEffect());
            return true;
        } else{
            System.out.println(this + " безуспешно" + action.getStatement());
            return false;
        }
    }

    @Override
    public boolean do_smth(Action action, Statused target) {
//        String message;
        if (action.check(force)){
            //setStatus(action.getEffect());

            switch (action.getLabel()){
                case "атакует":
                    System.out.println(this + " успешно" + action.getStatement() + " " + target.getName());
                    target.takeDamage(5 + (int) (Math.random() * (4 + Math.max(force - target.getForce(), 0))));
                    break;
                case "спрашивает":
                    System.out.println(this + action.getStatement() + " у " + target.getName());
                    break;
                case "лечит":
                    System.out.println(this + action.getStatement() + " " + target.getName());
                    target.heal();
                default:
                    System.out.println(this + " успешно" + action.getStatement() + " " + target.getName());
            }

//            System.out.println(message);
            target.setStatus(action.getEffect());
            return true;
        } else{
            System.out.println(this + " безуспешно" + action.getStatement());
            return false;
        }
    }

    @Override
    public void takeDamage(int d) {
        if (d < hp && d > 0){
            hp -= d;
            force -= (int) (d * 0.1);
            if(hp < 10){
                setStatus(Status.ANXIETY);
            }
        } else if (d >= hp){
            hp = 0;
            setStatus(Status.DEAD);
            return;
        }
    }

    @Override
    public void heal() {
        hp += 10;
        force += 5;
        if (status == Status.INJURED) setStatus(Status.NO);
    }

    @Override
    public void setStatus(Status st) {
        if (st.getType() != EntityType.ITEM && status != Status.DEAD){
            if (status == Status.CONFUSED && st == Status.CONFUSED) {
                takeDamage(1);
            } else if (st == Status.INJURED) {
                force -= 5;
            }
            if (status != st) System.out.println("Статус " + this + " изменился на " + st.getLabel());
            status = st;
            if(status == Status.DEAD) fail();
        }
    }
}
