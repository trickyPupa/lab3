package other;

public enum Place {
    DINING_ROOM("Столовая"),
    HALL("Коридор"),
    STAIRS("Лестница"),
    UPPER_FLOOR("Верхний этаж");

    private String translation;

    Place(String translation){
        this.translation = translation;
    }

    @Override
    public String toString() {
        return translation;
    }
}
