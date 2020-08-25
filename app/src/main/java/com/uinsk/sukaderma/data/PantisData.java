package com.uinsk.sukaderma.data;

import com.uinsk.sukaderma.model.Panti;

import java.util.ArrayList;
import java.util.Arrays;

public class PantisData {
    public static String[][] data = new String[][]{
            {"0", "Panti Asuhan Al - Furqon Hidayatullah", "Holtekam, Muara Tami, Kota Jayapura, Papua 99351", "Jagung | Beras | Kentang | Kedelai", "panti_alfurqon"},
            {"1", "Panti Asuhan Muhammadiyah Abepura", "Awiyo, Abepura, Kota Jayapura, Papua 99351", "Jagung | Beras | Kentang | Kedelai", "panti_abepura"},
            {"2", "Panti Asuhan Karya Anak Perdamaian", "Jl. Komba, Yobeh, Sentani, Jayapura, Papua 99359", "Jagung | Beras | Kentang | Kedelai", "panti_perdamaian"}
    };

    public static ArrayList<Panti> getListData(){
        ArrayList<Panti> list = new ArrayList<>();
        for (String[] aData : data){
            Panti panti = new Panti();
            panti.setId_panti(aData[0]);
            panti.setNama(aData[1]);
            panti.setAlamat(aData[2]);
            panti.setProduk(aData[3]);
            panti.setFoto(aData[4]);

            list.add(panti);
        }

        return list;
    }

    public static Panti getItemData(int id){

        String[] arr = Arrays.asList(data).get(id);

        Panti panti = new Panti();
        panti.setId_panti(arr[0]);
        panti.setNama(arr[1]);
        panti.setAlamat(arr[2]);
        panti.setProduk(arr[3]);
        panti.setFoto(arr[4]);

        return panti;
    };
}
