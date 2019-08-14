package a.a.a;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class f
{
  public static int a(Context paramContext, SQLiteDatabase paramSQLiteDatabase, String paramString)
    throws IOException
  {
    return a(paramContext, paramSQLiteDatabase, paramString, true);
  }

  public static int a(Context paramContext, SQLiteDatabase paramSQLiteDatabase, String paramString, boolean paramBoolean)
    throws IOException
  {
    String[] arrayOfString = new String(a(paramContext, paramString), "UTF-8").split(";(\\s)*[\n\r]");
    if (paramBoolean);
    for (int i = a(paramSQLiteDatabase, arrayOfString); ; i = b(paramSQLiteDatabase, arrayOfString))
    {
      e.c("Executed " + i + " statements from SQL script '" + paramString + "'");
      return i;
    }
  }

  public static int a(SQLiteDatabase paramSQLiteDatabase, String[] paramArrayOfString)
  {
    paramSQLiteDatabase.beginTransaction();
    try
    {
      int i = b(paramSQLiteDatabase, paramArrayOfString);
      paramSQLiteDatabase.setTransactionSuccessful();
      return i;
    }
    finally
    {
      paramSQLiteDatabase.endTransaction();
    }
    throw localObject;
  }

  public static int a(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    byte[] arrayOfByte = new byte[4096];
    int i = 0;
    while (true)
    {
      int j = paramInputStream.read(arrayOfByte);
      if (j == -1)
        return i;
      paramOutputStream.write(arrayOfByte, 0, j);
      i += j;
    }
  }

  public static void a(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("VACUUM");
  }

  public static void a(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    Cursor localCursor = paramSQLiteDatabase.query(paramString, null, null, null, null, null, null);
    try
    {
      e.b(DatabaseUtils.dumpCursorToString(localCursor));
      return;
    }
    finally
    {
      localCursor.close();
    }
    throw localObject;
  }

  public static byte[] a(Context paramContext, String paramString)
    throws IOException
  {
    InputStream localInputStream = paramContext.getResources().getAssets().open(paramString);
    try
    {
      byte[] arrayOfByte = a(localInputStream);
      return arrayOfByte;
    }
    finally
    {
      localInputStream.close();
    }
    throw localObject;
  }

  public static byte[] a(InputStream paramInputStream)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    a(paramInputStream, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }

  public static int b(SQLiteDatabase paramSQLiteDatabase, String[] paramArrayOfString)
  {
    int i = 0;
    int j = paramArrayOfString.length;
    for (int k = 0; ; k++)
    {
      if (k >= j)
        return i;
      String str = paramArrayOfString[k].trim();
      if (str.length() <= 0)
        continue;
      paramSQLiteDatabase.execSQL(str);
      i++;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     a.a.a.f
 * JD-Core Version:    0.6.0
 */