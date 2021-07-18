import java.text.DecimalFormat;
import java.util.Random;

public class PhoneNumberGenerator  {

    private final String countryCode = "+7";
    private final int minValueOfOperatorCode = 900;
    private final int maxValueOfOperatorAndFirsPartOfClientCode = 999;
    private final int minValueOfClientCode = 0;
    private final int maxValueOfSecondPartClientCode = 99;

    DecimalFormat df1 = new DecimalFormat("000");
    DecimalFormat df2 = new DecimalFormat("00");
    Random random = new Random();

    public String generate() {
        int operatorCode = minValueOfOperatorCode + random.nextInt(maxValueOfOperatorAndFirsPartOfClientCode - minValueOfOperatorCode + 1);
        int firsPartOfClientCode = minValueOfClientCode + random.nextInt(maxValueOfOperatorAndFirsPartOfClientCode - minValueOfClientCode + 1);
        int secondPartOfClientCode = minValueOfClientCode + random.nextInt(maxValueOfSecondPartClientCode - minValueOfClientCode + 1);
        int thirdPartOfClientCode = minValueOfClientCode + random.nextInt(maxValueOfSecondPartClientCode - minValueOfClientCode + 1);
        return countryCode
                + "(" + operatorCode + ")"
                + df1.format(firsPartOfClientCode)
                + "-" + df2.format(secondPartOfClientCode)
                + "-" + df2.format(thirdPartOfClientCode);
    }
}
