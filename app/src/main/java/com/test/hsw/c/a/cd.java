package c.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.umeng.a.k;

public class cd
{
  private final byte[] a = { 0, 0, 0, 0, 0, 0, 0, 0 };
  private final int b = 1;
  private final int c = 0;
  private String d = "1.0";
  private String e = null;
  private byte[] f = null;
  private byte[] g = null;
  private byte[] h = null;
  private int i = 0;
  private int j = 0;
  private int k = 0;
  private byte[] l = null;
  private byte[] m = null;
  private boolean n = false;

  private cd(byte[] paramArrayOfByte1, String paramString, byte[] paramArrayOfByte2)
    throws Exception
  {
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte1.length == 0))
      throw new Exception("entity is null or empty");
    this.e = paramString;
    this.k = paramArrayOfByte1.length;
    this.l = cg.a(paramArrayOfByte1);
    this.j = (int)(System.currentTimeMillis() / 1000L);
    this.m = paramArrayOfByte2;
  }

  public static cd a(Context paramContext, String paramString, byte[] paramArrayOfByte)
  {
    try
    {
      String str1 = bt.p(paramContext);
      String str2 = bt.f(paramContext);
      SharedPreferences localSharedPreferences = fc.a(paramContext);
      String str3 = localSharedPreferences.getString("signature", null);
      int i1 = localSharedPreferences.getInt("serial", 1);
      cd localcd = new cd(paramArrayOfByte, paramString, (str2 + str1).getBytes());
      localcd.a(str3);
      localcd.a(i1);
      localcd.b();
      localSharedPreferences.edit().putInt("serial", i1 + 1).putString("signature", localcd.a()).commit();
      return localcd;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }

  public static String a(Context paramContext)
  {
    SharedPreferences localSharedPreferences = fc.a(paramContext);
    if (localSharedPreferences == null)
      return null;
    return localSharedPreferences.getString("signature", null);
  }

  private byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    int i1 = 0;
    byte[] arrayOfByte1 = k.b(this.m);
    byte[] arrayOfByte2 = k.b(this.l);
    int i2 = arrayOfByte1.length;
    byte[] arrayOfByte3 = new byte[i2 * 2];
    for (int i3 = 0; i3 < i2; i3++)
    {
      arrayOfByte3[(i3 * 2)] = arrayOfByte2[i3];
      arrayOfByte3[(1 + i3 * 2)] = arrayOfByte1[i3];
    }
    for (int i4 = 0; i4 < 2; i4++)
    {
      arrayOfByte3[i4] = paramArrayOfByte[i4];
      arrayOfByte3[(-1 + (arrayOfByte3.length - i4))] = paramArrayOfByte[(-1 + (paramArrayOfByte.length - i4))];
    }
    byte[] arrayOfByte4 = new byte[4];
    arrayOfByte4[0] = (byte)(paramInt & 0xFF);
    arrayOfByte4[1] = (byte)(0xFF & paramInt >> 8);
    arrayOfByte4[2] = (byte)(0xFF & paramInt >> 16);
    arrayOfByte4[3] = (byte)(paramInt >>> 24);
    while (i1 < arrayOfByte3.length)
    {
      arrayOfByte3[i1] = (byte)(arrayOfByte3[i1] ^ arrayOfByte4[(i1 % 4)]);
      i1++;
    }
    return arrayOfByte3;
  }

  public static cd b(Context paramContext, String paramString, byte[] paramArrayOfByte)
  {
    try
    {
      String str1 = bt.p(paramContext);
      String str2 = bt.f(paramContext);
      SharedPreferences localSharedPreferences = fc.a(paramContext);
      String str3 = localSharedPreferences.getString("signature", null);
      int i1 = localSharedPreferences.getInt("serial", 1);
      cd localcd = new cd(paramArrayOfByte, paramString, (str2 + str1).getBytes());
      localcd.a(true);
      localcd.a(str3);
      localcd.a(i1);
      localcd.b();
      localSharedPreferences.edit().putInt("serial", i1 + 1).putString("signature", localcd.a()).commit();
      return localcd;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }

  private byte[] d()
  {
    return a(this.a, (int)(System.currentTimeMillis() / 1000L));
  }

  private byte[] e()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(k.a(this.f));
    localStringBuilder.append(this.i);
    localStringBuilder.append(this.j);
    localStringBuilder.append(this.k);
    localStringBuilder.append(k.a(this.g));
    return k.b(localStringBuilder.toString().getBytes());
  }

  public String a()
  {
    return k.a(this.f);
  }

  public void a(int paramInt)
  {
    this.i = paramInt;
  }

  public void a(String paramString)
  {
    this.f = k.a(paramString);
  }

  public void a(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }

  public void b()
  {
    if (this.f == null)
      this.f = d();
    byte[] arrayOfByte;
    if (this.n)
      arrayOfByte = new byte[16];
    try
    {
      System.arraycopy(this.f, 1, arrayOfByte, 0, 16);
      this.l = k.a(this.l, arrayOfByte);
      label51: this.g = a(this.f, this.j);
      this.h = e();
      return;
    }
    catch (Exception localException)
    {
      break label51;
    }
  }

  public byte[] c()
  {
    br localbr = new br();
    localbr.a(this.d);
    localbr.b(this.e);
    localbr.c(k.a(this.f));
    localbr.a(this.i);
    localbr.c(this.j);
    localbr.d(this.k);
    localbr.a(this.l);
    int i1;
    if (this.n)
      i1 = 1;
    while (true)
    {
      localbr.e(i1);
      localbr.d(k.a(this.g));
      localbr.e(k.a(this.h));
      try
      {
        byte[] arrayOfByte = new cv().a(localbr);
        return arrayOfByte;
        i1 = 0;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return null;
  }

  public String toString()
  {
    int i1 = 1;
    StringBuilder localStringBuilder = new StringBuilder();
    Object[] arrayOfObject1 = new Object[i1];
    arrayOfObject1[0] = this.d;
    localStringBuilder.append(String.format("version : %s\n", arrayOfObject1));
    Object[] arrayOfObject2 = new Object[i1];
    arrayOfObject2[0] = this.e;
    localStringBuilder.append(String.format("address : %s\n", arrayOfObject2));
    Object[] arrayOfObject3 = new Object[i1];
    arrayOfObject3[0] = k.a(this.f);
    localStringBuilder.append(String.format("signature : %s\n", arrayOfObject3));
    Object[] arrayOfObject4 = new Object[i1];
    arrayOfObject4[0] = Integer.valueOf(this.i);
    localStringBuilder.append(String.format("serial : %s\n", arrayOfObject4));
    Object[] arrayOfObject5 = new Object[i1];
    arrayOfObject5[0] = Integer.valueOf(this.j);
    localStringBuilder.append(String.format("timestamp : %d\n", arrayOfObject5));
    Object[] arrayOfObject6 = new Object[i1];
    arrayOfObject6[0] = Integer.valueOf(this.k);
    localStringBuilder.append(String.format("length : %d\n", arrayOfObject6));
    Object[] arrayOfObject7 = new Object[i1];
    arrayOfObject7[0] = k.a(this.g);
    localStringBuilder.append(String.format("guid : %s\n", arrayOfObject7));
    Object[] arrayOfObject8 = new Object[i1];
    arrayOfObject8[0] = k.a(this.h);
    localStringBuilder.append(String.format("checksum : %s ", arrayOfObject8));
    Object[] arrayOfObject9 = new Object[i1];
    if (this.n);
    while (true)
    {
      arrayOfObject9[0] = Integer.valueOf(i1);
      localStringBuilder.append(String.format("codex : %d", arrayOfObject9));
      return localStringBuilder.toString();
      i1 = 0;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     c.a.cd
 * JD-Core Version:    0.6.0
 */