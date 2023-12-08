package depracated;

import technical.EntityType;

// для реализации только enum
public interface IStatus {
    EntityType getType();
    String getLabel();
}
