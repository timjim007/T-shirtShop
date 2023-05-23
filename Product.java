package myshop;

import java.util.ArrayList;

public class Product {
	private ArrayList<Integer> id;
    private ArrayList<String> name;
    private ArrayList<Double> price;

    //Class Constructor
    public Product(ArrayList<Integer> id, ArrayList<String> name, ArrayList<Double> price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    //Methods
    public ArrayList<Integer> getID(){
        return id;
    }
    
    public ArrayList<String> getName(){
        return name;
    }

    public ArrayList<Double> getPrice(){
        return price;
    }

}
