package koudai.db;

import a.a.a.i;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

public class CourseJiangYiInforDao extends a.a.a.a<b, Long>
{
  public static final String TABLENAME = "COURSE_JIANG_YI_INFOR";

  public CourseJiangYiInforDao(a.a.a.d.a parama)
  {
    super(parama);
  }

  public CourseJiangYiInforDao(a.a.a.d.a parama, d paramd)
  {
    super(parama, paramd);
  }

  public static void a(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    if (paramBoolean);
    for (String str = "IF NOT EXISTS "; ; str = "")
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE " + str + "'COURSE_JIANG_YI_INFOR' (" + "'COURSE_JIANG_YI_ID' INTEGER PRIMARY KEY AUTOINCREMENT ," + "'JIANG_YI_PATH' TEXT," + "'JIANG_YI_ID' TEXT," + "'IS_HAVE_DOWNLOAD' INTEGER," + "'CURRENT_PROGRESS' INTEGER," + "'JIANG_YI_LENGTH' INTEGER," + "'JIANG_YI_DOWN_STATUS' INTEGER);");
      return;
    }
  }

  public static void b(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder("DROP TABLE ");
    if (paramBoolean);
    for (String str = "IF EXISTS "; ; str = "")
    {
      paramSQLiteDatabase.execSQL(str + "'COURSE_JIANG_YI_INFOR'");
      return;
    }
  }

  public Long a(b paramb)
  {
    if (paramb != null)
      return paramb.a();
    return null;
  }

  protected Long a(b paramb, long paramLong)
  {
    paramb.a(Long.valueOf(paramLong));
    return Long.valueOf(paramLong);
  }

  public void a(Cursor paramCursor, b paramb, int paramInt)
  {
    Long localLong;
    String str1;
    label36: String str2;
    label57: Boolean localBoolean;
    Integer localInteger1;
    label99: Integer localInteger2;
    label120: Integer localInteger3;
    if (paramCursor.isNull(paramInt + 0))
    {
      localLong = null;
      paramb.a(localLong);
      if (!paramCursor.isNull(paramInt + 1))
        break label170;
      str1 = null;
      paramb.a(str1);
      if (!paramCursor.isNull(paramInt + 2))
        break label184;
      str2 = null;
      paramb.b(str2);
      if (!paramCursor.isNull(paramInt + 3))
        break label198;
      localBoolean = null;
      paramb.a(localBoolean);
      if (!paramCursor.isNull(paramInt + 4))
        break label229;
      localInteger1 = null;
      paramb.a(localInteger1);
      if (!paramCursor.isNull(paramInt + 5))
        break label246;
      localInteger2 = null;
      paramb.b(localInteger2);
      boolean bool2 = paramCursor.isNull(paramInt + 6);
      localInteger3 = null;
      if (!bool2)
        break label263;
    }
    while (true)
    {
      paramb.c(localInteger3);
      return;
      localLong = Long.valueOf(paramCursor.getLong(paramInt + 0));
      break;
      label170: str1 = paramCursor.getString(paramInt + 1);
      break label36;
      label184: str2 = paramCursor.getString(paramInt + 2);
      break label57;
      label198: if (paramCursor.getShort(paramInt + 3) != 0);
      for (boolean bool1 = true; ; bool1 = false)
      {
        localBoolean = Boolean.valueOf(bool1);
        break;
      }
      label229: localInteger1 = Integer.valueOf(paramCursor.getInt(paramInt + 4));
      break label99;
      label246: localInteger2 = Integer.valueOf(paramCursor.getInt(paramInt + 5));
      break label120;
      label263: localInteger3 = Integer.valueOf(paramCursor.getInt(paramInt + 6));
    }
  }

  protected void a(SQLiteStatement paramSQLiteStatement, b paramb)
  {
    paramSQLiteStatement.clearBindings();
    Long localLong = paramb.a();
    if (localLong != null)
      paramSQLiteStatement.bindLong(1, localLong.longValue());
    String str1 = paramb.b();
    if (str1 != null)
      paramSQLiteStatement.bindString(2, str1);
    String str2 = paramb.c();
    if (str2 != null)
      paramSQLiteStatement.bindString(3, str2);
    Boolean localBoolean = paramb.d();
    long l;
    if (localBoolean != null)
    {
      if (!localBoolean.booleanValue())
        break label156;
      l = 1L;
    }
    while (true)
    {
      paramSQLiteStatement.bindLong(4, l);
      Integer localInteger1 = paramb.e();
      if (localInteger1 != null)
        paramSQLiteStatement.bindLong(5, localInteger1.intValue());
      Integer localInteger2 = paramb.f();
      if (localInteger2 != null)
        paramSQLiteStatement.bindLong(6, localInteger2.intValue());
      Integer localInteger3 = paramb.g();
      if (localInteger3 != null)
        paramSQLiteStatement.bindLong(7, localInteger3.intValue());
      return;
      label156: l = 0L;
    }
  }

  public Long c(Cursor paramCursor, int paramInt)
  {
    if (paramCursor.isNull(paramInt + 0))
      return null;
    return Long.valueOf(paramCursor.getLong(paramInt + 0));
  }

  public b d(Cursor paramCursor, int paramInt)
  {
    Long localLong;
    String str1;
    label29: String str2;
    label44: Boolean localBoolean;
    Integer localInteger1;
    label74: Integer localInteger2;
    label89: Integer localInteger3;
    if (paramCursor.isNull(paramInt + 0))
    {
      localLong = null;
      if (!paramCursor.isNull(paramInt + 1))
        break label146;
      str1 = null;
      if (!paramCursor.isNull(paramInt + 2))
        break label160;
      str2 = null;
      if (!paramCursor.isNull(paramInt + 3))
        break label174;
      localBoolean = null;
      if (!paramCursor.isNull(paramInt + 4))
        break label205;
      localInteger1 = null;
      if (!paramCursor.isNull(paramInt + 5))
        break label222;
      localInteger2 = null;
      boolean bool2 = paramCursor.isNull(paramInt + 6);
      localInteger3 = null;
      if (!bool2)
        break label239;
    }
    while (true)
    {
      return new b(localLong, str1, str2, localBoolean, localInteger1, localInteger2, localInteger3);
      localLong = Long.valueOf(paramCursor.getLong(paramInt + 0));
      break;
      label146: str1 = paramCursor.getString(paramInt + 1);
      break label29;
      label160: str2 = paramCursor.getString(paramInt + 2);
      break label44;
      label174: if (paramCursor.getShort(paramInt + 3) != 0);
      for (boolean bool1 = true; ; bool1 = false)
      {
        localBoolean = Boolean.valueOf(bool1);
        break;
      }
      label205: localInteger1 = Integer.valueOf(paramCursor.getInt(paramInt + 4));
      break label74;
      label222: localInteger2 = Integer.valueOf(paramCursor.getInt(paramInt + 5));
      break label89;
      label239: localInteger3 = Integer.valueOf(paramCursor.getInt(paramInt + 6));
    }
  }

  protected boolean o()
  {
    return true;
  }

  public static class Properties
  {
    public static final i a = new i(0, Long.class, "CourseJiangYiId", true, "COURSE_JIANG_YI_ID");
    public static final i b = new i(1, String.class, "JiangYiPath", false, "JIANG_YI_PATH");
    public static final i c = new i(2, String.class, "JiangYiId", false, "JIANG_YI_ID");
    public static final i d = new i(3, Boolean.class, "isHaveDownload", false, "IS_HAVE_DOWNLOAD");
    public static final i e = new i(4, Integer.class, "currentProgress", false, "CURRENT_PROGRESS");
    public static final i f = new i(5, Integer.class, "JiangYiLength", false, "JIANG_YI_LENGTH");
    public static final i g = new i(6, Integer.class, "JiangYiDownStatus", false, "JIANG_YI_DOWN_STATUS");
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     koudai.db.CourseJiangYiInforDao
 * JD-Core Version:    0.6.0
 */