import java.util.Scanner;

public class AlgolExercise {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Jumlah data karyawan
        System.out.print("Jumlah Karyawan: ");
        int n = input.nextInt();
        input.nextLine(); // buang newline

        // Deklarasi array
        String[] nama = new String[n];
        int[] gol = new int[n];
        String[] jabatan = new String[n];
        int[] gajiPokok = new int[n];
        int[] status = new int[n];
        String[] keteranganStatus = new String[n];
        double[] tunjangan = new double[n];
        double[] totalGaji = new double[n];

        // Input data
        for (int i = 0; i < n; i++) {
            System.out.println("\nData -" + (i + 1));
            System.out.print("Nama                               : ");
            nama[i] = input.nextLine();
            System.out.print("Golongan [1-3]                     : ");
            gol[i] = input.nextInt();
            System.out.print("Status [1=Belum Menikah, 2=Menikah]: ");
            status[i] = input.nextInt();
            input.nextLine();

            // Tentukan jabatan dan gaji pokok
            if (gol[i] == 1) {
                jabatan[i] = "Staff";
                gajiPokok[i] = 5000;
            } else if (gol[i] == 2) {
                jabatan[i] = "Supervisor";
                gajiPokok[i] = 7500;
            } else if (gol[i] == 3) {
                jabatan[i] = "Manager";
                gajiPokok[i] = 15000;
            } else {
                jabatan[i] = "-";
                gajiPokok[i] = 0;
            }

            // Tentukan status dan tunjangan
            if (status[i] == 2) {
                keteranganStatus[i] = " Menikah ";
                tunjangan[i] = 0.15 * gajiPokok[i];
            } else {
                keteranganStatus[i] = " Belum Menikah ";
                tunjangan[i] = 0;
            }

            // Hitung total gaji
            totalGaji[i] = gajiPokok[i] + tunjangan[i];
        }

        // Header tabel
        System.out.println(
                "\n=================================================================================================================");
        System.out.printf("%-4s %-10s %-5s %-12s %-12s %-10s %-12s %-12s\n",
                "No", "Nama", "Gol", "Jabatan", "GajiPokok", "Status", "Tunjangan", "TotalGaji");
        System.out.println(
                "-------------------------------------------------------------------------------------------------------------------");

        // Isi tabel
        double totalGajiPokok = 0, totalTunjangan = 0, totalSemua = 0;
        for (int i = 0; i < n; i++) {
            System.out.printf("%-4d %-10s %-5d %-12s %-12d %-10s %-12.0f %-12.0f\n",
                    (i + 1), nama[i], gol[i], jabatan[i], gajiPokok[i],
                    keteranganStatus[i], tunjangan[i], totalGaji[i]);

            totalGajiPokok += gajiPokok[i];
            totalTunjangan += tunjangan[i];
            totalSemua += totalGaji[i];
        }

        // Garis pemisah
        System.out.println(
                "-----------------------------------------------------------------------------------------------------------------");

        // Total akhir
        System.out.printf("%-33s %-12.0f %-10s %-12.0f %-12.0f\n",
                "Total", totalGajiPokok, "", totalTunjangan, totalSemua);

        System.out.println(
                "=================================================================================================================");
    }
}