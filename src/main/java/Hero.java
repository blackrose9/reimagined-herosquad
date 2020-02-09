import java.util.ArrayList;

public class Hero {
    private String mAlias;
    private int mAge;
    private String mPower;
    private String mKryptonite;
    //.....
    private boolean isInSqua;
    private int id;
    //.....
    private static ArrayList<Hero> instances = new ArrayList<Hero>();

    public Hero(String alias, int age, String power, String kryptonite) {
        this.mAlias = alias;
        this.mAge = age;
        this.mPower = power;
        this.mKryptonite = kryptonite;
        //.....
        this.isInSqua = false;
        instances.add(this);
        this.id = instances.size();
    }

    public static ArrayList<Hero> getAll(){
        return instances;
    }

    public Boolean getIsSqua(){ return this.isInSqua; }

    public String getAlias() {
        return mAlias;
    }

    public void setAlias(String mAlias) {
        this.mAlias = mAlias;
    }

    public int getAge() {
        return mAge;
    }

    public void setAge(int age) {
        this.mAge = age;
    }

    public String getPower() {
        return mPower;
    }

    public void setPower(String power) {
        this.mPower = power;
    }

    public String getKryptonite() {
        return mKryptonite;
    }

    public void setKryptonite(String kryptonite) { this.mKryptonite = kryptonite; }

    public static void retireAllHeroes(){ instances.clear(); }
}
