package com.doubleclick.marktinhome.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.doubleclick.ViewHolder.ChatViewHolder;
import com.doubleclick.marktinhome.Model.Chat;
import com.doubleclick.marktinhome.R;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created By Eslam Ghazy on 3/17/2022
 */
public class ChatAdapter extends RecyclerView.Adapter<ChatViewHolder> {

    private ArrayList<Chat> chatArrayList = new ArrayList<>();
    private final int LEFT = 0;
    private final int RIGHT = 1;

    public ChatAdapter(ArrayList<Chat> chatArrayList) {
        this.chatArrayList = chatArrayList;
    }

    @NonNull
    @Override
    public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == LEFT) {
            return new ChatViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.left_chat, parent, false));
        } else if (viewType == RIGHT) {
            return new ChatViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.right_chat, parent, false));
        } else {
            return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ChatViewHolder holder, int position) {
        holder.textMessage.setText(chatArrayList.get(position).getMessage());
    }

    @Override
    public int getItemViewType(int position) {
        if (chatArrayList.get(position).getSender().equals(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid().toString())) {
            return LEFT;
        } else {
            return RIGHT;
        }
    }

    @Override
    public int getItemCount() {
        return chatArrayList.size();
    }
}
