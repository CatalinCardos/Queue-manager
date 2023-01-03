package Model;

public class Task implements Comparable<Task> {
    private final int id;
    private final int arrivalTime;
    private final int serviceTime;

    public Task(int id, int arrivalTime, int serviceTime) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.serviceTime = serviceTime;
    }

    public int getId() {
        return id;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    @Override
    public int compareTo(Task o) {
        if(o.getArrivalTime() > this.getArrivalTime())
        {
            return -1;
        }
        else{
            return 1;
        }

    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", arrivalTime=" + arrivalTime +
                ", serviceTime=" + serviceTime +
                '}';
    }
}
