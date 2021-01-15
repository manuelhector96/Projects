import java.util.Scanner;

public class CoffeeMachine {

        public static void main(String[] args) {
            greeting();
            action();
        }
        static void greeting(){
            System.out.println("Starting to make a coffee");
            System.out.println("Grinding coffee beans");
            System.out.println("Boiling water");
            System.out.println("Mixing boiled water with crushed coffee beans");
            System.out.println("Pouring coffee into the cup");
            System.out.println("Pouring some milk into the cup");
            System.out.println("Coffee is ready!");
        }

        static void cupsOfCoffee(){
            /**
             * One cup of coffee is
             *  200mL of water
             *  50mL of milk
             *  15g of coffee
             **/

            System.out.println("Write how many cups of coffee you will need:");
            Scanner sc = new Scanner(System.in);
            int cups = sc.nextInt();
            int water = cups * 200;
            int milk = cups * 50;
            int coffee = cups * 15;
            System.out.println("For " + cups + "you will need:" + "\n"
                    + water + " ml of water" + "\n"
                    + milk + " ml of milk" + "\n"
                    + coffee + " g of coffee beans");
        }

        static void cupsOfCoffee2(){
            Scanner sc = new Scanner(System.in);
            System.out.println("Write how many ml of water the machine has:");
            int water = sc.nextInt();

            System.out.println("Write how many ml of milk the machine has:");
            int milk = sc.nextInt();

            System.out.println("Write how many grams of coffee beans the machine has:");
            int coffee = sc.nextInt();

            System.out.println("Write how many cups of coffee you will need:");
            int cups = sc.nextInt();

            cupsMade(water, milk, coffee, cups);
        }

        static void cupsMade(int w, int m, int c, int n){
            int wleft, mleft, cleft = 0;
            int count = 0;
            int rcups = 0;
            while(w != 0 || m != 0 || c != 0){
                if(w >= 200 && m >= 50 && c >= 15){
                    wleft = w - 200;
                    mleft = m - 50;
                    cleft = c - 15;
                    count++;
                    w = wleft;
                    m = mleft;
                    c = cleft;
                    if(count > n ){
                        rcups++;
                    }
                } else if(count < n){
                    System.out.println("No, I can make only " + count + " cup(s) of coffee");
                    break;
                } else if(count == n && rcups == 0){
                    System.out.println("Yes, I can make that amount of coffee");
                    break;
                } else if(count >= n && rcups != 0) {
                    System.out.println("Yes, I can make that amount of coffee (and even " + rcups + " more than that");
                    break;
                }
            }
        }

        /**
         * Method to interact with the machine
         *
         * User will choose from various options where can fill inventory, buy drinks, or check inventory, or take cash out
         **/

        static void action() {
            int water = 400;
            int milk = 540;
            int coffee = 120;
            int cups = 9;
            int money = 550;

            Scanner sc = new Scanner(System.in);
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String str = sc.nextLine();
            while(!str.equals("exit")) {
                switch (str) {
                    case "buy":
                        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                        String input = sc.nextLine();
                        try {
                            int buy = Integer.parseInt(input);
                            switch (buy) {
                                case 1:
                                    if(water < 250 ){
                                        System.out.println("Sorry, not enough water!");
                                    } else if(coffee < 16){
                                        System.out.println("Sorry, not enough coffee!");
                                    }
                                    else{
                                        water = water - 250;
                                        coffee = coffee - 16;
                                        cups = cups - 1;
                                        money = money + 4;
                                        System.out.println("I have enough resources, making you a coffee!");
                                    }
                                    break;
                                case 2:
                                    if(water < 250){
                                        System.out.println("Sorry, not enough water!");
                                    }
                                    else if((milk < 75)){
                                        System.out.println("Sorry, not enough milk!");
                                    }
                                    else if(coffee < 20){
                                        System.out.println("Sorry, not enough coffee!");
                                    }
                                    else{
                                        water = water - 350;
                                        milk = milk - 75;
                                        coffee = coffee - 20;
                                        cups = cups - 1;
                                        money = money + 7;
                                        System.out.println("I have enough resources, making you a coffee!");
                                    }
                                    break;
                                case 3:
                                    if(water < 200){
                                        System.out.println("Sorry, not enough water!");
                                    }
                                    else if(milk < 100){
                                        System.out.println("Sorry, not enough milk!");
                                    }
                                    else if(coffee < 12){
                                        System.out.println("Sorry, not enough coffee!");
                                    }
                                    else {
                                        water = water - 200;
                                        milk = milk - 100;
                                        coffee = coffee - 12;
                                        cups = cups - 1;
                                        money = money + 6;
                                        System.out.println("Sorry, not enough milk!");
                                    }
                                    break;
                            }
                        }
                        catch(Exception e) {
                            System.out.println("Write action (buy, fill, take, remaining, exit):");
                            break;
                        }
                        System.out.println("Write action (buy, fill, take, remaining, exit):");
                        break;

                    case "fill":
                        int addWater, addMilk, addCoffee, addCups;
                        System.out.println("Write how many ml of water do you want to add:");
                        addWater = sc.nextInt();
                        water += addWater;
                        System.out.println("Write how many ml of milk do you want to add:");
                        addMilk = sc.nextInt();
                        milk += addMilk;
                        System.out.println("Write how many grams of coffee beans do you want to add:");
                        addCoffee = sc.nextInt();
                        coffee += addCoffee;
                        System.out.println("Write how many disposable cups of coffee do you want to add");
                        addCups = sc.nextInt();
                        cups += addCups;
                        break;

                    case "take":
                        System.out.println("I gave you $" + money);
                        money -= money;
                        break;

                    case "remaining":
                        System.out.println("The coffee machine has:");
                        System.out.println(water + " of water");
                        System.out.println(milk + " of milk");
                        System.out.println(coffee + " of coffee beans");
                        System.out.println(cups + " of disposable cups");
                        System.out.println(money + " of money");
                        System.out.println("Write action (buy, fill, take, remaining, exit):");
                        break;
                }
                str = sc.nextLine();
            }
        }
    }

