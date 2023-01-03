package Controller;

import Model.Server;
import Model.Task;

import java.util.ArrayList;
import java.util.List;

public class Scheduler {

    private List<Server> servers;
    private int maxNoServers;
    private int maxTasksPerServer;
    private Strategy strategy;

    public Scheduler(int maxNoServers, int maxTasksPerServer) {
        this.maxNoServers = maxNoServers;
        this.maxTasksPerServer = maxTasksPerServer;
        servers = new ArrayList<>();
        for (int i = 0; i < maxNoServers; i++) {
            Server server = new Server(maxTasksPerServer);
            servers.add(server);
            Thread t = new Thread(server);
            t.start();
        }
    }

    public void changeStrategy(SelectionPolicy selectionPolicy){

        if(selectionPolicy == SelectionPolicy.SHORTESH_QUEUE)
        {
            strategy = new ConcreteStrategyQueue();
        }
        if(selectionPolicy == SelectionPolicy.SHORTEST_TIME)
        {
            strategy = new ConcreteStrategyTime();
        }

    }
    public synchronized void dispatchTask(Task task){
        strategy.addTask(servers,task);
    }

    public List<Server> getServers() {
        return servers;
    }
    public boolean verifOFServers()
    {
        int counterOfServers = 0;
        int counterOfEmptyServers = 0;
        for (Server server: this.servers) {
            if(server.getTasks().size() == 0)
            {
                counterOfEmptyServers++;
            }
            counterOfServers++;
        }
        if(counterOfServers == counterOfEmptyServers){
            return true;
        }
        else{
            return false;
        }
    }

    public synchronized float retWaitingPeriodOfServers()
    {
        int counterOfServers = 0;
        long sumOfPeriods = 0;
        for (Server server: this.servers) {
            sumOfPeriods += server.getWaitingPeriod().get();
            counterOfServers++;
        }
        return sumOfPeriods/counterOfServers;
    }
}
