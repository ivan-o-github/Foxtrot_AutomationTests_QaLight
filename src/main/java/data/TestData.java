package data;

import java.util.HashMap;

public class TestData {
    public static final String IPHONE_14_QUERY = "iPhone 14";
    public static final String CATEGORY_QUERY = "Навушники";
    public static HashMap<String, String> categories = new HashMap<>();

    public static void setCategories() {
        categories.put("Пилососи", "pylesosy");
        categories.put("Пылесосы", "pylesosy");
        categories.put("Навушники", "naushniki");
        categories.put("Наушники", "naushniki");
        categories.put("Смартфони", "mobilnye_telefony_smartfon");
        categories.put("Смартфоны", "mobilnye_telefony_smartfon");
        categories.put("Ноутбуки", "noutbuki");
        categories.put("Ноутбуки", "noutbuki");
        categories.put("Телевізори", "led_televizory");
        categories.put("Телевизоры", "led_televizory");
    }
}
