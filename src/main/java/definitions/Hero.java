package definitions;

import java.util.ArrayList;

public class Hero {
    private String mAlias;
    private int mAge;
    private String mPower;
    private String mKryptonite;

    private static ArrayList<Hero> instances = new ArrayList<Hero>();

    public Hero(String alias, int age, String power, String kryptonite) {
        this.mAlias = alias;
        this.mAge = age;
        this.mPower = power;
        this.mKryptonite = kryptonite;

        instances.add(this);
//      instances.addAll(mAge, mAlias, mKryptonite, mPower);
    }

    public static ArrayList<Hero> getAll(){
        return instances;
    }

    public static void retireAllHeroes(){
        instances.clear();
    }

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

    public void setKryptonite(String kryptonite) {
        this.mKryptonite = kryptonite;
    }
}
