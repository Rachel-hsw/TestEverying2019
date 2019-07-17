package com.squareup.wire;

import com.umeng.message.b.at;
import com.umeng.message.b.cg;
import com.umeng.message.b.ct;
import com.umeng.message.b.cw;
import com.umeng.message.b.cy;
import com.umeng.message.b.da;
import com.umeng.message.b.j;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;

final class MessageAdapter<M extends Message>
{
  private static final String a = "█";
  private static final String b = "██";
  private final Wire c;
  private final Class<M> d;
  private final Class<Message.Builder<M>> e;
  private final Map<String, Integer> f = new LinkedHashMap();
  private final cw<FieldInfo> g;

  MessageAdapter(Wire paramWire, Class<M> paramClass)
  {
    this.c = paramWire;
    this.d = paramClass;
    this.e = a(paramClass);
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Field[] arrayOfField = paramClass.getDeclaredFields();
    int i = arrayOfField.length;
    int j = 0;
    if (j < i)
    {
      Field localField = arrayOfField[j];
      ProtoField localProtoField = (ProtoField)localField.getAnnotation(ProtoField.class);
      int k;
      String str;
      Message.Datatype localDatatype1;
      Class localClass;
      if (localProtoField != null)
      {
        k = localProtoField.tag();
        str = localField.getName();
        this.f.put(str, Integer.valueOf(k));
        localDatatype1 = localProtoField.type();
        if (localDatatype1 != Message.Datatype.ENUM)
          break label201;
        localClass = b(localField);
      }
      while (true)
      {
        localLinkedHashMap.put(Integer.valueOf(k), new FieldInfo(k, str, localDatatype1, localProtoField.label(), localProtoField.redacted(), localClass, localField, c(str), null));
        j++;
        break;
        label201: Message.Datatype localDatatype2 = Message.Datatype.MESSAGE;
        localClass = null;
        if (localDatatype1 != localDatatype2)
          continue;
        localClass = a(localField);
      }
    }
    this.g = cw.a(localLinkedHashMap);
  }

  private int a(int paramInt, Object paramObject, Message.Datatype paramDatatype)
  {
    return WireOutput.a(paramInt) + a(paramObject, paramDatatype);
  }

  private <E extends ProtoEnum> int a(E paramE)
  {
    return WireOutput.b(this.c.c(paramE.getClass()).a(paramE));
  }

  private <T extends ExtendableMessage<?>> int a(cg<T> paramcg)
  {
    int i = 0;
    int j = 0;
    if (i < paramcg.a())
    {
      Extension localExtension = paramcg.a(i);
      Object localObject = paramcg.b(i);
      int k = localExtension.getTag();
      Message.Datatype localDatatype = localExtension.getDatatype();
      Message.Label localLabel = localExtension.getLabel();
      if (localLabel.isRepeated())
        if (localLabel.isPacked())
          j += b((List)localObject, k, localDatatype);
      while (true)
      {
        i++;
        break;
        j += a((List)localObject, k, localDatatype);
        continue;
        j += a(k, localObject, localDatatype);
      }
    }
    return j;
  }

  private int a(Object paramObject, Message.Datatype paramDatatype)
  {
    switch (MessageAdapter.1.a[paramDatatype.ordinal()])
    {
    default:
      throw new RuntimeException();
    case 1:
      return WireOutput.int32Size(((Integer)paramObject).intValue());
    case 2:
    case 3:
      return WireOutput.a(((Long)paramObject).longValue());
    case 4:
      return WireOutput.b(((Integer)paramObject).intValue());
    case 5:
      return WireOutput.b(WireOutput.g(((Integer)paramObject).intValue()));
    case 6:
      return WireOutput.a(WireOutput.d(((Long)paramObject).longValue()));
    case 7:
      return 1;
    case 8:
      return a((ProtoEnum)paramObject);
    case 9:
      int j = d((String)paramObject);
      return j + WireOutput.b(j);
    case 10:
      int i = ((j)paramObject).f();
      return i + WireOutput.b(i);
    case 11:
      return d((Message)paramObject);
    case 12:
    case 13:
    case 14:
      return 4;
    case 15:
    case 16:
    case 17:
    }
    return 8;
  }

  private int a(List<?> paramList, int paramInt, Message.Datatype paramDatatype)
  {
    int i = 0;
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
      i += a(paramInt, localIterator.next(), paramDatatype);
    return i;
  }

