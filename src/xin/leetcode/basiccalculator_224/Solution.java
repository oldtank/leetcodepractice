package xin.leetcode.basiccalculator_224;

import java.util.Stack;

/**
 * Created by Xin on 9/17/2016.
 */
public class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int sign = 1;
        int result = 0;
        int currNumber = 0;
        for (char c : s.toCharArray()) {
            if (c >='0' && c<='9') {
                currNumber = currNumber*10+(c-'0');
            } else if (c == '+' || c == '-') {
                result += currNumber * sign;
                currNumber = 0;
                sign = c=='+' ? 1 : -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                currNumber = 0;
                result = 0;
                sign=1;
            } else if (c == ')') {
                result += currNumber * sign;
                result *= stack.pop();
                result += stack.pop();
                currNumber = 0;
            }
        }

        result += sign*currNumber;
        return result;
    }


    public int calculateSlow(String s) {
        if (s==null || s.length() == 0) {
            return 0;
        }
        String simple = simplifyWithBracket(s, 0, s.length()-1, false);
        System.out.println("Simple expression: " + simple);
        return calculateHelper2(simple);
    }

    public int calculateHelper2(String s) {
        int result = 0;
        int pos = findNextNonNum(s, 0);
        result = Integer.parseInt(s.substring(0, pos));
        while (pos != s.length()) {
            char operator = s.charAt(pos);
            pos ++;
            int next_pos = findNextNonNum(s, pos);
            int operand;
            if (next_pos >=0) {
                operand = Integer.parseInt(s.substring(pos, next_pos));
            } else {
                operand = Integer.parseInt(s.substring(pos));
            }

            switch(operator) {
                case '+': result += operand;
                    break;
                case '-': result -= operand;
                    break;
            }

            pos = next_pos;
        }

        return result;
    }

    public String simplifyWithBracket(String s, int start, int end, boolean reverse) {
        if (start > end) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        char lastOperator='+';
        for (int i=start; i<=end; i++) {
            if (s.charAt(i) == ' ') {
                continue;
            } else if (isDigit(s.charAt(i))) {
                sb.append(s.charAt(i));
            } else if (isOperator(s.charAt(i))) {
                char c = s.charAt(i);
                if (!reverse) {
                    sb.append(c);
                } else {
                    switch(c) {
                        case '+': sb.append('-');
                            break;
                        case '-': sb.append('+');
                            break;
                    }
                }
                if ( (reverse && c=='+') || (!reverse && c=='-')) {
                    lastOperator = '-';
                }
                if ((reverse && c=='-') || (!reverse && c=='+')) {
                    lastOperator = '+';
                }

            } else if (s.charAt(i) == '(') {
                int closingPos = findClosing(s, i);
                System.out.println("doing subproblem: "+s.substring(i, closingPos+1)+ " lastOperator: "+lastOperator);
                sb.append(simplifyWithBracket(s, i+1, closingPos-1, lastOperator == '-'));
                lastOperator= '+';
                i = closingPos;
            }
        }
        return sb.toString();
    }

    private boolean isDigit(char c) {
        return c>='0' && c<='9';
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-';
    }

    public int findNextNonNum(String s, int start) {
        int right = start;
        while (right < s.length()) {
            if (s.charAt(right) >= '0' && s.charAt(right) <= '9') {
                right++;
            } else {
                return right;
            }
        }
        return right;
    }

    public int findClosing(String s, int start) {
        int pos = start+1;
        int rightToSkip = 0;
        while (pos < s.length()) {
            if (s.charAt(pos) == '(') {
                rightToSkip ++;
            } else if (s.charAt(pos) == ')') {
                if (rightToSkip>0) {
                    rightToSkip--;
                } else {
                    return pos;
                }
            }
            pos++;
        }
        return -1;
    }
}