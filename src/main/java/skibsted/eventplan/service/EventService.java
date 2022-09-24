package skibsted.eventplan.service;

import org.springframework.stereotype.Service;
import skibsted.eventplan.model.Event;
import skibsted.eventplan.repository.EventRepository;

import java.security.PrivateKey;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class EventService implements IEventService{

    private EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Set<Event> findAll() {
        Set<Event> set = new HashSet<>();
        eventRepository.findAll().forEach(set::add);
        return null;
    }

    @Override
    public Event save(Event object) {
        eventRepository.save(object);
        return null;
    }

    @Override
    public void delete(Event object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Optional<Event> findById(Long aLong) {
        return Optional.empty();
    }
}
