import java.util.Scanner;

public class Lab1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1) Инициализация массива, сумма и среднее (for)");
        task3_forSumAndAverage();

        System.out.println("\n2) Ввод массива, суммы (do-while, while), min/max");
        task4_inputSumMinMax(sc);

        System.out.println("\n3) Вывод аргументов командной строки (for)");
        printArgs(args);

        System.out.println("\n4) Первые 10 чисел гармонического ряда:");
        printHarmonicFirst10();

        System.out.println("\n5) Вычисление факториала (пример метода)");
        System.out.print("Введите неотрицательное целое для факториала: ");
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            if (n < 0) {
                System.out.println("Нужно неотрицательное число.");
            } else {
                System.out.println(n + "! = " + factorial(n));
            }
        } else {
            System.out.println("Не целое число.");
        }

        sc.close();
    }

    // Задание 3: массив инициализированный напрямую, сумма и среднее — использовать цикл for
    public static void task3_forSumAndAverage() {
        int[] arr = {1, 2, 3, 4, 5, 10};
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        double avg = (arr.length > 0) ? (double) sum / arr.length : 0;
        System.out.println("Массив: ");
        for (int v : arr) System.out.print(v + " ");
        System.out.println("\nСумма = " + sum + ", среднее = " + avg);
    }

    // Задание 4: ввод массива с клавиатуры, сумма с do-while и while, найти min и max
    public static void task4_inputSumMinMax(Scanner sc) {
        System.out.print("Введите размер массива (положительное целое): ");
        int n = 0;
        if (sc.hasNextInt()) {
            n = sc.nextInt();
        } else {
            System.out.println("Неверный ввод размера.");
            sc.nextLine();
            return;
        }
        if (n <= 0) {
            System.out.println("Размер должен быть положительным.");
            return;
        }

        int[] a = new int[n];
        System.out.println("Введите " + n + " целых чисел:");
        for (int i = 0; i < n; i++) {
            while (!sc.hasNextInt()) {
                System.out.println("Ожидается целое число, попробуйте снова:");
                sc.next();
            }
            a[i] = sc.nextInt();
        }


        int idx = 0;
        int sumWhile = 0;
        while (idx < n) {
            sumWhile += a[idx];
            idx++;
        }


        int sumDoWhile = 0;
        idx = 0;
        if (n > 0) {
            do {
                sumDoWhile += a[idx];
                idx++;
            } while (idx < n);
        }


        int min = a[0], max = a[0];
        for (int i = 1; i < n; i++) {
            if (a[i] < min) min = a[i];
            if (a[i] > max) max = a[i];
        }

        System.out.println("Сумма (while) = " + sumWhile);
        System.out.println("Сумма (do-while) = " + sumDoWhile);
        System.out.println("Минимум = " + min + ", Максимум = " + max);
    }

    // Задание 5: вывод аргументов командной строки в цикле for
    public static void printArgs(String[] args) {
        if (args.length == 0) {
            System.out.println("Аргументы командной строки отсутствуют.");
            return;
        }
        for (int i = 0; i < args.length; i++) {
            System.out.println("args[" + i + "] = " + args[i]);
        }
    }

    // Задание 6: первые 10 чисел гармонического ряда (1, 1/2, 1/3, ...)
    public static void printHarmonicFirst10() {
        for (int i = 1; i <= 10; i++) {
            System.out.printf("1/%d = %.6f%n", i, 1.0 / i);
        }
    }

    // Задание 7: метод вычисления факториала (используем цикл)
    public static long factorial(int n) {
        long res = 1;
        for (int i = 2; i <= n; i++) {
            res *= i;
        }
        return res;
    }
}