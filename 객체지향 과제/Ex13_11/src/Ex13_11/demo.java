package Ex13_11;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class demo {
/*
 * ������ ������ �ܾ� �����̴�: "��û����, �����, ������ �ܾ� ����, 'dous'�� ������ �Ϲ����� �ܾ��� �̸��� ���."
��� �̰Ϳ� ���� �����غ��� �Ƹ� ��ſ��� �ٰ��� ���Դϴ�. 
�׷���, �츮�� ���� ���� �ܾ��� �ؽ�Ʈ ������ �а� ���� "dous"�� ���ԵǾ� �ִٸ� �� �ܾ ��������ν� �� ������ Ǯ �� �ִ�.
�ؽ�Ʈ ���� "words.txt"�� ������ �ϼ��ϴ� �ܾ �����Ͽ� 87314���� ���� �ܾ �����ϰ� �ִ�.
 �� ������ å�� �ҽ� �ڵ�� �¶��ο��� ����� �� �ֽ��ϴ�. 
�ؽ�Ʈ ���Ͽ��� �� �ܾ �а� �������� "dous"�� ���Ե� �ܾ ����Ͽ� ������ Ǫ�� ���α׷��� �ۼ��Ѵ�.
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String inputfilename ="C:\\Users\\82108\\eclipse-workspace\\Ex13_11\\words.txt";
		Scanner inputStream = null;
		String s="";
		try {
			inputStream= new Scanner(new File(inputfilename));
		}
		catch(FileNotFoundException e) {
			System.out.println("Error opening name "+inputfilename);
			System.exit(0);
		}
		String outputfilename ="with_dous.txt";
		PrintWriter outputStream = null;
		try {
			outputStream= new PrintWriter(outputfilename);
		}
		catch(FileNotFoundException e) {
			System.out.println("Error opening name "+outputfilename);
			System.exit(0);
		}
		while(inputStream.hasNext()) {
			s=inputStream.next();
			int len=s.length();
			if(len>=4&&s.charAt(len-4)=='d'&&s.charAt(len-3)=='o'&&s.charAt(len-2)=='u'&&s.charAt(len-1)=='s') {
				outputStream.println(s);
				System.out.println(s);
			}
		}
		
		
		inputStream.close();
		outputStream.close();
	}

}
