package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.UUID;

final class TypeAdapters$21 extends TypeAdapter<UUID>
{
  public UUID read(JsonReader paramJsonReader)
    throws IOException
  {
    if (paramJsonReader.peek() == JsonToken.NULL)
    {
      paramJsonReader.nextNull();
      return null;
    }
    return UUID.fromString(paramJsonReader.nextString());
  }

  public void write(JsonWriter paramJsonWriter, UUID paramUUID)
    throws IOException
  {
    if (paramUUID == null);
    for (String str = null; ; str = paramUUID.toString())
    {
      paramJsonWriter.value(str);
      return;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.google.gson.internal.bind.TypeAdapters.21
 * JD-Core Version:    0.6.0
 */