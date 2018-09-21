public class Main {

    public static void main(String[] args) {
        int mileage1 = 1000;
        int day1 = 23;
        int month1 = 4;
        int year1 = 2020;

        int mileage2 = 1900;
        int day2 = 4;
        int month2 = 6;
        int year2 = 2000;

        int mileage3 = 400;
        int day3 = 19;
        int month3 = 1;
        int year3 = 2013;

        Date date1 = new Date(day1,month1,year1);
        Date date2 = new Date(day2,month2,year2);
        Date date3 = new Date(day3,month3,year3);

        ServiceBook serviceBook = new ServiceBook();
        Service service1 = new Service(mileage1,date1);
        Service service2 = new Service(mileage2,date2);
        Service service3 = new Service(mileage3,date3);

        serviceBook.addService(service1);
        serviceBook.addService(service2);
        serviceBook.addService(service3);

        System.out.println(serviceBook.toString());



    }



}
