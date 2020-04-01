package com.hou.activemq.service;

import com.hou.activemq.pojo.User;

public interface MessageService {

    void sendMessage(String message);

    void receiveMessage(String message);

    void sendUser(User user);

    void receiveUser(User user);
}
