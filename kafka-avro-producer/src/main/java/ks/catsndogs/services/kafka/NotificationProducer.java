package ks.catsndogs.services.kafka;

import ks.catsndogs.avro.PetAdvertised;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.generic.GenericRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationProducer {

    private final KafkaTemplate<String, GenericRecord> kafkaTemplate;

    @Value("${ks.env.topicName}")
    private String topicName;

    public void sendNotification(PetAdvertised petAdvertised) {
        kafkaTemplate.send(topicName, String.valueOf(petAdvertised.getName()), petAdvertised)
                .completable()
                .thenAccept(v -> log.info("Notification sent successfully"))
                .exceptionally(v -> {
                    log.error("Failed to send notification!");
                    return null;
                });
    }
}
