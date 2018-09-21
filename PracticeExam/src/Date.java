import java.util.Objects;

public class Date {

    int day;
    int month;
    int year;

    public Date(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void set(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public Date copy(){
        return new Date(day,month,year);
    }

    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Date date = (Date) o;
        return day == date.day &&
                month == date.month &&
                year == date.year;
    }


    public String toString() {
        return " day = "+Integer.toString(day)+", month "+Integer.toString(month)+", year "+Integer.toString(year);
    }


}
