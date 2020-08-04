package machine;
import java.util.*;
public class CoffeeMachine {
    private int water=400, milk=540, beans=120, cup=9,money=550;
    private static Scanner sc = new Scanner(System.in);
    private void printState()
    {
        System.out.println("The coffee machine has:");
        System.out.println(water+" of water");
        System.out.println(milk+" of milk");
        System.out.println(beans+" of coffee beans");
        System.out.println(cup + " of disposable cups");
        System.out.println(money+ " of money");
    }
    private void checkBuy(int water,int milk, int beans,int money)
    {
        if(this.water>=water)
        {
            if(this.milk>=milk)
            {
                if(this.beans>=beans)
                {
                    System.out.println("I have enough resources, making you a coffee!");
                    this.water -= water;
                    this.milk -= milk;
                    this.beans -= beans;
                    this.money += money;
                    cup -= 1;
                }
                else
                System.out.println("Sorry, not enough coffee beans");
            }
            else
            System.out.println("Sorry, not enough milk!");
        }
        else
        System.out.println("Sorry, not enough water!");
    }
    private void buy()
    {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: back - to main menu: ");
        String choice = sc.next();
        if(choice.equalsIgnoreCase("back"))
        return;
        int option = Integer.parseInt(choice);
        switch(option)
        {
            case 1:
                checkBuy(250,0,16,4);
                break;
            case 2:
                checkBuy(350,75,20,7);
                break;
            case 3:
                checkBuy(200,100,12,6);
                break;
        }
    }
    private void fill()
    {
        System.out.println("Write how many ml of water do you want to add: ");
        water += sc.nextInt();
        System.out.println("Write how many ml of milk do you want to add: ");
        milk += sc.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add: ");
        beans += sc.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        cup += sc.nextInt();
    }
    private void take()
    {
        System.out.println("I gave you " + money);
        money = 0;
    }
    
    public static void main(String[] args) {
        CoffeeMachine machine = new CoffeeMachine();
        String action;
        do
        {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            action = sc.next().toLowerCase();
            switch(action)
            {
                case "buy":
                    machine.buy();
                    break;
                case "fill":
                    machine.fill();
                    break;
                case "take":
                    machine.take();
                    break;
                case "remaining":
                    machine.printState();
                    break;
            }
        }while(!action.equals("exit"));
    }
}
