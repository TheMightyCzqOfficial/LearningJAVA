package domain;

import java.sql.Date;

public class Data {
    private int id;
    private String code;
    private Date trade_date;
    private String open;
    private String high;
    private String low;
    private String close;
    private String pre_close;
    private String change_amount;
    private String pct_chg;
    private String vol;
    private String amount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getTrade_date() {
        return trade_date;
    }

    public void setTrade_date(Date trade_date) {
        this.trade_date = trade_date;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public String getPre_close() {
        return pre_close;
    }

    public void setPre_close(String pre_close) {
        this.pre_close = pre_close;
    }

    public String getChange_amount() {
        return change_amount;
    }

    public void setChange_amount(String change_amount) {
        this.change_amount = change_amount;
    }

    public String getPct_chg() {
        return pct_chg;
    }

    public void setPct_chg(String pct_chg) {
        this.pct_chg = pct_chg;
    }

    public String getVol() {
        return vol;
    }

    public void setVol(String vol) {
        this.vol = vol;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", trade_date=" + trade_date +
                ", open='" + open + '\'' +
                ", high='" + high + '\'' +
                ", low='" + low + '\'' +
                ", close='" + close + '\'' +
                ", pre_close='" + pre_close + '\'' +
                ", change_amount='" + change_amount + '\'' +
                ", pct_chg='" + pct_chg + '\'' +
                ", vol='" + vol + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }
}
