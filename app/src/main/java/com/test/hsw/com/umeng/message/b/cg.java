package com.umeng.message.b;

import com.squareup.wire.ExtendableMessage;
import com.squareup.wire.Extension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class cg<T extends ExtendableMessage<?>>
{
  private static final int a = 1;
  private Object[] b;
  private int c;

  public <E> cg(Extension<T, E> paramExtension, E paramE)
  {
    this.b = new Object[2];
    this.b[0] = paramExtension;
    this.b[1] = paramE;
    this.c = 1;
  }

  public cg(cg<T> paramcg)
  {
    this.b = ((Object[])paramcg.b.clone());
    this.c = paramcg.c;
  }

  private <E> void a(Extension<T, E> paramExtension, E paramE, int paramInt)
  {
    Object[] arrayOfObject = this.b;
    if (this.b.length < 2 * (1 + this.c))
    {
      arrayOfObject = new Object[2 * this.b.length];
      System.arraycopy(this.b, 0, arrayOfObject, 0, paramInt);
    }
    if (paramInt < this.c)
    {
      System.arraycopy(this.b, paramInt + this.c, arrayOfObject, 2 + (paramInt + this.c), this.c - paramInt);
      System.arraycopy(this.b, paramInt, arrayOfObject, paramInt + 1, this.c);
    }
    while (true)
    {
      this.c = (1 + this.c);
      this.b = arrayOfObject;
      this.b[paramInt] = paramExtension;
      this.b[(paramInt + this.c)] = paramE;
      return;
      System.arraycopy(this.b, this.c, arrayOfObject, 1 + this.c, this.c);
    }
  }

  public int a()
  {
    return this.c;
  }

  public Extension<T, ?> a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.c))
      throw new IndexOutOfBoundsException("" + paramInt);
    return (Extension)this.b[paramInt];
  }

  public <E> E a(Extension<T, E> paramExtension)
  {
    int i = Arrays.binarySearch(this.b, 0, this.c, paramExtension);
    if (i < 0)
      return null;
    return this.b[(i + this.c)];
  }

  public <E> void a(Extension<T, E> paramExtension, E paramE)
  {
    int i = Arrays.binarySearch(this.b, 0, this.c, paramExtension);
    if (i >= 0)
    {
      this.b[(i + this.c)] = paramE;
      return;
    }
    a(paramExtension, paramE, -(i + 1));
  }

  public Object b(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.c))
      throw new IndexOutOfBoundsException("" + paramInt);
    return this.b[(paramInt + this.c)];
  }

  public List<Extension<T, ?>> b()
  {
    ArrayList localArrayList = new ArrayList(this.c);
    for (int i = 0; i < this.c; i++)
      localArrayList.add((Extension)this.b[i]);
    return Collections.unmodifiableList(localArrayList);
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof cg));
    cg localcg;
    do
    {
      return false;
      localcg = (cg)paramObject;
    }
    while (this.c != localcg.c);
    for (int i = 0; ; i++)
    {
      if (i >= 2 * this.c)
        break label61;
      if (!this.b[i].equals(localcg.b[i]))
        break;
    }
    label61: return true;
  }

  public int hashCode()
  {
    int i = 0;
    int j = 0;
    while (i < 2 * this.c)
    {
      j = j * 37 + this.b[i].hashCode();
      i++;
    }
    return j;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{");
    String str = "";
    int i = 0;
    while (i < this.c)
    {
      localStringBuilder.append(str);
      localStringBuilder.append(((Extension)this.b[i]).getTag());
      localStringBuilder.append("=");
      localStringBuilder.append(this.b[(i + this.c)]);
      i++;
      str = ", ";
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.cg
 * JD-Core Version:    0.6.0
 */