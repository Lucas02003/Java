import java.util.calender;
import java.util.GregorianCalender;

public class MyDate{
    private int year;

    private int month;

    private int day;

public MyDate() {

  GregorianCalender calender = new GregorianCalender(); 

 this.year = calender.get(Calender.YEAR);

 this.month = calender.get(Calender.MONTH);

 this.day = calender.get(Calender.DAY_OF_MONTH);

}

public MyDate(long elapsedTime){

    GregorianCalender calender = new GregorianCalender();

    calender.setTimeInMillis(elapsedTime);

    this.year = calender.get(Calender.YEAR);

    this.month = calender.get(Calender.MONTH);

    this.day = calender.get(Calender.DAY_OF_MONTH);

}


public MyDate(int year, int month, int day){

 this.year = year;

 this.month = month;

 this.day = day;

}

public int getyear(){
   
    return year;

}

public int getmonth(){

    return month;

}

public int getday(){

   return day;

}

public void setDate(long elapsedTime){

    GregorianCalender calender = new GregorianCalender();

    calender.setTimeInMillis(elapsedTime);

    this.year = calender.get(Calender.YEAR);

    this.month = calender.get(Calender.MONTH);

    this.day = calender.get(Calender.DAY_OF_MONTH);  
}

}

public class TestMyDate {
    public static void main(String[] args) {
        MyDate date1 = new MyDate();
        System.out.println("Current Date: " + date1.getYear() + "-" + (date1.getMonth() + 1) + "-" + date1.getDay());

        MyDate date2 = new MyDate(34355555133101L);
        System.out.println("Date from Elapsed Time: " + date2.getYear() + "-" + (date2.getMonth() + 1) + "-" + date2.getDay());
    }
}