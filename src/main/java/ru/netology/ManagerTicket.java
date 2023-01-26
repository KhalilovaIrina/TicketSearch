package ru.netology;

import java.util.Arrays;
import java.util.Comparator;

public class ManagerTicket {
    private TicketRepository repo;


    public ManagerTicket(TicketRepository repo) {

        this.repo = repo;
    }

    public void add(Ticket ticket) {

        repo.save(ticket);
    }

    public Ticket[] findAll(String from, String to, Comparator<Ticket> comparator){

        Ticket[] result = searchBy(from, to);
        Arrays.sort(result, comparator);
        return result;
    }

    public Ticket[] findAll(String from, String to) {
        Ticket[] result = searchBy(from, to);
        Arrays.sort(result);
        return result;
    }

    public Ticket[] searchBy(String text1, String text2) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repo.findAll()) {
            if (ticket.matches(text1, text2)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        return result;
    }

}
