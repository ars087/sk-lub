import java.util.HashMap;
import java.util.Map;

public class CustomerStorage {
    private final Map<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;
        final String REG_NAME = "[А-Я,а-я]+";
        final String REG_PHONE = "(\\s*)?(\\+)?([- _():=+]?\\d[- _():=+]?){10,14}(\\s*)?";
        final String REG_EMAIL = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$";

        String[] components = data.split("\\s+");


        if (!components[INDEX_EMAIL].matches(REG_EMAIL)) {

            throw new RuntimeException();

        } else if (!components[INDEX_PHONE].matches(REG_PHONE)) {


            throw new RuntimeException();
        } else if (!components[INDEX_NAME].matches(REG_NAME)) {


            throw new RuntimeException();
        } else if (!components[INDEX_SURNAME].matches(REG_NAME)) {


            throw new RuntimeException();
        } else if (components.length != 4) {


            throw new ArrayIndexOutOfBoundsException();
        }

        String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];

        storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));


    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        if (getCount() == 0) {
            throw new RuntimeException();

        } else {
            storage.remove(name);
        }

    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }
}