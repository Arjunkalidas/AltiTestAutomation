package com.automation.lab;

public class SingletonExample {

	private static SingletonExample SingletonInstance;
	private SingletonExample() {
	}

	public static SingletonExample getSingleInstance() {
		if(SingletonInstance == null){
				//synchronized (SingletonExample.class){
			
			SingletonInstance = new SingletonExample();
			System.out.println("Creating a new instance");
		//}
	}
		
		return SingletonInstance;
	}
	
	public void printSingleton(){
		System.out.println("Print singleton");
	}
	
	public void secondClass(){
		getSingleInstance().printSingleton();
	}
	public void thirdClass(){
		getSingleInstance().printSingleton();
	}
}
