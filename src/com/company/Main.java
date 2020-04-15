import java.io.IOException;
import java.util.Iterator;

import model.Group;
import model.ISetModifier;
import model.Product;
import view.MainFrame;
public class Main {
    public static void main(String[] args) throws IOException {
        /*MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
        mainFrame.setSize(800,600);*/
        Group group = new Group("fruits");
        ISetModifier<Product> modifier = group.getProductsModifier();
        try {
            modifier.add(new Product("apple","good apple",0,0));
            for (Iterator<Product> it = group.getIterator(); it.hasNext(); ) {
                Product product = it.next();
                System.out.println(product.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
