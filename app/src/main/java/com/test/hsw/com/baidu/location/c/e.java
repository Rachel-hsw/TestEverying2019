package com.baidu.location.c;

import android.database.sqlite.SQLiteDatabase;
import com.baidu.location.Jni;
import com.baidu.location.b.b;
import com.baidu.location.b.c;
import com.baidu.location.b.f;
import com.baidu.location.b.k;
import com.baidu.location.b.m;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

final class e
  implements b
{
  private static final String au = "ofl.config";
  private final d aA;
  private boolean aB = true;
  private boolean aC;
  private boolean aD;
  private boolean aE;
  private boolean aF;
  private String[] aG;
  private double aH;
  private long aI = 8000L;
  private int aJ;
  private long aK = 5000L;
  private double aL;
  private int aM;
  private int aN;
  private boolean aO;
  private final a aP;
  private double aQ;
  private final SQLiteDatabase aR;
  private long aS = 5000L;
  private int aT;
  private long av = 5000L;
  private double aw;
  private boolean ax;
  private double ay;
  private long az = 5000L;

  e(d paramd, SQLiteDatabase paramSQLiteDatabase)
  {
    this.aA = paramd;
    this.aO = false;
    this.ax = false;
    this.aE = false;
    this.aD = false;
    this.aF = false;
    this.aC = false;
    this.aN = 6;
    this.aJ = 30;
    this.aM = 30;
    this.aw = 0.0D;
    this.aL = 0.0D;
    this.aQ = 0.0D;
    this.ay = 0.0D;
    this.aH = 0.0D;
    this.aT = 8;
    this.aG = new String[0];
    this.aR = paramSQLiteDatabase;
    this.aP = new a(null);
    if ((this.aR != null) && (this.aR.isOpen()))
      this.aR.execSQL("CREATE TABLE IF NOT EXISTS BLACK (name VARCHAR(100) PRIMARY KEY);");
    q();
  }

  double A()
  {
    return this.aw;
  }

  boolean B()
  {
    return this.aC;
  }

  boolean C()
  {
    return this.aE;
  }

  int D()
  {
    return this.aJ;
  }

  double E()
  {
    return this.ay;
  }

  void jdMethod_int(String[] paramArrayOfString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    for (int i = 0; i < paramArrayOfString.length; i++)
    {
      if (i > 0)
        localStringBuffer.append(",");
      localStringBuffer.append("(\"");
      localStringBuffer.append(paramArrayOfString[i]);
      localStringBuffer.append("\")");
    }
    String str;
    if ((this.aR != null) && (this.aR.isOpen()) && (localStringBuffer.length() > 0))
    {
      Locale localLocale = Locale.US;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = localStringBuffer.toString();
      str = String.format(localLocale, "INSERT OR IGNORE INTO BLACK VALUES %s;", arrayOfObject);
    }
    try
    {
      this.aR.execSQL(str);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  // ERROR //
  boolean jdMethod_new(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: getstatic 186	java/util/Locale:US	Ljava/util/Locale;
    //   5: ldc 199
    //   7: iconst_1
    //   8: anewarray 4	java/lang/Object
    //   11: dup
    //   12: iconst_0
    //   13: aload_1
    //   14: aastore
    //   15: invokestatic 196	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   18: astore_3
    //   19: aload_0
    //   20: getfield 102	com/baidu/location/c/e:aR	Landroid/database/sqlite/SQLiteDatabase;
    //   23: aload_3
    //   24: aconst_null
    //   25: invokevirtual 203	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   28: astore_2
    //   29: aload_2
    //   30: invokeinterface 208 1 0
    //   35: istore 9
    //   37: iconst_0
    //   38: istore 7
    //   40: iload 9
    //   42: ifle +6 -> 48
    //   45: iconst_1
    //   46: istore 7
    //   48: aload_2
    //   49: ifnull +9 -> 58
    //   52: aload_2
    //   53: invokeinterface 211 1 0
    //   58: iload 7
    //   60: ifeq +3 -> 63
    //   63: iload 7
    //   65: ireturn
    //   66: astore 6
    //   68: iconst_0
    //   69: istore 7
    //   71: aload_2
    //   72: ifnull -14 -> 58
    //   75: aload_2
    //   76: invokeinterface 211 1 0
    //   81: iconst_0
    //   82: istore 7
    //   84: goto -26 -> 58
    //   87: astore 8
    //   89: iconst_0
    //   90: istore 7
    //   92: goto -34 -> 58
    //   95: astore 4
    //   97: aload_2
    //   98: ifnull +9 -> 107
    //   101: aload_2
    //   102: invokeinterface 211 1 0
    //   107: aload 4
    //   109: athrow
    //   110: astore 10
    //   112: goto -54 -> 58
    //   115: astore 5
    //   117: goto -10 -> 107
    //
    // Exception table:
    //   from	to	target	type
    //   19	37	66	java/lang/Exception
    //   75	81	87	java/lang/Exception
    //   19	37	95	finally
    //   52	58	110	java/lang/Exception
    //   101	107	115	java/lang/Exception
  }

  int o()
  {
    return this.aN;
  }

  double p()
  {
    return this.aQ;
  }

  void q()
  {
    a.jdMethod_if(this.aP);
  }

  double r()
  {
    return this.aL;
  }

  int s()
  {
    return this.aT;
  }

  boolean t()
  {
    return this.aB;
  }

  long jdMethod_try(String paramString)
  {
    long l = 5000L;
    if (paramString.equals("2G"))
      l = this.aI;
    do
    {
      return l;
      if (paramString.equals("3G"))
        return this.aS;
      if (paramString.equals("4G"))
        return this.az;
      if (paramString.equals("WIFI"))
        return this.aK;
    }
    while (!paramString.equals("unknown"));
    return this.av;
  }

  int u()
  {
    return this.aM;
  }

  String[] v()
  {
    return this.aG;
  }

  boolean w()
  {
    return this.aO;
  }

  boolean x()
  {
    return this.ax;
  }

  boolean y()
  {
    return this.aD;
  }

  double z()
  {
    return this.aH;
  }

  private final class a extends m
    implements f
  {
    private static final String d0 = "0";
    private static final String d1 = "wn";
    private static final String d2 = "addrup";
    private static final String d3 = "poiup";
    private static final String d4 = "bklist";
    private static final String d5 = "2";
    private static final String d6 = "para";
    private static final String d7 = "fl";
    private static final String d8 = "rgcgp";
    private static final String dH = "3";
    private static final String dI = "t";
    private static final String dK = "oflp";
    private static final String dL = "rgcon";
    private static final String dO = "req";
    private static final String dP = "conf";
    private static final int dQ = -1;
    private static final String dR = "1";
    private static final String dS = "ol";
    private static final String dT = "oc";
    private static final String dV = "4";
    private static final long dW = 86400000L;
    private static final String dX = "ver";
    private static final int dY = 2;
    private static final String dZ = "cplist";
    private static final String eb = "on";
    private static final String ec = "onlt";
    private static final String ed = "minapn";
    private static final String ee = "qt";
    private static final String ef = "ofl";
    private final String d9;
    private boolean dJ = false;
    private long dM = -1L;
    private int dN = 0;
    private long dU = -1L;

    private a()
    {
      this.c7 = new ArrayList();
      Locale localLocale = Locale.US;
      Object[] arrayOfObject = new Object[5];
      arrayOfObject[0] = "1";
      arrayOfObject[1] = c.N().bm;
      arrayOfObject[2] = c.bj;
      arrayOfObject[3] = c.bn;
      arrayOfObject[4] = Float.valueOf(6.13F);
      this.d9 = Jni.G(String.format(localLocale, "&ver=%s&cuid=%s&prod=%s:%s&sdk=%.2f", arrayOfObject));
    }

    private boolean aI()
    {
      int i = 1;
      if (this.dN < 2);
      while (true)
      {
        if (i == 0);
        return i;
        if (86400000L + this.dU < System.currentTimeMillis())
        {
          this.dN = 0;
          this.dU = -1L;
          continue;
        }
        i = 0;
      }
    }

    private void aJ()
    {
      if (this.dJ);
      while (true)
      {
        return;
        try
        {
          File localFile = new File(e.jdMethod_else(e.this).d(), "ofl.config");
          if ((this.dM == -1L) && (localFile.exists()))
          {
            Scanner localScanner = new Scanner(localFile);
            String str = localScanner.next();
            localScanner.close();
            JSONObject localJSONObject1 = new JSONObject(str);
            e.jdMethod_if(e.this, localJSONObject1.getBoolean("ol"));
            e.jdMethod_do(e.this, localJSONObject1.getBoolean("fl"));
            e.jdMethod_for(e.this, localJSONObject1.getBoolean("on"));
            e.jdMethod_int(e.this, localJSONObject1.getBoolean("wn"));
            e.jdMethod_new(e.this, localJSONObject1.getBoolean("oc"));
            this.dM = localJSONObject1.getLong("t");
            if (localJSONObject1.has("cplist"))
              e.jdMethod_if(e.this, localJSONObject1.getString("cplist").split(";"));
            if (localJSONObject1.has("rgcgp"))
              e.jdMethod_for(e.this, localJSONObject1.getInt("rgcgp"));
            if (localJSONObject1.has("rgcon"))
              e.jdMethod_try(e.this, localJSONObject1.getBoolean("rgcon"));
            if (localJSONObject1.has("addrup"))
              e.jdMethod_if(e.this, localJSONObject1.getInt("addrup"));
            if (localJSONObject1.has("poiup"))
              e.jdMethod_do(e.this, localJSONObject1.getInt("poiup"));
            if (localJSONObject1.has("oflp"))
            {
              JSONObject localJSONObject3 = localJSONObject1.getJSONObject("oflp");
              if (localJSONObject3.has("0"))
                e.jdMethod_new(e.this, localJSONObject3.getDouble("0"));
              if (localJSONObject3.has("1"))
                e.jdMethod_if(e.this, localJSONObject3.getDouble("1"));
              if (localJSONObject3.has("2"))
                e.jdMethod_do(e.this, localJSONObject3.getDouble("2"));
              if (localJSONObject3.has("3"))
                e.jdMethod_for(e.this, localJSONObject3.getDouble("3"));
              if (localJSONObject3.has("4"))
                e.jdMethod_int(e.this, localJSONObject3.getDouble("4"));
            }
            if (localJSONObject1.has("onlt"))
            {
              JSONObject localJSONObject2 = localJSONObject1.getJSONObject("onlt");
              if (localJSONObject2.has("0"))
                e.jdMethod_for(e.this, localJSONObject2.getLong("0"));
              if (localJSONObject2.has("1"))
                e.jdMethod_int(e.this, localJSONObject2.getLong("1"));
              if (localJSONObject2.has("2"))
                e.jdMethod_if(e.this, localJSONObject2.getLong("2"));
              if (localJSONObject2.has("3"))
                e.jdMethod_new(e.this, localJSONObject2.getLong("3"));
              if (localJSONObject2.has("4"))
                e.jdMethod_do(e.this, localJSONObject2.getLong("4"));
            }
            if (localJSONObject1.has("minapn"))
              e.jdMethod_int(e.this, localJSONObject1.getInt("minapn"));
          }
          if ((this.dM == -1L) && (!localFile.exists()));
          boolean bool1 = this.dM < -1L;
          i = 0;
          if (bool1)
          {
            long l1 = 86400000L + this.dM;
            long l2 = System.currentTimeMillis();
            boolean bool2 = l1 < l2;
            i = 0;
            if (!bool2)
              i = 1;
          }
          if (((this.dM != -1L) && (i == 0)) || (!aI()) || (!k.jdMethod_for(e.jdMethod_else(e.this).jdMethod_char())))
            continue;
          this.dJ = true;
          ao();
          return;
        }
        catch (Exception localException)
        {
          while (true)
            int i = 0;
        }
      }
    }

    public void au()
    {
      this.c7.clear();
      this.c7.add(new BasicNameValuePair("qt", "conf"));
      this.c7.add(new BasicNameValuePair("req", this.d9));
      this.c5 = d.ak;
    }

    public void jdMethod_int(boolean paramBoolean)
    {
      if ((paramBoolean) && (this.c6 != null));
      while (true)
      {
        try
        {
          JSONObject localJSONObject1 = new JSONObject(EntityUtils.toString(this.c6, "utf-8"));
          String str = "1";
          long l = 0L;
          if (!localJSONObject1.has("ofl"))
            continue;
          l = localJSONObject1.getLong("ofl");
          if (!localJSONObject1.has("ver"))
            continue;
          str = localJSONObject1.getString("ver");
          if ((l & 1L) != 1L)
            continue;
          e.jdMethod_if(e.this, true);
          if ((l & 0x2) != 2L)
            continue;
          e.jdMethod_do(e.this, true);
          if ((l & 0x4) != 4L)
            continue;
          e.jdMethod_for(e.this, true);
          if ((l & 0x8) != 8L)
            continue;
          e.jdMethod_int(e.this, true);
          if ((0x10 & l) != 16L)
            continue;
          e.jdMethod_new(e.this, true);
          if ((l & 0x20) != 32L)
            continue;
          e.jdMethod_try(e.this, true);
          JSONObject localJSONObject2 = new JSONObject();
          if (!localJSONObject1.has("cplist"))
            continue;
          e.jdMethod_if(e.this, localJSONObject1.getString("cplist").split(";"));
          localJSONObject2.put("cplist", localJSONObject1.getString("cplist"));
          if (!localJSONObject1.has("bklist"))
            continue;
          String[] arrayOfString = localJSONObject1.getString("bklist").split(";");
          e.this.jdMethod_int(arrayOfString);
          if (!localJSONObject1.has("para"))
            continue;
          JSONObject localJSONObject5 = localJSONObject1.getJSONObject("para");
          if (!localJSONObject5.has("rgcgp"))
            continue;
          e.jdMethod_for(e.this, localJSONObject5.getInt("rgcgp"));
          if (!localJSONObject5.has("addrup"))
            continue;
          e.jdMethod_if(e.this, localJSONObject5.getInt("addrup"));
          if (!localJSONObject5.has("poiup"))
            continue;
          e.jdMethod_do(e.this, localJSONObject5.getInt("poiup"));
          if (!localJSONObject5.has("oflp"))
            continue;
          JSONObject localJSONObject7 = localJSONObject5.getJSONObject("oflp");
          if (!localJSONObject7.has("0"))
            continue;
          e.jdMethod_new(e.this, localJSONObject7.getDouble("0"));
          if (!localJSONObject7.has("1"))
            continue;
          e.jdMethod_if(e.this, localJSONObject7.getDouble("1"));
          if (!localJSONObject7.has("2"))
            continue;
          e.jdMethod_do(e.this, localJSONObject7.getDouble("2"));
          if (!localJSONObject7.has("3"))
            continue;
          e.jdMethod_for(e.this, localJSONObject7.getDouble("3"));
          if (!localJSONObject7.has("4"))
            continue;
          e.jdMethod_int(e.this, localJSONObject7.getDouble("4"));
          if (!localJSONObject5.has("onlt"))
            continue;
          JSONObject localJSONObject6 = localJSONObject5.getJSONObject("onlt");
          if (!localJSONObject6.has("0"))
            continue;
          e.jdMethod_for(e.this, localJSONObject6.getLong("0"));
          if (!localJSONObject6.has("1"))
            continue;
          e.jdMethod_int(e.this, localJSONObject6.getLong("1"));
          if (!localJSONObject6.has("2"))
            continue;
          e.jdMethod_if(e.this, localJSONObject6.getLong("2"));
          if (!localJSONObject6.has("3"))
            continue;
          e.jdMethod_new(e.this, localJSONObject6.getLong("3"));
          if (!localJSONObject6.has("4"))
            continue;
          e.jdMethod_do(e.this, localJSONObject6.getLong("4"));
          if (!localJSONObject5.has("minapn"))
            continue;
          e.jdMethod_int(e.this, localJSONObject5.getInt("minapn"));
          localJSONObject2.put("ol", e.h(e.this));
          localJSONObject2.put("fl", e.jdMethod_char(e.this));
          localJSONObject2.put("on", e.jdMethod_for(e.this));
          localJSONObject2.put("wn", e.j(e.this));
          localJSONObject2.put("oc", e.d(e.this));
          this.dM = System.currentTimeMillis();
          localJSONObject2.put("t", this.dM);
          localJSONObject2.put("ver", str);
          localJSONObject2.put("rgcon", e.jdMethod_byte(e.this));
          localJSONObject2.put("rgcgp", e.k(e.this));
          JSONObject localJSONObject3 = new JSONObject();
          localJSONObject3.put("0", e.jdMethod_if(e.this));
          localJSONObject3.put("1", e.i(e.this));
          localJSONObject3.put("2", e.jdMethod_goto(e.this));
          localJSONObject3.put("3", e.jdMethod_int(e.this));
          localJSONObject3.put("4", e.l(e.this));
          localJSONObject2.put("oflp", localJSONObject3);
          JSONObject localJSONObject4 = new JSONObject();
          localJSONObject4.put("0", e.jdMethod_long(e.this));
          localJSONObject4.put("1", e.jdMethod_new(e.this));
          localJSONObject4.put("2", e.m(e.this));
          localJSONObject4.put("3", e.e(e.this));
          localJSONObject4.put("4", e.jdMethod_case(e.this));
          localJSONObject2.put("onlt", localJSONObject4);
          localJSONObject2.put("addrup", e.jdMethod_void(e.this));
          localJSONObject2.put("poiup", e.jdMethod_try(e.this));
          localJSONObject2.put("minapn", e.jdMethod_do(e.this));
          File localFile = new File(e.jdMethod_else(e.this).d(), "ofl.config");
          if (localFile.exists())
            continue;
          localFile.createNewFile();
          FileWriter localFileWriter = new FileWriter(localFile);
          localFileWriter.write(localJSONObject2.toString());
          localFileWriter.close();
          this.dJ = false;
          return;
        }
        catch (Exception localException)
        {
          this.dN = (1 + this.dN);
          this.dU = System.currentTimeMillis();
          continue;
        }
        this.dN = (1 + this.dN);
        this.dU = System.currentTimeMillis();
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.baidu.location.c.e
 * JD-Core Version:    0.6.0
 */