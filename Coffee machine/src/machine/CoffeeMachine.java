package machine;

//import javax.swing.*;
import java.util.Scanner;

public class CoffeeMachine {
    static class machine {
        private int water;
        private int milk;
        private int beans;
        private int cups;
        private int money;

        public machine(int water, int milk, int beans, int cups, int money) {
            this.water = water;
            this.milk = milk;
            this.beans = beans;
            this.cups = cups;
            this.money = money;
        }

        public void remaining() {
            System.out.println();
            System.out.println("The coffee machine has:");
            System.out.printf("%d ml of water%n", water);
            System.out.printf("%d ml of milk%n", milk);
            System.out.printf("%d g of coffee beans%n", beans);
            System.out.printf("%d disposable cups%n", cups);
            System.out.printf("$%d of money%n", money);
        }
        public void take() {
            System.out.println();
            System.out.printf("I gave you $%d%n", money);
            money = 0;
        }
        public void fill(int water, int milk, int beans, int cups) {
            this.water += water;
            this.milk += milk;
            this.beans += beans;
            this.cups += cups;
        }

        public void buy(String choose) {
            if (choose.equals("1")) {
                if (water < 250 || beans < 16 || cups <1) {
                    if (water < 250) {
                        System.out.println("Sorry, not enough water!");
                    } else if (beans < 16) {
                        System.out.println("Sorry, not enough beans!");
                    } else {
                        System.out.println("Sorry, not enough cups!");
                    }

                } else {
                    water -= 250;
                    beans -= 16;
                    cups--;
                    money += 4;
                    System.out.println("I have enough resources, making you a coffee!");
                }

            } else if (choose.equals("2")) {
                if (water < 350 || beans < 20 || cups <1 || milk < 75) {
                    if (water < 350) {
                        System.out.println("Sorry, not enough water!");
                    } else if (beans < 20) {
                        System.out.println("Sorry, not enough beans!");
                    } else if (milk < 75) {
                        System.out.println("Sorry, not enough milk!");
                    } else {
                        System.out.println("Sorry, not enough cups!");
                    }
                } else {
                    water -= 350;
                    milk -= 75;
                    beans -= 20;
                    cups--;
                    money += 7;
                    System.out.println("I have enough resources, making you a coffee!");
                }
            } else if (choose.equals("3")){
                if (water < 200 || beans < 12 || cups < 1 || milk < 100) {
                    if (water < 200) {
                        System.out.println("Sorry, not enough water!");
                    } else if (beans < 12) {
                        System.out.println("Sorry, not enough beans!");
                    } else if (milk < 100) {
                        System.out.println("Sorry, not enough milk!");
                    } else {
                        System.out.println("Sorry, not enough cups!");
                    }
                } else {
                    water -= 200;
                    milk -= 100;
                    beans -= 12;
                    cups--;
                    money += 6;
                    System.out.println("I have enough resources, making you a coffee!");
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        machine m = new machine(400,540,120,9,550);
        String s = "";
        while (!s.equals("exit")) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            s = scanner.next();
            if (s.equals("remaining")) {
                m.remaining();
            } else if(s.equals("take")) {
                m.take();
            } else if(s.equals("buy")) {
                System.out.println();
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
                String choose = scanner.next();
                m.buy(choose);
            } else if(s.equals("fill")) {
                System.out.println();
                int add1, add2, add3, add4;
                System.out.println("Write how many ml of water you want to add: ");
                add1 = scanner.nextInt();
                System.out.println("Write how many ml of milk you want to add: ");
                add2 = scanner.nextInt();
                System.out.println("Write how many grams of coffee beans you want to add: ");
                add3 = scanner.nextInt();
                System.out.println("Write how many disposable cups you want to add: ");
                add4 = scanner.nextInt();
                m.fill(add1, add2, add3, add4);
            }
            System.out.println();
        }
    }


}
