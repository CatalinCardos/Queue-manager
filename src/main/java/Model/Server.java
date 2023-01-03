package Model;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Server implements Runnable{
    private BlockingQueue<Task> tasks;
    private AtomicInteger waitingPeriod;

    public Server(int size) {
        tasks = new ArrayBlockingQueue<Task>(size);
        waitingPeriod = new AtomicInteger();
        waitingPeriod.set(0);
    }

    public void addTask(Task newTask){
        this.tasks.add(newTask);
        waitingPeriod.addAndGet(newTask.getServiceTime());
    }

    @Override
    public void run() {
        while(true)
        {
            if(tasks.size() != 0)
            {
                Task aux = this.tasks.peek();
                try {
                    Thread.sleep(aux.getServiceTime()* 1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.tasks.remove();
                this.waitingPeriod.set(waitingPeriod.get() - aux.getServiceTime());
            }

        }
    }

    public BlockingQueue<Task> getTasks() {
        return tasks;
    }

    public void setTasks(BlockingQueue<Task> tasks) {
        this.tasks = tasks;
    }

    public AtomicInteger getWaitingPeriod() {
        return waitingPeriod;
    }

    public void setWaitingPeriod(AtomicInteger waitingPeriod) {
        this.waitingPeriod = waitingPeriod;
    }
}
