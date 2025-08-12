import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;

public class SortedArrayGenerator {

    public static ArrayList<BigDecimal> GenerateDataSet(int size) {
        Random rand = new Random();
        ArrayList<BigDecimal> dataSet = new ArrayList<>(size);
        long num = 0;
        for (int i = 0; i < size; i++) {
            dataSet.add(new BigDecimal(num));
            num += rand.nextLong(1, 5);
        }
        return dataSet;
    }

    private SortedArrayGenerator() {}
}
