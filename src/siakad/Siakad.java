package siakad;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Siakad {

    /**
     * @param args the command line arguments
     */

    static ArrayList<Mahasiswa> listMhs = new ArrayList<>();

    public static void main(String[] args) {

        // Dummy data
        Dosen dsn1 = new Dosen(
                "1234567890",
                "Dr. Budi Santoso",
                "Aktif");
        Mahasiswa mhs1 = new Mahasiswa(
                "2310001",
                "Andi Pratama",
                Mahasiswa.Prodi.TEKNIK_INFORMATIKA,
                3.75,
                dsn1);

        Dosen dsn2 = new Dosen(
                "1234567890",
                "Dr. Budi Santoso",
                "Aktif");
        Mahasiswa mhs2 = new Mahasiswa(
                "24552011280",
                "Winata Hadi Pratama",
                Mahasiswa.Prodi.DESAIN_KOMUNIKASI_VISUAL,
                4,
                dsn2);

        tambahMahasiswa(mhs1);
        tambahMahasiswa(mhs2);

        // Jika pengguna ingin keluar dari menu
        Boolean exit = false;

        Scanner input = new Scanner(System.in);

        // Menu loop
        while (!exit) {
            showMenu();
            int menuSelection = input.nextInt();
            switch (menuSelection) {
                case 0: // Exit
                    System.out.println(
                            "=========================================================\n" +
                            "Terima kasih telah menggunakan Sistem Informasi Akademik.\n" +
                            "=========================================================\n");
                    exit = true;
                    break;
                case 1: // List Mahasiswa
                    System.out.println("=== Daftar Mahasiswa ===");
                    displayListMahasiswa();
                    break;
                case 2: // Search Mahasiswa by NIM
                    System.out.println("=== Pencarian Mahasiswa ===");

                    System.out.print("Masukan NIM yang ingin dicari: ");
                    input.nextLine(); // Consume the newline character
                    String nimToSearch = input.next();

                    Mahasiswa foundedMhs = cariMahasiswaByNIM(nimToSearch);

                    if (foundedMhs != null) {
                        System.out.println("Data Mahasiswa ditemukan:");
                        foundedMhs.tampilData();
                    } else {
                        System.out.println("Mahasiswa dengan NIM " + nimToSearch + " tidak ditemukan.");
                    }

                    break;
                case 3: // Calculate average IPK
                    System.out.println("Jumlah Mahasiswa: " + listMhs.size());
                    System.out.println("Rata-rata IPK Mahasiswa: " + rataRataIPK(listMhs));
                    break;
                case 4: // Change Dosen Wali
                    System.out.println("=== Penggantian Dosen Wali ===");
                    System.out.print("Masukkan NIM Mahasiswa: ");
                    input.nextLine(); // Consume the newline character
                    String nimMahasiswa = input.next();
                    Mahasiswa mhsToUpdate = cariMahasiswaByNIM(nimMahasiswa);
                    if (mhsToUpdate == null) {
                        System.out.println("Mahasiswa dengan NIM " + nimMahasiswa + " tidak ditemukan.");
                        break;
                    }
                    mhsToUpdate.tampilData();

                    System.out.print("Masukkan nama Dosen Wali baru: ");
                    input.nextLine(); // Consume the newline character
                    String namaDosenBaru = input.nextLine();
                    System.out.print("Masukkan NIDN Dosen Wali baru: ");
                    String nidnDosenBaru = input.nextLine();
                    System.out.print("Masukkan status Dosen Wali baru: ");
                    String statusDosenBaru = input.nextLine();
                    Dosen dosenWaliBaru = new Dosen(nidnDosenBaru, namaDosenBaru, statusDosenBaru);
                    mhsToUpdate.dosenWali = dosenWaliBaru;

                    System.out.println("Dosen Wali berhasil diperbarui.");
                    mhsToUpdate.tampilData();
                    break;
                case 5: // Add new Mahasiswa
                    System.out.println("=== Penambahan Mahasiswa ===");
                    input.nextLine(); // Consume the newline character
                    System.out.print("NIM Mahasiswa: ");
                    String nim = input.nextLine();
                    System.out.print("Nama Mahasiswa: ");
                    String nama = input.nextLine();
                    System.out.println("Pilih Program Studi: ");
                    System.out.println("(1) Teknik Industri");
                    System.out.println("(2) Teknik Informatika");
                    System.out.println("(3) Desain Komunikasi Visual");
                    System.out.println("(4) Bisnis Digital");
                    System.out.println("(5) Manajemen Retail");
                    System.out.print("Pilihan (1-5): ");
                    int prodiInt = input.nextInt();
                    Mahasiswa.Prodi prodi;
                    switch (prodiInt) {
                        case 1:
                            prodi = Mahasiswa.Prodi.TEKNIK_INDUSTRI;
                            break;
                        case 2:
                            prodi = Mahasiswa.Prodi.TEKNIK_INFORMATIKA;
                            break;
                        case 3:
                            prodi = Mahasiswa.Prodi.DESAIN_KOMUNIKASI_VISUAL;
                            break;
                        case 4:
                            prodi = Mahasiswa.Prodi.BISNIS_DIGITAL;
                            break;
                        case 5:
                            prodi = Mahasiswa.Prodi.MANAJEMEN_RETAIL;
                            break;
                        default:
                            prodi = Mahasiswa.Prodi.TEKNIK_INFORMATIKA;
                            System.out.println("Pilihan tidak valid, program studi diatur ke Teknik Informatika.");
                    }
                    System.out.print("IPK: ");
                    double ipk = input.nextDouble();

                    input.nextLine(); // Consume the newline character
                    System.out.print("Nama Dosen Wali: ");
                    String namaDosen = input.nextLine();
                    System.out.print("NIDN Dosen Wali: ");
                    String nidnDosen = input.nextLine();
                    System.out.print("Status Dosen Wali: ");
                    String statusDosen = input.nextLine();

                    Dosen dosenWali = new Dosen(nidnDosen, namaDosen, statusDosen);
                    Mahasiswa newMhs = new Mahasiswa(nim, nama, prodi, ipk, dosenWali);

                    System.out.println("Mahasiswa baru berhasil ditambahkan:");
                    newMhs.tampilData();
                    tambahMahasiswa(newMhs);
                    break;
                default: // Invalid choice
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    break;
            }
        }
        input.close();

        // listMhs.add(mhs1);

        // mhs1.tampilData();

        // mhs1.predikatIPK();

        // System.out.println("===============================");

        // listMhs.add(mhs2);

        // mhs2.tampilData();

        // mhs2.predikatIPK();

        // System.out.println("===============================");
    }

    public static void showMenu() {
        System.out.println("=== Sistem Informasi Akademik ===");
        System.out.println("0. Keluar");
        System.out.println("1. Daftar Mahasiswa");
        System.out.println("2. Mencari data berdasarkan NIM");
        System.out.println("3. Menghitung rata-rata IPK");
        System.out.println("4. Mengganti dosen wali");
        System.out.println("5. Menambah siswa baru");
        System.out.print("Pilih menu: ");
    }

    public static void displayListMahasiswa() {
        for (Mahasiswa mhs : listMhs) {
            mhs.tampilData();
            System.out.println("-------------------------------");
        }
    }

    public static void tambahMahasiswa(Mahasiswa mhs) {
        listMhs.add(mhs);
    }

    public static Mahasiswa cariMahasiswaByNIM(String nim) {
        for (Mahasiswa mhs : listMhs) {
            if (mhs.nim.equals(nim)) {
                return mhs;
            }
        }
        return null;
    }

    public static double rataRataIPK(List<Mahasiswa> list) {
        double totalIpk = 0;
        for (Mahasiswa mhs : list) {
            totalIpk += mhs.ipk;
        }
        double rataRata = totalIpk / list.size();
        return rataRata;
    }
}
