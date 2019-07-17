package com.google.gson.internal.bind;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal..Gson.Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Primitives;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public final class ReflectiveTypeAdapterFactory
  implements TypeAdapterFactory
{
  private final ConstructorConstructor constructorConstructor;
  private final Excluder excluder;
  private final FieldNamingStrategy fieldNamingPolicy;

  public ReflectiveTypeAdapterFactory(ConstructorConstructor paramConstructorConstructor, FieldNamingStrategy paramFieldNamingStrategy, Excluder paramExcluder)
  {
    this.constructorConstructor = paramConstructorConstructor;
    this.fieldNamingPolicy = paramFieldNamingStrategy;
    this.excluder = paramExcluder;
  }

  private BoundField createBoundField(Gson paramGson, Field paramField, String paramString, TypeToken<?> paramTypeToken, boolean paramBoolean1, boolean paramBoolean2)
  {
    return new ReflectiveTypeAdapterFactory.1(this, paramString, paramBoolean1, paramBoolean2, paramGson, paramTypeToken, paramField, Primitives.isPrimitive(paramTypeToken.getRawType()));
  }

  private Map<String, BoundField> getBoundFields(Gson paramGson, TypeToken<?> paramTypeToken, Class<?> paramClass)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    if (paramClass.isInterface())
      return localLinkedHashMap;
    Type localType1 = paramTypeToken.getType();
    while (paramClass != Object.class)
    {
      Field[] arrayOfField = paramClass.getDeclaredFields();
      int i = arrayOfField.length;
      int j = 0;
      if (j < i)
      {
        Field localField = arrayOfField[j];
        boolean bool1 = excludeField(localField, true);
        boolean bool2 = excludeField(localField, false);
        if ((!bool1) && (!bool2));
        BoundField localBoundField2;
        do
        {
          j++;
          break;
          localField.setAccessible(true);
          Type localType2 = .Gson.Types.resolve(paramTypeToken.getType(), paramClass, localField.getGenericType());
          BoundField localBoundField1 = createBoundField(paramGson, localField, getFieldName(localField), TypeToken.get(localType2), bool1, bool2);
          localBoundField2 = (BoundField)localLinkedHashMap.put(localBoundField1.name, localBoundField1);
        }
        while (localBoundField2 == null);
        throw new IllegalArgumentException(localType1 + " declares multiple JSON fields named " + localBoundField2.name);
      }
      paramTypeToken = TypeToken.get(.Gson.Types.resolve(paramTypeToken.getType(), paramClass, paramClass.getGenericSuperclass()));
      paramClass = paramTypeToken.getRawType();
    }
    return localLinkedHashMap;
  }

  private String getFieldName(Field paramField)
  {
    SerializedName localSerializedName = (SerializedName)paramField.getAnnotation(SerializedName.class);
    if (localSerializedName == null)
      return this.fieldNamingPolicy.translateName(paramField);
    return localSerializedName.value();
  }

  public <T> TypeAdapter<T> create(Gson paramGson, TypeToken<T> paramTypeToken)
  {
    Class localClass = paramTypeToken.getRawType();
    if (!Object.class.isAssignableFrom(localClass))
      return null;
    return new Adapter(this.constructorConstructor.get(paramTypeToken), getBoundFields(paramGson, paramTypeToken, localClass), null);
  }

  public boolean excludeField(Field paramField, boolean paramBoolean)
  {
    return (!this.excluder.excludeClass(paramField.getType(), paramBoolean)) && (!this.excluder.excludeField(paramField, paramBoolean));
  }

  public static final class Adapter<T> extends TypeAdapter<T>
  {
    private final Map<String, ReflectiveTypeAdapterFactory.BoundField> boundFields;
    private final ObjectConstructor<T> constructor;

    private Adapter(ObjectConstructor<T> paramObjectConstructor, Map<String, ReflectiveTypeAdapterFactory.BoundField> paramMap)
    {
      this.constructor = paramObjectConstructor;
      this.boundFields = paramMap;
    }

    public T read(JsonReader paramJsonReader)
      throws IOException
    {
      if (paramJsonReader.peek() == JsonToken.NULL)
      {
        paramJsonReader.nextNull();
        return null;
      }
      Object localObject = this.constructor.construct();
      try
      {
        paramJsonReader.beginObject();
        while (true)
        {
          if (!paramJsonReader.hasNext())
            break label111;
          String str = paramJsonReader.nextName();
          localBoundField = (ReflectiveTypeAdapterFactory.BoundField)this.boundFields.get(str);
          if ((localBoundField != null) && (localBoundField.deserialized))
            break;
          paramJsonReader.skipValue();
        }
      }
      catch (IllegalStateException localIllegalStateException)
      {
        while (true)
        {
          ReflectiveTypeAdapterFactory.BoundField localBoundField;
          throw new JsonSyntaxException(localIllegalStateException);
          localBoundField.read(paramJsonReader, localObject);
        }
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        throw new AssertionError(localIllegalAccessException);
      }
      label111: paramJsonReader.endObject();
      return localObject;
    }

    public void write(JsonWriter paramJsonWriter, T paramT)
      throws IOException
    {
      if (paramT == null)
      {
        paramJsonWriter.nullValue();
        return;
      }
      paramJsonWriter.beginObject();
      try
      {
        Iterator localIterator = this.boundFields.values().iterator();
        while (localIterator.hasNext())
        {
          ReflectiveTypeAdapterFactory.BoundField localBoundField = (ReflectiveTypeAdapterFactory.BoundField)localIterator.next();
          if (!localBoundField.serialized)
            continue;
          paramJsonWriter.name(localBoundField.name);
          localBoundField.write(paramJsonWriter, paramT);
        }
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        throw new AssertionError();
      }
      paramJsonWriter.endObject();
    }
  }

  static abstract class BoundField
  {
    final boolean deserialized;
    final String name;
    final boolean serialized;

    protected BoundField(String paramString, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.name = paramString;
      this.serialized = paramBoolean1;
      this.deserialized = paramBoolean2;
    }

    abstract void read(JsonReader paramJsonReader, Object paramObject)
      throws IOException, IllegalAccessException;

    abstract void write(JsonWriter paramJsonWriter, Object paramObject)
      throws IOException, IllegalAccessException;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.google.gson.internal.bind.ReflectiveTypeAdapterFactory
 * JD-Core Version:    0.6.0
 */