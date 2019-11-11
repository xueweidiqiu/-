package pers.bwr.translaterForPerson.initialization;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

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
	static Map iniContents = new HashMap<Object , Object>();//Ҫ���ص�ֵ
	String iniName = "ini.txt";
	
	//�����ε�Ĭ�Ϲ��췽ʽ
	IniReader(){
		this("ini.txt");
	}
	
	//���������ļ����Ĺ��췽��
	IniReader(String iniName) {
		this.iniName = iniName;
	}
	
	public Map readIni() throws IOException {
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
