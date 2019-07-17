package com.umeng.message.b;

import com.squareup.wire.ProtoEnum;
import java.util.Arrays;
import java.util.Comparator;

public final class at<E extends ProtoEnum>
{
  private static final Comparator<ProtoEnum> a = new au();
  private final Class<E> b;
  private final int[] c;
  private final E[] d;
  private final boolean e;

  public at(Class<E> paramClass)
  {
    this.b = paramClass;
    this.d = ((ProtoEnum[])paramClass.getEnumConstants());
    Arrays.sort(this.d, a);
    int i = this.d.length;
    if ((this.d[0].getValue() == 1) && (this.d[(i - 1)].getValue() == i))
    {
      this.e = true;
      this.c = null;
    }
    while (true)
    {
      return;
      this.e = false;
      this.c = new int[i];
      for (int j = 0; j < i; j++)
        this.c[j] = this.d[j].getValue();
    }
  }

  public int a(E paramE)
  {
    return paramE.getValue();
  }

  public E a(int paramInt)
  {
    int i;
    if (this.e)
      i = paramInt - 1;
    try
    {
      while (true)
      {
        ProtoEnum localProtoEnum = this.d[i];
        return localProtoEnum;
        i = Arrays.binarySearch(this.c, paramInt);
      }
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
    }
    throw new IllegalArgumentException("Unknown enum tag " + paramInt + " for " + this.b.getCanonicalName());
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.at
 * JD-Core Version:    0.6.0
 */