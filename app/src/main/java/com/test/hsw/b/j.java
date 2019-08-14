package b;

import B;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public final class j
  implements Serializable
{
  public static final j a;
  private static final char[] c = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  private static final long d = 1L;
  final byte[] b;
  private transient int e;
  private transient String f;

  static
  {
    a = a(new byte[0]);
  }

  j(byte[] paramArrayOfByte)
  {
    this.b = paramArrayOfByte;
  }

  private static int a(char paramChar)
  {
    if ((paramChar >= '0') && (paramChar <= '9'))
      return paramChar - '0';
    if ((paramChar >= 'a') && (paramChar <= 'f'))
      return 10 + (paramChar - 'a');
    if ((paramChar >= 'A') && (paramChar <= 'F'))
      return 10 + (paramChar - 'A');
    throw new IllegalArgumentException("Unexpected hex digit: " + paramChar);
  }

  public static j a(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    if (paramInputStream == null)
      throw new IllegalArgumentException("in == null");
    if (paramInt < 0)
      throw new IllegalArgumentException("byteCount < 0: " + paramInt);
    byte[] arrayOfByte = new byte[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      int j = paramInputStream.read(arrayOfByte, i, paramInt - i);
      if (j == -1)
        throw new EOFException();
      i += j;
    }
    return new j(arrayOfByte);
  }

  public static j a(String paramString)
  {
    if (paramString == null)
      throw new IllegalArgumentException("s == null");
    j localj = new j(paramString.getBytes(ae.a));
    localj.f = paramString;
    return localj;
  }

  public static j a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
      throw new IllegalArgumentException("data == null");
    return new j((byte[])paramArrayOfByte.clone());
  }

  public static j a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null)
      throw new IllegalArgumentException("data == null");
    ae.a(paramArrayOfByte.length, paramInt1, paramInt2);
    byte[] arrayOfByte = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
    return new j(arrayOfByte);
  }

  private void a(ObjectInputStream paramObjectInputStream)
    throws IOException
  {
    j localj = a(paramObjectInputStream, paramObjectInputStream.readInt());
    try
    {
      Field localField = j.class.getDeclaredField("b");
      localField.setAccessible(true);
      localField.set(this, localj.b);
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      throw new AssertionError();
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
    }
    throw new AssertionError();
  }

  private void a(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.writeInt(this.b.length);
    paramObjectOutputStream.write(this.b);
  }

  public static j b(String paramString)
  {
    if (paramString == null)
      throw new IllegalArgumentException("base64 == null");
    byte[] arrayOfByte = d.a(paramString);
    if (arrayOfByte != null)
      return new j(arrayOfByte);
    return null;
  }

  public static j c(String paramString)
  {
    if (paramString == null)
      throw new IllegalArgumentException("hex == null");
    if (paramString.length() % 2 != 0)
      throw new IllegalArgumentException("Unexpected hex string: " + paramString);
    byte[] arrayOfByte = new byte[paramString.length() / 2];
    for (int i = 0; i < arrayOfByte.length; i++)
      arrayOfByte[i] = (byte)((a(paramString.charAt(i * 2)) << 4) + a(paramString.charAt(1 + i * 2)));
    return a(arrayOfByte);
  }

  public byte a(int paramInt)
  {
    return this.b[paramInt];
  }

  public String a()
  {
    String str1 = this.f;
    if (str1 != null)
      return str1;
    String str2 = new String(this.b, ae.a);
    this.f = str2;
    return str2;
  }

  public void a(OutputStream paramOutputStream)
    throws IOException
  {
    if (paramOutputStream == null)
      throw new IllegalArgumentException("out == null");
    paramOutputStream.write(this.b);
  }

  public String b()
  {
    return d.a(this.b);
  }

  public String c()
  {
    int i = 0;
    char[] arrayOfChar = new char[2 * this.b.length];
    byte[] arrayOfByte = this.b;
    int j = arrayOfByte.length;
    int k = 0;
    while (i < j)
    {
      int m = arrayOfByte[i];
      int n = k + 1;
      arrayOfChar[k] = c[(0xF & m >> 4)];
      k = n + 1;
      arrayOfChar[n] = c[(m & 0xF)];
      i++;
    }
    return new String(arrayOfChar);
  }

  public j d()
  {
    int i = 0;
    while (i < this.b.length)
    {
      int j = this.b[i];
      if ((j < 65) || (j > 90))
      {
        i++;
        continue;
      }
      byte[] arrayOfByte = (byte[])this.b.clone();
      int k = i + 1;
      arrayOfByte[i] = (byte)(j + 32);
      int m = k;
      if (m < arrayOfByte.length)
      {
        int n = arrayOfByte[m];
        if ((n < 65) || (n > 90));
        while (true)
        {
          m++;
          break;
          arrayOfByte[m] = (byte)(n + 32);
        }
      }
      this = new j(arrayOfByte);
    }
    return this;
  }

  public j e()
  {
    int i = 0;
    while (i < this.b.length)
    {
      int j = this.b[i];
      if ((j < 97) || (j > 122))
      {
        i++;
        continue;
      }
      byte[] arrayOfByte = (byte[])this.b.clone();
      int k = i + 1;
      arrayOfByte[i] = (byte)(j - 32);
      int m = k;
      if (m < arrayOfByte.length)
      {
        int n = arrayOfByte[m];
        if ((n < 97) || (n > 122));
        while (true)
        {
          m++;
          break;
          arrayOfByte[m] = (byte)(n - 32);
        }
      }
      this = new j(arrayOfByte);
    }
    return this;
  }

  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof j)) && (Arrays.equals(((j)paramObject).b, this.b)));
  }

  public int f()
  {
    return this.b.length;
  }

  public byte[] g()
  {
    return (byte[])this.b.clone();
  }

  public int hashCode()
  {
    int i = this.e;
    if (i != 0)
      return i;
    int j = Arrays.hashCode(this.b);
    this.e = j;
    return j;
  }

  public String toString()
  {
    if (this.b.length == 0)
      return "ByteString[size=0]";
    if (this.b.length <= 16)
    {
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = Integer.valueOf(this.b.length);
      arrayOfObject2[1] = c();
      return String.format("ByteString[size=%s data=%s]", arrayOfObject2);
    }
    try
    {
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = Integer.valueOf(this.b.length);
      arrayOfObject1[1] = a(MessageDigest.getInstance("MD5").digest(this.b)).c();
      String str = String.format("ByteString[size=%s md5=%s]", arrayOfObject1);
      return str;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
    }
    throw new AssertionError();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     b.j
 * JD-Core Version:    0.6.0
 */