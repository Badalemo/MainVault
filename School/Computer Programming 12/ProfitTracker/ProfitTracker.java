import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

// Remember to change to main file from the drop down menu next to file, before running ;)
// Brief Report is attached as a .txt file for this assignment.
/* TODO
 * Ask teacher if there is need to write comments to explain methods,
   Since i am already writing a brief report
*/

/*INTRODUCED IN PART 1
 * The class ProfitTracker is used to track the profits of a business for a week.
 * Before calling methods, i made a list called dailyProfits, and a scanner called in.
 * In Part 1, the class was created with the following methods:
 * 1. enterDailyProfits - This method prompts the user to enter daily profits until the user enters -1.
 * 2. displayTotalProfit - This method calculates and displays the total weekly profit.
*/

/*INTRODUCED IN PART 2
 * Before adding the new methods, I added an instance variable for weekly goal.
 * In part 2, the ProfitTracker class was updated with the following methods:
 * 1. setWeeklyGoal - This method prompts the user to enter the weekly profit goal.
 * 2. checkGoalStatus - This method checks if the weekly profit goal was met and displays a message accordingly.
*/

/*INTRODUCED IN PART 3
 * I added an instance variable for weekly profit.
 * In part 3, the ProfitTracker class was updated with the following methods:
 * 1. displayRemainingAmount - This method calculates and displays the remaining profit needed to reach the weekly goal.
 * 2. I updated the enterDailyProfits method to call the displayRemainingAmount method after each daily profit is entered.
*/

public class ProfitTracker {
    public static void main(String[] args) {
        ProfitTracker tracker = new ProfitTracker(); // Create an instance of Profit Tracker
        tracker.setWeeklyGoal(); // Call setWeeklyGoal
        tracker.enterDailyProfits(); // Call enterDailyProfits
        tracker.displayTotalProfit(); // Call displayTotalProfit
        tracker.checkGoalStatus(); // Call checkGoalStatus
    }

    private List<Double> dailyProfits;
    private Scanner in;
    private double weeklyGoal; // Instance variable for weekly goal
    private double weeklyProfit; // Instance variable for weekly profit

    public ProfitTracker() {
        this.dailyProfits = new ArrayList<>();
        double weeklyGoal;
        this.in = new Scanner(System.in); // Initialize the scanner
    }

    public void enterDailyProfits() {
        System.out.println("Enter daily profits (enter -1 to stop):");

        double profit;
        while (true) {
            System.out.print("Profit: ");
            profit = in.nextDouble();

            if (profit == -1) {
                break; // Exit the loop if the user enters -1
            }

            dailyProfits.add(profit);
            displayRemainingAmount();
        }
    }

    public void setWeeklyGoal() {
        System.out.print("What is the Profit Goal for the week? ");
        this.weeklyGoal = in.nextDouble();

    }

    public void displayTotalProfit() {
        double totalProfit = 0;
        for (double profit : dailyProfits) {
            totalProfit += profit;
        }
        this.weeklyProfit = totalProfit;
        System.out.println("Total weekly profit $" + totalProfit);
    }

    public void checkGoalStatus() {
        if (weeklyProfit > weeklyGoal) {
            System.out.println("You passed the weekly goal of $" + weeklyGoal + "! Woohoo!");
        } else if (weeklyProfit < weeklyGoal) {
            double difference = weeklyGoal - weeklyProfit;
            System.out.println("You needed $" + difference + " more to hit your weekly goal!");
        } else {
            System.out.println("You hit your weekly goal of $" + weeklyGoal + "! Woohoo!");
        }
    }

    private void displayRemainingAmount() {
        double currentTotal = 0;
        for (double profit : dailyProfits) {
            currentTotal += profit;
        }

        double remaining = weeklyGoal - currentTotal;
        if (currentTotal > weeklyGoal) {
            System.out.println("You have exceeded weekly goal!");
        } else if (currentTotal < weeklyGoal) {
            System.out.println("Remaining profit needed: $" + remaining);
        } else {
            System.out.println("You reached your weekly goal!");
        }
    }
}