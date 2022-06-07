package com.nfs.foodmyproject.ui.home;

import android.widget.ListView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<ListView> mListView;

    public HomeViewModel() {
        mListView = new MutableLiveData<>();
    }

    public LiveData<ListView> getListView() {
        return mListView;
    }
}