package com.squareup.wire;

import com.umeng.message.b.a;
import com.umeng.message.b.at;
import com.umeng.message.b.cu;
import com.umeng.message.b.cy;
import com.umeng.message.b.cy.a;
import com.umeng.message.b.j;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class Message
  implements Serializable
{
  private static final long a;
  private static final Wire c = new Wire(new Class[0]);
  protected transient int b = 0;
  private transient cy d;
  private transient boolean e;
  private transient int f;

  private Object a()
    throws ObjectStreamException
  {
    return new cu(this, getClass());
  }

  protected static <T> List<T> a(List<T> paramList)
  {
    if (paramList == null)
      return null;
    return new ArrayList(paramList);
  }

  private void a(WireOutput paramWireOutput)
  {
    MessageAdapter localMessageAdapter = c.a(getClass());
    try
    {
      localMessageAdapter.a(this, paramWireOutput);
      return;
    }
    catch (IOException localIOException)
    {
    }
    throw new RuntimeException(localIOException);
  }

  protected static <T> List<T> b(List<T> paramList)
  {
    if (paramList == null)
      paramList = Collections.emptyList();
    do
      return paramList;
    while ((paramList instanceof MessageAdapter.a));
    return Collections.unmodifiableList(new ArrayList(paramList));
  }

  public static <E extends Enum,  extends ProtoEnum> E enumFromInt(Class<E> paramClass, int paramInt)
  {
    return (Enum)c.c(paramClass).a(paramInt);
  }

  public static <E extends Enum,  extends ProtoEnum> int intFromEnum(E paramE)
  {
    return c.c(paramE.getClass()).a((ProtoEnum)paramE);
  }

  protected void a(Builder paramBuilder)
  {
    if (paramBuilder.b != null)
      this.d = new cy(paramBuilder.b);
  }

  protected boolean a(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }

  protected boolean a(List<?> paramList1, List<?> paramList2)
  {
    if ((paramList1 != null) && (paramList1.isEmpty()))
      paramList1 = null;
    if ((paramList2 != null) && (paramList2.isEmpty()))
      paramList2 = null;
    return (paramList1 == paramList2) || ((paramList1 != null) && (paramList1.equals(paramList2)));
  }

  protected Collection<List<cy.a>> c()
  {
    if (this.d == null)
      return Collections.emptySet();
    return this.d.a.values();
  }

  public int getSerializedSize()
  {
    if (!this.e)
    {
      this.f = c.a(getClass()).a(this);
      this.e = true;
    }
    return this.f;
  }

  public int getUnknownFieldsSerializedSize()
  {
    if (this.d == null)
      return 0;
    return this.d.a();
  }

  public byte[] toByteArray()
  {
    return c.a(getClass()).b(this);
  }

  public String toString()
  {
    return c.a(getClass()).c(this);
  }

  public void writeTo(byte[] paramArrayOfByte)
  {
    writeTo(paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  public void writeTo(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    a(WireOutput.a(paramArrayOfByte, paramInt1, paramInt2));
  }

  public void writeUnknownFieldMap(WireOutput paramWireOutput)
    throws IOException
  {
    if (this.d != null)
      this.d.a(paramWireOutput);
  }

  public static abstract class Builder<T extends Message>
  {
    cy b;

    public Builder()
    {
    }

    public Builder(Message paramMessage)
    {
      if ((paramMessage != null) && (Message.a(paramMessage) != null))
        this.b = new cy(Message.a(paramMessage));
    }

    protected static <T> List<T> a(List<T> paramList)
    {
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        int i = 0;
        int j = paramList.size();
        while (i < j)
        {
          if (paramList.get(i) == null)
            throw new NullPointerException("Element at index " + i + " is null");
          i++;
        }
      }
      return paramList;
    }

    cy a()
    {
      if (this.b == null)
        this.b = new cy();
      return this.b;
    }

    public void addFixed32(int paramInt1, int paramInt2)
    {
      try
      {
        a().a(paramInt1, Integer.valueOf(paramInt2));
        return;
      }
      catch (IOException localIOException)
      {
      }
      throw new IllegalArgumentException(localIOException.getMessage());
    }

    public void addFixed64(int paramInt, long paramLong)
    {
      try
      {
        a().b(paramInt, Long.valueOf(paramLong));
        return;
      }
      catch (IOException localIOException)
      {
      }
      throw new IllegalArgumentException(localIOException.getMessage());
    }

    public void addLengthDelimited(int paramInt, j paramj)
    {
      try
      {
        a().a(paramInt, paramj);
        return;
      }
      catch (IOException localIOException)
      {
      }
      throw new IllegalArgumentException(localIOException.getMessage());
    }

    public void addVarint(int paramInt, long paramLong)
    {
      try
      {
        a().a(paramInt, Long.valueOf(paramLong));
        return;
      }
      catch (IOException localIOException)
      {
      }
      throw new IllegalArgumentException(localIOException.getMessage());
    }

    public abstract T build();

    public void checkRequiredFields()
    {
      Message.d().b(getClass()).a(this);
    }
  }

  public static enum Datatype
  {
    public static final Comparator<Datatype> ORDER_BY_NAME;
    private static final Map<String, Datatype> a;
    private final int b;

    static
    {
      SINT32 = new Datatype("SINT32", 4, 5);
      SINT64 = new Datatype("SINT64", 5, 6);
      BOOL = new Datatype("BOOL", 6, 7);
      ENUM = new Datatype("ENUM", 7, 8);
      STRING = new Datatype("STRING", 8, 9);
      BYTES = new Datatype("BYTES", 9, 10);
      MESSAGE = new Datatype("MESSAGE", 10, 11);
      FIXED32 = new Datatype("FIXED32", 11, 12);
      SFIXED32 = new Datatype("SFIXED32", 12, 13);
      FIXED64 = new Datatype("FIXED64", 13, 14);
      SFIXED64 = new Datatype("SFIXED64", 14, 15);
      FLOAT = new Datatype("FLOAT", 15, 16);
      DOUBLE = new Datatype("DOUBLE", 16, 17);
      Datatype[] arrayOfDatatype = new Datatype[17];
      arrayOfDatatype[0] = INT32;
      arrayOfDatatype[1] = INT64;
      arrayOfDatatype[2] = UINT32;
      arrayOfDatatype[3] = UINT64;
      arrayOfDatatype[4] = SINT32;
      arrayOfDatatype[5] = SINT64;
      arrayOfDatatype[6] = BOOL;
      arrayOfDatatype[7] = ENUM;
      arrayOfDatatype[8] = STRING;
      arrayOfDatatype[9] = BYTES;
      arrayOfDatatype[10] = MESSAGE;
      arrayOfDatatype[11] = FIXED32;
      arrayOfDatatype[12] = SFIXED32;
      arrayOfDatatype[13] = FIXED64;
      arrayOfDatatype[14] = SFIXED64;
      arrayOfDatatype[15] = FLOAT;
      arrayOfDatatype[16] = DOUBLE;
      c = arrayOfDatatype;
      ORDER_BY_NAME = new Message.Datatype.1();
      a = new LinkedHashMap();
      a.put("int32", INT32);
      a.put("int64", INT64);
      a.put("uint32", UINT32);
      a.put("uint64", UINT64);
      a.put("sint32", SINT32);
      a.put("sint64", SINT64);
      a.put("bool", BOOL);
      a.put("enum", ENUM);
      a.put("string", STRING);
      a.put("bytes", BYTES);
      a.put("message", MESSAGE);
      a.put("fixed32", FIXED32);
      a.put("sfixed32", SFIXED32);
      a.put("fixed64", FIXED64);
      a.put("sfixed64", SFIXED64);
      a.put("float", FLOAT);
      a.put("double", DOUBLE);
    }

    private Datatype(int paramInt)
    {
      this.b = paramInt;
    }

    public static Datatype of(String paramString)
    {
      return (Datatype)a.get(paramString);
    }

    public int value()
    {
      return this.b;
    }

    public WireType wireType()
    {
      switch (Message.1.a[ordinal()])
      {
      default:
        throw new AssertionError("No wiretype for datatype " + this);
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
        return WireType.VARINT;
      case 9:
      case 10:
      case 11:
        return WireType.FIXED32;
      case 12:
      case 13:
      case 14:
        return WireType.FIXED64;
      case 15:
      case 16:
      case 17:
      }
      return WireType.LENGTH_DELIMITED;
    }
  }

  public static enum Label
  {
    public static final Comparator<Label> ORDER_BY_NAME;
    private final int a;

    static
    {
      OPTIONAL = new Label("OPTIONAL", 1, 64);
      REPEATED = new Label("REPEATED", 2, 128);
      PACKED = new Label("PACKED", 3, 256);
      Label[] arrayOfLabel = new Label[4];
      arrayOfLabel[0] = REQUIRED;
      arrayOfLabel[1] = OPTIONAL;
      arrayOfLabel[2] = REPEATED;
      arrayOfLabel[3] = PACKED;
      b = arrayOfLabel;
      ORDER_BY_NAME = new Message.Label.1();
    }

    private Label(int paramInt)
    {
      this.a = paramInt;
    }

    public boolean isPacked()
    {
      return this == PACKED;
    }

    public boolean isRepeated()
    {
      return (this == REPEATED) || (this == PACKED);
    }

    public int value()
    {
      return this.a;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.squareup.wire.Message
 * JD-Core Version:    0.6.0
 */