import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Seeder {
  public static String CATALOG_FILE_PATH = "catalog.json";

  public static void main(String[] args) throws IOException {
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    InputStream stream = classLoader.getResourceAsStream(CATALOG_FILE_PATH);
    Scanner scanner = new Scanner(stream).useDelimiter("\\z");
    System.out.println(scanner.next());
  }
}
