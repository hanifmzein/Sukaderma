package com.uinsk.sukaderma.adapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.uinsk.sukaderma.R;
import com.uinsk.sukaderma.activity.ProdukActivity;
import com.uinsk.sukaderma.activity.TotalActivity;
import com.uinsk.sukaderma.model.Produk;
import com.uinsk.sukaderma.model.Transaksi;

import java.util.ArrayList;

public class ProdukListAdapter extends RecyclerView.Adapter<ProdukListAdapter.ListViewHolder> {
    private ArrayList<Produk> listProduk;
    private Transaksi transaksi;

    public ProdukListAdapter(ArrayList<Produk> list, Transaksi transaksi) {
        this.listProduk = list;
        this.transaksi = transaksi;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_produk, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        final Produk Produk = listProduk.get(position);

        holder.tvNama.setText(Produk.getNama());
        holder.tvHarga.setText(Integer.toString(Produk.getHarga()));

        Glide.with(holder.itemView.getContext())
                .load(holder.itemView.getContext().getResources()
                        .getIdentifier(Produk.getFoto(), "drawable", holder.itemView.getContext()
                                .getPackageName())).into(holder.imgFoto);



        holder.cvProduk.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {


                transaksi.setProduk(Produk.getNama());

                Bundle bundle = new Bundle();
                bundle.putParcelable(TotalActivity.EXTRA_NAME, transaksi);

                Intent intent = new Intent(holder.itemView.getContext(), TotalActivity.class);
                intent.putExtras(bundle);
                holder.itemView.getContext().startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        return listProduk.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {

        TextView tvNama, tvHarga;
        ImageView imgFoto;
        CardView cvProduk;

        ListViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNama = itemView.findViewById(R.id.tv_nama);
            tvHarga = itemView.findViewById(R.id.tv_harga);
            imgFoto = itemView.findViewById(R.id.img_foto);
            cvProduk = itemView.findViewById(R.id.cv_produk);
        }
    }
}
