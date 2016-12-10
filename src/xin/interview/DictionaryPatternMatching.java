package xin.interview;

import xin.general.GeneralUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * "abc"<--  "cdf", "too", "hgfdt", "paa" -> "cdf"
 * "acc" <--"cdf", "too", "hgfdt", "paa"  -> "too", "paa"
 */
public class DictionaryPatternMatching {
    public static void main(String[] args) {
        String pattern = "accb";
        ArrayList<String> dictionary = new ArrayList<>();
        dictionary.add("cdf");
        dictionary.add("toow");
        dictionary.add("hgfdt");
        dictionary.add("paa");

        System.out.println(match(pattern, dictionary));
    }

    public static ArrayList<String> match(String pattern, ArrayList<String> dictionary) {
        ArrayList<String> matched = new ArrayList<>();
        for (String word : dictionary) {
            if (word.length() == pattern.length()) {
                Map<String, String> mapping_from_pattern = new HashMap<String, String>();
                Map<String, String> mapping_from_word = new HashMap<>();
                boolean match = true;
                for (int i=0; i<word.length(); i++) {
                    String in_word = word.substring(i, i+1);
                    String in_pattern = pattern.substring(i, i+1);
                    if (mapping_from_pattern.get(in_pattern) == null && mapping_from_word.get(in_word) == null) {
                        mapping_from_pattern.put(in_pattern, in_word);
                        mapping_from_word.put(in_word, in_pattern);
                    } else if ( (mapping_from_pattern.get(in_pattern) != null && mapping_from_word.get(in_word) == null) ||
                            (mapping_from_pattern.get(in_pattern) == null && mapping_from_word.get(in_word) != null) ) {
                        match = false;
                        break;
                    } else {
                        if (!mapping_from_pattern.get(in_pattern).equals(in_word) ||
                                !mapping_from_word.get(in_word).equals(in_pattern)) {
                            match = false;
                            break;
                        }
                    }
                }
                if (match) {
                    matched.add(word);
                }
            }
        }
        return matched;
    }
}
