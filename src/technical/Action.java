package technical;

public class Action {
//    ACT("делает"),
//    OPEN("открывает"),
//    TALK("говорит"),
//    ASK("спрашивает"),
//    THINK("думает"),
//    DAMAGE("наносит урон");
//    лечит
//    успокаивает
//    бежит
//    летит


    public static final String[] modes = {"оригинально", "смешно", "хорошо", "по-комариному", "приглушенно",
            "внимательно", "лукаво", "тихо", ""};

    private final String label;
    private Status effect;
    private boolean mode = true;
    private long force = 0;

    public Action(String label){
        this.label = label;
        this.effect = Status.NO;
    }
    public Action(String label, Status effect, int force, boolean mode){
        this.label = label;
        this.effect = effect;
        this.force = force;
        this.mode = mode;
    }
    public void setForce(int f){
        force = f;
    }
    public String getLabel(){
        return label;
    }
    public Status getEffect(){
        return effect;
    }
    public void setEffect(Status ef){
        effect = ef;
    }
    public void setMode(boolean mode){
        this.mode = mode;
    }
    public String getStatement(){
        String md = " ";
        if (mode) {
            int a = (int) (Math.random() * modes.length);
            md += modes[a] + " ";
        }
        return md + label;
    }

    public boolean check(long force2){
        return force == 0 || force <= force2;
    }

    @Override
    public String toString() {
        String ans = "Действие: \"" + getLabel() + "\"";
        if (mode) ans += " с возможным случайным образом действия";
        return ans;
    }
}
