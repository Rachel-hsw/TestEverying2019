package com.xiaomi.push.a;

import android.annotation.SuppressLint;
import android.content.Context;
import com.xiaomi.a.a.c.c;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class a
{
  private static String b = "/MiPushLog";

  @SuppressLint({"SimpleDateFormat"})
  private final SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  private String c;
  private String d;
  private boolean e;
  private int f;
  private int g = 2097152;
  private ArrayList<File> h = new ArrayList();

  private void a(BufferedReader paramBufferedReader, BufferedWriter paramBufferedWriter, Pattern paramPattern)
  {
    char[] arrayOfChar = new char[4096];
    int i = paramBufferedReader.read(arrayOfChar);
    int j = 0;
    int k;
    int m;
    int n;
    if ((i != -1) && (j != 1))
    {
      String str1 = new String(arrayOfChar, 0, i);
      Matcher localMatcher = paramPattern.matcher(str1);
      k = 0;
      m = 0;
      if ((k >= i) || (!localMatcher.find(k)))
        break label267;
      n = localMatcher.start();
      String str2 = str1.substring(n, n + this.c.length());
      if (!this.e)
        if (str2.compareTo(this.c) >= 0)
        {
          this.e = true;
          m = n;
        }
      do
      {
        int i4 = str1.indexOf('\n', n);
        if (i4 == -1)
          break label212;
        k = n + i4;
        break;
      }
      while (str2.compareTo(this.d) <= 0);
    }
    for (int i1 = 1; ; i1 = j)
    {
      if (this.e)
      {
        int i3 = n - m;
        this.f = (i3 + this.f);
        if (i1 != 0)
          paramBufferedWriter.write(arrayOfChar, m, i3);
        label212: 
        do
        {
          return;
          k = n + this.c.length();
          break;
          paramBufferedWriter.write(arrayOfChar, m, i3);
        }
        while (this.f > this.g);
      }
      int i2 = paramBufferedReader.read(arrayOfChar);
      j = i1;
      i = i2;
      break;
      label267: n = i;
    }
  }

  // ERROR //
  private void b(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 110
    //   4: invokestatic 114	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   7: astore_3
    //   8: new 100	java/io/BufferedWriter
    //   11: dup
    //   12: new 116	java/io/OutputStreamWriter
    //   15: dup
    //   16: new 118	java/io/FileOutputStream
    //   19: dup
    //   20: aload_1
    //   21: invokespecial 120	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   24: invokespecial 123	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   27: invokespecial 126	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   30: astore 4
    //   32: new 128	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   39: astore 5
    //   41: aload 5
    //   43: ldc 131
    //   45: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: getstatic 140	android/os/Build:MODEL	Ljava/lang/String;
    //   51: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload 5
    //   57: ldc 142
    //   59: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: getstatic 147	android/os/Build$VERSION:INCREMENTAL	Ljava/lang/String;
    //   65: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload 5
    //   71: ldc 149
    //   73: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: invokestatic 154	com/xiaomi/d/e/h:b	()Ljava/lang/String;
    //   79: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: aload 5
    //   85: ldc 156
    //   87: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: invokestatic 162	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   93: invokevirtual 165	java/util/Locale:toString	()Ljava/lang/String;
    //   96: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload 5
    //   102: ldc 167
    //   104: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: bipush 7
    //   109: invokevirtual 170	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload 5
    //   115: ldc 172
    //   117: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: aload 4
    //   123: aload 5
    //   125: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokevirtual 175	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   131: aload_0
    //   132: iconst_0
    //   133: putfield 98	com/xiaomi/push/a/a:f	I
    //   136: aload_0
    //   137: getfield 47	com/xiaomi/push/a/a:h	Ljava/util/ArrayList;
    //   140: invokevirtual 179	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   143: astore 15
    //   145: aconst_null
    //   146: astore 16
    //   148: aload 15
    //   150: invokeinterface 185 1 0
    //   155: ifeq +53 -> 208
    //   158: new 50	java/io/BufferedReader
    //   161: dup
    //   162: new 187	java/io/InputStreamReader
    //   165: dup
    //   166: new 189	java/io/FileInputStream
    //   169: dup
    //   170: aload 15
    //   172: invokeinterface 193 1 0
    //   177: checkcast 195	java/io/File
    //   180: invokespecial 196	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   183: invokespecial 199	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   186: invokespecial 202	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   189: astore_2
    //   190: aload_0
    //   191: aload_2
    //   192: aload 4
    //   194: aload_3
    //   195: invokespecial 204	com/xiaomi/push/a/a:a	(Ljava/io/BufferedReader;Ljava/io/BufferedWriter;Ljava/util/regex/Pattern;)V
    //   198: aload_2
    //   199: invokevirtual 207	java/io/BufferedReader:close	()V
    //   202: aload_2
    //   203: astore 16
    //   205: goto -57 -> 148
    //   208: aload 4
    //   210: invokestatic 211	com/xiaomi/a/a/b/a:a	(Ljava/io/Writer;)V
    //   213: aload 16
    //   215: invokestatic 213	com/xiaomi/a/a/b/a:a	(Ljava/io/Reader;)V
    //   218: return
    //   219: astore 6
    //   221: aconst_null
    //   222: astore 4
    //   224: new 128	java/lang/StringBuilder
    //   227: dup
    //   228: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   231: ldc 215
    //   233: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: aload 6
    //   238: invokevirtual 218	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   241: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: invokestatic 222	com/xiaomi/a/a/c/c:c	(Ljava/lang/String;)V
    //   250: aload 4
    //   252: invokestatic 211	com/xiaomi/a/a/b/a:a	(Ljava/io/Writer;)V
    //   255: aload_2
    //   256: invokestatic 213	com/xiaomi/a/a/b/a:a	(Ljava/io/Reader;)V
    //   259: return
    //   260: astore 8
    //   262: aconst_null
    //   263: astore 4
    //   265: new 128	java/lang/StringBuilder
    //   268: dup
    //   269: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   272: ldc 215
    //   274: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: aload 8
    //   279: invokevirtual 223	java/io/IOException:getMessage	()Ljava/lang/String;
    //   282: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   288: invokestatic 222	com/xiaomi/a/a/c/c:c	(Ljava/lang/String;)V
    //   291: aload 4
    //   293: invokestatic 211	com/xiaomi/a/a/b/a:a	(Ljava/io/Writer;)V
    //   296: aload_2
    //   297: invokestatic 213	com/xiaomi/a/a/b/a:a	(Ljava/io/Reader;)V
    //   300: return
    //   301: astore 7
    //   303: aconst_null
    //   304: astore 4
    //   306: aload 4
    //   308: invokestatic 211	com/xiaomi/a/a/b/a:a	(Ljava/io/Writer;)V
    //   311: aload_2
    //   312: invokestatic 213	com/xiaomi/a/a/b/a:a	(Ljava/io/Reader;)V
    //   315: aload 7
    //   317: athrow
    //   318: astore 7
    //   320: goto -14 -> 306
    //   323: astore 7
    //   325: aload 16
    //   327: astore_2
    //   328: goto -22 -> 306
    //   331: astore 8
    //   333: goto -68 -> 265
    //   336: astore 8
    //   338: aload 16
    //   340: astore_2
    //   341: goto -76 -> 265
    //   344: astore 6
    //   346: goto -122 -> 224
    //   349: astore 6
    //   351: aload 16
    //   353: astore_2
    //   354: goto -130 -> 224
    //
    // Exception table:
    //   from	to	target	type
    //   8	32	219	java/io/FileNotFoundException
    //   8	32	260	java/io/IOException
    //   8	32	301	finally
    //   32	145	318	finally
    //   190	202	318	finally
    //   224	250	318	finally
    //   265	291	318	finally
    //   148	190	323	finally
    //   32	145	331	java/io/IOException
    //   190	202	331	java/io/IOException
    //   148	190	336	java/io/IOException
    //   32	145	344	java/io/FileNotFoundException
    //   190	202	344	java/io/FileNotFoundException
    //   148	190	349	java/io/FileNotFoundException
  }

  a a(File paramFile)
  {
    if (paramFile.exists())
      this.h.add(paramFile);
    return this;
  }

  a a(Date paramDate1, Date paramDate2)
  {
    if (paramDate1.after(paramDate2))
    {
      this.c = this.a.format(paramDate2);
      this.d = this.a.format(paramDate1);
      return this;
    }
    this.c = this.a.format(paramDate1);
    this.d = this.a.format(paramDate2);
    return this;
  }

  File a(Context paramContext, Date paramDate1, Date paramDate2, File paramFile)
  {
    File localFile1;
    File localFile2;
    if ("com.xiaomi.xmsf".equalsIgnoreCase(paramContext.getPackageName()))
    {
      localFile1 = paramContext.getFilesDir();
      a(new File(localFile1, "xmsf.log.1"));
      a(new File(localFile1, "xmsf.log"));
      if (localFile1.isDirectory())
        break label136;
      localFile2 = null;
    }
    label136: 
    do
    {
      return localFile2;
      localFile1 = new File(paramContext.getExternalFilesDir(null) + b);
      a(new File(localFile1, "log0.txt"));
      a(new File(localFile1, "log1.txt"));
      break;
      localFile2 = new File(paramFile, paramDate1.getTime() + "-" + paramDate2.getTime() + ".zip");
      if (localFile2.exists())
        return null;
      a(paramDate1, paramDate2);
      long l1 = System.currentTimeMillis();
      File localFile3 = new File(paramFile, "log.txt");
      b(localFile3);
      c.c("LOG: filter cost = " + (System.currentTimeMillis() - l1));
      if (!localFile3.exists())
        break label315;
      long l2 = System.currentTimeMillis();
      com.xiaomi.a.a.b.a.a(localFile2, localFile3);
      c.c("LOG: zip cost = " + (System.currentTimeMillis() - l2));
      localFile3.delete();
    }
    while (localFile2.exists());
    label315: return null;
  }

  void a(int paramInt)
  {
    if (paramInt != 0)
      this.g = paramInt;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.a.a
 * JD-Core Version:    0.6.0
 */