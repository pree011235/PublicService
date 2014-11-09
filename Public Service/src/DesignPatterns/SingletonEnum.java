package DesignPatterns;

import java.util.Arrays;

/*
 * Using enum
 */
public enum SingletonEnum {
	SingletonInstance;

	private final String[] instanceVariables = { "One", "Two", "Three" };
	
	public void printIntanceVariables(){
		System.out.println(Arrays.toString(instanceVariables));
	}

}
