package pers.bwr.translaterForPerson.lineReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import pers.bwr.translaterForPerson.lineReader.fac.LineReader;

/**
 * 从只有一句话的txt中读取的方法,该方法只能读取txt文件的第一行，
 * 如果文件不存在，可能会发生未知错误。
 * 使用方法：实例化此类（ReadLineFromShortTxt）并调用readLine（String dataName）方法。
 * 此方法将返回值文件第一行内容。（传入的文件名应包含“。txt”扩展名，即应传入文件全名）
 * @author 黑色的白兔子（592128947@qq。com）
 *
 */

/**
 * 目前只有
 * pers.bwr.translaterForPerson.work.getContent.GetOneLineFromTxt类
 * 调用了此方法，因此此方法可能在后期优化时进行整合删除
 * @author v592128947
 *
 */
public class ReadLineFromShortTxt implements LineReader {
	//String dataName;//传入的文件名
	String lineContent;//要读取的文件内容
	BufferedReader readin;//具体内容的阅读器
	InputStream dataStream;//文件的输入流
	
	@Override
	public String readLine(String dataName) throws IOException {
		dataStream = new FileInputStream(new File(dataName));//将文件名包装成file类并以此类创建输入流
		readin = new BufferedReader(new InputStreamReader(dataStream,"utf-8"));//用阅读器包装输入流并创建缓冲区
		lineContent = readin.readLine();//使用缓冲阅读器的readLine方法读取其中一行的内容。
		return lineContent;//最终返回值
	}

}
