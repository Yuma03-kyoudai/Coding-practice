import java.util.Scanner;

public class while文 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] nama = new String[5];
        int[] nilai = new int[5];
        String[] keterangan = new String[5];

        int i = 0;

        while (i < 5) {
            System.out.println("--------------");
            System.out.print("Nama  : ");
            nama[i] = input.nextLine();

            System.out.print("Nilai : ");
            nilai[i] = input.nextInt();
            input.nextLine();

            if (nilai[i] >= 70) {
                keterangan[i] = "Lulus";
            } else {
                keterangan[i] = "Gagal";
            }

            i++;
        }

        System.out.println("--------------------------------");
        System.out.println("No  Nama   \tNilai  \tKeterangan");
        System.out.println("--------------------------------");

        i = 0;
        while (i < 5) {
            System.out.println((i + 1) + ".  " + nama[i] + "\t" + nilai[i] + "\t" + keterangan[i]);
            i++;
        }

        System.out.println("--------------------------------");
        input.close();
    }
}