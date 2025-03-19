import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

// Remember to change to main file from the drop down menu next to file, before running ;)
// Brief Report is attached as a .txt file for this assignment.
/* TODO
 * Ask teacher if there is need to write comments to explain methods,
   Since i am already writing a brief report
*/
public class ProfitTracker
{
    public static void main(String[] args)
    {
        ProfitTracker tracker = new ProfitTracker(); //Create an instance of Profit Tracker
        tracker.setWeeklyGoal(); //Call setWeeklyGoal
        tracker.enterDailyProfits(); //Call enterDailyProfits
        tracker.displayTotalProfit(); //Call displayTotalProfit
        tracker.checkGoalStatus(); //Call checkGoalStatus
    }
    private List<Double> dailyProfits;
    private Scanner in;
    private double weeklyGoal; // Instance variable for weekly goal
    private double weeklyProfit; //Instance variable for weekly profit

    public ProfitTracker()
    {
        this.dailyProfits = new ArrayList<>();
        double weeklyGoal;
        this.in = new Scanner(System.in); // Initialize the scanner
    }

    public void enterDailyProfits()
    {
        System.out.println("Enter daily profits (enter -1 to stop):");

        double profit;
        while (true)
        {
            System.out.print("Profit: ");
            profit = in.nextDouble();

            if (profit == -1)
            {
                break; //Exit the loop if the user enters -1
            }

            dailyProfits.add(profit);
            displayRemainingAmount();
        }
    }
    public void setWeeklyGoal()
    {
        System.out.print("What is the Profit Goal for the week? ");
        this.weeklyGoal = in.nextDouble();

    }
    public void displayTotalProfit()
    {
        double totalProfit = 0;
        for (double profit: dailyProfits)
        {
            totalProfit += profit;
        }
        this.weeklyProfit = totalProfit;
        System.out.println("Total weekly profit $" + totalProfit);
    }
    public void checkGoalStatus()
    {
        if (weeklyProfit > weeklyGoal)
        {
            System.out.println("You passed the weekly goal of $" + weeklyGoal + "! Woohoo!");
        }
        else if (weeklyProfit < weeklyGoal)
        {
            double difference = weeklyGoal - weeklyProfit;
            System.out.println("You needed $" + difference + " more to hit your weekly goal!");
        }
        else
        {
            System.out.println("You hit your weekly goal of $" + weeklyGoal +"! Woohoo!");
        }
    }
    private void displayRemainingAmount()
    {
        double currentTotal = 0;
        for (double profit : dailyProfits)
        {
            currentTotal += profit;
        }

        double remaining = weeklyGoal - currentTotal;
        if (currentTotal > weeklyGoal)
        {
            System.out.println("You have exceeded weekly goal!");
        }
        else if (currentTotal < weeklyGoal)
        {
            System.out.println("Remaining profit needed: $" + remaining);
        }
        else
        {
            System.out.println("You reached your weekly goal!");
        }
    }
}