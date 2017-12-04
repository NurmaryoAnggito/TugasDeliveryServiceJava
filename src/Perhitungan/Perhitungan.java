/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Perhitungan;

import DAO.TarifDAO;

import Model.Penerima;
import Model.Tarif;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author user
 */
public class Perhitungan {

    /**
     * @return the tujuan
     */
    public String getTujuan() {
        return tujuan;
    }

    /**
     * @param tujuan the tujuan to set
     */
    public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
    }

    /**
     * @return the jenispaket
     */
    public String getJenispaket() {
        return jenispaket;
    }

    /**
     * @param jenispaket the jenispaket to set
     */
    public void setJenispaket(String jenispaket) {
        this.jenispaket = jenispaket;
    }
    private double TarifAsuransi = 0.03;
    private double berat;
    private double HargaBarang;
    private boolean asuransi;
    private String pembayaran;
    private double panjang;
    private double lebar;
    private double tinggi;
    
    private TarifDAO tarifdao = new TarifDAO();
    private Tarif datatarif = new Tarif();
    private Penerima penerima = new Penerima();
    private double tarifterpilih;
    private String jenispaket;
    
    private double biayakirim;
    private double biayaasuransi;
    private double biayakirimdanasuransi;
    private double dimensi;
    private String tujuan;

    private String resipaket;
    private String resi;
    private Date tgl = new Date();
    /**
     * @return the datakirim
     */
    
    
    public Perhitungan() {
    }
    
    public double hitungDimensi(){
        double d = this.getPanjang()*this.getLebar()*this.getTinggi();
        setDimensi(d);
        return getDimensi();
    }
    
    public double hitungHargaAsuransi(){
        setBiayaasuransi(this.getTarifAsuransi()*this.getHargaBarang());
        return getBiayaasuransi();
    }
    
    public double hitungBiayaKirim(){
        setBiayakirim(this.getBerat()*this.getTarifterpilih());
        return getBiayakirim();
    }

    public double hitungbiayaTotal(){
        setBiayakirimdanasuransi(this.getBiayaasuransi()+this.getBiayakirim());
        return getBiayakirimdanasuransi();
    }
    
    public void selectTarifReguler(){
        tarifdao.scanTarif();
        for (Tarif tarif : tarifdao.getListtarif()) {
            if (this.getTujuan().equalsIgnoreCase(tarif.getProvinsiTujuan())) {
                this.setTarifterpilih(tarif.getTarifreguler());
            }
        }
        
    }
    
    public void selectTarifCepat(){
        tarifdao.scanTarif();
        for (Tarif tarif : tarifdao.getListtarif()) {
            if (this.getTujuan().equalsIgnoreCase(tarif.getProvinsiTujuan())) {
                this.setTarifterpilih(tarif.getTarifcepat());
            }
        }
        
    }
    
    public void selectTarifExpress(){
        tarifdao.scanTarif();
        for (Tarif tarif : tarifdao.getListtarif()) {
            if (this.getTujuan().equalsIgnoreCase(tarif.getProvinsiTujuan())) {
                this.setTarifterpilih(tarif.getTarifexpress());
            }
        }
        
    }
    
    public void selectTarifTommorow(){
        tarifdao.scanTarif();
        for (Tarif tarif : tarifdao.getListtarif()) {
            if (this.getTujuan().equalsIgnoreCase(tarif.getProvinsiTujuan())) {
                this.setTarifterpilih(tarif.getTariftommorow());
            }
        }
        
    }
    
    public void selectTarifSameday(){
        tarifdao.scanTarif();
        for (Tarif tarif : tarifdao.getListtarif()) {
            if (this.getTujuan().equalsIgnoreCase(tarif.getProvinsiTujuan())) {
                this.setTarifterpilih(tarif.getTarifsameday());
            }
        }
        
    }
    
    public void buatResi(){
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyy");
        double rand = Math.random()*1000;
        double ceil = Math.ceil(rand);
        int kode = (int)ceil;
        
        setResi("RE-"+getResipaket()+"-"+sdf.format(getTgl())+"-"+String.valueOf(kode));
    }
    

    /**
     * @return the tarifdao
     */
    public TarifDAO getTarifdao() {
        return tarifdao;
    }

    /**
     * @param tarifdao the tarifdao to set
     */
    public void setTarifdao(TarifDAO tarifdao) {
        this.tarifdao = tarifdao;
    }

    /**
     * @return the datatarif
     */
    public Tarif getDatatarif() {
        return datatarif;
    }

    /**
     * @param datatarif the datatarif to set
     */
    public void setDatatarif(Tarif datatarif) {
        this.datatarif = datatarif;
    }

    /**
     * @return the tarifterpilih
     */
    public double getTarifterpilih() {
        return tarifterpilih;
    }

    /**
     * @param tarifterpilih the tarifterpilih to set
     */
    public void setTarifterpilih(double tarifterpilih) {
        this.tarifterpilih = tarifterpilih;
    }

    /**
     * @return the penerima
     */
    public Penerima getPenerima() {
        return penerima;
    }

    /**
     * @param penerima the penerima to set
     */
    public void setPenerima(Penerima penerima) {
        this.penerima = penerima;
    }

    /**
     * @return the listtarif
     */
    

    /**
     * @return the biayakirim
     */
    public double getBiayakirim() {
        return biayakirim;
    }

    /**
     * @param biayakirim the biayakirim to set
     */
    public void setBiayakirim(double biayakirim) {
        this.biayakirim = biayakirim;
    }

    /**
     * @return the biayaasuransi
     */
    public double getBiayaasuransi() {
        return biayaasuransi;
    }

    /**
     * @param biayaasuransi the biayaasuransi to set
     */
    public void setBiayaasuransi(double biayaasuransi) {
        this.biayaasuransi = biayaasuransi;
    }

    /**
     * @return the biayakirimdanasuransi
     */
    public double getBiayakirimdanasuransi() {
        return biayakirimdanasuransi;
    }

    /**
     * @param biayakirimdanasuransi the biayakirimdanasuransi to set
     */
    public void setBiayakirimdanasuransi(double biayakirimdanasuransi) {
        this.biayakirimdanasuransi = biayakirimdanasuransi;
    }

    /**
     * @return the dimensi
     */
    public double getDimensi() {
        return dimensi;
    }

    /**
     * @param dimensi the dimensi to set
     */
    public void setDimensi(double dimensi) {
        this.dimensi = dimensi;
    }

    /**
     * @return the TarifAsuransi
     */
    public double getTarifAsuransi() {
        return TarifAsuransi;
    }

    /**
     * @param TarifAsuransi the TarifAsuransi to set
     */
    public void setTarifAsuransi(double TarifAsuransi) {
        this.TarifAsuransi = TarifAsuransi;
    }

    /**
     * @return the berat
     */
    public double getBerat() {
        return berat;
    }

    /**
     * @param berat the berat to set
     */
    public void setBerat(double berat) {
        this.berat = berat;
    }

    /**
     * @return the HargaBarang
     */
    public double getHargaBarang() {
        return HargaBarang;
    }

    /**
     * @param HargaBarang the HargaBarang to set
     */
    public void setHargaBarang(double HargaBarang) {
        this.HargaBarang = HargaBarang;
    }

    /**
     * @return the asuransi
     */
    public boolean isAsuransi() {
        return asuransi;
    }

    /**
     * @param asuransi the asuransi to set
     */
    public void setAsuransi(boolean asuransi) {
        this.asuransi = asuransi;
    }

    /**
     * @return the pembayaran
     */
    public String getPembayaran() {
        return pembayaran;
    }

    /**
     * @param pembayaran the pembayaran to set
     */
    public void setPembayaran(String pembayaran) {
        this.pembayaran = pembayaran;
    }

    /**
     * @return the panjang
     */
    public double getPanjang() {
        return panjang;
    }

    /**
     * @param panjang the panjang to set
     */
    public void setPanjang(double panjang) {
        this.panjang = panjang;
    }

    /**
     * @return the lebar
     */
    public double getLebar() {
        return lebar;
    }

    /**
     * @param lebar the lebar to set
     */
    public void setLebar(double lebar) {
        this.lebar = lebar;
    }

    /**
     * @return the tinggi
     */
    public double getTinggi() {
        return tinggi;
    }

    /**
     * @param tinggi the tinggi to set
     */
    public void setTinggi(double tinggi) {
        this.tinggi = tinggi;
    }

    /**
     * @return the resipaket
     */
    public String getResipaket() {
        return resipaket;
    }

    /**
     * @param resipaket the resipaket to set
     */
    public void setResipaket(String resipaket) {
        this.resipaket = resipaket;
    }

    /**
     * @return the resi
     */
    public String getResi() {
        return resi;
    }

    /**
     * @param resi the resi to set
     */
    public void setResi(String resi) {
        this.resi = resi;
    }

    /**
     * @return the tgl
     */
    public Date getTgl() {
        return tgl;
    }

    /**
     * @param tgl the tgl to set
     */
    public void setTgl(Date tgl) {
        this.tgl = tgl;
    }

    /**
     * @return the jenispengiriman
     */
    
    
    
}
