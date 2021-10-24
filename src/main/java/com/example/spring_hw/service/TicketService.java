package com.example.spring_hw.service;

import com.example.spring_hw.dao.TicketDao;
import com.example.spring_hw.model.Event;
import com.example.spring_hw.model.Ticket;
import com.example.spring_hw.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;


@Service
public class TicketService implements TicketDao{

    private final Logger logger = Logger.getLogger(String.valueOf(TicketService.class));

    @Autowired
    TicketDao ticketDao;

    @Override
    public Ticket bookTicket(long ticketId, long userId, long eventId, int place, Ticket.Category category) {
        logger.info("Ticket was booked" + ticketId);
        return ticketDao.bookTicket(ticketId, userId, eventId, place, category);
    }
    @Override
    public List<Ticket> getBookedTickets(User user, int pageSize, int pageNum) {
        return ticketDao.getBookedTickets(user, pageSize, pageNum);
    }
    @Override
    public List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum) {
        return ticketDao.getBookedTickets(event, pageSize, pageNum);
    }
    @Override
    public boolean cancelTicket(long ticketId) {
        logger.info("Ticket was canceled" + ticketId);
        return ticketDao.cancelTicket(ticketId);
    }
}

