package com.xyz.consumers;

import com.xyz.producers.Producer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Consumer1 {
    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(Consumer1::startConsumer);
        executorService.execute(Consumer1::startConsumer2);
        executorService.execute(Consumer1::startProducer);
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.MINUTES);
    }
    public static void startConsumer(){
        Properties properties = getConsumerProps();
        KafkaConsumer<String,String> consumer1 = new KafkaConsumer<String, String>(properties);
        consumer1.assign(Collections.singleton(new TopicPartition("abc", 0)));


        int giveUp = 100; int noRecordsCount = 0;
        while(true)
        {
            ConsumerRecords<String,String> consumerRecords = consumer1.poll(100);
            if(consumerRecords.count()==0) {
                noRecordsCount++;
                if (noRecordsCount > giveUp) break;
                else continue;
            }
            consumerRecords.forEach(record ->{
                try {
                    writeFile(record.value());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });


            consumer1.commitAsync();
        }
        consumer1.close();
    }
    public static void startConsumer2()
    {
        Properties properties = getConsumerProps();
        KafkaConsumer<String,String> consumer = new KafkaConsumer<String, String>(properties);
        consumer.assign(Collections.singleton(new TopicPartition("abc", 1)));

        int giveUp = 100; int noRecordsCount = 0;
        while(true)
        {
            ConsumerRecords<String,String> consumerRecords = consumer.poll(100);
            if(consumerRecords.count()==0) {
                noRecordsCount++;
                if (noRecordsCount > giveUp) break;
                else continue;
            }
            consumerRecords.forEach(record ->{
                try {
                    writeFile(record.value());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });


            consumer.commitAsync();
        }
        consumer.close();
    }
    public static void writeFile(String data) throws IOException {
        File file = new File("/home/saadman/TestFolder/consumed.txt");
        FileWriter writer = new FileWriter(file,true);
        writer.write(data);
        writer.append("\n");
        writer.close();
    }
    public static KafkaConsumer createConsumer()
    {
        Logger logger = LoggerFactory.getLogger(Consumer1.class.getName());
        String bootstrapServers = "localhost:9092";
        String groupId = "xyz";
        String topic = "MyFirstTopic";
        Properties properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapServers);
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG,groupId);
        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");

        KafkaConsumer<String,String> consumer = new KafkaConsumer<String, String>(properties);
        consumer.subscribe(Arrays.asList(topic));
        return consumer;
    }
    public static Properties getConsumerProps()
    {
        String bootstrapServers = "localhost:9092";
        String groupId = "xyz";
        String topic = "MyFirstTopic";
        Properties properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapServers);
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG,groupId);
        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");
        return properties;
    }
    public static void startProducer() {
        Properties properties = Producer.getProducerProps();
        KafkaProducer producer = new KafkaProducer(properties);
        File file = new File("/home/saadman/TestFolder/sample3.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while(sc.hasNext())
        {
            for(int partitionId=0;partitionId<2;partitionId++)
            {
                if(!sc.hasNext())break;
                String value=sc.nextLine();
                String key = partitionId+"";
                producer.send(new ProducerRecord("abc",partitionId,key,value));
            }
        }
    }
}
