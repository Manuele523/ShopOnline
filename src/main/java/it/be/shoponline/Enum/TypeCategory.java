package it.be.shoponline.Enum;

import java.util.Arrays;

public enum TypeCategory {
    TUBER("tuber"),
    VEGETABLE("vegetable"),
    FRUIT("fruit"),
    MEAT("meat");

    private String typeCategory;

    TypeCategory(String typeCategory) {
        this.typeCategory = typeCategory;
    }

    public static String getEnumByName(String category) {
        return Arrays.stream(TypeCategory.values())
                .filter(enume -> enume.typeCategory.equals(category.toLowerCase()))
                .findFirst()
                .get().name();
    }
}
