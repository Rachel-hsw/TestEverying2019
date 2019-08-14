package koudai.db;

import a.a.a.i;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

public class UserAnsDao extends a.a.a.a<h, Long>
{
  public static final String TABLENAME = "USER_ANS";

  public UserAnsDao(a.a.a.d.a parama)
  {
    super(parama);
  }

  public UserAnsDao(a.a.a.d.a parama, d paramd)
  {
    super(parama, paramd);
  }

  public static void a(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    if (paramBoolean);
    for (String str = "IF NOT EXISTS "; ; str = "")
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE " + str + "'USER_ANS' (" + "'USER_ANSWERS_ID' INTEGER PRIMARY KEY AUTOINCREMENT ," + "'BRUSH_TIME' INTEGER," + "'EXCER_ID_KPOINT_ID' TEXT," + "'IS_CONFIRM' INTEGER," + "'IS_CORRECT' INTEGER," + "'USER_SCORE' REAL," + "'EXCERCISE_BRUSH_ID' TEXT," + "'CORRECT_ANSWER' TEXT," + "'USER_ANSWER' TEXT," + "'EXERCISE_ID' TEXT," + "'KPOINT_ID' TEXT," + "'SUBJECT_ID' TEXT);");
      return;
    }
  }

  public static void b(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder("DROP TABLE ");
    if (paramBoolean);
    for (String str = "IF EXISTS "; ; str = "")
    {
      paramSQLiteDatabase.execSQL(str + "'USER_ANS'");
      return;
    }
  }

  public Long a(h paramh)
  {
    if (paramh != null)
      return paramh.a();
    return null;
  }

  protected Long a(h paramh, long paramLong)
  {
    paramh.a(Long.valueOf(paramLong));
    return Long.valueOf(paramLong);
  }

  public void a(Cursor paramCursor, h paramh, int paramInt)
  {
    boolean bool1 = true;
    Long localLong1;
    Long localLong2;
    label39: String str1;
    label60: Boolean localBoolean1;
    Boolean localBoolean2;
    Double localDouble;
    label123: String str2;
    label145: String str3;
    label167: String str4;
    label189: String str5;
    label211: String str6;
    label233: String str7;
    if (paramCursor.isNull(paramInt + 0))
    {
      localLong1 = null;
      paramh.a(localLong1);
      if (!paramCursor.isNull(paramInt + 1))
        break label283;
      localLong2 = null;
      paramh.b(localLong2);
      if (!paramCursor.isNull(paramInt + 2))
        break label300;
      str1 = null;
      paramh.a(str1);
      if (!paramCursor.isNull(paramInt + 3))
        break label314;
      localBoolean1 = null;
      paramh.a(localBoolean1);
      if (!paramCursor.isNull(paramInt + 4))
        break label346;
      localBoolean2 = null;
      paramh.b(localBoolean2);
      if (!paramCursor.isNull(paramInt + 5))
        break label374;
      localDouble = null;
      paramh.a(localDouble);
      if (!paramCursor.isNull(paramInt + 6))
        break label391;
      str2 = null;
      paramh.b(str2);
      if (!paramCursor.isNull(paramInt + 7))
        break label406;
      str3 = null;
      paramh.c(str3);
      if (!paramCursor.isNull(paramInt + 8))
        break label421;
      str4 = null;
      paramh.d(str4);
      if (!paramCursor.isNull(paramInt + 9))
        break label436;
      str5 = null;
      paramh.e(str5);
      if (!paramCursor.isNull(paramInt + 10))
        break label451;
      str6 = null;
      paramh.f(str6);
      boolean bool3 = paramCursor.isNull(paramInt + 11);
      str7 = null;
      if (!bool3)
        break label466;
    }
    while (true)
    {
      paramh.g(str7);
      return;
      localLong1 = Long.valueOf(paramCursor.getLong(paramInt + 0));
      break;
      label283: localLong2 = Long.valueOf(paramCursor.getLong(paramInt + 1));
      break label39;
      label300: str1 = paramCursor.getString(paramInt + 2);
      break label60;
      label314: if (paramCursor.getShort(paramInt + 3) != 0);
      for (boolean bool2 = bool1; ; bool2 = false)
      {
        localBoolean1 = Boolean.valueOf(bool2);
        break;
      }
      label346: if (paramCursor.getShort(paramInt + 4) != 0);
      while (true)
      {
        localBoolean2 = Boolean.valueOf(bool1);
        break;
        bool1 = false;
      }
      label374: localDouble = Double.valueOf(paramCursor.getDouble(paramInt + 5));
      break label123;
      label391: str2 = paramCursor.getString(paramInt + 6);
      break label145;
      label406: str3 = paramCursor.getString(paramInt + 7);
      break label167;
      label421: str4 = paramCursor.getString(paramInt + 8);
      break label189;
      label436: str5 = paramCursor.getString(paramInt + 9);
      break label211;
      label451: str6 = paramCursor.getString(paramInt + 10);
      break label233;
      label466: str7 = paramCursor.getString(paramInt + 11);
    }
  }

  protected void a(SQLiteStatement paramSQLiteStatement, h paramh)
  {
    long l1 = 1L;
    paramSQLiteStatement.clearBindings();
    Long localLong1 = paramh.a();
    if (localLong1 != null)
      paramSQLiteStatement.bindLong(1, localLong1.longValue());
    Long localLong2 = paramh.b();
    if (localLong2 != null)
      paramSQLiteStatement.bindLong(2, localLong2.longValue());
    String str1 = paramh.c();
    if (str1 != null)
      paramSQLiteStatement.bindString(3, str1);
    Boolean localBoolean1 = paramh.d();
    long l2;
    if (localBoolean1 != null)
    {
      if (localBoolean1.booleanValue())
      {
        l2 = l1;
        paramSQLiteStatement.bindLong(4, l2);
      }
    }
    else
    {
      Boolean localBoolean2 = paramh.e();
      if (localBoolean2 != null)
        if (!localBoolean2.booleanValue())
          break label263;
    }
    while (true)
    {
      paramSQLiteStatement.bindLong(5, l1);
      Double localDouble = paramh.f();
      if (localDouble != null)
        paramSQLiteStatement.bindDouble(6, localDouble.doubleValue());
      String str2 = paramh.g();
      if (str2 != null)
        paramSQLiteStatement.bindString(7, str2);
      String str3 = paramh.h();
      if (str3 != null)
        paramSQLiteStatement.bindString(8, str3);
      String str4 = paramh.i();
      if (str4 != null)
        paramSQLiteStatement.bindString(9, str4);
      String str5 = paramh.j();
      if (str5 != null)
        paramSQLiteStatement.bindString(10, str5);
      String str6 = paramh.k();
      if (str6 != null)
        paramSQLiteStatement.bindString(11, str6);
      String str7 = paramh.l();
      if (str7 != null)
        paramSQLiteStatement.bindString(12, str7);
      return;
      l2 = 0L;
      break;
      label263: l1 = 0L;
    }
  }

  public Long c(Cursor paramCursor, int paramInt)
  {
    if (paramCursor.isNull(paramInt + 0))
      return null;
    return Long.valueOf(paramCursor.getLong(paramInt + 0));
  }

  public h d(Cursor paramCursor, int paramInt)
  {
    Long localLong1;
    Long localLong2;
    label29: String str1;
    label44: Boolean localBoolean1;
    Boolean localBoolean2;
    Double localDouble;
    label89: String str2;
    label105: String str3;
    label121: String str4;
    label137: String str5;
    label153: String str6;
    if (paramCursor.isNull(paramInt + 0))
    {
      localLong1 = null;
      if (!paramCursor.isNull(paramInt + 1))
        break label232;
      localLong2 = null;
      if (!paramCursor.isNull(paramInt + 2))
        break label249;
      str1 = null;
      if (!paramCursor.isNull(paramInt + 3))
        break label263;
      localBoolean1 = null;
      if (!paramCursor.isNull(paramInt + 4))
        break label294;
      localBoolean2 = null;
      if (!paramCursor.isNull(paramInt + 5))
        break label325;
      localDouble = null;
      if (!paramCursor.isNull(paramInt + 6))
        break label342;
      str2 = null;
      if (!paramCursor.isNull(paramInt + 7))
        break label357;
      str3 = null;
      if (!paramCursor.isNull(paramInt + 8))
        break label372;
      str4 = null;
      if (!paramCursor.isNull(paramInt + 9))
        break label387;
      str5 = null;
      if (!paramCursor.isNull(paramInt + 10))
        break label402;
      str6 = null;
      label169: if (!paramCursor.isNull(paramInt + 11))
        break label417;
    }
    label263: label402: label417: for (String str7 = null; ; str7 = paramCursor.getString(paramInt + 11))
    {
      return new h(localLong1, localLong2, str1, localBoolean1, localBoolean2, localDouble, str2, str3, str4, str5, str6, str7);
      localLong1 = Long.valueOf(paramCursor.getLong(paramInt + 0));
      break;
      label232: localLong2 = Long.valueOf(paramCursor.getLong(paramInt + 1));
      break label29;
      label249: str1 = paramCursor.getString(paramInt + 2);
      break label44;
      if (paramCursor.getShort(paramInt + 3) != 0);
      for (boolean bool1 = true; ; bool1 = false)
      {
        localBoolean1 = Boolean.valueOf(bool1);
        break;
      }
      label294: if (paramCursor.getShort(paramInt + 4) != 0);
      for (boolean bool2 = true; ; bool2 = false)
      {
        localBoolean2 = Boolean.valueOf(bool2);
        break;
      }
      label325: localDouble = Double.valueOf(paramCursor.getDouble(paramInt + 5));
      break label89;
      label342: str2 = paramCursor.getString(paramInt + 6);
      break label105;
      label357: str3 = paramCursor.getString(paramInt + 7);
      break label121;
      label372: str4 = paramCursor.getString(paramInt + 8);
      break label137;
      str5 = paramCursor.getString(paramInt + 9);
      break label153;
      str6 = paramCursor.getString(paramInt + 10);
      break label169;
    }
  }

  protected boolean o()
  {
    return true;
  }

  public static class Properties
  {
    public static final i a = new i(0, Long.class, "UserAnswersId", true, "USER_ANSWERS_ID");
    public static final i b = new i(1, Long.class, "BrushTime", false, "BRUSH_TIME");
    public static final i c = new i(2, String.class, "excerId_kpointId", false, "EXCER_ID_KPOINT_ID");
    public static final i d = new i(3, Boolean.class, "IsConfirm", false, "IS_CONFIRM");
    public static final i e = new i(4, Boolean.class, "isCorrect", false, "IS_CORRECT");
    public static final i f = new i(5, Double.class, "userScore", false, "USER_SCORE");
    public static final i g = new i(6, String.class, "ExcerciseBrushId", false, "EXCERCISE_BRUSH_ID");
    public static final i h = new i(7, String.class, "CorrectAnswer", false, "CORRECT_ANSWER");
    public static final i i = new i(8, String.class, "UserAnswer", false, "USER_ANSWER");
    public static final i j = new i(9, String.class, "ExerciseId", false, "EXERCISE_ID");
    public static final i k = new i(10, String.class, "KpointId", false, "KPOINT_ID");
    public static final i l = new i(11, String.class, "SubjectId", false, "SUBJECT_ID");
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     koudai.db.UserAnsDao
 * JD-Core Version:    0.6.0
 */