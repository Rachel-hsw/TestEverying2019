package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.math.BigDecimal;

final class TypeAdapters$14 extends TypeAdapter<BigDecimal>
{
  public BigDecimal read(JsonReader paramJsonReader)
    throws IOException
  {
    if (paramJsonReader.peek() == JsonToken.NULL)
    {
      paramJsonReader.nextNull();
      return null;
    }
    try
    {
      BigDecimal localBigDecimal = new BigDecimal(paramJsonReader.nextString());
      return localBigDecimal;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    throw new JsonSyntaxException(localNumberFormatException);
  }

  public void write(JsonWriter paramJsonWriter, BigDecimal paramBigDecimal)
    throws IOException
  {
    paramJsonWriter.value(paramBigDecimal);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.google.gson.internal.bind.TypeAdapters.14
 * JD-Core Version:    0.6.0
 */