package com.gensee.download.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.gensee.download.VodDownLoadEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VodDataBaseManager
{
  private VodDataBaseHelper dataBaseHelper;

  public VodDataBaseManager(Context paramContext)
  {
    this.dataBaseHelper = new VodDataBaseHelper(paramContext.getApplicationContext());
  }

  private ContentValues _insert(VodDownLoadEntity paramVodDownLoadEntity)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("colDownLOADID", paramVodDownLoadEntity.getDownLoadId());
    localContentValues.put("colDownLoadURL", paramVodDownLoadEntity.getDownLoadUrl());
    localContentValues.put("colLength", Long.valueOf(paramVodDownLoadEntity.getnLength()));
    localContentValues.put("colPercent", Integer.valueOf(paramVodDownLoadEntity.getnPercent()));
    localContentValues.put("colReserved1", Integer.valueOf(paramVodDownLoadEntity.getnReserved1()));
    localContentValues.put("colReserved2", Integer.valueOf(paramVodDownLoadEntity.getnReserved2()));
    localContentValues.put("colReserved3", paramVodDownLoadEntity.getsReserved3());
    localContentValues.put("colReserved4", paramVodDownLoadEntity.getsReserved4());
    localContentValues.put("colStatus", Integer.valueOf(paramVodDownLoadEntity.getnStatus()));
    localContentValues.put("colStopStatus", Integer.valueOf(paramVodDownLoadEntity.getnStopStatus()));
    localContentValues.put("colUUID", paramVodDownLoadEntity.getUUID());
    localContentValues.put("colAddTime", paramVodDownLoadEntity.getsAddTime());
    localContentValues.put("colSubejct", paramVodDownLoadEntity.getVodSubject());
    localContentValues.put("colSiteId", Long.valueOf(paramVodDownLoadEntity.getSiteId()));
    localContentValues.put("colConnectSvr", paramVodDownLoadEntity.getConnectSvr());
    localContentValues.put("colNickName", paramVodDownLoadEntity.getNickName());
    localContentValues.put("colUserId", Long.valueOf(paramVodDownLoadEntity.getUserId()));
    return localContentValues;
  }

  private VodDownLoadEntity dataToObject(Cursor paramCursor)
  {
    VodDownLoadEntity localVodDownLoadEntity = new VodDownLoadEntity();
    localVodDownLoadEntity.setDownLoadId(paramCursor.getString(paramCursor.getColumnIndex("colDownLOADID")));
    localVodDownLoadEntity.setDownLoadUrl(paramCursor.getString(paramCursor.getColumnIndex("colDownLoadURL")));
    localVodDownLoadEntity.setnLength(paramCursor.getLong(paramCursor.getColumnIndex("colLength")));
    localVodDownLoadEntity.setnPercent(paramCursor.getInt(paramCursor.getColumnIndex("colPercent")));
    localVodDownLoadEntity.setnReserved1(paramCursor.getInt(paramCursor.getColumnIndex("colReserved1")));
    localVodDownLoadEntity.setnReserved2(paramCursor.getInt(paramCursor.getColumnIndex("colReserved2")));
    localVodDownLoadEntity.setnStatus(paramCursor.getInt(paramCursor.getColumnIndex("colStatus")));
    localVodDownLoadEntity.setnStopStatus(paramCursor.getInt(paramCursor.getColumnIndex("colStopStatus")));
    localVodDownLoadEntity.setsReserved3(paramCursor.getString(paramCursor.getColumnIndex("colReserved3")));
    localVodDownLoadEntity.setsReserved4(paramCursor.getString(paramCursor.getColumnIndex("colReserved4")));
    localVodDownLoadEntity.setUUID(paramCursor.getString(paramCursor.getColumnIndex("colUUID")));
    localVodDownLoadEntity.setVodSubject(paramCursor.getString(paramCursor.getColumnIndex("colSubejct")));
    localVodDownLoadEntity.setSiteId(paramCursor.getLong(paramCursor.getColumnIndex("colSiteId")));
    localVodDownLoadEntity.setUserId(paramCursor.getLong(paramCursor.getColumnIndex("colUserId")));
    localVodDownLoadEntity.setNickName(paramCursor.getString(paramCursor.getColumnIndex("colNickName")));
    localVodDownLoadEntity.setConnectSvr(paramCursor.getString(paramCursor.getColumnIndex("colConnectSvr")));
    return localVodDownLoadEntity;
  }

  public void insert(VodDownLoadEntity paramVodDownLoadEntity)
  {
    SQLiteDatabase localSQLiteDatabase = this.dataBaseHelper.getWritableDatabase();
    try
    {
      localSQLiteDatabase.insert("table_vod_download", null, _insert(paramVodDownLoadEntity));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    finally
    {
      localSQLiteDatabase.close();
    }
    throw localObject;
  }

  public void insertValues(List<VodDownLoadEntity> paramList)
  {
    SQLiteDatabase localSQLiteDatabase = this.dataBaseHelper.getWritableDatabase();
    try
    {
      localSQLiteDatabase.beginTransaction();
      for (int i = 0; ; i++)
      {
        if (i >= paramList.size())
        {
          localSQLiteDatabase.setTransactionSuccessful();
          return;
        }
        localSQLiteDatabase.insert("table_vod_download", null, _insert((VodDownLoadEntity)paramList.get(i)));
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
      localSQLiteDatabase.close();
    }
    throw localObject;
  }

  public VodDownLoadEntity queryByDownLoadId(String paramString1, String paramString2)
  {
    VodDownLoadEntity localVodDownLoadEntity = null;
    SQLiteDatabase localSQLiteDatabase = this.dataBaseHelper.getReadableDatabase();
    try
    {
      Cursor localCursor2 = localSQLiteDatabase.rawQuery("select * from table_vod_download where colUUID=? and colDownLOADID=? order by colAddTime limit ?", new String[] { paramString1, paramString2, "1" });
      localCursor1 = localCursor2;
      try
      {
        localCursor1.moveToFirst();
        while (true)
        {
          boolean bool = localCursor1.isAfterLast();
          if (bool)
          {
            if (localCursor1 != null)
              localCursor1.close();
            localSQLiteDatabase.close();
            return localVodDownLoadEntity;
          }
          localVodDownLoadEntity = dataToObject(localCursor1);
          localCursor1.moveToNext();
        }
      }
      finally
      {
      }
      if (localCursor1 != null)
        localCursor1.close();
      localSQLiteDatabase.close();
      throw localObject1;
    }
    finally
    {
      Cursor localCursor1 = null;
    }
  }

  public List<VodDownLoadEntity> queryByUUID(String paramString)
  {
    SQLiteDatabase localSQLiteDatabase = this.dataBaseHelper.getReadableDatabase();
    Cursor localCursor = null;
    ArrayList localArrayList = new ArrayList();
    try
    {
      localCursor = localSQLiteDatabase.rawQuery("select * from table_vod_download where colUUID=? order by colAddTime", new String[] { paramString });
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
      localSQLiteDatabase.close();
    }
    throw localObject;
  }

  public void removeByDownLoadId(String paramString1, String paramString2)
  {
    SQLiteDatabase localSQLiteDatabase = this.dataBaseHelper.getWritableDatabase();
    try
    {
      localSQLiteDatabase.delete("table_vod_download", "colUUID=? and colDownLOADID=?", new String[] { paramString1, paramString2 });
      return;
    }
    finally
    {
      localSQLiteDatabase.close();
    }
    throw localObject;
  }

  public void removeByDownLoadIds(String paramString, List<String> paramList)
  {
    SQLiteDatabase localSQLiteDatabase = this.dataBaseHelper.getWritableDatabase();
    try
    {
      localSQLiteDatabase.beginTransaction();
      Iterator localIterator = paramList.iterator();
      while (true)
      {
        if (!localIterator.hasNext())
        {
          localSQLiteDatabase.setTransactionSuccessful();
          return;
        }
        localSQLiteDatabase.delete("table_vod_download", "colUUID=? and colDownLOADID=?", new String[] { paramString, (String)localIterator.next() });
      }
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
      localSQLiteDatabase.close();
    }
    throw localObject;
  }

  public int removeByUUID(String paramString)
  {
    SQLiteDatabase localSQLiteDatabase = this.dataBaseHelper.getWritableDatabase();
    Integer.valueOf(0);
    try
    {
      Integer localInteger = Integer.valueOf(localSQLiteDatabase.delete("table_vod_download", "colUUID=?", new String[] { paramString }));
      return localInteger.intValue();
    }
    finally
    {
      localSQLiteDatabase.close();
    }
    throw localObject;
  }

  public int updateByDownLoadId(VodDownLoadEntity paramVodDownLoadEntity)
  {
    SQLiteDatabase localSQLiteDatabase = this.dataBaseHelper.getWritableDatabase();
    try
    {
      ContentValues localContentValues = _insert(paramVodDownLoadEntity);
      String[] arrayOfString = new String[2];
      arrayOfString[0] = paramVodDownLoadEntity.getUUID();
      arrayOfString[1] = paramVodDownLoadEntity.getDownLoadId();
      int i = localSQLiteDatabase.update("table_vod_download", localContentValues, "colUUID=? and colDownLOADID=?", arrayOfString);
      return i;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return -1;
    }
    finally
    {
      localSQLiteDatabase.close();
    }
    throw localObject;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.download.db.VodDataBaseManager
 * JD-Core Version:    0.6.0
 */