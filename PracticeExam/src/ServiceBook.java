import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class ServiceBook {
    ArrayList<Service> services = new ArrayList<>();
    int serviceLength;
    Service serviceArray[];
    Service serviceCheck;
    Date dateCheck;
    boolean dateMatch;
    String serviceString;

    public ServiceBook(){

    }
    public void addService(Service service){
        serviceLength = services.size();
        services.ensureCapacity(serviceLength);
        services.add(serviceLength, service);
    }
    public int getNumberOfServices(){
        return services.size();
    }
    public Service getService(int index){
        if(index >= 1) {
            return services.get(index - 1);
        }else{
            return null;
        }

    }
    public Service[] getAllServices(){
            serviceLength = services.size();
        if(serviceLength >= 0) {
            Service[] serviceArray = new Service[serviceLength];

            for (int i = 0; i < serviceLength; i++) {
                serviceArray[i] = services.get(i);
            }
            return serviceArray;
        }else{
            return null;
        }
    }
    public boolean hasServiceOnDate(Date date){
        serviceLength = services.size();
        dateCheck = date;
        if(serviceLength >= 0) {
            dateMatch = false;
            for (int i = 0; i < serviceLength; i++) {
                serviceCheck = services.get(i);
                dateMatch = dateCheck.equals(serviceCheck.getDate());
                if (dateMatch == true) {
                    break;
                }
            }
            return dateMatch;
        }else{
            return false;
        }
    }
    public Date getDateOfLastService(){
        serviceLength = services.size();
        if(serviceLength >= 0){
            return services.get(serviceLength-1).getDate();
        }else{
            return null;
        }

    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceBook that = (ServiceBook) o;
        return serviceLength == that.serviceLength &&
                Objects.equals(services, that.services) &&
                Arrays.equals(serviceArray, that.serviceArray);
    }
    
    public String toString() {
                serviceLength = services.size();
                for (int i =0; i< serviceLength; i++){
                    serviceString += "\n";
                    serviceString += services.get(i).toString() ;
                }
                serviceString += "\n";

        return "ServiceBook{" +
                "services=" + serviceString +
                "serviceLength=" + serviceLength +
                ", serviceArray=" + Arrays.toString(serviceArray) +
                ", serviceCheck=" + serviceCheck +
                ", dateCheck=" + dateCheck +
                ", dateMatch=" + dateMatch +
                '}';
    }
}
