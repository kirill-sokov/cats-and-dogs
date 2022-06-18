package ks.catsndogs.services;

import ks.catsndogs.avro.PetAdvertised;
import ks.catsndogs.avro.status;
import ks.catsndogs.avro.type;
import ks.catsndogs.model.Cat;
import ks.catsndogs.services.kafka.NotificationProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class CatsService {

    private final InMemStorageService<Cat> storage = new InMemStorageService<>();

    private final NotificationProducer notificationProducer;

    public Cat add(Cat cat) {
        Cat catSaved = storage.add(cat.getName(), cat);

        sendNotification(catSaved, status.AWAITING_OWNER);

        return catSaved;
    }

    public void remove(String name) {
        Cat catSaved = storage.remove(name);

        sendNotification(catSaved, status.ADOPTED);
    }

    public Collection<Cat> getAll() {
        return storage.getAll();
    }

    private void sendNotification(Cat cat, status status) {

        notificationProducer.sendNotification(PetAdvertised.newBuilder()
                .setAge(cat.getAge())
                .setStatus(status)
                .setBreed(cat.getBreed())
                .setColor(cat.getColor())
                .setType(type.CAT)
                .setName(cat.getName())
                .build());
    }
}
