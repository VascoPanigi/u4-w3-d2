package VascoPanigi.dao;

import VascoPanigi.entities.Event;
import VascoPanigi.exceptions.EventNotFoundException;
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

    public Event findById(long eventId) {
        Event event = em.find(Event.class, eventId);
        if (event == null) throw new EventNotFoundException(eventId);
        return event;
    }

    public void findByIdAndDelete(long eventId) {
        Event found = this.findById(eventId);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("The event " + found.getTitle() + " has been eliminated from our system!");
    }
}
