package com.uinsk.sukaderma.data;

import com.uinsk.sukaderma.model.Panti;
import com.uinsk.sukaderma.model.Produk;

import java.util.ArrayList;
import java.util.Arrays;

public class ProduksData {
    public static String[][] data = new String[][]{
            {"Jagung", "4000", "produk_jagung"},
            {"Beras", "10000", "produk_beras"},
            {"Kentang", "12000", "produk_kentang"},
            {"Kedelai", "7000", "produk_kedelai"}
    };

    public static ArrayList<Produk> getListData(){
        ArrayList<Produk> list = new ArrayList<>();
        for (String[] aData : data){
            Produk produk = new Produk();
            produk.setNama(aData[0]);
            produk.setHarga(Integer.parseInt(aData[1]));
            produk.setFoto(aData[2]);

            list.add(produk);
        }

        return list;
    }

    public static Produk getItemData(String nama){

        String[] arrNama = new String[data.length];

        for (int i = 0; i<data.length; i++){
            arrNama[i] = data[i][0];
        }

        String[] arr = data[Arrays.asList(arrNama).indexOf(nama)];

        Produk produk = new Produk();
        produk.setNama(arr[0]);
        produk.setHarga(Integer.parseInt(arr[1]));
        produk.setFoto(arr[2]);

        return produk;
    };
}
