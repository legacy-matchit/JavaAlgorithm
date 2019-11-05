import java.util.ArrayList;
import java.util.Scanner;

public class MainTest {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        FeeRegistry feeRegistry = new FeeRegistry();
        boolean input = true;
        while (input){
            System.out.println("plese input registNumber,date,fee with space");
            String line = scan.nextLine();

            if(line.length() == 0 || line == null){
                input = false;
            }else {
                String[] s = line.split(" ");
                String licenseNr = s[0];
                String date = s[1];
                int fee = Integer.parseInt(s[2]);
                //System.out.println(licenseNr +" : "+date+" : "+fee);
                feeRegistry.addFee(licenseNr,date,fee);
            }
        }

        FeeAggregator aggregator = new FeeAggregator(feeRegistry);
        ArrayList<FeeSummary> summaries = aggregator.getSummaries();
        for(int i = 0; i < summaries.size(); i++){
            FeeSummary summary = summaries.get(i);
            System.out.print("ResigtNumber : "+summary.getLicenseNr() + " : ");
            System.out.println("Total unpaid : "+summary.getSumFees());
        }

        System.out.println("MAX:" + aggregator.getSummryWithHighestFee().getSumFees());
    }
}
