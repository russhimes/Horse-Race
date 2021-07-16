package model;

import java.math.BigDecimal;

public class Player {
    private BigDecimal money;

    public Player(BigDecimal money) {
        this.money = money;
    }

    public BigDecimal getMoney(){
        return this.money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}
