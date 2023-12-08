package depracated;

import technical.EntityType;

public enum CreatureStatus implements IStatus {
    ASTONISHMENT("Изумление"),
    ANXIETY("Тревога"),
    CONFUSED("Озадаченность");



    private String label;

    CreatureStatus(String label) {
        this.label = label;
    }

    @Override
    public EntityType getType() {
        return EntityType.CREATUE;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return "Статус " + label + "у существа";
    }
}
