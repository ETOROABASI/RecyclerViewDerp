package com.example.android.recyclerviewderp.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.android.recyclerviewderp.R;

import com.example.android.recyclerviewderp.R;
import com.example.android.recyclerviewderp.adapter.DerpAdapter;
import com.example.android.recyclerviewderp.model.DerpData;
import com.example.android.recyclerviewderp.model.ListItem;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity implements DerpAdapter.ItemClickCallBack{  //implement is for the interface we
    //created in our DerpAdapter class

    private static final String BUNDLE_EXTRA = "BUNDLE_EXTRA";
    private static final String EXTRA_QUOTE = "EXTRA_QUOTE";        // I used the string directly instead
    private static final String EXTRA_ATTR = "EXTRA_ATTR";

    private RecyclerView recyclerView;
    private DerpAdapter adapter;
    private ArrayList listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listData = (ArrayList) DerpData.getListData();

        recyclerView = (RecyclerView) findViewById(R.id.rec_list);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));  //we could have also used
        //GridLayoutManager or StaggeredGridLayoutManager depending in what we needed to achieve

        adapter = new DerpAdapter(DerpData.getListData(), this); //this gets the 12 items and passes it into the constructor
        //of the adapter ie DerpAdapter

        recyclerView.setAdapter(adapter);
        adapter.setItemClickCallBack(this);
    }

    @Override
    public void onItemClick(int p) {
        ListItem item = (ListItem) listData.get(p);

        Intent intent = new Intent(this, DetailActivity.class);

        Bundle extras = new Bundle();

        extras.putString("EXTRA_QUOTE", item.getTitle());
        extras.putString(EXTRA_ATTR, item.getSubTitle());

        intent.putExtra(BUNDLE_EXTRA, extras);
        startActivity(intent);


    }

    @Override
    public void onFavouriteClicked(int p) {
        ListItem item = (ListItem) listData.get(p);

        //this alternates the state of the image when clicked
        if (item.isFavourite()){
            item.setFavourite(false);
        }

        else{
            item.setFavourite(true);
        }

        //pass new data to adapter and update
        adapter.setListData(listData);
        adapter.notifyDataSetChanged();  //not used in all cases esp when data is from web or db

    }
}
