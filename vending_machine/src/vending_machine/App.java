/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vending_machine;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;

/**
 *
 * @author jose
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        BlockingQueue<Product> queue = new ArrayBlockingQueue<>(10);
        
        Product p1 = new Product("Pizza", 3);
        Product p2 = new Product("HotDog", 2);
        Product p3 = new Product("Hamburguer", 2);
        
        String[] options = {p1.getName(), p2.getName(), p3.getName(), "Exit"};
        
        final Runnable vendingMachine = () -> {
            while (true) {
                Product p;
                try {
                    p = queue.take();
                    TimeUnit.SECONDS.sleep((int) p.getPreparingTime());
                    System.out.println("Your " + p.getName() + " is Ready");
                } catch (InterruptedException ex) {
                    System.out.println(ex);
                }
            }
        };
        new Thread(vendingMachine).start();
        
        final Runnable consumer = () -> {
            while (true) {
                Product p = new Product();
                try {
                    int option = JOptionPane.showOptionDialog(
                            null, "Select what do you want to order", "Order",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                            null, options, options[0]);
                    switch (option) {
                        case 0:
                            p = p1;
                            break;
                        case 1:
                            p = p2;
                            break;
                        case 2:
                            p = p3;
                            break;
                        default:
                            System.exit(0);
                            break;
                    }
                    process(p);
                    queue.put(p);
                } catch (InterruptedException ex) {
                    System.out.println(ex);
                }
            }
        };
        new Thread(consumer).start();

    }
    
    public static void process(Product p) {
        System.out.println("Preparing " + p.getName());
    }
    
}
