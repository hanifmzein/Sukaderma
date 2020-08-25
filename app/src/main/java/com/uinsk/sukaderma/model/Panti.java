package com.uinsk.sukaderma.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Panti implements Parcelable {

    public Panti(Parcel in) {
        id_panti = in.readInt();
        nama = in.readString();
        alamat = in.readString();
        produk = in.readString();
        foto = in.readString();
    }

    public static final Creator<Panti> CREATOR = new Creator<Panti>() {
        @Override
        public Panti createFromParcel(Parcel in) {
            return new Panti(in);
        }

        @Override
        public Panti[] newArray(int size) {
            return new Panti[size];
        }
    };

    public Panti() {

    }

    public int getId_panti() {
        return id_panti;
    }

    public void setId_panti(String id_panti) {
        this.id_panti = Integer.parseInt(id_panti);
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getProduk() {
        return produk;
    }

    public void setProduk(String produk) {
        this.produk = produk;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    private int id_panti;
    private String nama;
    private String alamat;
    private String produk;
    private String foto;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id_panti);
        parcel.writeString(nama);
        parcel.writeString(alamat);
        parcel.writeString(produk);
        parcel.writeString(foto);
    }
}
