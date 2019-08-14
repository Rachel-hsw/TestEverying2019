package com.android.http;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;

public class q
{
  private static String c = "UTF-8";
  private static final char[] d = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
  protected ConcurrentHashMap<String, String> a;
  protected ConcurrentHashMap<String, a> b;

  public q()
  {
    d();
  }

  public q(String paramString1, String paramString2)
  {
    d();
    a(paramString1, paramString2);
  }

  private void d()
  {
    this.a = new ConcurrentHashMap();
    this.b = new ConcurrentHashMap();
  }

  public HttpEntity a()
  {
    if (!this.b.isEmpty())
    {
      b localb = new b();
      Iterator localIterator1 = this.a.entrySet().iterator();
      int i;
      Iterator localIterator2;
      int j;
      while (true)
      {
        if (!localIterator1.hasNext())
        {
          i = -1 + this.b.entrySet().size();
          localIterator2 = this.b.entrySet().iterator();
          j = 0;
          if (localIterator2.hasNext())
            break;
          return localb;
        }
        Map.Entry localEntry1 = (Map.Entry)localIterator1.next();
        localb.a((String)localEntry1.getKey(), (String)localEntry1.getValue());
      }
      Map.Entry localEntry2 = (Map.Entry)localIterator2.next();
      a locala = (a)localEntry2.getValue();
      boolean bool;
      if (locala.a != null)
      {
        if (j != i)
          break label208;
        bool = true;
        label163: if (locala.c == null)
          break label214;
        localb.a((String)localEntry2.getKey(), locala.a(), locala.a, locala.c, bool);
      }
      while (true)
      {
        j++;
        break;
        label208: bool = false;
        break label163;
        label214: localb.a((String)localEntry2.getKey(), locala.a(), locala.a, bool);
      }
    }
    try
    {
      UrlEncodedFormEntity localUrlEncodedFormEntity = new UrlEncodedFormEntity(b(), c);
      return localUrlEncodedFormEntity;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
    return null;
  }

  public void a(String paramString, File paramFile)
  {
    try
    {
      a(paramString, new FileInputStream(paramFile), paramFile.getName());
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localFileNotFoundException.printStackTrace();
    }
  }

  public void a(String paramString1, InputStream paramInputStream, String paramString2)
  {
    a(paramString1, paramInputStream, paramString2, null);
  }

  public void a(String paramString1, InputStream paramInputStream, String paramString2, String paramString3)
  {
    if ((paramString1 != null) && (paramInputStream != null))
      this.b.put(paramString1, new a(paramInputStream, paramString2, paramString3));
  }

  public void a(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null))
      this.a.put(paramString1, paramString2);
  }

  protected List<BasicNameValuePair> b()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.a.entrySet().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return localArrayList;
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localArrayList.add(new BasicNameValuePair((String)localEntry.getKey(), (String)localEntry.getValue()));
    }
  }

  private static class a
  {
    public InputStream a;
    public String b;
    public String c;

    public a(InputStream paramInputStream, String paramString1, String paramString2)
    {
      this.a = paramInputStream;
      this.b = paramString1;
      this.c = paramString2;
    }

    public String a()
    {
      if (this.b != null)
        return this.b;
      return "nofilename";
    }
  }

  class b
    implements HttpEntity
  {
    ByteArrayOutputStream a = new ByteArrayOutputStream();
    boolean b = false;
    boolean c = false;
    private String e = null;

    public b()
    {
      StringBuffer localStringBuffer = new StringBuffer();
      Random localRandom = new Random();
      while (true)
      {
        if (i >= 30)
        {
          this.e = localStringBuffer.toString();
          return;
        }
        localStringBuffer.append(q.c()[localRandom.nextInt(q.c().length)]);
        i++;
      }
    }

    public void a()
    {
      if (!this.c);
      try
      {
        this.a.write(("--" + this.e + "\r\n").getBytes());
        this.c = true;
        return;
      }
      catch (IOException localIOException)
      {
        while (true)
          localIOException.printStackTrace();
      }
    }

    public void a(String paramString, File paramFile, boolean paramBoolean)
    {
      try
      {
        a(paramString, paramFile.getName(), new FileInputStream(paramFile), paramBoolean);
        return;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        localFileNotFoundException.printStackTrace();
      }
    }

    public void a(String paramString1, String paramString2)
    {
      a();
      try
      {
        this.a.write(("Content-Disposition: form-data; name=\"" + paramString1 + "\"\r\n\r\n").getBytes());
        this.a.write(paramString2.getBytes());
        this.a.write(("\r\n--" + this.e + "\r\n").getBytes());
        return;
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
    }

    // ERROR //
    public void a(String paramString1, String paramString2, InputStream paramInputStream, String paramString3, boolean paramBoolean)
    {
      // Byte code:
      //   0: aload_0
      //   1: invokevirtual 104	com/android/http/q$b:a	()V
      //   4: new 60	java/lang/StringBuilder
      //   7: dup
      //   8: ldc 113
      //   10: invokespecial 65	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   13: aload 4
      //   15: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   18: ldc 70
      //   20: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   23: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   26: astore 10
      //   28: aload_0
      //   29: getfield 29	com/android/http/q$b:a	Ljava/io/ByteArrayOutputStream;
      //   32: new 60	java/lang/StringBuilder
      //   35: dup
      //   36: ldc 106
      //   38: invokespecial 65	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   41: aload_1
      //   42: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   45: ldc 115
      //   47: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   50: aload_2
      //   51: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   54: ldc 117
      //   56: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   59: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   62: invokevirtual 77	java/lang/String:getBytes	()[B
      //   65: invokevirtual 81	java/io/ByteArrayOutputStream:write	([B)V
      //   68: aload_0
      //   69: getfield 29	com/android/http/q$b:a	Ljava/io/ByteArrayOutputStream;
      //   72: aload 10
      //   74: invokevirtual 77	java/lang/String:getBytes	()[B
      //   77: invokevirtual 81	java/io/ByteArrayOutputStream:write	([B)V
      //   80: aload_0
      //   81: getfield 29	com/android/http/q$b:a	Ljava/io/ByteArrayOutputStream;
      //   84: ldc 119
      //   86: invokevirtual 77	java/lang/String:getBytes	()[B
      //   89: invokevirtual 81	java/io/ByteArrayOutputStream:write	([B)V
      //   92: sipush 4096
      //   95: newarray byte
      //   97: astore 11
      //   99: aload_3
      //   100: aload 11
      //   102: invokevirtual 125	java/io/InputStream:read	([B)I
      //   105: istore 12
      //   107: iload 12
      //   109: iconst_m1
      //   110: if_icmpne +54 -> 164
      //   113: iload 5
      //   115: ifne +84 -> 199
      //   118: aload_0
      //   119: getfield 29	com/android/http/q$b:a	Ljava/io/ByteArrayOutputStream;
      //   122: new 60	java/lang/StringBuilder
      //   125: dup
      //   126: ldc 110
      //   128: invokespecial 65	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   131: aload_0
      //   132: getfield 24	com/android/http/q$b:e	Ljava/lang/String;
      //   135: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   138: ldc 70
      //   140: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   143: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   146: invokevirtual 77	java/lang/String:getBytes	()[B
      //   149: invokevirtual 81	java/io/ByteArrayOutputStream:write	([B)V
      //   152: aload_0
      //   153: getfield 29	com/android/http/q$b:a	Ljava/io/ByteArrayOutputStream;
      //   156: invokevirtual 128	java/io/ByteArrayOutputStream:flush	()V
      //   159: aload_3
      //   160: invokevirtual 131	java/io/InputStream:close	()V
      //   163: return
      //   164: aload_0
      //   165: getfield 29	com/android/http/q$b:a	Ljava/io/ByteArrayOutputStream;
      //   168: aload 11
      //   170: iconst_0
      //   171: iload 12
      //   173: invokevirtual 134	java/io/ByteArrayOutputStream:write	([BII)V
      //   176: goto -77 -> 99
      //   179: astore 8
      //   181: aload 8
      //   183: invokevirtual 84	java/io/IOException:printStackTrace	()V
      //   186: aload_3
      //   187: invokevirtual 131	java/io/InputStream:close	()V
      //   190: return
      //   191: astore 9
      //   193: aload 9
      //   195: invokevirtual 84	java/io/IOException:printStackTrace	()V
      //   198: return
      //   199: aload_0
      //   200: invokevirtual 136	com/android/http/q$b:b	()V
      //   203: goto -51 -> 152
      //   206: astore 6
      //   208: aload_3
      //   209: invokevirtual 131	java/io/InputStream:close	()V
      //   212: aload 6
      //   214: athrow
      //   215: astore 7
      //   217: aload 7
      //   219: invokevirtual 84	java/io/IOException:printStackTrace	()V
      //   222: goto -10 -> 212
      //   225: astore 13
      //   227: aload 13
      //   229: invokevirtual 84	java/io/IOException:printStackTrace	()V
      //   232: return
      //
      // Exception table:
      //   from	to	target	type
      //   4	99	179	java/io/IOException
      //   99	107	179	java/io/IOException
      //   118	152	179	java/io/IOException
      //   152	159	179	java/io/IOException
      //   164	176	179	java/io/IOException
      //   199	203	179	java/io/IOException
      //   186	190	191	java/io/IOException
      //   4	99	206	finally
      //   99	107	206	finally
      //   118	152	206	finally
      //   152	159	206	finally
      //   164	176	206	finally
      //   181	186	206	finally
      //   199	203	206	finally
      //   208	212	215	java/io/IOException
      //   159	163	225	java/io/IOException
    }

    public void a(String paramString1, String paramString2, InputStream paramInputStream, boolean paramBoolean)
    {
      a(paramString1, paramString2, paramInputStream, "application/octet-stream", paramBoolean);
    }

    public void b()
    {
      if (this.b)
        return;
      try
      {
        this.a.write(("\r\n--" + this.e + "--\r\n").getBytes());
        this.b = true;
        return;
      }
      catch (IOException localIOException)
      {
        while (true)
          localIOException.printStackTrace();
      }
    }

    public void consumeContent()
      throws IOException, UnsupportedOperationException
    {
      if (isStreaming())
        throw new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
    }

    public InputStream getContent()
      throws IOException, UnsupportedOperationException
    {
      return new ByteArrayInputStream(this.a.toByteArray());
    }

    public Header getContentEncoding()
    {
      return null;
    }

    public long getContentLength()
    {
      b();
      return this.a.toByteArray().length;
    }

    public Header getContentType()
    {
      return new BasicHeader("Content-Type", "multipart/form-data; boundary=" + this.e);
    }

    public boolean isChunked()
    {
      return false;
    }

    public boolean isRepeatable()
    {
      return false;
    }

    public boolean isStreaming()
    {
      return false;
    }

    public void writeTo(OutputStream paramOutputStream)
      throws IOException
    {
      paramOutputStream.write(this.a.toByteArray());
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.android.http.q
 * JD-Core Version:    0.6.0
 */