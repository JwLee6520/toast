package kr.hs.sdh.toast.entity;

import java.time.LocalDateTime;

public class BankAccountHistory {
    private final int amount;
    private final int beforeAmount;
    private final String memo;
    private final boolean type;
    private final LocalDateTime transDateTime;
    public BankAccountHistory(
            int amount,
            int beforeAmount,
            String memo,
            boolean type,
            LocalDateTime transDateTime
    ){
        this.amount = amount;
        this.beforeAmount = beforeAmount;
        this.memo = memo;
        this.type = type;
        this.transDateTime = transDateTime;
    }

    public int getAmount() {
        return amount;
    }

    public int getBeforeAmount() {
        return beforeAmount;
    }

    public String getMemo() {
        return memo;
    }

    public boolean isType() {
        return type;
    }

    public LocalDateTime getTransDateTime() {
        return transDateTime;
    }
}
