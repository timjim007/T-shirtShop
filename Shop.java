package myshop;

public class Shop {
	private String name;
    private Product products;
    public Shop(){
    
    }
    
    /**Class constructor
    */
    public Shop(String name,Product products){
        this.name = name;
        this.products = products;
    }
    
    /**
    *Gets name of shop
    */
    public String getName(){
        return name;
    }
     
    /**
    * Prints Products.
    */
    public void printProducts(){
        System.out.println("--Products--");
        
        for(int i: products.getID()){
            System.out.print("ID "+ products.getID().get(i) + ": ");
            System.out.println(products.getName().get(i) + " - $" + products.getPrice().get(i));
        }
    }
    
     /**
    *Find product index from name.
    */
    public int findProduct(String searchText){
        for(int i: products.getID()){
            String product = products.getName().get(i);
            
            if(product.equals(searchText)){
                return i;
            }
        }
        return -1;
    }
    
    /**
    *Find productName from Id
    */
     public String findProductName(int searchID){
        for(int i: products.getID()){
            int product = products.getID().get(i);
            
            if(product == searchID){
                return products.getName().get(searchID);
            }
            
        }
        return "";
    }
    
    /**
    *Find the product price from id
    */
    public double getProductPrice(int searchID){
        for(int i: products.getID()){
            int product = products.getID().get(i);
            
            if(product == searchID){
                return products.getPrice().get(searchID);
            }
            
        }
        return 0.0;
    }
}
