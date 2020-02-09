import java.util.ArrayList;

public class Squad {
    private String name;
    private String cause;
    private int members;
    private int id;
    private static ArrayList<Squad> instances = new ArrayList<>();

    public Squad(String name, String cause, int members) {
        this.name = name;
        this.cause = cause;
        this.members = members;
        instances.add(this);
        this.id = instances.size();
    }


}
