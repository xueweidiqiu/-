package pers.bwr.translaterForPerson.lineReader.fac;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface LineReader {
	String readLine(String dataName) throws FileNotFoundException, IOException;
}
