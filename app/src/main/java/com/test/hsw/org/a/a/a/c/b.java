package org.a.a.a.c;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.a.a.a.g.d;

public class b
{
  public static <L> void a(Object paramObject, Class<L> paramClass, L paramL)
  {
    try
    {
      d.a(paramObject, "add" + paramClass.getSimpleName(), new Object[] { paramL });
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      throw new IllegalArgumentException("Class " + paramObject.getClass().getName() + " does not have a public add" + paramClass.getSimpleName() + " method which takes a parameter of type " + paramClass.getName() + ".");
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new IllegalArgumentException("Class " + paramObject.getClass().getName() + " does not have an accessible add" + paramClass.getSimpleName() + " method which takes a parameter of type " + paramClass.getName() + ".");
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
    }
    throw new RuntimeException("Unable to add listener.", localInvocationTargetException.getCause());
  }

  public static <L> void a(Object paramObject1, String paramString, Object paramObject2, Class<L> paramClass, String[] paramArrayOfString)
  {
    a(paramObject2, paramClass, paramClass.cast(Proxy.newProxyInstance(paramObject1.getClass().getClassLoader(), new Class[] { paramClass }, new a(paramObject1, paramString, paramArrayOfString))));
  }

  private static class a
    implements InvocationHandler
  {
    private final Object a;
    private final String b;
    private final Set<String> c;

    a(Object paramObject, String paramString, String[] paramArrayOfString)
    {
      this.a = paramObject;
      this.b = paramString;
      this.c = new HashSet(Arrays.asList(paramArrayOfString));
    }

    private boolean a(Method paramMethod)
    {
      return d.a(this.a.getClass(), this.b, paramMethod.getParameterTypes()) != null;
    }

    public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
      throws Throwable
    {
      if ((this.c.isEmpty()) || (this.c.contains(paramMethod.getName())))
      {
        if (a(paramMethod))
          return d.a(this.a, this.b, paramArrayOfObject);
        return d.a(this.a, this.b, new Object[0]);
      }
      return null;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.c.b
 * JD-Core Version:    0.6.0
 */