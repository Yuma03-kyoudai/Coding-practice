import java.util.Scanner;

public class iwatodaibunryou {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] nama = new String[5];
        int[] kode = new int[5];
        String[] kelas = new String[5];
        int[] harga = new int[5];
        int[] tglMasuk = new int[5];
        int[] tglKeluar = new int[5];
        int[] lama = new int[5];
        double[] discount = new double[5];
        double[] total = new double[5];

        System.out.println("=== DATA HOTEL ===");

        for (int i = 0; i < 5; i++) {
            System.out.println("\nData " + (i + 1));
            System.out.print("Nama : ");
            nama[i] = input.nextLine();

            System.out.print("Kode Kamar (1-12): ");
            kode[i] = input.nextInt();

            // switch menentukan kelas dan harga
            switch (kode[i]) {
                case 1:
                    kelas[i] = "Standard Single Room";
                    harga[i] = 750;
                    break;

                case 2:
                    kelas[i] = "Superior Single Room";
                    harga[i] = 900;
                    break;

                case 3:
                    kelas[i] = "Deluxe Single Room";
                    harga[i] = 1100;
                    break;

                case 4:
                    kelas[i] = "Junior Suite Single Room";
                    harga[i] = 1300;
                    break;

                case 5:
                    kelas[i] = "Suite Single Room";
                    harga[i] = 1700;
                    break;

                case 6:
                    kelas[i] = "Presidential Suite Single Room";
                    harga[i] = 2100;
                    break;

                case 7:
                    kelas[i] = "Standard Twin Room";
                    harga[i] = 800;
                    break;

                case 8:
                    kelas[i] = "Superior Twin Room";
                    harga[i] = 950;
                    break;

                case 9:
                    kelas[i] = "Deluxe Twin Room";
                    harga[i] = 1150;
                    break;

                case 10:
                    kelas[i] = "Junior Suite Twin Room";
                    harga[i] = 1350;
                    break;

                case 11:
                    kelas[i] = "Suite Twin Room";
                    harga[i] = 1750;
                    break;

                case 12:
                    kelas[i] = "Presidential Suite Twin Room";
                    harga[i] = 2150;
                    break;

                default:
                    kelas[i] = "Tidak Diketahui";
                    harga[i] = 0;
                    break;
            }

            System.out.print("Tanggal Masuk (1-31): ");
            tglMasuk[i] = input.nextInt();

            System.out.print("Tanggal Keluar (1-31): ");
            tglKeluar[i] = input.nextInt();

            lama[i] = tglKeluar[i] - tglMasuk[i];
            if (lama[i] < 0)
                lama[i] = 0;

            // hitung discount
            if (lama[i] >= 2 && lama[i] <= 3)
                discount[i] = 0.05 * harga[i] * lama[i];
            else if (lama[i] >= 4 && lama[i] <= 10)
                discount[i] = 0.07 * harga[i] * lama[i];
            else if (lama[i] > 10)
                discount[i] = 0.10 * harga[i] * lama[i];
            else
                discount[i] = 0;

            total[i] = (harga[i] * lama[i]) - discount[i];

            input.nextLine(); // clear buffer
        }

        // TAMPILKAN HASIL
        System.out.println("\n=== DATA HOTEL ===");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.printf("%-3s %-15s %-30s %-8s %-10s %-10s %-10s%n",
                "No", "Nama", "Kelas Kamar", "Harga", "Lama", "Discount", "Total");
        System.out.println("-----------------------------------------------------------------------------------------");

        double totalSemua = 0, totalDiscount = 0;
        double max = total[0], min = total[0];

        for (int i = 0; i < 5; i++) {
            System.out.printf("%-3d %-15s %-30s %-8d %-10d %-10.2f %-10.2f%n",
                    (i + 1), nama[i], kelas[i], harga[i], lama[i], discount[i], total[i]);

            totalSemua += total[i];
            totalDiscount += discount[i];

            if (total[i] > max)
                max = total[i];
            if (total[i] < min)
                min = total[i];
        }

        System.out.println("---------------------------------------------------------------------------------------");
        System.out.printf("Total Seluruh: %.2f%n", totalSemua);
        System.out.printf("Rata-rata: %.2f%n", totalSemua / 5);
        System.out.printf("Total Discount: %.2f%n", totalDiscount);
        System.out.printf("Nilai Tertinggi: %.2f%n", max);
        System.out.printf("Nilai Terendah: %.2f%n", min);

        input.close();
    }
}