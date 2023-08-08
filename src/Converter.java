public class Converter {

    public static final double USD_RATE =  17.07;
    public static final double EUR_RATE =  18.74;
    public static final double CAN_RATE =  12.75;
    public static final double GBP_RATE =  21.72;

    static class MxnToConverter {
        public double convert(double amount, double rate) {
            return amount / rate;
        }
    }

     static class ConvertToMxn {
        public double convert(double amount, double rate) {
            return amount * rate;
        }
    }

}


