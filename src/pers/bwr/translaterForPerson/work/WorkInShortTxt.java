package pers.bwr.translaterForPerson.work;

import java.io.IOException;

import pers.bwr.translaterForPerson.lineReader.ReadLineFromShortTxt;
import pers.bwr.translaterForPerson.work.fac.Work;

public class WorkInShortTxt implements Work{
	String txtLine;

	@Override
	public String getTranslateResult(String readFrom) {
		// TODO Auto-generated method stub
		//LineReader.readLine();
		
		//��txt�ж�ȡһ�еĴ���
		try {
			txtLine = new ReadLineFromShortTxt().readLine(readFrom);
			System.out.println(txtLine);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//return Translater.translateLine();
		return null;
	}

}
