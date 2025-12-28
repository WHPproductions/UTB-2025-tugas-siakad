package siakad;

import java.util.List;

public class MahasiswaOffline extends Mahasiswa {
    // tambahan atribut untuk ruang praktik
    private String[] rencanaRuangKelas;
    private String ruangKlsYngSdngDipakai = null;

    public MahasiswaOffline(
        String nim,
        String nama,
        Prodi prodi,
        double ipk,
        Dosen dosenWali,
        List<MataKuliah> krs,
        String[] rencanaRuangKelas
    ) {
        super(nim, nama, prodi, ipk, dosenWali, krs);
        this.rencanaRuangKelas = rencanaRuangKelas;
    } 

    public String[] getRencanaRuangKelas() {
        return rencanaRuangKelas;
    }

    public void setRencanaRuangKelas(String[] rencanaRuangKelas) {
        this.rencanaRuangKelas = rencanaRuangKelas;
    }
    
    public String getRuangKlsYngSdngDipakai() {
        return ruangKlsYngSdngDipakai;
    }

    public void pakaiRuangKelas(String ruangKelas) {
        for (String rk : rencanaRuangKelas) {
            if (rk.equals(ruangKelas)) {
                this.ruangKlsYngSdngDipakai = ruangKelas;
                return;
            }
        }
        System.out.println("Ruang kelas " + ruangKelas + " tidak ada dalam rencana.");
    }

    public void selesaiMenggunakanRuangKelas() {
        this.ruangKlsYngSdngDipakai = null;
    }
}


