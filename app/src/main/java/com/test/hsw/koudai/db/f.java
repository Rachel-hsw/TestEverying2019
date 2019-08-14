package koudai.db;

import a.a.a.i;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class f
{
  private static final String a = "MIGRATION HELPER - CLASS DOESN'T MATCH WITH THE CURRENT PARAMETERS";
  private static f b;

  private String a(Class<?> paramClass)
    throws Exception
  {
    if (paramClass.equals(String.class))
      return "TEXT";
    if ((paramClass.equals(Long.class)) || (paramClass.equals(Integer.class)) || (paramClass.equals(Long.TYPE)))
      return "INTEGER";
    if (paramClass.equals(Boolean.class))
      return "BOOLEAN";
    throw new Exception("MIGRATION HELPER - CLASS DOESN'T MATCH WITH THE CURRENT PARAMETERS".concat(" - Class: ").concat(paramClass.toString()));
  }

  private static List<String> a(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    Cursor localCursor = null;
    Object localObject1 = new ArrayList();
    try
    {
      localCursor = paramSQLiteDatabase.rawQuery("SELECT * FROM " + paramString + " limit 1", null);
      if (localCursor != null)
      {
        ArrayList localArrayList = new ArrayList(Arrays.asList(localCursor.getColumnNames()));
        localObject1 = localArrayList;
      }
      return localObject1;
    }
    catch (Exception localException)
    {
      Log.v(paramString, localException.getMessage(), localException);
      localException.printStackTrace();
      return localObject1;
    }
    finally
    {
      if (localCursor != null)
        localCursor.close();
    }
    throw localObject2;
  }

  public static f a()
  {
    if (b == null)
      b = new f();
    return b;
  }

  private void b(SQLiteDatabase paramSQLiteDatabase, Class<? extends a.a.a.a<?, ?>>[] paramArrayOfClass)
  {
    int i = 0;
    if (i >= paramArrayOfClass.length)
      return;
    a.a.a.d.a locala = new a.a.a.d.a(paramSQLiteDatabase, paramArrayOfClass[i]);
    String str1 = "";
    String str2 = locala.b;
    String str3 = locala.b.concat("_TEMP");
    ArrayList localArrayList = new ArrayList();
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("CREATE TABLE ").append(str3).append(" (");
    int j = 0;
    while (true)
    {
      if (j >= locala.c.length)
      {
        localStringBuilder1.append(");");
        paramSQLiteDatabase.execSQL(localStringBuilder1.toString());
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("INSERT INTO ").append(str3).append(" (");
        localStringBuilder2.append(TextUtils.join(",", localArrayList));
        localStringBuilder2.append(") SELECT ");
        localStringBuilder2.append(TextUtils.join(",", localArrayList));
        localStringBuilder2.append(" FROM ").append(str2).append(";");
        paramSQLiteDatabase.execSQL(localStringBuilder2.toString());
        i++;
        break;
      }
      String str4 = locala.c[j].e;
      if (a(paramSQLiteDatabase, str2).contains(str4))
        localArrayList.add(str4);
      try
      {
        String str6 = a(locala.c[j].b);
        str5 = str6;
        localStringBuilder1.append(str1).append(str4).append(" ").append(str5);
        if (locala.c[j].d)
          localStringBuilder1.append(" PRIMARY KEY");
        str1 = ",";
        j++;
      }
      catch (Exception localException)
      {
        while (true)
          String str5 = null;
      }
    }
  }

  private void c(SQLiteDatabase paramSQLiteDatabase, Class<? extends a.a.a.a<?, ?>>[] paramArrayOfClass)
  {
    int i = 0;
    if (i >= paramArrayOfClass.length)
      return;
    a.a.a.d.a locala = new a.a.a.d.a(paramSQLiteDatabase, paramArrayOfClass[i]);
    String str1 = locala.b;
    String str2 = locala.b.concat("_TEMP");
    ArrayList localArrayList = new ArrayList();
    for (int j = 0; ; j++)
    {
      if (j >= locala.c.length)
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("INSERT INTO ").append(str1).append(" (");
        localStringBuilder1.append(TextUtils.join(",", localArrayList));
        localStringBuilder1.append(") SELECT ");
        localStringBuilder1.append(TextUtils.join(",", localArrayList));
        localStringBuilder1.append(" FROM ").append(str2).append(";");
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("DROP TABLE ").append(str2);
        paramSQLiteDatabase.execSQL(localStringBuilder1.toString());
        paramSQLiteDatabase.execSQL(localStringBuilder2.toString());
        i++;
        break;
      }
      String str3 = locala.c[j].e;
      if (!a(paramSQLiteDatabase, str2).contains(str3))
        continue;
      localArrayList.add(str3);
    }
  }

  public void a(SQLiteDatabase paramSQLiteDatabase, Class<? extends a.a.a.a<?, ?>>[] paramArrayOfClass)
  {
    b(paramSQLiteDatabase, paramArrayOfClass);
    c.b(paramSQLiteDatabase, true);
    c.a(paramSQLiteDatabase, false);
    c(paramSQLiteDatabase, paramArrayOfClass);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     koudai.db.f
 * JD-Core Version:    0.6.0
 */