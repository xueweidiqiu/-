package pers.bwr.translaterForPerson.lineReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import pers.bwr.translaterForPerson.lineReader.fac.LineReader;

/**
 * ��ֻ��һ�仰��txt�ж�ȡ�ķ���,�÷���ֻ�ܶ�ȡtxt�ļ��ĵ�һ�У�
 * ����ļ������ڣ����ܻᷢ��δ֪����
 * ʹ�÷�����ʵ�������ࣨReadLineFromShortTxt��������readLine��String dataName��������
 * �˷���������ֵ�ļ���һ�����ݡ���������ļ���Ӧ��������txt����չ������Ӧ�����ļ�ȫ����
 * @author ��ɫ�İ����ӣ�592128947@qq��com��
 *
 */

/**
 * Ŀǰֻ��
 * pers.bwr.translaterForPerson.work.getContent.GetOneLineFromTxt��
 * �����˴˷�������˴˷��������ں����Ż�ʱ��������ɾ��
 * @author v592128947
 *
 */
public class ReadLineFromShortTxt implements LineReader {
	//String dataName;//������ļ���
	String lineContent;//Ҫ��ȡ���ļ�����
	BufferedReader readin;//�������ݵ��Ķ���
	InputStream dataStream;//�ļ���������
	
	@Override
	public String readLine(String dataName) throws IOException {
		dataStream = new FileInputStream(new File(dataName));//���ļ�����װ��file�ಢ�Դ��ഴ��������
		readin = new BufferedReader(new InputStreamReader(dataStream,"utf-8"));//���Ķ�����װ������������������
		lineContent = readin.readLine();//ʹ�û����Ķ�����readLine������ȡ����һ�е����ݡ�
		return lineContent;//���շ���ֵ
	}

}
