package app.service;

import app.data.Minuman;
import app.data.MinumanRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MinumanService {
    private MinumanRepository repository = new MinumanRepository();

    // ANSI Color Codes
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    // Fitur untuk menampilkan data
    public void tampilkanSemuaMinuman() {
        List<Minuman> daftarMinuman = repository.getAllMinuman();

        System.out.println(ANSI_YELLOW + "\n--- Daftar Minuman Tersedia ---" + ANSI_RESET);
        if (daftarMinuman.isEmpty()) {
            System.out.println(ANSI_WHITE + "Belum ada data minuman." + ANSI_RESET);
        } else {
            System.out
                    .println(ANSI_CYAN + "┌────┬─────────────────────┬───────────┬─────────────┬──────┐" + ANSI_RESET);
            System.out.printf(
                    ANSI_CYAN + "│" + ANSI_YELLOW + " %-3s" + ANSI_CYAN + "│" + ANSI_YELLOW + " %-20s" + ANSI_CYAN + "│"
                            + ANSI_YELLOW + " %-10s" + ANSI_CYAN + "│" + ANSI_YELLOW + " %-12s" + ANSI_CYAN + "│"
                            + ANSI_YELLOW + " %-5s" + ANSI_CYAN + "│%n" + ANSI_RESET,
                    "ID", "Nama Minuman", "Jenis", "Harga", "Stok");
            System.out
                    .println(ANSI_CYAN + "├────┼─────────────────────┼───────────┼─────────────┼──────┤" + ANSI_RESET);
            for (Minuman m : daftarMinuman) {
                System.out.printf(
                        ANSI_CYAN + "│ " + ANSI_WHITE + "%-3d" + ANSI_CYAN + "│ " + ANSI_WHITE + "%-20s" + ANSI_CYAN
                                + "│ " + ANSI_WHITE + "%-10s" + ANSI_CYAN + "│ " + ANSI_WHITE + "Rp %-9d" + ANSI_CYAN
                                + "│ " + ANSI_WHITE + "%-5d" + ANSI_CYAN + "│%n" + ANSI_RESET,
                        m.getId(), m.getNama(), m.getJenis(), m.getHarga(), m.getStok());
            }
            System.out
                    .println(ANSI_CYAN + "└────┴─────────────────────┴───────────┴─────────────┴──────┘" + ANSI_RESET);
        }
        System.out.print(ANSI_WHITE + "\nTekan Enter untuk kembali ke menu..." + ANSI_RESET);
        new java.util.Scanner(System.in).nextLine();
    }

    // Fitur untuk menambah data
    public void tambahMinuman(String nama, String jenis, int harga, int stok) {
        Minuman minumanBaru = new Minuman(nama, jenis, harga, stok);
        repository.tambahMinuman(minumanBaru);
        System.out.println(ANSI_GREEN + "Sukses: Minuman '" + nama + "' berhasil ditambahkan." + ANSI_RESET);
    }

    // Fitur untuk mencari data
    public void cariMinuman(String keyword) {
        List<Minuman> hasil = repository.getAllMinuman().stream()
                .filter(m -> m.getNama().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());

        System.out.println(ANSI_YELLOW + "\n--- Hasil Pencarian untuk '" + keyword + "' ---" + ANSI_RESET);
        if (hasil.isEmpty()) {
            System.out.println(ANSI_WHITE + "Minuman tidak ditemukan." + ANSI_RESET);
        } else {
            System.out
                    .println(ANSI_CYAN + "┌────┬─────────────────────┬───────────┬─────────────┬──────┐" + ANSI_RESET);
            System.out.printf(
                    ANSI_CYAN + "│" + ANSI_YELLOW + " %-3s" + ANSI_CYAN + "│" + ANSI_YELLOW + " %-20s" + ANSI_CYAN + "│"
                            + ANSI_YELLOW + " %-10s" + ANSI_CYAN + "│" + ANSI_YELLOW + " %-12s" + ANSI_CYAN + "│"
                            + ANSI_YELLOW + " %-5s" + ANSI_CYAN + "│%n" + ANSI_RESET,
                    "ID", "Nama Minuman", "Jenis", "Harga", "Stok");
            System.out
                    .println(ANSI_CYAN + "├────┼─────────────────────┼───────────┼─────────────┼──────┤" + ANSI_RESET);
            for (Minuman m : hasil) {
                System.out.printf(
                        ANSI_CYAN + "│ " + ANSI_WHITE + "%-3d" + ANSI_CYAN + "│ " + ANSI_WHITE + "%-20s" + ANSI_CYAN
                                + "│ " + ANSI_WHITE + "%-10s" + ANSI_CYAN + "│ " + ANSI_WHITE + "Rp %-9d" + ANSI_CYAN
                                + "│ " + ANSI_WHITE + "%-5d" + ANSI_CYAN + "│%n" + ANSI_RESET,
                        m.getId(), m.getNama(), m.getJenis(), m.getHarga(), m.getStok());
            }
            System.out
                    .println(ANSI_CYAN + "└────┴─────────────────────┴───────────┴─────────────┴──────┘" + ANSI_RESET);
        }
    }

    // Fitur untuk mengedit data
    public void editMinuman(int id, int hargaBaru, int stokBaru) {
        Optional<Minuman> minumanOpt = repository.findMinumanById(id);
        if (minumanOpt.isPresent()) {
            Minuman minuman = minumanOpt.get();
            minuman.setHarga(hargaBaru);
            minuman.setStok(stokBaru);
            System.out.println(ANSI_GREEN + "Sukses: Data minuman ID " + id + " berhasil diperbarui." + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + "Error: Minuman dengan ID " + id + " tidak ditemukan." + ANSI_RESET);
        }
    }

    // Fitur untuk menghapus data
    public void hapusMinuman(int id) {
        if (repository.hapusMinuman(id)) {
            System.out.println(ANSI_GREEN + "Sukses: Minuman dengan ID " + id + " berhasil dihapus." + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + "Error: Minuman dengan ID " + id + " tidak ditemukan." + ANSI_RESET);
        }
    }

    // Fitur untuk membeli minuman (berdasarkan ID, untuk internal)
    public void beliMinuman(int id, int jumlah, int uangBayar) {
        Optional<Minuman> minumanOpt = repository.findMinumanById(id);
        prosesPembelian(minumanOpt, jumlah, uangBayar);
    }

    // Fitur untuk membeli minuman (berdasarkan Nama, untuk pengguna)
    public void beliMinuman(String nama, int jumlah, int uangBayar) {
        Optional<Minuman> minumanOpt = repository.findMinumanByNama(nama);
        prosesPembelian(minumanOpt, jumlah, uangBayar);
    }

    // Logika pembelian yang dipisahkan agar bisa dipakai ulang
    private void prosesPembelian(Optional<Minuman> minumanOpt, int jumlah, int uangBayar) {
        if (minumanOpt.isPresent()) {
            Minuman minuman = minumanOpt.get();
            if (minuman.getStok() < jumlah) {
                System.out.println(ANSI_RED + "Error: Stok '" + minuman.getNama() + "' tidak mencukupi." + ANSI_RESET);
                return;
            }

            int totalHarga = minuman.getHarga() * jumlah;

            if (uangBayar < totalHarga) {
                System.out.println(ANSI_RED + "\nError: Jumlah uang yang dibayarkan tidak cukup." + ANSI_RESET);
                System.out.printf(ANSI_WHITE + "Total Belanja: Rp %d, Uang Anda: Rp %d%n" + ANSI_RESET, totalHarga,
                        uangBayar);
                return; // Batalkan transaksi
            }

            minuman.kurangiStok(jumlah); // Kurangi stok hanya jika pembayaran berhasil
            int kembalian = uangBayar - totalHarga;

            System.out.println(ANSI_CYAN + "\n┌───────────────────────────────┐" + ANSI_RESET);
            System.out.println(
                    ANSI_CYAN + "│" + ANSI_YELLOW + "         STRUK PEMBELIAN         " + ANSI_CYAN + "│" + ANSI_RESET);
            System.out.println(ANSI_CYAN + "├───────────────────────────────┤" + ANSI_RESET);
            System.out.printf(ANSI_CYAN + "│ " + ANSI_WHITE + "Produk      : %-16s" + ANSI_CYAN + " │%n" + ANSI_RESET,
                    minuman.getNama());
            System.out.printf(ANSI_CYAN + "│ " + ANSI_WHITE + "Jumlah      : %-16d" + ANSI_CYAN + " │%n" + ANSI_RESET,
                    jumlah);
            System.out.println(ANSI_CYAN + "│                               │" + ANSI_RESET);
            System.out.printf(
                    ANSI_CYAN + "│ " + ANSI_WHITE + "Total Harga : Rp %-13d" + ANSI_CYAN + " │%n" + ANSI_RESET,
                    totalHarga);
            System.out.printf(
                    ANSI_CYAN + "│ " + ANSI_WHITE + "Uang Bayar  : Rp %-13d" + ANSI_CYAN + " │%n" + ANSI_RESET,
                    uangBayar);
            System.out.printf(
                    ANSI_CYAN + "│ " + ANSI_WHITE + "Kembalian   : Rp %-13d" + ANSI_CYAN + " │%n" + ANSI_RESET,
                    kembalian);
            System.out.println(ANSI_CYAN + "└───────────────────────────────┘" + ANSI_RESET);
            System.out.println(ANSI_GREEN + "Transaksi berhasil! Terima kasih." + ANSI_RESET);

        } else {
            System.out.println(ANSI_RED + "Error: Minuman tidak ditemukan." + ANSI_RESET);
        }
    }
}