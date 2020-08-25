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
import com.uinsk.sukaderma.model.Panti;
import com.uinsk.sukaderma.model.Transaksi;

import java.util.ArrayList;

public class PantiListAdapter extends RecyclerView.Adapter<PantiListAdapter.ListViewHolder> {
    private ArrayList<Panti> listPanti;
    private Transaksi transaksi;
    private String jenis;

    public PantiListAdapter(ArrayList<Panti> list, String jenis) {
        this.listPanti = list;
        this.jenis = jenis;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_panti, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, final int position) {
        final Panti panti = listPanti.get(position);
        transaksi = new Transaksi();

        holder.tvNama.setText(panti.getNama());
        holder.tvAlamat.setText(panti.getAlamat());
        holder.tvProduk.setText(panti.getProduk());

        Glide.with(holder.itemView.getContext())
                .load(holder.itemView.getContext().getResources()
                        .getIdentifier(panti.getFoto(), "drawable", holder.itemView.getContext()
                                .getPackageName())).into(holder.imgFoto);

        System.out.println("ADAPTER POSITION : "+position);

        holder.cvPanti.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {


                transaksi.setJenis(jenis);
                transaksi.setId_panti(position);

                Bundle bundle = new Bundle();
                bundle.putParcelable(ProdukActivity.EXTRA_NAME, transaksi);

                Intent intent = new Intent(holder.itemView.getContext(), ProdukActivity.class);
                intent.putExtras(bundle);
                holder.itemView.getContext().startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        return listPanti.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {

        TextView tvNama, tvAlamat, tvProduk;
        ImageView imgFoto;
        CardView cvPanti;

        ListViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNama = itemView.findViewById(R.id.tv_nama);
            tvAlamat = itemView.findViewById(R.id.tv_alamat);
            tvProduk = itemView.findViewById(R.id.tv_produk);
            imgFoto = itemView.findViewById(R.id.img_foto);
            cvPanti = itemView.findViewById(R.id.cv_panti);
        }
    }
}
