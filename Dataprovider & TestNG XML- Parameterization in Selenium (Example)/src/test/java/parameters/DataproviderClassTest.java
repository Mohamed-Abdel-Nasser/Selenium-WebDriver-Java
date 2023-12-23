package parameters;

import org.testng.annotations.DataProvider;

/**
 * This class provides a data provider named "SearchProvider"
 * containing test data for search tests. Each sub-array represents
 * a single test case with author name and search keyword.
 */
public class DataproviderClassTest {

    /**
     * This data provider named "SearchProvider" supplies test data
     * for various search scenarios. Each row in the returned array
     * represents a single test case with two elements:
     * - The first element is the author name (for logging purposes).
     * - The second element is the search keyword to be used in the test.
     *
     * @return A two-dimensional array of objects containing test data.
     * DataProvider method providing test data for the "SearchProvider" DataProvider.
     *  *
     *  * @return Object[][] representing test data for different test cases.
     */
    @DataProvider(name = "SearchProvider")
    public static Object[][] getDataFromDataProvider() {
        // Define the test data for different test cases
        return new Object[][] {
                // Test case 1: Guru99 searching for India
                {"Guru99", "India"},
                // Test case 2: Krishna searching for UK
                {"Krishna", "UK"},
                // Test case 3: Bhupesh searching for USA
                {"Bhupesh", "USA"}
        };
    }}
