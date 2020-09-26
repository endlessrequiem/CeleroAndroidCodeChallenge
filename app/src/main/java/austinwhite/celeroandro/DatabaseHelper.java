package austinwhite.celeroandro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String MYDATABASE_NAME = "CUSTOMER_INFO";
    public static final String MYDATABASE_TABLE = "MY_TABLE";
    public static final int MYDATABASE_VERSION = 1;
    public static final String COL_CustomerIdentifier = "CustomerIdentifier";
    public static final String COL_VisitOrder = "VisitOrder";
    public static final String COL_Name = "Name";
    public static final String COL_Number = "Number";
    public static final String COL_ServiceIssue = "ServiceIssue";
    public static final String COL_StreetAddress = "StreetAddress";
    public static final String COL_CityAddress = "CityAddress";
    public static final String COL_StateAddress = "StateAddress";
    public static final String COL_PostalCodeAddress = "PostalCodeAddress";
    public static final String COL_Latitude = "Latitude";
    public static final String COL_Longitude = "Longitude";
    public static final String COL_CustomerPicture = "CustomerPicture";



    public DatabaseHelper(Context context) {
        super(context, MYDATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();


    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + MYDATABASE_TABLE + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " ITEM1 TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("create table " + MYDATABASE_TABLE + " ( Id INTEGER PRIMARY KEY,NAME TEXT ) ");
        Log.e("DB CREATE","DATABASE CREATE");

    }

    public void addData(int customerIdentifier,
                        int visitOrder,
                        String name,
                        String customerPhoneNumber,
                        String serviceIssue,
                        String address,
                        double latitude,
                        double longitude,
                        String customerPicture
    ) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_CustomerIdentifier, customerIdentifier);
        contentValues.put(COL_VisitOrder, visitOrder);
        contentValues.put(COL_Name, name);
        contentValues.put(COL_Number,customerPhoneNumber);
        contentValues.put(COL_ServiceIssue, serviceIssue);
        contentValues.put(COL_StreetAddress, address);
        contentValues.put(COL_Latitude, latitude);
        contentValues.put(COL_Longitude, longitude);
        contentValues.put(COL_CustomerPicture, customerPicture);


        db.insert(MYDATABASE_TABLE, null, contentValues);

    }
    public Cursor getListContents(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + MYDATABASE_TABLE, null);
        return data;
    }

}
