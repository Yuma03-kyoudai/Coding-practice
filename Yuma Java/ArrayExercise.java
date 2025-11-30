import java.util.Scanner;

public class ArrayExercise {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Data produk
        String[] productID = { "P01", "P02", "P03" };
        String[] productName = { "Monitor", "Keyboard", "Mouse" };
        double[] price = { 8500, 3500, 2870 };

        int jumlahData = 5;

        // Array hasil input
        String[] nama = new String[jumlahData];
        String[] id = new String[jumlahData];
        String[] namaProduk = new String[jumlahData];
        double[] harga = new double[jumlahData];
        int[] qty = new int[jumlahData];
        double[] diskon = new double[jumlahData];
        double[] pajak = new double[jumlahData];
        double[] total = new double[jumlahData];

        System.out.println("=== DATA PENJUALAN ===");

        for (int i = 0; i < jumlahData; i++) {
            System.out.println("\nData -" + (i + 1));

            System.out.print("Nama Pembeli: ");
            nama[i] = input.nextLine();

            System.out.println("Pilih Product ID:");
            System.out.println("P01 - Monitor (Rp8500)");
            System.out.println("P02 - Keyboard (Rp3500)");
            System.out.println("P03 - Mouse (Rp2870)");
            System.out.print("Masukkan Product ID: ");
            id[i] = input.nextLine().toUpperCase();

            // Gunakan SWITCH untuk menentukan produk
            switch (id[i]) {
                case "P01":
                    namaProduk[i] = productName[0];
                    harga[i] = price[0];
                    break;
                case "P02":
                    namaProduk[i] = productName[1];
                    harga[i] = price[1];
                    break;
                case "P03":
                    namaProduk[i] = productName[2];
                    harga[i] = price[2];
                    break;
                default:
                    System.out.println("❌ Product ID tidak ditemukan! Ulangi input.");
                    i--;
                    continue;
            }

            System.out.print(" Qty: ");
            qty[i] = input.nextInt();
            input.nextLine(); // clear buffer

            // Hitung diskon pakai if
            if (qty[i] >= 10 && qty[i] <= 20) {
                diskon[i] = 0.05 * harga[i] * qty[i];
            } else if (qty[i] >= 21 && qty[i] <= 50) {
                diskon[i] = 0.07 * harga[i] * qty[i];
            } else if (qty[i] > 50) {
                diskon[i] = 0.10 * harga[i] * qty[i];
            } else {
                diskon[i] = 0;
            }

            // Pajak 11%
            pajak[i] = 0.11 * ((harga[i] * qty[i]) - diskon[i]);

            // Total
            total[i] = (harga[i] * qty[i]) - diskon[i] + pajak[i];
        }

        // Output tabel
        System.out.println("\n\n=== LAPORAN PENJUALAN ===");
        System.out.printf("%-3s %-10s %-8s %-12s %-8s %-8s %-8s %-10s\n",
                "No", "Nama", "ProdID", "ProdName", "Price", "Qty", "Tax", "Total");
        System.out.println("---------------------------------------------------------------------------");

        double totalSemua = 0;
        double min = total[0], max = total[0];

        for (int i = 0; i < jumlahData; i++) {
            System.out.printf("%-3d %-10s %-8s %-12s %-8.0f %-8d %-8.0f %-10.0f\n",
                    (i + 1), nama[i], id[i], namaProduk[i], harga[i], qty[i], pajak[i], total[i]);

            totalSemua += total[i];
            if (total[i] < min)
                min = total[i];
            if (total[i] > max)
                max = total[i];
        }

        double rata = totalSemua / jumlahData;

        System.out.println("---------------------------------------------------------------------------");
        System.out.printf("%-45s : %.0f\n", "Total", totalSemua);
        System.out.printf("%-45s : %.0f\n", "Rata-Rata", rata);
        System.out.printf("%-45s : %.0f\n", "Min", min);
        System.out.printf("%-45s : %.0f\n", "Max", max);
    }
}