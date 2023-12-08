package depracated;

public class RandomAdverb {
    static final String[] adverbs = {"оригинально", "смешно", "хорошо", "по-комариному", "приглушенно", "встревоженно",
            "изумлённо", "внимательно", ""};
    public static String adverb(){
        int a = (int) (Math.random() * adverbs.length);
        return adverbs[a];
    }
}
