package com.example.spring_hw.config;

import com.example.spring_hw.dao.EventDao;
import com.example.spring_hw.dao.TicketDao;
import com.example.spring_hw.dao.UserDao;
import com.example.spring_hw.entity.EventImpl;
import com.example.spring_hw.entity.TicketImpl;
import com.example.spring_hw.entity.UserImpl;
import com.example.spring_hw.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;


@Component
public class OnStartRunner implements CommandLineRunner {

    @Autowired
    UserDao userDao;

    @Autowired
    EventDao eventDao;

    @Autowired
    TicketDao ticketDao;

    public void run(String... args) throws Exception {
        UserImpl user = new UserImpl();
        user.setId(1L);
        user.setName("Bob");
        user.setEmail("email@gmail.com");

        UserImpl user2 = new UserImpl();
        user2.setId(2L);
        user2.setName("Tim");
        user2.setEmail("email@gmail.com");

        UserImpl user3 = new UserImpl();
        user3.setId(3L);
        user3.setName("Maks");
        user3.setEmail("email@gmail.com");

        userDao.saveUser(user);
        userDao.saveUser(user2);
        userDao.saveUser(user3);

        EventImpl event = new EventImpl();
        event.setId(1L);
        event.setTitle("Spider Man");
        event.setDate(new Date(21, Calendar.OCTOBER, 25));

        EventImpl event2 = new EventImpl();
        event2.setId(2L);
        event2.setTitle("Venom 2");
        event2.setDate(new Date(21, Calendar.OCTOBER, 26));

        EventImpl event3 = new EventImpl();
        event3.setId(3L);
        event3.setTitle("Dyna");
        event3.setDate(new Date(21, Calendar.OCTOBER, 27));

        eventDao.saveEvent(event);
        eventDao.saveEvent(event2);
        eventDao.saveEvent(event3);

        TicketImpl ticket = new TicketImpl();
        ticket.setId(1L);
        ticket.setEventId(1L);
        ticket.setUserId(1L);
        ticket.setCategory(Ticket.Category.STANDARD);
        ticket.setPlace(20);

        TicketImpl ticket2 = new TicketImpl();
        ticket2.setId(2L);
        ticket2.setEventId(2L);
        ticket2.setUserId(2L);
        ticket2.setCategory(Ticket.Category.PREMIUM);
        ticket2.setPlace(1);

        TicketImpl ticket3 = new TicketImpl();
        ticket3.setId(3L);
        ticket3.setEventId(3L);
        ticket3.setUserId(3L);
        ticket3.setCategory(Ticket.Category.BAR);
        ticket3.setPlace(36);

        ticketDao.saveTicket(ticket);
        ticketDao.saveTicket(ticket2);
        ticketDao.saveTicket(ticket3);

    }
}
