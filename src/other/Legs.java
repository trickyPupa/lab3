package other;

import characters.Gnome;
import technical.Floatable;

import java.util.Objects;

public class Legs implements Floatable {
    private Gnome owner;
    private boolean injured = false;
    private int length;

    public Legs(Gnome owner, int length){
        this.owner = owner;
        this.length = length;
    }
    public Gnome getOwner(){
        return owner;
    }
    public void flip() {
        System.out.println(this + " задрались вверх");
    }

    @Override
    public void crash() {
        System.out.println(owner + " ударился ногами");
        if (Math.random() < 0.2 + (length * 0.005)) injure();
    }

    @Override
    public void floating() {
        System.out.println(this + " плавают в воздухе");
    }

    public void injure(){
        injured = true;
        System.out.println(owner + " повредил свои ноги");
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
        return Objects.hash(this.toString());
    }


}
