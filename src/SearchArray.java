import java.util.Arrays;
import java.util.Random;

public class SearchArray {

    public static final int MAX_LENGTH = 10_000_000;

    private int[] array;
    private int getCounter;
    private int load;
    private String path;

    public SearchArray(int load, String path){
        getCounter = 0;
        this.load = load;
        this.path = path;
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
        Thread.yield();

        getCounter++;
        return array[index];
    }

    public void load(){
        array  = new Random().ints(12_000_000, 1_000_000 ,2_000_000_000)
                .distinct().sorted().limit(MAX_LENGTH).toArray();

        array[0] = 314699018;
        array[1] = 816387057;
        array[2] = 1317297914;
        array[3] = 1651147229;

        Arrays.sort(array);
    }

   /* public void load(){
        array = new int[MAX_LENGTH];
        int counter = 0;

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))){
            array = (int[]) ois.readObject();

        } catch (FileNotFoundException e) {
            System.out.println(counter);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(counter);
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // change to public if needed
    private void generate() {
        int arr[]  = new Random().ints(12_000_000, 1_000_000 ,2_000_000_000)
                .distinct().sorted().limit(MAX_LENGTH).toArray();;

        System.out.println("arr.length = " + arr.length);
        
        Arrays.sort(arr);
        try (ObjectOutputStream fw = new ObjectOutputStream( new FileOutputStream("./values.txt"))) {
            fw.writeObject(arr);
            fw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/



}
