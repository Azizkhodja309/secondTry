package toDoProject.enums;

import java.util.StringJoiner;

public enum TaskStatus /*extend Enum*/ {
    CREATED,
    IN_PROGRESS,
    DONE,
    CANCELED,
    DEFAULT
    ;

    private TaskStatus() {
    }

    public static String getAllValuesAsString(){
        TaskStatus[] values = values();
        StringJoiner joiner = new StringJoiner("\n");
        for (TaskStatus value : values) {
            joiner.add(value.ordinal()+1+". "+value);
        }
        return joiner.toString();
    }

    public static TaskStatus getValueByOrder(int order){
        TaskStatus[] values = values();
        for (TaskStatus value : values) {
            if (value.ordinal()==order-1){
                return value;
            }
        }   return DEFAULT;
    }
}

