import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class FeeRegistry {

    ArrayList<ParkingFee> pfList;

    public FeeRegistry(){
        pfList = new ArrayList<>();
    }

    public void addFee(String licenseNr, String date, int fee){
        pfList.add(new ParkingFee(licenseNr,date,fee));
    }

    public void removeFee(String licenseNr, String date){
        for(int i = 0; i < pfList.size(); i++){
            if(pfList.get(i).getLicenseNr().equals(licenseNr) &&
            pfList.get(i).getDate().equals(date)){
                pfList.remove(i);
            }
        }
    }

    public ArrayList<ParkingFee> getUnpaidFees(String licenseNr){
        ArrayList<ParkingFee> temp = new ArrayList<>();
        for(int i = 0; i < pfList.size(); i++){
            if(pfList.get(i).getLicenseNr().equals(licenseNr)){
                temp.add(pfList.get(i));
            }
        }

        return temp;
    }

    public int getUnpaidFeesSum(String licenseNr){
        int sum = 0;
        for(int i = 0; i < pfList.size(); i++){
            if(pfList.get(i).getLicenseNr().equals(licenseNr)){
                sum += pfList.get(i).getFee();
            }
        }
        return sum;
    }

    public ArrayList<String> getUniqueLicenseNrs(){
        ArrayList<String> temp = new ArrayList<>();
        for(int i = 0; i < pfList.size(); i++){
            if(!temp.contains(pfList.get(i).getLicenseNr())){
                temp.add(pfList.get(i).getLicenseNr());
            }
        }
        return temp;
    }


}
