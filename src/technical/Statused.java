package technical;

public abstract class Statused {
    protected Status status = Status.NO;
    protected int hp;
    protected int force;
    protected String name;

    public Statused(String name, int hp){
        this.hp = hp;
    }
    public abstract void takeDamage(int d);
    public abstract void heal();
    public Status getStatus(){
        return status;
    }
    public abstract void setStatus(Status status);
    public String getName() {
        return name;
    }
    public long getHp() {
        return hp;
    }
}
