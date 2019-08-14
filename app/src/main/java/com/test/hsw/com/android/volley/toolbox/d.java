package com.android.volley.toolbox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class d
{
  protected static final Comparator<byte[]> a = new e();
  private List<byte[]> b = new LinkedList();
  private List<byte[]> c = new ArrayList(64);
  private int d = 0;
  private final int e;

  public d(int paramInt)
  {
    this.e = paramInt;
  }

  private void a()
  {
    monitorenter;
    try
    {
      while (true)
      {
        int i = this.d;
        int j = this.e;
        if (i <= j)
          return;
        byte[] arrayOfByte = (byte[])this.b.remove(0);
        this.c.remove(arrayOfByte);
        this.d -= arrayOfByte.length;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public void a(byte[] paramArrayOfByte)
  {
    monitorenter;
    if (paramArrayOfByte != null);
    try
    {
      int i = paramArrayOfByte.length;
      int j = this.e;
      if (i > j);
      while (true)
      {
        return;
        this.b.add(paramArrayOfByte);
        int k = Collections.binarySearch(this.c, paramArrayOfByte, a);
        if (k < 0)
          k = -1 + -k;
        this.c.add(k, paramArrayOfByte);
        this.d += paramArrayOfByte.length;
        a();
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public byte[] a(int paramInt)
  {
    monitorenter;
    for (int i = 0; ; i++)
      try
      {
        byte[] arrayOfByte;
        if (i >= this.c.size())
          arrayOfByte = new byte[paramInt];
        while (true)
        {
          return arrayOfByte;
          arrayOfByte = (byte[])this.c.get(i);
          if (arrayOfByte.length < paramInt)
            break;
          this.d -= arrayOfByte.length;
          this.c.remove(i);
          this.b.remove(arrayOfByte);
        }
      }
      finally
      {
        monitorexit;
      }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.android.volley.toolbox.d
 * JD-Core Version:    0.6.0
 */