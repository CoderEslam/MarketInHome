package com.doubleclick.marktinhome.Repository;

import static com.doubleclick.marktinhome.BaseApplication.isNetworkConnected;
import static com.doubleclick.marktinhome.Model.Constantes.TRADEMARK;

import android.util.Log;

import androidx.annotation.NonNull;

import com.doubleclick.Tradmarkinterface;
import com.doubleclick.marktinhome.Model.Trademark;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By Eslam Ghazy on 3/8/2022
 */
public class TradmarkRepository extends BaseRepository {

    ArrayList<Trademark> tradmarks = new ArrayList<>();
    List<String> names = new ArrayList<>();
    Tradmarkinterface tradmarkinterface;

    public TradmarkRepository(Tradmarkinterface tradmarkinterface) {
        this.tradmarkinterface = tradmarkinterface;
    }

    public void getTradmark() {
        reference.child(TRADEMARK).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                try {
                    if (isNetworkConnected() && task.getResult().exists()) {
                        DataSnapshot snapshot = task.getResult();
                        for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                            Trademark tradmark = dataSnapshot.getValue(Trademark.class);
                            tradmarks.add(tradmark);
                        }
                        tradmarkinterface.AllTradmark(tradmarks);
                    }
                } catch (Exception e) {
                    ShowToast("No Internet Connection");
                    Log.e("Exception", e.getMessage());
                }

            }
        });

    }

    public void getNameTradmark() {
        reference.child(TRADEMARK).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                try {
                    if (isNetworkConnected() && task.getResult().exists()) {
                        DataSnapshot snapshot = task.getResult();
                        for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                            Trademark tradmark = dataSnapshot.getValue(Trademark.class);
                            assert tradmark != null;
                            names.add(tradmark.getName());
                        }
                        tradmarkinterface.AllNameTradmark(names);
                    }

                } catch (Exception e) {
                    ShowToast("No Internet Connection");
                    Log.e("Exception", e.getMessage());
                }
            }
        });

    }

}
