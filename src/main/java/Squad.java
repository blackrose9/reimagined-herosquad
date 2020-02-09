import java.util.ArrayList;
import java.util.Collection;

public class Squad {
    private String name;
    private String cause;
    private int members;
    private String teamcolor;
    private int id;
    private static ArrayList<Squad> instances = new ArrayList<>();

    public Squad(String name, String cause, int members, String teamcolor) {
        this.name = name;
        this.cause = cause;
        this.members = members;
        this.teamcolor = teamcolor;
        instances.add(this);
        this.id = instances.size();
    }

    public String getName() { return name; }

    public String getCause() { return cause; }

    public int getMembers() { return members; }

    public String getTeamcolor() { return teamcolor; }

    public static ArrayList<Squad> getAll() { return instances; }

    public static Squad findById(int id) {
        return instances.get(id-1); //because arrayLists start from 0
    }
    public int getId() { return id; }

    public static void clearAllSquads(){ instances.clear(); }
}
