import java.util.Scanner;

public class for文 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Menyimpan data 5 orang
        String[] nama = new String[5];
        int[] nilai = new int[5];
        String[] keterangan = new String[5];

        System.out.println("=== Input Data ===");
        for (int i = 0; i < 5; i++) {
            System.out.println("\nData-" + (i + 1));
            System.out.print("Nama       : ");
            nama[i] = input.nextLine();

            System.out.print("Nilai      : ");
            nilai[i] = input.nextInt();
            input.nextLine(); // membersihkan buffer

            // Menentukan keterangan (grade)
            if (nilai[i] > 80) {
                keterangan[i] = "Baik Sekali";
            } else if (nilai[i] >= 70) {
                keterangan[i] = "Baik";
            } else if (nilai[i] >= 60) {
                keterangan[i] = "Cukup";
            } else {
                keterangan[i] = "Kurang";
            }
        }

        // Menampilkan hasil
        System.out.println("\n------------------------------------------");
        System.out.println("No\tNama\t\tNilai\tKeterangan");
        System.out.println("--------------------------------------------");

        for (int i = 0; i < 5; i++) {
            System.out.printf("%d.\t%-10s\t%d\t%s\n", (i + 1), nama[i], nilai[i], keterangan[i]);
        }

        System.out.println("--------------------------------------------");
    }
}