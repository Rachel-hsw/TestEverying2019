package com.alipay.android.phone.mrpc.core;

import java.io.Closeable;
import java.io.IOException;

public final class r
{
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null);
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException localIOException)
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.android.phone.mrpc.core.r
 * JD-Core Version:    0.6.0
 */