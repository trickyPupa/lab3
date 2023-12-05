package characters;

import other.Place;
import technical.*;

import java.util.Objects;

public abstract class Gnome implements Floatable, IDoWithSmth {
    protected String name;
    protected Place location;

    public Gnome(String nm, Place loc){
        this.name = nm;
        this.location = loc;
    }
    public String getName(){
        return this.name;
    }

    public String getLocation(){
        return this.location.toString();
    }

    public abstract void move(Place loc);

    @Override
    public void flip(){
        System.out.println(toString() + " переворачивается вниз головой");
    }

    public void presentation(){
        System.out.println(this + ", находящийся в " + this.getLocation());
    }

    @Override
    public String toString() {
        return this.getName();
//        return "коротышка по имени " + this.getName();
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
        return Objects.hash(name);
    }

    @Override
    public void floating() {
        System.out.println(toString() + " плавает в воздухе");
    }
}
