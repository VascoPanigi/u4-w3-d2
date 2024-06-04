package VascoPanigi.dao;

import VascoPanigi.entities.Event;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EventsDAO {

    private EntityManager em;

    public EventsDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Event event) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(event);
        transaction.commit();
        System.out.println("The event " + event.getTitle() + " has been added. Yippieee :D");
    }

}
