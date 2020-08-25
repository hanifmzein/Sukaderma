package com.uinsk.sukaderma.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.uinsk.sukaderma.R;
import com.uinsk.sukaderma.data.PantisData;
import com.uinsk.sukaderma.model.Panti;
import com.uinsk.sukaderma.model.Transaksi;

import java.util.ArrayList;

public class TransaksiListAdapter extends RecyclerView.Adapter<TransaksiListAdapter.ListViewHolder> {
    private ArrayList<Transaksi> listTransaksi;

    public TransaksiListAdapter(ArrayList<Transaksi> list) {
        this.listTransaksi = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_transaksi, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        final Transaksi transaksi = listTransaksi.get(position);

        Panti panti = PantisData.getItemData(position); // get Object Panti

        holder.tvJenis.setText(transaksi.getJenis());
        holder.tvProduk.setText(transaksi.getProduk());
        holder.tvHarga.setText(Integer.toString(transaksi.getTotal_harga()));
        holder.tvPanti.setText(panti.getNama());
        holder.tvStatus.setText(transaksi.getStatus());

//        holder.cvMovie.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View view) {
//
//                Bundle bundle = new Bundle();
//                bundle.putParcelable(MovieDetailActivity.EXTRA_NAME, movie);
//
//                Intent intent = new Intent(holder.itemView.getContext(), MovieDetailActivity.class);
//                intent.putExtras(bundle);
//                holder.itemView.getContext().startActivity(intent);
//
//
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return listTransaksi.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {

        TextView tvJenis, tvProduk, tvHarga, tvPanti, tvStatus;

        ListViewHolder(@NonNull View itemView) {
            super(itemView);

            tvJenis = itemView.findViewById(R.id.tv_jenis);
            tvProduk = itemView.findViewById(R.id.tv_produk);
            tvHarga = itemView.findViewById(R.id.tv_harga);
            tvPanti = itemView.findViewById(R.id.tv_panti);
            tvStatus = itemView.findViewById(R.id.tv_status);
        }
    }
}
