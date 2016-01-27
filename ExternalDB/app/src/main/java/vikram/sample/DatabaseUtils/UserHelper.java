package vikram.sample.DatabaseUtils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


import java.util.ArrayList;

import vikram.sample.Classes.User;

public class UserHelper extends DatabaseHelper {

    public static final String MODULE = "UserHelper";
    public static String TAG = "";
    public Context mContext;
    SQLiteDatabase db = null;

    public UserHelper(Context context) {
        super(context);
        mContext = context;
        db = this.getWritableDatabase();
    }

    public long addUser(User user) {
        TAG = "addpUser";
        Log.d(MODULE, TAG);
        long res = -1;
        try {
            SQLiteDatabase db = this.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(ConsDB.FLD_USERID, user.getUserID());
            values.put(ConsDB.FLD_USERNAME, user.getUserName());
            values.put(ConsDB.FLD_USERPASS, user.getPassWord());
            values.put(ConsDB.FLD_USERIMAGE, user.getUserImage());
            values.put(ConsDB.FLD_FIRSTNAME, user.getFirstName());
            values.put(ConsDB.FLD_LASTNAME, user.getLastName());
            values.put(ConsDB.FLD_GENDER, user.getGender());
            values.put(ConsDB.FLD_PHONE, user.getPhoneNumber());
            values.put(ConsDB.FLD_EMAIL, user.getEmail());
            values.put(ConsDB.FLD_ADDRESS, user.getAddress());
            values.put(ConsDB.FLD_BDAY, user.getBday());

            res = db.insert(ConsDB.TABLE_USER, null, values);
            System.out.println(res + "");
//			db.insert(ConsDB.TABLE_USER, null, values);
        } catch (Exception e) {
            Log.e(MODULE, TAG + ", Exception Occurs " + e);
        } finally {
            try {
                db.close();
            } catch (Exception e) {
                Log.e(MODULE, TAG + ", Exception Occurs " + e);
            }
        }
        return res;
    }


    public long addUserDetails(User user) {
        TAG = "addpUser";
        Log.d(MODULE, TAG);
        long res = -1;
        try {
            SQLiteDatabase db = this.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(ConsDB.FLD_USERNAME, user.getUserName());
            values.put(ConsDB.FLD_USERPASS, user.getPassWord());
            values.put(ConsDB.FLD_USERIMAGE, user.getUserImage());
            values.put(ConsDB.FLD_FIRSTNAME, user.getFirstName());
            values.put(ConsDB.FLD_LASTNAME, user.getLastName());
            values.put(ConsDB.FLD_GENDER, user.getGender());
            values.put(ConsDB.FLD_EMAIL, user.getEmail());
            values.put(ConsDB.FLD_PHONE, user.getPhoneNumber());
            values.put(ConsDB.FLD_BDAY, user.getBday());
            values.put(ConsDB.FLD_ADDRESS, user.getAddress());

            res = db.insert(ConsDB.TABLE_USER, null, values);
            System.out.println(res + "");
//			db.insert(ConsDB.TABLE_USER, null, values);
        } catch (Exception e) {
            Log.e(MODULE, TAG + ", Exception Occurs " + e);
        } finally {
            try {
                db.close();
            } catch (Exception e) {
                Log.e(MODULE, TAG + ", Exception Occurs " + e);
            }
        }
        return res;
    }


    public long updateUser(String usrId, User user) {
        TAG = "updateUser";
        Log.d(MODULE, TAG);

        long rowId = -1;

        try {
            SQLiteDatabase db = UserHelper.this.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(ConsDB.FLD_USERNAME, user.getUserName());
            values.put(ConsDB.FLD_USERPASS, user.getPassWord());
            values.put(ConsDB.FLD_USERIMAGE, user.getUserImage());
            values.put(ConsDB.FLD_FIRSTNAME, user.getFirstName());
            values.put(ConsDB.FLD_LASTNAME, user.getLastName());
            values.put(ConsDB.FLD_GENDER, user.getGender());
            values.put(ConsDB.FLD_EMAIL, user.getEmail());
            values.put(ConsDB.FLD_PHONE, user.getPhoneNumber());
            values.put(ConsDB.FLD_ADDRESS, user.getAddress());
            values.put(ConsDB.FLD_BDAY, user.getBday());

            rowId = db.update(ConsDB.TABLE_USER, values, ConsDB.FLD_USERID + "=?", new String[]{usrId});
            try {
                db.close();
            } catch (Exception e) {
                Log.e(MODULE, TAG + ", Exception Occurs " + e);
            }
        } catch (Exception e) {
            Log.e(MODULE, TAG + ", Exception Occurs " + e);
        }
        return rowId;
    }

//    public long updateUserImage(String usrId, byte[] usrImage) {
//        TAG = "updateUserImage";
//        Log.d(MODULE, TAG);
//
//        long rowId = -1;
//
//        try {
//            //SQLiteDatabase db = AppUserHelper.this.getWritableDatabase();
//
//            ContentValues values = new ContentValues();
//            values.put(ConsDB.FLD_USERIMAGE, usrImage);
//
//            rowId = db.update(ConsDB.TABLE_USER, values, ConsDB.FLD_USERID + "=?", new String[]{usrId});
//            try {
//                db.close();
//            } catch (Exception e) {
//                Log.e(MODULE, TAG + ", Exception Occurs " + e);
//            }
//        } catch (Exception e) {
//            Log.e(MODULE, TAG + ", Exception Occurs " + e);
//        }
//        return rowId;
//    }

