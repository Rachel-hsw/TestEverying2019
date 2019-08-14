package koudai.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

public class VideoInfroDao extends a.a.a.a<i, Long>
{
  public static final String TABLENAME = "VIDEO_INFRO";

  public VideoInfroDao(a.a.a.d.a parama)
  {
    super(parama);
  }

  public VideoInfroDao(a.a.a.d.a parama, d paramd)
  {
    super(parama, paramd);
  }

  public static void a(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    if (paramBoolean);
    for (String str = "IF NOT EXISTS "; ; str = "")
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE " + str + "'VIDEO_INFRO' (" + "'VIDEO_INFRO_ID' INTEGER PRIMARY KEY AUTOINCREMENT ," + "'VIDEO_ID' TEXT," + "'VIDEO_PATH' TEXT);");
      return;
    }
  }

  public static void b(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder("DROP TABLE ");
    if (paramBoolean);
    for (String str = "IF EXISTS "; ; str = "")
    {
      paramSQLiteDatabase.execSQL(str + "'VIDEO_INFRO'");
      return;
    }
  }

  public Long a(i parami)
  {
    if (parami != null)
      return parami.a();
    return null;
  }

  protected Long a(i parami, long paramLong)
  {
    parami.a(Long.valueOf(paramLong));
    return Long.valueOf(paramLong);
  }

  public void a(Cursor paramCursor, i parami, int paramInt)
  {
    Long localLong;
    String str1;
    label36: String str2;
    if (paramCursor.isNull(paramInt + 0))
    {
      localLong = null;
      parami.a(localLong);
      if (!paramCursor.isNull(paramInt + 1))
        break label85;
      str1 = null;
      parami.a(str1);
      boolean bool = paramCursor.isNull(paramInt + 2);
      str2 = null;
      if (!bool)
        break label99;
    }
    while (true)
    {
      parami.b(str2);
      return;
      localLong = Long.valueOf(paramCursor.getLong(paramInt + 0));
      break;
      label85: str1 = paramCursor.getString(paramInt + 1);
      break label36;
      label99: str2 = paramCursor.getString(paramInt + 2);
    }
  }

  protected void a(SQLiteStatement paramSQLiteStatement, i parami)
  {
    paramSQLiteStatement.clearBindings();
    Long localLong = parami.a();
    if (localLong != null)
      paramSQLiteStatement.bindLong(1, localLong.longValue());
    String str1 = parami.b();
    if (str1 != null)
      paramSQLiteStatement.bindString(2, str1);
    String str2 = parami.c();
    if (str2 != null)
      paramSQLiteStatement.bindString(3, str2);
  }

  public Long c(Cursor paramCursor, int paramInt)
  {
    if (paramCursor.isNull(paramInt + 0))
      return null;
    return Long.valueOf(paramCursor.getLong(paramInt + 0));
  }

  public i d(Cursor paramCursor, int paramInt)
  {
    Long localLong;
    String str1;
    label29: String str2;
    if (paramCursor.isNull(paramInt + 0))
    {
      localLong = null;
      if (!paramCursor.isNull(paramInt + 1))
        break label77;
      str1 = null;
      boolean bool = paramCursor.isNull(paramInt + 2);
      str2 = null;
      if (!bool)
        break label91;
    }
    while (true)
    {
      return new i(localLong, str1, str2);
      localLong = Long.valueOf(paramCursor.getLong(paramInt + 0));
      break;
      label77: str1 = paramCursor.getString(paramInt + 1);
      break label29;
      label91: str2 = paramCursor.getString(paramInt + 2);
    }
  }

  protected boolean o()
  {
    return true;
  }

  public static class Properties
  {
    public static final a.a.a.i a = new a.a.a.i(0, Long.class, "VideoInfroId", true, "VIDEO_INFRO_ID");
    public static final a.a.a.i b = new a.a.a.i(1, String.class, "VideoId", false, "VIDEO_ID");
    public static final a.a.a.i c = new a.a.a.i(2, String.class, "VideoPath", false, "VIDEO_PATH");
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     koudai.db.VideoInfroDao
 * JD-Core Version:    0.6.0
 */