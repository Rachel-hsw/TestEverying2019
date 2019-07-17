package org.a.a.a.a;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.a.a.a.c;

public class f extends h
{
  protected String[] a;
  private boolean b = false;
  private boolean c = false;
  private Class<?> d = null;

  public f(Object paramObject)
  {
    super(paramObject);
  }

  public f(Object paramObject, i parami)
  {
    super(paramObject, parami);
  }

  public f(Object paramObject, i parami, StringBuffer paramStringBuffer)
  {
    super(paramObject, parami, paramStringBuffer);
  }

  public <T> f(T paramT, i parami, StringBuffer paramStringBuffer, Class<? super T> paramClass, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramT, parami, paramStringBuffer);
    b(paramClass);
    b(paramBoolean1);
    a(paramBoolean2);
  }

  public static String a(Object paramObject)
  {
    return a(paramObject, null, false, false, null);
  }

  public static String a(Object paramObject, Collection<String> paramCollection)
  {
    return a(paramObject, a(paramCollection));
  }

  public static String a(Object paramObject, i parami)
  {
    return a(paramObject, parami, false, false, null);
  }

  public static String a(Object paramObject, i parami, boolean paramBoolean)
  {
    return a(paramObject, parami, paramBoolean, false, null);
  }

  public static String a(Object paramObject, i parami, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramObject, parami, paramBoolean1, paramBoolean2, null);
  }

  public static <T> String a(T paramT, i parami, boolean paramBoolean1, boolean paramBoolean2, Class<? super T> paramClass)
  {
    return new f(paramT, parami, null, paramClass, paramBoolean1, paramBoolean2).toString();
  }

  public static String a(Object paramObject, String[] paramArrayOfString)
  {
    return new f(paramObject).a(paramArrayOfString).toString();
  }

  static String[] a(Collection<String> paramCollection)
  {
    if (paramCollection == null)
      return c.c;
    return a(paramCollection.toArray());
  }

  static String[] a(Object[] paramArrayOfObject)
  {
    ArrayList localArrayList = new ArrayList(paramArrayOfObject.length);
    int i = paramArrayOfObject.length;
    for (int j = 0; j < i; j++)
    {
      Object localObject = paramArrayOfObject[j];
      if (localObject == null)
        continue;
      localArrayList.add(localObject.toString());
    }
    return (String[])localArrayList.toArray(c.c);
  }

  public f a(String[] paramArrayOfString)
  {
    if (paramArrayOfString == null)
    {
      this.a = null;
      return this;
    }
    this.a = a(paramArrayOfString);
    Arrays.sort(this.a);
    return this;
  }

  protected void a(Class<?> paramClass)
  {
    if (paramClass.isArray())
    {
      b(g());
      return;
    }
    Field[] arrayOfField = paramClass.getDeclaredFields();
    AccessibleObject.setAccessible(arrayOfField, true);
    int i = arrayOfField.length;
    int j = 0;
    while (j < i)
    {
      Field localField = arrayOfField[j];
      String str = localField.getName();
      if (a(localField));
      try
      {
        a(str, b(localField));
        j++;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
      }
    }
    throw new InternalError("Unexpected IllegalAccessException: " + localIllegalAccessException.getMessage());
  }

  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }

  protected boolean a(Field paramField)
  {
    if (paramField.getName().indexOf('$') != -1);
    do
      return false;
    while (((Modifier.isTransient(paramField.getModifiers())) && (!e())) || ((Modifier.isStatic(paramField.getModifiers())) && (!d())) || ((this.a != null) && (Arrays.binarySearch(this.a, paramField.getName()) >= 0)));
    return true;
  }

  protected Object b(Field paramField)
    throws IllegalArgumentException, IllegalAccessException
  {
    return paramField.get(g());
  }

  public f b(Object paramObject)
  {
    i().d(h(), null, paramObject);
    return this;
  }

  public void b(Class<?> paramClass)
  {
    if (paramClass != null)
    {
      Object localObject = g();
      if ((localObject != null) && (!paramClass.isInstance(localObject)))
        throw new IllegalArgumentException("Specified class is not a superclass of the object");
    }
    this.d = paramClass;
  }

  public void b(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }

  public String[] b()
  {
    return (String[])this.a.clone();
  }

  public Class<?> c()
  {
    return this.d;
  }

  public boolean d()
  {
    return this.b;
  }

  public boolean e()
  {
    return this.c;
  }

  public String toString()
  {
    if (g() == null)
      return i().p();
    Class localClass = g().getClass();
    a(localClass);
    while ((localClass.getSuperclass() != null) && (localClass != c()))
    {
      localClass = localClass.getSuperclass();
      a(localClass);
    }
    return super.toString();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.a.f
 * JD-Core Version:    0.6.0
 */