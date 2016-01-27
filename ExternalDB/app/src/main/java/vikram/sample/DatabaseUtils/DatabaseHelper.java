package vikram.sample.DatabaseUtils;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by bosco on 8/31/2015.
 */
public class DatabaseHelper extends SQLiteOpenHelper{
    public static final String MODULE = "DatabaseHelper";
    public static String TAG = "";

    Context context;
    SQLiteDatabase myDataBase = null;

    public SQLiteDatabase getMyDataBase() {
        return myDataBase;
    }

    public void setMyDataBase(SQLiteDatabase myDataBase) {
        this.myDataBase = myDataBase;
    }

    Cursor myCursor = null;

    public DatabaseHelper(Context context) {
        super(context, ConsDB.DATABASE_NAME, null, ConsDB.DATABASE_VERSION);
        this.context = context;
        try {
            TAG = "onCreate";
            Log.d(MODULE, TAG);

            ConsDB.DATABASE_PATH = "data/data/" + this.context.getPackageName() + "/databases/";

            boolean dbexist = checkdatabase();
            if (dbexist) {
                Log.d(MODULE, TAG + " Database exists");
                if (!myDataBase.isOpen())
                    opendatabase();
            } else {
                Log.d(MODULE, TAG + " Database doesn't exist");
                createdatabase();
            }
        } catch (Exception e) {
            Log.e(MODULE, TAG + ", Exception Occurs : " + e);
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        TAG = "onCreate";
        try {
        } catch (Exception e) {
            Log.e(MODULE, TAG + ", Exception Occurs : " + e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        TAG = "onUpgrade";
        try {
            onCreate(db);
        } catch (Exception e) {
            Log.e(MODULE, TAG + ", Exception Occurs : " + e);
        }
    }

    public boolean checkdatabase() {
        //SQLiteDatabase checkdb = null;
        boolean checkdb = false;

        try {
            String myPath = ConsDB.DATABASE_PATH + ConsDB.DATABASE_NAME;
            File dbfile = new File(myPath);
            //checkdb = SQLiteDatabase.openDatabase(myPath,null,SQLiteDatabase.OPEN_READWRITE);
            checkdb = dbfile.exists();
        } catch (SQLiteException e) {
            System.out.println("Database doesn't exist");
        }
        return checkdb;
    }

    public void opendatabase() throws SQLException {
        //Open the database
        TAG = "opendatabase";

        try {
            String mypath = ConsDB.DATABASE_PATH + ConsDB.DATABASE_NAME;
            myDataBase = SQLiteDatabase.openDatabase(mypath, null, SQLiteDatabase.OPEN_READWRITE);
        } catch (Exception e) {
            Log.e(MODULE, TAG + ", Exceptio Occurs : " + e);
        }
    }

    public void createdatabase() throws IOException {
        TAG = "createdatabase";
        Log.d(MODULE, TAG);

        try {
            boolean dbexist = checkdatabase();
            if (dbexist) {
                System.out.println(" Database exists.");
            } else {
                this.getReadableDatabase();
                try {
                    copydatabase();
                } catch (IOException e) {
                    throw new Error("Error copying database");
                }
            }
        } catch (Exception e) {
            Log.e(MODULE, TAG + ", Exception Occurs : " + e);
        }
    }

    private void copydatabase() throws IOException {
        TAG = "copydatabase";
        Log.d(MODULE, TAG);

        try {
            //Open your local db as the input stream
            java.io.InputStream myinput = context.getAssets().open(ConsDB.DATABASE_NAME);

            // Path to the just created empty db
            String outfilename = ConsDB.DATABASE_PATH + ConsDB.DATABASE_NAME;

            //Open the empty db as the output stream
            java.io.OutputStream myoutput = new FileOutputStream(outfilename);

            // transfer byte to inputfile to outputfile
            byte[] buffer = new byte[1024];
            int length;
            while ((length = myinput.read(buffer)) > 0) {
                myoutput.write(buffer, 0, length);
            }

            //Close the streams
            myoutput.flush();
            myoutput.close();
            myinput.close();
        } catch (Exception e) {
            Log.e(MODULE, TAG + ", Exception Occurs : " + e);
        }
    }

    public void closeDatabase() {
        TAG = "closeDatabase";

        try {
            if (myDataBase != null)
                myDataBase.close();

            if (myCursor != null) {
                myCursor.close();
            }

        } catch (Exception e) {
            Log.e(MODULE, TAG + ", Exception Occurs : " + e);
        }
    }

    public int removeTableRecords(String tableName) {
        TAG = "removeTableRecords";
        Log.d(MODULE, TAG);

        int recordCount = 0;
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            recordCount = db.delete(tableName, null, null);
        } catch (Exception e) {
            Log.e(MODULE, TAG + ", Exception Occurs " + e);
        }

        return recordCount;
    }
}
