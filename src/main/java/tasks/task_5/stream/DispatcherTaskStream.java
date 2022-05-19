package tasks.task_5.stream;

import tasks.task_4.Client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DispatcherTaskStream {
    public static void main(String[] args) {
        List<Client> clientGroup = new ArrayList<>();
        clientGroup.add(new Client("Oleg", "lol@mail.com", 22));
        clientGroup.add(new Client("Alla", "ola@mail.com", 19));
        clientGroup.add(new Client("Zheka", "aheka@mail.com", 21));

        System.out.println(clientGroup);
        clientGroup =  clientGroup.stream().sorted(Comparator.comparing(Client::getName)).collect(Collectors.toList());;
        System.out.println(clientGroup);
        System.out.println(clientGroup.stream().filter(c -> c.getAge()>20).collect(Collectors.toList()));
        System.out.println(clientGroup.stream().map(Client::getEmail).collect(Collectors.toList()));

        // Maven's args
        System.out.println(Arrays.asList(args));
    }
}
