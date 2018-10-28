package com.slandshow.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

@Service
public class MessageQueueService {

    private static final String EXCHANGE_NAME = "messages";
    private static final Logger LOGGER = Logger.getLogger(MessageQueueService.class);
    private List<String> messages;
    private static boolean INSTANCE_IS_CREATED = false;

    private void produceMsg(String msg) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");

        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(EXCHANGE_NAME, false, false, false, null);
        channel.basicPublish("", EXCHANGE_NAME, null, msg.getBytes("UTF-8"));
        LOGGER.info(" [x] Sent '" + msg + "'");

        channel.close();
        connection.close();
    }

    public List<String> getMessagesInstance() {
        if (INSTANCE_IS_CREATED == false) {
            INSTANCE_IS_CREATED = true;
            messages = new ArrayList<>();
        }

        return messages;
    }

    public void produceMessagesInOneTransaction() throws IOException, TimeoutException {
        for (String message: messages) {
            produceMsg(message);
        }
    }
}