    public long deleteUser(String usrId) {
        TAG = "updateUserImage";
        Log.d(MODULE, TAG);

        long rowId = -1;

        try {
             db = UserHelper.this.getWritableDatabase();

//            ContentValues values = new ContentValues();

            rowId = db.delete(ConsDB.TABLE_USER, ConsDB.FLD_USERID + "=?", new String[]{usrId});
            try {
                db.close();
            } catch (Exception e) {
                Log.e(MODULE, TAG + ", Exception Occurs " + e);
            }
        } catch (Exception e) {
            Log.e(MODULE, TAG + ", Exception Occurs " + e);
        }
        return rowId;
    }

//    public long updateUserLogin(String usrId,String Login_status) {
//        TAG = "updateUserPrevsyncDt";
//        Log.d(MODULE, TAG);
//
//        long rowId = -1;
//
//        try {
//            SQLiteDatabase db = this.getWritableDatabase();
//
//            ContentValues values = new ContentValues();
//            values.put(ConsDB.FLD_STATUS, Login_status);
//            rowId = db.update(ConsDB.TABLE_USER, values, ConsDB.FLD_USERID + "=?", new String[]{usrId});
//            try {
//                db.close();
//            } catch (Exception e) {
//                Log.e(MODULE, TAG + ", Exception Occurs " + e);
//            }
//        } catch (Exception e) {
//            Log.e(MODULE, TAG + ", Exception Occurs " + e);
//        }
//        return rowId;
//    }

    public byte[] getUserImage(String userId) {
        TAG = "getUserImage";
        Log.d(MODULE, TAG);

        byte[] userImage = null;
        try {
            String selectQuery = "SELECT  * FROM " + ConsDB.TABLE_USER + " where " + ConsDB.FLD_USERID + " = '" + userId + "'";
            Log.v(MODULE, TAG + " selectQuery " + selectQuery);

            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(selectQuery, null);

            if (cursor.getCount() > 0) {
                if (cursor.moveToFirst()) {

                    do {
                        userImage = cursor.getBlob(cursor.getColumnIndex(ConsDB.FLD_USERIMAGE));
                    } while (cursor.moveToNext());
                }
            }

            if (cursor != null) {
                cursor.close();
            }
            try {
                db.close();
            } catch (Exception e) {
                Log.e(MODULE, TAG + ", Exception Occurs " + e);
            }
        } catch (Exception e) {
            Log.e(MODULE, TAG + ", Exception Occurs " + e);
        }

        return userImage;
    }

