package VascoPanigi;

import VascoPanigi.dao.EventsDAO;
import VascoPanigi.entities.Event;
import VascoPanigi.enums.EventType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4-w3-d2");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EventsDAO sd = new EventsDAO(em);
        Event eventone = new Event(500, EventType.PUBLIC, "prevendite spazio", LocalDate.of(2020, 5, 13), "seratona spazio lascia perde oo");

        sd.save(eventone);
    }
}
