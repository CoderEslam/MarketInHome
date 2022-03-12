package com.doubleclick.ViewModel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.doubleclick.RecentSearchInterface;
import com.doubleclick.marktinhome.Model.RecentSearch;
import com.doubleclick.marktinhome.Repository.RecentSearchRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By Eslam Ghazy on 3/11/2022
 */
public class RecentSearchViewModel extends ViewModel implements RecentSearchInterface {

    MutableLiveData<List<String>> recentSearchMutableLiveDataOneTime = new MutableLiveData<>();
    MutableLiveData<RecentSearch> recentSearch = new MutableLiveData<>();
    RecentSearchRepository recentSearchRepository = new RecentSearchRepository(this);

    public RecentSearchViewModel() {
        recentSearchRepository.getLastSearchOneTime();
        recentSearchRepository.getRecentSearch();
    }

    public LiveData<List<String>> getLastSearchListLiveDataOneTime() {
        return recentSearchMutableLiveDataOneTime;
    }

    public LiveData<RecentSearch> getRecentSearchLiveData() {
        return recentSearch;
    }


    @Override
    public void getRecentSearch(@NonNull RecentSearch recent) {
        recentSearch.setValue(recent);
    }


    @Override
    public void getLastListSearchOneTime(@Nullable List<String> recentSearchOneTime) {
        recentSearchMutableLiveDataOneTime.setValue(recentSearchOneTime);

    }
}
