package other;

import technical.Floatable;
import technical.IDoSmth;

public enum Item implements Floatable, IDoSmth {
    DOOR("Дверь"),
    RAILING("Перила"),
    TABLE("Стол"),
    CHAIR("Стул"),
    PAN_WITH_PORRIDGE("Кастрюля с манной кашей"),
    SPOON("Ложка"),
    BENCH("Скамейка"),
    PLATE("Тарелка"),
    BOWL("Миска"),
    SHOUTS("Крики"),
    METHOD("Способ");

    private String name;

    Item (String name){
        this.name = name;
    }

    @Override
    public void flip() {
        System.out.println(this + " переворачивается в воздухе");
    }

    @Override
    public void floating() {
        System.out.println(this + " плавает в воздухе");
    }

    @Override
    public String toString() {
        return name;
    }
}
