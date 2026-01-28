package siakad;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DosenHonorer extends Dosen {
    private String institutAsal;

    public DosenHonorer() {
        super();
    }

    public DosenHonorer(String nama, String nidn, String status_dosen, String institutAsal) {
        super(nama, nidn, status_dosen);
        this.institutAsal = institutAsal;
    }

    @Override
    public void absen(String jam, String keterangan) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String waktu = now.format(formatter);

        System.out.println("=== ABSEN DOSEN HONORER ===");
        System.out.println("Nama Dosen   : " + this.nama);
        System.out.println("NIDN         : " + this.nidn);
        System.out.println("Status       : " + this.status_dosen);
        System.out.println("Asal Institut: " + this.institutAsal);
        System.out.println("Waktu Absen  : " + waktu);
        System.out.println("Jam Masuk    : " + jam);
        System.out.println("Keterangan   : " + keterangan);
        System.out.println("Status: HADIR");
        System.out.println("===========================\n");
    }

    public String getInstitutAsal() {
        return institutAsal;
    }

    public void setInstitutAsal(String institutAsal) {
        this.institutAsal = institutAsal;
    }
}
