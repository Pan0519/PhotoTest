package com.example.phototest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ChatRoomActivity extends AppCompatActivity {
    @BindView(R.id.send_btn)
    Button SendBtn;

    @BindView(R.id.chat_listView)
    ListView ChatListView;

    @BindView(R.id.chat_editTxt)
    EditText chatEditTxt;

    ChatListAdapter listAdapter;

    List<ChatMessage> chatList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        ButterKnife.bind(this);
        chatList = new ArrayList<>();
        chatList.add(new ChatMessage("Test", ChatMessage.ChatType.SELF));
        listAdapter = new ChatListAdapter(getApplicationContext(), chatList);
        ChatListView.setAdapter(listAdapter);
    }

    public void SendMsg(View v) {
        if (chatEditTxt.getText().toString().isEmpty()) {
            return;
        }
        Toast.makeText(ChatRoomActivity.this, chatEditTxt.getText().toString(), Toast.LENGTH_SHORT).show();
        chatList.add(new ChatMessage(chatEditTxt.getText().toString(), ChatMessage.ChatType.SELF));
        chatList.add(new ChatMessage(chatEditTxt.getText().toString(), ChatMessage.ChatType.OTHER));
        listAdapter.notifyDataSetChanged();
    }
}
