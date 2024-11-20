package kr.hs.sdh.toast.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class BankAccountLog {
    private final String number;
    private final LocalDateTime date;
    private final boolean isDeposit;
    private final int before_money;
    private final int money;
    private final int after_money;

    public BankAccountLog(
            String number,
            LocalDateTime date,

            boolean isDeposit,
            int before_money,
            int money,
            int after_money
    ) {
        this.number = number;
        this.date = date;
        this.isDeposit = isDeposit;
        this.before_money = before_money;
        this.money = money;
        this.after_money = after_money;
    }

    public String getNumber() {
        return number;
    }

    public LocalDateTime  getDate() {
        return date;
    }

    public boolean isDeposit() {
        return isDeposit;
    }

    public int getBefore_money() {
        return before_money;
    }

    public int getMoney() {
        return money;
    }

    public int getAfter_money() {
        return after_money;
    }
}