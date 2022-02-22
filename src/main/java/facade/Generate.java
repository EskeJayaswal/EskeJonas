package facade;

import entities.Director;
import entities.Movie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Generate {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Director d1 = new Director("Ridley", "Scott");
            Director d2 = new Director("Peter", "Jackson");

            Movie m1 = new Movie("Alien", 1979, "Sci-fi Horror");
            Movie m2 = new Movie("Alien 2", 1986, "Sci-fi Horror");
            Movie m3 = new Movie("The Hobbit", 2012, "Fantasy");
            Movie m4 = new Movie("King Kong", 2005, "Adventure");
            Movie m5 = new Movie("District 9", 2009, "Sci-fi");






            d1.addMovie(m1);
            d1.addMovie(m2);
            d2.addMovie(m3);
            d2.addMovie(m4);
            d2.addMovie(m5);
            em.persist(d1);
            em.persist(d2);
            em.persist(m1);
            em.persist(m2);
            em.persist(m3);
            em.persist(m4);
            em.persist(m5);



            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
