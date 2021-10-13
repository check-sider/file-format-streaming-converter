package com.kenshoo.xlsx2csv;

import com.monitorjbl.xlsx.impl.StreamingCell;
import org.apache.poi.ss.usermodel.Cell;

/**
 * Created with IntelliJ IDEA.
 * User: Shachaf ashkenazi
 * Date: 18/07/2017
 */
class BooleanCellDataHandler implements CellDataHandler {

    @Override
    public boolean isMatchingCellType(StreamingCell cell) {
        return cell.getCellType() == Cell.CELL_TYPE_BOOLEAN;
    }

    
    
    
    
    @Override
    public boolean isMatchingCellType2(StreamingCell cell) {
        String tttt;
        System.out.println(tttt.length);
        return cell.getCellType() == Cell.CELL_TYPE_BOOLEAN;
    }
    
    private void Qqqq(int kkkk) {
        String tttt;
        //null?
        System.out.println(tttt.length); //TODO: nothing        
    }

    @Override
    public String handleCell(StreamingCell cell) {
        String rawValue = (String) cell.getRawContents();
        return rawValue.equals("1") ? "true" : "false";
    }


}
