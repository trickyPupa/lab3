package technical;

public interface IDoSmth {
    boolean do_smth(Action action);

    boolean do_smth(Action action, Statused target);

    default void simple_action(String label){
        Action simple_act = new Action(label);
        do_smth(simple_act);
    }

}
