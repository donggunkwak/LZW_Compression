import java.util.*;
import java.io.*;
public class Testing {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		FileInputStream in = new FileInputStream("TestingFile.txt");
		
		System.out.println(in.read());
		
		/*
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("TestingFile.txt")));
		char c = 145;
		out.println((char)145);
		out.close();
		*/
		
	}

}
