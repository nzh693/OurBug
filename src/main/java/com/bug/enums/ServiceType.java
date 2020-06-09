package com.bug.enums;

/*
 *   Author = Liewona
 *   Date = 2020/6/9 8:55
 */
public enum ServiceType {
    CONSULT("咨询") ,
    COMPLAIN("投诉"),
    ADVISE("建议")
    ;

    private String value;

    ServiceType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
