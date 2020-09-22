package com.example.phototest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChatListAdapter extends BaseAdapter {

    private final Context context;
    List<ChatMessage> msgList;
    LayoutInflater inflater;

    public ChatListAdapter(Context context, List<ChatMessage> resources) {
        this.context = context;
        this.msgList = resources;
        inflater = (LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        return msgList.size();
    }

    @Override
    public Object getItem(int i) {
        return msgList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.item_chat, null);

        TextView leftText = view.findViewById(R.id.left_content_txt);
        TextView rightText = view.findViewById(R.id.right_content_txt);

        ChatMessage msg = msgList.get(i);

        leftText.setVisibility(msg.getMsgType() == ChatMessage.ChatType.OTHER ? View.VISIBLE : View.GONE);
        rightText.setVisibility(msg.getMsgType() == ChatMessage.ChatType.SELF ? View.VISIBLE : View.GONE);

        switch (msg.getMsgType()) {
            case SELF:
                rightText.setText(msg.getMsgContent());
                break;

            case OTHER:
                leftText.setText(msg.getMsgContent());
                break;
        }

        return view;
    }
}
