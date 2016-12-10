package xin.leetcode.textjustification_68;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xin on 10/30/2016.
 */
public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        if (words.length == 0) {
            return result;
        }

        List<String> currLine = new ArrayList<>();
        currLine.add(words[0]);
        int spaceLeft = maxWidth - words[0].length();
        for (int i=1; i<words.length; i++) {
            if (words[i].length() + 1 <= spaceLeft) {
                currLine.add(words[i]);
                spaceLeft -= (1 + words[i].length());
            } else {
                result.add(expand(currLine, maxWidth, false));
                currLine.clear();
                currLine.add(words[i]);
                spaceLeft = maxWidth - words[i].length();
            }
        }
        result.add(expand(currLine, maxWidth, true));
        return result;
    }

    private String expand(List<String> words, int maxWidth, boolean isLast) {
        StringBuilder sb = new StringBuilder();
        int occupiedSpaces = 0;
        for (int i=0; i<words.size(); i++) {
            occupiedSpaces += words.get(i).length();
        }

        int whiteSpaces = maxWidth - occupiedSpaces;
        for (int i=0; i<words.size()-1; i++) {

            int trailing = isLast ? 1 : (int) Math.ceil((double)whiteSpaces/(words.size()-i-1));
            sb.append(words.get(i));
            for (int j=0; j<trailing; j++) {
               sb.append(" ");
            }
            whiteSpaces -= trailing;
        }
        sb.append(words.get(words.size()-1));

        for (int i=0; i<whiteSpaces; i++) {
            sb.append(" ");
        }

        return sb.toString();
    }
}