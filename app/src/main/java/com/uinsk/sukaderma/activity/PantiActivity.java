package com.uinsk.sukaderma.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.uinsk.sukaderma.model.Panti;
import com.uinsk.sukaderma.adapter.PantiListAdapter;
import com.uinsk.sukaderma.data.PantisData;
import com.uinsk.sukaderma.R;

import java.util.ArrayList;

public class PantiActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "pilih jenis";

    RecyclerView rvPanti;

    ArrayList<Panti> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panti);

        String jenis = getIntent().getStringExtra(EXTRA_NAME);

//        System.out.println("JENIS : "+jenis);

        list.addAll(PantisData.getListData());

        rvPanti = findViewById(R.id.rv_panti);
        rvPanti.setHasFixedSize(true);

        rvPanti.setLayoutManager(new LinearLayoutManager(this));
        PantiListAdapter pantiListAdapter = new PantiListAdapter(list, jenis);
        rvPanti.setAdapter(pantiListAdapter);
    }
}