package _01_;

import java.io.Serializable;

public class AtGuiguDemo implements Serializable,Comparable<AtGuiguDemo> {
    private static final long serialVersionUID = 1L;
    private int id;
    private String info;
    private int num;

    @Override
    public int compareTo(AtGuiguDemo o) {
        return 0;
    }
    public AtGuiguDemo(){}
    public AtGuiguDemo(int id, String info, int num) {
        this.id = id;
        this.info = info;
        this.num = num;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
