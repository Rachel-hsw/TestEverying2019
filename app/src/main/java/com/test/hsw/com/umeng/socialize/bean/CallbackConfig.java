package com.umeng.socialize.bean;

import com.umeng.socialize.a.a;
import com.umeng.socialize.controller.listener.SocializeListeners.MulStatusListener;
import com.umeng.socialize.controller.listener.SocializeListeners.SnsPostListener;
import com.umeng.socialize.controller.listener.SocializeListeners.SocializeClientListener;
import com.umeng.socialize.controller.listener.SocializeListeners.UMAuthListener;
import com.umeng.socialize.utils.i;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public class CallbackConfig
{
  public static final int a = 1;
  public static final int b = 16;
  public static final Map<ICallbackListener, Integer[]> d = Collections.synchronizedMap(new WeakHashMap());
  public static final Map<ICallbackListener, Integer[]> e = Collections.synchronizedMap(new HashMap());
  private static final int f = 30;
  private static final int g = 15;
  private static final int h = 240;
  private static final int i = 256;
  private static final int j = 512;
  private static final int k = 768;
  private static final int l = 1024;
  private static final int m = 3840;
  protected boolean c = true;

  private boolean a(int paramInt)
  {
    monitorenter;
    if ((paramInt & 0xF0) == 16);
    try
    {
      Iterator localIterator1 = d.keySet().iterator();
      boolean bool1;
      while (localIterator1.hasNext())
      {
        ICallbackListener localICallbackListener2 = (ICallbackListener)localIterator1.next();
        Integer[] arrayOfInteger2 = (Integer[])d.get(localICallbackListener2);
        if (arrayOfInteger2 == null)
          continue;
        boolean bool3 = a(paramInt, arrayOfInteger2[0].intValue());
        if (bool3)
          d.remove(localICallbackListener2);
        bool1 = bool3;
      }
      while (true)
      {
        return bool1;
        Iterator localIterator2 = e.keySet().iterator();
        while (true)
          if (localIterator2.hasNext())
          {
            ICallbackListener localICallbackListener1 = (ICallbackListener)localIterator2.next();
            Integer[] arrayOfInteger1 = (Integer[])e.get(localICallbackListener1);
            if (arrayOfInteger1 == null)
              continue;
            boolean bool2 = a(paramInt, arrayOfInteger1[0].intValue());
            if (bool2)
              e.remove(localICallbackListener1);
            bool1 = bool2;
            break;
          }
        bool1 = false;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private boolean a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 & 0xF) == (paramInt2 & 0xF));
    for (int n = 1; (n != 0) && ((paramInt2 & 0xF0) == 16) && ((paramInt2 & 0xF00) == (paramInt1 & 0xF00)); n = 0)
      return true;
    return false;
  }

  private boolean a(ICallbackListener paramICallbackListener, boolean paramBoolean, int paramInt)
    throws a
  {
    monitorenter;
    while (true)
    {
      int i1;
      try
      {
        i.b("--->", " regist listener :  " + paramICallbackListener);
        n = 0;
        if (paramICallbackListener == null)
          return n;
        if (paramBoolean)
        {
          localMap = d;
          i1 = paramInt | e(paramICallbackListener);
          if (!c(paramICallbackListener, paramInt))
            break label90;
          throw new a("该类型监听器已经超过最大使用量,请注销不使用的监听器再试。");
        }
      }
      finally
      {
        monitorexit;
      }
      Map localMap = e;
      continue;
      label90: a(i1);
      Integer[] arrayOfInteger = new Integer[2];
      arrayOfInteger[0] = Integer.valueOf(i1);
      if (c(paramICallbackListener) >= 0)
      {
        i.a("com.umeng.socialize", "The callback-listener has exist in the pool,resgister will update permission flag.");
        localMap.put(paramICallbackListener, arrayOfInteger);
        n = 0;
        continue;
      }
      int n = 1;
    }
  }

  private boolean a(Class<?> paramClass1, Class<?> paramClass2)
  {
    Class[] arrayOfClass = paramClass1.getInterfaces();
    int n = 0;
    int i1;
    if (arrayOfClass != null)
      i1 = arrayOfClass.length;
    for (int i2 = 0; ; i2++)
    {
      n = 0;
      if (i2 < i1)
      {
        if (arrayOfClass[i2] != paramClass2)
          continue;
        n = 1;
      }
      return n;
    }
  }

  private boolean c(ICallbackListener paramICallbackListener, int paramInt)
    throws a
  {
    Object localObject;
    if ((paramICallbackListener instanceof SocializeListeners.SnsPostListener))
      localObject = SocializeListeners.SnsPostListener.class;
    while (29 < a((Class)localObject).length)
    {
      return true;
      if ((paramICallbackListener instanceof SocializeListeners.SocializeClientListener))
      {
        localObject = SocializeListeners.SocializeClientListener.class;
        continue;
      }
      if ((paramICallbackListener instanceof SocializeListeners.MulStatusListener))
      {
        localObject = SocializeListeners.MulStatusListener.class;
        continue;
      }
      if ((paramICallbackListener instanceof SocializeListeners.UMAuthListener))
      {
        localObject = SocializeListeners.UMAuthListener.class;
        continue;
      }
      throw new a("unknow listener`s class.");
    }
    return false;
  }

  private int e(ICallbackListener paramICallbackListener)
    throws a
  {
    if ((paramICallbackListener instanceof SocializeListeners.SnsPostListener))
      return 512;
    if ((paramICallbackListener instanceof SocializeListeners.SocializeClientListener))
      return 768;
    if ((paramICallbackListener instanceof SocializeListeners.MulStatusListener))
      return 256;
    if ((paramICallbackListener instanceof SocializeListeners.UMAuthListener))
      return 1024;
    throw new a("unknow params");
  }

  public void a(ICallbackListener[] paramArrayOfICallbackListener)
  {
    if (paramArrayOfICallbackListener != null)
    {
      int n = paramArrayOfICallbackListener.length;
      for (int i1 = 0; i1 < n; i1++)
        d(paramArrayOfICallbackListener[i1]);
    }
  }

  public boolean a()
  {
    try
    {
      d.clear();
      e.clear();
      return true;
    }
    catch (Exception localException)
    {
      i.b("com.umeng.socialize", "", localException);
    }
    return false;
  }

  public boolean a(ICallbackListener paramICallbackListener)
    throws a
  {
    monitorenter;
    try
    {
      boolean bool = a(paramICallbackListener, true, 0);
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

  public boolean a(ICallbackListener paramICallbackListener, int paramInt)
    throws a
  {
    monitorenter;
    try
    {
      boolean bool = a(paramICallbackListener, true, paramInt);
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

  public <T> T[] a(Class<T> paramClass)
    throws a
  {
    HashSet localHashSet = new HashSet();
    if (!a(paramClass, ICallbackListener.class))
      throw new a("The param is not implements ICallbackLister.");
    try
    {
      Iterator localIterator1 = d.keySet().iterator();
      while (localIterator1.hasNext())
      {
        ICallbackListener localICallbackListener2 = (ICallbackListener)localIterator1.next();
        if (!paramClass.isInstance(localICallbackListener2))
          continue;
        localHashSet.add(localICallbackListener2);
      }
    }
    catch (Exception localException)
    {
      i.e("com.umeng.socialize", "", localException);
    }
    while (true)
    {
      return localHashSet.toArray((Object[])(Object[])Array.newInstance(paramClass, localHashSet.size()));
      Iterator localIterator2 = e.keySet().iterator();
      while (localIterator2.hasNext())
      {
        ICallbackListener localICallbackListener1 = (ICallbackListener)localIterator2.next();
        if (!paramClass.isInstance(localICallbackListener1))
          continue;
        localHashSet.add(localICallbackListener1);
      }
    }
  }

  public boolean b(ICallbackListener paramICallbackListener)
    throws a
  {
    monitorenter;
    try
    {
      boolean bool = a(paramICallbackListener, false, 0);
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

  public boolean b(ICallbackListener paramICallbackListener, int paramInt)
    throws a
  {
    monitorenter;
    try
    {
      boolean bool = a(paramICallbackListener, false, paramInt);
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

  public int c(ICallbackListener paramICallbackListener)
  {
    monitorenter;
    try
    {
      boolean bool1 = d.containsKey(paramICallbackListener);
      int n = 0;
      if (bool1)
        n = 1;
      boolean bool2 = e.containsKey(paramICallbackListener);
      if (bool2)
        n += 2;
      return n;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public boolean d(ICallbackListener paramICallbackListener)
  {
    try
    {
      boolean bool = e.containsKey(paramICallbackListener);
      Integer[] arrayOfInteger = null;
      if (bool)
        arrayOfInteger = (Integer[])e.remove(paramICallbackListener);
      if ((d.containsKey(paramICallbackListener)) && (arrayOfInteger == null))
        arrayOfInteger = (Integer[])d.remove(paramICallbackListener);
      return arrayOfInteger != null;
    }
    catch (Exception localException)
    {
      i.e("com.umeng.socialize", "", localException);
    }
    return false;
  }

  public static abstract interface ICallbackListener
  {
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.bean.CallbackConfig
 * JD-Core Version:    0.6.0
 */