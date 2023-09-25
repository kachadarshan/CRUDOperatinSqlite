package com.yourbrandname.demosqlite_recyc.Activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;

import com.yourbrandname.demosqlite_recyc.Adapter.DataAdapter;
import com.yourbrandname.demosqlite_recyc.Database.MyDbhelper;
import com.yourbrandname.demosqlite_recyc.Model.Datamodel;
import com.yourbrandname.demosqlite_recyc.R;

import java.util.ArrayList;

public class ViewActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    DataAdapter adapter;

    ArrayList<Datamodel> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        recyclerView = findViewById(R.id.recyclerview);
        MyDbhelper dbhelper = new MyDbhelper(this);
        arrayList = new ArrayList<>();

        arrayList = dbhelper.getDatas();
        Log.d("SIZE", "sieze" + arrayList.size());
        adapter = new DataAdapter(ViewActivity.this, arrayList, ViewActivity.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 100) {
            recreate();
        }
    }
}