import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        String str = new String();
        File myFile = new File("input.txt");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(myFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        byte[] buffer = new byte[1024];
        int bytes;
        while ((bytes = fis.read(buffer)) != -1) {
            str = new String(buffer, 0, bytes);
            System.out.println(str);
            System.out.println();
        }
        fis.close();

        String[] produkt = new String[] {};
        produkt = str.split("\\s+");

        Map<String, Integer> length = new HashMap<>();
        for (String i : produkt) {
            length.putIfAbsent(i, i.length());
        }
        ArrayList<Integer> valueList = new ArrayList<>(length.values());
        Integer maxLength = Collections.max(valueList);
        String maxWord = null;
        for (String i : produkt) {
            if (i.length() == maxLength)
                maxWord = i;
        }

        Map<String, Integer> timeMap = new HashMap<>();
        for (String i : produkt) {
            if (timeMap.containsKey(i)) {
                timeMap.put(i, timeMap.get(i) + 1);
            } else {
                timeMap.put(i, 1);
            }
        }
        ArrayList<Integer> valueList2 = new ArrayList<>(timeMap.values());
        Integer timesWord = Collections.max(valueList2);
        String timeWords = null;
        for (var item : timeMap.entrySet()) {
            if (item.getValue() == timesWord)
                timeWords = item.getKey();
        }

        System.out.println("Мы взяли с собой на пикник фрукты и овощи: " + produkt.length +
                "\nСамое длинное название продукта: " + maxWord + ". \n" +
                "Наибольшее количество количество продуктов, которые у нас есть: " + timeWords);
    }
}