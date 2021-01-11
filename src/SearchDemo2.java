public class SearchDemo2 {

    public static void main(String[] args) {

        System.out.println("Starting SearchDemo2");

        SearchArray searchArray = new SearchArray(1, "./values.txt");
        searchArray.load();
        System.out.println("SearchDemo2: loading entries finished");


        // count of entries ...
        System.out.println("searchArray.length() = " + searchArray.length());
        // get one element ...
        System.out.println("searchArray.get(10) = " + searchArray.get(10));

        System.out.println("searching ...");

        // LOOKING for 314699018
        searchFor(searchArray, 314699018);

        // LOOKING for 816387057
        searchFor(searchArray, 816387057);

        // LOOKING for 1317297914
        searchFor(searchArray, 1317297914);

        // LOOKING for 1651147229
        searchFor(searchArray, 1651147229);

        // LOOKING for 1651147228
        searchFor(searchArray, 1651147228);
    }

    public static int search(SearchArray array, int value, int left, int right){
        // Your Code

        return -1;
    }

    private static void searchFor(SearchArray array, int value ){
        System.out.print("Looking for " + value + " ");
        array.resetGetCounter();
        long startTime = System.currentTimeMillis();
        int index = search(array, value, 0, array.length());
        long stopTime = System.currentTimeMillis();

        System.out.println("at position " + index + ", took " + array.getGetCounter() + " calls, and took " + (stopTime - startTime) + "ms");
    }

}
