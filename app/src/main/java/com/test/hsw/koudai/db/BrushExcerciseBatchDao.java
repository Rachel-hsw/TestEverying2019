package koudai.db;

import a.a.a.i;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

public class BrushExcerciseBatchDao extends a.a.a.a<a, Long>
{
  public static final String TABLENAME = "BRUSH_EXCERCISE_BATCH";

  public BrushExcerciseBatchDao(a.a.a.d.a parama)
  {
    super(parama);
  }

  public BrushExcerciseBatchDao(a.a.a.d.a parama, d paramd)
  {
    super(parama, paramd);
  }

  public static void a(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    if (paramBoolean);
    for (String str = "IF NOT EXISTS "; ; str = "")
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE " + str + "'BRUSH_EXCERCISE_BATCH' (" + "'BRUSH_EXCERCISE_BATCH_ID' INTEGER PRIMARY KEY AUTOINCREMENT ," + "'BRUSH_EXCERCISE_ID' TEXT," + "'BRUSH_TYPE' TEXT," + "'MOCK_COST_TIME' INTEGER);");
      return;
    }
  }

  public static void b(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder("DROP TABLE ");
    if (paramBoolean);
    for (String str = "IF EXISTS "; ; str = "")
    {
      paramSQLiteDatabase.execSQL(str + "'BRUSH_EXCERCISE_BATCH'");
      return;
    }
  }

  public Long a(a parama)
  {
    if (parama != null)
      return parama.a();
    return null;
  }

  protected Long a(a parama, long paramLong)
  {
    parama.a(Long.valueOf(paramLong));
    return Long.valueOf(paramLong);
  }

  public void a(Cursor paramCursor, a parama, int paramInt)
  {
    Long localLong1;
    String str1;
    label36: String str2;
    label57: Long localLong2;
    if (paramCursor.isNull(paramInt + 0))
    {
      localLong1 = null;
      parama.a(localLong1);
      if (!paramCursor.isNull(paramInt + 1))
        break label106;
      str1 = null;
      parama.a(str1);
      if (!paramCursor.isNull(paramInt + 2))
        break label120;
      str2 = null;
      parama.b(str2);
      boolean bool = paramCursor.isNull(paramInt + 3);
      localLong2 = null;
      if (!bool)
        break label134;
    }
    while (true)
    {
      parama.b(localLong2);
      return;
      localLong1 = Long.valueOf(paramCursor.getLong(paramInt + 0));
      break;
      label106: str1 = paramCursor.getString(paramInt + 1);
      break label36;
      label120: str2 = paramCursor.getString(paramInt + 2);
      break label57;
      label134: localLong2 = Long.valueOf(paramCursor.getLong(paramInt + 3));
    }
  }

  protected void a(SQLiteStatement paramSQLiteStatement, a parama)
  {
    paramSQLiteStatement.clearBindings();
    Long localLong1 = parama.a();
    if (localLong1 != null)
      paramSQLiteStatement.bindLong(1, localLong1.longValue());
    String str1 = parama.b();
    if (str1 != null)
      paramSQLiteStatement.bindString(2, str1);
    String str2 = parama.c();
    if (str2 != null)
      paramSQLiteStatement.bindString(3, str2);
    Long localLong2 = parama.d();
    if (localLong2 != null)
      paramSQLiteStatement.bindLong(4, localLong2.longValue());
  }

  public Long c(Cursor paramCursor, int paramInt)
  {
    if (paramCursor.isNull(paramInt + 0))
      return null;
    return Long.valueOf(paramCursor.getLong(paramInt + 0));
  }

  public a d(Cursor paramCursor, int paramInt)
  {
    Long localLong1;
    String str1;
    label29: String str2;
    label44: Long localLong2;
    if (paramCursor.isNull(paramInt + 0))
    {
      localLong1 = null;
      if (!paramCursor.isNull(paramInt + 1))
        break label94;
      str1 = null;
      if (!paramCursor.isNull(paramInt + 2))
        break label108;
      str2 = null;
      boolean bool = paramCursor.isNull(paramInt + 3);
      localLong2 = null;
      if (!bool)
        break label122;
    }
    while (true)
    {
      return new a(localLong1, str1, str2, localLong2);
      localLong1 = Long.valueOf(paramCursor.getLong(paramInt + 0));
      break;
      label94: str1 = paramCursor.getString(paramInt + 1);
      break label29;
      label108: str2 = paramCursor.getString(paramInt + 2);
      break label44;
      label122: localLong2 = Long.valueOf(paramCursor.getLong(paramInt + 3));
    }
  }

  protected boolean o()
  {
    return true;
  }

  public static class Properties
  {
    public static final i a = new i(0, Long.class, "BrushExcerciseBatchId", true, "BRUSH_EXCERCISE_BATCH_ID");
    public static final i b = new i(1, String.class, "BrushExcerciseId", false, "BRUSH_EXCERCISE_ID");
    public static final i c = new i(2, String.class, "BrushType", false, "BRUSH_TYPE");
    public static final i d = new i(3, Long.class, "MockCostTime", false, "MOCK_COST_TIME");
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     koudai.db.BrushExcerciseBatchDao
 * JD-Core Version:    0.6.0
 */