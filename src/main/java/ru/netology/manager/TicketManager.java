package ru.netology.manager;

import ru.netology.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

public class TicketManager {
    private TicketRepository repository;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;{
        }
    }

    public Ticket[] findAll(String from, String to) {
        Ticket[] ans = new Ticket[0];
        for (Ticket ticket : repository.getAll()) {
            if (ticket.getAirportFrom() == from) {
                if (ticket.getAirportTo() == to) {
                    Ticket[] tmp = new Ticket[ans.length + 1];
                    for (int i = 0; i < ans.length; i++) {
                        tmp[i] = ans[i];
                    }
                    tmp[tmp.length - 1] = ticket;
                    ans = tmp;
                }
            }
        }
        Arrays.sort(ans);
        return ans;
    }

}
