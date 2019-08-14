package com.umeng.message.b;

import com.squareup.wire.Message;
import com.squareup.wire.Wire;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.io.StreamCorruptedException;

public final class cu
  implements Serializable
{
  private static final long a;
  private final byte[] b;
  private final Class<? extends Message> c;

  public cu(Message paramMessage, Class<? extends Message> paramClass)
  {
    this.b = paramMessage.toByteArray();
    this.c = paramClass;
  }

  Object a()
    throws ObjectStreamException
  {
    try
    {
      Message localMessage = new Wire(new Class[0]).parseFrom(this.b, this.c);
      return localMessage;
    }
    catch (IOException localIOException)
    {
    }
    throw new StreamCorruptedException(localIOException.getMessage());
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.cu
 * JD-Core Version:    0.6.0
 */