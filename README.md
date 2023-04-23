# Kafka

Kafka steps:
1. install kafka from following link:
   https://kafka.apache.org/downloads
2. We need to modify some configs and properties:
   inside config dir, open zookeeper.properties file and update dataDir path: <not sure if this is required as we have different zookeeper folder now>
   dataDir= <path of kafka with '/' as directory differentiator>/zookeeper-data
   ![img_4.png](img_4.png)
3. In the same dir, open server.properties and update log.dir:
   log.dir=<path of kafka with '/' as directory differentiator>/kafka-logs
    ![img_5.png](img_5.png)
    ![img_3.png](img_3.png)

4. start zookeeper:
   ```agsl
    .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
    ```
   ![img_6.png](img_6.png)

5. start kafka:
   ```agsl
    .\bin\windows\kafka-server-start.bat .\config\server.properties
    ```
    ![img_7.png](img_7.png)

6. create kafka topics:
   ```agsl
    kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic test
    ```
   ![img_8.png](img_8.png)

7. Check topics created list
   ```agsl
    kafka-topics.bat --list --bootstrap-server localhost:9092
    ```
    ![img_9.png](img_9.png)


## ERRORS:
1. __ERROR__ Exiting Kafka due to fatal exception during startup. (kafka.Kafka$)
kafka.common.InconsistentClusterIdException: The Cluster ID OXY59REORCCwZu1JD0j-wA doesn't match stored clusterId Some(SVqEzqpYTSKqC3FfbZs5yg) in meta.properties. The broker is trying to join the wrong cluster. Configured zookeeper.connect may be wrong.
    <br>
    __Solution:__
   delete all logs from following folders:
   D:/softwares/zookeeper/apache-zookeeper-3.8.1-bin/data
   kafka-logs
   zookeeper-data