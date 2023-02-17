package pl.coderunner.championsposa.service;

import org.springframework.stereotype.Service;
import pl.coderunner.championsposa.domain.Event;
import pl.coderunner.championsposa.repository.EventRepository;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event findEvent(long id) {
        Event event = eventRepository.findById(id);
        return event;
    }
}
