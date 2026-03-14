import java.util.*;
import java.io.*;

public class Mainn {

    // Matematik funksiyalar
    public static long factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }

    public static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // String funksiyalar
    public static boolean isPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        return s.equalsIgnoreCase(rev);
    }

    public static String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static int countVowels(String s) {
        int count = 0;
        for (char c : s.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(c) != -1) count++;
        }
        return count;
    }

    // Array funksiyalar
    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int n : arr) if (n > max) max = n;
        return max;
    }

    public static int findMin(int[] arr) {
        int min = arr[0];
        for (int n : arr) if (n < min) min = n;
        return min;
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    // OOP misol
    static abstract class Animal {
        abstract void sound();
    }

    static class Dog extends Animal {
        void sound() { System.out.println("Woof!"); }
    }

    static class Cat extends Animal {
        void sound() { System.out.println("Meow!"); }
    }

    interface Shape {
        double area();
    }

    static class Circle implements Shape {
        double r;
        Circle(double r) { this.r = r; }
        public double area() { return Math.PI * r * r; }
    }

    static class Rectangle implements Shape {
        double w, h;
        Rectangle(double w, double h) { this.w = w; this.h = h; }
        public double area() { return w * h; }
    }

    // Oddiy o‘yin
    public static void guessNumberGame() {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int number = rand.nextInt(100) + 1;
        int guess = 0;
        System.out.println("1 dan 100 gacha son toping!");
        while (guess != number) {
            guess = sc.nextInt();
            if (guess < number) System.out.println("Kattaroq son!");
            else if (guess > number) System.out.println("Kichikroq son!");
            else System.out.println("To‘g‘ri topdingiz!");
        }
    }

    // File I/O
    public static void writeFile(String filename, String content) {
        try (FileWriter fw = new FileWriter(filename)) {
            fw.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFile(String filename) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("Factorial(5) = " + factorial(5));
        System.out.println("Fibonacci(10) = " + fibonacci(10));
        System.out.println("Is 17 prime? " + isPrime(17));

        System.out.println("Palindrome check: " + isPalindrome("level"));
        System.out.println("Reverse string: " + reverseString("Java"));
        System.out.println("Vowels in 'Programming': " + countVowels("Programming"));

        int[] arr = {5, 2, 9, 1, 7};
        bubbleSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
        System.out.println("Max: " + findMax(arr));
        System.out.println("Min: " + findMin(arr));

        Animal dog = new Dog();
        Animal cat = new Cat();
        dog.sound();
        cat.sound();

        Shape circle = new Circle(5);
        Shape rect = new Rectangle(4, 6);
        System.out.println("Circle area: " + circle.area());
        System.out.println("Rectangle area: " + rect.area());

        writeFile("test.txt", "Salom, bu faylga yozilgan matn!");
        System.out.println("File content:\n" + readFile("test.txt"));

        // guessNumberGame(); // Uncomment to play
    }
}
