package Array2D;

public class Array {

    public static void main(String[] args) {
        String[] header = {"NIM", "Nama", "Jurusan"};
        String[][] data = {{"001", "Wildan", "Teknik Informatika"}, {"002", "Joni", "Sistem Informasi"}, {"003", "Jono", "Teknik Informatika"}};
        
        for (int i = 0; i < header.length; i++) {
            System.out.printf("%-10s ", header[i]);
        }
        System.out.println("");
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.printf("%-10s", data[i][j]);
            }
            System.out.println("");
        }
    }
}