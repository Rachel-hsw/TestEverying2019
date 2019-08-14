package com.tencent.mm.sdk.b;

import java.util.LinkedHashMap;

public final class c<K, V>
{
  private int A;
  private int B;
  private int C;
  private int D;
  private int size;
  private final LinkedHashMap<K, V> u;
  private int v;

  // ERROR //
  private void trimToSize(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 19	com/tencent/mm/sdk/b/c:size	I
    //   6: iflt +20 -> 26
    //   9: aload_0
    //   10: getfield 21	com/tencent/mm/sdk/b/c:u	Ljava/util/LinkedHashMap;
    //   13: invokevirtual 27	java/util/LinkedHashMap:isEmpty	()Z
    //   16: ifeq +48 -> 64
    //   19: aload_0
    //   20: getfield 19	com/tencent/mm/sdk/b/c:size	I
    //   23: ifeq +41 -> 64
    //   26: new 29	java/lang/IllegalStateException
    //   29: dup
    //   30: new 31	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   37: aload_0
    //   38: invokevirtual 39	java/lang/Object:getClass	()Ljava/lang/Class;
    //   41: invokevirtual 45	java/lang/Class:getName	()Ljava/lang/String;
    //   44: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: ldc 51
    //   49: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokespecial 57	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   58: athrow
    //   59: astore_2
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_2
    //   63: athrow
    //   64: aload_0
    //   65: getfield 19	com/tencent/mm/sdk/b/c:size	I
    //   68: iload_1
    //   69: if_icmple +13 -> 82
    //   72: aload_0
    //   73: getfield 21	com/tencent/mm/sdk/b/c:u	Ljava/util/LinkedHashMap;
    //   76: invokevirtual 27	java/util/LinkedHashMap:isEmpty	()Z
    //   79: ifeq +6 -> 85
    //   82: aload_0
    //   83: monitorexit
    //   84: return
    //   85: aload_0
    //   86: getfield 21	com/tencent/mm/sdk/b/c:u	Ljava/util/LinkedHashMap;
    //   89: invokevirtual 61	java/util/LinkedHashMap:entrySet	()Ljava/util/Set;
    //   92: invokeinterface 67 1 0
    //   97: invokeinterface 73 1 0
    //   102: checkcast 75	java/util/Map$Entry
    //   105: astore_3
    //   106: aload_3
    //   107: invokeinterface 78 1 0
    //   112: astore 4
    //   114: aload_3
    //   115: invokeinterface 81 1 0
    //   120: pop
    //   121: aload_0
    //   122: getfield 21	com/tencent/mm/sdk/b/c:u	Ljava/util/LinkedHashMap;
    //   125: aload 4
    //   127: invokevirtual 85	java/util/LinkedHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   130: pop
    //   131: aload_0
    //   132: iconst_m1
    //   133: aload_0
    //   134: getfield 19	com/tencent/mm/sdk/b/c:size	I
    //   137: iadd
    //   138: putfield 19	com/tencent/mm/sdk/b/c:size	I
    //   141: aload_0
    //   142: iconst_1
    //   143: aload_0
    //   144: getfield 87	com/tencent/mm/sdk/b/c:B	I
    //   147: iadd
    //   148: putfield 87	com/tencent/mm/sdk/b/c:B	I
    //   151: aload_0
    //   152: monitorexit
    //   153: goto -153 -> 0
    //
    // Exception table:
    //   from	to	target	type
    //   2	26	59	finally
    //   26	59	59	finally
    //   64	82	59	finally
    //   82	84	59	finally
    //   85	153	59	finally
  }

  public final boolean a(K paramK)
  {
    monitorenter;
    try
    {
      boolean bool = this.u.containsKey(paramK);
      monitorexit;
      return bool;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public final V get(K paramK)
  {
    if (paramK == null)
      throw new NullPointerException("key == null");
    monitorenter;
    try
    {
      Object localObject2 = this.u.get(paramK);
      if (localObject2 != null)
      {
        this.C = (1 + this.C);
        return localObject2;
      }
      this.D = (1 + this.D);
      return null;
    }
    finally
    {
      monitorexit;
    }
    throw localObject1;
  }

  public final V put(K paramK, V paramV)
  {
    if ((paramK == null) || (paramV == null))
      throw new NullPointerException("key == null || value == null");
    monitorenter;
    try
    {
      this.A = (1 + this.A);
      this.size = (1 + this.size);
      Object localObject2 = this.u.put(paramK, paramV);
      if (localObject2 != null)
        this.size = (-1 + this.size);
      monitorexit;
      trimToSize(this.v);
      return localObject2;
    }
    finally
    {
      monitorexit;
    }
    throw localObject1;
  }

  public final String toString()
  {
    monitorenter;
    try
    {
      int i = this.C + this.D;
      int j = 0;
      if (i != 0)
        j = 100 * this.C / i;
      Object[] arrayOfObject = new Object[4];
      arrayOfObject[0] = Integer.valueOf(this.v);
      arrayOfObject[1] = Integer.valueOf(this.C);
      arrayOfObject[2] = Integer.valueOf(this.D);
      arrayOfObject[3] = Integer.valueOf(j);
      String str = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", arrayOfObject);
      return str;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.b.c
 * JD-Core Version:    0.6.0
 */