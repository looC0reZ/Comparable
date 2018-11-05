/* class Product.
 *
 * ver.: 0.0.1
 *
 * Информации об авторском параве нет
 */

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/** Реализация интерфейса Comparator.
 * @version   0.1 27 Oct 2018
 * @author    Georgiy Krasko
 */

public final class Product {
    private String name;
    private int count;

    private Product(final String pName, final int pCount) {
        this.name = pName;
        this.count = pCount;
    }

    String getName() {
        return name;
    }

    int getCount() {
        return count;
    }
    public static void main(final String[] args) {
        Comparator<Product> nc = new CountComparator().thenComparing(new NameComparator());
        Set<Product> products = new TreeSet<>(nc);
        products.add(new Product("Ноутбук", 3));
        products.add(new Product("Телефон", 5));
        products.add(new Product("Телевизор", 1));
        products.add(new Product("Наушники", 10));
        for (Product s : products) {
            System.out.println(s.getName() + " " + s.getCount());
        }

    }
}

class NameComparator implements Comparator<Product> {
    @Override
    public int compare(final Product o1, final Product o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class CountComparator implements Comparator<Product> {
    @Override
    public int compare(final Product o1, final Product o2) {
        if (o1.getCount() > o2.getCount()) {
            return 1;
        } else if (o1.getCount() < o2.getCount()) {
            return -1;
        } else {
            return 0;
        }
    }
}
