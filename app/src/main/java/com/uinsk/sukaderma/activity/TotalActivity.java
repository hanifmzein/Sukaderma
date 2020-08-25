package com.uinsk.sukaderma.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.uinsk.sukaderma.R;
import com.uinsk.sukaderma.data.ProduksData;
import com.uinsk.sukaderma.model.Produk;
import com.uinsk.sukaderma.model.Transaksi;

public class TotalActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "pilih produk";
    EditText edtJumlah;
    TextView tvTotal, tvNamaProduk, tvHargaProduk;
    Transaksi transaksi;
    Button btnCheckout;
    ImageView imgFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total);

        edtJumlah = findViewById(R.id.edt_jumlah);
        btnCheckout = findViewById(R.id.btn_checkout);
        tvNamaProduk = findViewById(R.id.tv_nama);
        tvHargaProduk = findViewById(R.id.tv_harga);
        imgFoto = findViewById(R.id.img_foto);

        transaksi = getIntent().getParcelableExtra(EXTRA_NAME);

        Produk produk = ProduksData.getItemData(transaksi.getProduk());

        final int harga = produk.getHarga();

        tvNamaProduk.setText(produk.getNama());
        tvHargaProduk.setText(Integer.toString(produk.getHarga()));

        Glide.with(this)
                .load(getResources()
                        .getIdentifier(produk.getFoto(), "drawable", this
                                .getPackageName())).into(imgFoto);


        edtJumlah.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String inputText = edtJumlah.getText().toString();
                tvTotal = findViewById(R.id.tv_total);

                String hitung = Integer.toString(Integer.parseInt(inputText)*harga);
                tvTotal.setText(hitung);
            }
        });

        btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int jumlah = Integer.parseInt(edtJumlah.getText().toString());
                int total = Integer.parseInt(tvTotal.getText().toString());

                transaksi.setJumlah(jumlah);
                transaksi.setTotal_harga(total);

                Bundle bundle = new Bundle();
                bundle.putParcelable(DetailActivity.EXTRA_NAME, transaksi);

                Intent intent = new Intent(TotalActivity.this, DetailActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}