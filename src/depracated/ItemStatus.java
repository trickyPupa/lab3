package depracated;

import technical.EntityType;

public enum ItemStatus implements IStatus {
    HOT("Горячий"),
    COLD("Холодный"),
    NO("Без статуса"),
    BROKEN("Сломанный");

    private String label;

    ItemStatus(String label){
        this.label = label;
    }

    public EntityType getType() {
        return EntityType.ITEM;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return "Статус " + label + "у предмета";
    }
}
