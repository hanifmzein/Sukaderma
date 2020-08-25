package com.uinsk.sukaderma.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Transaksi implements Parcelable {
    public Transaksi(Parcel in) {
        jenis = in.readString();
        produk = in.readString();
        id_panti = in.readInt();
        jumlah = in.readInt();
        total_harga = in.readInt();
        status = in.readString();
    }

    public static final Creator<Transaksi> CREATOR = new Creator<Transaksi>() {
        @Override
        public Transaksi createFromParcel(Parcel in) {
            return new Transaksi(in);
        }

        @Override
        public Transaksi[] newArray(int size) {
            return new Transaksi[size];
        }
    };

    public Transaksi() {

    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getProduk() {
        return produk;
    }

    public void setProduk(String produk) {
        this.produk = produk;
    }

    public int getId_panti() {
        return id_panti;
    }

    public void setId_panti(int id_panti) {
        this.id_panti = id_panti;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public int getTotal_harga() {
        return total_harga;
    }

    public void setTotal_harga(int total_harga) {
        this.total_harga = total_harga;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String jenis;
    private String produk;
    private int id_panti;
    private int jumlah;
    private int total_harga;
    private String status;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(jenis);
        parcel.writeString(produk);
        parcel.writeInt(id_panti);
        parcel.writeInt(jumlah);
        parcel.writeInt(total_harga);
        parcel.writeString(status);
    }
}
