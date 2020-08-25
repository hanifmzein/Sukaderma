package com.uinsk.sukaderma.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.uinsk.sukaderma.R;
import com.uinsk.sukaderma.adapter.PantiListAdapter;
import com.uinsk.sukaderma.adapter.ProdukListAdapter;
import com.uinsk.sukaderma.data.PantisData;
import com.uinsk.sukaderma.data.ProduksData;
import com.uinsk.sukaderma.model.Panti;
import com.uinsk.sukaderma.model.Produk;
import com.uinsk.sukaderma.model.Transaksi;

import java.util.ArrayList;

public class ProdukActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "PILH PANTI";

    RecyclerView rvProduk;

    ArrayList<Produk> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produk);

        Transaksi transaksi = getIntent().getParcelableExtra(EXTRA_NAME);

        System.out.println("JENIS : "+transaksi.getJenis());
        System.out.println("PANTI : "+transaksi.getId_panti());

        list.addAll(ProduksData.getListData());

        rvProduk = findViewById(R.id.rv_produk);
        rvProduk.setHasFixedSize(true);

        rvProduk.setLayoutManager(new GridLayoutManager(this, 2));
        ProdukListAdapter produkListAdapter = new ProdukListAdapter(list, transaksi);
        rvProduk.setAdapter(produkListAdapter);
    }
}