  private Message a(da paramda, int paramInt)
    throws IOException
  {
    int i = paramda.d();
    if (paramda.b >= 64)
      throw new IOException("Wire recursion limit exceeded");
    int j = paramda.d(i);
    paramda.b = (1 + paramda.b);
    Message localMessage = a(paramInt).a(paramda);
    paramda.a(0);
    paramda.b = (-1 + paramda.b);
    paramda.e(j);
    return localMessage;
  }

  private MessageAdapter<? extends Message> a(int paramInt)
  {
    FieldInfo localFieldInfo = (FieldInfo)this.g.a(paramInt);
    if ((localFieldInfo != null) && (localFieldInfo.h != null))
      return localFieldInfo.h;
    MessageAdapter localMessageAdapter = this.c.a(c(paramInt));
    if (localFieldInfo != null)
      localFieldInfo.h = localMessageAdapter;
    return localMessageAdapter;
  }

  private Class<Message.Builder<M>> a(Class<M> paramClass)
  {
    try
    {
      Class localClass = Class.forName(paramClass.getName() + "$Builder");
      return localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
    }
    throw new IllegalArgumentException("No builder class found for message type " + paramClass.getName());
  }

  private Class<? extends Message> a(Field paramField)
  {
    Class localClass = paramField.getType();
    if (Message.class.isAssignableFrom(localClass))
      return localClass;
    if (List.class.isAssignableFrom(localClass))
      return ((ProtoField)paramField.getAnnotation(ProtoField.class)).messageType();
    return null;
  }

  private Object a(da paramda, int paramInt, Message.Datatype paramDatatype)
    throws IOException
  {
    switch (MessageAdapter.1.a[paramDatatype.ordinal()])
    {
    default:
      throw new RuntimeException();
    case 1:
    case 4:
      return Integer.valueOf(paramda.d());
    case 2:
    case 3:
      return Long.valueOf(paramda.e());
    case 5:
      return Integer.valueOf(da.c(paramda.d()));
    case 6:
      return Long.valueOf(da.a(paramda.e()));
    case 7:
      if (paramda.d() != 0);
      for (boolean bool = true; ; bool = false)
        return Boolean.valueOf(bool);
    case 8:
      at localat = b(paramInt);
      int i = paramda.d();
      try
      {
        ProtoEnum localProtoEnum = localat.a(i);
        return localProtoEnum;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        return Integer.valueOf(i);
      }
    case 9:
      return paramda.b();
    case 10:
      return paramda.c();
    case 11:
      return a(paramda, paramInt);
    case 12:
    case 13:
      return Integer.valueOf(paramda.f());
    case 15:
    case 16:
      return Long.valueOf(paramda.g());
    case 14:
      return Float.valueOf(Float.intBitsToFloat(paramda.f()));
    case 17:
    }
    return Double.valueOf(Double.longBitsToDouble(paramda.g()));
  }

  private void a(ExtendableMessage.ExtendableBuilder paramExtendableBuilder, Extension<?, ?> paramExtension, Object paramObject)
  {
    paramExtendableBuilder.setExtension(paramExtension, paramObject);
  }

  private void a(Message.Builder paramBuilder, da paramda, int paramInt, WireType paramWireType)
    throws IOException
  {
    switch (MessageAdapter.1.b[paramWireType.ordinal()])
    {
    default:
      throw new RuntimeException("Unsupported wire type: " + paramWireType);
    case 1:
      paramBuilder.a().a(paramInt, Long.valueOf(paramda.e()));
    case 6:
      return;
    case 2:
      paramBuilder.a().a(paramInt, Integer.valueOf(paramda.f()));
      return;
    case 3:
      paramBuilder.a().b(paramInt, Long.valueOf(paramda.g()));
      return;
    case 4:
      int i = paramda.d();
      paramBuilder.a().a(paramInt, paramda.b(i));
      return;
    case 5:
    }
    paramda.i();
  }

  private <E extends ProtoEnum> void a(E paramE, WireOutput paramWireOutput)
    throws IOException
  {
    paramWireOutput.e(this.c.c(paramE.getClass()).a(paramE));
  }

  private void a(WireOutput paramWireOutput, int paramInt, Object paramObject, Message.Datatype paramDatatype)
    throws IOException
  {
    paramWireOutput.a(paramInt, paramDatatype.wireType());
    a(paramWireOutput, paramObject, paramDatatype);
  }

