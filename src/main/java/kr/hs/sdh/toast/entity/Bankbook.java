package kr.hs.sdh.toast.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;


public class Bankbook {
    private final String uuid;
    private final String name;
    private final BigDecimal intRate;
    private final boolean withdrawal;
    private final LocalDateTime regStDate;
    private final LocalDateTime regEdDate;
    private final String b_uuid;

    public Bankbook(
            String uuid,
            String name,
            BigDecimal intRate,
            boolean withdrawal,
            LocalDateTime regStDate,
            LocalDateTime regEdDate,
            String b_uuid
    ){
        this.uuid = uuid;
        this.name = name;
        this.intRate = intRate;
        this.withdrawal = withdrawal;
        this.regStDate = regStDate;
        this.regEdDate = regEdDate;
        this.b_uuid = b_uuid;
    }
    public String getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getIntRate() {
        return intRate;
    }

    public boolean isWithdrawal() {
        return withdrawal;
    }

    public LocalDateTime getRegStDate() {
        return regStDate;
    }

    public LocalDateTime getRegEdDate() {
        return regEdDate;
    }

    public String getB_uuid() {
        return b_uuid;
    }
}
