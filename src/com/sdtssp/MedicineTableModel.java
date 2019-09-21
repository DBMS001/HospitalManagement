/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sdtssp;

/**
 *
 * @author shreeram
 */
import java.util.List;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;
 
 
public class MedicineTableModel extends AbstractTableModel
{
    private final Vector<Medicine> medicineList;
     
    private final String[] columnNames = new String[] {
            "Select", "Name", "Batch", "QTY", "MRP", "AMT"
    };
    private final Class[] columnClass = new Class[] {
        Boolean.class , String.class, Integer.class,Integer.class,Integer.class,Integer.class
    };
 
    public MedicineTableModel(Vector<Medicine> medicineList)
    {
        this.medicineList = medicineList;
    }
    public Vector getMed(){
    return medicineList;
    }
    
    @Override
    public String getColumnName(int column)
    {
        return columnNames[column];
    }
 
    @Override
    public Class<?> getColumnClass(int columnIndex)
    {
        return columnClass[columnIndex];
    }
 
    @Override
    public int getColumnCount()
    {
        return columnNames.length;
    }
 
    @Override
    public int getRowCount()
    {
        return medicineList.size();
    }
 
    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        Medicine row = medicineList.get(rowIndex);
        if(0 == columnIndex) {
            return row.isSelect();
        }
        else if(1 == columnIndex) {
            return row.getName();
        }
        else if(2 == columnIndex) {
            return row.getBatch();
        }
        else if(3 == columnIndex) {
            return row.getQty();
        }
        else if(4 == columnIndex) {
            return row.getMrp();
        }
        else if(5 == columnIndex) {
            return row.getAmount();
        }

        return null;
    }
}
