package technical;

public enum Status {
    NO("Без статуса", EntityType.NO),
    BROKEN("Сломан", EntityType.ITEM),
    ASTONISHMENT("Изумление", EntityType.CREATUE),
    ANXIETY("Тревога", EntityType.CREATUE),
    DEAD("Мёртв", EntityType.CREATUE),
    DESTROYED("Уничтожен", EntityType.ITEM),
    INJURED("Ранен", EntityType.CREATUE),
    SCARE("Страх", EntityType.CREATUE),
    CONFUSED("Озадаченность", EntityType.CREATUE);

//    public static String[] item_statuses = {};
//    public static String[] creature_statuses = {};

    private final String label;
    private final EntityType type;

    Status(String label, EntityType type){
        this.label = label;
        this.type = type;
    }

    public EntityType getType() {
        return type;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return "Статус " + label + "у объекта типа " + type;
    }
}