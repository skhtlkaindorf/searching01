public class SearchDemo2 {

    public static void main(String[] args) {

        System.out.println("Starting SearchDemo2");

        SearchArray searchArray = new SearchArray(2, 10_000_000);
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
        if (right < left)
            return -1;

        //System.out.println("search for value: " + value);

        int mid = (left + right) / 2;
        int valueMid = array.get(mid);
        if (value == valueMid)
            return mid; // wir haben den index gefunden
        else if (value < valueMid)
            return search(array, value, left, mid -1);
        else
            return search(array, value, mid + 1, right);
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
