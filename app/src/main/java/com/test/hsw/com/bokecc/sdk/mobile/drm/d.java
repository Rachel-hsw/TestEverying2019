package com.bokecc.sdk.mobile.drm;

import android.util.Log;
import com.bokecc.sdk.mobile.exception.DreamwinException;
import com.bokecc.sdk.mobile.exception.ErrorCode;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class d
{
  private e a;
  private long b;
  private long c;
  private long d;
  private long[] e;

  public d(e parame)
  {
    this.a = parame;
  }

  private void a(DataOutputStream paramDataOutputStream)
    throws Exception
  {
    long l1 = this.a.d();
    Object localObject = new byte[2048];
    long[] arrayOfLong = this.e;
    int i = arrayOfLong.length;
    int j = 0;
    long l2 = 0L;
    long l3 = 0L;
    while (j < i)
    {
      long l6 = arrayOfLong[j];
      long l7 = l2 + l6;
      byte[] arrayOfByte1 = DESUtil.a(this.a.a((int)l6), DESUtil.KEY_STORE.FILE_CRYPT_KEY.value().getBytes());
      int k = arrayOfByte1.length;
      byte[] arrayOfByte2 = new byte[(int)(l3 + k)];
      if (l3 > 0L)
        System.arraycopy(localObject, 0, arrayOfByte2, 0, (int)l3);
      System.arraycopy(arrayOfByte1, 0, arrayOfByte2, (int)l3, k);
      l3 += k;
      j++;
      localObject = arrayOfByte2;
      l2 = l7;
    }
    long l5;
    if (this.c == 0L)
    {
      paramDataOutputStream.write(localObject);
      l5 = this.b - l3;
    }
    while (true)
    {
      a(paramDataOutputStream, l5);
      do
      {
        return;
        if ((this.c <= 0L) || (this.c > l3))
          continue;
        paramDataOutputStream.write(localObject, (int)this.c, (int)(l3 - this.c));
        l5 = this.b - l3;
        break;
      }
      while ((this.c <= l3) || (this.c >= this.b));
      long l4 = l1 + this.c + (l2 - l3);
      this.a.a(l4);
      l5 = this.b - this.c;
    }
  }

  private void a(DataOutputStream paramDataOutputStream, long paramLong)
    throws IOException
  {
    byte[] arrayOfByte1 = new byte[2048];
    long l = 0L;
    byte[] arrayOfByte2 = arrayOfByte1;
    int i = 0;
    while (true)
    {
      int j = this.a.a(arrayOfByte2);
      if ((j == -1) || (i != 0))
        break;
      l += j;
      if (l >= paramLong)
      {
        int k = (int)(j - (l - paramLong));
        arrayOfByte2 = Arrays.copyOf(arrayOfByte2, k);
        j = k;
        i = 1;
      }
      paramDataOutputStream.write(arrayOfByte2, 0, j);
      paramDataOutputStream.flush();
    }
  }

  private void b()
    throws IOException, DreamwinException
  {
    int i = 0;
    if (this.b <= 0L)
      throw new DreamwinException(ErrorCode.PROCESS_FAIL, new String[] { "file is null." });
    if (!"PCM".equals(c.a(this.a.a(3))))
      throw new DreamwinException(ErrorCode.PROCESS_FAIL, new String[] { "file is not a pcm file." });
    if (c.b(this.a.a(4)) != 4)
      throw new DreamwinException(ErrorCode.PROCESS_FAIL, new String[] { "version number is wrong." });
    int j = c.b(this.a.a(4));
    this.a.a(j);
    int k = c.b(this.a.a(4));
    this.a.a(k);
    this.a.a(4);
    byte[] arrayOfByte1 = this.a.a(8);
    if (!this.a.a())
      this.c = c.c(arrayOfByte1);
    byte[] arrayOfByte2 = this.a.a(8);
    if (!this.a.a())
      this.d = c.c(arrayOfByte2);
    this.b = c.c(this.a.a(8));
    if (this.b <= 0L)
      throw new DreamwinException(ErrorCode.PROCESS_FAIL, new String[] { "file is null." });
    this.d = this.b;
    this.a.a(4);
    int m = c.b(this.a.a(4));
    this.e = new long[m];
    while (i < m)
    {
      long l = c.c(this.a.a(8));
      this.e[i] = l;
      i++;
    }
    int n = c.b(this.a.a(4));
    this.a.a(n);
  }

  // ERROR //
  private void b(DataOutputStream paramDataOutputStream)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 29	com/bokecc/sdk/mobile/drm/d:e	[J
    //   4: astore_2
    //   5: aload_2
    //   6: arraylength
    //   7: istore_3
    //   8: iconst_0
    //   9: istore 4
    //   11: lconst_0
    //   12: lstore 5
    //   14: iload 4
    //   16: iload_3
    //   17: if_icmpge +98 -> 115
    //   20: aload_2
    //   21: iload 4
    //   23: laload
    //   24: lstore 7
    //   26: aload_0
    //   27: getfield 19	com/bokecc/sdk/mobile/drm/d:a	Lcom/bokecc/sdk/mobile/drm/e;
    //   30: lload 7
    //   32: l2i
    //   33: invokevirtual 32	com/bokecc/sdk/mobile/drm/e:a	(I)[B
    //   36: getstatic 38	com/bokecc/sdk/mobile/drm/DESUtil$KEY_STORE:FILE_CRYPT_KEY	Lcom/bokecc/sdk/mobile/drm/DESUtil$KEY_STORE;
    //   39: invokevirtual 42	com/bokecc/sdk/mobile/drm/DESUtil$KEY_STORE:value	()Ljava/lang/String;
    //   42: invokevirtual 48	java/lang/String:getBytes	()[B
    //   45: invokestatic 53	com/bokecc/sdk/mobile/drm/DESUtil:a	([B[B)[B
    //   48: astore 11
    //   50: aload 11
    //   52: arraylength
    //   53: istore 12
    //   55: lload 5
    //   57: iload 12
    //   59: i2l
    //   60: ladd
    //   61: lstore 13
    //   63: aload_1
    //   64: aload 11
    //   66: iconst_0
    //   67: aload 11
    //   69: arraylength
    //   70: invokevirtual 75	java/io/DataOutputStream:write	([BII)V
    //   73: aload_1
    //   74: invokevirtual 92	java/io/DataOutputStream:flush	()V
    //   77: iinc 4 1
    //   80: lload 13
    //   82: lstore 5
    //   84: goto -70 -> 14
    //   87: astore 9
    //   89: ldc 132
    //   91: new 134	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   98: aload 9
    //   100: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   103: ldc 141
    //   105: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokestatic 153	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   114: pop
    //   115: aload_0
    //   116: aload_1
    //   117: aload_0
    //   118: getfield 69	com/bokecc/sdk/mobile/drm/d:b	J
    //   121: lload 5
    //   123: lsub
    //   124: invokespecial 72	com/bokecc/sdk/mobile/drm/d:a	(Ljava/io/DataOutputStream;J)V
    //   127: return
    //   128: astore 15
    //   130: lload 13
    //   132: lstore 5
    //   134: aload 15
    //   136: astore 9
    //   138: goto -49 -> 89
    //
    // Exception table:
    //   from	to	target	type
    //   26	55	87	java/lang/Exception
    //   63	77	128	java/lang/Exception
  }

  public Map<String, String> a()
  {
    HashMap localHashMap = new HashMap();
    if (this.c > 0L)
    {
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = Long.valueOf(this.c);
      arrayOfObject[1] = Long.valueOf(this.d);
      arrayOfObject[2] = Long.valueOf(this.b);
      localHashMap.put("Content-Range", String.format("bytes %d-%d/%d", arrayOfObject));
    }
    while (true)
    {
      localHashMap.put("Content-Length", this.b - this.c + "");
      return localHashMap;
      localHashMap.put("Accept-Ranges", "bytes");
    }
  }

  public void a(OutputStream paramOutputStream)
    throws Exception
  {
    DataOutputStream localDataOutputStream = new DataOutputStream(paramOutputStream);
    if (this.a.a())
      a(localDataOutputStream);
    while (true)
    {
      this.a.e();
      return;
      b(localDataOutputStream);
    }
  }

  public boolean a(long paramLong1, long paramLong2)
  {
    this.c = paramLong1;
    this.d = paramLong2;
    this.b = this.a.b();
    try
    {
      b();
      return true;
    }
    catch (Exception localException)
    {
      Log.e("DRMContentParser", localException + "");
    }
    return false;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.bokecc.sdk.mobile.drm.d
 * JD-Core Version:    0.6.0
 */