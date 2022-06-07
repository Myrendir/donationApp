package com.nfs.foodmyproject.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.nfs.foodmyproject.DAO.DaoFactory;
import com.nfs.foodmyproject.R;
import com.nfs.foodmyproject.beans.Box;
import com.nfs.foodmyproject.beans.ProjetToBoxAdapter;
import com.nfs.foodmyproject.beans.adapter.BoxListAdapter;
import com.nfs.foodmyproject.databinding.FragmentHomeBinding;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    private BoxListAdapter bla;
    private ArrayList<Box> boxList;
    private ListView listView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        listView = binding.listView;
        homeViewModel.getListView().observe(getViewLifecycleOwner(), listView::addView);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            //get Item at position
            Box box = (Box) listView.getItemAtPosition(position);
            Bundle bundle = new Bundle();
            bundle.putString("titre", box.getTitle());
            bundle.putString("description", box.getDescription());
            bundle.putString("image", box.getImage());
            bundle.putInt("prix", box.getPercentage());
            Navigation.findNavController(view).navigate(R.id.navigation_dashboard, bundle);
        });

        boxList = getBoxes();
        bla = new BoxListAdapter(getContext(), boxList);
        listView.setAdapter(bla);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public ArrayList<Box> getBoxes() {
        ProjetToBoxAdapter pba = new ProjetToBoxAdapter();
        return (ArrayList<Box>) pba.ConvertProjetToBox(DaoFactory.getProjetDao(this.getContext()).getAll());
    }
}