import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;

public class SortedArrayGenerator {

    public static ArrayList<BigDecimal> GenerateDataSet(int size) {
        Random rand = new Random();
        ArrayList<BigDecimal> dataSet = new ArrayList<>(size);
        BigDecimal latest = new BigDecimal(0);
        for (int i = 0; i < size; i++) {
            dataSet.add(latest);
            latest.add(new BigDecimal(rand.nextLong(5)));
        }
        return dataSet;
    }

    private SortedArrayGenerator() {}
}
