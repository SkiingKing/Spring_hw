package com.example.spring_hw.dao;

import com.example.spring_hw.Database;
import com.example.spring_hw.entity.EventImpl;
import com.example.spring_hw.model.Event;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public interface EventDao {
    default Event getEventById(long eventId) {
        return Database.getInstance().getMapOfEvents().get("event:" + eventId);
    }

    default List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
        return Database.getInstance().getMapOfEvents().values().stream()
                .filter(event -> event.getTitle().equals(title))
                .limit(pageSize)
                .collect(Collectors.toList());
    }


    default List<Event> getEventsForDay(Date day, int pageSize, int pageNum) {
        return Database.getInstance().getMapOfEvents().values().stream()
                .filter(event -> event.getDate().equals(day))
                .limit(pageSize)
                .collect(Collectors.toList());
    }

    default Event createEvent(EventImpl event) {
        return saveEvent(event);
    }

    default Event updateEvent(EventImpl event) {
        return Database.getInstance().getMapOfEvents().put("event:" + event.getId(), event);
    }

    default boolean deleteEvent(long eventId) {
        if (Database.getInstance().getMapOfTickets().containsKey("ticket:" + eventId)) {
            Database.getInstance().getMapOfTickets().remove("ticket:" + eventId);
            return true;
        } else
            return false;
    }

    default Event saveEvent(EventImpl event){
        return Database.getInstance().getMapOfEvents().put("event:" + event.getId(), event);
    }
}
