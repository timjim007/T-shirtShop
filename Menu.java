package myshop;

import java.util.Scanner;

public class Menu {
	private Shop shop;
    private Cart cart;
    private String[] menuOptions = {"Exit", "List Products", "Buy Product", "Find Product", "Show Cart", "Checkout"};
    private Scanner scanner;
    
    public Menu(Scanner scanner, Shop shop,Cart cart) {
        this.scanner = scanner;
        this.shop = shop;
        this.cart = cart;
    }
   
    public void executeMenu(){   
        while(true){
                printMenu();
                int num = getNextIntFromUser();
                if(num == 1){
                    shop.printProducts();
                    executeMenu();
                    break;
                    
                }
                else if(num == 2){
                    addToCart();
                    executeMenu();
                    break;
                    
                }
                
                else if(num == 3){
                    findProduct();
                    executeMenu();
                    break;
                }
                
                else if(num == 4){
                    showCart();
                    executeMenu();
                    break;
                }
                
                else if(num == 5){
                    if(cart.showDetails().isEmpty()){
                      System.out.println("Your cart is currently empty. Please add at least one product to check out.");
                        executeMenu();
                        break;
                    }
                    cart.checkOut();
                    System.out.println(String.format("Your total is "+"%c"+"%.2f",'$',cart.getPostTaxTotal()));
                    System.out.println("Thank you for shopping at T-Shirt Mart.");
                    executeMenu();
                    exit();
                    break;
                }
                
                else if(num == 0){
                    System.out.println("Exiting now. Goodbye.");
                    exit();
                    break;
                }
                
                else{
                    System.out.println("Exiting now. Goodbye.");
                    exit();
                    break;

                }

            }
            
                   
        }

        /**
         * Asks the user to enter their name.
         * After the user provides their name, it outputs a greeting to the user to standard out.
         */
        public void greet() {
            System.out.print("Hello. Please enter your name:\n");
            String name = scanner.nextLine();
            
            System.out.println("Welcome " + name + " to " + shop.getName());
        }

        /**
         * Prints the menu header and menu options.
         */
        private void printMenu() {
            System.out.println();
            System.out.println("--Main Menu--");
            System.out.println("Select an option using one of the numbers shown");
            System.out.println();

            for(int i = 0; i < menuOptions.length; i++) {
                System.out.print(i + ": ");
                System.out.println(menuOptions[i]);
            }
        }
        
       /**
       *Adds item to cart
       */
        private void addToCart(){
            while(true){
                System.out.println("Please enter the ID of the product you would like to purchase:");
                int itemID = getNextIntFromUser();
                String itemFound = shop.findProductName(itemID);

                  if(itemFound.isEmpty()){
                      System.out.println("That item ID is invalid and could not be added to the cart.");
                      break;

                   }
                cart.addItem(itemFound);
                cart.addTotal(shop.getProductPrice(itemID));
                System.out.println(itemFound+" has been added to your cart.");
                break;
            }
        }
        
        /**
        Finds product
        **/
        private void findProduct(){
               System.out.println("Enter the item to search for:");
               String itemToFind = getNextStringLineFromUser();
               int itemIndex = shop.findProduct(itemToFind);

                 if(itemIndex == -1){
                     System.out.println("That product was not found.");
                   }
                 else{
                     System.out.println(itemToFind + " was found and its product id is "+ itemIndex);
                   }
        }
        
        /**
        Show contents of cart
        */
        private void showCart(){
            while(true){
                 if (cart.showDetails().isEmpty()){
                        System.out.println("The cart is empty. Please add at least one product to see it in the cart.");
                       break;
                        }

                        System.out.println("--Cart--");
                        System.out.println("Item Count: "+ cart.showDetails().size());
                        System.out.println(String.format("Items:"));
                        for(String item : cart.showDetails()){

                            System.out.println(String.format(item +": " +"%c"+"%.2f",'$',shop.getProductPrice(shop.findProduct(item)))); 
                        }

                        System.out.println(String.format("%nPre-Tax Total: " +"%c"+"%.2f%nPost-Tax Total (10.00"+"%c"+" Tax): "+"%c"+"%.2f",'$',cart.getPreTaxTotal(),'%','$',cart.getPostTaxTotal()));     
                break;
            }  
        }
        /**
         * Prints an exit statement and closes the scanner object.
         */
        private void exit() {
            scanner.close();
        }

        /**
         * Collects next user-entered int.
         * @return integer value denoting the user selection
         */
        private int getNextIntFromUser() {
            return scanner.nextInt();
        }
         
        
        /**
         * Skips a line of empty input from the scanner's input stream
         * and then returns the next available line.
         * @return string representing the line of input typed by the user
         */
        private String getNextStringLineFromUser() {
            scanner.nextLine();
            return scanner.nextLine();
        }
        
       
    
}
