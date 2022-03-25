package task_4;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DispatcherTask4 {
    public static void main(String[] args) {
//        Client client = new Client("John", "john@mail.com", 23);
//
//        System.out.println(get(client, "name"));
//        put(client, "name", 0);
//        System.out.println(get(client, "name"));
//
//        System.out.println(get(client, "age"));
//        clear(client, "age");
//        System.out.println(get(client, "age"));

        List<Client> clientGroup = new ArrayList<>();
        clientGroup.add(new Client("Oleg", "lol@mail.com", 22));
        clientGroup.add(new Client("Alla", "ola@mail.com", 19));
        clientGroup.add(new Client("Zheka", "aheka@mail.com", 21));

        Comparator<Client> comparatorByAge = (o1, o2) -> {
            try {
                return Integer.parseInt(get(o2, "age").toString()) - Integer.parseInt(get(o1, "age").toString());
            } catch (IllegalArgumentException i) {
                i.printStackTrace();
                return 0;
            }
        };
        Comparator<Client> comparatorByName = Comparator.comparing(o -> get(o, "name").toString());

        sort(clientGroup, comparatorByName);
        min(clientGroup);
        max(clientGroup);

        sort(clientGroup, comparatorByAge);
        min(clientGroup);
        max(clientGroup);
    }

    private static <T> void sort(List<T> list, Comparator<T> comparator) {
        list.sort(comparator);
    }

    private static <T> void max(List<T> clientGroup) {
        System.out.println(clientGroup.get(0));
    }

    private static <T> void min(List<T> clientGroup) {
        System.out.println(clientGroup.get(clientGroup.size()-1));
    }


    private static Object get(Object obj, String fieldName) {
        for (Field f : obj.getClass().getDeclaredFields()) {
            if (f.getName().equals(fieldName)) {
                try {
                    f.setAccessible(true);
                    return f.get(obj);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    private static void put(Object obj, String fieldName, Object value) {
        for (Field f : obj.getClass().getDeclaredFields()) {
            if (f.getName().equals(fieldName)) {
                try {
                    f.setAccessible(true);
                    f.set(obj, value);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void clear(Object obj, String fieldName) {
        for (Field f : obj.getClass().getDeclaredFields()) {
            if (f.getName().equals(fieldName)) {
                try {
                    f.setAccessible(true);
                    if (f.getType().toString().equals("int")) {
                        f.set(obj, 0);
                    } else {
                        f.set(obj, null);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
