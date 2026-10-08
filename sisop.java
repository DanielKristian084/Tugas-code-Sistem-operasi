import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class ThreadFaktorial extends Thread {
    public void run() {
        int n = 5;
        int hasil = 1;

        for (int i = 1; i <= n; i++) {
            hasil *= i;
        }

        System.out.println("Thread Faktorial : " + n + "! = " + hasil);
    }
}

class ThreadFibonacci extends Thread {
    public void run() {
        int n = 10;
        int a = 0;
        int b = 1;

        System.out.print("Thread Fibonacci : ");

        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");

            int c = a + b;
            a = b;
            b = c;
        }

        System.out.println();
    }
}

class ThreadDataText extends Thread {
    public void run() {
        System.out.println("Thread Data Text :");

        try {
            BufferedReader reader =
                new BufferedReader(new FileReader("data.txt"));

            String data;

            while ((data = reader.readLine()) != null) {
                System.out.println(data);
            }

            reader.close();

        } catch (IOException e) {
            System.out.println("File data.txt tidak ditemukan!");
        }
    }
}

public class sisop {
    public static void main(String[] args) {

        ThreadFaktorial thread1 = new ThreadFaktorial();
        ThreadFibonacci thread2 = new ThreadFibonacci();
        ThreadDataText thread3 = new ThreadDataText();

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            System.out.println("Thread terganggu.");
        }

        System.out.println("Semua thread selesai.");
    }
}