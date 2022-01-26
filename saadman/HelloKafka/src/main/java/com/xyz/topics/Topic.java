package com.xyz.topics;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;


import java.util.*;
public class Topic {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        createTopic("abc",2);
    }
    static void createTopic(String topicName,int partitions) throws ExecutionException, InterruptedException {
        Properties config = new Properties();
        config.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        AdminClient admin = AdminClient.create(config);

        boolean alreadyExists = admin.listTopics().names().get().stream().anyMatch(existingTopicName -> existingTopicName.equals(topicName));
        if(alreadyExists) System.out.println("Topic already exists");

        else{
            NewTopic topic = new NewTopic(topicName,partitions, (short) 1);
            admin.createTopics(Collections.singleton(topic)).all().get();
            System.out.println("Topic created.");
        }
        admin.close();
    }
}
