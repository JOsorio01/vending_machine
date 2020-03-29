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
        
        BlockingQueue<Product> queue = new ArrayBlockingQueue<>(6);
        
        final Runnable producer = () -> {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    queue.put(createProduct());
                } catch (InterruptedException ex) {
                    System.out.println(ex);
                }
            }
        };
        new Thread(producer).start();
        
        while (true) {
            int reply = JOptionPane.showConfirmDialog(null, "Order more?",
                    "Title", JOptionPane.YES_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                try {
                    if (!queue.isEmpty()) {
                        Product p = queue.take();
                        process(p);
                    } else {
                        System.out.println("No products!");
                    }
                    
                } catch (InterruptedException ex) {
                    System.out.println(ex);
                }
            }
            else {
               JOptionPane.showMessageDialog(null, "GOODBYE");
               System.exit(0);
            }
        }

    }
    
    public static Product createProduct() {
        return new Product();
    }
    
    public static void process(Product p) {
        System.out.println(p);
    }
    
}
