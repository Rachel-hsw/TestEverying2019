package org.a.a.a.g;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import org.a.a.a.l;

abstract class c
{
  private static final int a = 7;
  private static final Class<?>[] b;

  static
  {
    Class[] arrayOfClass = new Class[7];
    arrayOfClass[0] = Byte.TYPE;
    arrayOfClass[1] = Short.TYPE;
    arrayOfClass[2] = Character.TYPE;
    arrayOfClass[3] = Integer.TYPE;
    arrayOfClass[4] = Long.TYPE;
    arrayOfClass[5] = Float.TYPE;
    arrayOfClass[6] = Double.TYPE;
    b = arrayOfClass;
  }

  private static float a(Class<?> paramClass1, Class<?> paramClass2)
  {
    if (paramClass2.isPrimitive())
    {
      f = b(paramClass1, paramClass2);
      return f;
    }
    float f = 0.0F;
    while (true)
    {
      if ((paramClass1 != null) && (!paramClass2.equals(paramClass1)))
      {
        if ((paramClass2.isInterface()) && (l.a(paramClass1, paramClass2)))
          f += 0.25F;
      }
      else
      {
        if (paramClass1 != null)
          break;
        return f + 1.5F;
      }
      f += 1.0F;
      paramClass1 = paramClass1.getSuperclass();
    }
  }

  private static float a(Class<?>[] paramArrayOfClass1, Class<?>[] paramArrayOfClass2)
  {
    float f = 0.0F;
    for (int i = 0; i < paramArrayOfClass1.length; i++)
      f += a(paramArrayOfClass1[i], paramArrayOfClass2[i]);
    return f;
  }

  static int a(Class<?>[] paramArrayOfClass1, Class<?>[] paramArrayOfClass2, Class<?>[] paramArrayOfClass3)
  {
    float f1 = a(paramArrayOfClass3, paramArrayOfClass1);
    float f2 = a(paramArrayOfClass3, paramArrayOfClass2);
    if (f1 < f2)
      return -1;
    if (f2 < f1)
      return 1;
    return 0;
  }

  static void a(AccessibleObject paramAccessibleObject)
  {
    if ((paramAccessibleObject == null) || (paramAccessibleObject.isAccessible()));
    Member localMember;
    do
    {
      return;
      localMember = (Member)paramAccessibleObject;
    }
    while ((!Modifier.isPublic(localMember.getModifiers())) || (!a(localMember.getDeclaringClass().getModifiers())));
    try
    {
      paramAccessibleObject.setAccessible(true);
      return;
    }
    catch (SecurityException localSecurityException)
    {
    }
  }

  static boolean a(int paramInt)
  {
    return (paramInt & 0x7) == 0;
  }

  static boolean a(Member paramMember)
  {
    return (paramMember != null) && (Modifier.isPublic(paramMember.getModifiers())) && (!paramMember.isSynthetic());
  }

  private static float b(Class<?> paramClass1, Class<?> paramClass2)
  {
    boolean bool = paramClass1.isPrimitive();
    float f1 = 0.0F;
    if (!bool)
    {
      f1 = 0.0F + 0.1F;
      paramClass1 = l.i(paramClass1);
    }
    int i = 0;
    float f2 = f1;
    Object localObject = paramClass1;
    while ((localObject != paramClass2) && (i < b.length))
    {
      if (localObject == b[i])
      {
        f2 += 0.1F;
        if (i < -1 + b.length)
          localObject = b[(i + 1)];
      }
      i++;
    }
    return f2;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.g.c
 * JD-Core Version:    0.6.0
 */