package Controller;

import Model.Server;
import Model.Task;
import View.GuiThreads;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimulationManager implements Runnable{
    private final Scheduler scheduler;
    private final List<Task> tasks;
    private SelectionPolicy selectionPolicy;
    private GuiThreads frame;
    private final int clients;
    private int queues;
    private final int maxTimeSim;
    private final int minArrival;
    private final int maxArrival;
    private final int minService;
    private final int maxService;
    private long sumOfServices;
    private long numerOfServices;
    private float sumOfWaitingPeriod;
    private int peekLevel;
    private int peekClients;


    public SimulationManager(int clients, int queues, int maxTimeSim, int minArrival, int maxArrival, int minService, int maxService, GuiThreads frame) {
        this.clients = clients;
        this.queues = queues;
        this.maxTimeSim = maxTimeSim;
        this.minArrival = minArrival;
        this.maxArrival = maxArrival;
        this.minService = minService;
        this.maxService = maxService;
        this.frame = frame;
        this.peekLevel = 0;
        this.peekClients = 0;
        tasks = new ArrayList<>();
        scheduler = new Scheduler(queues,100);
        //--create and start numberOfServers threads
        selectionPolicy = SelectionPolicy.SHORTESH_QUEUE;
        scheduler.changeStrategy(selectionPolicy);
        generateRandomTasks();
        this.numerOfServices = 0;
        this.sumOfServices = 0;
        this.sumOfWaitingPeriod = 0;
        frame.getTextArea1().setText("");
    }

    public void generateRandomTasks(){

        for (int i = 1; i <= clients; i++) {
            int random_Arrival = (int)Math.floor(Math.random()*(maxArrival-minArrival+1)+minArrival);
            int random_Service = (int)Math.floor(Math.random()*(maxService-minService+1)+minService);
            this.tasks.add(new Task(i,random_Arrival,random_Service));
        }
        Collections.sort(this.tasks);
    }

    @Override
    public void run() {
        int currentTime = 1;
        while(currentTime <= maxTimeSim){
            frame.getTextArea1().append(String.valueOf(currentTime) + ")\n");
            List<Task> removeItems = new ArrayList<>();
            for (Task auxtask: this.tasks) {
                if(auxtask.getArrivalTime() == currentTime) {
                    this.sumOfServices += auxtask.getServiceTime();
                    scheduler.dispatchTask(auxtask);
                    sumOfWaitingPeriod += scheduler.retWaitingPeriodOfServers();
                    this.numerOfServices++;
                    removeItems.add(auxtask);
                }
            }
            for (Task aux: removeItems) {
                this.tasks.remove(aux);
            }
            getMaxPeek(scheduler.getServers(), currentTime);
            printTasks(scheduler.getServers());
            currentTime++;
            try {
                Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
            frame.getTextArea1().append("\n");
            if(scheduler.verifOFServers() && this.tasks.size() == 0){
                break;
            }
        }
        displayFinal();
        folderWrite();
    }
    public void printTasks(List<Server> printer)
    {

    int counter = 1;
        if(printer.size() != 0)
        {
            for (Server aux1: printer) {
                frame.getTextArea1().append("Queue " + counter + ": ");
                if(aux1.getTasks().size() != 0)
                {
                    for (Task aux2: aux1.getTasks()) {
                        frame.getTextArea1().append(aux2.toString() + " ");
                    }
                }
                else
                {
                    frame.getTextArea1().append("Closed");
                }
                frame.getTextArea1().append("\n");
                counter++;
            }
        }
    }
    public void displayFinal()
    {
        frame.getTextArea1().append("Average service waiting time: " + this.sumOfServices / this.numerOfServices + "\n");
        frame.getTextArea1().append("Average waiting time: " + this.sumOfWaitingPeriod / this.numerOfServices + "\n");
        frame.getTextArea1().append("Peek level: " + this.peekLevel);
    }
    public void getMaxPeek(List<Server> servers, int currentTime)
    {
        int peek = 0;
        for (Server server: servers) {
            peek += server.getTasks().size();
        }
        if(peek > this.peekClients) {
            this.peekClients = peek;
            this.peekLevel = currentTime;
        }
    }
    public void folderWrite()
    {
        try{
            FileWriter fw = new FileWriter("C:\\Users\\catal\\Desktop\\TEST3.txt");
            fw.write(this.frame.getTextArea1().getText());
            fw.close();
        }catch(Exception e){System.out.println(e);}
    }
}


