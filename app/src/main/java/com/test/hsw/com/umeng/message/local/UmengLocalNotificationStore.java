package com.umeng.message.local;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UmengLocalNotificationStore
{
  private static final String a = UmengLocalNotificationStore.class.getName();
  private static UmengLocalNotificationStore b;
  private static final String f = "UmengLocalNotificationStore.db";
  private static final int g = 1;
  private static final String h = "UmengLocalNotification";
  private static final String i = "UmengNotificationBuilder";
  private SQLiteDatabase c;
  private a d;
  private Context e;

  private UmengLocalNotificationStore(Context paramContext)
  {
    this.e = paramContext.getApplicationContext();
    this.d = new a(paramContext);
    this.c = this.d.getWritableDatabase();
  }

  public static UmengLocalNotificationStore getInstance(Context paramContext)
  {
    monitorenter;
    try
    {
      if (b == null)
        b = new UmengLocalNotificationStore(paramContext);
      UmengLocalNotificationStore localUmengLocalNotificationStore = b;
      return localUmengLocalNotificationStore;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public boolean addLocalNotification(UmengLocalNotification paramUmengLocalNotification)
  {
    if ((TextUtils.isEmpty(paramUmengLocalNotification.getId())) || (TextUtils.isEmpty(paramUmengLocalNotification.getNotificationBuilder().getId())));
    long l1;
    long l2;
    do
    {
      return false;
      l1 = this.c.insert("UmengLocalNotification", null, paramUmengLocalNotification.getContentValues());
      l2 = this.c.insert("UmengNotificationBuilder", null, paramUmengLocalNotification.getNotificationBuilder().getContentValues());
    }
    while ((l1 == -1L) || (l2 == -1L));
    return true;
  }

  public void deleteAllLocalNotifications()
  {
    Iterator localIterator = findAllLocalNotifications().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      UmengLocalNotification localUmengLocalNotification = (UmengLocalNotification)localIterator.next();
      String[] arrayOfString = new String[1];
      arrayOfString[0] = localUmengLocalNotification.getId();
      this.c.delete("UmengLocalNotification", "id=?", arrayOfString);
      this.c.delete("UmengNotificationBuilder", "localnotification_id=?", arrayOfString);
    }
  }

  public boolean deleteLocalNotification(String paramString)
  {
    if (TextUtils.isEmpty(paramString));
    int j;
    int k;
    do
    {
      return false;
      String[] arrayOfString = { paramString };
      j = this.c.delete("UmengLocalNotification", "id=?", arrayOfString);
      k = this.c.delete("UmengNotificationBuilder", "localnotification_id=?", arrayOfString);
    }
    while ((j != 1) || (k != 1));
    return true;
  }

  public List<UmengLocalNotification> findAllLocalNotifications()
  {
    Cursor localCursor1 = this.c.query("UmengLocalNotification", null, null, null, null, null, null, null);
    boolean bool = localCursor1.moveToFirst();
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor2 = null;
    while (true)
    {
      if (!bool)
      {
        localCursor1.close();
        if (localCursor2 != null)
          localCursor2.close();
        return localArrayList;
      }
      UmengLocalNotification localUmengLocalNotification = new UmengLocalNotification(localCursor1);
      String[] arrayOfString = new String[1];
      arrayOfString[0] = localUmengLocalNotification.getId();
      localCursor2 = this.c.query("UmengNotificationBuilder", null, "localnotification_id=?", arrayOfString, null, null, null, null);
      if (localCursor2.moveToFirst())
        localUmengLocalNotification.setNotificationBuilder(new UmengNotificationBuilder(localCursor2));
      localArrayList.add(localUmengLocalNotification);
      bool = localCursor1.moveToNext();
    }
  }

  public UmengLocalNotification findLocalNotification(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return null;
    String[] arrayOfString1 = { paramString };
    Cursor localCursor1 = this.c.query("UmengLocalNotification", null, "id=?", arrayOfString1, null, null, null, null);
    boolean bool1 = localCursor1.moveToFirst();
    if (bool1);
    for (UmengLocalNotification localUmengLocalNotification = new UmengLocalNotification(localCursor1); ; localUmengLocalNotification = null)
    {
      localCursor1.close();
      String[] arrayOfString2 = { paramString };
      Cursor localCursor2 = this.c.query("UmengNotificationBuilder", null, "localnotification_id=?", arrayOfString2, null, null, null, null);
      boolean bool2 = localCursor2.moveToFirst();
      if ((bool1) && (bool2))
        localUmengLocalNotification.setNotificationBuilder(new UmengNotificationBuilder(localCursor2));
      return localUmengLocalNotification;
    }
  }

  public List<UmengLocalNotification> findLocalNotifications(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return null;
    ArrayList localArrayList = new ArrayList();
    String str = "title LIKE '%" + paramString + "%' OR content LIKE '%" + paramString + "%'";
    Cursor localCursor1 = this.c.query("UmengLocalNotification", null, str, null, null, null, null, null);
    boolean bool = localCursor1.moveToFirst();
    Cursor localCursor2 = null;
    while (true)
    {
      if (!bool)
      {
        localCursor1.close();
        if (localCursor2 != null)
          localCursor2.close();
        return localArrayList;
      }
      UmengLocalNotification localUmengLocalNotification = new UmengLocalNotification(localCursor1);
      String[] arrayOfString = new String[1];
      arrayOfString[0] = localUmengLocalNotification.getId();
      localCursor2 = this.c.query("UmengNotificationBuilder", null, "localnotification_id=?", arrayOfString, null, null, null, null);
      if (localCursor2.moveToFirst())
        localUmengLocalNotification.setNotificationBuilder(new UmengNotificationBuilder(localCursor2));
      localArrayList.add(localUmengLocalNotification);
      bool = localCursor1.moveToNext();
    }
  }

  public boolean updateLocalNotification(UmengLocalNotification paramUmengLocalNotification)
  {
    int j = 1;
    if ((TextUtils.isEmpty(paramUmengLocalNotification.getId())) || (TextUtils.isEmpty(paramUmengLocalNotification.getNotificationBuilder().getId())))
      j = 0;
    long l1;
    long l2;
    do
    {
      return j;
      SQLiteDatabase localSQLiteDatabase1 = this.c;
      ContentValues localContentValues1 = paramUmengLocalNotification.getContentValues();
      String[] arrayOfString1 = new String[j];
      arrayOfString1[0] = paramUmengLocalNotification.getId();
      l1 = localSQLiteDatabase1.update("UmengLocalNotification", localContentValues1, "id=?", arrayOfString1);
      SQLiteDatabase localSQLiteDatabase2 = this.c;
      ContentValues localContentValues2 = paramUmengLocalNotification.getNotificationBuilder().getContentValues();
      String[] arrayOfString2 = new String[j];
      arrayOfString2[0] = paramUmengLocalNotification.getNotificationBuilder().getId();
      l2 = localSQLiteDatabase2.update("UmengNotificationBuilder", localContentValues2, "id=?", arrayOfString2);
    }
    while ((l1 != -1L) && (l2 != -1L));
    return false;
  }

  class a extends SQLiteOpenHelper
  {
    public a(Context arg2)
    {
      super("UmengLocalNotificationStore.db", null, 1);
    }

    public void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
      paramSQLiteDatabase.execSQL("create table if not exists UmengLocalNotification (id varchar, year integer, month integer, day integer, hour integer, minute integer, second integer, repeating_num integer, repeating_unit integer, repeating_interval integer, special_day integer, title varchar, content varchar, ticker varchar, PRIMARY KEY(id))");
      paramSQLiteDatabase.execSQL("create table if not exists UmengNotificationBuilder (id varchar, localnotification_id varchar, flags integer, defaults integer, smallicon_drawable varchar, largeicon_drawable varchar, sound_drawable varchar, play_vibrate integer, play_lights integer, play_sound integer, screen_on integer, layout_id integer, layout_title_id integer, layout_content_id integer, layout_icon_id integer, layout_icon_drawable_id, FOREIGN KEY(localnotification_id) REFERENCES UmengLocalNotification(id), PRIMARY KEY(id))");
    }

    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
      onCreate(paramSQLiteDatabase);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.local.UmengLocalNotificationStore
 * JD-Core Version:    0.6.0
 */