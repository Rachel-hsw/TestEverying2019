package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.net.URL;

final class TypeAdapters$18 extends TypeAdapter<URL>
{
  public URL read(JsonReader paramJsonReader)
    throws IOException
  {
    if (paramJsonReader.peek() == JsonToken.NULL)
      paramJsonReader.nextNull();
    String str;
    do
    {
      return null;
      str = paramJsonReader.nextString();
    }
    while ("null".equals(str));
    return new URL(str);
  }

  public void write(JsonWriter paramJsonWriter, URL paramURL)
    throws IOException
  {
    if (paramURL == null);
    for (String str = null; ; str = paramURL.toExternalForm())
    {
      paramJsonWriter.value(str);
      return;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.google.gson.internal.bind.TypeAdapters.18
 * JD-Core Version:    0.6.0
 */