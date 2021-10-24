package com.example.spring_hw.service;

import com.example.spring_hw.dao.EventDao;
import com.example.spring_hw.entity.EventImpl;
import com.example.spring_hw.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;


@Service
public class EventService implements EventDao {

    private final Logger logger = Logger.getLogger(String.valueOf(EventService.class));

    @Autowired
    EventDao eventDao;

    public Event getEventById(long eventId) {
        return eventDao.getEventById(eventId);
    }

    public List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
        return eventDao.getEventsByTitle(title, pageSize, pageNum);
    }

    public List<Event> getEventsForDay(Date day, int pageSize, int pageNum) {
        return eventDao.getEventsForDay(day, pageSize, pageNum);
    }

    public Event createEvent(EventImpl event) {
        logger.info("New event was created" + event.getId());
        return eventDao.createEvent(event);
    }

    public Event updateEvent(EventImpl event) {
        logger.info("Event was updated" + event.getId());
        return eventDao.updateEvent(event);
    }

    public boolean deleteEvent(long eventId) {
        logger.info("Event was deleted" + eventId);
        return eventDao.deleteEvent(eventId);
    }
}
