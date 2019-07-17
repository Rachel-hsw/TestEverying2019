package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

final class TypeAdapters$6 extends TypeAdapter<Number>
{
  public Number read(JsonReader paramJsonReader)
    throws IOException
  {
    if (paramJsonReader.peek() == JsonToken.NULL)
    {
      paramJsonReader.nextNull();
      return null;
    }
    try
    {
      Short localShort = Short.valueOf((short)paramJsonReader.nextInt());
      return localShort;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    throw new JsonSyntaxException(localNumberFormatException);
  }

  public void write(JsonWriter paramJsonWriter, Number paramNumber)
    throws IOException
  {
    paramJsonWriter.value(paramNumber);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.google.gson.internal.bind.TypeAdapters.6
 * JD-Core Version:    0.6.0
 */