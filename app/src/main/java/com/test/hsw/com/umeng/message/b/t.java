package com.umeng.message.b;

import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

final class t extends c
{
  t(Socket paramSocket)
  {
  }

  protected void c()
  {
    try
    {
      this.a.close();
      return;
    }
    catch (Exception localException)
    {
      o.a().log(Level.WARNING, "Failed to close timed out socket " + this.a, localException);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.t
 * JD-Core Version:    0.6.0
 */