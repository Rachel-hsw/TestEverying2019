package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

final class TypeAdapters$4 extends TypeAdapter<Boolean>
{
  public Boolean read(JsonReader paramJsonReader)
    throws IOException
  {
    if (paramJsonReader.peek() == JsonToken.NULL)
    {
      paramJsonReader.nextNull();
      return null;
    }
    return Boolean.valueOf(paramJsonReader.nextString());
  }

  public void write(JsonWriter paramJsonWriter, Boolean paramBoolean)
    throws IOException
  {
    if (paramBoolean == null);
    for (String str = "null"; ; str = paramBoolean.toString())
    {
      paramJsonWriter.value(str);
      return;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.google.gson.internal.bind.TypeAdapters.4
 * JD-Core Version:    0.6.0
 */