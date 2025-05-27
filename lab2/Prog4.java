package lab2;

public class Prog4 {
    public class Data {
        public static String records = "134A,abc,123:213A,xyz,456:911C,pqr,789:012E,test,321:662Z,demo,654";
    }
    public static void main(String[] args) {
        String myString = Data.records;

        String[] records = myString.split(":");

        for(String record : records) {
            String[] fields = record.split(",");
            if(fields.length > 0) {
                System.out.println(fields[0]);
            }
        }
    }
}
