package it.be.shoponline.Enum;

import java.util.Arrays;

public enum StatusCode {

    OK_INSERT("ok_insert", "Insert successful!"),
    KO_INSERT("ko_insert", "Insert Error!"),
    OK_UPDATE("ok_update", "Update successful!"),
    KO_UPDATE("ko_update", "Update Error!"),
    OK_DELETE("ok_delete", "Delete successful!"),
    KO_DELETE("ko_delete", "Delete Error!");

    private String code;
    private String description;

    StatusCode(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static String getEnumByName(String stCode) {
        return Arrays.stream(StatusCode.values())
                .filter(enume -> enume.code.equals(stCode.toLowerCase()))
                .findFirst()
                .get().name();
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}