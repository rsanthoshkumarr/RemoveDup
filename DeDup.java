package test;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class DeDup {

    public int[] randomIntegers = {1,2,34,34,25,1,45,3,26,85,4,34,86,25,43,2,1,10000,11,16,19,1,18,4,9,3,
            20,17,8,15,6,2,5,10,14,12,13,7,8,9,1,2,15,12,18,10,14,20,17,16,3,6,19,
            13,5,11,4,7,19,16,5,9,12,3,20,7,15,17,10,6,1,8,18,4,14,13,2,11};   

	
    public static void main(String arr[]){
    	
    	DeDup deDup=new DeDup();
    	int[] newArry=deDup.removeDuplicateByArrays(deDup.randomIntegers);
    	Object[] newArry2=deDup.removeDuplicateBySet(deDup.randomIntegers);
    	int[] newArry3=deDup.removeDuplicatesByRecurive(deDup.randomIntegers);
    	
    }
    
	
	/**
	 *  implementation 1:
	 * This method removes the duplicate from the integer array,But doesn't maintain the original order
	 * @param arr :Original Integer Array
	 * @return Integer array without any duplicate.
	 */
	public int[] removeDuplicateByArrays(int[] arr){
		Arrays.sort(arr);
		int[] result=new int[arr.length];
		result[0]=arr[0];
		int count = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] != arr[i + 1]) {
				result[count++] = arr[i];
			}
		}
		int[] newArr=new int[count];
		System.arraycopy(result, 0, newArr, 0, count);
		return newArr;
	}
	
	/**
	 *  implementation 2:
	 * This method removes the duplicate from the integer array by using Set.This maintains the original insertion order
	 * @param arr :Original Integer Array
	 * @return Integer array without any duplicate.
	 */
	public Object[] removeDuplicateBySet(int[] arr){
		Set<Integer> set=new LinkedHashSet<Integer>();
		int[] newArr=new int[arr.length];
		for (int i = 0; i < arr.length - 1; i++) {
			set.add(arr[i]);
		}
		return set.toArray();
	}
	

	/**
	 *  implementation 3:
	 * This could be considered as better approach to resolve the duplicate because in above two implementation 
	 * uses collection/sort to remove duplicates but in this approach it doesn't use any inbuilt collections/sort
	 * This method removes the duplicate from the integer array recursive functionality,and the insertion order is maintained
	 * @param arr :Original Integer Array
	 * @return Integer array without any duplicate.
	 */
	public  int[] removeDuplicatesByRecurive(int[] arr){
        int result[] = new int[arr.length];
        int count=0;
        for (int i : arr) {
            if(!isValueExists(result, i))
                result[count++] = i;
        }
        int[] newArr=new int[count];
		System.arraycopy(result, 0, newArr, 0, count);
        return result;
    }
	
    /**
     * @param array
     * @param value
     * @return
     */
    private  boolean isValueExists(int[] array, int value){
        for (int i : array) {
            if(i==value)
                return true;
        }
        return false;
    }

}
