package technical;

public abstract class Statused {
    protected Status status = Status.NO;
    protected int hp;
    protected int force;
    protected String name;

    public Statused(String name, int hp, int force){
        this.hp = hp;
        this.name = name;
        this.force = force;
    }
    public abstract void takeDamage(int d);
    public abstract void heal();
    public abstract String presentation();
    public Status getStatus(){
        return status;
    }
    public int getForce(){
        return force;
    }
    public abstract void setStatus(Status status);
    public String getName() {
        return name;
    }
    public long getHp() {
        return hp;
    }
}
