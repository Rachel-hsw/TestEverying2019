package com.gensee.download.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class VodDataBaseHelper extends SQLiteOpenHelper
{
  private static final String CREATE_TABLE_VOD = "CREATE TABLE table_vod_download (_id INTEGER PRIMARY KEY AUTOINCREMENT,colDownLOADID TEXT,colDownLoadURL TEXT,colAddTime TEXT,colUUID TEXT,colSubejct TEXT,colLength INTEGER,colPercent INTEGER,colStopStatus INTEGER,colReserved1 INTEGER,colReserved2 INTEGER,colStatus INTEGER,colReserved3 TEXT,colSiteId TEXT,colNickName TEXT,colConnectSvr TEXT,colUserId TEXT,colReserved4 TEXT);";
  private static final String DATABASE_NAME = "Vod_DownLoad.db";
  private static final int DATABASE_VERSION = 2;

  public VodDataBaseHelper(Context paramContext)
  {
    super(paramContext, "Vod_DownLoad.db", null, 2);
  }

  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE table_vod_download (_id INTEGER PRIMARY KEY AUTOINCREMENT,colDownLOADID TEXT,colDownLoadURL TEXT,colAddTime TEXT,colUUID TEXT,colSubejct TEXT,colLength INTEGER,colPercent INTEGER,colStopStatus INTEGER,colReserved1 INTEGER,colReserved2 INTEGER,colStatus INTEGER,colReserved3 TEXT,colSiteId TEXT,colNickName TEXT,colConnectSvr TEXT,colUserId TEXT,colReserved4 TEXT);");
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 1) && (paramInt2 == 2))
    {
      paramSQLiteDatabase.execSQL("ALTER TABLE table_vod_download ADD COLUMN colSiteId TEXT;");
      paramSQLiteDatabase.execSQL("ALTER TABLE table_vod_download ADD COLUMN colNickName TEXT;");
      paramSQLiteDatabase.execSQL("ALTER TABLE table_vod_download ADD COLUMN colConnectSvr TEXT;");
      paramSQLiteDatabase.execSQL("ALTER TABLE table_vod_download ADD COLUMN colUserId TEXT;");
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.download.db.VodDataBaseHelper
 * JD-Core Version:    0.6.0
 */