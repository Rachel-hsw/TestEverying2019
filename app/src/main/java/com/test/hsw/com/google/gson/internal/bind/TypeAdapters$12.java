package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

final class TypeAdapters$12 extends TypeAdapter<Character>
{
  public Character read(JsonReader paramJsonReader)
    throws IOException
  {
    if (paramJsonReader.peek() == JsonToken.NULL)
    {
      paramJsonReader.nextNull();
      return null;
    }
    String str = paramJsonReader.nextString();
    if (str.length() != 1)
      throw new JsonSyntaxException("Expecting character, got: " + str);
    return Character.valueOf(str.charAt(0));
  }

  public void write(JsonWriter paramJsonWriter, Character paramCharacter)
    throws IOException
  {
    if (paramCharacter == null);
    for (String str = null; ; str = String.valueOf(paramCharacter))
    {
      paramJsonWriter.value(str);
      return;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.google.gson.internal.bind.TypeAdapters.12
 * JD-Core Version:    0.6.0
 */