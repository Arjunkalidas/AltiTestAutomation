package com.automation.lab;


public enum Currency{
	PENNY("Android"), NICKEL("Iphone 4S"), DIME("Nexus"), QUARTER("iPad");

	private String value;
	
		
	private Currency(String value){
		this.value = value;
	}
	
	
	public static void main(String[] args) {
		System.out.println(Currency.NICKEL.value);
		 
		Currency usCoin = Currency.NICKEL;
		
			switch (usCoin) {
			case PENNY:
				System.out.println("Penny coin");
				break;
			case NICKEL:
				System.out.println("Nickel coin");
				break;
			case DIME:
				System.out.println("Dime coin");
				break;
			case QUARTER:
				System.out.println("Quarter coin");
				break;
			}
		
	}
};

