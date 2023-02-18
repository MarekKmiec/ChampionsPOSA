package pl.coderunner.championsposa.controler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.coderunner.championsposa.domain.Event;
import pl.coderunner.championsposa.service.EventService;
import pl.coderunner.championsposa.service.dto.EventDto;

@RestController
@RequestMapping("/api")
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }
    @GetMapping("/event/{id}")
    public EventDto findEvent(@PathVariable("id") long id){
       return eventService.findEvent(id);

    }
}
