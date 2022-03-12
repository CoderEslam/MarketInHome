package com.doubleclick.ViewModel;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.doubleclick.Tradmarkinterface;
import com.doubleclick.marktinhome.Model.Trademark;
import com.doubleclick.marktinhome.Repository.TradmarkRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By Eslam Ghazy on 3/8/2022
 */
public class TradmarkViewModel extends ViewModel implements Tradmarkinterface {


    private MutableLiveData<ArrayList<Trademark>> mutableLiveData = new MutableLiveData<>();
    private MutableLiveData<List<String>> mutableLiveDataNames = new MutableLiveData<>();
    TradmarkRepository tradmarkRepository = new TradmarkRepository(this);

    public TradmarkViewModel() {
        tradmarkRepository.getTradmark();
        tradmarkRepository.getNameTradmark();
    }

    public LiveData<ArrayList<Trademark>> getAllMark() {
        return mutableLiveData;
    }

    public LiveData<List<String>> getNamesMark() {
        return mutableLiveDataNames;
    }


    @Override
    public void AllTradmark(@Nullable ArrayList<Trademark> tradmark) {
        mutableLiveData.setValue(tradmark);
    }

    @Override
    public void AllNameTradmark(@Nullable List<String> names) {
        mutableLiveDataNames.setValue(names);
    }

    @Override
    public void OnItemTradmark(@Nullable Trademark tradmark) {

    }
}
