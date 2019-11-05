public class ParkingFee {

    private String licenseNr;
    private String date;
    private int fee;

    public ParkingFee(String licenseNr,String date,int fee){
        this.licenseNr = licenseNr;
        this.date = date;
        this.fee = fee;
    }

    public String getLicenseNr() {
        return licenseNr;
    }

    public String getDate() {
        return date;
    }

    public int getFee() {
        return fee;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof ParkingFee)){
            return false;
        }
        ParkingFee pf = (ParkingFee)obj;
        return this.licenseNr.equals(pf.licenseNr);
    }
}
