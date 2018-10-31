/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_library;

import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Choxmi
 */
public class ResultsetHolder {
    
    public boolean modal_opened = false;
    public static String modalType;

    /**
     * @return the record
     */
    public static List<String> getRecord() {
        return record;
    }

    /**
     * @param aRecord the record to set
     */
    public static void setRecord(List<String> aRecord) {
        record = aRecord;
    }
    
    private static ResultSet results;
    private static List<String> record;
    
    /**
     * @return the results
     */
    public static ResultSet getResults() {
        return results;
    }

    /**
     * @param aResults the results to set
     */
    public static void setResults(ResultSet aResults, String type) {
        modalType = type;
        results = aResults;
    }
    
    
}
