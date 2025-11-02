package siakad;

import java.util.List;
import java.util.regex.Pattern;

public class Mahasiswa {
    enum Prodi {
        TEKNIK_INDUSTRI,
        TEKNIK_INFORMATIKA,
        DESAIN_KOMUNIKASI_VISUAL,
        BISNIS_DIGITAL,
        MANAJEMEN_RETAIL,
    }

    enum Predikat {
        CUM_LAUDE,
        SANGAT_MEMUASKAN,
        MEMUASKAN,
        CUKUP,
    }

    private String nim;
    private String nama;
    private Prodi prodi;
    private double ipk;
    private Predikat predikat;
    private Dosen dosenWali;
    private List<MataKuliah> krs;
    private int jumlahKrs;

    // Default Constructor
    public Mahasiswa() {
    }

    // Complete Parameter Constructor
    public Mahasiswa(String nim, String nama, Prodi prodi, double ipk, Dosen dosenWali, List<MataKuliah> krs) {
        this.nim = nim;
        this.nama = nama;
        this.prodi = prodi;
        this.ipk = ipk;
        this.dosenWali = dosenWali;
        this.krs = krs;
        this.jumlahKrs = krs.size();

        // menentukan predikat berdasarkan ipk
        if (ipk >= 3.5) {
            this.predikat = Predikat.CUM_LAUDE;
        } else if (ipk >= 3.0) {
            this.predikat = Predikat.SANGAT_MEMUASKAN;
        } else if (ipk >= 2.5) {
            this.predikat = Predikat.MEMUASKAN;
        } else {
            this.predikat = Predikat.CUKUP;
        }
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        // validasi
        Pattern pattern = Pattern.compile("^[0-9]{11}$");
        if (!pattern.matcher(nim).matches()) {
            System.out.println(
                    "NIM harus terdiri dari 11 digit angka \n" +
                            "Contoh: 24552011280");
            return;
        }
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        // validasi
        Pattern pattern = Pattern.compile("^[A-Za-z ]+$");
        if (!pattern.matcher(nama).matches()) {
            System.out.println(
                    "Nama hanya boleh mengandung huruf dan spasi \n" +
                            "Contoh: Budi Santoso");
            return;
        }
        this.nama = nama;
    }

    public Prodi getProdi() {
        return prodi;
    }

    public void setProdi(Prodi prodi) {
        this.prodi = prodi;
    }

    public double getIpk() {
        return ipk;
    }

    public void setIpk(double ipk) {
        // validasi
        if (ipk < 0.0 || ipk > 4.0) {
            System.out.println(
                    "IPK harus berada di rentang 0.0 sampai 4.0 \n" +
                            "Contoh: 3.75");
            return;
        }
        this.ipk = ipk;
    }

    public Dosen getDosenWali() {
        return dosenWali;
    }

    public void setDosenWali(Dosen dosenWali) {
        this.dosenWali = dosenWali;
    }

    public List<MataKuliah> getKrs() {
        return krs;
    }

    public void setKrs(List<MataKuliah> krs) {
        this.krs = krs;
    }

    public int getJumlahKrs() {
        return jumlahKrs;
    }
    
    public void setJumlahKrs(int jumlahKrs) {
        this.jumlahKrs = jumlahKrs;
    }

    void tampilData() {
        System.out.println("NIM\t\t: " + nim);
        System.out.println("Nama\t\t: " + nama);
        System.out.println("Program Studi\t: " + prodi);
        System.out.println("IPK\t\t: " + ipk);
        System.out.println("Wali Dosen\t: " + dosenWali.nama);
        System.out.println("\t\t  " + dosenWali.nidn);
        System.out.println("\t\t  " + dosenWali.status_dosen);
    }

    void predikatIPK() {
        switch (predikat) {
            case CUM_LAUDE:
                System.out.println("Predikat\t: Cum Laude");
                break;
            case SANGAT_MEMUASKAN:
                System.out.println("Predikat\t: Sangat Memuaskan");
                break;
            case MEMUASKAN:
                System.out.println("Predikat\t: Memuaskan");
                break;
            case CUKUP:
                System.out.println("Predikat\t: Cukup");
                break;
        }
    }

    String predikatKelulusan() {
        if (ipk >= 2.0) {
            return "Lulus";
        } else {
            return "Tidak Lulus";
        }
    }

    void infoSingkat() {
        System.out.println(nim + " - " + nama + " (" + prodi + ") - IPK: " + ipk);
    }

    Mahasiswa updMahasiswa(String nim, String nama, Prodi prodi, double ipk, Dosen dosenWali) {
        this.nim = nim;
        this.nama = nama;
        this.prodi = prodi;
        this.ipk = ipk;
        this.dosenWali = dosenWali;

        // menentukan predikat berdasarkan ipk
        if (ipk >= 3.5) {
            this.predikat = Predikat.CUM_LAUDE;
        } else if (ipk >= 3.0) {
            this.predikat = Predikat.SANGAT_MEMUASKAN;
        } else if (ipk >= 2.5) {
            this.predikat = Predikat.MEMUASKAN;
        } else {
            this.predikat = Predikat.CUKUP;
        }

        return this;
    }

    void tambahMataKuliah(MataKuliah mk) {
        // validasi duplikasi mata kuliah
        if (this.krs.contains(mk)) {
            System.out.println("Mata kuliah dengan kode " + mk.getKode_matkul() + " sudah ada di KRS.");
            return;
        }

        // validasi jumlah sks
        int jumlahSks = 0;
        for (MataKuliah existingMk : this.krs) { // hitung semua sks di array krs
            jumlahSks += existingMk.getSks();
        }
        if (jumlahSks + mk.getSks() > 24) {
            System.out.println("Tidak dapat menambahkan mata kuliah " + mk.getKode_matkul() +
                    ". Jumlah SKS melebihi batas maksimum 24 SKS.");
            return;
        }

        this.krs.add(mk);
    }

    void hapusMataKuliah(String kodeMK) {
        Boolean isDeleted = this.krs.removeIf(mk -> mk.getKode_matkul().equals(kodeMK));
        if (!isDeleted) {
            System.out.println("Mata Kuliah dengan kode " + kodeMK + " tidak ditemukan.");
        } else {
            System.out.println("Mata Kuliah dengan kode " + kodeMK + " berhasil dihapus dari KRS.");
        }
    }

    void tampilKRS() {
        System.out.println("Mata Kuliah yang diambil:");
        int totalSks = 0;
        for (MataKuliah mk : krs) {
            totalSks += mk.getSks();
            System.out.print("- "); // menambahkan tanda minus sebelum info mata kuliah
            mk.info();
        }
        System.out.println("Total SKS: " + totalSks);
    }
}
