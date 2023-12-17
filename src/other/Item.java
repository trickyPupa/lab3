package other;

import technical.*;

import java.util.Objects;

public class Item extends Statused {
//    DOOR("Дверь"),
//    RAILING("Перила"),
//    TABLE("Стол"),
//    CHAIR("Стул"),
//    PAN_WITH_PORRIDGE("Кастрюля с манной кашей"),
//    SPOON("Ложка"),
//    BENCH("Скамейка"),
//    PLATE("Тарелка"),
//    BOWL("Миска"),
//    SHOUTS("Крики"),
//    METHOD("Способ");

    public Item (String name, int force){
        super(name, 2, force);
    }

    @Override
    public void flip() {
        System.out.println(this.getName() + " переворачивается в воздухе");
    }

    @Override
    public void crash() {
        System.out.println(this + " врезался во что-то");
        if (Math.random() < 0.1) takeDamage(1);
    }

    @Override
    public void floating() {
        System.out.println(this.getName() + " плавает в воздухе");
        if (Math.random() < 0.5) this.flip();
        if (Math.random() < 0.5) this.crash();
    }


    @Override
    public String toString() {
        return "Предмет " + name;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item gn = (Item) o;
        return Objects.equals(getName(), gn.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name) + hp + Objects.hash(status.getLabel());
    }

    @Override
    public boolean do_smth(Action action) {
        if (action.check(force)){
            System.out.println(this + " успешно " + action.getStatement());

            setStatus(action.getEffect());
            return true;
        } else{
            System.out.println(this + " безуспешно " + action.getStatement());
            return false;
        }
    }

    @Override
    public boolean do_smth(Action action, Statused target) {
        if (action.check(force)){
            System.out.println(this + " успешно " + action.getStatement() + " " + target);

            target.setStatus(action.getEffect());
            return true;
        } else{
            System.out.println(this + " безуспешно " + action.getStatement() + " " + target);
            return false;
        }
    }

    @Override
    public void takeDamage(int d) {
        if (d == 1){
            hp -= 1;
        } else if (d > 1){
            hp = 0;
        }

        if (hp == 1) {
            setStatus(Status.BROKEN);
        } else if (hp == 0) {
            setStatus(Status.DESTROYED);
        }
    }

    @Override
    public void heal() {
        if (hp != 0) hp = 2;
    }

    @Override
    public String presentation() {
        return this + ",\tстатус: " + status.getLabel();
    }

    @Override
    public void setStatus(Status st) {
        if (st.getType() != EntityType.CREATUE && status != Status.DESTROYED && status != Status.BROKEN && status != st) {
            System.out.println("Статус " + this.getName() + " изменился на " + st.getLabel());
            status = st;
        }
    }
}
