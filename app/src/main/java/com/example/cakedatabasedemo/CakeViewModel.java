package com.example.cakedatabasedemo;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class CakeViewModel extends AndroidViewModel {

    private final LiveData<List<Cake>> allCakes;
    private CakeRepository cakeRepository;

    //constructor

    public CakeViewModel(Application application) {
        super(application);
        cakeRepository = new CakeRepository(application);
        allCakes = cakeRepository.getAllCakes();
    }


    //getter

    public LiveData<List<Cake>> getAllCakes() {
        return allCakes;
    }

    public void insert(Cake cake){
        cakeRepository.insert(cake);
    }


    //insert
}
