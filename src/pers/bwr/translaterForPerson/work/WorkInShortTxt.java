package pers.bwr.translaterForPerson.work;

import java.io.IOException;
import java.util.HashSet;

import pers.bwr.translaterForPerson.lineReader.ReadLineFromShortTxt;
import pers.bwr.translaterForPerson.mode.TranslatePart;
import pers.bwr.translaterForPerson.translater.fat.Translater;
import pers.bwr.translaterForPerson.work.fac.Work;
import pers.bwr.translaterForPerson.work.getContent.GetFromTxt;
import pers.bwr.translaterForPerson.work.translate.TranslateOneLine;
import pers.bwr.translaterForPerson.work.translate.fac.Translate;

/**
 * ������ֻ����txt�е�һ�����ݵļ����̷�����
 * ʹ�÷�����
 * �ȴ������󣬴�������������ֱ���Ҫ��ȡ���ļ�����ʹ�õķ��빤�ߵ�set����
 * Ȼ���ٵ���getWorkResult()������������д���ļ���
 * ����Ĺ�������˵����1.��ȡtxt�ļ��������ݣ�1.���з��룬3.�������������txt�ļ���
 * @author v592128947
 *
 */

public class WorkInShortTxt implements Work {
	String txtLine = "������";
	HashSet<TranslatePart> translateMode;
	//String txtName;
	Class<Translater> translaterClass;//ͨ�����䴴���������ʱʹ�õĶ���
	String translateResult = "";
	Translate translate;

	public WorkInShortTxt(String readFrom,HashSet<TranslatePart> translateMode) {
		//this.txtName = readFrom;
		this.translateMode = translateMode;
	
	
		txtLine = new GetFromTxt(readFrom).getResult();
		
		translate = new TranslateOneLine(txtLine,translateMode);
		translateResult += translate.getTranslateResult();
		
		//System.out.println(translateResult);
	}
	
	@Override
	public String getWorkResult() {
		//��ǰ�Ĵ���ʽ�ǽ���������ϲ㴦���뾡���дд���ļ��ķ���
		return translateResult;
	}

}
