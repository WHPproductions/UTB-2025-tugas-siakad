package siakad;

import java.util.List;

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
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
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
        this.ipk = ipk;
    }

    public Dosen getDosenWali() {
        return dosenWali;
    }

    public void setDosenWali(String nama) {
        this.dosenWali = new Dosen(nama);
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
        this.krs.add(mk);
    }

    void hapusMataKuliah(String kodeMK) {
        Boolean isDeleted = this.krs.removeIf(mk -> mk.getKode_matkul().equals(kodeMK));
        if (!isDeleted) {
            System.out.println("Mata Kuliah dengan kode " + kodeMK + " tidak ditemukan.");
        }
    }

    void tampilKRS() {
        System.out.println("Mata Kuliah yang diambil:");
        for (MataKuliah mk : krs) {
            System.out.print("- "); // menambahkan tanda minus sebelum info mata kuliah
            mk.info();
        }
    }
}
