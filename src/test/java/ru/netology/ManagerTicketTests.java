package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.sql.Array;
import java.util.Arrays;
import java.util.Comparator;

public class ManagerTicketTests {
    TicketRepository repo = new TicketRepository();
    ManagerTicket manager = new ManagerTicket(repo);

    Ticket ticket1 = new Ticket(1, 8000, "LED", "KRD", 165);
    Ticket ticket2 = new Ticket(2, 3000, "KRD", "LED", 165);
    Ticket ticket3 = new Ticket(3, 7000, "LED", "KRD", 180);
    Ticket ticket4 = new Ticket(4, 6000, "DME", "LED", 60);
    Ticket ticket5 = new Ticket(5, 4000, "LED", "KRD", 150);


    @Test
    public void shouldFindByFromToSome() {

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket5);

        Ticket[] expected = {ticket5, ticket3, ticket1};
        Ticket[] actual = manager.findAll("LED", "KRD");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindByFromToOne() {

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket4);


        Ticket[] expected = {ticket4};
        Ticket[] actual = manager.findAll("DME", "LED");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindByFromToNone() {

        manager.add(ticket1);
        manager.add(ticket3);
        manager.add(ticket4);


        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("KRD", "LED");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindByFromToIfEmpty() {

        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("KRD", "LED");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindByFromToIfOne() {

        manager.add(ticket4);


        Ticket[] expected = {ticket4};
        Ticket[] actual = manager.findAll("DME", "LED");

        Assertions.assertArrayEquals(expected, actual);

    }
}
