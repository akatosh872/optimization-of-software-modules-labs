class Factorial {
    public static int recursionExecute(int n) {
        assert(n >= 0);
        n = (n <= 1) ? 1 :  n * recursionExecute(n - 1);
        return n;
    }

    public static int cycleExecute(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 5;
        int resultRecursion = recursionExecute(n);
        int resultCycle = cycleExecute(n);
        assert resultRecursion == resultCycle : "different values";
        System.out.println("N: " + n);
        System.out.println("Factorial (Recursion): " + resultRecursion);
    }
}

class Recursion {
    public static int recursionExecute(int n) {
        n = n <= 1 ? n : recursionExecute(n - 1) + recursionExecute(n - 2);
        return n;
    }

    public static int cycleExecute(int n) {
        if (n <= 1) {
            return n;
        }
        int a = 0, b = 1, result = 0;
        for (int i = 2; i <= n; i++) {
            result = a + b;
            a = b;
            b = result;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 8;
        int resultRecursion = recursionExecute(n);
        int resultCycle = cycleExecute(n);
        assert resultRecursion == resultCycle : "different values";
        System.out.println("N: " + n);
        System.out.println("Fibonacci (Cycle): " + resultCycle);
    }
}

class DigitSum {
    public static int execute(int n) {
        n = n == 0 ? 0 : n % 10 + execute(n/10);
        return n;
    }

    public static void main(String[] args) {
        int n = 223;
        int result = execute(n);
        System.out.println("Input Number: " + n);
        System.out.println("Sum of Digits: " + result);
    }
}

class Sum {
    public static int execute(int a, int b) {
        if (b == 0) {
            return a;
        }
        int sum = a ^ b; // Додавання без переносу через операцію XOR
        int carry = (a & b) << 1; // Перенос вліво на 1 біт
        return execute(sum, carry); // Операція повторюється доки b!=0
    }

    public static void main(String[] args) {
        int a = 7, b = 6;
        int result = execute(a, b);
        System.out.println("Input Numbers: a = " + a + ", b = " + b);
        System.out.println("Sum: " + result);
    }
}