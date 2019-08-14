package com.umeng.message;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import android.util.Log;
import com.umeng.message.b.dl;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONObject;

public class MsgLogStore
{
  public static final String ActionType = "ActionType";
  public static final String AppLaunchAt = "AppLaunchAt";
  public static final String MsgId = "MsgId";
  public static final String MsgStatus = "MsgStatus";
  public static final String MsgType = "MsgType";
  public static final String SerialNo = "SerialNo";
  public static final String TaskId = "TaskId";
  public static final String Time = "Time";
  public static final String UpdateResponse = "UpdateResponse";
  private static final String a = MsgLogStore.class.getName();
  private static MsgLogStore b;
  private static final String f = " And ";
  private static final String g = " Asc ";
  private static final String h = " Desc ";
  private static final String i = "MsgLogStore.db";
  private static final int j = 4;
  private static final String k = "MsgLogStore";
  private static final String l = "MsgLogIdTypeStore";
  private static final String m = "MsgLogStoreForAgoo";
  private static final String n = "MsgLogIdTypeStoreForAgoo";
  private static final String o = "MsgConfigInfo";
  private SQLiteDatabase c;
  private a d;
  private Context e;

  private MsgLogStore(Context paramContext)
  {
    this.e = paramContext.getApplicationContext();
    this.d = new a(paramContext);
    this.c = this.d.getWritableDatabase();
  }

  private void a(File paramFile)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(b(paramFile));
      addLog(localJSONObject.optString("msg_id"), localJSONObject.optInt("action_type"), localJSONObject.optLong("ts"));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  // ERROR //
  private String b(File paramFile)
    throws java.io.IOException
  {
    // Byte code:
    //   0: new 138	java/io/BufferedReader
    //   3: dup
    //   4: new 140	java/io/FileReader
    //   7: dup
    //   8: aload_1
    //   9: invokespecial 142	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   12: invokespecial 145	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   15: astore_2
    //   16: new 147	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   23: astore_3
    //   24: aload_2
    //   25: invokevirtual 151	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   28: astore 6
    //   30: aload 6
    //   32: ifnonnull +20 -> 52
    //   35: aload_3
    //   36: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: astore 7
    //   41: aload_2
    //   42: ifnull +7 -> 49
    //   45: aload_2
    //   46: invokevirtual 157	java/io/BufferedReader:close	()V
    //   49: aload 7
    //   51: areturn
    //   52: aload_3
    //   53: aload 6
    //   55: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: goto -35 -> 24
    //   62: astore 4
    //   64: aload_2
    //   65: ifnull +7 -> 72
    //   68: aload_2
    //   69: invokevirtual 157	java/io/BufferedReader:close	()V
    //   72: aload 4
    //   74: athrow
    //   75: astore 8
    //   77: aload 8
    //   79: invokevirtual 162	java/io/IOException:printStackTrace	()V
    //   82: aload 7
    //   84: areturn
    //   85: astore 5
    //   87: aload 5
    //   89: invokevirtual 162	java/io/IOException:printStackTrace	()V
    //   92: goto -20 -> 72
    //   95: astore 4
    //   97: aconst_null
    //   98: astore_2
    //   99: goto -35 -> 64
    //
    // Exception table:
    //   from	to	target	type
    //   16	24	62	finally
    //   24	30	62	finally
    //   35	41	62	finally
    //   52	59	62	finally
    //   45	49	75	java/io/IOException
    //   68	72	85	java/io/IOException
    //   0	16	95	finally
  }

  private void b()
  {
    if (MessageSharedPrefs.getInstance(this.e).h())
      return;
    File[] arrayOfFile = this.e.getCacheDir().listFiles(new MsgLogStore.1(this));
    int i1;
    if (arrayOfFile != null)
      i1 = arrayOfFile.length;
    for (int i2 = 0; ; i2++)
    {
      if (i2 >= i1)
      {
        MessageSharedPrefs.getInstance(this.e).i();
        return;
      }
      File localFile = arrayOfFile[i2];
      a(localFile);
      localFile.delete();
    }
  }

