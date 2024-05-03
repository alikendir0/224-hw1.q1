import java.util.Iterator;
import java.util.LinkedList;

public class Bag<Item> implements Iterable<Item> {
  private LinkedList<Item> items;

  public Bag() {
    items = new LinkedList<>();
  }

  public void add(Item item) {
    items.add(item);
  }

  @Override
  public Iterator<Item> iterator() {
    return items.iterator();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (Item item : items) {
      sb.append(item).append(" ");
    }
    return sb.toString();
  }
}