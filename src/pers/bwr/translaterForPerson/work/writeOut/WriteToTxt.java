package pers.bwr.translaterForPerson.work.writeOut;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import pers.bwr.translaterForPerson.work.writeOut.fac.Write;

public class WriteToTxt implements Write {
	public WriteToTxt(String writeContent , String toThisFile) {
		/*
		 * �Ǳ��˴���
		 */
		FileOutputStream fos = null;
        File file;
        String mycontent = writeContent;
        try {
            // ָ��д���ļ���·��
            file = new File(toThisFile);
            fos = new FileOutputStream(file);
            /* �ȼ���ļ��Ƿ���ڣ�������������ȴ���*/ 
            if (!file.exists()) {
                file.createNewFile();
            }
            /*
             * �ַ���������û��ֱ��д���ļ���������Ҫ��ʹ��getBytesת��Ϊbytes��
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