  private <T extends ExtendableMessage<?>> void a(WireOutput paramWireOutput, cg<T> paramcg)
    throws IOException
  {
    int i = 0;
    if (i < paramcg.a())
    {
      Extension localExtension = paramcg.a(i);
      Object localObject = paramcg.b(i);
      int j = localExtension.getTag();
      Message.Datatype localDatatype = localExtension.getDatatype();
      Message.Label localLabel = localExtension.getLabel();
      if (localLabel.isRepeated())
        if (localLabel.isPacked())
          b(paramWireOutput, (List)localObject, j, localDatatype);
      while (true)
      {
        i++;
        break;
        a(paramWireOutput, (List)localObject, j, localDatatype);
        continue;
        a(paramWireOutput, j, localObject, localDatatype);
      }
    }
  }

  private void a(WireOutput paramWireOutput, Object paramObject, Message.Datatype paramDatatype)
    throws IOException
  {
    switch (MessageAdapter.1.a[paramDatatype.ordinal()])
    {
    default:
      throw new RuntimeException();
    case 1:
      paramWireOutput.d(((Integer)paramObject).intValue());
      return;
    case 2:
    case 3:
      paramWireOutput.b(((Long)paramObject).longValue());
      return;
    case 4:
      paramWireOutput.e(((Integer)paramObject).intValue());
      return;
    case 5:
      paramWireOutput.e(WireOutput.g(((Integer)paramObject).intValue()));
      return;
    case 6:
      paramWireOutput.b(WireOutput.d(((Long)paramObject).longValue()));
      return;
    case 7:
      if (((Boolean)paramObject).booleanValue());
      for (int i = 1; ; i = 0)
      {
        paramWireOutput.c(i);
        return;
      }
    case 8:
      a((ProtoEnum)paramObject, paramWireOutput);
      return;
    case 9:
      byte[] arrayOfByte = ((String)paramObject).getBytes("UTF-8");
      paramWireOutput.e(arrayOfByte.length);
      paramWireOutput.b(arrayOfByte);
      return;
    case 10:
      j localj = (j)paramObject;
      paramWireOutput.e(localj.f());
      paramWireOutput.b(localj.g());
      return;
    case 11:
      b((Message)paramObject, paramWireOutput);
      return;
    case 12:
    case 13:
      paramWireOutput.f(((Integer)paramObject).intValue());
      return;
    case 15:
    case 16:
      paramWireOutput.c(((Long)paramObject).longValue());
      return;
    case 14:
      paramWireOutput.f(Float.floatToIntBits(((Float)paramObject).floatValue()));
      return;
    case 17:
    }
    paramWireOutput.c(Double.doubleToLongBits(((Double)paramObject).doubleValue()));
  }