    /*public long updateUserPrevsyncDt(String usrId, String prevSyncDt) {
        TAG = "updateUserPrevsyncDt";
        Log.d(MODULE, TAG);

        long rowId = -1;

        try {
            SQLiteDatabase db = this.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(ConsDB.FLD_PREV_SYNC_DATE, prevSyncDt);

            rowId = db.update(ConsDB.TABLE_USER, values, ConsDB.FLD_USERID + "=?", new String[]{usrId});
            try {
                db.close();
            } catch (Exception e) {
                Log.e(MODULE, TAG + ", Exception Occurs " + e);
            }
        } catch (Exception e) {
            Log.e(MODULE, TAG + ", Exception Occurs " + e);
        }
        return rowId;
    }

    public boolean checkUserByIDAvailable(String usrId) {
        TAG = "isUserAvailable";
        Log.d(MODULE, TAG);
        boolean isAvail = false;
        SQLiteDatabase db = null;
        Cursor cursor = null;
        try {
            String selectQuery = "SELECT  * FROM " + ConsDB.TABLE_USER + " where " + ConsDB.FLD_USERID + " = '" + usrId + "'";
            Log.v(MODULE, TAG + " selectQuery " + selectQuery);

            db = this.getWritableDatabase();
            cursor = db.rawQuery(selectQuery, null);

            if (cursor.getCount() > 0) {
                isAvail = true;
            } else {
                isAvail = false;
            }
        } catch (Exception e) {
            Log.e(MODULE, TAG + ", Exception Occurs " + e);
            isAvail = false;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            try {
                db.close();
            } catch (Exception e) {
                Log.e(MODULE, TAG + ", Exception Occurs " + e);
            }
        }
        return isAvail;
    }

    public boolean checkUserByNameAvailable(String usrName) {
        TAG = "checkUserByNameAvailable";
        Log.d(MODULE, TAG);
        boolean isAvail = false;
        SQLiteDatabase db = null;
        Cursor cursor = null;
        try {
            String selectQuery = "SELECT * FROM " + ConsDB.TABLE_USER
                    + " where " + ConsDB.FLD_USERNAME + " = '" + usrName + "'";
            Log.v(MODULE, TAG + " selectQuery " + selectQuery);

            db = this.getWritableDatabase();
            cursor = db.rawQuery(selectQuery, null);

            if (cursor.getCount() > 0) {
                isAvail = true;
            } else {
                isAvail = false;
            }
        } catch (Exception e) {
            Log.e(MODULE, TAG + ", Exception Occurs " + e);
            isAvail = false;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            try {
                db.close();
            } catch (Exception e) {
                Log.e(MODULE, TAG + ", Exception Occurs " + e);
            }
        }
        return isAvail;
    }

    public boolean checkUserAvailable(String usrName, String passwd) {
        TAG = "checkUserAvailable";
        Log.d(MODULE, TAG);
        boolean isAvail = false;
        SQLiteDatabase db = null;
        Cursor cursor = null;
        try {
            String selectQuery = "SELECT  * FROM " + ConsDB.TABLE_USER + " where " + ConsDB.FLD_USERNAME + " = '" + usrName + "' AND " + ConsDB.FLD_PASSWORD + " = '" + passwd + "'";
            Log.v(MODULE, TAG + " selectQuery " + selectQuery);

            db = this.getWritableDatabase();
            cursor = db.rawQuery(selectQuery, null);

            if (cursor.getCount() > 0) {
                isAvail = true;
            } else {
                isAvail = false;
            }
        } catch (Exception e) {
            Log.e(MODULE, TAG + ", Exception Occurs " + e);
            isAvail = false;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            try {
                db.close();
            } catch (Exception e) {
                Log.e(MODULE, TAG + ", Exception Occurs " + e);
            }
        }
        return isAvail;
    }

    public boolean offlineUserLogin(String usrName, String pwd) {
        TAG = "offlineUserLogin";
        Log.d(MODULE, TAG);
        boolean isAvail = false;
        SQLiteDatabase db = null;
        Cursor cursor = null;
        try {
            String selectQuery = "SELECT  * FROM " + ConsDB.TABLE_USER
                    + " where " + ConsDB.FLD_USERNAME + " = '" + usrName + "' and " + ConsDB.FLD_PASSWORD + " = '" + pwd + "\n\'";
            Log.v(MODULE, TAG + " selectQuery " + selectQuery);

            db = this.getWritableDatabase();
            cursor = db.rawQuery(selectQuery, null);

            if (cursor.getCount() > 0) {
                isAvail = true;
            } else {
                isAvail = false;
            }
        } catch (Exception e) {
            Log.e(MODULE, TAG + ", Exception Occurs " + e);
            isAvail = false;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            try {
                db.close();
            } catch (Exception e) {
                Log.e(MODULE, TAG + ", Exception Occurs " + e);
            }
        }
        return isAvail;
    }

    public User getUserDetail(String userName, String userPasswd) {
        TAG = "getUserDetail";
        Log.d(MODULE, TAG);

        User user = null;
        try {
            String selectQuery = "SELECT  * FROM " + ConsDB.TABLE_USER + " where " + ConsDB.FLD_USERNAME + " = '" + userName + "' AND " + ConsDB.FLD_PASSWORD + " = '" + userPasswd + "'";
            Log.v(MODULE, TAG + " selectQuery " + selectQuery);

            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(selectQuery, null);

            if (cursor.getCount() > 0) {
                if (cursor.moveToFirst()) {

                    do {
                        String id = cursor.getString(cursor.getColumnIndex(ConsDB.FLD_USERID));
                        String uname = cursor.getString(cursor.getColumnIndex(ConsDB.FLD_USERNAME));
                        String passwd = cursor.getString(cursor.getColumnIndex(ConsDB.FLD_PASSWORD));
                        byte[] uImage = cursor.getBlob(cursor.getColumnIndex(ConsDB.FLD_USERIMAGE));
                        String fName = cursor.getString(cursor.getColumnIndex(ConsDB.FLD_FIRSTNAME));
                        String gender = cursor.getString(cursor.getColumnIndex(ConsDB.FLD_GENDER));
                        String lName = cursor.getString(cursor.getColumnIndex(ConsDB.FLD_LASTNAME));
                        String email = cursor.getString(cursor.getColumnIndex(ConsDB.FLD_EMAIL));
                        String phone = cursor.getString(cursor.getColumnIndex(ConsDB.FLD_PHONE));
                        String login_status = cursor.getString(cursor.getColumnIndex(ConsDB.FLD_STATUS));
                        String prev_sync = cursor.getString(cursor.getColumnIndex(ConsDB.FLD_PREV_SYNC_DATE));
                        user = new User(uname, passwd, login_status, id, fName, lName, gender, email, phone, uImage, prev_sync);
                    } while (cursor.moveToNext());
                }
            }

            if (cursor != null) {
                cursor.close();
            }
            try {
                db.close();
            } catch (Exception e) {
                Log.e(MODULE, TAG + ", Exception Occurs " + e);
            }
        } catch (Exception e) {
            Log.e(MODULE, TAG + ", Exception Occurs " + e);
        }

        return user;
    }*/

