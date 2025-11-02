package siakad;

import java.util.regex.Pattern;

public class MataKuliah {
    private String kode_matkul;
    private String namaMk;
    private int sks;

    public String getKode_matkul() {
        return kode_matkul;
    }
    
    public void setKode_matkul(String kode_matkul) {
        Pattern pattern = Pattern.compile("^[A-Z]{2,4}[0-9]{3}$");
        if (!pattern.matcher(kode_matkul).matches()) {
            System.out.println(
                "Kode mata kuliah harus terdiri dari 2-4 huruf kapital diikuti oleh 3 digit angka \n" +
                "Contoh: IF101, MK202, TI303"
                );
            return;
        }

        this.kode_matkul = kode_matkul;
    }
    
    public String getNamaMk() {
        return namaMk;
    }
    
    public void setNamaMk(String namaMk) {
        Pattern pattern = Pattern.compile("/^[A-Za-z]+(?:\\s*[A-Za-z]+)*(?: \\d*)?$/gm");
        if (!pattern.matcher(namaMk).matches()) {
            System.out.println(
                    "Nama mata kuliah hanya boleh mengandung huruf dan spasi, \n" +
                    "dengan opsi tambahan angka di akhir setelah spasi \n" +
                    "Contoh: Pemrograman Dasar, Matematika Diskrit 1"
                );
            return;
        }
        this.namaMk = namaMk;
    }
    
    public int getSks() {
        return sks;
    }
    
    public void setSks(int sks) {
        if (sks < 1 || sks > 6) {
            System.out.println(
                "SKS harus diantara rentang 1 sampai 6 secara inklusif"
                );
            return;
        }
        this.sks = sks;
    }

    public void info() {
        System.out.println(kode_matkul + " " + namaMk + " (" + sks + ")");
    }
}
