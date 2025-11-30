public class substring {

    public static void main(String[] args) {

        String kereta[][] = {
                { "Bandung", "Yogyakarta", "Surabaya" },
                { "350", "600", "750" },
                { "200", "450", "580" },
                { "150", "300", "450" },
                { "Eksekutif", "Bisnis", "Ekonomi" },
        };

        String kode = "3B";
        String kodeJ = kode.substring(0, 1);
        int x = Integer.parseInt(kodeJ) - 1;
        char a = kode.charAt(1);
        int y = a - 65;

        System.out.println("Jurusan : " + kereta[0][x]);
        System.out.println("Kelas : " + kereta[4][y]);
        System.out.println("Biaya : " + kereta[x][y]);
    }
}