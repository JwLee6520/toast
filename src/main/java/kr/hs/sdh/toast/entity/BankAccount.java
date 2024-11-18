package kr.hs.sdh.toast.entity;

import java.time.LocalDateTime;

public class BankAccount {
    private final String number;
    private final boolean isFreezed;
    private final String name;
    private final int money;
    private final LocalDateTime createdDay;
    private final String identity;
    private final String uuid;

    public String getNumber() {
        return number;
    }

    public boolean isFreezed() {
        return isFreezed;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public LocalDateTime getCreatedDay() {
        return createdDay;
    }

    public String getIdentity() {
        return identity;
    }

    public String getUuid() {
        return uuid;
    }

    public BankAccount(
            String number,
            boolean isFreezed,
            String name,
            int money,
            LocalDateTime createdDay,
            String identity,
            String uuid
    ){
        this.number = number;
        this.isFreezed = isFreezed;
        this.name = name;
        this.money = money;
        this.createdDay = createdDay;
        this.identity = identity;
        this.uuid = uuid;
    }
}
