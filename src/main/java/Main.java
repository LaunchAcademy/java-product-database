import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

  public static void main(String[] args) throws IOException {
    // Retrieve products from file using a helper method.
    List<HashMap<String, String>> products = getProducts();

    // Create EntityManagerFactory using the Persistence object and the persistenceUnitName (located in persistence.xml file)
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.launchacademy.products");

    // Create EntityManager using the previously made EntityManagerFactory
    EntityManager em = emf.createEntityManager();

    try {
      // Start transaction
      em.getTransaction().begin();

      // Loop through the products List to create a new Product on each iteration
      for (HashMap<String, String> product : products) {

        // Instantiate a Product object with all fields empty
        Product newProduct = new Product();

        // Use setters to assign the value from the product's HashMap
        newProduct.setName(product.get("name"));
        newProduct.setDescription(product.get("description"));

        // If the Product field is anything other than a String, we must parse to what it is supposed to be
        newProduct.setPrice(Double.parseDouble(product.get("price")));
        newProduct.setFeatured(Boolean.parseBoolean(product.get("featured")));
        newProduct.setCategoryName(product.get("category_name"));

        // Stage the persisting of the newProduct
        em.persist(newProduct);
      }

      // Finish transaction and attempt to execute all things that were staged
      em.getTransaction().commit();
    } finally {

      // Close resources in reverse order created.
      em.close();
      emf.close();
    }


  }

  // Helper method to read in the json file and return a list of hashmaps
  private static List<HashMap<String, String>> getProducts() throws IOException {
    ClassLoader classLoader = Main.class.getClassLoader();
    ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

    // Returns List directly using map.readValue instead of storing in a variable first
    return mapper.readValue(new File(classLoader.getResource("catalog.json").getFile()),
        ArrayList.class);
  }
}
