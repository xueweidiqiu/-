package pers.bwr.translaterForPerson;

import java.io.IOException;

import pers.bwr.translaterForPerson.lineReader.ReadLineFromShortTxt;
import pers.bwr.translaterForPerson.mode.ReadingMode;

public class StartOfTranslater {

	public static void main(String[] args) {
		//��ʽ����
		
		//�����ô���
		//����ö��
		ReadingMode test = ReadingMode.ReadLineFromShortTxt;
		System.out.println(test.name());
		
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
