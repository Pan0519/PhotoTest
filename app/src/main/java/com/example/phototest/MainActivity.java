package com.example.phototest;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.takephoto_btn)
    Button ToTakePhotoBtn;

    @BindView(R.id.gridview_btn)
    Button GridLayoutBtn;

    @BindView(R.id.chat_btn)
    Button ChatBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ToTakePhotoBtn.setOnClickListener(this);
        GridLayoutBtn.setOnClickListener(this);
        ChatBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent intent = null;

        switch (view.getId()) {
            case R.id.takephoto_btn:
                intent = new Intent(MainActivity.this, TakePhotoActivity.class);
                break;

            case R.id.gridview_btn:
                intent = new Intent(MainActivity.this, GridLayoutActivity.class);
                break;

            case R.id.chat_btn:
                intent = new Intent(MainActivity.this, ChatRoomActivity.class);
                break;
        }

        if (intent == null) {
            return;
        }

        startActivity(intent);
    }
}
