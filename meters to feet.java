public class Main {
    public static double footToMeter(double foot){

    return 0.305 * foot;
}
public static double meterToFoot(double meter){

    return 3.279 * meter;
}
public static void main(String[] args) {
    double feet = 10;
    double meters = footToMeter(feet);
    System.out.println(feet + " feet is equal to " + meters + " meters.");

    meters = 10;
    feet = meterToFoot(meters);
    System.out.println(meters + " meters is equal to " + feet + " feet.");
}
}