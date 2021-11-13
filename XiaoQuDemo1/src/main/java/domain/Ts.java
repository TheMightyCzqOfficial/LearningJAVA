package domain;

public class Ts {
    private int id;
    private String ts_user;
    private String ts_name;
    private String ts_text;
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTs_name() {
        return ts_name;
    }

    public void setTs_name(String ts_name) {
        this.ts_name = ts_name;
    }

    public String getTs_user() {
        return ts_user;
    }

    public void setTs_user(String ts_user) {
        this.ts_user = ts_user;
    }

    public String getTs_text() {
        return ts_text;
    }

    public void setTs_text(String ts_text) {
        this.ts_text = ts_text;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

