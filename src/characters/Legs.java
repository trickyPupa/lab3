package characters;

import technical.IDoSmth;
import technical.Floatable;

import java.util.Objects;

public class Legs implements IDoSmth, Floatable {
    private Gnome owner;

    Legs(Gnome owner){
        this.owner = owner;
    }
    public Gnome getOwner(){
        return owner;
    }
    public void flip() {
        System.out.println(toString() + " задрались вверх");
    }

    @Override
    public void floating() {
        System.out.println(toString() + " плавают в воздухе");
    }

    @Override
    public String toString(){
        return "ноги " + owner.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gnome gn = ((Legs) o).getOwner();
        return Objects.equals(owner, gn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner.toString());
    }
}
