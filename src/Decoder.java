import java.util.*;
import java.io.*;
public class Decoder {


	//public static final int BITS = 12;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		FileInputStream in = new FileInputStream("encoded.txt");//reader
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("decoded.txt")));

		StringBuilder ans = new StringBuilder();
		byte[] bits = in.readAllBytes();
		for(int i =0;i<bits.length;i++)
		{
			//System.out.println(bits[i]+" "+toBinary(bits[i]));
			//out.print(toBinary(bits[i]));
		}

		StringBuilder binary = new StringBuilder();
		for(int i =0;i<bits.length;i++)
		{
			binary.append(toBinary(bits[i]));
		}

		System.out.println(binary);
		/*for(int i = 0 ;i<binary.length()-9;i+=9)
		{
			System.out.print(binary.substring(i,i+9)+" ");
		}System.out.println();
		 */

		ArrayList<Integer> binVals = new ArrayList<Integer>();

		for(int i = 0 ;i<=binary.length()-12;i+=12)
		{
			binVals.add(binaryValue(binary.substring(i,i+12)));
		}
		System.out.println(binVals);

		HashMap<Integer, String> dict = new HashMap<Integer,String>();
		for(int i = 0;i<256;i++)
			dict.put(i, ""+ (char)i);

		int nextVal = 256;
		int old = binVals.get(0);
		String s = dict.get(old);
		String c = ""+s.charAt(0);
		out.print(s);
		for(int i = 1;i<binVals.size();i++)
		{
			int next = binVals.get(i);
			if(!dict.containsKey(next))
			{
				s = dict.get(old);
				s = s+c;
			}
			else
			{
				s = dict.get(next);
			}
			out.print(s);
			c = ""+s.charAt(0);
			dict.put(nextVal, dict.get(old)+c);
			nextVal++;
			old = next;
		}

		out.println();

		out.close();


	}
	public static int binaryValue(String a)
	{
		int ans = 0;
		for(int i = 0;i<12;i++)
		{
			if(a.charAt(i)=='1')
			{
				ans+=(1<<(11-i));
			}
		}
		return ans;
	}
	public static String toBinary(int a)
	{
		String cur =Integer.toBinaryString(a);
		StringBuilder ans = new StringBuilder();
		while(cur.length()+ans.length()<8)
		{
			ans.append("0");
		}
		if(cur.length()>8)
		{
			cur = cur.substring(cur.length()-8);
		}
		ans.append(cur);
		return ans.toString();
	}

}
