import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class BinaryTranslator {
	Scanner userIn;
	Scanner fileScanner;
	File file;
	
	BinaryTranslator() throws IOException{
		userIn = new Scanner(System.in);
		input();
	}
	public void input() throws IOException{
		String y = "y";
		String n = "n";
		System.out.println("Is your input coming from a file?(y or n)");
		String choice = userIn.nextLine();
		if(choice.equals(y)){
			System.out.println("Are you going from decimal to binary(y or n)");
			choice = userIn.nextLine();
			if(choice.equals(y))
				decToBin(true);
			else if(choice.equals(n))
				binToDec(true);
			else
				System.out.println("Please enter a valid input");
				input();
		}else if(choice.equals(n)){
			System.out.println("Are you going from decimal to binary(y or n)");
			choice = userIn.nextLine();
			if(choice.equals(y))
				decToBin(false);
			else if(choice.equals(n))
				binToDec(false);
			else
				System.out.println("Please enter a valid input");
				input();
		}else{
			System.out.println("Please enter a valid input next time, the program is terminating here");
			System.exit(0);
		}
	}
	public void decToBin(boolean fromFile) throws IOException{
		String path;
		int dec = 0;
		if(fromFile){
			System.out.println("Enter the path of file to covert to binary(File must have decimal numbers, no fractions):");
			path = userIn.nextLine();
			file = new File(path);
			fileScanner = new Scanner(file);
			while(fileScanner.hasNextLine()){
				String line = fileScanner.nextLine();
				try{
					dec = Integer.parseInt(line);
				}catch(NumberFormatException e){
					System.out.println("Couldn't find an integer in the file, please try again.");
					e.printStackTrace();
					decToBin(true);
				}
			}
			System.out.println(realDecToBin(dec));
		}else{
			System.out.println("Enter your decimal here(No fractions please):");
			dec = userIn.nextInt();
			System.out.println(realDecToBin(dec));
		}
		System.exit(0);
	}
	public void binToDec(boolean fromFile) throws IOException{
		String path;
		int bin = 0;
		if(fromFile){
			System.out.println("Enter the path of file to covert to decimal(File must have binary numbers):");
			path = userIn.nextLine();
			file = new File(path);
			fileScanner = new Scanner(file);
			while(fileScanner.hasNextLine()){
				String line = fileScanner.nextLine();
				try{
					bin = Integer.parseInt(line);
				}catch(NumberFormatException e){
					System.out.println("Couldn't find any integers in the file, please try again.");
					e.printStackTrace();
					decToBin(true);
				}
			}
			System.out.println(realBinToDec(bin));
		}else{
			System.out.println("Enter your binary here:");
			bin = userIn.nextInt();
			System.out.println(realBinToDec(bin));
		}
		System.exit(0);
	}
	
	public int realDecToBin(int dec){
		String bin = "";
		while(dec > 0){
			if (dec % 2 == 0){
				bin += "0";
			}else{
				bin += "1";
			}
			dec = dec / 2;
		}
		return Integer.parseInt(bin);
	}
	public int realBinToDec(int bin){
		int dec = 0;
		String binStr = Integer.toString(bin);
		for(int i = 0; i < binStr.length(); i ++){
			dec = 2 * dec + Character.getNumericValue(binStr.charAt(i));
		}
		return dec;
	}
	public static void main (String[] args){
		try {
			new BinaryTranslator();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
