package View;

import javax.swing.*;
import java.awt.event.ActionListener;

public class GuiThreads {
    private JPanel panel1;
    private JButton enterButton;
    private JComboBox comboBoxClients;
    private JComboBox comboBoxQueues;
    private JComboBox comboBoxMaxTimeSim;
    private JComboBox comboBoxMinArrival;
    private JComboBox comboBoxMinService;
    private JComboBox comboBoxMaxArrival;
    private JComboBox comboBoxMaxService;
    private JTextArea textArea1;

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public void addEnterButtonListener(ActionListener mal){enterButton.addActionListener(mal);}
    public void addcomboBoxClientsListener(ActionListener mal){comboBoxClients.addActionListener(mal);}
    public void addcomboBoxQueuesListener(ActionListener mal){comboBoxQueues.addActionListener(mal);}
    public void addcomboBoxMaxTimeSimListener(ActionListener mal){comboBoxMaxTimeSim.addActionListener(mal);}
    public void addcomboBoxMinArrivalListener(ActionListener mal){comboBoxMinArrival.addActionListener(mal);}
    public void addcomboBoxMinServiceListener(ActionListener mal){comboBoxMinService.addActionListener(mal);}
    public void addcomboBoxMaxArrivalListener(ActionListener mal){comboBoxMaxArrival.addActionListener(mal);}
    public void addcomboBoxMaxServiceListener(ActionListener mal){comboBoxMaxService.addActionListener(mal);}

    public JButton getEnterButton() {
        return enterButton;
    }

    public void setEnterButton(JButton enterButton) {
        this.enterButton = enterButton;
    }

    public JComboBox getComboBoxClients() {
        return comboBoxClients;
    }

    public void setComboBoxClients(JComboBox comboBoxClients) {
        this.comboBoxClients = comboBoxClients;
    }

    public JComboBox getComboBoxQueues() {
        return comboBoxQueues;
    }

    public void setComboBoxQueues(JComboBox comboBoxQueues) {
        this.comboBoxQueues = comboBoxQueues;
    }

    public JComboBox getComboBoxMaxTimeSim() {
        return comboBoxMaxTimeSim;
    }

    public void setComboBoxMaxTimeSim(JComboBox comboBoxMaxTimeSim) {
        this.comboBoxMaxTimeSim = comboBoxMaxTimeSim;
    }

    public JComboBox getComboBoxMinArrival() {
        return comboBoxMinArrival;
    }

    public void setComboBoxMinArrival(JComboBox comboBoxMinArrival) {
        this.comboBoxMinArrival = comboBoxMinArrival;
    }

    public JComboBox getComboBoxMinService() {
        return comboBoxMinService;
    }

    public void setComboBoxMinService(JComboBox comboBoxMinService) {
        this.comboBoxMinService = comboBoxMinService;
    }

    public JComboBox getComboBoxMaxArrival() {
        return comboBoxMaxArrival;
    }

    public void setComboBoxMaxArrival(JComboBox comboBoxMaxArrival) {
        this.comboBoxMaxArrival = comboBoxMaxArrival;
    }

    public JComboBox getComboBoxMaxService() {
        return comboBoxMaxService;
    }

    public void setComboBoxMaxService(JComboBox comboBoxMaxService) {
        this.comboBoxMaxService = comboBoxMaxService;
    }

    public JTextArea getTextArea1() {
        return textArea1;
    }

    public void setTextArea1(JTextArea textArea1) {
        this.textArea1 = textArea1;
    }
}
