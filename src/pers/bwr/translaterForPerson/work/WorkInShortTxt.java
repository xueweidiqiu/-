package pers.bwr.translaterForPerson.work;

import java.io.IOException;
import java.util.HashSet;

import pers.bwr.translaterForPerson.lineReader.ReadLineFromShortTxt;
import pers.bwr.translaterForPerson.mode.TranslatePart;
import pers.bwr.translaterForPerson.translater.fat.Translater;
import pers.bwr.translaterForPerson.work.fac.Work;

/**
 * ������ֻ����txt�е�һ�����ݵļ����̷�����
 * ʹ�÷�����
 * �ȴ������󣬴�������������ֱ���Ҫ��ȡ���ļ�����ʹ�õķ��빤�ߵ�set����
 * Ȼ���ٵ���getTranslateResult()������������д���ļ���
 * @author v592128947
 *
 */

public class WorkInShortTxt implements Work{
	String txtLine = "������";
	HashSet<TranslatePart> translateMode;
	String txtName;
	Class<Translater> translaterClass;//ͨ�����䴴���������ʱʹ�õĶ���

	public WorkInShortTxt(String readFrom,HashSet<TranslatePart> translateMode) {
		this.txtName = readFrom;
		this.translateMode = translateMode;
	}
	
	@SuppressWarnings("unchecked")
	@Override	
	public String getTranslateResult() {
		// TODO Auto-generated method stub
		//LineReader.readLine();
		
		//��txt�ж�ȡһ�еĴ���
		try {
			txtLine = new ReadLineFromShortTxt().readLine(txtName);
			//System.out.println(txtLine);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(TranslatePart translatePart:translateMode) {
			try {
				this.translaterClass = (Class<Translater>) Class.forName("pers.bwr.translaterForPerson.translater." + translatePart.toString());
				System.out.println(translaterClass);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//return Translater.translateLine();
		return null;
	}

}
