package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import model.Product;
import model.ProductDAO;

public class ProcessStock extends Thread
{
	ProductDAO pdao;
	private List <Product> products;
    
	public ProcessStock(ProductDAO pdao) 
    {
        this.pdao = pdao;
        this.products = new ArrayList<>();
    }
	
	public void run() {
        while (true) {
            try {
                products = pdao.readerProducts();

                List<Product> lowStockProducts = new ArrayList<>();
                for (Product p : products) {
                    if (p.getStock() <= 5) {
                        lowStockProducts.add(p);
                    }
                }

                if (!lowStockProducts.isEmpty()) {
                    SwingUtilities.invokeLater(() -> {
                        StringBuilder message = new StringBuilder("Los siguientes productos tienen un stock inferior a 5:\n");
                        for (Product p : lowStockProducts) {
                            message.append(p.getName()).append(": ").append(p.getStock()).append("\n");
                        }
                        JOptionPane.showMessageDialog(null, message.toString(), "Advertencia de Stock", JOptionPane.WARNING_MESSAGE);
                    });
                }

                // Pausa de 10 segundos antes de la siguiente verificación
                Thread.sleep(10000);

            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
