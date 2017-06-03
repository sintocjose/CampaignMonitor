package com.campaignmonitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.campaignmonitor.exceptions.InvalidTriangleException;

/**
 * This class is to address the language requirements coding test for campaign monitor
 * @author Sinto
 *
 */
public class LanguageRequirements {
	/**
	 * Requirement 1 : This method will check the given String value is null or empty
	 * @param value
	 * @return
	 */
	public boolean isNullOrEmpty(String value){
		return value == null || value.trim().length() == 0;
	}
	/**
	 * Requirement 2 : This method will return all the positive divisors of the input integer 
	 * in a list
	 * @param input
	 * @return
	 */
	public List<Integer> getPositiveDivisors(Integer input){
		if(input <=0){
			throw new RuntimeException("Invalid Number");
		}
		List<Integer> divisors = new LinkedList<>();
		for (int i=1;i<=input;i++)
			if (input%i==0){
				divisors.add(i);
			}
		return divisors;
	}
	/**
	 * Requirement 3 : This method returns the are of the triangle.
	 * @param length1 : Length of the triangle side a
	 * @param length2 : Length of the triangle side b
	 * @param length3 : Length of the triangle side c
	 * @return
	 */
	public double getTriangleArea(int length1,int length2, int length3){
		isValidTriangle(length1,length2,length3);
		int s = (length1 + length2 + length3)/2;
		double area = Math.sqrt(s*(s-length1)*(s-length2)*(s-length3));
		return area;
	}
	/**
	 * Requirement 4: This method returns the common elements in the input array.
	 * @param inputArray
	 * @return
	 */
	public int[] getCommonElements(int[] inputArray){
		if(inputArray==null || inputArray.length==0){
			throw new RuntimeException("Invalid Array");
		}
		Map<Integer,Integer> map = null;
		int count = 0;
		Integer val = null;
		for(int i=0;i<inputArray.length;i++){
			if(count==0){
				map = new HashMap<>();
			}
			val = map.get(inputArray[i]);
			if(val ==null){
				map.put(inputArray[i],1);
			}else{
				val=val+1;
				map.put(inputArray[i],val);
			}
			count++;
		}
		if(map==null){
			return inputArray;
		}else{
			List<Integer> list= new ArrayList<Integer>(map.values());
			Collections.sort(list, Collections.reverseOrder());
			int maxCount = list.get(0);
			ArrayList<Integer> arrayList = new ArrayList<>();
			for (Entry<Integer, Integer> e : map.entrySet()) {
				Integer key = e.getKey();
				Integer value = e.getValue();
				if(value==maxCount){
					arrayList.add(key);
				}
			}
			System.out.println(arrayList);
			return copyArrayListToArray(arrayList);
		}
	}
	/**
	 * Check whether the given sides of a triangle is valid or not.
	 * Triangle sides should be positive and 2 sides of triangle should be greater than the 3rd side 
	 * @param length1
	 * @param length2
	 * @param length3
	 * @return
	 */
	private static boolean isValidTriangle(int length1,int length2, int length3){
		if(length1<=0 ||length2<=0 ||length3<=0){
			throw new InvalidTriangleException("Invalid Triangle Side and Sides should be positive values");
		}
		if((length1+length2 > length3) && (length1+length3 >length2) && (length2+length3 > length1)){
			return true;
		}else{
			throw new InvalidTriangleException("Invalid Triangle Sides");
		}
	}
	/**
	 * Convert the arraylist to int array type
	 * @param set
	 * @return
	 */
	private static int[] copyArrayListToArray(List<Integer> list){
		int[] arr = new int[list.size()];
		int index = 0;
		for (int i : list) {
			arr[index++] = i;
		}
		return arr;
	}
}
