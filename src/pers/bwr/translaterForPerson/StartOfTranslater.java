package pers.bwr.translaterForPerson;

import java.io.IOException;

import pers.bwr.translaterForPerson.initialization.IniReader;

public class StartOfTranslater {

	public static void main(String[] args) {
		//正式代码
		
		//测试用代码
		
		/* //测试枚举
		ReadingMode test = ReadingMode.ReadLineFromShortTxt;
		System.out.println(test.name());
		*/
		
		/*（测试从txt中读取一行的代码
		try {
			String txtLine = new ReadLineFromShortTxt().readLine("oneLine.txt");
			System.out.println(txtLine);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//测试从txt中读取一行的代码）*/
		
		//》测试从txt中读取配置
		try {
			IniReader nrdr = new IniReader();
			System.out.println(nrdr.readIni());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//《测试从txt中读取配置
		
	}

}
