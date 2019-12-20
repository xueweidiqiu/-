package pers.bwr.translaterForPerson.work.getContent;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import pers.bwr.translaterForPerson.work.getContent.fat.GetContent;


/**
 * �˷����Ǵ�txt�ĵ��ж�ȡ�������ݵķ���
 * ʹ�ã��ȹ���ReadAllFromTxt(String readFrom)���������Ϊϣ����ȡ���ļ�����
 * Ȼ�����getResult()������ȡ������˷����ķ���ֵΪString���͡�
 * ���ܳ��ֵ����⣺//���д
 * @author v592128947
 *
 */
public class ReadAllFromTxt implements GetContent {
	String result = "�����ݻ��ȡʧ��";
	
	//��ȡ�ļ���صı���
	//String dataName;//������ļ���
	String lineContent;//Ҫ��ȡ���ļ�����
	BufferedReader readin;//�������ݵ��Ķ���
	InputStream dataStream;//�ļ���������
	
	public ReadAllFromTxt(String readFrom) {
		//��ȡ�ļ���صĴ���
		
		try {
			this.dataStream = new FileInputStream(new File(readFrom));//���ļ�����װ��file�ಢ�Դ��ഴ��������
			this.readin = new BufferedReader(new InputStreamReader(dataStream,"utf-8"));//���Ķ�����װ������������������
			this.result = "";//��ս����������Ϊ��ȡ������׼�� 
			while( (this.lineContent = readin.readLine() ) != null ){//ʹ�û����Ķ�����readLine������ȡ����һ�е����ݡ�
				this.result += this.lineContent;//��ÿһ�е����ݴ�����������
			}
			
			//return lineContent;//���շ���ֵ
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public String getResult() {
		// TODO Auto-generated method stub
		return result;
	}

}
