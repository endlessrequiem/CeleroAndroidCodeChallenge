package austinwhite.celeroandro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.concurrent.atomic.AtomicReference;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String TAG = "DatabaseHelper";
    public static final String MYDATABASE_NAME = "CUSTOMER_INFO";
    public static final String MYDATABASE_TABLE = "MY_TABLE";
    public static final int MYDATABASE_VERSION = 1;
    public static final String COL_CustomerIdentifier = "CustomerIdentifier";
    public static final String COL_VisitOrder = "VisitOrder";
    public static final String COL_Name = "Name";
    public static final String COL_Number = "Number";
    public static final String COL_ServiceIssue = "ServiceIssue";
    public static final String COL_CustomerAddress = "CustomerAddress";
    public static final String COL_Latitude = "Latitude";
    public static final String COL_Longitude = "Longitude";
    public static final String COL_CustomerPicture = "CustomerPicture";



    public DatabaseHelper(Context context) {
        super(context, MYDATABASE_NAME, null, 1);

    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE MY_TABLE (ID INTEGER PRIMARY KEY AUTOINCREMENT, Name TEXT)";
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
        Log.d(TAG, "addData: Adding: " + customerIdentifier + " to " + MYDATABASE_TABLE);

        contentValues.put(COL_VisitOrder, visitOrder);
        Log.d(TAG, "addData: Adding: " + visitOrder + " to " + MYDATABASE_TABLE);

        contentValues.put(COL_Name, name);
        Log.d(TAG, "addData: Adding: " + name + " to " + MYDATABASE_TABLE);

        contentValues.put(COL_Number,customerPhoneNumber);
        Log.d(TAG, "addData: Adding: " + customerPhoneNumber + " to " + MYDATABASE_TABLE);

        contentValues.put(COL_ServiceIssue, serviceIssue);
        Log.d(TAG, "addData: Adding: " + serviceIssue + " to " + MYDATABASE_TABLE);

        contentValues.put(COL_CustomerAddress, address);
        Log.d(TAG, "addData: Adding: " + address + " to " + MYDATABASE_TABLE);

        contentValues.put(COL_Latitude, latitude);
        Log.d(TAG, "addData: Adding: " + latitude + " to " + MYDATABASE_TABLE);

        contentValues.put(COL_Longitude, longitude);
        Log.d(TAG, "addData: Adding: " + longitude + " to " + MYDATABASE_TABLE);

        contentValues.put(COL_CustomerPicture, customerPicture);
        Log.d(TAG, "addData: Adding: " + customerPicture + " to " + MYDATABASE_TABLE);


    }
    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM MY_TABLE";
        AtomicReference<Cursor> data = new AtomicReference<>(db.rawQuery(query, null));
        return data.get();
    }




}
