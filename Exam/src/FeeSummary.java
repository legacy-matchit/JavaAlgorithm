public class FeeSummary {

    private String licenseNr;
    private int sumFees;
    public FeeSummary(String licenseNr, int sumFees){
        this.licenseNr = licenseNr;
        this.sumFees = sumFees;
    }

    public String getLicenseNr(){
        return licenseNr;
    }

    public int getSumFees(){
        return sumFees;
    }
}
