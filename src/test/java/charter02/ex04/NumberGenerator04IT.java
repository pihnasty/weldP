package charter02.ex04;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class NumberGenerator04IT {

  // ======================================
  // =             Attributes             =
  // ======================================

  protected Weld weld;
  protected WeldContainer container;

  // ======================================
  // =          Lifecycle Methods         =
  // ======================================


  // ======================================
  // =              Methods               =
  // ======================================

  @Test
  public void shouldCheckNumberIsThirteenDigits() {
    weld = new Weld();
    container = weld.initialize();
    BookService04 bookService = container.instance().select(BookService04.class).get();
    Book04 book = bookService.createBook("H2G2", 12.5f, "Geeky scifi Book2");
    assertTrue(book.getIsbn().startsWith("13"));
    System.out.println( book.toString());
    weld.shutdown();
  }
}
