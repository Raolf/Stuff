import java.util.Objects;

public class Service{
    int mileage;
    Date date;

    public Service(int mileage, Date date){
        this.mileage = mileage;
        this.date = date;
    }

    public int getMilage() {
        return mileage;
    }
    public Date getDate(){
        return date;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Service service = (Service) o;

        return mileage == service.mileage &&
                Objects.equals(date, service.date);
    }

    public String toString() {
        return " mileage = "+Integer.toString(mileage)+", "+date.toString();
    }
}
