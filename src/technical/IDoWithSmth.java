package technical;

import other.Item;

public interface IDoWithSmth extends IDoSmth {
   default void do_smth_with(String verb, Item item){
        System.out.println(this + " " + RandomAdverb.adverb() + " " + verb + " " + item );
   }

    default void do_smth_with(String verb, Item item, boolean randAd){
       if (randAd) System.out.println(this + " " + RandomAdverb.adverb() + " " + verb + " " + item );
       else System.out.println(this + " " + verb + " " + item );
    }

    default void do_with_chance(String verb, Item item, int chance){
       while (Math.random() < chance / 100.0) {
           System.out.println(this + " пытается " + verb + " " + item + ", но не выходит");
           chance += 30;
       }
       System.out.println(this + " после нескольких попыток " + RandomAdverb.adverb() + " " + verb + " " + item);

    }

    default void do_with_chance(String verb, Item item, int chance, boolean randAd){
       int i = 0;
        while (Math.random() < chance / 100.0) {
            System.out.println(this + " пытается " + verb + " " + item + ", но не выходит");
            chance += 30;
            i++;
        }
        if (randAd) System.out.println(this + " после " + i + " попыток " + RandomAdverb.adverb() + " " + verb + " " + item);
        else System.out.println(this + " после " + i + " попыток " + verb + " " + item);
    }
}
