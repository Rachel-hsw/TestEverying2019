package c.a;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class cr
{
  public static cq a(Class<? extends cq> paramClass, int paramInt)
  {
    try
    {
      Class[] arrayOfClass = new Class[1];
      arrayOfClass[0] = Integer.TYPE;
      Method localMethod = paramClass.getMethod("findByValue", arrayOfClass);
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(paramInt);
      cq localcq = (cq)localMethod.invoke(null, arrayOfObject);
      return localcq;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      return null;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      return null;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
    }
    return null;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     c.a.cr
 * JD-Core Version:    0.6.0
 */