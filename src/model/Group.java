package model;
import java.util.HashSet;

public class Group {
    private String name;
    private HashSet<Product> products;
    public Group(String name){
        this.name = name;
        products = new HashSet<Product>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public ISetModifier<Product> getProductsModifier(){
        return new ProductsModifier();
    }

    private class ProductsModifier implements ISetModifier<Product> {

        @Override
        public void add(Product product) {
            products.add(product);
        }

        @Override
        public void remove(String name) {
            try {
                products.remove(new Product(name,0,0));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public void edit(String  name, Product newProduct) {
            remove(name);
            products.add(newProduct);
        }
    }
}
