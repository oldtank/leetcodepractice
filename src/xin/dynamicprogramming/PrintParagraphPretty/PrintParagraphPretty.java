package xin.dynamicprogramming.PrintParagraphPretty;

import lombok.Data;
import xin.general.GeneralUtil;
import xin.general.TwoDimMatrix;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by Xin on 7/31/2016.
 */
@Data
public class PrintParagraphPretty {

    int lineLength;
    int numOfWords;
    ArrayList<Integer> wordLengths;

    PrintParagraphPretty(String text, int lineLength) {
        StringTokenizer tokenizer = new StringTokenizer(text, " ");
        this.wordLengths = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            wordLengths.add(tokenizer.nextToken().length());
        }
        numOfWords = wordLengths.size();
        this.lineLength = lineLength;
    }

    public int printPretty() {
        ArrayList<Integer> printHelp = GeneralUtil.initializeArrayList(numOfWords );
        // total cost of printing words up to i
        ArrayList<Integer> cost = new ArrayList<>();
        for (int i=0; i<numOfWords; i++) {
            cost.add(Integer.MAX_VALUE);
        }
        cost.set(0, 0);

        // space at the end line after putting word i to j
        TwoDimMatrix<Integer> extra = new TwoDimMatrix<>(numOfWords, numOfWords);
        for (int i = 0; i < numOfWords; i++) {
            extra.set(i, i, lineLength - wordLengths.get(i));
            for (int j = i + 1; j < numOfWords; j++) {
                extra.set(i, j, extra.get(i, j - 1) - wordLengths.get(j) - 1);
            }
        }

        // cost of putting word i to j in one line
        TwoDimMatrix<Integer> lineCost = new TwoDimMatrix<>(numOfWords, numOfWords);
        for (int i = 0; i < numOfWords; i++) {
            for (int j = i; j < numOfWords; j++) {
                if (extra.get(i, j) < 0 ) {
                    lineCost.set(i, j, Integer.MAX_VALUE);
                } else if (j == numOfWords - 1 && extra.get(i, j) >=0 ){
                    // last line
                    lineCost.set(i, j, 0);
                } else {
                    lineCost.set(i, j, extra.get(i, j) * extra.get(i, j) * extra.get(i, j));
                }
            }
        }
        for (int i=0; i<numOfWords; i++) {
            cost.set(i, lineCost.get(0, i));
        }
        for (int i=1; i<numOfWords;i++) {
            for (int j=1; j<=i; j++) {
                if (lineCost.get(j, i) != Integer.MAX_VALUE) {
                    if (cost.get(i) > cost.get(j - 1) + lineCost.get(j, i)) {
                        cost.set(i, cost.get(j - 1) + lineCost.get(j, i));
                        printHelp.set(i, j);
                    }
                }
            }
        }

        return cost.get(numOfWords - 1);
    }
}
