package ks.catsndogs.services;

import ks.catsndogs.avro.PetAdvertised;
import ks.catsndogs.avro.status;
import ks.catsndogs.avro.type;
import ks.catsndogs.model.Dog;
import ks.catsndogs.services.kafka.NotificationProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class DogsService {

    private final InMemStorageService<Dog> storage = new InMemStorageService<>();

    NotificationProducer notificationProducer;

    public Dog add(Dog dog) {
        Dog dogSaved = storage.add(dog.getName(), dog);

        sendNotification(dogSaved, status.AWAITING_OWNER);

        return dogSaved;
    }

    public void remove(String name) {
        Dog dogSaved = storage.remove(name);

        sendNotification(dogSaved, status.ADOPTED);
    }

    public Collection<Dog> getAll() {
        return storage.getAll();
    }

    private void sendNotification(Dog dog, status status) {

        notificationProducer.sendNotification(PetAdvertised.newBuilder()
                .setAge(dog.getAge())
                .setStatus(status)
                .setBreed(dog.getBreed())
                .setColor(dog.getColor())
                .setType(type.DOG)
                .setName(dog.getName())
                .build());
    }
}
