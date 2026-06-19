package app.ui;

public class Menu {

    public static void tampilkanSplashScreen() {
        clearScreen();
        String welcomeText = "Selamat Datang di...";
        System.out.println("\n\n\n");
        for (char ch : welcomeText.toCharArray()) {
            System.out.print(ch);
            try {
                Thread.sleep(100); // Jeda 100 milidetik per karakter
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("\n");
        tampilkanLogo();
        try {
            Thread.sleep(2000); // Tampilkan splash screen selama 2 detik
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // ANSI Color Codes for terminal output
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m"; // For titles
    public static final String ANSI_CYAN = "\u001B[36m"; // For frames and borders
    public static final String ANSI_WHITE = "\u001B[37m"; // For menu text

    private static void tampilkanLogo() {
        System.out.println(ANSI_YELLOW + "========================================================" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "          APLIKASI MESIN MINUMAN PINTAR (SMART DRINK)     " + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "========================================================" + ANSI_RESET);
    }

    public static void clearScreen() {
        // Trik sederhana untuk "membersihkan" layar di berbagai konsol
        for (int i = 0; i < 50; ++i)
            System.out.println();
    }

    public static void tampilkanMenuUtama() {
        clearScreen();
        tampilkanLogo();
        System.out.println(ANSI_CYAN + "┌──────────────────────────────────────────────────────┐" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "│" + ANSI_YELLOW + "                    PILIH OPERASI                     "
                + ANSI_CYAN + "│" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "├──────────────────────────────────────────────────────┤" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "│                                                      │" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "│   " + ANSI_WHITE + "[1] Tampilkan Daftar Minuman" + ANSI_CYAN + "   "
                + ANSI_WHITE + "[5] Hapus Minuman" + ANSI_CYAN + "   │" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "│   " + ANSI_WHITE + "[2] Tambah Minuman" + ANSI_CYAN + "             "
                + ANSI_WHITE + "[6] Beli Minuman" + ANSI_CYAN + "    │" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "│   " + ANSI_WHITE + "[3] Cari Minuman" + ANSI_CYAN
                + "                                   │" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "│   " + ANSI_WHITE + "[4] Edit Minuman" + ANSI_CYAN
                + "                                   │" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "│                                                      │" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "│   " + ANSI_WHITE + "[7] Keluar" + ANSI_CYAN
                + "                                         │" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "│                                                      │" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "└──────────────────────────────────────────────────────┘" + ANSI_RESET);
        System.out.print(ANSI_WHITE + "  Masukkan Pilihan Anda [1-7] : " + ANSI_RESET);
    }
}