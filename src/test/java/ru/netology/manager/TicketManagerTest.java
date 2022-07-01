package ru.netology.manager;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import ru.netology.Ticket;
import ru.netology.repository.TicketRepository;


class TicketManagerTest {

    TicketRepository repository = new TicketRepository();
    TicketManager manager = new TicketManager(repository);

    Ticket ticket1 = new Ticket(1, 1599, "SVO", "KZN", 95);
    Ticket ticket2 = new Ticket(2, 2599, "VKO", "KZN", 95);
    Ticket ticket3 = new Ticket(3, 1900, "SVO", "GOJ", 180);
    Ticket ticket4 = new Ticket(4, 4000, "SVO", "KZN", 120);
    Ticket ticket5 = new Ticket(5, 1400, "SVO", "KZN", 95);

    @Test
    public void shouldFindTicket() {
        repository.add(ticket1);
        repository.add(ticket2);
        repository.add(ticket3);
        repository.add(ticket4);
        repository.add(ticket5);

        Ticket[] actual = manager.findAll("SVO", "KZN");
        Ticket[] expected = {ticket5, ticket1, ticket4};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void doNotFindTicket() {
        repository.add(ticket1);
        repository.add(ticket2);
        repository.add(ticket3);
        repository.add(ticket4);
        repository.add(ticket5);

        Ticket[] actual = manager.findAll("VKO", "GOJ");
        Ticket[] expected = new Ticket[0];

        assertArrayEquals(expected, actual);
    }
}