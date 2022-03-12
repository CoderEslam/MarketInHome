package com.doubleclick.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.doubleclick.UserInter;
import com.doubleclick.marktinhome.Model.User;
import com.doubleclick.marktinhome.Repository.UserRepository;

/**
 * Created By Eslam Ghazy on 3/1/2022
 */
public class UserViewModel extends ViewModel implements UserInter {

    MutableLiveData<User> mutableLiveData = new MutableLiveData<>();

    UserRepository userRepository = new UserRepository(this);

    public UserViewModel() {
        userRepository.getUser();
    }

    public LiveData<User> getUser(){
        return mutableLiveData;
    }

    @Override
    public void ItemUser(User user) {
        mutableLiveData.setValue(user);
    }
}