  public static MsgLogStore getInstance(Context paramContext)
  {
    if (b == null)
    {
      b = new MsgLogStore(paramContext);
      b.b();
    }
    return b;
  }

  public boolean addLog(String paramString, int paramInt, long paramLong)
  {
    if (TextUtils.isEmpty(paramString))
      return false;
    MsgLog localMsgLog = new MsgLog(paramString, paramInt, paramLong);
    return this.c.insert("MsgLogStore", null, localMsgLog.getContentValues()) != -1L;
  }

  public boolean addLogForAgoo(String paramString1, String paramString2, String paramString3, long paramLong)
  {
    if (TextUtils.isEmpty(paramString1));
    MsgLogForAgoo localMsgLogForAgoo;
    do
    {
      return false;
      localMsgLogForAgoo = new MsgLogForAgoo(paramString1, paramString2, paramString3, paramLong);
    }
    while (this.c.insert("MsgLogStoreForAgoo", null, localMsgLogForAgoo.getContentValues()) == -1L);
    return true;
  }

  public boolean addLogIdType(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1));
    MsgLogIdType localMsgLogIdType;
    do
    {
      return false;
      localMsgLogIdType = new MsgLogIdType(paramString1, paramString2);
    }
    while (this.c.insert("MsgLogIdTypeStore", null, localMsgLogIdType.getContentValues()) == -1L);
    return true;
  }

  public boolean addLogIdTypeForAgoo(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1));
    MsgLogIdTypeForAgoo localMsgLogIdTypeForAgoo;
    do
    {
      return false;
      localMsgLogIdTypeForAgoo = new MsgLogIdTypeForAgoo(paramString1, paramString2, paramString3);
    }
    while (this.c.insert("MsgLogIdTypeStoreForAgoo", null, localMsgLogIdTypeForAgoo.getContentValues()) == -1L);
    return true;
  }

  public long getMsgConfigInfo_AppLaunchAt()
  {
    Cursor localCursor = this.c.query("MsgConfigInfo", new String[] { "AppLaunchAt" }, null, null, null, null, null, null);
    boolean bool = localCursor.moveToFirst();
    long l1 = 0L;
    if (bool)
      l1 = localCursor.getLong(localCursor.getColumnIndex("AppLaunchAt"));
    localCursor.close();
    Log.d(a, "appLaunchAt=" + l1);
    return l1;
  }

  public int getMsgConfigInfo_SerialNo()
  {
    Cursor localCursor = this.c.query("MsgConfigInfo", new String[] { "SerialNo" }, null, null, null, null, null, null);
    if (localCursor.moveToFirst());
    for (int i1 = localCursor.getInt(localCursor.getColumnIndex("SerialNo")); ; i1 = 0)
    {
      localCursor.close();
      return i1;
    }
  }

  public Object getMsgConfigInfo_UpdateResponse()
  {
    Cursor localCursor = this.c.query("MsgConfigInfo", new String[] { "UpdateResponse" }, null, null, null, null, null, null);
    boolean bool = localCursor.moveToFirst();
    String str = null;
    if (bool)
      str = localCursor.getString(localCursor.getColumnIndex("UpdateResponse"));
    localCursor.close();
    Log.d(a, "updateResponse=" + str);
    return dl.f(str);
  }

  public MsgLog getMsgLog(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return null;
    String[] arrayOfString = { paramString };
    Cursor localCursor = this.c.query("MsgLogStore", null, "MsgId=?", arrayOfString, null, null, null, null);
    boolean bool = localCursor.moveToFirst();
    MsgLog localMsgLog = null;
    if (bool)
      localMsgLog = new MsgLog(localCursor);
    localCursor.close();
    return localMsgLog;
  }

  public MsgLogForAgoo getMsgLogForAgoo(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return null;
    String[] arrayOfString = { paramString };
    Cursor localCursor = this.c.query("MsgLogStoreForAgoo", null, "MsgId=?", arrayOfString, null, null, null, null);
    boolean bool = localCursor.moveToFirst();
    MsgLogForAgoo localMsgLogForAgoo = null;
    if (bool)
      localMsgLogForAgoo = new MsgLogForAgoo(localCursor);
    localCursor.close();
    return localMsgLogForAgoo;
  }

  public ArrayList<MsgLogIdType> getMsgLogIdTypes()
  {
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = this.c.query("MsgLogIdTypeStore", null, null, null, null, null, "MsgId Asc ", null);
    for (boolean bool = localCursor.moveToFirst(); ; bool = localCursor.moveToNext())
    {
      if (!bool)
      {
        localCursor.close();
        return localArrayList;
      }
      localArrayList.add(new MsgLogIdType(localCursor));
    }
  }

  public ArrayList<MsgLogIdType> getMsgLogIdTypes(int paramInt)
  {
    if (paramInt < 1)
      return null;
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = this.c.query("MsgLogIdTypeStore", null, null, null, null, null, "MsgId Asc ", paramInt);
    for (boolean bool = localCursor.moveToFirst(); ; bool = localCursor.moveToNext())
    {
      if (!bool)
      {
        localCursor.close();
        return localArrayList;
      }
      localArrayList.add(new MsgLogIdType(localCursor));
    }
  }

  public ArrayList<MsgLogIdTypeForAgoo> getMsgLogIdTypesForAgoo()
  {
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = this.c.query("MsgLogIdTypeStoreForAgoo", null, null, null, null, null, "MsgId Asc ", null);
    for (boolean bool = localCursor.moveToFirst(); ; bool = localCursor.moveToNext())
    {
      if (!bool)
      {
        localCursor.close();
        return localArrayList;
      }
      localArrayList.add(new MsgLogIdTypeForAgoo(localCursor));
    }
  }

  public ArrayList<MsgLogIdTypeForAgoo> getMsgLogIdTypesForAgoo(int paramInt)
  {
    if (paramInt < 1)
      return null;
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = this.c.query("MsgLogIdTypeStoreForAgoo", null, null, null, null, null, "MsgId Asc ", paramInt);
    for (boolean bool = localCursor.moveToFirst(); ; bool = localCursor.moveToNext())
    {
      if (!bool)
      {
        localCursor.close();
        return localArrayList;
      }
      localArrayList.add(new MsgLogIdTypeForAgoo(localCursor));
    }
  }

  public ArrayList<MsgLog> getMsgLogs()
  {
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = this.c.query("MsgLogStore", null, null, null, null, null, "Time Asc ", null);
    for (boolean bool = localCursor.moveToFirst(); ; bool = localCursor.moveToNext())
    {
      if (!bool)
      {
        localCursor.close();
        return localArrayList;
      }
      localArrayList.add(new MsgLog(localCursor));
    }
  }

  public ArrayList<MsgLog> getMsgLogs(int paramInt)
  {
    if (paramInt < 1)
      return null;
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = this.c.query("MsgLogStore", null, null, null, null, null, "Time Asc ", paramInt);
    for (boolean bool = localCursor.moveToFirst(); ; bool = localCursor.moveToNext())
    {
      if (!bool)
      {
        localCursor.close();
        return localArrayList;
      }
      localArrayList.add(new MsgLog(localCursor));
    }
  }

  public ArrayList<MsgLogForAgoo> getMsgLogsForAgoo()
  {
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = this.c.query("MsgLogStoreForAgoo", null, null, null, null, null, "Time Asc ", null);
    for (boolean bool = localCursor.moveToFirst(); ; bool = localCursor.moveToNext())
    {
      if (!bool)
      {
        localCursor.close();
        return localArrayList;
      }
      localArrayList.add(new MsgLogForAgoo(localCursor));
    }
  }

  public ArrayList<MsgLogForAgoo> getMsgLogsForAgoo(int paramInt)
  {
    if (paramInt < 1)
      return null;
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = this.c.query("MsgLogStoreForAgoo", null, null, null, null, null, "Time Asc ", paramInt);
    for (boolean bool = localCursor.moveToFirst(); ; bool = localCursor.moveToNext())
    {
      if (!bool)
      {
        localCursor.close();
        return localArrayList;
      }
      localArrayList.add(new MsgLogForAgoo(localCursor));
    }
  }

  public boolean removeLog(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString));
    String[] arrayOfString;
    do
    {
      return false;
      arrayOfString = new String[2];
      arrayOfString[0] = paramString;
      arrayOfString[1] = paramInt;
    }
    while (this.c.delete("MsgLogStore", "MsgId=? And ActionType=?", arrayOfString) != 1);
    return true;
  }

  public boolean removeLogForAgoo(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1));
    String[] arrayOfString;
    do
    {
      return false;
      arrayOfString = new String[] { paramString1, paramString2 };
    }
    while (this.c.delete("MsgLogStoreForAgoo", "MsgId=? And MsgStatus=?", arrayOfString) != 1);
    return true;
  }

  public boolean removeLogIdType(String paramString)
  {
    if (TextUtils.isEmpty(paramString));
    String[] arrayOfString;
    do
    {
      return false;
      arrayOfString = new String[] { paramString };
    }
    while (this.c.delete("MsgLogIdTypeStore", "MsgId=?", arrayOfString) != 1);
    return true;
  }

  public boolean removeLogIdTypeForAgoo(String paramString)
  {
    if (TextUtils.isEmpty(paramString));
    String[] arrayOfString;
    do
    {
      return false;
      arrayOfString = new String[] { paramString };
    }
    while (this.c.delete("MsgLogIdTypeStoreForAgoo", "MsgId=?", arrayOfString) != 1);
    return true;
  }

  public void setMsgConfigInfo_AppLaunchAt(long paramLong)
  {
    String str = "update MsgConfigInfo set AppLaunchAt = " + paramLong;
    this.c.execSQL(str);
  }

  public void setMsgConfigInfo_SerialNo(int paramInt)
  {
    String str = "update MsgConfigInfo set SerialNo = " + paramInt;
    this.c.execSQL(str);
  }

  public void setMsgConfigInfo_UpdateResponse(Object paramObject)
  {
    String str1 = dl.a(paramObject);
    String str2 = "update MsgConfigInfo set UpdateResponse =  '" + str1 + "'";
    this.c.execSQL(str2);
  }

  public class MsgLog
  {
    public int actionType;
    public String msgId;
    public long time;

    public MsgLog(Cursor arg2)
    {
      Object localObject;
      this.msgId = localObject.getString(localObject.getColumnIndex("MsgId"));
      this.time = localObject.getLong(localObject.getColumnIndex("Time"));
      this.actionType = localObject.getInt(localObject.getColumnIndex("ActionType"));
    }

    public MsgLog(String paramInt, int paramLong, long arg4)
    {
      this.msgId = paramInt;
      this.actionType = paramLong;
      Object localObject;
      this.time = localObject;
    }

    public ContentValues getContentValues()
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("MsgId", this.msgId);
      localContentValues.put("Time", Long.valueOf(this.time));
      localContentValues.put("ActionType", Integer.valueOf(this.actionType));
      return localContentValues;
    }
  }

  public class MsgLogForAgoo
  {
    public String msgId;
    public String msgStatus;
    public String taskId;
    public long time;

    public MsgLogForAgoo(Cursor arg2)
    {
      Object localObject;
      this.msgId = localObject.getString(localObject.getColumnIndex("MsgId"));
      this.taskId = localObject.getString(localObject.getColumnIndex("TaskId"));
      this.msgStatus = localObject.getString(localObject.getColumnIndex("MsgStatus"));
      this.time = localObject.getLong(localObject.getColumnIndex("Time"));
    }

    public MsgLogForAgoo(String paramString1, String paramString2, String paramLong, long arg5)
    {
      this.msgId = paramString1;
      this.taskId = paramString2;
      this.msgStatus = paramLong;
      Object localObject;
      this.time = localObject;
    }

    public ContentValues getContentValues()
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("MsgId", this.msgId);
      localContentValues.put("TaskId", this.taskId);
      localContentValues.put("MsgStatus", this.msgStatus);
      localContentValues.put("Time", Long.valueOf(this.time));
      return localContentValues;
    }
  }

  public class MsgLogIdType
  {
    public String msgId;
    public String msgType;

    public MsgLogIdType(Cursor arg2)
    {
      Object localObject;
      this.msgId = localObject.getString(localObject.getColumnIndex("MsgId"));
      this.msgType = localObject.getString(localObject.getColumnIndex("MsgType"));
    }

    public MsgLogIdType(String paramString1, String arg3)
    {
      this.msgId = paramString1;
      Object localObject;
      this.msgType = localObject;
    }

    public ContentValues getContentValues()
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("MsgId", this.msgId);
      localContentValues.put("MsgType", this.msgType);
      return localContentValues;
    }
  }

  public class MsgLogIdTypeForAgoo
  {
    public String msgId;
    public String msgStatus;
    public String taskId;

    public MsgLogIdTypeForAgoo(Cursor arg2)
    {
      Object localObject;
      this.msgId = localObject.getString(localObject.getColumnIndex("MsgId"));
      this.taskId = localObject.getString(localObject.getColumnIndex("TaskId"));
      this.msgStatus = localObject.getString(localObject.getColumnIndex("MsgStatus"));
    }

    public MsgLogIdTypeForAgoo(String paramString1, String paramString2, String arg4)
    {
      this.msgId = paramString1;
      this.taskId = paramString2;
      Object localObject;
      this.msgStatus = localObject;
    }

    public ContentValues getContentValues()
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("MsgId", this.msgId);
      localContentValues.put("TaskId", this.taskId);
      localContentValues.put("MsgStatus", this.msgStatus);
      return localContentValues;
    }
  }

  class a extends SQLiteOpenHelper
  {
    public a(Context arg2)
    {
      super("MsgLogStore.db", null, 4);
    }

    private boolean a(SQLiteDatabase paramSQLiteDatabase, String paramString)
    {
      if (TextUtils.isEmpty(paramString));
      while (true)
      {
        return false;
        try
        {
          Cursor localCursor = paramSQLiteDatabase.rawQuery("select count(*) as c from sqlite_master where type = 'table' and name = '" + paramString.trim() + "'", null);
          if (!localCursor.moveToNext())
            continue;
          int i = localCursor.getInt(0);
          if (i > 0)
            return true;
        }
        catch (Exception localException)
        {
        }
      }
      return false;
    }

    public void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
      paramSQLiteDatabase.execSQL("create table if not exists MsgLogStore (MsgId varchar, ActionType Integer, Time long, PRIMARY KEY(MsgId, ActionType))");
      paramSQLiteDatabase.execSQL("create table if not exists MsgLogIdTypeStore (MsgId varchar, MsgType varchar, PRIMARY KEY(MsgId))");
      paramSQLiteDatabase.execSQL("create table if not exists MsgLogStoreForAgoo (MsgId varchar, TaskId varchar, MsgStatus varchar, Time long, PRIMARY KEY(MsgId, MsgStatus))");
      paramSQLiteDatabase.execSQL("create table if not exists MsgLogIdTypeStoreForAgoo (MsgId varchar, TaskId varchar, MsgStatus varchar, PRIMARY KEY(MsgId))");
      boolean bool = a(paramSQLiteDatabase, "MsgConfigInfo");
      paramSQLiteDatabase.execSQL("create table if not exists MsgConfigInfo (SerialNo integer default 1, AppLaunchAt long default 0, UpdateResponse varchar default NULL)");
      if (!bool)
      {
        int i = MessageSharedPrefs.getInstance(MsgLogStore.a(MsgLogStore.this)).getSerialNo();
        long l = MessageSharedPrefs.getInstance(MsgLogStore.a(MsgLogStore.this)).getAppLaunchLogSentAt();
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = Integer.valueOf(i);
        arrayOfObject[1] = Long.valueOf(l);
        paramSQLiteDatabase.execSQL("insert into MsgConfigInfo(SerialNo, AppLaunchAt) values (?, ?)", arrayOfObject);
      }
      while (true)
      {
        Log.d(MsgLogStore.a(), "onCreate");
        return;
        paramSQLiteDatabase.execSQL("alter table MsgConfigInfo add column UpdateResponse varchar");
      }
    }

    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
      onCreate(paramSQLiteDatabase);
      Log.d(MsgLogStore.a(), "onUpgrade");
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.MsgLogStore
 * JD-Core Version:    0.6.0
 */