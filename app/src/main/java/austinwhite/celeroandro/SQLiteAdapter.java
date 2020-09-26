package austinwhite.celeroandro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteAdapter {

    public static final String MYDATABASE_NAME = "CUSTOMER_INFO";
    public static final String MYDATABASE_TABLE = "MY_TABLE";
    public static final int MYDATABASE_VERSION = 1;
    public static final String KEY_ID = "_id";
    public static final String KEY_CustomerIdentifier = "CustomerIdentifier";
    public static final String KEY_VisitOrder = "VisitOrder";
    public static final String KEY_Name = "Name";
    public static final String KEY_Number = "Number";
    public static final String KEY_StreetAddress = "StreetAddress";
    public static final String KEY_CityAddress = "CityAddress";
    public static final String KEY_StateAddress = "StateAddress";
    public static final String KEY_PostalCodeAddress = "PostalCodeAddress";
    public static final String KEY_Latitude = "Latitude";
    public static final String KEY_Longitude = "Longitude";




    //create table MY_DATABASE (ID integer primary key, Content text not null);
    private static final String SCRIPT_CREATE_DATABASE =
            "create table " + MYDATABASE_TABLE + " ("
                    + KEY_ID + " integer primary key autoincrement, "
                    + KEY_CustomerIdentifier + " text not null, "
                    + KEY_VisitOrder + " text not null, "
                    + KEY_Name + " text not null, "
                    + KEY_Number + " text not null, "
                    + KEY_StreetAddress + " text not null, "
                    + KEY_CityAddress + " text not null, "
                    + KEY_StateAddress + " text not null, "
                    + KEY_PostalCodeAddress + " text not null, "
                    + KEY_Latitude + " text not null, "
                    + KEY_Longitude + " text not null );";


    private SQLiteHelper sqLiteHelper;
    private SQLiteDatabase sqLiteDatabase;

    private Context context;

    public SQLiteAdapter(Context c){
        context = c;
    }

    public SQLiteAdapter openToRead() throws android.database.SQLException {
        sqLiteHelper = new SQLiteHelper(context, MYDATABASE_NAME, null, MYDATABASE_VERSION);
        sqLiteDatabase = sqLiteHelper.getReadableDatabase();
        return this;
    }

    public SQLiteAdapter openToWrite() throws android.database.SQLException {
        sqLiteHelper = new SQLiteHelper(context, MYDATABASE_NAME, null, MYDATABASE_VERSION);
        sqLiteDatabase = sqLiteHelper.getWritableDatabase();
        return this;
    }

    public void close(){
        sqLiteHelper.close();
    }

    public long insert(String[] content,
                       String[] content1,
                       String[] content2,
                       String[] content3,
                       String[] content4,
                       String[] content5,
                       String[] content6,
                       String[] content7){

        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_CustomerIdentifier, content.toString());
        contentValues.put(KEY_VisitOrder, content.toString());
        contentValues.put(KEY_Name, content.toString());
        contentValues.put(KEY_Number, content1.toString());
        contentValues.put(KEY_StreetAddress, content2.toString());
        contentValues.put(KEY_CityAddress, content3.toString());
        contentValues.put(KEY_StateAddress, content4.toString());
        contentValues.put(KEY_PostalCodeAddress, content5.toString());
        contentValues.put(KEY_Latitude, content6.toString());
        contentValues.put(KEY_Longitude, content7.toString());


        return sqLiteDatabase.insert(MYDATABASE_TABLE, null, contentValues);
    }

    public int deleteAll(){
        return sqLiteDatabase.delete(MYDATABASE_TABLE, null, null);
    }

    public Cursor queueAll(){
        String[] columns = new String[]{KEY_ID,
                KEY_CustomerIdentifier,
                KEY_VisitOrder,
                KEY_Name,
                KEY_Number,
                KEY_StreetAddress,
                KEY_CityAddress,
                KEY_StateAddress,
                KEY_PostalCodeAddress
        };
        Cursor cursor = sqLiteDatabase.query(MYDATABASE_TABLE, columns,null, null, null, null, null);

        return cursor;
    }

    public class SQLiteHelper extends SQLiteOpenHelper {

        public SQLiteHelper(Context context, String name,
                            SQLiteDatabase.CursorFactory factory, int version) {
            super(context,
                    name,
                    factory,
                    version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            // TODO Auto-generated method stub
            db.execSQL(SCRIPT_CREATE_DATABASE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // TODO Auto-generated method stub

        }

    }

}
