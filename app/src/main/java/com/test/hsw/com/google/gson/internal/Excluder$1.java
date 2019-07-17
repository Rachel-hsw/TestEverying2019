package com.google.gson.internal;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

class Excluder$1 extends TypeAdapter<T>
{
  private TypeAdapter<T> delegate;

  private TypeAdapter<T> delegate()
  {
    TypeAdapter localTypeAdapter1 = this.delegate;
    if (localTypeAdapter1 != null)
      return localTypeAdapter1;
    TypeAdapter localTypeAdapter2 = this.val$gson.getDelegateAdapter(this.this$0, this.val$type);
    this.delegate = localTypeAdapter2;
    return localTypeAdapter2;
  }

  public T read(JsonReader paramJsonReader)
    throws IOException
  {
    if (this.val$skipDeserialize)
    {
      paramJsonReader.skipValue();
      return null;
    }
    return delegate().read(paramJsonReader);
  }

  public void write(JsonWriter paramJsonWriter, T paramT)
    throws IOException
  {
    if (this.val$skipSerialize)
    {
      paramJsonWriter.nullValue();
      return;
    }
    delegate().write(paramJsonWriter, paramT);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.google.gson.internal.Excluder.1
 * JD-Core Version:    0.6.0
 */