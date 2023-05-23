package myshop;

import java.util.ArrayList;

public class Cart {
	private ArrayList<String> items;
    private double total = 0;
    private double taxRate = 0.1;
    
    
    public Cart(){
        this.items = new ArrayList<>();    
    }

    public void addItem(String item){
        items.add(item);
    }
    
    public ArrayList<String> showDetails(){
        return items;
    }
    
    public void addTotal(double price){
        total += price;
    }
    
    public double getPreTaxTotal(){
        return total;
    }
    
    public double getPostTaxTotal(){
        return total-(total*taxRate);
    }
    
    public void emptyCart(){
        for(int i = 0; i <=items.size(); i++){
            items.remove(i);
        }
        
    }
    
    public void checkOut(){
        emptyCart();
    }
}
