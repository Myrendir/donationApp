package com.nfs.donationApp.ui.dashboard;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.nfs.donationApp.R;
import com.nfs.donationApp.beans.Palier;
import com.nfs.donationApp.beans.adapter.PalierListAdapter;
import com.nfs.donationApp.databinding.FragmentDashboardBinding;
import com.squareup.picasso.Picasso;

import java.time.LocalDate;
import java.util.ArrayList;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;

    private PalierListAdapter pla;
    private ArrayList<Palier> palierList;
    private ListView listView;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textDashboard;
        //logd argument titre
        Log.d("titre", "onCreateView: " + getArguments().getString("titre"));
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), s -> textView.setText(getArguments().getString("titre")));
        dashboardViewModel.getDescription().observe(getViewLifecycleOwner(), s -> textView.setText(getArguments().getString("titre")));
        ImageView imageView = (ImageView) binding.imagetest;

        Picasso.get().load(getArguments().getString("image")).into(binding.imagetest);

        palierList = getPalier();
        listView = binding.listView;
        dashboardViewModel.getListView().observe(getViewLifecycleOwner(),listView::addView);
        pla = new PalierListAdapter(getContext(), palierList);
        listView.setAdapter(pla);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public ArrayList<Palier> getPalier() {
        ArrayList<Palier> paliers = new ArrayList<>();
        paliers.add(new Palier("Palier 1","ouais", 5, LocalDate.now()));
        paliers.add(new Palier("Palier 2","ouais", 10, LocalDate.now()));
        paliers.add(new Palier("Palier 3","ouais", 7, LocalDate.now()));
        paliers.add(new Palier("Palier 3","ouais", 7, LocalDate.now()));
        paliers.add(new Palier("Palier 3","ouais", 7, LocalDate.now()));
        paliers.add(new Palier("Palier 3","ouais", 7, LocalDate.now()));
        return paliers;
    }
}