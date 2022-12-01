package www.hrminiapp.com;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    static final String DBNAME = "Company.db";
    static final int VERSION = 1;
    static final String TABLE_NAME = "Employee";
    static final String COL1 = "id";
    static final String COL2 = "name";
    static final String COL3 = "designation";
    static final String COL4 = "department";
    static final String COL5 = "emailid";
    static final String COL6 = "salary";
    static final String CREATE_TABLE = "create table " + TABLE_NAME + " (" + COL1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL2 + " TEXT NOT NULL, " + COL3 + " TEXT, " + COL4 + " TEXT, " + COL5 + " TEXT, " + COL6 + " INTEGER); ";
    static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    public DBHelper(Context context) {
        super(context, DBNAME, null, VERSION);
    }

    //creates the table
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    //drops the table and recreates it
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DROP_TABLE);
        onCreate(sqLiteDatabase);
    }

    //inserts the employee object into the database
    public boolean InsertEmployee(Employee objEmp) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL2, objEmp.getName());
        cv.put(COL3, objEmp.getDesig());
        cv.put(COL4, objEmp.getDept());
        cv.put(COL5, objEmp.getEmailid());
        cv.put(COL6, objEmp.getSalary());
        long result = db.insert(TABLE_NAME, null, cv);
        return result != -1;
    }

    //returns a cursor object containing all the data from the database
    public Cursor ListEmployee() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + TABLE_NAME, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }
}
