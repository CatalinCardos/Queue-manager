package Controller;

import Model.Task;
import View.GuiThreads;

import javax.swing.*;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Main  {

public static void main(String[]args) throws InterruptedException{
        GuiThreads panel = new GuiThreads();
        MainController mainController = new MainController(panel);


        }

}
