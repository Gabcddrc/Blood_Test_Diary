/**
 * Spreadsheet import service
 *
 * @Author Yilei Liang
 */



/**
 * IMPORTANT NOTICE: This Service will not work properly if the speradsheet is not well-defined!!! (As shown in example spreadsheet file)
 * Therefore in order to test it, delete the third workbook in Shared Care DB!!
 *
 *
 * NOTE: Email Address NOT IN spreadsheet
 */
package com.blood.service;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import com.blood.service.Patient.Service;
import com.blood.pojo.Patient;
public class ImportService{
    private PatientService patientService;

    /**
     * Load the spreadsheet to database
     * @param fileLocation -- URL of the spreadsheet
     */
    public void load(String fileLocation) {
        try {
            FileInputStream file = new FileInputStream(new File(fileLocation));
            Workbook workbook = new XSSWorkbook(file);
            //For each sheet (as some spreadsheet contains multiple sheet)
            for (Sheet sheet : workbook) {
                Iterator<Row> rowIterator = datatypeSheet.iterator();
                Row curRow = iterator.next(); //Skip the first row
                while (iterator.hasNext()){
                    curRow = iterator.next();
                    Iterator<Cell> cellIterator = currentRow.iterator();
                    //Process the data import here
                    //Format: SN, FN, HOSPITAL, DOB, AGE, SEX, DIAG, TRANSP, LOCAL_HO/SURG/, CONTACT NO,  COMMENT
                    Patient patient = new Patient();
                    Cell curCell = cellIterator.next(); //SURNAME
                    patient.setSuername(curCell.getStringCellValue());
                    curCell = cellIterator.next();//Forename
                    patient.setForename(curCell.getStringCellValue());
                    curCell = cellIterator.next(); //Hospital No
                    //Insert any Data here?
                    curCell = cellIterator.next(); //DOB: Need to use the date today & DOB to calculate
                    patient.setDOB(curCell.getStringCellValue());
                    curCell = cellIterator.next(); //Age
                    curCell = cellIterator.next(); //Sex
                    patient.setSex(curCell.getStringCellValue());
                    curCell = cellIterator.next(); //Diagnosis
                    patient.setDiagnosis(curCell.getStringCellValue());
                    curCell = cellIterator.next(); //Transplant
                    patient.setTransplant(curCell.getStringCellValue());
                    curCell = cellIterator.next();//Local Hospital/Surgery
                    patient.setLocal_hospital(curCell.getStringCellValue());
                    curCell = cellIterator.next(); //Contact No for bloods
                    //Something here?
                    curCell = cellIterator.next(); //Comments
                    patient.setComments(curCell.getStringCellValue);
                    curCell = cellIterator.next();//TAC
                    patientService.add(patient); //Add the patient to DB
                }
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
