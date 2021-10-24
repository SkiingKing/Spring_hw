package com.example.spring_hw;

import com.example.spring_hw.entity.EventImpl;
import com.example.spring_hw.entity.TicketImpl;
import com.example.spring_hw.entity.UserImpl;
import com.example.spring_hw.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class Database {

   @Autowired
    private HashMap<String, UserImpl> mapOfUsers = new HashMap<>();

    @Autowired
    private HashMap<String, EventImpl> mapOfEvents = new HashMap<>();

    @Autowired
    private HashMap<String, TicketImpl> mapOfTickets = new HashMap<>();

    static Database instance = null;

    private Database(){}

    static public Database getInstance()
    {
        if (instance == null)
            instance = new Database();

        return instance;
    }



    public HashMap<String, UserImpl> getMapOfUsers() {
        return mapOfUsers;
    }

    public HashMap<String, EventImpl> getMapOfEvents() {
        return mapOfEvents;
    }

    public HashMap<String, TicketImpl> getMapOfTickets() {
        return mapOfTickets;
    }

    public void setMapOfUsers(HashMap<String, UserImpl> mapOfUsers) {
        this.mapOfUsers = mapOfUsers;
    }

    public void setMapOfEvents(HashMap<String, EventImpl> mapOfEvents) {
        this.mapOfEvents = mapOfEvents;
    }

    public void setMapOfTickets(HashMap<String, TicketImpl> mapOfTickets) {
        this.mapOfTickets = mapOfTickets;
    }


}
