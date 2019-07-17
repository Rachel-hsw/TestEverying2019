package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.a.a.c.c;
import com.xiaomi.f.a.d;
import com.xiaomi.f.a.e;
import com.xiaomi.f.a.g;
import com.xiaomi.f.a.i;
import com.xiaomi.f.a.k;
import com.xiaomi.f.a.m;
import com.xiaomi.f.a.n;
import com.xiaomi.f.a.p;
import com.xiaomi.f.a.r;
import com.xiaomi.f.a.t;
import com.xiaomi.f.a.u;
import java.nio.ByteBuffer;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.a.c.b;
import org.a.c.f;

public class l
{
  private static final byte[] a = { 100, 23, 84, 114, 72, 0, 4, 97, 73, 97, 2, 52, 84, 102, 18, 32 };

  protected static <T extends b<T, ?>> com.xiaomi.f.a.h a(Context paramContext, T paramT, com.xiaomi.f.a.a parama)
  {
    if (!parama.equals(com.xiaomi.f.a.a.a));
    for (boolean bool = true; ; bool = false)
      return a(paramContext, paramT, parama, bool, paramContext.getPackageName(), h.a(paramContext).c());
  }

  protected static <T extends b<T, ?>> com.xiaomi.f.a.h a(Context paramContext, T paramT, com.xiaomi.f.a.a parama, boolean paramBoolean, String paramString1, String paramString2)
  {
    Object localObject = u.a(paramT);
    if (localObject == null)
    {
      c.a("invoke convertThriftObjectToBytes method, return null.");
      return null;
    }
    com.xiaomi.f.a.h localh = new com.xiaomi.f.a.h();
    byte[] arrayOfByte1;
    if (paramBoolean)
    {
      String str = h.a(paramContext).f();
      if (TextUtils.isEmpty(str))
      {
        c.a("regSecret is empty, return null");
        return null;
      }
      arrayOfByte1 = com.xiaomi.a.a.g.a.a(str);
    }
    try
    {
      byte[] arrayOfByte2 = b(arrayOfByte1, localObject);
      localObject = arrayOfByte2;
      d locald = new d();
      locald.a = 5L;
      locald.b = "fakeid";
      localh.a(locald);
      localh.a(ByteBuffer.wrap(localObject));
      localh.a(parama);
      localh.c(true);
      localh.b(paramString1);
      localh.a(paramBoolean);
      localh.a(paramString2);
      return localh;
    }
    catch (Exception localException)
    {
      while (true)
        c.d("encryption error. ");
    }
  }

  private static Cipher a(byte[] paramArrayOfByte, int paramInt)
  {
    SecretKeySpec localSecretKeySpec = new SecretKeySpec(paramArrayOfByte, "AES");
    IvParameterSpec localIvParameterSpec = new IvParameterSpec(a);
    Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    localCipher.init(paramInt, localSecretKeySpec, localIvParameterSpec);
    return localCipher;
  }

  protected static b a(Context paramContext, com.xiaomi.f.a.h paramh)
  {
    byte[] arrayOfByte2;
    if (paramh.c())
      arrayOfByte2 = com.xiaomi.a.a.g.a.a(h.a(paramContext).f());
    while (true)
    {
      try
      {
        byte[] arrayOfByte3 = a(arrayOfByte2, paramh.f());
        arrayOfByte1 = arrayOfByte3;
        b localb = a(paramh.a());
        if (localb == null)
          continue;
        u.a(localb, arrayOfByte1);
        return localb;
      }
      catch (Exception localException)
      {
        throw new f("the aes decrypt failed.", localException);
      }
      byte[] arrayOfByte1 = paramh.f();
    }
  }

  private static b a(com.xiaomi.f.a.a parama)
  {
    switch (1.a[parama.ordinal()])
    {
    default:
      return null;
    case 1:
      return new k();
    case 2:
      return new r();
    case 3:
      return new p();
    case 4:
      return new t();
    case 5:
      return new n();
    case 6:
      return new e();
    case 7:
      return new g();
    case 8:
      return new m();
    case 9:
      return new i();
    case 10:
    }
    return new g();
  }

  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return a(paramArrayOfByte1, 2).doFinal(paramArrayOfByte2);
  }

  public static byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return a(paramArrayOfByte1, 1).doFinal(paramArrayOfByte2);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.mipush.sdk.l
 * JD-Core Version:    0.6.0
 */