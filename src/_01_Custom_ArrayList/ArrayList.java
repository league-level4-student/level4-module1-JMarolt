package _01_Custom_ArrayList;

@SuppressWarnings("unchecked")

public class ArrayList <T>{
	
	T[] array;
	
	public ArrayList() {
		
		array = (T[])new Object[0];
		
	}
	
	public T get(int loc) throws IndexOutOfBoundsException {
		
		return array[loc];
		
	}
	
	public void add(T val) {
		
		int len = array.length;
		T[] newArr = (T[])new Object[len + 1];
		
		for(int i = 0; i < len; i++) {
			newArr[i] = array[i];
		}
		
		int newLen = newArr.length - 1;
		newArr[newLen] = val;
		
		array = newArr;
		
	}
	
	public void insert(int loc, T val) throws IndexOutOfBoundsException {
		
		int len = array.length;
		T[] newArr = (T[])new Object[len + 1];
		
		for(int i = 0; i < loc; i++) {
			newArr[i] = array[i];
		}
		
		newArr[loc] = val;
		
		for(int k = loc + 1; k < len; k++) {
			newArr[k] = array[k];
		}
		
		array = newArr;
		
	}
	
	public void set(int loc, T val) throws IndexOutOfBoundsException {
		array[loc] = val;
	}
	
	public void remove(int loc) throws IndexOutOfBoundsException {
	
		T[] newArr = (T[])new Object[array.length];
		int spot = loc;
		for(int i = 0; i < loc; i++) {
			newArr[i] = array[i];
		}
		
		for(int k = spot; k < array.length; k++) {
			newArr[k] = array[k];
		}
		
		array = newArr;
		
	}
	
	public boolean contains(T val) {
		for(int i = 0; i < array.length; i++) {
			if(array[i] == val) {
				return true;
			}
		}
		return false;
	}

	public int size() {
		return array.length;
	}
}