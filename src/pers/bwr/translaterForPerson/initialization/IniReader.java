package pers.bwr.translaterForPerson.initialization;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import pers.bwr.translaterForPerson.mode.ReadingMode;
import pers.bwr.translaterForPerson.mode.TranslateMode;
import pers.bwr.translaterForPerson.mode.TranslatePart;
import pers.bwr.translaterForPerson.mode.part.WorkPart;

/**
 * �����ļ��Ķ������뽫�����ļ�����Ϊ
 * ��ini.txt��,���ʼ������ʱ�������ļ����ļ�ȫ������
 * ���๦�ܣ���ȡ�����ļ���
 * �����ذ����˹�����ʽ��HashMap<ĳһ���ֹ������乤����ʽ>
 * ʹ�÷��������г�ʼ�������readIni()������ȡ����ֵ
 * �����׳����쳣��IO�쳣
 * @author ��ɫ�İ����ӣ�592128947@qq.com��
 *
 */

public class IniReader {
	String iniLine;//�����ļ�ÿһ�е�����
	BufferedReader readin;//�������ݵ��Ķ���
	InputStream iniStream;//�����ļ���������
	Map<WorkPart, Object> iniContents;//Ҫ���ص�ֵ��ͨ��map�洢������Ϣ
	String iniName;//�����ļ�������
	//ReadingMode readingMode;
	
	/*
	//�����ñ���
	File testFile;
	int i = 0;
	*/
	
	//�����ε�Ĭ�Ϲ��췽ʽ
	public IniReader() throws FileNotFoundException{
		this("ini.txt");
	}
	
	//���������ļ����Ĺ��췽��
	//���ǹ��췽�������ڸ÷������޸������ļ����е���Ŀ
	public IniReader(String iniName) throws FileNotFoundException {
		this.iniName = iniName;
		iniContents = new HashMap<WorkPart , Object>();//��ʼ��
		
	}
	
	//��ȡ����
	public Map<WorkPart, Object> readIni() throws IOException {
		iniStream = new FileInputStream(new File(iniName));//�������ļ���װ��file�ಢ�Դ��ഴ��������
		
		/*//�����ó�ʼ������
		testFile = new File(iniName);
		iniStream = new FileInputStream(testFile);
		*/
		
		readin = new BufferedReader(new InputStreamReader(iniStream));//���Ķ�����װ������������������
		//iniLine = readin.readLine();//ʹ�û����Ķ�����readLine������ȡ����һ�е����ݡ�
		
		//���ж�ȡ�����ļ�
		while( (iniLine = readin.readLine()) != null){//�жϷ�ʽ���ܴ��ڳ��ֿ���ɨ��ֹͣ�����������������������
			//�жϴ����Ƿ�Ϊע������
			if(iniLine.startsWith("#")){
				//System.out.println("��" + i + "��Ϊע��");
				continue;
			}
			//�ж϶�ȡ�跭����ı��ķ�ʽ
			if(iniLine.startsWith("Reading:")){
				iniContents.put(WorkPart.ReadingMode, ReadingMode.valueOf(iniLine.substring(8)));
			}
			//�ж�ʹ�õ�api
			if(iniLine.startsWith("Translater:")) {
				/*//���Դ���
				String partstring = iniLine.substring(11);
				TranslatePart TranPart = TranslatePart.valueOf(partstring);
				System.out.println(TranPart.values());
				TranslateMode.addTranslateMode(TranslatePart.BaiduFanyi);
				*/
				TranslateMode.addTranslateMode(TranslatePart.valueOf(iniLine.substring(11)));
			}
		}
		
		//readingMode = ReadingMode.ReadLineFromShortTxt;
		//��ȡ�������ڶ�ȡ������Ϣ�����жϵĹ����н��й��洢����������ٴ洢һ��
		//iniContents.put(WorkPart.ReadingMode , ReadingMode.ReadLineFromShortTxt);
		
		//������ʹ�õķ���ȫ������iniContents��Ϣ��
		iniContents.put(WorkPart.TranslateMode, TranslateMode.getTranslateMode());
		
		return iniContents;//���շ���ֵ
	}
}
