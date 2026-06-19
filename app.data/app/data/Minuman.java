package app.data;

public class Minuman {
    private static int nextId = 1;

    private int id;
    private String nama;
    private String jenis;
    private int harga;
    private int stok;

    public Minuman(String nama, String jenis, int harga, int stok) {
        this.id = nextId++;
        this.nama = nama;
        this.jenis = jenis;
        this.harga = harga;
        this.stok = stok;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getJenis() {
        return jenis;
    }

    public int getHarga() {
        return harga;
    }

    public int getStok() {
        return stok;
    }

    // Setters untuk fitur Edit
    public void setHarga(int harga) {
        this.harga = harga;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public void kurangiStok(int jumlah) {
        if (this.stok >= jumlah) {
            this.stok -= jumlah;
        }
    }

    public String getInfo() {
        return String.format("ID: %-3d | Nama: %-15s | Jenis: %-12s | Harga: Rp %-6d | Stok: %d",
                id, nama, jenis, harga, stok);
    }
}