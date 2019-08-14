package com.baidu.location.e;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import com.baidu.location.Jni;
import com.baidu.location.b.c;
import com.baidu.location.b.e;
import com.baidu.location.b.m;
import com.baidu.location.b.n;
import com.baidu.location.f;
import com.baidu.location.h.l;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class d extends m
{
  private static d ey = null;
  Handler eA = null;
  String eB = null;
  String eC = null;
  String eD = null;
  String eE = null;
  int ez = 1;

  private boolean aL()
  {
    if (this.eC == null);
    do
      return true;
    while (new File(com.baidu.location.b.k.ai() + File.separator + this.eC).exists());
    return jdMethod_do("http://" + this.eE + "/" + this.eC, this.eC);
  }

  private void aM()
  {
    if (this.eD == null);
    File localFile1;
    String str;
    do
    {
      do
      {
        return;
        localFile1 = new File(com.baidu.location.b.k.ai() + File.separator + this.eD);
      }
      while ((localFile1.exists()) || (!jdMethod_do("http://" + this.eE + "/" + this.eD, this.eD)));
      str = com.baidu.location.b.k.jdMethod_if(localFile1);
    }
    while ((this.eB == null) || (str == null) || (!this.eB.equals(str)));
    File localFile2 = new File(com.baidu.location.b.k.ai() + File.separator + f.replaceFileName);
    if (localFile2.exists())
      localFile2.delete();
    try
    {
      jdMethod_if(localFile1, localFile2);
      return;
    }
    catch (Exception localException)
    {
      localFile2.delete();
    }
  }

  private Handler aN()
  {
    return this.eA;
  }

  private void aO()
  {
    String str = e.int + "/grtcf.dat";
    try
    {
      File localFile1 = new File(str);
      if (!localFile1.exists())
      {
        File localFile2 = new File(e.int);
        if (!localFile2.exists())
          localFile2.mkdirs();
        if (localFile1.createNewFile())
        {
          RandomAccessFile localRandomAccessFile1 = new RandomAccessFile(localFile1, "rw");
          localRandomAccessFile1.seek(2L);
          localRandomAccessFile1.writeInt(0);
          localRandomAccessFile1.seek(8L);
          byte[] arrayOfByte1 = "1980_01_01:0".getBytes();
          localRandomAccessFile1.writeInt(arrayOfByte1.length);
          localRandomAccessFile1.write(arrayOfByte1);
          localRandomAccessFile1.seek(200L);
          localRandomAccessFile1.writeBoolean(false);
          localRandomAccessFile1.seek(800L);
          localRandomAccessFile1.writeBoolean(false);
          localRandomAccessFile1.close();
        }
      }
      else
      {
        RandomAccessFile localRandomAccessFile2 = new RandomAccessFile(localFile1, "rw");
        localRandomAccessFile2.seek(200L);
        localRandomAccessFile2.writeBoolean(true);
        if (this.ez == 1)
        {
          localRandomAccessFile2.writeBoolean(true);
          if (this.eB == null)
            break label246;
          byte[] arrayOfByte2 = this.eB.getBytes();
          localRandomAccessFile2.writeInt(arrayOfByte2.length);
          localRandomAccessFile2.write(arrayOfByte2);
        }
        while (true)
        {
          localRandomAccessFile2.close();
          return;
          localRandomAccessFile2.writeBoolean(false);
          break;
          label246: localRandomAccessFile2.writeInt(0);
        }
      }
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private void aP()
  {
    if (this.eE == null);
    do
      return;
    while (!l.a().c9());
    new d.4(this).start();
  }

  public static d aR()
  {
    if (ey == null)
      ey = new d();
    return ey;
  }

  private static boolean jdMethod_do(String paramString1, String paramString2)
  {
    File localFile = new File(com.baidu.location.b.k.ai() + File.separator + "tmp");
    if (localFile.exists())
      localFile.delete();
    FileOutputStream localFileOutputStream;
    HttpURLConnection localHttpURLConnection;
    try
    {
      localFileOutputStream = new FileOutputStream(localFile);
      byte[] arrayOfByte = new byte[4096];
      localHttpURLConnection = (HttpURLConnection)new URL(paramString1).openConnection();
      BufferedInputStream localBufferedInputStream = new BufferedInputStream(localHttpURLConnection.getInputStream());
      while (true)
      {
        int i = localBufferedInputStream.read(arrayOfByte);
        if (i <= 0)
          break;
        localFileOutputStream.write(arrayOfByte, 0, i);
      }
    }
    catch (Exception localException)
    {
      localFile.delete();
      return false;
    }
    localHttpURLConnection.disconnect();
    localFileOutputStream.close();
    if (localFile.length() < 10240L)
    {
      localFile.delete();
      return false;
    }
    localFile.renameTo(new File(com.baidu.location.b.k.ai() + File.separator + paramString2));
    return true;
  }

  // ERROR //
  public static void jdMethod_if(File paramFile1, File paramFile2)
    throws java.io.IOException
  {
    // Byte code:
    //   0: new 197	java/io/BufferedInputStream
    //   3: dup
    //   4: new 235	java/io/FileInputStream
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 236	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   12: invokespecial 204	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   15: astore_2
    //   16: new 238	java/io/BufferedOutputStream
    //   19: dup
    //   20: new 183	java/io/FileOutputStream
    //   23: dup
    //   24: aload_1
    //   25: invokespecial 186	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   28: invokespecial 241	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   31: astore_3
    //   32: sipush 5120
    //   35: newarray byte
    //   37: astore 6
    //   39: aload_2
    //   40: aload 6
    //   42: invokevirtual 208	java/io/BufferedInputStream:read	([B)I
    //   45: istore 7
    //   47: iload 7
    //   49: iconst_m1
    //   50: if_icmpeq +41 -> 91
    //   53: aload_3
    //   54: aload 6
    //   56: iconst_0
    //   57: iload 7
    //   59: invokevirtual 242	java/io/BufferedOutputStream:write	([BII)V
    //   62: goto -23 -> 39
    //   65: astore 4
    //   67: aload_2
    //   68: astore 5
    //   70: aload 5
    //   72: ifnull +8 -> 80
    //   75: aload 5
    //   77: invokevirtual 243	java/io/BufferedInputStream:close	()V
    //   80: aload_3
    //   81: ifnull +7 -> 88
    //   84: aload_3
    //   85: invokevirtual 244	java/io/BufferedOutputStream:close	()V
    //   88: aload 4
    //   90: athrow
    //   91: aload_3
    //   92: invokevirtual 247	java/io/BufferedOutputStream:flush	()V
    //   95: aload_0
    //   96: invokevirtual 95	java/io/File:delete	()Z
    //   99: pop
    //   100: aload_2
    //   101: ifnull +7 -> 108
    //   104: aload_2
    //   105: invokevirtual 243	java/io/BufferedInputStream:close	()V
    //   108: aload_3
    //   109: ifnull +7 -> 116
    //   112: aload_3
    //   113: invokevirtual 244	java/io/BufferedOutputStream:close	()V
    //   116: return
    //   117: astore 4
    //   119: aconst_null
    //   120: astore_3
    //   121: aconst_null
    //   122: astore 5
    //   124: goto -54 -> 70
    //   127: astore 4
    //   129: aload_2
    //   130: astore 5
    //   132: aconst_null
    //   133: astore_3
    //   134: goto -64 -> 70
    //
    // Exception table:
    //   from	to	target	type
    //   32	39	65	finally
    //   39	47	65	finally
    //   53	62	65	finally
    //   91	100	65	finally
    //   0	16	117	finally
    //   16	32	127	finally
  }

  public void aQ()
  {
    long l = n.jdMethod_if().jdMethod_do();
    if (System.currentTimeMillis() - l > 86400000L)
    {
      aN().postDelayed(new d.1(this), 10000L);
      aN().postDelayed(new d.2(this), 5000L);
    }
  }

  public void au()
  {
    StringBuffer localStringBuffer = new StringBuffer(128);
    localStringBuffer.append("&sdk=");
    localStringBuffer.append(6.13F);
    localStringBuffer.append("&fw=");
    localStringBuffer.append(f.getFrameVersion());
    localStringBuffer.append("&suit=");
    localStringBuffer.append(2);
    if (c.N().bm == null)
    {
      localStringBuffer.append("&im=");
      localStringBuffer.append(c.N().bo);
    }
    while (true)
    {
      localStringBuffer.append("&mb=");
      localStringBuffer.append(Build.MODEL);
      localStringBuffer.append("&sv=");
      String str = Build.VERSION.RELEASE;
      if ((str != null) && (str.length() > 10))
        str = str.substring(0, 10);
      localStringBuffer.append(str);
      localStringBuffer.append("&pack=");
      localStringBuffer.append(c.bn);
      this.c5 = (com.baidu.location.b.k.ac() + "?&it=" + Jni.F(localStringBuffer.toString()));
      return;
      localStringBuffer.append("&cu=");
      localStringBuffer.append(c.N().bm);
    }
  }

  public void jdMethod_int(boolean paramBoolean)
  {
    if (paramBoolean);
    try
    {
      JSONObject localJSONObject = new JSONObject(EntityUtils.toString(this.c6, "utf-8"));
      if ("up".equals(localJSONObject.getString("res")))
      {
        this.eE = localJSONObject.getString("upath");
        if (localJSONObject.has("u1"))
          this.eD = localJSONObject.getString("u1");
        if (localJSONObject.has("u2"))
          this.eC = localJSONObject.getString("u2");
        if (localJSONObject.has("u1_md5"))
          this.eB = localJSONObject.getString("u1_md5");
        aN().post(new d.3(this));
      }
      if (localJSONObject.has("ison"))
        this.ez = localJSONObject.getInt("ison");
      aO();
      label153: n.jdMethod_if().jdMethod_for(System.currentTimeMillis());
      return;
    }
    catch (Exception localException)
    {
      break label153;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.baidu.location.e.d
 * JD-Core Version:    0.6.0
 */