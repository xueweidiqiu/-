package pers.bwr.translaterForPerson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import pers.bwr.translaterForPerson.initialization.IniReader;
import pers.bwr.translaterForPerson.mode.part.WorkPart;
import pers.bwr.translaterForPerson.work.WorkInShortTxt;
import pers.bwr.translaterForPerson.work.fac.Work;

public class StartOfTranslater {

	public static void main(String[] args) {
		//��ʽ����
		
		//�����ô���
		
		/* //����ö��
		ReadingMode test = ReadingMode.ReadLineFromShortTxt;
		System.out.println(test.name());
		*/
		
		/*�����Դ�txt�ж�ȡһ�еĴ���
		try {
			String txtLine = new ReadLineFromShortTxt().readLine("oneLine.txt");
			System.out.println(txtLine);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//���Դ�txt�ж�ȡһ�еĴ��룩*/
		
		Map ini = new HashMap();
		
		//�����Դ�txt�ж�ȡ����
		try {
			IniReader nrdr = new IniReader();
			ini = nrdr.readIni();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//�����Դ�txt�ж�ȡ����
		
		//���Դ�ShortTxt�ж�ȡ
		Work workPro = new WorkInShortTxt();
		workPro.getTranslateResult(ini.get(WorkPart.ReadingFrom).toString());
		
	}

}
