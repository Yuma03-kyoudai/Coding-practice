import java.util.Scanner;

public class ArrayMultiDimensi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Array harga
        int[] bandung = { 350, 200, 150 };
        int[] jogja = { 600, 450, 300 };
        int[] surabaya = { 750, 580, 450 };

        // Array untuk menyimpan data
        String[] nama = new String[5];
        String[] kodeTiket = new String[5];
        String[] jurusan = new String[5];
        String[] kelas = new String[5];
        int[] harga = new int[5];
        int[] jumlah = new int[5];
        int[] total = new int[5];

        int grandTotal = 0;

        // Input data
        for (int i = 0; i < 5; i++) {
            System.out.println("\nData " + (i + 1));

            System.out.print("Nama Penumpang : ");
            nama[i] = input.nextLine();

            System.out.print("Kode Tiket (1A - 3C) : ");
            kodeTiket[i] = input.nextLine().toUpperCase();

            System.out.print("Jumlah Tiket : ");
            jumlah[i] = input.nextInt();
            input.nextLine();

            // Ambil kode
            String kodeJurusan = kodeTiket[i].substring(0, 1);
            String kodeKelas = kodeTiket[i].substring(1, 2);

            // Tentukan jurusan dan harga
            switch (kodeJurusan) {
                case "1":
                    jurusan[i] = "Bandung";
                    harga[i] = getHarga(kodeKelas, bandung);
                    break;
                case "2":
                    jurusan[i] = "Yogyakarta";
                    harga[i] = getHarga(kodeKelas, jogja);
                    break;
                case "3":
                    jurusan[i] = "Surabaya";
                    harga[i] = getHarga(kodeKelas, surabaya);
                    break;
                default:
                    jurusan[i] = "Tidak Valid";
            }

            // Tentukan kelas
            switch (kodeKelas) {
                case "A":
                    kelas[i] = "Executive";
                    break;
                case "B":
                    kelas[i] = "Bisnis";
                    break;
                case "C":
                    kelas[i] = "Ekonomi";
                    break;
                default:
                    kelas[i] = "Tidak Valid";
            }

            total[i] = harga[i] * jumlah[i];
            grandTotal += total[i];
        }

        // Tampilkan hasil dalam bentuk tabel
        System.out.println("\n====================================================================");
        System.out.println("No  Penumpang KodeTiket Jurusan      Kelas    Biaya   Jumlah  Total");
        System.out.println("======================================================================");

        for (int i = 0; i < 5; i++) {
            System.out.printf("%-3d %-12s %-6s %-12s %-10s %-6d %-4d %-6d\n",
                    (i + 1),
                    nama[i],
                    kodeTiket[i],
                    jurusan[i],
                    kelas[i],
                    harga[i],
                    jumlah[i],
                    total[i]);
        }

        System.out.println("=======================================================================");
        System.out.printf("Total                                                       %d\n", grandTotal);
        System.out.println("=======================================================================");
    }

    // Fungsi harga (array 1 dimensi)
    static int getHarga(String kodeKelas, int[] hargaArray) {
        switch (kodeKelas) {
            case "A":
                return hargaArray[0];
            case "B":
                return hargaArray[1];
            case "C":
                return hargaArray[2];
            default:
                return 0;
        }
    }
}