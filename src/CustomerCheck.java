
import java.util.ArrayList;

public class CustomerCheck
{
    /** The check for a customer or group of customers
     *  Guaranteed to contain at least one MenuItem and all entries are non-null
     */
    private ArrayList<MenuItem> check;

    /* Constructor */
    public CustomerCheck(ArrayList<MenuItem> check)
    {
        this.check = check;
    }

    /** Returns the total of all MenuItem prices on the check,
     *  as described in part (a)
     */
    public double totalPrices()
    {
        /* to be implemented in part (a) */
        double sum = 0;
        for (MenuItem item: check){
            sum += item.getPrice();
        }
        return sum;
    }

    /** Returns true if the restaurant’s coupon offer can be applied to this check and
     *  returns false otherwise, as described in part (b) */
    public boolean couponApplies()
    {
        /* to be implemented in part (b) */
        boolean applies = true;
        for (MenuItem item: check){
            if (item.isDailySpecial()){
                applies = false;
            }
        }
        if (totalPrices() < 40){
            applies = false;
        }
        return applies;
    }

    /** Calculates the final cost of this check, as described in part (c) */
    public double calculateCheck()
    {
        /* to be implemented in part (c) */
        double original = totalPrices();
        double sum = totalPrices();
        if (couponApplies()){
            sum -= (original * .25);
        }
        int numCustomers = 0;
        for (MenuItem item: check){
            if (item.isEntree()){
                numCustomers++;
            }
        }
        if (numCustomers >= 6){
            sum += (.20 * original);
        }
        return sum;
    }
}
