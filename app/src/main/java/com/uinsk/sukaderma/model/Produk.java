package com.uinsk.sukaderma.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Produk implements Parcelable {
    private String nama;
    private int harga;
    private String foto;


    protected Produk(Parcel in) {
        nama = in.readString();
        harga = in.readInt();
        foto = in.readString();
    }

    public static final Creator<Produk> CREATOR = new Creator<Produk>() {
        @Override
        public Produk createFromParcel(Parcel in) {
            return new Produk(in);
        }

        @Override
        public Produk[] newArray(int size) {
            return new Produk[size];
        }
    };

    public Produk() {

    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nama);
        parcel.writeInt(harga);
        parcel.writeString(foto);
    }
}
