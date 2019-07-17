package koudai.db;

import a.a.a.i;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

public class ProvinceDBDao extends a.a.a.a<g, Long>
{
  public static final String TABLENAME = "PROVINCE_DB";
  private d h;

  public ProvinceDBDao(a.a.a.d.a parama)
  {
    super(parama);
  }

  public ProvinceDBDao(a.a.a.d.a parama, d paramd)
  {
    super(parama, paramd);
    this.h = paramd;
  }

  public static void a(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    if (paramBoolean);
    for (String str = "IF NOT EXISTS "; ; str = "")
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE " + str + "'PROVINCE_DB' (" + "'PROVICE_ID' INTEGER PRIMARY KEY AUTOINCREMENT ," + "'PROV_ID' TEXT," + "'PROVICE_NAME' TEXT);");
      return;
    }
  }

  public static void b(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder("DROP TABLE ");
    if (paramBoolean);
    for (String str = "IF EXISTS "; ; str = "")
    {
      paramSQLiteDatabase.execSQL(str + "'PROVINCE_DB'");
      return;
    }
  }

  protected Long a(g paramg, long paramLong)
  {
    paramg.a(Long.valueOf(paramLong));
    return Long.valueOf(paramLong);
  }

  public void a(Cursor paramCursor, g paramg, int paramInt)
  {
    Long localLong;
    String str1;
    label36: String str2;
    if (paramCursor.isNull(paramInt + 0))
    {
      localLong = null;
      paramg.a(localLong);
      if (!paramCursor.isNull(paramInt + 1))
        break label85;
      str1 = null;
      paramg.a(str1);
      boolean bool = paramCursor.isNull(paramInt + 2);
      str2 = null;
      if (!bool)
        break label99;
    }
    while (true)
    {
      paramg.b(str2);
      return;
      localLong = Long.valueOf(paramCursor.getLong(paramInt + 0));
      break;
      label85: str1 = paramCursor.getString(paramInt + 1);
      break label36;
      label99: str2 = paramCursor.getString(paramInt + 2);
    }
  }

  protected void a(SQLiteStatement paramSQLiteStatement, g paramg)
  {
    paramSQLiteStatement.clearBindings();
    Long localLong = paramg.a();
    if (localLong != null)
      paramSQLiteStatement.bindLong(1, localLong.longValue());
    String str1 = paramg.b();
    if (str1 != null)
      paramSQLiteStatement.bindString(2, str1);
    String str2 = paramg.c();
    if (str2 != null)
      paramSQLiteStatement.bindString(3, str2);
  }

  protected void a(g paramg)
  {
    super.j(paramg);
    paramg.a(this.h);
  }

  public Long b(g paramg)
  {
    if (paramg != null)
      return paramg.a();
    return null;
  }

  public Long c(Cursor paramCursor, int paramInt)
  {
    if (paramCursor.isNull(paramInt + 0))
      return null;
    return Long.valueOf(paramCursor.getLong(paramInt + 0));
  }

  public g d(Cursor paramCursor, int paramInt)
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
      return new g(localLong, str1, str2);
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
    public static final i a = new i(0, Long.class, "ProviceId", true, "PROVICE_ID");
    public static final i b = new i(1, String.class, "provId", false, "PROV_ID");
    public static final i c = new i(2, String.class, "proviceName", false, "PROVICE_NAME");
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     koudai.db.ProvinceDBDao
 * JD-Core Version:    0.6.0
 */