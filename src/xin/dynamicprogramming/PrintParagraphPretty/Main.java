package xin.dynamicprogramming.PrintParagraphPretty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Xin on 7/31/2016.
 */
public class Main {
    public static Map<String, String> initializeLayout() {
        Map<String, String> layout = new HashMap<>();
        layout.put("1", "1");
        layout.put("2", "ABC2");
        layout.put("3", "DEF3");
        layout.put("4", "GHI4");
        layout.put("5", "JKL5");
        layout.put("6", "MNO6");
        layout.put("7", "PQRS7");
        layout.put("8", "TUV8");
        layout.put("9", "WXYZ");
        layout.put("*", "*");
        layout.put("0", " 0");
        layout.put("#", "#");

        return layout;
    }

    public static void main(String[] args) {
        String text = "aaa bb cc dddd";
        PrintParagraphPretty printParagraphPretty = new PrintParagraphPretty(text, 6);
        System.out.println(printParagraphPretty.printPretty());

        Map<String, String> layout = initializeLayout();
        Map<String, Integer> charCount = new HashMap<>();
        layout.keySet().forEach(key -> {
            String charsHere = layout.get(key);
            for (int i=0; i<charsHere.length(); i++) {
                charCount.put(charsHere.substring(i, i+1), i+1);
            }
        });

        String toType = "HOW R U";
        int count = 0;
        for (int i=0; i<toType.length(); i++) {
            count += charCount.get(toType.substring(i, i+1));
        }
        System.out.println(count);
    }

}
