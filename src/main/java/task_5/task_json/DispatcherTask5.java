package task_5.task_json;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;
import task_4.Client;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;

public class DispatcherTask5 {
    private static final String PACKAGE_PATH = "/Users/user/Desktop/ITSU/QA Automation/workspace/task0/src/main/java/task_5/task_json/";
    public static void main(String[] args) {
        String inputString = "";
        try {
            inputString = Files.readString(new File(PACKAGE_PATH+"input.json").toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(inputString);

        JSONObject json = new JSONObject(inputString);
        System.out.println(json);

        ObjectMapper mapper = new ObjectMapper();

        Client client = new Client();
        try {
            client = mapper.readValue(inputString, Client.class);
            System.out.println(client);
        } catch (IOException e) {
            e.printStackTrace();
        }

        client.setOrders(new ArrayList<>());

        client.getOrders().add(1000);
        client.getOrders().add(1001);
        client.getOrders().add(1002);
        client.getOrders().add(1003);

        System.out.println(client);

        JSONObject outputJson = new JSONObject(client);

        System.out.println(outputJson);

        try {
            PrintWriter pw = new PrintWriter(PACKAGE_PATH+"output.json");
            pw.println(outputJson);
            pw.flush(); pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
