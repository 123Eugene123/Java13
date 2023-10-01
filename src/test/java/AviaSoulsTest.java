import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {
    @Test
    public void shouldFindTicket() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("Moscow", "Omsk", 17_000, 7, 10);
        Ticket ticket2 = new Ticket("Moscow", "Omsk", 15_000, 6, 17);
        Ticket ticket3 = new Ticket("Nsk", "Omsk", 9_000, 9, 11);
        Ticket ticket4 = new Ticket("Dagestan", "Moscow", 13_000, 11, 20);
        Ticket ticket5 = new Ticket("Nsk", "Moscow", 16_000, 11, 15);
        Ticket ticket6 = new Ticket("Moscow", "Omsk", 14_000, 12, 15);
        Ticket ticket7 = new Ticket("Moscow", "Omsk", 10_000, 20, 23);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] expected = {ticket7,ticket6,ticket2,ticket1};
        Ticket[] actual = manager.search("Moscow","Omsk");

        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    public void shouldFindOneTicket() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("Moscow", "Omsk", 17_000, 7, 10);
        Ticket ticket2 = new Ticket("Moscow", "Omsk", 15_000, 6, 17);
        Ticket ticket3 = new Ticket("Nsk", "Omsk", 9_000, 9, 11);
        Ticket ticket4 = new Ticket("Dagestan", "Moscow", 13_000, 11, 20);
        Ticket ticket5 = new Ticket("Nsk", "Moscow", 16_000, 11, 15);
        Ticket ticket6 = new Ticket("Moscow", "Omsk", 14_000, 12, 15);
        Ticket ticket7 = new Ticket("Moscow", "Omsk", 10_000, 20, 23);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] expected = {ticket4};
        Ticket[] actual = manager.search("Dagestan","Moscow");

        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    public void shouldFindNoneTicket() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("Moscow", "Omsk", 17_000, 7, 10);
        Ticket ticket2 = new Ticket("Moscow", "Omsk", 15_000, 6, 17);
        Ticket ticket3 = new Ticket("Nsk", "Omsk", 9_000, 9, 11);
        Ticket ticket4 = new Ticket("Dagestan", "Moscow", 13_000, 11, 20);
        Ticket ticket5 = new Ticket("Nsk", "Moscow", 16_000, 11, 15);
        Ticket ticket6 = new Ticket("Moscow", "Omsk", 14_000, 12, 15);
        Ticket ticket7 = new Ticket("Moscow", "Omsk", 10_000, 20, 23);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] expected = {};
        Ticket[] actual = manager.search("Dagestan","Nsk");

        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    public void findTicketComporator() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("Moscow", "Omsk", 17_000, 7, 10);
        Ticket ticket2 = new Ticket("Moscow", "Omsk", 15_000, 15, 17);
        Ticket ticket3 = new Ticket("Nsk", "Omsk", 9_000, 9, 11);
        Ticket ticket4 = new Ticket("Dagestan", "Moscow", 13_000, 11, 20);
        Ticket ticket5 = new Ticket("Nsk", "Moscow", 16_000, 11, 15);
        Ticket ticket6 = new Ticket("Moscow", "Omsk", 14_000, 18, 19);
        Ticket ticket7 = new Ticket("Moscow", "Nsk", 10_000, 20, 23);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket6,ticket2,ticket1};
        Ticket[] actual = manager.searchAndSortBy("Moscow", "Omsk",comparator);

        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    public void findOneTicketComporator() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("Moscow", "Omsk", 17_000, 7, 10);
        Ticket ticket2 = new Ticket("Moscow", "Omsk", 15_000, 15, 17);
        Ticket ticket3 = new Ticket("Nsk", "Omsk", 9_000, 9, 11);
        Ticket ticket4 = new Ticket("Dagestan", "Moscow", 13_000, 11, 20);
        Ticket ticket5 = new Ticket("Nsk", "Moscow", 16_000, 11, 15);
        Ticket ticket6 = new Ticket("Moscow", "Omsk", 14_000, 18, 19);
        Ticket ticket7 = new Ticket("Moscow", "Nsk", 10_000, 20, 23);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket3};
        Ticket[] actual = manager.searchAndSortBy("Nsk", "Omsk",comparator);

        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    public void noneTicketComporator() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("Moscow", "Omsk", 17_000, 7, 10);
        Ticket ticket2 = new Ticket("Moscow", "Omsk", 15_000, 15, 17);
        Ticket ticket3 = new Ticket("Nsk", "Omsk", 9_000, 9, 11);
        Ticket ticket4 = new Ticket("Dagestan", "Moscow", 13_000, 11, 20);
        Ticket ticket5 = new Ticket("Nsk", "Moscow", 16_000, 11, 15);
        Ticket ticket6 = new Ticket("Moscow", "Omsk", 14_000, 18, 19);
        Ticket ticket7 = new Ticket("Moscow", "Nsk", 10_000, 20, 23);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {};
        Ticket[] actual = manager.searchAndSortBy("Dagestan", "Omsk",comparator);

        Assertions.assertArrayEquals(expected,actual);
    }
}