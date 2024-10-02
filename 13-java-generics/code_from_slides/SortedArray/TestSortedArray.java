public class TestSortedArray {
    public static void main(String[] args) {
        // Declare the test data
        String[] testData = new String[]{
            "This", "is", "five", "words", "long"
        };
        
        // Print the test data
        System.out.print("The test data is [");
        for(var s : testData) System.out.print(s + " ");
        System.out.println("]");
        
        // Declare the SortedArray and print its attributes
        SortedArray<String> sas = new SortedArray<>(testData.length);
        System.out.println("Initial sas size = " + sas.size() + ", length = " + sas.length());
        
        // Load the test data
        for(var s : testData)
            sas.add(s);
            
        // Try to exceed size limit
        try {
            sas.add("I should cause Exception");
            System.err.println("FAIL - added 6th element to 5 element SortedArray");
        } catch(Exception e) {
        }
        
        // Check size and length again
        System.out.println("Final   sas size = " + sas.size() + ", length = " + sas.length());
        
        // Print the sorted test data
        System.out.print("SortedArray   is [");
        for(int i=0; i<sas.size(); ++i)
            System.out.print(sas.get(i) + " ");
        System.out.println("]");
    }

}
