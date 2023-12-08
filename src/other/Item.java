package other;

import characters.Gnome;
import technical.*;

import java.util.Objects;

public class Item extends Statused implements Floatable, IDoSmth {
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

    Item (String name){
        super(name, 2);
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
        if (Math.random() > 0.5) this.crash();
    }


    @Override
    public String toString() {
        return "Предмет " + name + " в статусе " + status.getLabel();
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

    public String getName() {
        return name;
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
            System.out.println(this + " успешно " + action.getStatement() + " с " + target);

            target.setStatus(action.getEffect());
            return true;
        } else{
            System.out.println(this + " безуспешно " + action.getStatement() + " с " + target);
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
    public void setStatus(Status stat) {
        if (stat.getType() != EntityType.CREATUE && (status != Status.DESTROYED || status != Status.BROKEN)) {
            status = stat;
            System.out.println("Статус " + this.getName() + " изменился на " + status.getLabel());
        }
    }
}
