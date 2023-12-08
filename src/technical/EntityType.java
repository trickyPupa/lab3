package technical;

public enum EntityType {
    CREATUE("живое существо"),
    ITEM("предмет"),
    NO("любой");

    private String type;

    EntityType(String type){
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
