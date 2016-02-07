package com.wikidreams.shell;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class App {

	public static void main(String[] args) {

		String domainName = "google.com";

		// Execute the command in windows
		String command = "ping -n 3 " + domainName;

		// Execute the command in Mac osX
		//String command = "ping -c 3 " + domainName;

		String output = executeCommand(command);
		System.out.println(output);
	}

	public static String executeCommand(String command) {
		StringBuffer output = new StringBuffer();
		Process p;
		try {
			p = Runtime.getRuntime().exec(command);
			p.waitFor();
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = "";			
			while ((line = reader.readLine())!= null) {
				output.append(line + "\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return output.toString();
	}

}
