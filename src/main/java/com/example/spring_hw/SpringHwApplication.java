package com.example.spring_hw;

import com.example.spring_hw.facade.BookingFacade;
import com.example.spring_hw.facade.BookingFacadeImpl;
import com.example.spring_hw.model.Event;
import com.example.spring_hw.model.Ticket;
import com.example.spring_hw.service.EventService;
import com.example.spring_hw.service.TicketService;
import com.example.spring_hw.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringHwApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringHwApplication.class, args);

        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        UserService userService = (UserService) context.getBean("userService");
        EventService eventService = (EventService) context.getBean("eventService");
        TicketService ticketService = (TicketService) context.getBean("ticketService");


       BookingFacade bookingFacade = new BookingFacadeImpl(userService, eventService, ticketService);



    }

}
