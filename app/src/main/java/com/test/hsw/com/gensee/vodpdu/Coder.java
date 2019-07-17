package com.gensee.vodpdu;

import com.gensee.utils.GenseeLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.util.ByteArrayBuffer;

public class Coder
{
  private static final String TAG = "Coder";
  private static final int UNSIGNED_NUM = 255;
  private List<Byte> byteList;
  private int lastPos;
  private byte[] stream;

  public Coder()
  {
  }

  public Coder(byte[] paramArrayOfByte)
  {
    this.lastPos = 0;
    this.stream = paramArrayOfByte;
    GenseeLog.d("Coder", "length = " + paramArrayOfByte.length);
  }

  public static byte[] intToByte(int paramInt, ByteArrayBuffer paramByteArrayBuffer)
  {
    byte[] arrayOfByte = new byte[4];
    arrayOfByte[0] = (byte)(paramInt & 0xFF);
    arrayOfByte[1] = (byte)(0xFF & paramInt >> 8);
    arrayOfByte[2] = (byte)(0xFF & paramInt >> 16);
    arrayOfByte[3] = (byte)(0xFF & paramInt >> 24);
    if (paramByteArrayBuffer != null)
      paramByteArrayBuffer.append(arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }

  public static byte[] longToByte(long paramLong, ByteArrayBuffer paramByteArrayBuffer)
  {
    byte[] arrayOfByte = new byte[8];
    arrayOfByte[0] = (byte)(int)(paramLong & 0xFF);
    arrayOfByte[1] = (byte)(int)(0xFF & paramLong >> 8);
    arrayOfByte[2] = (byte)(int)(0xFF & paramLong >> 16);
    arrayOfByte[3] = (byte)(int)(0xFF & paramLong >> 24);
    arrayOfByte[4] = (byte)(int)(0xFF & paramLong >> 32);
    arrayOfByte[5] = (byte)(int)(0xFF & paramLong >> 40);
    arrayOfByte[6] = (byte)(int)(0xFF & paramLong >> 48);
    arrayOfByte[7] = (byte)(int)(0xFF & paramLong >> 56);
    if (paramByteArrayBuffer != null)
      paramByteArrayBuffer.append(arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }

  private void setString(byte[] paramArrayOfByte)
  {
    int i;
    if (paramArrayOfByte != null)
      i = paramArrayOfByte.length;
    for (int j = 0; ; j++)
    {
      if (j >= i)
        return;
      byte b = paramArrayOfByte[j];
      this.byteList.add(Byte.valueOf(b));
    }
  }

  public static byte[] shortToByte(short paramShort, ByteArrayBuffer paramByteArrayBuffer)
  {
    byte[] arrayOfByte = new byte[2];
    arrayOfByte[0] = (byte)(paramShort & 0xFF);
    arrayOfByte[1] = (byte)(0xFF & paramShort >> 8);
    if (paramByteArrayBuffer != null)
      paramByteArrayBuffer.append(arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }

  public String getBigString()
  {
    return getString(getUnsignedInt());
  }

  public boolean getBoolean()
  {
    int i = 0xFF & this.stream[this.lastPos];
    this.lastPos = (1 + this.lastPos);
    return i != 0;
  }

  public short getByte()
  {
    int i = (short)(0xFF & this.stream[this.lastPos]);
    this.lastPos = (1 + this.lastPos);
    return i;
  }

  public byte[] getByteData()
  {
    int i;
    byte[] arrayOfByte;
    if (this.byteList == null)
    {
      i = 0;
      arrayOfByte = new byte[i];
    }
    for (int j = 0; ; j++)
    {
      if (j >= i)
      {
        this.byteList.clear();
        return arrayOfByte;
        i = this.byteList.size();
        break;
      }
      arrayOfByte[j] = ((Byte)this.byteList.get(j)).byteValue();
    }
  }

  public int getColor(boolean paramBoolean)
  {
    int i = 0xFF & this.stream[this.lastPos];
    this.lastPos = (1 + this.lastPos);
    int j = 0xFF & this.stream[this.lastPos];
    this.lastPos = (1 + this.lastPos);
    int k = 0xFF & this.stream[this.lastPos];
    this.lastPos = (1 + this.lastPos);
    int m = 0xFF & this.stream[this.lastPos];
    this.lastPos = (1 + this.lastPos);
    if ((paramBoolean) && (m == 0));
    for (int n = 175; ; n = 255)
      return k | (n << 24 | i << 16 | j << 8);
  }

  public String getData()
  {
    int i;
    if (this.byteList == null)
      i = 0;
    while (true)
      if (i > 0)
      {
        byte[] arrayOfByte = new byte[i];
        int j = 0;
        if (j >= i);
        try
        {
          String str = new String(arrayOfByte, "UTF-8");
          return str;
          i = this.byteList.size();
          continue;
          arrayOfByte[j] = ((Byte)this.byteList.get(j)).byteValue();
          GenseeLog.d("Coder", "b[" + j + "] = " + arrayOfByte[j]);
          j++;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          localUnsupportedEncodingException.printStackTrace();
        }
      }
    return "";
  }

  public int getInt()
  {
    int i = 0xFF & this.stream[this.lastPos];
    this.lastPos = (1 + this.lastPos);
    int j = 0xFF & this.stream[this.lastPos];
    this.lastPos = (1 + this.lastPos);
    int k = 0xFF & this.stream[this.lastPos];
    this.lastPos = (1 + this.lastPos);
    int m = 0xFF & this.stream[this.lastPos];
    this.lastPos = (1 + this.lastPos);
    return i | j << 8 | k << 16 | m << 24;
  }

  public long getLong()
  {
    long l1 = 0xFF & this.stream[this.lastPos];
    this.lastPos = (1 + this.lastPos);
    long l2 = 0xFF & this.stream[this.lastPos];
    this.lastPos = (1 + this.lastPos);
    long l3 = 0xFF & this.stream[this.lastPos];
    this.lastPos = (1 + this.lastPos);
    long l4 = 0xFF & this.stream[this.lastPos];
    this.lastPos = (1 + this.lastPos);
    long l5 = 0xFF & this.stream[this.lastPos];
    this.lastPos = (1 + this.lastPos);
    long l6 = 0xFF & this.stream[this.lastPos];
    this.lastPos = (1 + this.lastPos);
    long l7 = 0xFF & this.stream[this.lastPos];
    this.lastPos = (1 + this.lastPos);
    long l8 = 0xFF & this.stream[this.lastPos];
    this.lastPos = (1 + this.lastPos);
    return l1 | l2 << 8 | l3 << 16 | l4 << 24 | l5 << 32 | l6 << 40 | l7 << 48 | l8 << 56;
  }

  public int getShort()
  {
    int i = (short)(0xFF & this.stream[this.lastPos]);
    this.lastPos = (1 + this.lastPos);
    int j = (short)(0xFF & this.stream[this.lastPos]);
    this.lastPos = (1 + this.lastPos);
    return i | j << 8;
  }

  public String getString()
  {
    return getString(getShort());
  }

  public String getString(long paramLong)
  {
    if (paramLong <= 0L)
      return "";
    byte[] arrayOfByte = new byte[(int)paramLong];
    for (int i = 0; ; i++)
    {
      if (i >= paramLong)
      {
        this.lastPos = (int)(paramLong + this.lastPos);
        return new String(arrayOfByte);
      }
      arrayOfByte[i] = this.stream[(i + this.lastPos)];
    }
  }

  public long getUnsignedInt()
  {
    int i = 0xFF & this.stream[this.lastPos];
    this.lastPos = (1 + this.lastPos);
    int j = 0xFF & this.stream[this.lastPos];
    this.lastPos = (1 + this.lastPos);
    int k = 0xFF & this.stream[this.lastPos];
    this.lastPos = (1 + this.lastPos);
    int m = 0xFF & this.stream[this.lastPos];
    this.lastPos = (1 + this.lastPos);
    return 0xFFFFFFFF & (i | j << 8 | k << 16 | m << 24);
  }

  public byte peekAVtype()
  {
    return this.stream[0];
  }

  public short peekByteType()
  {
    return (short)(0xFF & this.stream[0]);
  }

  public short peekType()
  {
    return (short)(this.stream[1] | this.stream[2] << 8);
  }

  public void reset()
  {
    if (this.byteList != null)
    {
      this.byteList.clear();
      return;
    }
    this.byteList = new ArrayList(0);
  }

  public void setBigString(String paramString)
  {
    byte[] arrayOfByte = paramString.getBytes();
    if (arrayOfByte != null)
    {
      setInt(arrayOfByte.length);
      setString(arrayOfByte);
      return;
    }
    setInt(0);
  }

  public void setBoolean(boolean paramBoolean)
  {
    List localList = this.byteList;
    if (paramBoolean);
    for (int i = 1; ; i = 0)
    {
      localList.add(Byte.valueOf((byte)i));
      return;
    }
  }

  public void setByte(byte paramByte)
  {
    this.byteList.add(Byte.valueOf(paramByte));
  }

  public void setByteArray(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
      paramArrayOfByte.length;
  }

  public void setColor(int paramInt1, int paramInt2)
  {
    int i = (byte)(0xFF & paramInt1 >> 24);
    byte b1 = (byte)(0xFF & paramInt1 >> 16);
    byte b2 = (byte)(0xFF & paramInt1 >> 8);
    byte b3 = (byte)(paramInt1 & 0xFF);
    GenseeLog.d("Coder", "a = " + i);
    if (i != -1);
    for (int j = 0; ; j = 1)
    {
      byte b4 = (byte)j;
      GenseeLog.d("Coder", "a = " + b4);
      this.byteList.add(Byte.valueOf(b1));
      this.byteList.add(Byte.valueOf(b2));
      this.byteList.add(Byte.valueOf(b3));
      this.byteList.add(Byte.valueOf(b4));
      return;
    }
  }

  public void setInt(int paramInt)
  {
    byte b1 = (byte)(paramInt & 0xFF);
    this.byteList.add(Byte.valueOf(b1));
    byte b2 = (byte)(0xFF & paramInt >> 8);
    this.byteList.add(Byte.valueOf(b2));
    byte b3 = (byte)(0xFF & paramInt >> 16);
    this.byteList.add(Byte.valueOf(b3));
    byte b4 = (byte)(0xFF & paramInt >> 24);
    this.byteList.add(Byte.valueOf(b4));
  }

  public void setLong(long paramLong)
  {
    byte b1 = (byte)(int)(paramLong & 0xFF);
    this.byteList.add(Byte.valueOf(b1));
    byte b2 = (byte)(int)(0xFF & paramLong >> 8);
    this.byteList.add(Byte.valueOf(b2));
    byte b3 = (byte)(int)(0xFF & paramLong >> 16);
    this.byteList.add(Byte.valueOf(b3));
    byte b4 = (byte)(int)(0xFF & paramLong >> 24);
    this.byteList.add(Byte.valueOf(b4));
    byte b5 = (byte)(int)(0xFF & paramLong >> 32);
    this.byteList.add(Byte.valueOf(b5));
    byte b6 = (byte)(int)(0xFF & paramLong >> 40);
    this.byteList.add(Byte.valueOf(b6));
    byte b7 = (byte)(int)(0xFF & paramLong >> 48);
    this.byteList.add(Byte.valueOf(b7));
    byte b8 = (byte)(int)(0xFF & paramLong >> 56);
    this.byteList.add(Byte.valueOf(b8));
  }

  public void setShort(short paramShort)
  {
    byte b1 = (byte)(paramShort & 0xFF);
    this.byteList.add(Byte.valueOf(b1));
    byte b2 = (byte)(0xFF & paramShort >> 8);
    this.byteList.add(Byte.valueOf(b2));
  }

  public void setShortString(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString)))
    {
      setShort(0);
      return;
    }
    byte[] arrayOfByte = paramString.getBytes();
    if (arrayOfByte != null)
    {
      setShort((short)arrayOfByte.length);
      setString(arrayOfByte);
      return;
    }
    setShort(0);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.vodpdu.Coder
 * JD-Core Version:    0.6.0
 */