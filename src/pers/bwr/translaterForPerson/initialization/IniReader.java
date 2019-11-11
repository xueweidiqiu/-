package pers.bwr.translaterForPerson.initialization;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
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
 * 
 * �����׳����쳣��IO�쳣
 * @author ��ɫ�İ����ӣ�592128947@qq.com��
 *
 */

public class IniReader {
	String iniLine;//�����ļ�ÿһ�е�����
	BufferedReader readin;//�������ݵ��Ķ���
	InputStream iniStream;//�����ļ���������
	Map<WorkPart, Object> iniContents;//Ҫ���ص�ֵ
	String iniName;//�����ļ�������
	//ReadingMode readingMode;
	
	//�����ε�Ĭ�Ϲ��췽ʽ
	IniReader(){
		this("ini.txt");
	}
	
	//���������ļ����Ĺ��췽��
	//���ǹ��췽�������ڸ÷������޸������ļ����е���Ŀ
	IniReader(String iniName) {
		this.iniName = iniName;
		iniContents = new HashMap<WorkPart , Object>();//��ʼ��
		
		//readingMode = ReadingMode.ReadLineFromShortTxt;
		//
		iniContents.put(WorkPart.ReadingMode , ReadingMode.ReadLineFromShortTxt);
		iniContents.put(WorkPart.TranslateMode, TranslateMode.getTranslateMode());
	}
	
	//��ȡ����
	public Map<WorkPart, Object> readIni() throws IOException {
		iniStream = new FileInputStream(new File(iniName));//�������ļ���װ��file�ಢ�Դ��ഴ��������
		readin = new BufferedReader(new InputStreamReader(iniStream));//���Ķ�����װ������������������
		//iniLine = readin.readLine();//ʹ�û����Ķ�����readLine������ȡ����һ�е����ݡ�
		
		//���ж�ȡ�����ļ�
		while( (iniLine = readin.readLine()) != null){//�жϷ�ʽ���ܴ��ڳ��ֿ���ɨ��ֹͣ�����������������������
			//�жϴ����Ƿ�Ϊע������
			if(iniLine.startsWith("#")){
				break;
			}
			//�ж϶�ȡ�跭����ı��ķ�ʽ
			if(iniLine.startsWith("Reading:")){
				//����б�д
			}
		}
		
		return iniContents;//���շ���ֵ
	}
}
