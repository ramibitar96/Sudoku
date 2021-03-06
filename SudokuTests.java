import java.util.Arrays;
import junit.framework.TestCase;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class SudokuTests extends TestCase {
    
    int[][] testBoard = { {0,4,8,3,9,5,7,1,6},
                          {5,7,1,6,2,8,3,4,9},
                          {9,3,6,7,4,1,5,8,2},
                          {6,8,2,5,3,9,1,7,4},
                          {3,5,9,1,7,4,6,2,8},
                          {7,1,4,8,6,2,9,5,3},
                          {8,6,3,4,1,7,2,9,5},
                          {1,9,5,2,8,6,4,3,7},
                          {4,2,7,9,5,3,8,6,1} };
    
    String testString = "248395716571628349936741582682539174359174628714862953863417095195286437427953861";
    
    int[][] testBoard2 = { {2,4,8,3,9,5,7,1,6}, {5,7,1,6,2,8,3,4,9}, {9,3,6,7,4,1,5,8,2},
                         {6,8,2,5,3,9,1,7,4}, {3,5,9,1,7,4,6,2,8}, {7,1,4,8,6,2,9,5,3},
                         {8,6,3,4,1,7,2,9,5}, {1,9,5,2,8,6,4,3,7}, {4,2,7,9,5,3,8,6,1} };
    
    int[][] testBoard3 = { {2,4,8,3,9,5,7,1,6},
                          {5,7,1,6,2,8,3,4,9},
                          {9,3,6,7,4,1,5,8,2},
                          {6,8,2,5,3,9,3,7,4},
                          {3,5,9,1,7,4,6,2,8},
                          {7,1,4,8,6,2,9,5,3},
                          {8,6,3,4,1,7,2,9,5},
                          {1,9,5,2,8,6,4,3,7},
                          {4,2,7,9,5,3,8,6,1} };
     boolean[] testing = {false, false, true, false, false, false, false, false, false, false};
    
     int[] one = {1,3,4,2,5};
     int[] two = {4,5,7,8,9,2,3};
     int[] three = {2,4,5,6,8,9};
     int[] four = {2,4,5};
     Sudoku k;
     Sudoku k2;
     Sudoku k3;
     Sudoku k4;
     
     public void testSolve() 
     {
         k2.solve();
     }
     
    public void setUp() 
    {
        k = new Sudoku(testBoard);
        k2 = new Sudoku(testBoard2);
        k3 = new Sudoku(testBoard3);
        k4 = new Sudoku();
    }
    
    public void testGetBoxNum() 
    {
        int answer1 = 0;
        int answer2 = 1;
        assertEquals(answer1,k.getBoxNum(100,2));
        assertEquals(answer2,k.getBoxNum(2,10));
    }
    
    public void testNakedSingles() 
    {
        assertTrue(k.nakedSingles());
    }
    
    public void testHiddenSingles() 
    {
        assertTrue(k.hiddenSingles());
    }

    public void testIsSolved() 
    {
        assertTrue(k2.isSolved());
        assertFalse(k.isSolved());
        assertFalse(k3.isSolved());
        assertFalse(k4.isSolved());
    }
    
    public void testCandidates() 
    {
     boolean[] j = k.candidates(0,0);
     for(int i = 0; i < k.candidates(0,0).length; i++)
            System.out.println(k.candidates(0,0)[i]);
     System.out.println("--------------" + Arrays.equals(k.candidates(0,0), testing));
     for(int i = 1; i < 10; i++)
            System.out.println(testing[i]);
     
     
        assertTrue(Arrays.equals(j, testing));
    }
    public void testMergeAll()
    {
        assertTrue(Arrays.equals(k3.mergeAll(one, two, three), four));
    }
}
