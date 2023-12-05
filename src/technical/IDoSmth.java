package technical;

public interface IDoSmth {
    default void do_smth(String verb){
        System.out.println(this + " " + RandomAdverb.adverb() + " " + verb);
    }

    default void do_smth(String verb, boolean randAd){
        if (randAd) do_smth(verb);
        else System.out.println(this + " " + verb);
    }
}
