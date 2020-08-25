package com.uinsk.sukaderma.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.uinsk.sukaderma.R;
import com.uinsk.sukaderma.model.Transaksi;
import com.uinsk.sukaderma.adapter.TransaksiListAdapter;
import com.uinsk.sukaderma.data.TransaksisData;

import java.util.ArrayList;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private ArrayList<Transaksi> list = new ArrayList<>();
    private RecyclerView rvTransaksi;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);

        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
//        final TextView textView = root.findViewById(R.id.text_dashboard);
//
//        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

        list.addAll(TransaksisData.getListData());

        rvTransaksi = root.findViewById(R.id.rv_transaksi);
        rvTransaksi.setHasFixedSize(true);

        rvTransaksi.setLayoutManager(new LinearLayoutManager(getContext()));
        TransaksiListAdapter transaksiListAdapter = new TransaksiListAdapter(list);
        rvTransaksi.setAdapter(transaksiListAdapter);


        return root;
    }
}