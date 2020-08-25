package com.uinsk.sukaderma.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.uinsk.sukaderma.R;
import com.uinsk.sukaderma.data.PantisData;
import com.uinsk.sukaderma.data.ProduksData;
import com.uinsk.sukaderma.data.TransaksisData;
import com.uinsk.sukaderma.model.Panti;
import com.uinsk.sukaderma.model.Produk;
import com.uinsk.sukaderma.model.Transaksi;

import java.util.Random;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "pilih total";

    TextView tvNamaProduk, tvHargaProduk, tvNamaPanti, tvAlamatPanti, tvTotalHarga, tvHargaTransfer;
    Button btnBukti, btnKonfirmasi;
    ImageView imgProduk, imgPanti;

    Transaksi transaksi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvNamaProduk = findViewById(R.id.tv_nama_produk);
        tvHargaProduk = findViewById(R.id.tv_harga_produk);
        tvNamaPanti = findViewById(R.id.tv_nama_panti);
        tvAlamatPanti = findViewById(R.id.tv_alamat_panti);
        tvTotalHarga = findViewById(R.id.tv_total_harga);
        tvHargaTransfer = findViewById(R.id.tv_harga_transfer);

        imgProduk = findViewById(R.id.img_produk);
        imgPanti = findViewById(R.id.img_panti);

        btnBukti = findViewById(R.id.btn_bukti);
        btnKonfirmasi = findViewById(R.id.btn_konfirmasi);

        transaksi = getIntent().getParcelableExtra(EXTRA_NAME);

        System.out.println("PRODUK : "+transaksi);

        Produk produk = ProduksData.getItemData(transaksi.getProduk());
        Panti panti = PantisData.getItemData(transaksi.getId_panti());

        String hargaProduk = Integer.toString(produk.getHarga());
        Random random = new Random();
        String hargaTransfer = Integer.toString(transaksi.getTotal_harga()+random.nextInt(999));

        tvNamaProduk.setText(transaksi.getProduk());
        tvHargaProduk.setText(hargaProduk);
        tvNamaPanti.setText(panti.getNama());
        tvAlamatPanti.setText(panti.getAlamat());
        tvTotalHarga.setText(Integer.toString(transaksi.getTotal_harga()));
        tvHargaTransfer.setText(hargaTransfer);

        Glide.with(this)
                .load(getResources()
                        .getIdentifier(produk.getFoto(), "drawable", this
                                .getPackageName())).into(imgProduk);

        Glide.with(this)
                .load(getResources()
                        .getIdentifier(panti.getFoto(), "drawable", this
                                .getPackageName())).into(imgPanti);

        btnKonfirmasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TransaksisData.addListData(transaksi);

                Intent intent = new Intent(DetailActivity.this, DetailActivity.class);
                startActivity(intent);
            }
        });

    }
}