package client;

import java.io.Serializable;

public class Coin implements Serializable {
    private int price;
    private String name;
    private int changeRate;

    public Coin(int price, String name, int changeRate) {
        this.price = price;
        this.name = name;
        this.changeRate = changeRate;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("이름 : ");
        sb.append(name);
        sb.append("\n가격 : ");
        sb.append(price);
        sb.append("\n변동률 : ");
        sb.append(changeRate);
        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public int getChangeRate() {
        return changeRate;
    }

    public int getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setChangeRate(int changeRate) {
        this.changeRate = changeRate;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
