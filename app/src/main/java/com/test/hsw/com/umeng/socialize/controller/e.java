package com.umeng.socialize.controller;

import com.umeng.socialize.bean.ay;
import com.umeng.socialize.utils.i;
import java.lang.reflect.Constructor;

public final class e
{
  private static final String a = a.class.getName();

  public static final Object a(ay paramay, a parama, Object[] paramArrayOfObject)
  {
    return parama.a(paramay, paramArrayOfObject);
  }

  public static enum a
  {
    private static final String f = "com.umeng.socialize.controller.impl.CommentServiceImpl";
    private static final String g = "com.umeng.socialize.controller.impl.LikeServiceImpl";
    private static final String h = "com.umeng.socialize.controller.impl.UserCenterServiceImpl";

    static
    {
      a[] arrayOfa = new a[5];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
      arrayOfa[4] = e;
      i = arrayOfa;
    }

    public Object a(ay paramay, Object[] paramArrayOfObject)
    {
      return null;
    }

    public Object a(String paramString, ay paramay, Object[] paramArrayOfObject)
    {
      try
      {
        Class localClass = Class.forName(paramString);
        if (this == e)
        {
          Constructor localConstructor = localClass.getConstructor(new Class[] { ay.class, AuthService.class });
          Object[] arrayOfObject = new Object[2];
          arrayOfObject[0] = paramay;
          arrayOfObject[1] = paramArrayOfObject[0];
          return localConstructor.newInstance(arrayOfObject);
        }
        Object localObject = localClass.getConstructor(new Class[] { ay.class }).newInstance(new Object[] { paramay });
        return localObject;
      }
      catch (Exception localException)
      {
      }
      return b(paramay, paramArrayOfObject);
    }

    protected void a(String paramString)
    {
      i.e(e.a(), paramString);
    }

    protected Object b(ay paramay, Object[] paramArrayOfObject)
    {
      return null;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.controller.e
 * JD-Core Version:    0.6.0
 */