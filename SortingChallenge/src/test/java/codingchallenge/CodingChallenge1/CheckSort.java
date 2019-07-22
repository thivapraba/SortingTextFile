package codingchallenge.CodingChallenge1;

import static org.junit.Assert.*;

import org.junit.Test;

public class CheckSort {

	private MergeSort sorter = new MergeSort();
	 
    @Test
    public void shouldDoNothingWithEmptyArray() {
        Integer [] values = {};
       
        sorter.mergeSort(values, 0, -1);
 
        assertEquals(values.length, 0, -1);
    }
 
    @Test
    public void shouldDoNothingWithOneElementArray() {
    	Integer [] values = {42};
 
        sorter.mergeSort(values,0,0);
 
        assertEquals(values.length, 1,1);
    }
    
    @Test
    public void shouldSortValues() {
        Integer [] values = { 9, -3, 5, 0, 1};
        Integer [] expectedOrder = { -3, 0, 1, 5, 9};
 
        sorter.mergeSort(values, 0, 4);
        assertArrayEquals(expectedOrder, values);
    }
}