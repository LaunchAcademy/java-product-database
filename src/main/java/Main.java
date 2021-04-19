import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args){

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("com.launchacademy.products");

        EntityManager em = emf.createEntityManager();

        Product prod1 = new Product();
        prod1.setName("rubber duck");
        prod1.setDescription("yellow floating duck");
        prod1.setPrice(4.99);
        prod1.setFeatured(true);
        prod1.setCategoryName("toy");

        Product prod2 = new Product();
        prod2.setName("Engineering Journal");
        prod2.setDescription("Record your observations and thoughts as you work through coding projects");
        prod2.setPrice(7.99);
        prod2.setFeatured(true);
        prod2.setCategoryName("Productivity");

        em.getTransaction().begin();
        em.persist(prod1);
        em.persist(prod2);
        em.getTransaction().commit();

        em.close();
        emf.close();

    }
}