    public ArrayList<User> getAllUsersDetail() {
        TAG = "getAllUsersDetail";
        Log.d(MODULE, TAG);

        User user = null;
        ArrayList<User> users = new ArrayList<User>();
        try {
            String selectQuery = "SELECT  * FROM " + ConsDB.TABLE_USER;
            Log.v(MODULE, TAG + " selectQuery " + selectQuery);

            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(selectQuery, null);

            if (cursor.getCount() > 0) {
                if (cursor.moveToFirst()) {

                    do {
                        String id = cursor.getString(cursor.getColumnIndex(ConsDB.FLD_USERID));
                        String uname = cursor.getString(cursor.getColumnIndex(ConsDB.FLD_USERNAME));
                        String passwd = cursor.getString(cursor.getColumnIndex(ConsDB.FLD_USERPASS));
                        byte[] uImage = cursor.getBlob(cursor.getColumnIndex(ConsDB.FLD_USERIMAGE));
                        String fName = cursor.getString(cursor.getColumnIndex(ConsDB.FLD_FIRSTNAME));
                        String lName = cursor.getString(cursor.getColumnIndex(ConsDB.FLD_LASTNAME));
                        String gender = cursor.getString(cursor.getColumnIndex(ConsDB.FLD_GENDER));
                        String email = cursor.getString(cursor.getColumnIndex(ConsDB.FLD_EMAIL));
                        String phone = cursor.getString(cursor.getColumnIndex(ConsDB.FLD_PHONE));
                        String address = cursor.getString(cursor.getColumnIndex(ConsDB.FLD_ADDRESS));
                        String bday = cursor.getString(cursor.getColumnIndex(ConsDB.FLD_BDAY));
                        user = new User(id, uname, passwd, uImage, fName,lName, gender, phone, email, address, bday);
                        users.add(user);
                    } while (cursor.moveToNext());
                }
            }

            if (cursor != null) {
                cursor.close();
            }
            try {
                db.close();
            } catch (Exception e) {
                Log.e(MODULE, TAG + ", Exception Occurs " + e);
            }
        } catch (Exception e) {
            Log.e(MODULE, TAG + ", Exception Occurs " + e);
        }

        return users;
    }


//    public UserClass getUserDetailbyNm(String usrNm) {
//        TAG = "getUserDetailbyNm";
//        Log.d(MODULE, TAG);
//
//        UserClass user = null;
//        try {
//            String selectQuery = "SELECT  * FROM " + ConsDB.TABLE_USER + " where " + ConsDB.FLD_USERNAME + " = '" + usrNm + "'";
//            Log.v(MODULE, TAG + " selectQuery " + selectQuery);
//
//            SQLiteDatabase db = this.getWritableDatabase();
//            Cursor cursor = db.rawQuery(selectQuery, null);
//
//            if (cursor.getCount() > 0) {
//                if (cursor.moveToFirst()) {
//
//                    do {
//                        String id = cursor.getString(cursor.getColumnIndex(ConsDB.FLD_USER_ID));
//                        String uname = cursor.getString(cursor.getColumnIndex(ConsDB.FLD_USERNAME));
//                        String passwd = cursor.getString(cursor.getColumnIndex(ConsDB.FLD_PASSWORD));
//                        String uImageUrl = cursor.getString(cursor.getColumnIndex(ConsDB.FLD_USERIMAGEURL));
//                        byte[] uImage = cursor.getBlob(cursor.getColumnIndex(ConsDB.FLD_USERIMAGE));
//                        String adNo = cursor.getString(cursor.getColumnIndex(ConsDB.FLD_ADDMISSION_NUMBER));
//                        String fName = cursor.getString(cursor.getColumnIndex(ConsDB.FLD_USER_FIRSTNAME));
//                        String gender = cursor.getString(cursor.getColumnIndex(ConsDB.FLD_GENDER));
//                        String cNumber = cursor.getString(cursor.getColumnIndex(ConsDB.FLD_CLASS_NUMBER));
//                        String faName = cursor.getString(cursor.getColumnIndex(ConsDB.FLD_FATHER_NAME));
//                        String moName = cursor.getString(cursor.getColumnIndex(ConsDB.FLD_MOTHER_NAME));
//                        String moNum = cursor.getString(cursor.getColumnIndex(ConsDB.FLD_MOBILE_NUMBER));
//                        String add = cursor.getString(cursor.getColumnIndex(ConsDB.FLD_ADDRESS));
//                        String clasId = cursor.getString(cursor.getColumnIndex(ConsDB.FLD_CLASS_ID));
//                        String schoolCode = cursor.getString(cursor.getColumnIndex(ConsDB.FLD_SCHOOL_CODE));
//
//                        user = new UserClass(id, uname, passwd, uImageUrl, uImage, adNo, fName, gender, cNumber, faName, moName, moNum, add, clasId, "", schoolCode);
//
//                    } while (cursor.moveToNext());
//                }
//            }
//
//            if (cursor != null) {
//                cursor.close();
//            }
//            try {
//                db.close();
//            } catch (Exception e) {
//                Log.e(MODULE, TAG + ", Exception Occurs " + e);
//            }
//        } catch (Exception e) {
//            Log.e(MODULE, TAG + ", Exception Occurs " + e);
//        }
//
//        return user;
//    }

