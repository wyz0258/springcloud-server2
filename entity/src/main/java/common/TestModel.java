package common;

import java.io.Serializable;

/**
 * @Author : wangyz
 * @Description :
 * @Date :  2017/7/14
 */
public class TestModel implements Serializable{

    private static final long serialVersionUID = 1L;

    private int a;
    private int b;
    private String c;

    @Override
    public String toString() {
        return "TestModel{" +
                "a=" + a +
                ", b=" + b +
                ", c='" + c + '\'' +
                '}';
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }
}
