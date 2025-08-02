import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static final int DEFAULT_SIZE = 1_000_000_000;
    public static final int DEFAULT_TIMES_TO_RUN_SEARCH = 100_000;

    public static void main(String[] args) {
        var stopWatch = new NanoStopwatch();
        stopWatch.reset();
        var dataSet = SortedArrayGenerator.GenerateDataSet(DEFAULT_SIZE);
        var elapsedTimeForDataSetGen = stopWatch.elapsedSeconds();
        System.out.println(
            "It took " +
            elapsedTimeForDataSetGen +
            " seconds to generate dataset"
        );
        System.out.println("DataSet Size: " + dataSet.size());

        ArrayList<Double> timesForLinearSearch = new ArrayList<>(
            DEFAULT_TIMES_TO_RUN_SEARCH
        );
        ArrayList<Double> timesForBinarySearch = new ArrayList<>(
            DEFAULT_TIMES_TO_RUN_SEARCH
        );
        Random randGen = new Random();
        for (int i = 0; i < DEFAULT_TIMES_TO_RUN_SEARCH; i++) {
            int randomIndex = randGen.nextInt(dataSet.size());
            timesForLinearSearch.add(RunLinearSearch(dataSet, randomIndex));
            timesForBinarySearch.add(RunBinarySearch(dataSet, randomIndex));
        }

        double linearSearchAvgSecs = timesForLinearSearch
            .stream()
            .mapToDouble(Double::doubleValue)
            .average()
            .orElse(0.0);
        System.out.printf(
            "It took %.10f seconds in average to do a linear search\n",
            linearSearchAvgSecs
        );
        double binarySearchAvgSecs = timesForBinarySearch
            .stream()
            .mapToDouble(Double::doubleValue)
            .average()
            .orElse(0.0);
        System.out.printf(
            "It took %.10f seconds in average to do a binary search\n",
            binarySearchAvgSecs
        );

        System.out.printf(
            "For a size of %d dataSet and %d number of times random search,\non average, binary search was %.10f times faster than linear search\n",
            dataSet.size(),
            DEFAULT_TIMES_TO_RUN_SEARCH,
            linearSearchAvgSecs / binarySearchAvgSecs
        );
    }

    public static double RunLinearSearch(
        ArrayList<BigDecimal> dataSet,
        int randomIndex
    ) {
        var stopWatch = new NanoStopwatch();
        stopWatch.reset();
        Linear_Search_NumberExists(dataSet, dataSet.get(randomIndex));
        return stopWatch.elapsedSeconds();
    }

    public static double RunBinarySearch(
        ArrayList<BigDecimal> dataSet,
        int randomIndex
    ) {
        var stopWatch = new NanoStopwatch();
        stopWatch.reset();
        Binary_Search_NumberExists(dataSet, dataSet.get(randomIndex));
        return stopWatch.elapsedSeconds();
    }

    public static boolean Linear_Search_NumberExists(
        ArrayList<BigDecimal> dataSet,
        BigDecimal number
    ) {
        for (int i = 0; i < dataSet.size(); i++) {
            if (dataSet.get(i) == number) {
                return true;
            }
        }

        return false;
    }

    public static boolean Binary_Search_NumberExists(
        ArrayList<BigDecimal> dataSet,
        BigDecimal number
    ) {
        int low = 0;
        int high = dataSet.size() - 1;

        for (; low <= high; ) {
            int mid = low + (high - low) / 2;
            BigDecimal numFromSet = dataSet.get(mid);
            if (numFromSet == number) {
                return true;
            } else if (numFromSet.compareTo(number) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }
}
