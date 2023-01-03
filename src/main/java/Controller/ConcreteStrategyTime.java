package Controller;

import Model.Server;
import Model.Task;

import java.util.List;

public class ConcreteStrategyTime implements Strategy{
    @Override
    public void addTask(List<Server> servers, Task task) {
        int indexMinTime = 0;
        if (servers.size() > 1)
        {

            int minTime = servers.get(0).getWaitingPeriod().get();
            int index = 0;
            for (Server server: servers) {
                if(server.getWaitingPeriod().get() < minTime)
                {
                    indexMinTime = index;
                    minTime = server.getWaitingPeriod().get();
                }
                index++;
            }
        }

        servers.get(indexMinTime).addTask(task);
    }
}
