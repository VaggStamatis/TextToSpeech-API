/*ExcelReader Class
 * Responsible : for reading an Excel document
 * Created by : Evangelos Stamatis 
 * 				Antreas Katsantonis
 * 				Xristos Paraskevopoulos
 * For AdvancedText2SpeechEditor project on Software Engineering 
 * */
package input;

import java.util.ArrayList;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader implements DocumentReader {
	private String path;
	public ExcelReader(String path) {
		// TODO Auto-generated constructor stub
		this.path = path;
	}
	
	@Override
	public ArrayList<String> read() {
		// TODO Auto-generated method stub
		ArrayList<String> file_in = new ArrayList<String>();
        FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(new File(this.path));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
        Workbook workbook = null;
		try {
			workbook = new XSSFWorkbook(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = firstSheet.iterator();
         
        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();
             
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                 
                switch (cell.getCellType()) {
                    case STRING:
                        file_in.add(cell.getStringCellValue());
                        break;
                    case BOOLEAN:
                        file_in.add(cell.getStringCellValue());
                        break;
                    case NUMERIC:
                    	file_in.add(cell.getStringCellValue());
                        break;
				default:
					break;
                }
                file_in.add("\t | \t");
            }
            file_in.add("\n");
        }
         
        try {
			workbook.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        try {
			inputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return file_in;
	}



}
