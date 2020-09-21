package com.example.phototest;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class GridLayoutActivity extends AppCompatActivity implements ListView.OnItemSelectedListener, View.OnClickListener {

    @BindView(R.id.grid_gridView)
    GridView grid_view;

    @BindView(R.id.item_count_edittxt)
    EditText count_editTxt;

    @BindView(R.id.show_list_btn)
    Button showList_btn;

    int[] itemResourceArray;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridlayout);
        ButterKnife.bind(this);

        showList_btn.setOnClickListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.show_list_btn:
                showList();
                break;
        }
    }

    void showList() {
        int itemCount = Integer.valueOf(count_editTxt.getText().toString());

        itemResourceArray = new int[itemCount];

        for (int i = 0; i < itemCount; ++i) {
            int itemIdx = i % 4;
            itemResourceArray[i] = (getResources().getIdentifier((String.format("photo_%d", itemIdx)), "drawable", getPackageName()));
        }
        GridLayoutAdapter layoutAdapter = new GridLayoutAdapter(getApplicationContext(), itemResourceArray);
        grid_view.setAdapter(layoutAdapter);
    }
}
