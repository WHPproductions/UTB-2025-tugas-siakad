package siakad;

public class MahasiswaOnline extends Mahasiswa {
    // tambahan atribut untuk ruang praktik
    public enum AplikasiMeeting {
        ZOOM,
        GOOGLE_MEET,
        MICROSOFT_TEAMS
    }
    private AplikasiMeeting aplikasiYgSdngDigunakan = null;

    public MahasiswaOnline(
        String nim,
        String nama,
        Prodi prodi,
        double ipk,
        Dosen dosenWali,
        java.util.List<MataKuliah> krs
    ) {
        super(nim, nama, prodi, ipk, dosenWali, krs);
    }

    public AplikasiMeeting getAplikasiYgSdngDigunakan() {
        return aplikasiYgSdngDigunakan;
    }
    public void setAplikasiYgSdngDigunakan(AplikasiMeeting aplikasiYgSdngDigunakan) {
        this.aplikasiYgSdngDigunakan = aplikasiYgSdngDigunakan;
    }
}
