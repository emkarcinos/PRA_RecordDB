package Database;

import Database.Model.Artist;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Manager {

    public static void main(String[] args){
        System.out.println("Starting sample session...");

        EntityManager entityManager = null;
        EntityManagerFactory entityManagerFactory = null;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");
            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();

            entityManager.flush();
        } catch (Throwable ex){
            ex.printStackTrace();
        } finally {
            entityManagerFactory.close();
        }
    }
}
