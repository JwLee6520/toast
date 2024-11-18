package kr.hs.sdh.toast.entity;

import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

public class Bank {
    private final String uuid;
    private final String name;
    private final String rep;
    private final int sector;
    private final String code;
    private final LocalDateTime establish;

    public Bank(
            String uuid,
            String name,
            String rep,
            int sector,
            String code,
            LocalDateTime establish
    ){
        this.uuid = uuid;
        this.name = name;
        this.rep = rep;
        this.sector = sector;
        this.code = code;
        this.establish = establish;
    }
    public String getUuid() {
        return uuid;
    }


    public String getName() {
        return name;
    }

    public String getRep() {
        return rep;
    }

    public int getSector() {
        return sector;
    }

    public String getCode() {
        return code;
    }

    public LocalDateTime getEstablish() {
        return establish;
    }
}
