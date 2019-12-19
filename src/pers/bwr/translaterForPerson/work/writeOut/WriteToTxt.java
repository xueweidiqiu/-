package pers.bwr.translaterForPerson.work.writeOut;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import pers.bwr.translaterForPerson.work.writeOut.fac.Write;

public class WriteToTxt implements Write {
	public WriteToTxt(String writeContent , String toThisFile) {
		/*
		 * 非本人代码
		 */
		FileOutputStream fos = null;
        File file;
        String mycontent = writeContent;
        try {
            // 指定写入文件的路径
            file = new File(toThisFile);
            fos = new FileOutputStream(file);
            /* 先检测文件是否存在，如果不存在则先创建*/ 
            if (!file.exists()) {
                file.createNewFile();
            }
            /*
             * 字符串的内容没法直接写到文件，我们需要先使用getBytes转换为bytes。
             */
            byte[] bytesArray = mycontent.getBytes();
            fos.write(bytesArray);
            fos.flush();
            //System.out.println("File Written Successfully");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException ioe) {
                System.out.println("Error in closing the Stream");
            }
        }
	}
}
