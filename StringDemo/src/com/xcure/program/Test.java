package com.xcure.program;

import java.util.HashMap;

public class Test {


	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	public static void main(String[] args) {
		
		Bhushan bhushan = new Bhushan();
		System.out.println(bhushan.hashCode());
		Shubham shubham = new Shubham();
		System.out.println(shubham.hashCode());
		Vaibhav vaibhav = new Vaibhav();
		System.out.println(vaibhav.hashCode());
		
		HashMap<Object,Object> hashMap = new HashMap<>();
		
		hashMap.put(new Bhushan(), "Prowing");
		hashMap.put(new Shubham(), "Prowing");
		hashMap.put(new Vaibhav(), "Prowing");
		
		System.out.println(hashMap);
		
	
		
	}
}
