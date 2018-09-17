import java.math.BigDecimal;

public class PotensRegner {

    public static void main(String[] args){

        long arg1;
        long arg2;
        long arg3;
        BigDecimal math1;

        try{
            arg1 = Integer.parseInt(args[0]);
            arg2 = Integer.parseInt(args[1]);
            arg3 = Integer.parseInt(args[2]);
            math1 = new BigDecimal(Math.pow(arg1,arg2)%arg3);
            System.out.println(math1);
        }catch(Exception e){
            System.out.println("Exception 1");
        }


    }
}
