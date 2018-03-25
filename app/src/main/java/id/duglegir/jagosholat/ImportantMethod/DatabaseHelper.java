package id.duglegir.jagosholat.ImportantMethod;

/**
 * Created by Ikhsan Ramadhan on 11/03/2018.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import id.duglegir.jagosholat.ImportantMethod.DataContract;
import id.duglegir.jagosholat.ImportantMethod.DataContract.DataEntry;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Deklarasi Nama Database dan Versinya ------------------
    private static final String DATABASE = "jagosholat.db";
    private static final int DATABASE_VERSION = 1;
    // -------------------------------------------------------

    // Deklarasi SQL Create dan Upgrade Table dalam bentuk variable string -------
    private String sql_drop_table;
    private String sql_create_table;
    // ---------------------------------------------------------------------------

    // Variable ini gunanya adalah untuk mendapatkan fungsi dari library SQLiteDatabase ---
    private SQLiteDatabase sqLiteDatabase = getWritableDatabase();
    // ada dua macam, "WriteableDatabase" dan "ReadableDatabase"

    private long result; // result ini untuk mendapatkan boolean dari insert data (true/false)

    // Variable projection ini gunanya untuk memilih column pada database
    // Guna variable projection ini sama seperti * pada SQL
    private String projection[] = {DataEntry._ID,
                                    DataEntry.COLUMN_TANGGAL,
                                    DataEntry.COLUMN_SHALAT,
                                    DataEntry.COLUMN_WAKTU,
                                    DataEntry.COLUMN_STATUS
                                    };

    // ------------------------------------------------------------------------------------

    public DatabaseHelper(Context context) {
        super(context, DATABASE, null, DATABASE_VERSION);
        onCreate(sqLiteDatabase);
    }

    // Disini Code Untuk Create Table di database SQLite -------------------------------
    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            sql_create_table = "CREATE TABLE IF NOT EXISTS " + DataEntry.TABLE_NAME + " (" +
                    DataEntry._ID + " TEXT PRIMARY KEY," +
                    DataEntry.COLUMN_TANGGAL + " TEXT NOT NULL," +
                    DataEntry.COLUMN_SHALAT + " TEXT NOT NULL," +
                    DataEntry.COLUMN_WAKTU + " TEXT NOT NULL," +
                    DataEntry.COLUMN_STATUS + " TEXT NOT NULL);";
            db.execSQL(sql_create_table);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // --------------------------------------------------------------------------------

    // Untuk mengupgrade table ---------------------------------------------------------------------
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        sql_drop_table = "DROP TABLE IF EXIST " + DataEntry.TABLE_NAME;
        db.execSQL(sql_drop_table);
        onCreate(db);
    }
    // ---------------------------------------------------------------------------------------------

    // Insert Data dalam Database -------------------------------------------------------------------
    public boolean insertData(String id,String tanggal, String shalat, String waktu, String status) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(DataEntry._ID, id);
            contentValues.put(DataEntry.COLUMN_TANGGAL, tanggal);
            contentValues.put(DataEntry.COLUMN_SHALAT, shalat);
            contentValues.put(DataEntry.COLUMN_WAKTU, waktu);
            contentValues.put(DataEntry.COLUMN_STATUS, status);
            result = sqLiteDatabase.insert(DataEntry.TABLE_NAME, null, contentValues);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
    // ----------------------------------------------------------------------------------------------

    // Method Cursor untuk menarik semua data sementara dari database -------------
    // dalam method ini menggambil semua data tanpa arguments
    public Cursor getAllData(){
        Cursor res = sqLiteDatabase.query(
                DataEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                DataEntry.COLUMN_TANGGAL
                );
        return res;
    }
    // ----------------------------------------------------------------------------


    // Mengambil semua data dengan kondisi dimana tanggal sama dengan tanggal inputan ---------
    public Cursor getDataTanggal(String tanggal){
        String selection = DataEntry.COLUMN_TANGGAL + " = '" + tanggal + "'";
        Cursor res = sqLiteDatabase.query(
                DataEntry.TABLE_NAME,
                projection,
                selection,
                null,
                null,
                null,
                null
        );
        return res;
    }
    // -----------------------------------------------------------------------------------------

    // kondisi dimana tanggal dan shalat sama dengan inputan -----------------------------------
    public Cursor getDataTanggalJenis(String tanggal, String shalat) {
        String selection = DataEntry.COLUMN_TANGGAL + " = '" + tanggal +
                "' AND " + DataEntry.COLUMN_SHALAT + " = '" + shalat + "'";
        Cursor res = sqLiteDatabase.query(
                DataEntry.TABLE_NAME,
                projection,
                selection,
                null,
                null,
                null,
                null
        );
        return res;
    }
    // ------------------------------------------------------------------------------------------

}
