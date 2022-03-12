package com.doubleclick.marktinhome.Repository;

import static com.doubleclick.marktinhome.BaseApplication.context;
import static com.doubleclick.marktinhome.BaseApplication.isNetworkConnected;
import static com.doubleclick.marktinhome.Model.Constantes.RECENTSEARCH;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.doubleclick.RecentSearchInterface;
import com.doubleclick.marktinhome.Model.RecentSearch;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created By Eslam Ghazy on 3/11/2022
 */
public class RecentSearchRepository extends BaseRepository {

    private RecentSearchInterface recentSearchInterface;
    private String[] wordsSearch = new String[]{};
    private String[] wordsSearchList = new String[]{};
    private List<String> LastSearchList = new ArrayList<>();


    public RecentSearchRepository(RecentSearchInterface recentSearchInterface) {
        this.recentSearchInterface = recentSearchInterface;
    }

    // run only one tome
    public void getLastSearchOneTime() {
        reference.child(RECENTSEARCH).child(myId).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                try {
                    if (isNetworkConnected() && task.getResult().exists()) {
                        DataSnapshot snapshot = task.getResult();
                        RecentSearch recentSearch = snapshot.getValue(RecentSearch.class);
                        LastSearchList.add(recentSearch.getRecentSearch());
                        wordsSearchList = recentSearch.getRecentSearch().split(",");
                        LastSearchList = Arrays.asList(wordsSearchList);
                        recentSearchInterface.getLastListSearchOneTime(LastSearchList);
                    }
                } catch (Exception e) {

                }
            }
        });

    }

    // at the same time
    public void getRecentSearch() {
        reference.child(RECENTSEARCH).child(myId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                try {
                    if (isNetworkConnected() && snapshot.exists()) {
                        RecentSearch recentSearch = snapshot.getValue(RecentSearch.class);
                        recentSearchInterface.getRecentSearch(recentSearch);
                    }
                } catch (Exception e) {

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

}
