package Controller;

import View.GuiThreads;
import com.sun.jdi.Value;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;

public class MainController {
    private GuiThreads frame;
    private int clients;
    private int queues;
    private int maxTimeSim;
    private int minArrival;
    private int maxArrival;
    private int minService;
    private int maxService;
    public MainController(GuiThreads frame) {
        this.frame = frame;

        frame.addcomboBoxClientsListener(new MainController.ComboBoxClients());
        frame.addcomboBoxQueuesListener(new MainController.ComboBoxQueues());
        frame.addcomboBoxMaxTimeSimListener(new MainController.ComboBoxMaxTimeSim());
        frame.addcomboBoxMinArrivalListener(new MainController.ComboBoxMinArrival());
        frame.addcomboBoxMaxArrivalListener(new MainController.ComboBoxMaxArrival());
        frame.addcomboBoxMinServiceListener(new MainController.ComboBoxMinService());
        frame.addcomboBoxMaxServiceListener(new MainController.ComboBoxMaxService());
        frame.addEnterButtonListener(new MainController.EnterButton());
        JFrame mainPage;
        mainPage = new JFrame("Threads");
        mainPage.setContentPane(frame.getPanel1());
        mainPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPage.pack();
        mainPage.setVisible(true);

    }

    class ComboBoxClients implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            clients = Integer.parseInt(frame.getComboBoxClients().getSelectedItem().toString());
        }
    }

    class ComboBoxQueues implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            queues = Integer.parseInt(frame.getComboBoxQueues().getSelectedItem().toString());

        }
    }

    class ComboBoxMaxTimeSim implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            maxTimeSim = Integer.parseInt(frame.getComboBoxMaxTimeSim().getSelectedItem().toString());
        }
    }

    class ComboBoxMinArrival implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            minArrival = Integer.parseInt(frame.getComboBoxMinArrival().getSelectedItem().toString());
        }
    }

    class ComboBoxMaxArrival implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            maxArrival = Integer.parseInt(frame.getComboBoxMaxArrival().getSelectedItem().toString());
        }
    }

    class ComboBoxMinService implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            minService = Integer.parseInt(frame.getComboBoxMinService().getSelectedItem().toString());
        }
    }

    class ComboBoxMaxService implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            maxService = Integer.parseInt(frame.getComboBoxMaxService().getSelectedItem().toString());
        }
    }

    class EnterButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            SimulationManager manager = new SimulationManager(clients,queues,maxTimeSim,minArrival,maxArrival,minService,maxService,frame);
            Thread t = new Thread(manager);
            t.start();


        }
    }
}
