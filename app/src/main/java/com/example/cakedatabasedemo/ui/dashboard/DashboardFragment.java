package com.example.cakedatabasedemo.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.cakedatabasedemo.Cake;
import com.example.cakedatabasedemo.CakeViewModel;
import com.example.cakedatabasedemo.R;

public class DashboardFragment extends Fragment {


    private CakeViewModel cakeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        cakeViewModel = new ViewModelProvider(this).get(CakeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EditText editCake = view.findViewById(R.id.editCakeName);
        Button btnAdd = view.findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(v -> {
            String cakeName = editCake.getText().toString();
            if (cakeName.length() > 2) {
                Cake cake = new Cake(cakeName);
                cakeViewModel.insert(cake);
            } else {
                editCake.setError("Please fill a valid cake name");
                editCake.setFocusable(true);
            }
        });
    }
}