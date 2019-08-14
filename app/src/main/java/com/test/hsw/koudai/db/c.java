package koudai.db;

import a.a.a.b;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class c extends b
{
  public static final int d = 19;

  public c(SQLiteDatabase paramSQLiteDatabase)
  {
    super(paramSQLiteDatabase, 19);
    a(VideoInfroDao.class);
    a(MajorDBDao.class);
    a(ProvinceDBDao.class);
    a(UserAnsDao.class);
    a(BrushExcerciseBatchDao.class);
    a(CourseJiangYiInforDao.class);
  }

  public static void a(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    VideoInfroDao.a(paramSQLiteDatabase, paramBoolean);
    MajorDBDao.a(paramSQLiteDatabase, paramBoolean);
    ProvinceDBDao.a(paramSQLiteDatabase, paramBoolean);
    UserAnsDao.a(paramSQLiteDatabase, paramBoolean);
    BrushExcerciseBatchDao.a(paramSQLiteDatabase, paramBoolean);
    CourseJiangYiInforDao.a(paramSQLiteDatabase, paramBoolean);
  }

  public static void b(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    VideoInfroDao.b(paramSQLiteDatabase, paramBoolean);
    MajorDBDao.b(paramSQLiteDatabase, paramBoolean);
    ProvinceDBDao.b(paramSQLiteDatabase, paramBoolean);
    UserAnsDao.b(paramSQLiteDatabase, paramBoolean);
    BrushExcerciseBatchDao.b(paramSQLiteDatabase, paramBoolean);
    CourseJiangYiInforDao.b(paramSQLiteDatabase, paramBoolean);
  }

  public d b(a.a.a.c.d paramd)
  {
    return new d(this.a, paramd, this.c);
  }

  public d d()
  {
    return new d(this.a, a.a.a.c.d.a, this.c);
  }

  public static class a extends c.b
  {
    public a(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory)
    {
      super(paramString, paramCursorFactory);
    }

    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
      Log.i("greenDAO", "Upgrading schema from version " + paramInt1 + " to " + paramInt2 + " by dropping all tables");
      try
      {
        f.a().a(paramSQLiteDatabase, new Class[] { VideoInfroDao.class });
        return;
      }
      catch (Exception localException)
      {
      }
    }
  }

  public static abstract class b extends SQLiteOpenHelper
  {
    public b(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory)
    {
      super(paramString, paramCursorFactory, 19);
    }

    public void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
      Log.i("greenDAO", "Creating tables for schema version 19");
      c.a(paramSQLiteDatabase, false);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     koudai.db.c
 * JD-Core Version:    0.6.0
 */