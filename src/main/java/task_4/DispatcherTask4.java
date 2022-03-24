package task_4;

import java.lang.reflect.Field;

public class DispatcherTask4 {
    public static void main(String[] args) {
        Client client = new Client("John", "john@mail.com", 23);

        System.out.println(get(client, "name"));
        put(client, "name", 0);
        System.out.println(get(client, "name"));

        System.out.println(get(client, "age"));
        clear(client, "age");
        System.out.println(get(client, "age"));
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
