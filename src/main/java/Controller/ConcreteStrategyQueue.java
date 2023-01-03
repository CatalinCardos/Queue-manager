package Controller;

import Model.Server;
import Model.Task;

import java.util.List;

public class ConcreteStrategyQueue implements Strategy{
    @Override
    public void addTask(List<Server> servers, Task task) {
        int indexServer = 0;
        if (servers.size() > 1) {


            int minSpace = servers.get(0).getTasks().size();
            int index = 0;
            for (Server server : servers) {
                if (server.getTasks().size() < minSpace) {
                    indexServer = index;
                    minSpace = server.getTasks().size();
                }
                index++;
            }
        }
        servers.get(indexServer).addTask(task);
    }
}
