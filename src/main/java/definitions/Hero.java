package definitions;

public class Hero {
    private String mAlias;
    private int mAge;
    private String mPower;
    private String mKryptonite;

    public Hero(String alias, int age, String power, String kryptonite) {
        this.mAlias = alias;
        this.mAge = age;
        this.mPower = power;
        this.mKryptonite = kryptonite;
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
