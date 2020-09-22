package com.example.phototest;

public class ChatMessage {
    enum ChatType {SELF, OTHER}

    private String msgContent;
    private ChatType msgType;

    public ChatMessage(String content, ChatType chatType) {
        this.msgContent = content;
        this.msgType = chatType;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public ChatType getMsgType() {
        return msgType;
    }
}
