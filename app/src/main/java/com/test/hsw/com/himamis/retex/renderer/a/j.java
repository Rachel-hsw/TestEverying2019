package com.himamis.retex.renderer.a;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public final class j
{
  private static float a(Stack<a> paramStack, at paramat, float paramFloat)
  {
    LinkedList localLinkedList = paramat.k;
    float[] arrayOfFloat = new float[1 + localLinkedList.size()];
    arrayOfFloat[0] = 0.0F;
    for (int i = 0; ; i++)
    {
      if (i >= localLinkedList.size())
        return paramat.f;
      i locali = (i)localLinkedList.get(i);
      arrayOfFloat[(i + 1)] = (arrayOfFloat[i] + locali.f);
      if (arrayOfFloat[(i + 1)] <= paramFloat)
        continue;
      int j = a(paramat, i);
      if ((locali instanceof at))
      {
        Stack localStack = new Stack();
        float f = a(localStack, (at)locali, paramFloat - arrayOfFloat[i]);
        if ((f != locali.f) && ((f + arrayOfFloat[i] <= paramFloat) || (j == -1)))
        {
          paramStack.push(new a(i - 1, paramat));
          paramStack.addAll(localStack);
          return f + arrayOfFloat[i];
        }
      }
      if (j == -1)
        continue;
      paramStack.push(new a(j, paramat));
      return arrayOfFloat[j];
    }
  }

  private static int a(at paramat, int paramInt)
  {
    if (paramat.o == null)
      return -1;
    int i = paramat.o.size();
    int j = 0;
    if (i == 1)
    {
      int k = ((Integer)paramat.o.get(0)).intValue();
      j = 0;
      if (k <= paramInt)
        return ((Integer)paramat.o.get(0)).intValue();
    }
    do
    {
      if (((Integer)paramat.o.get(j)).intValue() > paramInt)
      {
        if (j == 0)
          return -1;
        return ((Integer)paramat.o.get(j - 1)).intValue();
      }
      j++;
    }
    while (j < paramat.o.size());
    return ((Integer)paramat.o.get(j - 1)).intValue();
  }

  public static i a(at paramat, float paramFloat1, float paramFloat2)
  {
    ej localej = new ej();
    Object localObject1 = null;
    Stack localStack = new Stack();
    if ((paramat.f <= paramFloat1) || (a(localStack, paramat, paramFloat1) == paramat.f))
    {
      if (localObject1 != null)
      {
        localej.a((i)localObject1, paramFloat2);
        paramat = localej;
      }
      return paramat;
    }
    a locala1 = (a)localStack.pop();
    at[] arrayOfat1 = locala1.b.b(-1 + locala1.a);
    at localat1 = arrayOfat1[0];
    at localat2 = arrayOfat1[1];
    Object localObject2 = localat1;
    at localat4;
    for (localObject1 = localat2; ; localObject1 = localat4)
    {
      if (localStack.isEmpty())
      {
        localej.a((i)localObject2, paramFloat2);
        paramat = (at)localObject1;
        break;
      }
      a locala2 = (a)localStack.pop();
      at[] arrayOfat2 = locala2.b.c(locala2.a);
      arrayOfat2[0].a((i)localObject2);
      arrayOfat2[1].a(0, (i)localObject1);
      at localat3 = arrayOfat2[0];
      localat4 = arrayOfat2[1];
      localObject2 = localat3;
    }
  }

  private static i a(ej paramej, float paramFloat1, float paramFloat2)
  {
    ej localej = new ej();
    Iterator localIterator = paramej.k.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return localej;
      localej.a(a((i)localIterator.next(), paramFloat1, paramFloat2));
    }
  }

  public static i a(i parami, float paramFloat1, float paramFloat2)
  {
    if ((parami instanceof at))
      parami = a((at)parami, paramFloat1, paramFloat2);
    do
      return parami;
    while (!(parami instanceof ej));
    return a((ej)parami, paramFloat1, paramFloat2);
  }

  private static class a
  {
    int a;
    at b;

    a(int paramInt, at paramat)
    {
      this.a = paramInt;
      this.b = paramat;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.j
 * JD-Core Version:    0.6.0
 */