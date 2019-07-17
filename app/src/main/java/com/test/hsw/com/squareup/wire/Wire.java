package com.squareup.wire;

import com.umeng.message.b.a;
import com.umeng.message.b.ab;
import com.umeng.message.b.at;
import com.umeng.message.b.ct;
import com.umeng.message.b.cv;
import com.umeng.message.b.da;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class Wire
{
  final ct a = new ct();
  private final Map<Class<? extends Message>, MessageAdapter<? extends Message>> b = new LinkedHashMap();
  private final Map<Class<? extends Message.Builder>, a<? extends Message.Builder>> c = new LinkedHashMap();
  private final Map<Class<? extends ProtoEnum>, at<? extends ProtoEnum>> d = new LinkedHashMap();

  public Wire(List<Class<?>> paramList)
  {
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      Field[] arrayOfField = ((Class)localIterator.next()).getDeclaredFields();
      int i = arrayOfField.length;
      int j = 0;
      while (j < i)
      {
        Field localField = arrayOfField[j];
        if (localField.getType().equals(Extension.class));
        try
        {
          Extension localExtension = (Extension)localField.get(null);
          this.a.a(localExtension);
          j++;
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          throw new AssertionError(localIllegalAccessException);
        }
      }
    }
  }

  public Wire(Class<?>[] paramArrayOfClass)
  {
    this(Arrays.asList(paramArrayOfClass));
  }

  private <M extends Message> M a(da paramda, Class<M> paramClass)
    throws IOException
  {
    return a(paramClass).a(paramda);
  }

  public static <T> T get(T paramT1, T paramT2)
  {
    if (paramT1 != null)
      return paramT1;
    return paramT2;
  }

  <M extends Message> MessageAdapter<M> a(Class<M> paramClass)
  {
    monitorenter;
    try
    {
      MessageAdapter localMessageAdapter = (MessageAdapter)this.b.get(paramClass);
      if (localMessageAdapter == null)
      {
        localMessageAdapter = new MessageAdapter(this, paramClass);
        this.b.put(paramClass, localMessageAdapter);
      }
      return localMessageAdapter;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  <B extends Message.Builder> a<B> b(Class<B> paramClass)
  {
    monitorenter;
    try
    {
      a locala = (a)this.c.get(paramClass);
      if (locala == null)
      {
        locala = new a(paramClass);
        this.c.put(paramClass, locala);
      }
      return locala;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  <E extends ProtoEnum> at<E> c(Class<E> paramClass)
  {
    monitorenter;
    try
    {
      at localat = (at)this.d.get(paramClass);
      if (localat == null)
      {
        localat = new at(paramClass);
        this.d.put(paramClass, localat);
      }
      return localat;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public <M extends Message> M parseFrom(ab paramab, Class<M> paramClass)
    throws IOException
  {
    cv.a(paramab, "input");
    cv.a(paramClass, "messageClass");
    return a(da.a(paramab), paramClass);
  }

  public <M extends Message> M parseFrom(InputStream paramInputStream, Class<M> paramClass)
    throws IOException
  {
    cv.a(paramInputStream, "input");
    cv.a(paramClass, "messageClass");
    return a(da.a(paramInputStream), paramClass);
  }

  public <M extends Message> M parseFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2, Class<M> paramClass)
    throws IOException
  {
    boolean bool1 = true;
    cv.a(paramArrayOfByte, "bytes");
    boolean bool2;
    boolean bool3;
    if (paramInt1 >= 0)
    {
      bool2 = bool1;
      cv.a(bool2, "offset < 0");
      if (paramInt2 < 0)
        break label80;
      bool3 = bool1;
      label32: cv.a(bool3, "count < 0");
      if (paramInt1 + paramInt2 > paramArrayOfByte.length)
        break label86;
    }
    while (true)
    {
      cv.a(bool1, "offset + count > bytes");
      cv.a(paramClass, "messageClass");
      return a(da.a(paramArrayOfByte, paramInt1, paramInt2), paramClass);
      bool2 = false;
      break;
      label80: bool3 = false;
      break label32;
      label86: bool1 = false;
    }
  }

  public <M extends Message> M parseFrom(byte[] paramArrayOfByte, Class<M> paramClass)
    throws IOException
  {
    cv.a(paramArrayOfByte, "bytes");
    cv.a(paramClass, "messageClass");
    return a(da.a(paramArrayOfByte), paramClass);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.squareup.wire.Wire
 * JD-Core Version:    0.6.0
 */