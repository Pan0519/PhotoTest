package com.example.phototest;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;

public class ChatRoomActivity extends AppCompatActivity {
    @BindView(R.id.send_btn)
    Button SendBtn;

    @BindView(R.id.chat_listView)
    ListView ChatListView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
    }
}
