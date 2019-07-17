package koudai.db;

import a.a.a.e.h;
import a.a.a.e.k;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import java.util.ArrayList;
import java.util.List;

public class MajorDBDao extends a.a.a.a<e, Long>
{
  public static final String TABLENAME = "MAJOR_DB";
  private d h;
  private h<e> i;
  private String j;

  public MajorDBDao(a.a.a.d.a parama)
  {
    super(parama);
  }

  public MajorDBDao(a.a.a.d.a parama, d paramd)
  {
    super(parama, paramd);
    this.h = paramd;
  }

  public static void a(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    if (paramBoolean);
    for (String str = "IF NOT EXISTS "; ; str = "")
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE " + str + "'MAJOR_DB' (" + "'MAJ_ID' INTEGER PRIMARY KEY AUTOINCREMENT ," + "'MAJOR_ID' TEXT," + "'MAJOR_NAME' TEXT," + "'PROV_NAME' TEXT," + "'PROVICE_ID' INTEGER);");
      return;
    }
  }

  public static void b(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder("DROP TABLE ");
    if (paramBoolean);
    for (String str = "IF EXISTS "; ; str = "")
    {
      paramSQLiteDatabase.execSQL(str + "'MAJOR_DB'");
      return;
    }
  }

  protected Long a(e parame, long paramLong)
  {
    parame.a(Long.valueOf(paramLong));
    return Long.valueOf(paramLong);
  }

  public List<e> a(Long paramLong)
  {
    monitorenter;
    try
    {
      if (this.i == null)
      {
        a.a.a.e.i locali = k();
        locali.a(Properties.e.a(null), new k[0]);
        this.i = locali.a();
      }
      monitorexit;
      h localh = this.i.b();
      localh.a(0, paramLong);
      return localh.c();
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  protected e a(Cursor paramCursor, boolean paramBoolean)
  {
    e locale = (e)a(paramCursor, 0, paramBoolean);
    int k = f().length;
    locale.a((g)a(this.h.f(), paramCursor, k));
    return locale;
  }

  public void a(Cursor paramCursor, e parame, int paramInt)
  {
    Long localLong1;
    String str1;
    label36: String str2;
    label57: String str3;
    label78: Long localLong2;
    if (paramCursor.isNull(paramInt + 0))
    {
      localLong1 = null;
      parame.a(localLong1);
      if (!paramCursor.isNull(paramInt + 1))
        break label127;
      str1 = null;
      parame.a(str1);
      if (!paramCursor.isNull(paramInt + 2))
        break label141;
      str2 = null;
      parame.b(str2);
      if (!paramCursor.isNull(paramInt + 3))
        break label155;
      str3 = null;
      parame.c(str3);
      boolean bool = paramCursor.isNull(paramInt + 4);
      localLong2 = null;
      if (!bool)
        break label169;
    }
    while (true)
    {
      parame.b(localLong2);
      return;
      localLong1 = Long.valueOf(paramCursor.getLong(paramInt + 0));
      break;
      label127: str1 = paramCursor.getString(paramInt + 1);
      break label36;
      label141: str2 = paramCursor.getString(paramInt + 2);
      break label57;
      label155: str3 = paramCursor.getString(paramInt + 3);
      break label78;
      label169: localLong2 = Long.valueOf(paramCursor.getLong(paramInt + 4));
    }
  }

  protected void a(SQLiteStatement paramSQLiteStatement, e parame)
  {
    paramSQLiteStatement.clearBindings();
    Long localLong1 = parame.a();
    if (localLong1 != null)
      paramSQLiteStatement.bindLong(1, localLong1.longValue());
    String str1 = parame.b();
    if (str1 != null)
      paramSQLiteStatement.bindString(2, str1);
    String str2 = parame.c();
    if (str2 != null)
      paramSQLiteStatement.bindString(3, str2);
    String str3 = parame.d();
    if (str3 != null)
      paramSQLiteStatement.bindString(4, str3);
    Long localLong2 = parame.e();
    if (localLong2 != null)
      paramSQLiteStatement.bindLong(5, localLong2.longValue());
  }

  protected void a(e parame)
  {
    super.j(parame);
    parame.a(this.h);
  }

  public Long b(e parame)
  {
    if (parame != null)
      return parame.a();
    return null;
  }

  public List<e> b(String paramString, String[] paramArrayOfString)
  {
    return f(this.a.rawQuery(p() + paramString, paramArrayOfString));
  }

  public e b(Long paramLong)
  {
    l();
    if (paramLong == null)
      return null;
    StringBuilder localStringBuilder = new StringBuilder(p());
    localStringBuilder.append("WHERE ");
    a.a.a.d.d.b(localStringBuilder, "T", g());
    String str = localStringBuilder.toString();
    String[] arrayOfString = new String[1];
    arrayOfString[0] = paramLong.toString();
    Cursor localCursor = this.a.rawQuery(str, arrayOfString);
    try
    {
      boolean bool = localCursor.moveToFirst();
      if (!bool)
        return null;
      if (!localCursor.isLast())
        throw new IllegalStateException("Expected unique result, but count was " + localCursor.getCount());
    }
    finally
    {
      localCursor.close();
    }
    e locale = a(localCursor, true);
    localCursor.close();
    return locale;
  }

  public Long c(Cursor paramCursor, int paramInt)
  {
    if (paramCursor.isNull(paramInt + 0))
      return null;
    return Long.valueOf(paramCursor.getLong(paramInt + 0));
  }

  public e d(Cursor paramCursor, int paramInt)
  {
    Long localLong1;
    String str1;
    label29: String str2;
    label44: String str3;
    label59: Long localLong2;
    if (paramCursor.isNull(paramInt + 0))
    {
      localLong1 = null;
      if (!paramCursor.isNull(paramInt + 1))
        break label111;
      str1 = null;
      if (!paramCursor.isNull(paramInt + 2))
        break label125;
      str2 = null;
      if (!paramCursor.isNull(paramInt + 3))
        break label139;
      str3 = null;
      boolean bool = paramCursor.isNull(paramInt + 4);
      localLong2 = null;
      if (!bool)
        break label153;
    }
    while (true)
    {
      return new e(localLong1, str1, str2, str3, localLong2);
      localLong1 = Long.valueOf(paramCursor.getLong(paramInt + 0));
      break;
      label111: str1 = paramCursor.getString(paramInt + 1);
      break label29;
      label125: str2 = paramCursor.getString(paramInt + 2);
      break label44;
      label139: str3 = paramCursor.getString(paramInt + 3);
      break label59;
      label153: localLong2 = Long.valueOf(paramCursor.getLong(paramInt + 4));
    }
  }

  public List<e> e(Cursor paramCursor)
  {
    int k = paramCursor.getCount();
    ArrayList localArrayList = new ArrayList(k);
    if (paramCursor.moveToFirst())
      if (this.c != null)
      {
        this.c.b();
        this.c.a(k);
      }
    try
    {
      boolean bool;
      do
      {
        localArrayList.add(a(paramCursor, false));
        bool = paramCursor.moveToNext();
      }
      while (bool);
      return localArrayList;
    }
    finally
    {
      if (this.c != null)
        this.c.c();
    }
    throw localObject;
  }

  protected List<e> f(Cursor paramCursor)
  {
    try
    {
      List localList = e(paramCursor);
      return localList;
    }
    finally
    {
      paramCursor.close();
    }
    throw localObject;
  }

  protected boolean o()
  {
    return true;
  }

  protected String p()
  {
    if (this.j == null)
    {
      StringBuilder localStringBuilder = new StringBuilder("SELECT ");
      a.a.a.d.d.a(localStringBuilder, "T", f());
      localStringBuilder.append(',');
      a.a.a.d.d.a(localStringBuilder, "T0", this.h.f().f());
      localStringBuilder.append(" FROM MAJOR_DB T");
      localStringBuilder.append(" LEFT JOIN PROVINCE_DB T0 ON T.'PROVICE_ID'=T0.'PROVICE_ID'");
      localStringBuilder.append(' ');
      this.j = localStringBuilder.toString();
    }
    return this.j;
  }

  public static class Properties
  {
    public static final a.a.a.i a = new a.a.a.i(0, Long.class, "MajId", true, "MAJ_ID");
    public static final a.a.a.i b = new a.a.a.i(1, String.class, "majorId", false, "MAJOR_ID");
    public static final a.a.a.i c = new a.a.a.i(2, String.class, "majorName", false, "MAJOR_NAME");
    public static final a.a.a.i d = new a.a.a.i(3, String.class, "provName", false, "PROV_NAME");
    public static final a.a.a.i e = new a.a.a.i(4, Long.class, "ProviceId", false, "PROVICE_ID");
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     koudai.db.MajorDBDao
 * JD-Core Version:    0.6.0
 */