package com.doubleclick.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.doubleclick.marktinhome.Model.Chat;
import com.doubleclick.marktinhome.Repository.ChatReopsitory;

import java.util.ArrayList;

/**
 * Created By Eslam Ghazy on 3/17/2022
 */
public class ChatViewModel extends ViewModel implements ChatReopsitory.Chats {

    MutableLiveData<ArrayList<Chat>> mutableLiveData = new MutableLiveData<>();

    ChatReopsitory chatReopsitory = new ChatReopsitory(this);

    public ChatViewModel() {
        chatReopsitory.getChats();
    }

    public LiveData<ArrayList<Chat>> getMyChat() {
        return mutableLiveData;
    }


    @Override
    public void getChat(ArrayList<Chat> chats) {
        mutableLiveData.setValue(chats);
    }
}
