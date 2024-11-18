package kr.hs.sdh.toast.entity;

import java.time.LocalDateTime;

public class Bank_Account_Log {
    private final String number;
    private final LocalDateTime date;
    private final String message;
    private final boolean isDeposit;
    private final int beforeMoney;
    private final int money;
    private final int afterMoney;
    private final String target_number;



    public Bank_Account_Log(
            String number,
            LocalDateTime date,
            String message,
            boolean isDeposit,
            int beforeMoney,
            int money,
            int afterMoney,
            String target_number
    ){
        this.number = number;
        this.date = date;
        this.message = message;
        this.isDeposit = isDeposit;
        this.beforeMoney = beforeMoney;
        this.money = money;
        this.afterMoney = afterMoney;
        this.target_number = target_number;
    }

    public String getNumber() {
        return number;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getMessage() {
        return message;
    }

    public boolean isDeposit() {
        return isDeposit;
    }

    public int getBeforeMoney() {
        return beforeMoney;
    }

    public int getMoney() {
        return money;
    }

    public int getAfterMoney() {
        return afterMoney;
    }

    public String getTarget_number() {
        return target_number;
    }
}

