package app.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MinumanRepository {
    private List<Minuman> daftarMinuman = new ArrayList<>();

    public MinumanRepository() {
        // Inisialisasi data awal
        tambahMinuman(new Minuman("Coca-Cola", "Kaleng", 7000, 24));
        tambahMinuman(new Minuman("Sprite", "Kaleng", 7000, 20));
        tambahMinuman(new Minuman("Teh Kotak", "Karton", 5000, 30));
    }

    public List<Minuman> getAllMinuman() {
        return daftarMinuman;
    }

    public Optional<Minuman> findMinumanById(int id) {
        return daftarMinuman.stream()
                .filter(m -> m.getId() == id)
                .findFirst();
    }

    public Optional<Minuman> findMinumanByNama(String nama) {
        return daftarMinuman.stream()
                .filter(m -> m.getNama().equalsIgnoreCase(nama))
                .findFirst();
    }

    public void tambahMinuman(Minuman minuman) {
        daftarMinuman.add(minuman);
    }

    public boolean hapusMinuman(int id) {
        return daftarMinuman.removeIf(m -> m.getId() == id);
    }
}