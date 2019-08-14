package com.gensee.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.gensee.chat.msg.AbsChatMessage;
import com.gensee.chat.msg.PrivateMessage;
import com.gensee.chat.msg.PublicMessage;
import com.gensee.chat.msg.SysMessage;
import com.gensee.entity.QAMsg;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayerDataBaseManager
{
  private PlayerDataBaseHelper dataBaseHelper;
  boolean isClosed = false;
  private SQLiteDatabase mDatabase;

  public PlayerDataBaseManager(Context paramContext)
  {
    this.dataBaseHelper = new PlayerDataBaseHelper(paramContext.getApplicationContext());
    this.mDatabase = this.dataBaseHelper.getWritableDatabase();
    this.isClosed = false;
  }

  private ContentValues _insert(AbsChatMessage paramAbsChatMessage)
  {
    ContentValues localContentValues = new ContentValues();
    if ((paramAbsChatMessage instanceof PrivateMessage))
    {
      localContentValues.put("colChatType", "private");
      localContentValues.put("colReceiveUserId", Long.valueOf(((PrivateMessage)paramAbsChatMessage).getReceiveUserId()));
      localContentValues.put("colReceiveName", ((PrivateMessage)paramAbsChatMessage).getReceiveName());
    }
    while (true)
    {
      localContentValues.put("colSendUserId", Long.valueOf(paramAbsChatMessage.getSendUserId()));
      localContentValues.put("colSendUserName", paramAbsChatMessage.getSendUserName());
      localContentValues.put("colRich", paramAbsChatMessage.getRich());
      localContentValues.put("colText", paramAbsChatMessage.getText());
      localContentValues.put("colTime", Long.valueOf(paramAbsChatMessage.getTime()));
      localContentValues.put("colReserved1", Integer.valueOf(0));
      localContentValues.put("colReserved2", Integer.valueOf(0));
      localContentValues.put("colReserved3", "");
      localContentValues.put("colReserved4", "");
      return localContentValues;
      if ((paramAbsChatMessage instanceof PublicMessage))
      {
        localContentValues.put("colChatType", "public");
        continue;
      }
      if (!(paramAbsChatMessage instanceof SysMessage))
        continue;
      localContentValues.put("colChatType", "sys");
    }
  }

  private ContentValues _insertQa(QAMsg paramQAMsg)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("colQId", paramQAMsg.getQuestId());
    localContentValues.put("colTimestamp", Long.valueOf(paramQAMsg.getTimestamp()));
    localContentValues.put("colQuestion", paramQAMsg.getQuestion());
    localContentValues.put("colQuestTimgstamp", Long.valueOf(paramQAMsg.getQuestTimgstamp()));
    localContentValues.put("colQuestOwnerName", paramQAMsg.getQuestOwnerName());
    localContentValues.put("colQuestOwnerId", Long.valueOf(paramQAMsg.getQuestOwnerId()));
    localContentValues.put("colAnswerId", paramQAMsg.getAnswerId());
    localContentValues.put("colAnswer", paramQAMsg.getAnswer());
    localContentValues.put("colAnswerOwner", paramQAMsg.getAnswerOwner());
    localContentValues.put("colAnswerTimestamp", Long.valueOf(paramQAMsg.getAnswerTimestamp()));
    return localContentValues;
  }

  private AbsChatMessage dataToObject(Cursor paramCursor)
  {
    String str = paramCursor.getString(paramCursor.getColumnIndex("colChatType"));
    Object localObject;
    if ("private".equals(str))
    {
      localObject = new PrivateMessage();
      ((PrivateMessage)localObject).setReceiveUserId(paramCursor.getLong(paramCursor.getColumnIndex("colReceiveUserId")));
      ((PrivateMessage)localObject).setReceiveName(paramCursor.getString(paramCursor.getColumnIndex("colReceiveName")));
    }
    while (true)
    {
      if (localObject != null)
      {
        ((AbsChatMessage)localObject).setSendUserId(paramCursor.getLong(paramCursor.getColumnIndex("colSendUserId")));
        ((AbsChatMessage)localObject).setSendUserName(paramCursor.getString(paramCursor.getColumnIndex("colSendUserName")));
        ((AbsChatMessage)localObject).setRich(paramCursor.getString(paramCursor.getColumnIndex("colRich")));
        ((AbsChatMessage)localObject).setText(paramCursor.getString(paramCursor.getColumnIndex("colText")));
        ((AbsChatMessage)localObject).setTime(paramCursor.getLong(paramCursor.getColumnIndex("colTime")));
      }
      return localObject;
      if ("public".equals(str))
      {
        localObject = new PublicMessage();
        continue;
      }
      boolean bool = "sys".equals(str);
      localObject = null;
      if (!bool)
        continue;
      localObject = new SysMessage();
    }
  }

  private QAMsg dataToQaObject(Cursor paramCursor)
  {
    QAMsg localQAMsg = new QAMsg("qa");
    localQAMsg.setAnswer(paramCursor.getString(paramCursor.getColumnIndex("colAnswer")));
    localQAMsg.setAnswerId(paramCursor.getString(paramCursor.getColumnIndex("colAnswerId")));
    localQAMsg.setAnswerOwner(paramCursor.getString(paramCursor.getColumnIndex("colAnswerOwner")));
    localQAMsg.setAnswerTimestamp(paramCursor.getLong(paramCursor.getColumnIndex("colAnswerTimestamp")));
    localQAMsg.setQuestId(paramCursor.getString(paramCursor.getColumnIndex("colQId")));
    localQAMsg.setQuestion(paramCursor.getString(paramCursor.getColumnIndex("colQuestion")));
    localQAMsg.setQuestOwnerId(paramCursor.getLong(paramCursor.getColumnIndex("colQuestOwnerId")));
    localQAMsg.setQuestOwnerName(paramCursor.getString(paramCursor.getColumnIndex("colQuestOwnerName")));
    localQAMsg.setQuestTimgstamp(paramCursor.getLong(paramCursor.getColumnIndex("colQuestTimgstamp")));
    localQAMsg.setTimestamp(paramCursor.getLong(paramCursor.getColumnIndex("colTimestamp")));
    return localQAMsg;
  }

  private String getChatTableName(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + "table_player_chat" + " (_id INTEGER PRIMARY KEY AUTOINCREMENT,colTime TEXT,colText TEXT,colChatType TEXT,colSendUserName TEXT,colSendUserId INTEGER,colRich TEXT,colReceiveName TEXT,colReceiveUserId INTEGER,colReserved1 INTEGER,colReserved2 INTEGER,colReserved3 TEXT,colReserved4 TEXT);");
    return "table_player_chat";
  }

  private String getQaTableName(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + "table_player_qa" + " (_id INTEGER PRIMARY KEY AUTOINCREMENT,colTimestamp INTEGER,colQId TEXT,colQuestTimgstamp INTEGER,colQuestOwnerName TEXT,colQuestOwnerId INTEGER,colQuestion TEXT,colAnswerOwner TEXT,colAnswerId TEXT,colAnswerTimestamp INTEGER,colAnswer TEXT);");
    return "table_player_qa";
  }

  // ERROR //
  private long insertQaMsg(String paramString1, long paramLong1, String paramString2, long paramLong2, String paramString3, long paramLong3, String paramString4, String paramString5, String paramString6, long paramLong4)
  {
    // Byte code:
    //   0: new 39	android/content/ContentValues
    //   3: dup
    //   4: invokespecial 40	android/content/ContentValues:<init>	()V
    //   7: astore 15
    //   9: aload 15
    //   11: ldc 128
    //   13: aload_1
    //   14: invokevirtual 50	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: aload 15
    //   19: ldc 135
    //   21: lload_2
    //   22: invokestatic 62	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   25: invokevirtual 65	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   28: aload 15
    //   30: ldc 140
    //   32: aload 4
    //   34: invokevirtual 50	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   37: aload 15
    //   39: ldc 145
    //   41: lload 5
    //   43: invokestatic 62	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   46: invokevirtual 65	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   49: aload 15
    //   51: ldc 150
    //   53: aload 7
    //   55: invokevirtual 50	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   58: aload 15
    //   60: ldc 155
    //   62: lload 8
    //   64: invokestatic 62	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   67: invokevirtual 65	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   70: aload 15
    //   72: ldc 160
    //   74: aload 10
    //   76: invokevirtual 50	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   79: aload 15
    //   81: ldc 165
    //   83: aload 11
    //   85: invokevirtual 50	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: aload 15
    //   90: ldc 170
    //   92: aload 12
    //   94: invokevirtual 50	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   97: aload 15
    //   99: ldc 175
    //   101: lload 13
    //   103: invokestatic 62	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   106: invokevirtual 65	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   109: aload_0
    //   110: aload_0
    //   111: getfield 35	com/gensee/db/PlayerDataBaseManager:mDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   114: invokespecial 296	com/gensee/db/PlayerDataBaseManager:getQaTableName	(Landroid/database/sqlite/SQLiteDatabase;)Ljava/lang/String;
    //   117: astore 16
    //   119: aload_0
    //   120: getfield 35	com/gensee/db/PlayerDataBaseManager:mDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   123: invokevirtual 299	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   126: aload_0
    //   127: getfield 35	com/gensee/db/PlayerDataBaseManager:mDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   130: aload 16
    //   132: aconst_null
    //   133: aload 15
    //   135: invokevirtual 303	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   138: lstore 22
    //   140: lload 22
    //   142: lstore 19
    //   144: aload_0
    //   145: getfield 35	com/gensee/db/PlayerDataBaseManager:mDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   148: invokevirtual 306	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   151: aload_0
    //   152: getfield 35	com/gensee/db/PlayerDataBaseManager:mDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   155: invokevirtual 309	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   158: lload 19
    //   160: lreturn
    //   161: astore 18
    //   163: ldc2_w 310
    //   166: lstore 19
    //   168: aload 18
    //   170: astore 21
    //   172: aload 21
    //   174: invokevirtual 314	java/lang/Exception:printStackTrace	()V
    //   177: aload_0
    //   178: getfield 35	com/gensee/db/PlayerDataBaseManager:mDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   181: invokevirtual 309	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   184: lload 19
    //   186: lreturn
    //   187: astore 17
    //   189: aload_0
    //   190: getfield 35	com/gensee/db/PlayerDataBaseManager:mDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   193: invokevirtual 309	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   196: aload 17
    //   198: athrow
    //   199: astore 21
    //   201: goto -29 -> 172
    //
    // Exception table:
    //   from	to	target	type
    //   126	140	161	java/lang/Exception
    //   126	140	187	finally
    //   144	151	187	finally
    //   172	177	187	finally
    //   144	151	199	java/lang/Exception
  }

  private boolean isDbClose()
  {
    return this.isClosed;
  }

  public void closeDb()
  {
    if ((this.mDatabase != null) && (this.mDatabase.isOpen()))
    {
      this.mDatabase.close();
      this.isClosed = true;
    }
  }

  public void dropChatTable()
  {
    if (isDbClose())
      return;
    this.mDatabase.execSQL("DROP TABLE IF EXISTS table_player_chat");
  }

  public void dropQaTable()
  {
    if (isDbClose())
      return;
    this.mDatabase.execSQL("DROP TABLE IF EXISTS table_player_qa");
  }

  public AbsChatMessage getLatestMsg()
  {
    boolean bool1 = isDbClose();
    AbsChatMessage localAbsChatMessage = null;
    if (bool1);
    while (true)
    {
      return localAbsChatMessage;
      try
      {
        String str1 = getChatTableName(this.mDatabase);
        String str2 = "select * from " + str1 + " order by " + "colTime" + " desc limit ?";
        Cursor localCursor2 = this.mDatabase.rawQuery(str2, new String[] { "1" });
        localCursor1 = localCursor2;
        try
        {
          localCursor1.moveToFirst();
          while (true)
          {
            boolean bool2 = localCursor1.isAfterLast();
            if (bool2)
            {
              if (localCursor1 == null)
                break;
              localCursor1.close();
              return localAbsChatMessage;
            }
            localAbsChatMessage = dataToObject(localCursor1);
            localCursor1.moveToNext();
          }
        }
        finally
        {
        }
        if (localCursor1 != null)
          localCursor1.close();
        throw localObject2;
      }
      finally
      {
        Object localObject3 = localObject1;
        Cursor localCursor1 = null;
      }
    }
  }

  public List<AbsChatMessage> getLatestMsgsList(int paramInt)
  {
    Cursor localCursor = null;
    ArrayList localArrayList = new ArrayList();
    if (isDbClose())
      return localArrayList;
    try
    {
      String str1 = getChatTableName(this.mDatabase);
      String str2 = "select * from " + str1 + " order by " + "colTime" + " desc limit ?";
      SQLiteDatabase localSQLiteDatabase = this.mDatabase;
      String[] arrayOfString = new String[1];
      arrayOfString[0] = paramInt;
      localCursor = localSQLiteDatabase.rawQuery(str2, arrayOfString);
      localCursor.moveToFirst();
      while (true)
      {
        boolean bool = localCursor.isAfterLast();
        if (bool)
        {
          if (localCursor != null)
            localCursor.close();
          Collections.reverse(localArrayList);
          return localArrayList;
        }
        localArrayList.add(dataToObject(localCursor));
        localCursor.moveToNext();
      }
    }
    finally
    {
      if (localCursor != null)
        localCursor.close();
    }
    throw localObject;
  }

  public QAMsg getLatestQaMsg()
  {
    boolean bool1 = isDbClose();
    QAMsg localQAMsg = null;
    if (bool1);
    while (true)
    {
      return localQAMsg;
      String str1 = getQaTableName(this.mDatabase);
      try
      {
        String str2 = "select * from " + str1 + " order by " + "colTimestamp" + " desc limit ?";
        Cursor localCursor2 = this.mDatabase.rawQuery(str2, new String[] { "1" });
        localCursor1 = localCursor2;
        try
        {
          localCursor1.moveToFirst();
          while (true)
          {
            boolean bool2 = localCursor1.isAfterLast();
            if (bool2)
            {
              if (localCursor1 == null)
                break;
              localCursor1.close();
              return localQAMsg;
            }
            localQAMsg = dataToQaObject(localCursor1);
            localCursor1.moveToNext();
          }
        }
        finally
        {
        }
        if (localCursor1 != null)
          localCursor1.close();
        throw localObject2;
      }
      finally
      {
        Object localObject3 = localObject1;
        Cursor localCursor1 = null;
      }
    }
  }

  public List<QAMsg> getLatestQaMsgsList(int paramInt)
  {
    Cursor localCursor = null;
    ArrayList localArrayList = new ArrayList();
    if (isDbClose())
      return localArrayList;
    try
    {
      String str1 = getQaTableName(this.mDatabase);
      String str2 = "select * from " + str1 + " order by " + "colTimestamp" + " desc limit ?";
      SQLiteDatabase localSQLiteDatabase = this.mDatabase;
      String[] arrayOfString = new String[1];
      arrayOfString[0] = paramInt;
      localCursor = localSQLiteDatabase.rawQuery(str2, arrayOfString);
      localCursor.moveToFirst();
      while (true)
      {
        boolean bool = localCursor.isAfterLast();
        if (bool)
        {
          if (localCursor != null)
            localCursor.close();
          Collections.reverse(localArrayList);
          return localArrayList;
        }
        localArrayList.add(dataToQaObject(localCursor));
        localCursor.moveToNext();
      }
    }
    finally
    {
      if (localCursor != null)
        localCursor.close();
    }
    throw localObject;
  }

  public List<AbsChatMessage> getMsgsByOwnerId(long paramLong)
  {
    Cursor localCursor = null;
    ArrayList localArrayList = new ArrayList();
    if (isDbClose());
    while (true)
    {
      return localArrayList;
      try
      {
        String str1 = getChatTableName(this.mDatabase);
        String str2 = "select * from " + str1 + " where " + "colReceiveUserId" + "=?" + " or " + "colSendUserId" + "=?" + " order by " + "colTime";
        SQLiteDatabase localSQLiteDatabase = this.mDatabase;
        String[] arrayOfString = new String[2];
        arrayOfString[0] = paramLong;
        arrayOfString[1] = paramLong;
        localCursor = localSQLiteDatabase.rawQuery(str2, arrayOfString);
        localCursor.moveToFirst();
        while (true)
        {
          boolean bool = localCursor.isAfterLast();
          if (bool)
            return localArrayList;
          localArrayList.add(dataToObject(localCursor));
          localCursor.moveToNext();
        }
      }
      finally
      {
        if (localCursor != null)
          localCursor.close();
      }
    }
    throw localObject;
  }

  public void insert(AbsChatMessage paramAbsChatMessage)
  {
    if (isDbClose())
      return;
    String str = getChatTableName(this.mDatabase);
    ContentValues localContentValues = _insert(paramAbsChatMessage);
    this.mDatabase.insert(str, null, localContentValues);
  }

  public long insertQaMsg(QAMsg paramQAMsg)
  {
    if (isDbClose());
    do
      return -1L;
    while (paramQAMsg == null);
    return insertQaMsg(paramQAMsg.getQuestId(), paramQAMsg.getTimestamp(), paramQAMsg.getQuestion(), paramQAMsg.getQuestTimgstamp(), paramQAMsg.getQuestOwnerName(), paramQAMsg.getQuestOwnerId(), paramQAMsg.getAnswerId(), paramQAMsg.getAnswer(), paramQAMsg.getAnswerOwner(), paramQAMsg.getAnswerTimestamp());
  }

  public void insertQaMsgList(List<QAMsg> paramList)
  {
    if (isDbClose())
      return;
    try
    {
      String str = getQaTableName(this.mDatabase);
      this.mDatabase.beginTransaction();
      for (int i = 0; ; i++)
      {
        if (i >= paramList.size())
        {
          this.mDatabase.setTransactionSuccessful();
          return;
        }
        ContentValues localContentValues = _insertQa((QAMsg)paramList.get(i));
        this.mDatabase.insert(str, null, localContentValues);
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    finally
    {
      this.mDatabase.endTransaction();
    }
    throw localObject;
  }

  public void insertValues(List<AbsChatMessage> paramList)
  {
    if (isDbClose())
      return;
    try
    {
      String str = getChatTableName(this.mDatabase);
      this.mDatabase.beginTransaction();
      for (int i = 0; ; i++)
      {
        if (i >= paramList.size())
        {
          this.mDatabase.setTransactionSuccessful();
          return;
        }
        ContentValues localContentValues = _insert((AbsChatMessage)paramList.get(i));
        this.mDatabase.insert(str, null, localContentValues);
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    finally
    {
      this.mDatabase.endTransaction();
    }
    throw localObject;
  }

  public List<AbsChatMessage> queryChatMsgsLimitNext(int paramInt, long paramLong)
  {
    Cursor localCursor = null;
    ArrayList localArrayList = new ArrayList();
    if (isDbClose());
    while (true)
    {
      return localArrayList;
      try
      {
        String str1 = getChatTableName(this.mDatabase);
        String str2 = "select * from " + str1 + " where " + "colTime" + ">?" + " order by " + "colTime" + " limit ?";
        SQLiteDatabase localSQLiteDatabase = this.mDatabase;
        String[] arrayOfString = new String[2];
        arrayOfString[0] = paramLong;
        arrayOfString[1] = paramInt;
        localCursor = localSQLiteDatabase.rawQuery(str2, arrayOfString);
        localCursor.moveToFirst();
        while (true)
        {
          boolean bool = localCursor.isAfterLast();
          if (bool)
            return localArrayList;
          localArrayList.add(dataToObject(localCursor));
          localCursor.moveToNext();
        }
      }
      finally
      {
        if (localCursor != null)
          localCursor.close();
      }
    }
    throw localObject;
  }

  public List<AbsChatMessage> queryChatMsgsLimitPre(int paramInt, long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    if (isDbClose())
      return localArrayList;
    Cursor localCursor = null;
    try
    {
      String str1 = getChatTableName(this.mDatabase);
      String str2 = "select * from " + str1 + " where " + "colTime" + "<?" + " order by " + "colTime" + " desc limit ?";
      SQLiteDatabase localSQLiteDatabase = this.mDatabase;
      String[] arrayOfString = new String[2];
      arrayOfString[0] = paramLong;
      arrayOfString[1] = paramInt;
      localCursor = localSQLiteDatabase.rawQuery(str2, arrayOfString);
      localCursor.moveToFirst();
      while (true)
      {
        boolean bool = localCursor.isAfterLast();
        if (bool)
        {
          if (localCursor != null)
            localCursor.close();
          Collections.reverse(localArrayList);
          return localArrayList;
        }
        localArrayList.add(dataToObject(localCursor));
        localCursor.moveToNext();
      }
    }
    finally
    {
      if (localCursor != null)
        localCursor.close();
    }
    throw localObject;
  }

  public List<QAMsg> queryQaMsgsByOwnerId(long paramLong)
  {
    Cursor localCursor = null;
    ArrayList localArrayList = new ArrayList();
    if (isDbClose());
    while (true)
    {
      return localArrayList;
      try
      {
        String str1 = getQaTableName(this.mDatabase);
        String str2 = "select * from " + str1 + " where " + "colQuestOwnerId" + "=?" + " order by " + "colTimestamp";
        SQLiteDatabase localSQLiteDatabase = this.mDatabase;
        String[] arrayOfString = new String[1];
        arrayOfString[0] = paramLong;
        localCursor = localSQLiteDatabase.rawQuery(str2, arrayOfString);
        localCursor.moveToFirst();
        while (true)
        {
          boolean bool = localCursor.isAfterLast();
          if (bool)
            return localArrayList;
          localArrayList.add(dataToQaObject(localCursor));
          localCursor.moveToNext();
        }
      }
      finally
      {
        if (localCursor != null)
          localCursor.close();
      }
    }
    throw localObject;
  }

  public List<QAMsg> queryQaMsgsLimitNext(int paramInt, long paramLong)
  {
    Cursor localCursor = null;
    ArrayList localArrayList = new ArrayList();
    if (isDbClose());
    while (true)
    {
      return localArrayList;
      try
      {
        String str1 = getQaTableName(this.mDatabase);
        String str2 = "select * from " + str1 + " where " + "colTimestamp" + ">?" + " order by " + "colTimestamp" + " limit ?";
        SQLiteDatabase localSQLiteDatabase = this.mDatabase;
        String[] arrayOfString = new String[2];
        arrayOfString[0] = paramLong;
        arrayOfString[1] = paramInt;
        localCursor = localSQLiteDatabase.rawQuery(str2, arrayOfString);
        localCursor.moveToFirst();
        while (true)
        {
          boolean bool = localCursor.isAfterLast();
          if (bool)
            return localArrayList;
          localArrayList.add(dataToQaObject(localCursor));
          localCursor.moveToNext();
        }
      }
      finally
      {
        if (localCursor != null)
          localCursor.close();
      }
    }
    throw localObject;
  }

  public List<QAMsg> queryQaMsgsLimitPre(int paramInt, long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    if (isDbClose())
      return localArrayList;
    Cursor localCursor = null;
    try
    {
      String str1 = getQaTableName(this.mDatabase);
      String str2 = "select * from " + str1 + " where " + "colTimestamp" + "<?" + " order by " + "colTimestamp" + " desc limit ?";
      SQLiteDatabase localSQLiteDatabase = this.mDatabase;
      String[] arrayOfString = new String[2];
      arrayOfString[0] = paramLong;
      arrayOfString[1] = paramInt;
      localCursor = localSQLiteDatabase.rawQuery(str2, arrayOfString);
      localCursor.moveToFirst();
      while (true)
      {
        boolean bool = localCursor.isAfterLast();
        if (bool)
        {
          if (localCursor != null)
            localCursor.close();
          Collections.reverse(localArrayList);
          return localArrayList;
        }
        localArrayList.add(dataToQaObject(localCursor));
        localCursor.moveToNext();
      }
    }
    finally
    {
      if (localCursor != null)
        localCursor.close();
    }
    throw localObject;
  }

  public void removeAllChatMsgs()
  {
    if (isDbClose())
      return;
    String str = getChatTableName(this.mDatabase);
    this.mDatabase.delete(str, null, null);
  }

  public void removeAllQaMsgs()
  {
    if (isDbClose())
      return;
    String str = getQaTableName(this.mDatabase);
    this.mDatabase.delete(str, null, null);
  }

  public int removeChatMsgByUUID(String paramString)
  {
    Integer localInteger = Integer.valueOf(0);
    if (isDbClose())
      return localInteger.intValue();
    String str = getChatTableName(this.mDatabase);
    return Integer.valueOf(this.mDatabase.delete(str, "colTime=?", new String[] { paramString })).intValue();
  }

  public int removeQAMsgByUUID(String paramString)
  {
    if (isDbClose())
      return -1;
    String str = getQaTableName(this.mDatabase);
    Integer.valueOf(0);
    return Integer.valueOf(this.mDatabase.delete(str, "colQId=?", new String[] { paramString })).intValue();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.db.PlayerDataBaseManager
 * JD-Core Version:    0.6.0
 */