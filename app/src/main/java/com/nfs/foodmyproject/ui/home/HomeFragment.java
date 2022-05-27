package com.nfs.foodmyproject.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.nfs.foodmyproject.R;
import com.nfs.foodmyproject.beans.Box;
import com.nfs.foodmyproject.beans.adapter.BoxListAdapter;
import com.nfs.foodmyproject.databinding.FragmentHomeBinding;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        List<Box> boxes = getBoxes();
        ListView listView = (ListView) inflater.inflate(R.layout.fragment_home, container, false);
        listView.setAdapter(new BoxListAdapter(getContext(), boxes));

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public List<Box> getBoxes() {
        List<Box> boxes = new ArrayList<Box>();
        boxes.add(new Box("titre 1", "description 1", "image 1",85, LocalDate.now()));
        boxes.add(new Box("titre 2", "description 2", "image 2",40, LocalDate.now()));
        boxes.add(new Box("titre 3", "description 3", "image 3",20, LocalDate.now()));
        return boxes;
    }
}