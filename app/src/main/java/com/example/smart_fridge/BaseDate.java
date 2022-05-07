package com.example.smart_fridge;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BaseDate extends SQLiteOpenHelper {


    static final String dbName="DataBaseOnAndroid";
    static final String employeeTable="Employees";
    static final String colID="EmployeeID";
    static final String colName="EmployeeName";
    static final String colDescription="Age";
    static final String colDept="Dept";

    static final String deptTable="ProductTable";
    static final String colDeptID="DeptID";
    static final String colDeptName="DeptName";

    static final String viewEmps="ViewEmps";
    private static  Context context;

    public BaseDate(){
        super(context, dbName,null,33);
    }


    public BaseDate(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE "+deptTable+" ("+
                colDeptID+" INTEGER PRIMARY KEY , "+
                colDeptName+" TEXT)");

        db.execSQL("CREATE TABLE "+employeeTable+
                " ("+colID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                colName+" TEXT, "+colDescription+" TEXT);");

        db.execSQL("CREATE TRIGGER fk_empdept_deptid "+
                " BEFORE INSERT "+
                " ON "+employeeTable+

                " FOR EACH ROW BEGIN"+
                " SELECT CASE WHEN ((SELECT "+colDeptID+" FROM "+
                deptTable+" WHERE "+colDeptID+"=new."+colDept+" ) IS NULL)"+
                " THEN RAISE (ABORT,'Foreign Key Violation') END;"+
                " END;");

        db.execSQL("CREATE VIEW "+viewEmps+
                " AS SELECT "+employeeTable+"."+colID+" AS _id,"+
                " "+employeeTable+"."+colName+","+
                " "+employeeTable+"."+colDescription+","+
                " "+deptTable+"."+colDeptName+""+
                " FROM "+employeeTable+" JOIN "+deptTable+
                " ON "+employeeTable+"."+colDept+" ="+deptTable+"."+colDeptID
        );
//Inserts pre-defined departments


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    SQLiteDatabase db=this.getWritableDatabase();
    ContentValues cv=new ContentValues();

    public void SetParametersOnTable(String nameProd) {

        int i = 0;
        cv.put(colDeptID,i++);
        cv.put(colDeptName,nameProd);
        db.insert(deptTable, colDeptID, cv);

    }
}
