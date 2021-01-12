import java.util.Arrays;
import java.util.Random;

public class SearchArray {

    private int[] array;
    private int getCounter;
    private int load;
    private final int maxLength;

    public SearchArray(int load, int maxLength){
        getCounter = 0;
        this.load = load;
        this.maxLength = maxLength;
    }

    public void resetGetCounter(){
        getCounter = 0;
    }

    public int getGetCounter() {
        return getCounter;
    }

    public int length(){
        return array.length;
    }

    public int get(int index){
        // Making access a bit slower
        for (int i = 0; i < load; i++)
            Thread.yield();

        getCounter++;
        return array[index];
    }

    public void load(){
        System.out.println("Loading started, may take some time . . .");
        array  = new Random().ints((int) (maxLength * 1.2), 1_000_000 ,2_000_000_000)
                .distinct().sorted().limit(maxLength).toArray();

        System.out.println("Length of array: " + array.length);

        array[0] = 314699018;
        array[1] = 816387057;
        array[2] = 1317297914;
        array[3] = 1651147229;

        Arrays.sort(array);
    }
}
