package kakao.two;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

class Solution {
    public long solution(String expression) {
        String[][] mode = {{"+", "-", "*"}, {"-", "+", "*"}, {"+", "*", "-"}, {"*", "-", "+"}, {"*", "+", "-"}, {"-", "*", "+"}};
        long[] result=new long[6];
        for(int i=0; i<6; i++){
            Long postfix = calInfix(expression, mode[i]);
            result[i]=Math.abs(postfix);
        }
        Arrays.sort(result);
        long answer = result[5];
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        long result=solution.solution("50*6-3*2");
        System.out.println(result);
//        solution.split("100-200*300-500+20");
    }

    public Long calInfix(String input, String[] priority) {
        String[] testCase = split(input);
        Stack<String> result = new Stack<>();
        Stack<String> operator = new Stack<>();
        for (int i = 0; i < testCase.length; i++) {
            if (testCase[i].equals(priority[0])) {
                while (!operator.isEmpty()) {
                    result.push(operator.pop());
                }
                operator.push(testCase[i]);
            } else if (testCase[i].equals(priority[1])) {
                while (!operator.isEmpty() && (operator.peek().equals(priority[1]) || operator.peek().equals(priority[2]))) {
                    result.push(operator.pop());
                }
                operator.push(testCase[i]);
            } else if (testCase[i].equals(priority[2])) {
                while (!operator.isEmpty() && operator.peek().equals(priority[2])) {
                    result.push(operator.pop());
                }
                operator.push(testCase[i]);
            } else {
                result.push(testCase[i]);
            }

            if (i == testCase.length - 1) {
                while (operator.size() != 0)
                    result.push(operator.pop());
            }
        }
        Object[] result2Array = result.toArray();
        long res=calPostfix(result2Array);
        return res;
    }

    public long calPostfix(Object[] postfix) {
        Stack<Long> stack = new Stack<>();
        for (int i = 0; i < postfix.length; i++) {
            long b;
            long a;
            switch ((String) postfix[i]) {
                case "+":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a + b);
                    break;
                case "-":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a - b);
                    break;
                case "*":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a * b);
                    break;
                default:
                    stack.push(Long.parseLong((String) postfix[i]));
            }
        }
        return stack.get(0);
    }

    public String[] split(String input) {
        LinkedList<String> list = new LinkedList<>();
        int startIndex = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '/' || input.charAt(i) == '*') {
                list.add(input.substring(startIndex, i));
                list.add(input.charAt(i) + "");
                startIndex = i + 1;
            }
        }
        list.add(input.substring(startIndex));
        Object[] result = list.toArray();
        String[] strResult = new String[result.length];
        for (int i = 0; i < result.length; i++) {
            strResult[i] = (String) result[i];
        }
        return strResult;
    }
}