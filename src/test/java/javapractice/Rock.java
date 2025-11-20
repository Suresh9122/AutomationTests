package javapractice;

import java.util.Scanner;

public class Rock {
	public static void main(String[]args) {
		
		  Scanner sc = new Scanner(System.in);
		  System.out.println("Enter a String: ");
		  String input= sc.nextLine();
		 char ch;
	
		 String s="";
	for(int i=0;i<input.length();i++) {
		ch=input.charAt(i);
		s=ch+s;
		}
	System.out.println(s);
		
	}

}
