package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.Ticket;

import static org.junit.jupiter.api.Assertions.*;

class TicketRepositoryTest {

    TicketRepository repository = new TicketRepository();
    Ticket ticket1 = new Ticket(1, 1599, "SVO", "KZN", 95);
    Ticket ticket2 = new Ticket(2, 2599, "VKO", "KZN", 95);
    Ticket ticket3 = new Ticket(3, 1900, "SVO", "GOJ", 180);
    Ticket ticket4 = new Ticket(4, 4000, "SVO", "KZN", 120);
    Ticket ticket5 = new Ticket(5, 1400, "SVO", "KZN", 95);

    @Test
    public void addTicket() {
        repository.add(ticket1);
        repository.add(ticket2);
        repository.add(ticket3);
        repository.add(ticket4);
        repository.add(ticket5);

        Ticket[] actual = repository.getAll();
        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void removeById() {
        repository.add(ticket1);
        repository.add(ticket2);
        repository.add(ticket3);
        repository.add(ticket4);
        repository.add(ticket5);

        repository.removeById(2);

        Ticket[] actual = repository.getAll();
        Ticket[] expected = {ticket1, ticket3, ticket4, ticket5};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void removeByNonId() {
        repository.add(ticket1);
        repository.add(ticket2);
        repository.add(ticket3);
        repository.add(ticket4);
        repository.add(ticket5);

        assertThrows(NotFoundException.class, () -> {
            repository.removeById(6);
        });
    }

    @Test
    public void shouldFindId() {
        repository.add(ticket1);
        repository.add(ticket2);
        repository.add(ticket3);
        repository.add(ticket4);
        repository.add(ticket5);

        Ticket actual = repository.findById(2);
        Ticket expected = ticket2;
    }

    @Test
    public void findNonId() {
        repository.add(ticket1);
        repository.add(ticket2);
        repository.add(ticket3);
        repository.add(ticket4);
        repository.add(ticket5);

        Ticket actual = repository.findById(6);
        Ticket expected = null;
    }

}