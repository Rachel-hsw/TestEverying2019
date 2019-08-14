package com.xiaomi.f.a;

import com.xiaomi.a.a.c.c;
import org.a.c.b;
import org.a.c.b.a.a;
import org.a.c.b.l.a;
import org.a.c.e;
import org.a.c.f;
import org.a.c.g;

public class u
{
  public static <T extends b<T, ?>> void a(T paramT, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
      throw new f("the message byte is empty.");
    new e(new l.a(true, true, paramArrayOfByte.length)).a(paramT, paramArrayOfByte);
  }

  public static <T extends b<T, ?>> byte[] a(T paramT)
  {
    if (paramT == null)
      return null;
    try
    {
      byte[] arrayOfByte = new g(new a.a()).a(paramT);
      return arrayOfByte;
    }
    catch (f localf)
    {
      c.a("convertThriftObjectToBytes catch TException.", localf);
    }
    return null;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.f.a.u
 * JD-Core Version:    0.6.0
 */