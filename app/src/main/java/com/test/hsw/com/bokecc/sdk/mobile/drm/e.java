package com.bokecc.sdk.mobile.drm;

import com.bokecc.sdk.mobile.exception.DreamwinException;
import com.bokecc.sdk.mobile.exception.ErrorCode;
import com.bokecc.sdk.mobile.util.HttpUtil;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

class e
{
  private Object a = null;
  private long b = 0L;
  private long c = 0L;

  private void a(HttpURLConnection paramHttpURLConnection)
    throws ProtocolException
  {
    HttpURLConnection.setFollowRedirects(true);
    paramHttpURLConnection.setConnectTimeout(50000);
    paramHttpURLConnection.setReadTimeout(50000);
    paramHttpURLConnection.setRequestMethod("GET");
    paramHttpURLConnection.setRequestProperty("Accept", "image/gif, image/jpeg, image/pjpeg, image/pjpeg, application/x-shockwave-flash, application/xaml+xml, application/vnd.ms-xpsdocument, application/x-ms-xbap, application/x-ms-application, application/vnd.ms-excel, application/vnd.ms-powerpoint, application/msword, */*");
    paramHttpURLConnection.setRequestProperty("Accept-Language", "zh-CN");
    paramHttpURLConnection.setRequestProperty("Referer", "http://union.bokecc.com/flash/player.swf");
    paramHttpURLConnection.setRequestProperty("Charset", "UTF-8");
    paramHttpURLConnection.setRequestProperty("User-Agent", HttpUtil.getUserAgent());
    paramHttpURLConnection.setRequestProperty("Connection", "Keep-Alive");
  }

  public int a(byte[] paramArrayOfByte)
    throws IOException
  {
    if ((this.a instanceof InputStream))
      return ((InputStream)this.a).read(paramArrayOfByte);
    if ((this.a instanceof RandomAccessFile))
      return ((RandomAccessFile)this.a).read(paramArrayOfByte);
    return -1;
  }

  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if ((this.a instanceof InputStream))
      return ((InputStream)this.a).read(paramArrayOfByte, paramInt1, paramInt2);
    if ((this.a instanceof RandomAccessFile))
      return ((RandomAccessFile)this.a).read(paramArrayOfByte, paramInt1, paramInt2);
    return -1;
  }

  public void a(long paramLong)
    throws IOException
  {
    if ((this.a instanceof RandomAccessFile))
      ((RandomAccessFile)this.a).seek(paramLong);
  }

  public boolean a()
  {
    return (this.a instanceof RandomAccessFile);
  }

  public boolean a(String paramString, long paramLong)
    throws IOException
  {
    if (paramString.startsWith("http"))
    {
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(paramString).openConnection();
      a(localHttpURLConnection);
      if (paramLong > 0L)
        localHttpURLConnection.setRequestProperty("Range", "bytes=" + paramLong + "-");
      this.c = localHttpURLConnection.getLastModified();
      this.a = localHttpURLConnection.getInputStream();
      this.b = localHttpURLConnection.getContentLength();
      return true;
    }
    File localFile = new File(paramString);
    RandomAccessFile localRandomAccessFile = new RandomAccessFile(localFile, "r");
    this.c = localFile.lastModified();
    this.a = localRandomAccessFile;
    this.b = localRandomAccessFile.length();
    return true;
  }

  public byte[] a(int paramInt)
    throws IOException, DreamwinException
  {
    byte[] arrayOfByte = new byte[paramInt];
    if (b(arrayOfByte) < 0)
      throw new DreamwinException(ErrorCode.PROCESS_FAIL, new String[] { "Load Data Fail." });
    return arrayOfByte;
  }

  public int b(byte[] paramArrayOfByte)
    throws IOException
  {
    int i = a(paramArrayOfByte);
    if (i <= 0);
    label42: 
    while (true)
    {
      return i;
      int j = paramArrayOfByte.length;
      while (true)
      {
        if (i == j)
          break label42;
        int k = a(paramArrayOfByte, i, j - i);
        if (k < 0)
          break;
        i += k;
      }
    }
  }

  public long b()
  {
    return this.b;
  }

  public long c()
  {
    return this.c;
  }

  public long d()
    throws IOException
  {
    if ((this.a instanceof RandomAccessFile))
      return ((RandomAccessFile)this.a).getFilePointer();
    return 0L;
  }

  public void e()
    throws IOException
  {
    if ((this.a instanceof InputStream))
      ((InputStream)this.a).close();
    do
      return;
    while (!(this.a instanceof RandomAccessFile));
    ((RandomAccessFile)this.a).close();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.bokecc.sdk.mobile.drm.e
 * JD-Core Version:    0.6.0
 */