package pers.bwr.translaterForPerson.work;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

import pers.bwr.translaterForPerson.mode.TranslatePart;
import pers.bwr.translaterForPerson.work.fac.Work;
import pers.bwr.translaterForPerson.work.getContent.ReadAllFromTxt;
import pers.bwr.translaterForPerson.work.getContent.fat.GetContent;
import pers.bwr.translaterForPerson.work.translate.TranslateOneLine;
import pers.bwr.translaterForPerson.work.translate.fac.Translate;
import pers.bwr.translaterForPerson.work.writeOut.WriteToTxt;

public class WorkInLongTxtWithRandom implements Work {
	String translateResult = "";//���������ַ���
	String writeTo;//Ҫд����ļ���
	Translate translate;//���÷�����Ķ���

	public WorkInLongTxtWithRandom(String readFrom , HashSet<TranslatePart> translateMode , String writeTo) {
		this.writeTo = writeTo;
		
		//�ȴ��ĵ��ж�ȡ���е��ַ���
		GetContent readContent = new ReadAllFromTxt(readFrom);
		//System.out.println(readContent.getResult());
		String theContent = readContent.getResult();
		
		//Ȼ��ͨ���س��;�β�����ַ������зָ�
		theContent = theContent.replaceAll("\\?", "?������");
		theContent = theContent.replaceAll("\\.", ".������");
		theContent = theContent.replaceAll("\\!", "!������");
		//ȥ�����е����ӷ�
		theContent = theContent.replaceAll("-", "");
		
		String[] eachLine = theContent.split("������", 0);
		//System.out.println(eachLine[1]);
		
		int i = 0;
		//�Էָ������ݽ�����䷭�루ҵ���߼�ͬWorkInShortTxt��
		for(String lineText:eachLine) {
			translate = new TranslateOneLine(lineText,translateMode);
			translateResult += translate.getTranslateResult() + "\n";
			
			i++;
			int j = eachLine.length;
			try {
				Random rand = new Random();
				Thread.sleep(1000 + rand.nextInt(1000) );
				System.out.println("�ѷ���" + i + "�䣬��" + j + "��");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//new WorkInShortTxt(readFrom , translateMode , writeTo).getWorkResult();
	}
	
	
	public String getWorkResult() {
		new WriteToTxt(translateResult , writeTo);
		
		//�������ϲ㷵��д�������
		return translateResult;
	}

}
