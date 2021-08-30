package Ex13_11;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class demo {
/*
 * 다음은 오래된 단어 퍼즐이다: "엄청나고, 놀랍고, 끔찍한 단어 말고도, 'dous'로 끝나는 일반적인 단어의 이름을 대라."
잠시 이것에 대해 생각해보면 아마 당신에게 다가올 것입니다. 
그러나, 우리는 또한 영어 단어의 텍스트 파일을 읽고 끝에 "dous"가 포함되어 있다면 그 단어를 출력함으로써 이 퍼즐을 풀 수 있다.
텍스트 파일 "words.txt"는 퍼즐을 완성하는 단어를 포함하여 87314개의 영어 단어를 포함하고 있다.
 이 파일은 책의 소스 코드로 온라인에서 사용할 수 있습니다. 
텍스트 파일에서 각 단어를 읽고 마지막에 "dous"가 포함된 단어만 출력하여 퍼즐을 푸는 프로그램을 작성한다.
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
