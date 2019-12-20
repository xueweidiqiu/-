package pers.bwr.translaterForPerson.work.getContent;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import pers.bwr.translaterForPerson.work.getContent.fat.GetContent;


/**
 * 此方法是从txt文档中读取所有内容的方法
 * 使用：先构造ReadAllFromTxt(String readFrom)，传入参数为希望读取的文件名，
 * 然后调用getResult()方法获取结果，此方法的返回值为String类型。
 * 可能出现的问题：//请编写
 * @author v592128947
 *
 */
public class ReadAllFromTxt implements GetContent {
	String result = "无内容或获取失败";
	
	//读取文件相关的变量
	//String dataName;//传入的文件名
	String lineContent;//要读取的文件内容
	BufferedReader readin;//具体内容的阅读器
	InputStream dataStream;//文件的输入流
	
	public ReadAllFromTxt(String readFrom) {
		//读取文件相关的代码
		
		try {
			this.dataStream = new FileInputStream(new File(readFrom));//将文件名包装成file类并以此类创建输入流
			this.readin = new BufferedReader(new InputStreamReader(dataStream,"utf-8"));//用阅读器包装输入流并创建缓冲区
			this.result = "";//清空结果储存器，为读取操作做准备 
			while( (this.lineContent = readin.readLine() ) != null ){//使用缓冲阅读器的readLine方法读取其中一行的内容。
				this.result += this.lineContent;//将每一行的内容存入结果储存器
			}
			
			//return lineContent;//最终返回值
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
