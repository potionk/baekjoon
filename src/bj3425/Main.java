package bj3425;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Main {
    static final int MAX_VALUE = 1000000000, MIN_VALUE = -1000000000, ERROR = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        List<Operation> program = new LinkedList<>();
        boolean programRead = true;
        while (!(input = br.readLine()).equals("QUIT")) {
            if (!input.equals("")) {
                if (programRead) {
                    if (!input.equals("END")) {
                        String[] op = input.split(" ");
                        Operation operation;
                        if (op.length == 1) {
                            operation = new Operation(OperationType.valueOf(op[0]));
                        } else {
                            operation = new Operation(OperationType.valueOf(op[0]), Integer.parseInt(op[1]));
                        }
                        program.add(operation);
                    } else {
                        programRead = false;
                    }
                } else {
                    int n = Integer.parseInt(input);
                    while (n-- > 0) {
                        int result = executeProgram(program, Integer.parseInt(br.readLine()));
                        if (result == ERROR) {
                            bw.write("ERROR\n");
                        } else {
                            bw.write(result + "\n");
                        }
                    }
                    bw.write("\n");
                    programRead = true;
                    program = new LinkedList<>();
                }
            }
        }
        br.close();
        bw.close();
    }

    private static int executeProgram(List<Operation> program, int v) {
        Stack<Integer> goStack = new Stack<>();
        goStack.add(v);
        for (Operation operation : program) {
            switch (operation.operationType) {
                case ADD -> {
                    if (goStack.size() >= 2) {
                        int result = goStack.pop() + goStack.pop();
                        if (!isValidatedValue(result)) {
                            return ERROR;
                        }
                        goStack.push(result);

                    } else {
                        return ERROR;
                    }
                }
                case DIV -> {
                    if (goStack.size() >= 2 && goStack.peek() != 0) {
                        int divisor = goStack.pop();
                        int dividend = goStack.pop();
                        goStack.push(dividend / divisor);
                    } else {
                        return ERROR;
                    }
                }
                case MOD -> {
                    if (goStack.size() >= 2 && goStack.peek() != 0) {
                        int divisor = goStack.pop();
                        int dividend = goStack.pop();
                        goStack.push(dividend % divisor);
                    } else {
                        return ERROR;
                    }
                }
                case DUP -> {
                    if (goStack.size() >= 1) {
                        goStack.push(goStack.peek());
                    } else {
                        return ERROR;
                    }
                }
                case INV -> {
                    if (goStack.size() >= 1) {
                        goStack.push(goStack.pop() * -1);
                    } else {
                        return ERROR;
                    }
                }
                case MUL -> {
                    if (goStack.size() >= 2) {
                        long result = (long) goStack.pop() * (long) goStack.pop();
                        if (!isValidatedValue(result)) {
                            return ERROR;
                        }
                        goStack.push((int) result);
                    } else {
                        return ERROR;
                    }
                }
                case NUM -> goStack.push(operation.value);
                case POP -> {
                    if (goStack.size() >= 1) {
                        goStack.pop();
                    } else {
                        return ERROR;
                    }
                }
                case SUB -> {
                    if (goStack.size() >= 2) {
                        int a = goStack.pop();
                        int result = goStack.pop() - a;
                        if (!isValidatedValue(result)) {
                            return ERROR;
                        }
                        goStack.push(result);
                    } else {
                        return ERROR;
                    }
                }
                case SWP -> {
                    if (goStack.size() >= 2) {
                        int a = goStack.pop();
                        int b = goStack.pop();
                        goStack.push(a);
                        goStack.push(b);
                    } else {
                        return ERROR;
                    }
                }
            }
        }
        if (goStack.size() != 1) {
            return ERROR;
        } else {
            return goStack.peek();
        }
    }

    private static boolean isValidatedValue(int i) {
        return i >= MIN_VALUE && MAX_VALUE >= i;
    }

    private static boolean isValidatedValue(long l) {
        return l >= MIN_VALUE && MAX_VALUE >= l;
    }

    private static class Operation {
        OperationType operationType;
        int value;

        public Operation(OperationType operationType) {
            this.operationType = operationType;
        }

        public Operation(OperationType operationType, int value) {
            this.operationType = operationType;
            this.value = value;
        }
    }

    private enum OperationType {
        NUM, POP, INV, DUP, SWP, ADD, SUB, MUL, DIV, MOD
    }
}
