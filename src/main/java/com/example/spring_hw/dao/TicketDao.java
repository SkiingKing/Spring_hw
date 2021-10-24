package com.example.spring_hw.dao;


import com.example.spring_hw.Database;
import com.example.spring_hw.entity.EventImpl;
import com.example.spring_hw.entity.TicketImpl;
import com.example.spring_hw.model.Event;
import com.example.spring_hw.model.Ticket;
import com.example.spring_hw.model.User;

import java.util.List;
import java.util.stream.Collectors;


public interface TicketDao {

    default Ticket bookTicket(long ticketId, long userId, long eventId, int place, Ticket.Category category) {
        TicketImpl ticket = new TicketImpl();
        ticket.setId(ticketId);
        ticket.setUserId(userId);
        ticket.setEventId(eventId);
        ticket.setPlace(place);
        ticket.setCategory(category);
        return saveTicket(ticket);
    }
    default List<Ticket> getBookedTickets(User user, int pageSize, int pageNum) {
        return Database.getInstance().getMapOfTickets().values().stream()
                .filter(ticket -> ticket.getUserId() == user.getId())
                .collect(Collectors.toList());
    }
    default List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum) {
        return Database.getInstance().getMapOfTickets().values().stream()
                .filter(ticket -> ticket.getEventId() == event.getId())
                .collect(Collectors.toList());
    }

    default boolean cancelTicket(long ticketId) {
        if(Database.getInstance().getMapOfTickets().containsKey("ticket:" + ticketId)) {
            Database.getInstance().getMapOfTickets().remove("ticket:" + ticketId);
            return true;
        }else
            return false;
    }

    default Ticket saveTicket(TicketImpl ticket){
        return Database.getInstance().getMapOfTickets().put("ticket:" + ticket.getId(), ticket);
    }
}
