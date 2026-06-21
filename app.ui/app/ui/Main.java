package app.ui;

import app.service.MinumanService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu.tampilkanSplashScreen(); // Menampilkan layar pembuka

        MinumanService service = new MinumanService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            Menu.tampilkanMenuUtama();
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan buffer

            switch (pilihan) {
                case 1: // Tampilkan Daftar Minuman
                    service.tampilkanSemuaMinuman();
                    break;
                case 2: // Tambah Minuman
                    System.out.print("Nama Minuman: ");
                    String nama = scanner.nextLine();
                    System.out.print("Jenis (Kaleng/Botol/Karton): ");
                    String jenis = scanner.nextLine();
                    System.out.print("Harga: ");
                    int harga = scanner.nextInt();
                    System.out.print("Stok: ");
                    int stok = scanner.nextInt();
                    service.tambahMinuman(nama, jenis, harga, stok);
                    pressEnterToContinue();
                    break;
                case 3: // Cari Minuman
                    System.out.print("Masukkan nama minuman yang dicari: ");
                    String keyword = scanner.nextLine();
                    service.cariMinuman(keyword);
                    pressEnterToContinue();
                    break;
                case 4: // Edit Minuman
                    service.tampilkanSemuaMinuman(); // Tampilkan daftar sebelum edit
                    System.out.print("Masukkan ID minuman yang akan diedit: ");
                    int idEdit = scanner.nextInt();
                    System.out.print("Harga baru: ");
                    int hargaBaru = scanner.nextInt();
                    System.out.print("Stok baru: ");
                    int stokBaru = scanner.nextInt();
                    service.editMinuman(idEdit, hargaBaru, stokBaru);
                    pressEnterToContinue();
                    break;
                case 5: // Hapus Minuman
                    service.tampilkanSemuaMinuman(); // Tampilkan daftar sebelum hapus
                    System.out.print("Masukkan ID minuman yang akan dihapus: ");
                    int idHapus = scanner.nextInt();
                    service.hapusMinuman(idHapus);
                    pressEnterToContinue();
                    break;
                case 6: // Beli Minuman
                    System.out.print("Masukkan NAMA minuman yang akan dibeli: ");
                    String namaBeli = scanner.nextLine();
                    System.out.print("Jumlah: ");
                    int jumlah = scanner.nextInt();
                    System.out.print("Masukkan jumlah uang pembayaran: ");
                    int uangBayar = scanner.nextInt();
                    scanner.nextLine(); // Membersihkan newline
                    service.beliMinuman(namaBeli, jumlah, uangBayar);
                    pressEnterToContinue();
                    break;
                case 7: // Keluar
                    System.out.println("Terima kasih telah menggunakan SmartDrink!");
                    scanner.close();
                    return; // Keluar dari program
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    pressEnterToContinue();
            }
        }
    }

    private static void pressEnterToContinue() {
        System.out.print("\nTekan Enter untuk melanjutkan...");
        new java.util.Scanner(System.in).nextLine();
    }
}