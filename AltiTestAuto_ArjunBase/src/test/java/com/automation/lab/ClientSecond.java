package com.automation.lab;

public class ClientSecond extends SampleClient{

	public static void main(String[] args) {
		
		SingletonExample.getSingleInstance().printSingleton();
		
	}

}
