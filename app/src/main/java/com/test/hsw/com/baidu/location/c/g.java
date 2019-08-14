package com.baidu.location.c;

import android.database.sqlite.SQLiteDatabase;
import com.baidu.location.Jni;
import com.baidu.location.b.b;
import com.baidu.location.b.m;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.apache.http.ParseException;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

final class g
  implements b
{
  private static final String ba;
  private static final String bb;
  private static final int bc = 3;
  private static final int bd = 3000;
  private final SQLiteDatabase a8;
  private String a9 = null;
  private final a be;

  static
  {
    Locale localLocale1 = Locale.US;
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = Integer.valueOf(3000);
    bb = String.format(localLocale1, "DELETE FROM LOG WHERE timestamp NOT IN (SELECT timestamp FROM LOG ORDER BY timestamp DESC LIMIT %d);", arrayOfObject1);
    Locale localLocale2 = Locale.US;
    Object[] arrayOfObject2 = new Object[1];
    arrayOfObject2[0] = Integer.valueOf(3);
    ba = String.format(localLocale2, "SELECT * FROM LOG ORDER BY timestamp DESC LIMIT %d;", arrayOfObject2);
  }

  g(SQLiteDatabase paramSQLiteDatabase)
  {
    this.a8 = paramSQLiteDatabase;
    this.be = new a(this);
    if ((this.a8 != null) && (this.a8.isOpen()))
      this.a8.execSQL("CREATE TABLE IF NOT EXISTS LOG(timestamp LONG PRIMARY KEY, log VARCHAR(4000))");
  }

  // ERROR //
  private String J()
  {
    // Byte code:
    //   0: new 82	org/json/JSONArray
    //   3: dup
    //   4: invokespecial 83	org/json/JSONArray:<init>	()V
    //   7: astore_1
    //   8: new 85	org/json/JSONObject
    //   11: dup
    //   12: invokespecial 86	org/json/JSONObject:<init>	()V
    //   15: astore_2
    //   16: aload_0
    //   17: getfield 55	com/baidu/location/c/g:a8	Landroid/database/sqlite/SQLiteDatabase;
    //   20: getstatic 47	com/baidu/location/c/g:ba	Ljava/lang/String;
    //   23: aconst_null
    //   24: invokevirtual 90	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   27: astore 10
    //   29: aload 10
    //   31: astore 5
    //   33: aconst_null
    //   34: astore 4
    //   36: aload 5
    //   38: ifnull +145 -> 183
    //   41: aload 5
    //   43: invokeinterface 96 1 0
    //   48: istore 13
    //   50: aconst_null
    //   51: astore 4
    //   53: iload 13
    //   55: ifle +128 -> 183
    //   58: new 98	java/lang/StringBuffer
    //   61: dup
    //   62: invokespecial 99	java/lang/StringBuffer:<init>	()V
    //   65: astore 14
    //   67: aload 5
    //   69: invokeinterface 102 1 0
    //   74: pop
    //   75: aload 5
    //   77: invokeinterface 105 1 0
    //   82: ifne +74 -> 156
    //   85: aload_1
    //   86: aload 5
    //   88: iconst_1
    //   89: invokeinterface 109 2 0
    //   94: invokevirtual 113	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   97: pop
    //   98: aload 14
    //   100: invokevirtual 116	java/lang/StringBuffer:length	()I
    //   103: ifeq +11 -> 114
    //   106: aload 14
    //   108: ldc 118
    //   110: invokevirtual 122	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   113: pop
    //   114: aload 14
    //   116: aload 5
    //   118: iconst_0
    //   119: invokeinterface 126 2 0
    //   124: invokevirtual 129	java/lang/StringBuffer:append	(J)Ljava/lang/StringBuffer;
    //   127: pop
    //   128: aload 5
    //   130: invokeinterface 132 1 0
    //   135: pop
    //   136: goto -61 -> 75
    //   139: astore 12
    //   141: aload 5
    //   143: ifnull +10 -> 153
    //   146: aload 5
    //   148: invokeinterface 135 1 0
    //   153: aload 4
    //   155: areturn
    //   156: aload_2
    //   157: ldc 137
    //   159: aload_1
    //   160: invokevirtual 140	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   163: pop
    //   164: aload_2
    //   165: invokevirtual 143	org/json/JSONObject:toString	()Ljava/lang/String;
    //   168: astore 18
    //   170: aload 18
    //   172: astore 4
    //   174: aload_0
    //   175: aload 14
    //   177: invokevirtual 144	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   180: putfield 53	com/baidu/location/c/g:a9	Ljava/lang/String;
    //   183: aload 5
    //   185: ifnull -32 -> 153
    //   188: aload 5
    //   190: invokeinterface 135 1 0
    //   195: aload 4
    //   197: areturn
    //   198: astore 11
    //   200: aload 4
    //   202: areturn
    //   203: astore 7
    //   205: aconst_null
    //   206: astore 5
    //   208: aload 7
    //   210: astore 8
    //   212: aload 5
    //   214: ifnull +10 -> 224
    //   217: aload 5
    //   219: invokeinterface 135 1 0
    //   224: aload 8
    //   226: athrow
    //   227: astore 6
    //   229: aload 4
    //   231: areturn
    //   232: astore 9
    //   234: goto -10 -> 224
    //   237: astore 8
    //   239: goto -27 -> 212
    //   242: astore_3
    //   243: aconst_null
    //   244: astore 4
    //   246: aconst_null
    //   247: astore 5
    //   249: goto -108 -> 141
    //   252: astore 16
    //   254: aconst_null
    //   255: astore 4
    //   257: goto -83 -> 174
    //
    // Exception table:
    //   from	to	target	type
    //   41	50	139	java/lang/Exception
    //   58	75	139	java/lang/Exception
    //   75	114	139	java/lang/Exception
    //   114	136	139	java/lang/Exception
    //   156	170	139	java/lang/Exception
    //   174	183	139	java/lang/Exception
    //   188	195	198	java/lang/Exception
    //   16	29	203	finally
    //   146	153	227	java/lang/Exception
    //   217	224	232	java/lang/Exception
    //   41	50	237	finally
    //   58	75	237	finally
    //   75	114	237	finally
    //   114	136	237	finally
    //   156	170	237	finally
    //   174	183	237	finally
    //   16	29	242	java/lang/Exception
    //   156	170	252	org/json/JSONException
  }

  private void jdMethod_if(boolean paramBoolean)
  {
    String str;
    if ((paramBoolean) && (this.a9 != null))
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this.a9;
      str = String.format("DELETE FROM LOG WHERE timestamp in (%s);", arrayOfObject);
    }
    try
    {
      if (this.a9.length() > 0)
        this.a8.execSQL(str);
      label48: this.a9 = null;
      return;
    }
    catch (Exception localException)
    {
      break label48;
    }
  }

  void I()
  {
    a.jdMethod_for(this.be);
  }

  void jdMethod_byte(String paramString)
  {
    String str1 = Jni.G(paramString);
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Long.valueOf(System.currentTimeMillis());
    arrayOfObject[1] = str1;
    String str2 = String.format(localLocale, "INSERT OR IGNORE INTO LOG VALUES (%d,\"%s\");", arrayOfObject);
    try
    {
      this.a8.execSQL(str2);
      this.a8.execSQL(bb);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private class a extends m
  {
    private static final long ei = 86400000L;
    private static final String ej = "ofbh";
    private static final String el = "qt";
    private static final int eo = -1;
    private static final int eq = 2;
    private static final String es = "req";
    private static final int et = 161;
    private static final String eu = "error";
    private int eg;
    private String eh;
    private g ek;
    private boolean en;
    private long ep;
    private boolean er;

    a(g arg2)
    {
      Object localObject;
      this.ek = localObject;
      this.eh = null;
      this.en = false;
      this.er = false;
      this.c7 = new ArrayList();
      this.eg = 0;
      this.ep = -1L;
    }

    private void aK()
    {
      if (!this.en)
      {
        this.eh = g.jdMethod_if(this.ek);
        if ((this.ep != -1L) && (86400000L + this.ep <= System.currentTimeMillis()))
        {
          this.eg = 0;
          this.ep = -1L;
        }
        if ((this.eh != null) && (this.eg < 2))
        {
          this.en = true;
          ao();
        }
      }
    }

    public void au()
    {
      this.c7.clear();
      this.c7.add(new BasicNameValuePair("qt", "ofbh"));
      this.c7.add(new BasicNameValuePair("req", this.eh));
      this.c5 = d.ak;
    }

    public void jdMethod_int(boolean paramBoolean)
    {
      this.er = false;
      if ((paramBoolean) && (this.c6 != null));
      try
      {
        JSONObject localJSONObject = new JSONObject(EntityUtils.toString(this.c6, "utf-8"));
        if ((localJSONObject != null) && (localJSONObject.has("error")) && (localJSONObject.getInt("error") == 161))
          this.er = true;
        label63: this.en = false;
        if (!this.er)
        {
          this.eg = (1 + this.eg);
          this.ep = System.currentTimeMillis();
        }
        new g.a.1(this).start();
        return;
      }
      catch (IOException localIOException)
      {
        break label63;
      }
      catch (JSONException localJSONException)
      {
        break label63;
      }
      catch (ParseException localParseException)
      {
        break label63;
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.baidu.location.c.g
 * JD-Core Version:    0.6.0
 */