package com.uinsk.sukaderma.data;

import com.uinsk.sukaderma.model.Transaksi;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class TransaksisData {
    public static String[][] data = new String[][]{
            {"Zakat", "Jagung", "1", "100", "400000", "Ditanam"},
            {"Infaq", "Beras", "2", "50", "500000", "Dipanen"},
            {"Zakat", "Kentang", "3", "200", "2400000", "Disalurkan"}
    };

    public static ArrayList<Transaksi> getListData(){
        ArrayList<Transaksi> list = new ArrayList<>();
        for (String[] aData : data){

            Transaksi transaksi = new Transaksi();
            transaksi.setJenis(aData[0]);
            transaksi.setProduk(aData[1]);
            transaksi.setId_panti(Integer.parseInt(aData[2]));;
            transaksi.setJumlah(Integer.parseInt(aData[3]));
            transaksi.setTotal_harga(Integer.parseInt(aData[4]));
            transaksi.setStatus(aData[5]);

            list.add(transaksi);
        }

        return list;
    }

    public static String[][] addX(String[] x)
    {
        int i;

        int n = data.length;

        // create a new array of size n+1
        String[][] newarr = new String[n + 1][];

        // insert the elements from
        // the old array into the new array
        // insert all elements till n
        // then insert x at n+1
        for (i = 0; i < data.length; i++)
            newarr[i] = data[i];

        newarr[n] = x;

        return newarr;
    }

    public static void addListData(Transaksi transaksi){
        String[] dataNewTransaksi = new String[]{
                transaksi.getJenis(),
                transaksi.getProduk(),
                Integer.toString(transaksi.getId_panti()),
                Integer.toString(transaksi.getJumlah()),
                Integer.toString(transaksi.getTotal_harga()),
                transaksi.getStatus()
        };

        data = addX(dataNewTransaksi);
    }
}
