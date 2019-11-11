package pers.bwr.translaterForPerson;

import java.io.IOException;

import pers.bwr.translaterForPerson.lineReader.ReadLineFromShortTxt;

public class StartOfTranslater {

	public static void main(String[] args) {
		//正式代码
		
		//测试用代码
		//测试从txt中读取一行的代码
		try {
			String txtLine = new ReadLineFromShortTxt().readLine("oneLine.txt");
			System.out.println(txtLine);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		///测试从txt中读取一行的代码
	}

}
