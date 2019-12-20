package pers.bwr.translaterForPerson.work.getContent;

import java.io.IOException;

import pers.bwr.translaterForPerson.lineReader.ReadLineFromShortTxt;
import pers.bwr.translaterForPerson.work.getContent.fat.GetContent;

public class GetOneLineFromTxt implements GetContent {
	String txtLine = "无内容";
	
	public GetOneLineFromTxt(String txtName) {
		//从txt中读取一行的代码
		try {
			this.txtLine = new ReadLineFromShortTxt().readLine(txtName);
			//System.out.println(txtLine);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public String getResult() {
		return txtLine;
	}
	
}