   /* public int getUserCount() {
        TAG = "getUserCount";
        Log.d(MODULE, TAG);
        SQLiteDatabase db = null;
        Cursor cursor = null;
        int UserCount = 0;
        try {
            String selectQuery = "SELECT COUNT(*) FROM " + ConsDB.TABLE_USER;
            Log.v(MODULE, TAG + " selectQuery " + selectQuery);

            db = this.getReadableDatabase();
            cursor = db.rawQuery(selectQuery, null);

            if (null != cursor)
                if (cursor.getCount() > 0) {
                    cursor.moveToFirst();
                    UserCount = cursor.getInt(0);
                }
            cursor.close();

        } catch (Exception e) {
            Log.e(MODULE, TAG + ", Exception Occurs " + e);
        }
        return UserCount;
    }

    public String[] getUserIds() {
        TAG = "getUserCount";
        Log.d(MODULE, TAG);
        SQLiteDatabase db = null;
        Cursor cursor = null;
        String[] Users = null;
        try {
            String selectQuery = "SELECT " + ConsDB.FLD_USERID + " FROM " + ConsDB.TABLE_USER;
            Log.v(MODULE, TAG + " selectQuery " + selectQuery);

            db = this.getReadableDatabase();
            cursor = db.rawQuery(selectQuery, null);
            Users = new String[cursor.getCount()];

            if (cursor.getCount() > 0) {
                int i = 0;
                if (cursor.moveToFirst()) {

                    do {
                        Users[i] = cursor.getString(cursor.getColumnIndex(ConsDB.FLD_USERID));
                        i++;
                    } while (cursor.moveToNext());
                }
            }

        } catch (Exception e) {
            Log.e(MODULE, TAG + ", Exception Occurs " + e);
        }
        return Users;
    }
*/
}
