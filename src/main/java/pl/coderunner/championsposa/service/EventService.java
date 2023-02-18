package pl.coderunner.championsposa.service;

import org.springframework.stereotype.Service;
import pl.coderunner.championsposa.domain.Event;
import pl.coderunner.championsposa.repository.EventRepository;
import pl.coderunner.championsposa.service.dto.EventDto;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public EventDto findEvent(long id) {
        Event event = eventRepository.findById(id);
        EventDto eventDto=new EventDto();
        eventDto.setId(event.getId());
        eventDto.setName(event.getName());
        eventDto.setDescription(event.getDescription());
        eventDto.setEventAddress(event.getEventAddress());
        eventDto.setAdministrator(event.getAdministrator());
        eventDto.setCompetitionsList(event.getCompetitionsList());
        eventDto.setLocalDate(event.getLocalDate());

    return eventDto;
    }
}
