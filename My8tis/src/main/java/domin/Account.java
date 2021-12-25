package My8tis.src.main.java.domin;

public class Account {
    private int aid;
    private int sid;
    private String sname;
    private int money;

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "aid=" + aid +
                ", sid=" + sid +
                ", sname='" + sname + '\'' +
                ", money=" + money +
                '}';
    }
}
