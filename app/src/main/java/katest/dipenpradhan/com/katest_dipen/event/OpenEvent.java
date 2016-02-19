package katest.dipenpradhan.com.katest_dipen.event;

/**
 * Created by dipenpradhan on 2/8/16.
 */
public class OpenEvent {

    public enum Type{CATEGORY, BADGE}

    private Type type;
    private int id;
    private String name;

    public OpenEvent(Type type, int id, String name) {
        this.type = type;
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public Type getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
