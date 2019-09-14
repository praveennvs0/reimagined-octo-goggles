public class NoSynchronizationDemo
{
   public static void main (String [] args)
   {
      FinTrans22 ft = new FinTrans22 ();
      TransThread3 tt1 = new TransThread3 (ft, "Deposit Thread");
      TransThread3 tt2 = new TransThread3 (ft, "Withdrawal Thread");
      tt1.start ();
      tt2.start ();
   }
}
 

