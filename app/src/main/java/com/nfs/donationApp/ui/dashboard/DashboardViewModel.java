package com.nfs.donationApp.ui.dashboard;

import android.widget.ImageView;
import android.widget.ListView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DashboardViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    private final MutableLiveData<String> description;

    private final MutableLiveData<ImageView> image;

    private final MutableLiveData<ListView> mListView;

    public DashboardViewModel() {
        mListView = new MutableLiveData<>();
        mText = new MutableLiveData<>();
        description = new MutableLiveData<>();
        image = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public LiveData<ListView> getListView() {
        return mListView;
    }

    public MutableLiveData<String> getDescription() {
        return description;
    }

    public MutableLiveData<ImageView> getImage() {
        return image;
    }
}