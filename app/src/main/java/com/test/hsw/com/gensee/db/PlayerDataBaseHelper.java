package com.gensee.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PlayerDataBaseHelper extends SQLiteOpenHelper
{
  public static final String CREATE_TABLE_CHAT = " (_id INTEGER PRIMARY KEY AUTOINCREMENT,colTime TEXT,colText TEXT,colChatType TEXT,colSendUserName TEXT,colSendUserId INTEGER,colRich TEXT,colReceiveName TEXT,colReceiveUserId INTEGER,colReserved1 INTEGER,colReserved2 INTEGER,colReserved3 TEXT,colReserved4 TEXT);";
  public static final String CREATE_TABLE_QA = " (_id INTEGER PRIMARY KEY AUTOINCREMENT,colTimestamp INTEGER,colQId TEXT,colQuestTimgstamp INTEGER,colQuestOwnerName TEXT,colQuestOwnerId INTEGER,colQuestion TEXT,colAnswerOwner TEXT,colAnswerId TEXT,colAnswerTimestamp INTEGER,colAnswer TEXT);";
  public static final String DATABASE_NAME = "GsPlayer.db";
  private static final int DATABASE_VERSION = 1;

  public PlayerDataBaseHelper(Context paramContext)
  {
    super(paramContext, "GsPlayer.db", null, 1);
  }

  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL(" (_id INTEGER PRIMARY KEY AUTOINCREMENT,colTime TEXT,colText TEXT,colChatType TEXT,colSendUserName TEXT,colSendUserId INTEGER,colRich TEXT,colReceiveName TEXT,colReceiveUserId INTEGER,colReserved1 INTEGER,colReserved2 INTEGER,colReserved3 TEXT,colReserved4 TEXT);");
      paramSQLiteDatabase.execSQL(" (_id INTEGER PRIMARY KEY AUTOINCREMENT,colTimestamp INTEGER,colQId TEXT,colQuestTimgstamp INTEGER,colQuestOwnerName TEXT,colQuestOwnerId INTEGER,colQuestion TEXT,colAnswerOwner TEXT,colAnswerId TEXT,colAnswerTimestamp INTEGER,colAnswer TEXT);");
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.db.PlayerDataBaseHelper
 * JD-Core Version:    0.6.0
 */