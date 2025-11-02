package siakad;

public class Dosen {
    String nama;
    String nidn;
    String status_dosen; // e.g. "Aktif", "Tidak Aktif"

    public Dosen() {
    }

    public Dosen(String nama) {
        this.nama = nama;
        this.nidn = "0000000000";
        this.status_dosen = "N/A";
    }

    public Dosen(String nama, String nidn, String status_dosen) {
        this.nama = nama;
        this.nidn = nidn;
        this.status_dosen = status_dosen;
    }

    void info() {
        System.out.println("NIDN:\t" + nidn);
        System.out.println("Nama:\t" + nama);
        System.out.println("Status:\t" + status_dosen);
    }

    @Override
    public String toString() {
        return "NIDN: " + nidn + "\n" +
                ", Nama: " + nama + "\n" +
                ", Status: " + status_dosen + "\n";
    }
}