package pers.bwr.translaterForPerson;

import java.io.IOException;

import pers.bwr.translaterForPerson.lineReader.ReadLineFromShortTxt;

public class StartOfTranslater {

	public static void main(String[] args) {
		//��ʽ����
		
		//�����ô���
		//���Դ�txt�ж�ȡһ�еĴ���
		try {
			String txtLine = new ReadLineFromShortTxt().readLine("oneLine.txt");
			System.out.println(txtLine);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		///���Դ�txt�ж�ȡһ�еĴ���
	}

}
