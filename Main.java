package myshop;

import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Main{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  Product products = new Product(new ArrayList<Integer>(Arrays.asList(0,1,2,3,4)),
                  new ArrayList<String>(Arrays.asList("Crew Neck", "V-Neck", "Polo", "Boat Neck", "Tank Top")),
                  new ArrayList<Double>(Arrays.asList(20.00,20.00,20.00,20.00,20.00)));

		  Menu menu = new Menu(new Scanner(new InputStreamReader(System.in, Charset.forName("UTF-8"))),
				  new Shop("T-Shirt Mart",products),new Cart());

		  menu.greet();
		  menu.executeMenu();
	}

}
