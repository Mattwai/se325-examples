package se325.example13.parolee.services;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;

@Path("/parolees-test")
public class TestResource {

    @PUT
    @Path("/reset-database")
    public void reset() {
        PersistenceManager.instance().reset();
    }
//
//    /**
//     * Method that adds clears and then adds some dummy data to the "database".
//     */
//    protected void reloadDatabase() {
//
//        // Wipe the database and re-initialize it with empty tables.
//        PersistenceManager.instance().reset();
//
//        // Add dummy data
//        EntityManager em = PersistenceManager.instance().createEntityManager();
//        try {
//
//            em.getTransaction().begin();
//            // === Initialise Parolee #1
//            GeoPosition addressLocation = new GeoPosition(-36.865520, 174.859520);
//            Address address = new Address("15", "Bermuda road", "St Johns", "Auckland", "1071", addressLocation);
//            Parolee parolee = new Parolee(
//                    "Sinnen",
//                    "Oliver",
//                    Gender.MALE,
//                    LocalDate.of(1970, 5, 26),
//                    address);
//
//            parolee.getConvictions().add(new Conviction(LocalDate.of(
//                    1994, 1, 19), "Crime of passion", Offence.MURDER));
//
//            LocalDateTime today = LocalDateTime.of(2021, 8, 15, 12, 0, 0);
//            LocalDateTime earlierToday = today.minusHours(1);
//            LocalDateTime yesterday = today.minusDays(1);
//            GeoPosition position = new GeoPosition(-36.852617, 174.769525);
//
//            parolee.addMovement(new Movement(yesterday, position));
//            parolee.addMovement(new Movement(earlierToday, position));
//            parolee.addMovement(new Movement(today, position));
//
//            em.persist(parolee);
//            em.getTransaction().commit();
//
//            // === Initialise Parolee #2
//            em.getTransaction().begin();
//
//            address = new Address("22", "Tarawera Terrace", "St Heliers", "Auckland", "1071");
//            parolee = new Parolee(
//                    "Watson",
//                    "Catherine",
//                    Gender.FEMALE,
//                    LocalDate.of(1970, 2, 9),
//                    address);
//
//            em.persist(parolee);
//            em.getTransaction().commit();
//
//            // === Initialise Parolee #3
//            em.getTransaction().begin();
//
//            address = new Address("67", "Drayton Gardens", "Oraeki", "Auckland", "1071");
//            parolee = new Parolee(
//                    "Giacaman",
//                    "Nasser",
//                    Gender.MALE,
//                    LocalDate.of(1980, 10, 19),
//                    address);
//
//            em.persist(parolee);
//            em.getTransaction().commit();
//
//        } finally {
//            em.close();
//        }
//    }
}
