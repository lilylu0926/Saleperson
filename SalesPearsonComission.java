
/*
 * About this program: Use the JOptionPane to show the dialog. Calculate the yearly income(commission)
 * based on monthly sale.
 * If the monthly income is more than 15,000, the current month is finish and go to the next month.
 * If the yearly income is more than 100,000, this year you achieve the goal and holiday begin.
 * If the yearly income is less than 100,000, suggest take vocation in Montreal try next year.
 * result is out and tell the salesperson program will exit .
 */
import javax.swing.JOptionPane;
public class Assignment3 {
    public static void main(String[] args) {
        Assignment3 assignment3 = new Assignment3();
        assignment3.beginning();
    }

    /*Declare control variables for the outer loop.
     *parameter transaction_amount
     *return to a double number with two decimal
     */
    public double round2Decimal (double transaction_amount){
     return (double) Math.round( transaction_amount * 100) / 100;
    }


    /*monthly incomes base on monthly sales
     * if sales amount <=10,000. The commission rate is 0.1 (full commission is 1000).
     * if sales amount >= 10,000.01 && <= 30,000. The commission rate is 0.15 (full commission is 3000).
     * if sales amount >= 30,000.01.The commission rate is 0.2
     */
    public double calIncome(double monthlySales ){
        if (monthlySales >= 0 && monthlySales <= 10000){
            return round2Decimal(monthlySales *0.1);
        }else if (monthlySales >= 10000.01 && monthlySales <= 30000 ) {
            return round2Decimal((monthlySales - 10000) * 0.15 + 1000);
        }else return round2Decimal((monthlySales -30000)*0.2 + 4000);
    }

    public double calMonthlyIncome() {
        double monthSales = 0;
        double monthlyIncome = 0;

        //if the monthly income less than 15000, go to next month
        while (monthlyIncome <= 15000) {
            // show the dialog for answer yes or no question
            int newCustomer = JOptionPane.showConfirmDialog(null, "Do you hava a customer ?");
            if (newCustomer == JOptionPane.YES_OPTION) {
                //show welcome massage
                System.out.println("Welcome to Lili store");
                double transaction_amount = round2Decimal(Math.random() * 50000);
                //show the following massage
                int transAnswer = JOptionPane.showConfirmDialog(null, "Those items cost $" + transaction_amount + "Do you buy ?");
                if (transAnswer == JOptionPane.YES_OPTION){
                    System.out.println("Thanks for transaction amount $ " + transaction_amount);

                    //
                    monthSales += transaction_amount;
                    monthlyIncome = calIncome(monthSales);
                } else{
                    System.out.println("OK, See you next time.");
                }

            }else{
                break;
                }

       }System.out.println("You commission pay for this month is $ "+ monthlyIncome);
        return monthlyIncome;
    }
    
     //for Annual income
 
    public void beginning( ){

        String [] monthCount = {"January","February","March","April","May","June","July","August","September","October"
                               ,"November","December"};
        double annualIncome = 0;
        for (int i = 0 ; i < 12; i++){
            System.out.println("Welcome to" + " " + monthCount[i]);
            annualIncome += calMonthlyIncome();

            if (annualIncome >= 100000) {
                System.out.println("You earning for this year = $" + round2Decimal(annualIncome));
                System.out.println("Welcome to Honolulu ! Enjoy the rest of this year !");
            }
    }if (annualIncome < 100000){
            System.out.println("You earning for this year = $"+ round2Decimal(annualIncome));
            System.out.println("Enjoy the vocation in Montreal!");
        }
        System.out.println();
        System.exit(0);
    }

}
