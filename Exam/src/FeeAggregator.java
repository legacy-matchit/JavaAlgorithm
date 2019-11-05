import java.util.ArrayList;

public class FeeAggregator {
    private FeeRegistry feeRegistry;

    public FeeAggregator(FeeRegistry feeRegistry){
        this.feeRegistry = feeRegistry;
    }

    public ArrayList<FeeSummary> getSummaries(){
        ArrayList<FeeSummary> summaries = new ArrayList<>();
        ArrayList<String> licenseNrs = feeRegistry.getUniqueLicenseNrs();
        for(int i = 0; i < licenseNrs.size(); i++){
            String licenseNr = licenseNrs.get(i);
            int sum = feeRegistry.getUnpaidFeesSum(licenseNr);
            summaries.add(new FeeSummary(licenseNr,sum));
        }
        return summaries;
    }

    public FeeSummary getSummryWithHighestFee(){
        ArrayList<FeeSummary> summaries = getSummaries();
        int pos = 0;
        for(int i = 0; i < summaries.size(); i++){
            if(summaries.get(i).getSumFees() > summaries.get(pos).getSumFees()){
                pos = i;
            }
        }
        return summaries.get(pos);
    }

}
