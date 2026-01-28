package siakad;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DosenTetap extends Dosen {
    private String lokasiKantor;

    public DosenTetap() {
        super();
    }

    public DosenTetap(String nama, String nidn, String status_dosen, String lokasiKantor) {
        super(nama, nidn, status_dosen);
        this.lokasiKantor = lokasiKantor;
    }

    @Override
    public void absen(String jam, String keterangan) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String waktu = now.format(formatter);

        System.out.println("=== ABSEN DOSEN TETAP ===");
        System.out.println("Nama Dosen  : " + this.nama);
        System.out.println("NIDN        : " + this.nidn);
        System.out.println("Status      : " + this.status_dosen);
        System.out.println("Lokasi      : " + this.lokasiKantor);
        System.out.println("Waktu Absen : " + waktu);
        System.out.println("Jam Masuk   : " + jam);
        System.out.println("Keterangan  : " + keterangan);
        System.out.println("Status: HADIR");
        System.out.println("=======================\n");
    }

    public String getLokasiKantor() {
        return lokasiKantor;
    }

    public void setLokasiKantor(String lokasiKantor) {
        this.lokasiKantor = lokasiKantor;
    }
}