  private void a(WireOutput paramWireOutput, List<?> paramList, int paramInt, Message.Datatype paramDatatype)
    throws IOException
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
      a(paramWireOutput, paramInt, localIterator.next(), paramDatatype);
  }

  private int b(List<?> paramList, int paramInt, Message.Datatype paramDatatype)
  {
    int i = 0;
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
      i += a(localIterator.next(), paramDatatype);
    return i + (WireOutput.b(WireOutput.makeTag(paramInt, WireType.LENGTH_DELIMITED)) + WireOutput.b(i));
  }

  private at<? extends ProtoEnum> b(int paramInt)
  {
    FieldInfo localFieldInfo = (FieldInfo)this.g.a(paramInt);
    if ((localFieldInfo != null) && (localFieldInfo.i != null))
      return localFieldInfo.i;
    at localat = this.c.c(e(paramInt));
    if (localFieldInfo != null)
      localFieldInfo.i = localat;
    return localat;
  }

  private Class<? extends Enum> b(Field paramField)
  {
    Class localClass = paramField.getType();
    if (Enum.class.isAssignableFrom(localClass))
      return localClass;
    if (List.class.isAssignableFrom(localClass))
      return ((ProtoField)paramField.getAnnotation(ProtoField.class)).enumType();
    return null;
  }

  private <M extends Message> void b(M paramM, WireOutput paramWireOutput)
    throws IOException
  {
    paramWireOutput.e(paramM.getSerializedSize());
    this.c.a(paramM.getClass()).a(paramM, paramWireOutput);
  }

  private void b(WireOutput paramWireOutput, List<?> paramList, int paramInt, Message.Datatype paramDatatype)
    throws IOException
  {
    int i = 0;
    Iterator localIterator1 = paramList.iterator();
    while (localIterator1.hasNext())
      i += a(localIterator1.next(), paramDatatype);
    paramWireOutput.a(paramInt, WireType.LENGTH_DELIMITED);
    paramWireOutput.e(i);
    Iterator localIterator2 = paramList.iterator();
    while (localIterator2.hasNext())
      a(paramWireOutput, localIterator2.next(), paramDatatype);
  }

  private Class<Message> c(int paramInt)
  {
    FieldInfo localFieldInfo = (FieldInfo)this.g.a(paramInt);
    if (localFieldInfo == null);
    for (Class localClass = null; ; localClass = localFieldInfo.f)
    {
      if (localClass == null)
      {
        Extension localExtension = d(paramInt);
        if (localExtension != null)
          localClass = localExtension.getMessageType();
      }
      return localClass;
    }
  }

  private Field c(String paramString)
  {
    try
    {
      Field localField = this.e.getField(paramString);
      return localField;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
    }
    throw new AssertionError("No builder field " + this.e.getName() + "." + paramString);
  }

  private <M extends Message> int d(M paramM)
  {
    int i = paramM.getSerializedSize();
    return i + WireOutput.b(i);
  }

  private int d(String paramString)
  {
    int i = 0;
    int j = paramString.length();
    int k = 0;
    if (i < j)
    {
      int m = paramString.charAt(i);
      if (m <= 127)
        k++;
      while (true)
      {
        i++;
        break;
        if (m <= 2047)
        {
          k += 2;
          continue;
        }
        if (Character.isHighSurrogate(m))
        {
          k += 4;
          i++;
          continue;
        }
        k += 3;
      }
    }
    return k;
  }

  private Extension<ExtendableMessage<?>, ?> d(int paramInt)
  {
    ct localct = this.c.a;
    if (localct == null)
      return null;
    return localct.a(this.d, paramInt);
  }

  private Class<? extends ProtoEnum> e(int paramInt)
  {
    FieldInfo localFieldInfo = (FieldInfo)this.g.a(paramInt);
    if (localFieldInfo == null);
    for (Class localClass = null; ; localClass = localFieldInfo.e)
    {
      if (localClass == null)
      {
        Extension localExtension = d(paramInt);
        if (localExtension != null)
          localClass = localExtension.getEnumType();
      }
      return localClass;
    }
  }

  int a(M paramM)
  {
    Iterator localIterator = b().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      FieldInfo localFieldInfo = (FieldInfo)localIterator.next();
      Object localObject = a(paramM, localFieldInfo);
      if (localObject == null)
        continue;
      int j = localFieldInfo.a;
      Message.Datatype localDatatype = localFieldInfo.c;
      Message.Label localLabel = localFieldInfo.d;
      int k;
      if (localLabel.isRepeated())
        if (localLabel.isPacked())
          k = i + b((List)localObject, j, localDatatype);
      while (true)
      {
        i = k;
        break;
        k = i + a((List)localObject, j, localDatatype);
        continue;
        k = i + a(j, localObject, localDatatype);
      }
    }
    if ((paramM instanceof ExtendableMessage))
    {
      ExtendableMessage localExtendableMessage = (ExtendableMessage)paramM;
      if (localExtendableMessage.a != null)
        i += a(localExtendableMessage.a);
    }
    return i + paramM.getUnknownFieldsSerializedSize();
  }

  Message.Builder<M> a()
  {
    try
    {
      Message.Builder localBuilder = (Message.Builder)this.e.newInstance();
      return localBuilder;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new AssertionError(localIllegalAccessException);
    }
    catch (InstantiationException localInstantiationException)
    {
    }
    throw new AssertionError(localInstantiationException);
  }

  M a(da paramda)
    throws IOException
  {
    while (true)
    {
      Message.Builder localBuilder;
      b localb;
      int j;
      WireType localWireType;
      try
      {
        localBuilder = (Message.Builder)this.e.newInstance();
        localb = new b(null);
        int i = paramda.a();
        j = i >> 3;
        localWireType = WireType.valueOf(i);
        if (j != 0)
          break label164;
        Iterator localIterator = localb.a().iterator();
        if (localIterator.hasNext())
        {
          k = ((Integer)localIterator.next()).intValue();
          if (!this.g.b(k))
            continue;
          a(localBuilder, k, localb.a(k));
          continue;
        }
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        int k;
        throw new RuntimeException(localIllegalAccessException);
        a((ExtendableMessage.ExtendableBuilder)localBuilder, d(k), localb.a(k));
        continue;
      }
      catch (InstantiationException localInstantiationException)
      {
        throw new RuntimeException(localInstantiationException);
      }
      return localBuilder.build();
      label164: FieldInfo localFieldInfo = (FieldInfo)this.g.a(j);
      Object localObject1;
      Object localObject2;
      Object localObject3;
      label208: int m;
      long l;
      int n;
      if (localFieldInfo != null)
      {
        Message.Datatype localDatatype1 = localFieldInfo.c;
        Message.Label localLabel1 = localFieldInfo.d;
        localObject1 = localDatatype1;
        localObject2 = null;
        localObject3 = localLabel1;
        if ((((Message.Label)localObject3).isPacked()) && (localWireType == WireType.LENGTH_DELIMITED))
        {
          m = paramda.d();
          l = paramda.h();
          n = paramda.d(m);
        }
      }
      else
      {
        while (true)
        {
          if (paramda.h() >= l + m)
            break label372;
          Object localObject5 = a(paramda, j, (Message.Datatype)localObject1);
          if ((localObject1 == Message.Datatype.ENUM) && ((localObject5 instanceof Integer)))
          {
            localBuilder.addVarint(j, ((Integer)localObject5).intValue());
            continue;
            Extension localExtension = d(j);
            if (localExtension == null)
            {
              a(localBuilder, paramda, j, localWireType);
              break;
            }
            Message.Datatype localDatatype2 = localExtension.getDatatype();
            Message.Label localLabel2 = localExtension.getLabel();
            localObject2 = localExtension;
            localObject1 = localDatatype2;
            localObject3 = localLabel2;
            break label208;
          }
          localb.a(j, localObject5);
        }
        label372: paramda.e(n);
        if (paramda.h() == l + m)
          continue;
        throw new IOException("Packed data had wrong length!");
      }
      Object localObject4 = a(paramda, j, (Message.Datatype)localObject1);
      if ((localObject1 == Message.Datatype.ENUM) && ((localObject4 instanceof Integer)))
      {
        localBuilder.addVarint(j, ((Integer)localObject4).intValue());
        continue;
      }
      if (((Message.Label)localObject3).isRepeated())
      {
        localb.a(j, localObject4);
        continue;
      }
      if (localObject2 != null)
      {
        a((ExtendableMessage.ExtendableBuilder)localBuilder, localObject2, localObject4);
        continue;
      }
      a(localBuilder, j, localObject4);
    }
  }

  FieldInfo a(String paramString)
  {
    Integer localInteger = (Integer)this.f.get(paramString);
    if (localInteger == null)
      return null;
    return (FieldInfo)this.g.a(localInteger.intValue());
  }

  Object a(M paramM, FieldInfo paramFieldInfo)
  {
    if (FieldInfo.a(paramFieldInfo) == null)
      throw new AssertionError("Field is not of type \"Message\"");
    try
    {
      Object localObject = FieldInfo.a(paramFieldInfo).get(paramM);
      return localObject;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
    }
    throw new AssertionError(localIllegalAccessException);
  }

  public void a(Message.Builder<M> paramBuilder, int paramInt, Object paramObject)
  {
    try
    {
      FieldInfo.b((FieldInfo)this.g.a(paramInt)).set(paramBuilder, paramObject);
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
    }
    throw new AssertionError(localIllegalAccessException);
  }

  void a(M paramM, WireOutput paramWireOutput)
    throws IOException
  {
    Iterator localIterator = b().iterator();
    while (localIterator.hasNext())
    {
      FieldInfo localFieldInfo = (FieldInfo)localIterator.next();
      Object localObject = a(paramM, localFieldInfo);
      if (localObject == null)
        continue;
      int i = localFieldInfo.a;
      Message.Datatype localDatatype = localFieldInfo.c;
      Message.Label localLabel = localFieldInfo.d;
      if (localLabel.isRepeated())
      {
        if (localLabel.isPacked())
        {
          b(paramWireOutput, (List)localObject, i, localDatatype);
          continue;
        }
        a(paramWireOutput, (List)localObject, i, localDatatype);
        continue;
      }
      a(paramWireOutput, i, localObject, localDatatype);
    }
    if ((paramM instanceof ExtendableMessage))
    {
      ExtendableMessage localExtendableMessage = (ExtendableMessage)paramM;
      if (localExtendableMessage.a != null)
        a(paramWireOutput, localExtendableMessage.a);
    }
    paramM.writeUnknownFieldMap(paramWireOutput);
  }

  Extension<ExtendableMessage<?>, ?> b(String paramString)
  {
    ct localct = this.c.a;
    if (localct == null)
      return null;
    return localct.a(this.d, paramString);
  }

  Collection<FieldInfo> b()
  {
    return this.g.a();
  }

  byte[] b(M paramM)
  {
    byte[] arrayOfByte = new byte[a(paramM)];
    try
    {
      a(paramM, WireOutput.a(arrayOfByte));
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
    }
    throw new RuntimeException(localIOException);
  }

  String c(M paramM)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.d.getSimpleName());
    localStringBuilder.append("{");
    Iterator localIterator = b().iterator();
    String str = "";
    while (localIterator.hasNext())
    {
      FieldInfo localFieldInfo = (FieldInfo)localIterator.next();
      Object localObject1 = a(paramM, localFieldInfo);
      if (localObject1 == null)
        continue;
      localStringBuilder.append(str);
      str = ", ";
      localStringBuilder.append(localFieldInfo.b);
      localStringBuilder.append("=");
      if (localFieldInfo.g);
      for (Object localObject2 = "██"; ; localObject2 = localObject1)
      {
        localStringBuilder.append(localObject2);
        break;
      }
    }
    if ((paramM instanceof ExtendableMessage))
    {
      ExtendableMessage localExtendableMessage = (ExtendableMessage)paramM;
      localStringBuilder.append(str);
      localStringBuilder.append("{extensions=");
      localStringBuilder.append(localExtendableMessage.b());
      localStringBuilder.append("}");
    }
    localStringBuilder.append("}");
    return (String)localStringBuilder.toString();
  }

  public static final class FieldInfo
  {
    final int a;
    final String b;
    final Message.Datatype c;
    final Message.Label d;
    final Class<? extends ProtoEnum> e;
    final Class<? extends Message> f;
    final boolean g;
    MessageAdapter<? extends Message> h;
    at<? extends ProtoEnum> i;
    private final Field j;
    private final Field k;

    private FieldInfo(int paramInt, String paramString, Message.Datatype paramDatatype, Message.Label paramLabel, boolean paramBoolean, Class<?> paramClass, Field paramField1, Field paramField2)
    {
      this.a = paramInt;
      this.b = paramString;
      this.c = paramDatatype;
      this.d = paramLabel;
      this.g = paramBoolean;
      if (paramDatatype == Message.Datatype.ENUM)
      {
        this.e = paramClass;
        this.f = null;
      }
      while (true)
      {
        this.j = paramField1;
        this.k = paramField2;
        return;
        if (paramDatatype == Message.Datatype.MESSAGE)
        {
          this.f = paramClass;
          this.e = null;
          continue;
        }
        this.e = null;
        this.f = null;
      }
    }
  }

  static class a<T> extends AbstractList<T>
    implements Serializable, Cloneable, RandomAccess
  {
    private final List<T> a = new ArrayList();

    public Object clone()
    {
      return this;
    }

    public T get(int paramInt)
    {
      return this.a.get(paramInt);
    }

    public int size()
    {
      return this.a.size();
    }
  }

  static class b
  {
    private Map<Integer, MessageAdapter.a<Object>> a;

    List<Object> a(int paramInt)
    {
      if (this.a == null)
        return null;
      return (MessageAdapter.a)this.a.get(Integer.valueOf(paramInt));
    }

    Set<Integer> a()
    {
      if (this.a == null)
        return Collections.emptySet();
      return this.a.keySet();
    }

    void a(int paramInt, Object paramObject)
    {
      if (this.a == null);
      for (MessageAdapter.a locala = null; ; locala = (MessageAdapter.a)this.a.get(Integer.valueOf(paramInt)))
      {
        if (locala == null)
        {
          locala = new MessageAdapter.a();
          if (this.a == null)
            this.a = new LinkedHashMap();
          this.a.put(Integer.valueOf(paramInt), locala);
        }
        MessageAdapter.a.a(locala).add(paramObject);
        return;
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.squareup.wire.MessageAdapter
 * JD-Core Version:    0.6.0
 */