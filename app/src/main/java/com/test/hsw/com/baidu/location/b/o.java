package com.baidu.location.b;

import com.baidu.location.Jni;
import java.io.File;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class o
  implements f
{
  private static final String e0;
  private static o e1 = null;
  private static final int e3 = 128;
  private static String e4 = "LogSDK";
  private static int e5 = 0;
  private static final int e6 = 32;
  private static int e9 = 0;
  private static final int fa = 1040;
  private static final String fc;
  private static final int fd = 1000;
  public static final String fe;
  private l e2 = null;
  private long e7 = 0L;
  private SimpleDateFormat e8 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  private a fb = null;

  static
  {
    e5 = 1024;
    e0 = e.int + "/llg.dat";
    fc = e.int + "/ller.dat";
    fe = e.int + "/llin.dat";
  }

  private o()
  {
    if (this.e2 == null)
      this.e2 = new l();
  }

  public static o aX()
  {
    if (e1 == null)
      monitorenter;
    try
    {
      if (e1 == null)
        e1 = new o();
      return e1;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  // ERROR //
  public static void jdMethod_for(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 103	java/io/File
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 104	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore_2
    //   12: aload_2
    //   13: invokevirtual 108	java/io/File:exists	()Z
    //   16: ifne +7 -> 23
    //   19: aload_0
    //   20: invokestatic 111	com/baidu/location/b/o:i	(Ljava/lang/String;)V
    //   23: new 113	java/io/RandomAccessFile
    //   26: dup
    //   27: aload_2
    //   28: ldc 115
    //   30: invokespecial 118	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   33: astore 4
    //   35: aload 4
    //   37: ldc2_w 119
    //   40: invokevirtual 124	java/io/RandomAccessFile:seek	(J)V
    //   43: aload 4
    //   45: invokevirtual 128	java/io/RandomAccessFile:readInt	()I
    //   48: istore 6
    //   50: aload 4
    //   52: invokevirtual 128	java/io/RandomAccessFile:readInt	()I
    //   55: istore 7
    //   57: aload 4
    //   59: invokevirtual 128	java/io/RandomAccessFile:readInt	()I
    //   62: istore 8
    //   64: aload 4
    //   66: invokevirtual 128	java/io/RandomAccessFile:readInt	()I
    //   69: istore 9
    //   71: aload 4
    //   73: invokevirtual 128	java/io/RandomAccessFile:readInt	()I
    //   76: istore 10
    //   78: iload 8
    //   80: iload 6
    //   82: if_icmpge +104 -> 186
    //   85: aload 4
    //   87: sipush 128
    //   90: iload 7
    //   92: iload 8
    //   94: imul
    //   95: iadd
    //   96: i2l
    //   97: invokevirtual 124	java/io/RandomAccessFile:seek	(J)V
    //   100: new 47	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   107: aload_1
    //   108: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: iconst_0
    //   112: invokevirtual 131	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   115: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokevirtual 137	java/lang/String:getBytes	()[B
    //   121: astore 11
    //   123: aload 4
    //   125: aload 11
    //   127: arraylength
    //   128: invokevirtual 141	java/io/RandomAccessFile:writeInt	(I)V
    //   131: aload 4
    //   133: aload 11
    //   135: iconst_0
    //   136: aload 11
    //   138: arraylength
    //   139: invokevirtual 145	java/io/RandomAccessFile:write	([BII)V
    //   142: iload 8
    //   144: iconst_1
    //   145: iadd
    //   146: istore 12
    //   148: aload 4
    //   150: ldc2_w 146
    //   153: invokevirtual 124	java/io/RandomAccessFile:seek	(J)V
    //   156: aload 4
    //   158: iload 12
    //   160: invokevirtual 141	java/io/RandomAccessFile:writeInt	(I)V
    //   163: aload 4
    //   165: iload 9
    //   167: invokevirtual 141	java/io/RandomAccessFile:writeInt	(I)V
    //   170: aload 4
    //   172: iload 10
    //   174: invokevirtual 141	java/io/RandomAccessFile:writeInt	(I)V
    //   177: aload 4
    //   179: invokevirtual 150	java/io/RandomAccessFile:close	()V
    //   182: ldc 2
    //   184: monitorexit
    //   185: return
    //   186: sipush 128
    //   189: iload 9
    //   191: iload 7
    //   193: imul
    //   194: iadd
    //   195: i2l
    //   196: lstore 13
    //   198: aload 4
    //   200: lload 13
    //   202: invokevirtual 124	java/io/RandomAccessFile:seek	(J)V
    //   205: new 47	java/lang/StringBuilder
    //   208: dup
    //   209: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   212: aload_1
    //   213: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: iconst_0
    //   217: invokevirtual 131	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   220: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokevirtual 137	java/lang/String:getBytes	()[B
    //   226: astore 15
    //   228: aload 4
    //   230: aload 15
    //   232: arraylength
    //   233: invokevirtual 141	java/io/RandomAccessFile:writeInt	(I)V
    //   236: aload 4
    //   238: aload 15
    //   240: iconst_0
    //   241: aload 15
    //   243: arraylength
    //   244: invokevirtual 145	java/io/RandomAccessFile:write	([BII)V
    //   247: iinc 9 1
    //   250: iload 9
    //   252: iload 8
    //   254: if_icmple +24 -> 278
    //   257: iload 8
    //   259: istore 12
    //   261: iconst_0
    //   262: istore 9
    //   264: goto -116 -> 148
    //   267: astore_3
    //   268: ldc 2
    //   270: monitorexit
    //   271: aload_3
    //   272: athrow
    //   273: astore 5
    //   275: goto -93 -> 182
    //   278: iload 8
    //   280: istore 12
    //   282: goto -134 -> 148
    //
    // Exception table:
    //   from	to	target	type
    //   3	23	267	finally
    //   23	78	267	finally
    //   85	142	267	finally
    //   148	182	267	finally
    //   198	247	267	finally
    //   23	78	273	java/lang/Exception
    //   85	142	273	java/lang/Exception
    //   148	182	273	java/lang/Exception
    //   198	247	273	java/lang/Exception
  }

  private static void i(String paramString)
  {
    try
    {
      File localFile1 = new File(paramString);
      if (!localFile1.exists())
      {
        File localFile2 = new File(e.int);
        if (!localFile2.exists())
          localFile2.mkdirs();
        if (!localFile1.createNewFile())
          localFile1 = null;
        RandomAccessFile localRandomAccessFile = new RandomAccessFile(localFile1, "rw");
        localRandomAccessFile.seek(0L);
        localRandomAccessFile.writeInt(32);
        localRandomAccessFile.writeInt(1000);
        localRandomAccessFile.writeInt(1040);
        localRandomAccessFile.writeInt(0);
        localRandomAccessFile.writeInt(0);
        localRandomAccessFile.writeInt(0);
        localRandomAccessFile.close();
      }
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public static boolean jdMethod_if(String paramString, List paramList)
  {
    File localFile = new File(paramString);
    if (!localFile.exists())
      return false;
    while (true)
    {
      int i1;
      int i2;
      try
      {
        RandomAccessFile localRandomAccessFile = new RandomAccessFile(localFile, "rw");
        localRandomAccessFile.seek(8L);
        int i = localRandomAccessFile.readInt();
        int j = localRandomAccessFile.readInt();
        int k = localRandomAccessFile.readInt();
        byte[] arrayOfByte = new byte[e5];
        int m = e9;
        int n = m + 1;
        i1 = j;
        i2 = n;
        int i3 = 0;
        if ((i2 <= 0) || (i1 <= 0))
          continue;
        if (i1 >= k)
          continue;
        k = 0;
        long l = 128 + i * (i1 - 1);
        try
        {
          localRandomAccessFile.seek(l);
          int i4 = localRandomAccessFile.readInt();
          if ((i4 > 0) && (i4 < i))
          {
            localRandomAccessFile.read(arrayOfByte, 0, i4);
            if (arrayOfByte[(i4 - 1)] == 0)
            {
              paramList.add(0, new String(arrayOfByte, 0, i4 - 1));
              i3 = 1;
              break label223;
              localRandomAccessFile.seek(12L);
              localRandomAccessFile.writeInt(i1);
              localRandomAccessFile.writeInt(k);
              localRandomAccessFile.close();
              return i3;
            }
          }
        }
        catch (Exception localException2)
        {
          return i3;
        }
      }
      catch (Exception localException1)
      {
        return false;
      }
      label223: i2--;
      i1--;
    }
  }

  public l aU()
  {
    return this.e2;
  }

  public void aV()
  {
    if (this.fb == null)
      this.fb = new a();
    if (System.currentTimeMillis() - this.e7 < 3600000L);
    while (true)
    {
      return;
      if (this.fb.ay())
        continue;
      try
      {
        ArrayList localArrayList = new ArrayList();
        jdMethod_if(fc, localArrayList);
        int i;
        int j;
        if (localArrayList.size() > 0)
        {
          i = 0;
          j = 1;
        }
        while (true)
        {
          JSONArray localJSONArray = new JSONArray();
          JSONObject localJSONObject = new JSONObject();
          if (localArrayList.size() <= 0)
            break;
          int k = localArrayList.size();
          int m = 0;
          while (true)
            if (m < k)
            {
              localJSONArray.put((String)localArrayList.get(m));
              m++;
              continue;
              jdMethod_if(e0, localArrayList);
              if (localArrayList.size() != 0)
                break label237;
              jdMethod_if(fe, localArrayList);
              i = 1;
              j = 0;
              break;
            }
          if (j != 0)
            localJSONObject.put("locpt", localJSONArray);
          while (true)
          {
            this.fb.jdMethod_goto(localJSONObject.toString());
            return;
            if (i != 0)
            {
              localJSONObject.put("locup", localJSONArray);
              continue;
            }
            localJSONObject.put("loctc", localJSONArray);
          }
          label237: i = 0;
          j = 0;
        }
      }
      catch (Exception localException)
      {
      }
    }
  }

  public void aW()
  {
    if (this.e2 != null)
    {
      String str = Jni.H(this.e2.ak());
      jdMethod_for(e0, str);
      this.e2.aj();
    }
  }

  public void jdMethod_if(l paraml)
  {
    if (paraml != null)
    {
      String str = Jni.H(paraml.ak());
      jdMethod_for(e0, str);
    }
  }

  public void j(String paramString)
  {
    if (paramString != null);
    try
    {
      StringBuffer localStringBuffer = new StringBuffer();
      Date localDate = new Date();
      String str1 = this.e8.format(localDate);
      localStringBuffer.append("&time=");
      localStringBuffer.append(str1);
      localStringBuffer.append("&err=");
      localStringBuffer.append(paramString);
      localStringBuffer.append(c.N().jdMethod_do(false));
      localStringBuffer.append(com.baidu.location.e.c.bp().bs());
      String str2 = Jni.H(localStringBuffer.toString());
      jdMethod_for(fc, str2);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private class a extends m
  {
    private String dk = null;
    private boolean dl = false;

    a()
    {
      this.c7 = new ArrayList();
    }

    public void au()
    {
      this.c7.clear();
      this.c7.add(new BasicNameValuePair("qt", "stat"));
      this.c7.add(new BasicNameValuePair("req", this.dk));
      this.c5 = "http://loc.map.baidu.com/statloc";
    }

    public boolean ay()
    {
      return this.dl;
    }

    public void jdMethod_goto(String paramString)
    {
      this.dk = paramString;
      if (this.dk != null)
      {
        ao();
        this.dl = true;
      }
    }

    public void jdMethod_int(boolean paramBoolean)
    {
      this.dl = false;
      if ((paramBoolean) && (this.c6 != null));
      try
      {
        EntityUtils.toString(this.c6, "utf-8");
        return;
        o.jdMethod_if(o.this, System.currentTimeMillis());
        return;
      }
      catch (Exception localException)
      {
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.baidu.location.b.o
 * JD-Core Version:    0.6.0
 */