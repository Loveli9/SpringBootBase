package com.hou.rabbitmq.service;

import com.hou.rabbitmq.pojo.User;

public interface MessageSendService {

    void sendString(String message);

    void sendObject(User user);
}
