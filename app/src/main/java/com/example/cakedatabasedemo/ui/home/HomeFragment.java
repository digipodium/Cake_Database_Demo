package com.example.cakedatabasedemo.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cakedatabasedemo.Cake;
import com.example.cakedatabasedemo.CakeViewModel;
import com.example.cakedatabasedemo.R;

import java.util.List;

public class HomeFragment extends Fragment {

    private CakeViewModel cakeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        cakeViewModel = new ViewModelProvider(this).get(CakeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView rvCakes = view.findViewById(R.id.rvCakes);
        CakeListAdapter adapter = new CakeListAdapter(getActivity(), R.layout.row_cake);
        rvCakes.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvCakes.setAdapter(adapter);

        //observer
        cakeViewModel.getAllCakes().observe(getViewLifecycleOwner(), new Observer<List<Cake>>() {
            @Override
            public void onChanged(List<Cake> cakes) {
                adapter.setCakes(cakes);
            }
        });
    }
}