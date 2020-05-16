package com.mustafa.juvo.Model;

public class Vaka {
    private String vakaNo;
    private String durum;
    private String hizmet;
    private String tarih;
    private String aciklama;

    public Vaka(String vakaNo, String durum, String hizmet, String tarih, String aciklama) {
        this.vakaNo = vakaNo;
        this.durum = durum;
        this.hizmet = hizmet;
        this.tarih = tarih;
        this.aciklama = aciklama;
    }

    public String getVakaNo() {
        return vakaNo;
    }

    public void setVakaNo(String vakaNo) {
        this.vakaNo = vakaNo;
    }

    public String getDurum() {
        return durum;
    }

    public void setDurum(String durum) {
        this.durum = durum;
    }

    public String getHizmet() {
        return hizmet;
    }

    public void setHizmet(String hizmet) {
        this.hizmet = hizmet;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    @Override
    public String toString() {
        return "Vaka{" +
                "vakaNo='" + vakaNo + '\'' +
                ", durum='" + durum + '\'' +
                ", hizmet='" + hizmet + '\'' +
                ", tarih='" + tarih + '\'' +
                ", aciklama='" + aciklama + '\'' +
                '}';
    }
}