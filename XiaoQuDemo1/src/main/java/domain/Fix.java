package domain;

public class Fix {
    private int id;
    private String fix_user;
    private String fix_name;
    private String fix_text;
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFix_user() {
        return fix_user;
    }

    public void setFix_user(String fix_user) {
        this.fix_user = fix_user;
    }

    public String getFix_name() {
        return fix_name;
    }

    public void setFix_name(String fix_name) {
        this.fix_name = fix_name;
    }

    public String getFix_text() {
        return fix_text;
    }

    public void setFix_text(String fix_text) {
        this.fix_text = fix_text;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
