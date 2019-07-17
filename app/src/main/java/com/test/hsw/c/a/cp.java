package c.a;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public class cp
{
  private final dn a;
  private final ea b = new ea();

  public cp()
  {
    this(new dh.a());
  }

  public cp(dp paramdp)
  {
    this.a = paramdp.a(this.b);
  }

  private Object a(byte paramByte, byte[] paramArrayOfByte, ct paramct, ct[] paramArrayOfct)
    throws cs
  {
    try
    {
      di localdi = j(paramArrayOfByte, paramct, paramArrayOfct);
      if (localdi != null)
        switch (paramByte)
        {
        default:
        case 2:
        case 3:
        case 4:
        case 6:
        case 8:
        case 10:
        case 11:
        case 100:
        }
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                      return null;
                    while (localdi.b != 2);
                    Boolean localBoolean = Boolean.valueOf(this.a.t());
                    return localBoolean;
                  }
                  while (localdi.b != 3);
                  Byte localByte = Byte.valueOf(this.a.u());
                  return localByte;
                }
                while (localdi.b != 4);
                Double localDouble = Double.valueOf(this.a.y());
                return localDouble;
              }
              while (localdi.b != 6);
              Short localShort = Short.valueOf(this.a.v());
              return localShort;
            }
            while (localdi.b != 8);
            Integer localInteger = Integer.valueOf(this.a.w());
            return localInteger;
          }
          while (localdi.b != 10);
          Long localLong = Long.valueOf(this.a.x());
          return localLong;
        }
        while (localdi.b != 11);
        String str = this.a.z();
        return str;
      }
      while (localdi.b != 11);
      ByteBuffer localByteBuffer = this.a.A();
      return localByteBuffer;
    }
    catch (Exception localException)
    {
      throw new cs(localException);
    }
    finally
    {
      this.b.e();
      this.a.B();
    }
    throw localObject;
  }

  private di j(byte[] paramArrayOfByte, ct paramct, ct[] paramArrayOfct)
    throws cs
  {
    int i = 0;
    this.b.a(paramArrayOfByte);
    ct[] arrayOfct = new ct[1 + paramArrayOfct.length];
    arrayOfct[0] = paramct;
    for (int j = 0; j < paramArrayOfct.length; j++)
      arrayOfct[(j + 1)] = paramArrayOfct[j];
    this.a.j();
    di localdi = null;
    while (i < arrayOfct.length)
    {
      localdi = this.a.l();
      if ((localdi.b == 0) || (localdi.c > arrayOfct[i].a()))
        return null;
      if (localdi.c != arrayOfct[i].a())
      {
        dq.a(this.a, localdi.b);
        this.a.m();
        continue;
      }
      i++;
      if (i >= arrayOfct.length)
        continue;
      this.a.j();
    }
    return localdi;
  }

  public Boolean a(byte[] paramArrayOfByte, ct paramct, ct[] paramArrayOfct)
    throws cs
  {
    return (Boolean)a(2, paramArrayOfByte, paramct, paramArrayOfct);
  }

  public void a(cl paramcl, String paramString)
    throws cs
  {
    a(paramcl, paramString.getBytes());
  }

  public void a(cl paramcl, String paramString1, String paramString2)
    throws cs
  {
    try
    {
      a(paramcl, paramString1.getBytes(paramString2));
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new cs("JVM DOES NOT SUPPORT ENCODING: " + paramString2);
    }
    finally
    {
      this.a.B();
    }
    throw localObject;
  }

  public void a(cl paramcl, byte[] paramArrayOfByte)
    throws cs
  {
    try
    {
      this.b.a(paramArrayOfByte);
      paramcl.a(this.a);
      return;
    }
    finally
    {
      this.b.e();
      this.a.B();
    }
    throw localObject;
  }

  public void a(cl paramcl, byte[] paramArrayOfByte, ct paramct, ct[] paramArrayOfct)
    throws cs
  {
    try
    {
      if (j(paramArrayOfByte, paramct, paramArrayOfct) != null)
        paramcl.a(this.a);
      return;
    }
    catch (Exception localException)
    {
      throw new cs(localException);
    }
    finally
    {
      this.b.e();
      this.a.B();
    }
    throw localObject;
  }

  public Byte b(byte[] paramArrayOfByte, ct paramct, ct[] paramArrayOfct)
    throws cs
  {
    return (Byte)a(3, paramArrayOfByte, paramct, paramArrayOfct);
  }

  public Double c(byte[] paramArrayOfByte, ct paramct, ct[] paramArrayOfct)
    throws cs
  {
    return (Double)a(4, paramArrayOfByte, paramct, paramArrayOfct);
  }

  public Short d(byte[] paramArrayOfByte, ct paramct, ct[] paramArrayOfct)
    throws cs
  {
    return (Short)a(6, paramArrayOfByte, paramct, paramArrayOfct);
  }

  public Integer e(byte[] paramArrayOfByte, ct paramct, ct[] paramArrayOfct)
    throws cs
  {
    return (Integer)a(8, paramArrayOfByte, paramct, paramArrayOfct);
  }

  public Long f(byte[] paramArrayOfByte, ct paramct, ct[] paramArrayOfct)
    throws cs
  {
    return (Long)a(10, paramArrayOfByte, paramct, paramArrayOfct);
  }

  public String g(byte[] paramArrayOfByte, ct paramct, ct[] paramArrayOfct)
    throws cs
  {
    return (String)a(11, paramArrayOfByte, paramct, paramArrayOfct);
  }

  public ByteBuffer h(byte[] paramArrayOfByte, ct paramct, ct[] paramArrayOfct)
    throws cs
  {
    return (ByteBuffer)a(100, paramArrayOfByte, paramct, paramArrayOfct);
  }

  public Short i(byte[] paramArrayOfByte, ct paramct, ct[] paramArrayOfct)
    throws cs
  {
    try
    {
      if (j(paramArrayOfByte, paramct, paramArrayOfct) != null)
      {
        this.a.j();
        Short localShort = Short.valueOf(this.a.l().c);
        return localShort;
      }
      return null;
    }
    catch (Exception localException)
    {
      throw new cs(localException);
    }
    finally
    {
      this.b.e();
      this.a.B();
    }
    throw localObject;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     c.a.cp
 * JD-Core Version:    0.6.0
 */