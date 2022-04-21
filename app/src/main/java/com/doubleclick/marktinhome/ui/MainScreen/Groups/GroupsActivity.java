package com.doubleclick.marktinhome.ui.MainScreen.Groups;

import android.os.Bundle;

import com.doubleclick.marktinhome.Adapters.GroupsAdapter;
import com.doubleclick.marktinhome.R;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class GroupsActivity extends AppCompatActivity {


    private RecyclerView post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groups);
        post = findViewById(R.id.post);
        post.setAdapter(new GroupsAdapter());
    }
}