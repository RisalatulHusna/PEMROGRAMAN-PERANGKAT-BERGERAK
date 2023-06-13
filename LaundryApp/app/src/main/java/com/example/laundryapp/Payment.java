package com.example.laundryapp;

public class Payment {
    private String paymentId;
    private String nama;
    private String alamat;
    private String noTelpon;
    private String jenisLaundry;
    private String jumlahKilo;
    private String jumlahHarga;

    public Payment() {
        // Default constructor required for Firebase
    }

    public Payment(String paymentId, String nama, String alamat, String noTelpon, String jenisLaundry, String jumlahKilo, String jumlahHarga) {
        this.paymentId = paymentId;
        this.nama = nama;
        this.alamat = alamat;
        this.noTelpon = noTelpon;
        this.jenisLaundry = jenisLaundry;
        this.jumlahKilo = jumlahKilo;
        this.jumlahHarga = jumlahHarga;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getNoTelpon() {
        return noTelpon;
    }

    public String getJenisLaundry() {
        return jenisLaundry;
    }

    public String getJumlahKilo() {
        return jumlahKilo;
    }

    public String getJumlahHarga() {
        return jumlahHarga;
    }
}
