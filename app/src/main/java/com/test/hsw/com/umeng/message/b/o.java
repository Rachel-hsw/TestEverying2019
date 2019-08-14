package com.umeng.message.b;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;

public final class o
{
  private static final Logger a = Logger.getLogger(o.class.getName());

  public static aa a(OutputStream paramOutputStream)
  {
    return a(paramOutputStream, new ac());
  }

  private static aa a(OutputStream paramOutputStream, ac paramac)
  {
    return new p(paramac, paramOutputStream);
  }

  public static aa a(Socket paramSocket)
    throws IOException
  {
    c localc = c(paramSocket);
    return new q(localc, a(paramSocket.getOutputStream(), localc), paramSocket);
  }

  public static ab a(InputStream paramInputStream)
  {
    return a(paramInputStream, new ac());
  }

  private static ab a(InputStream paramInputStream, ac paramac)
  {
    return new r(paramac, paramInputStream);
  }

  public static h a(aa paramaa)
  {
    return new u(paramaa);
  }

  public static i a(ab paramab)
  {
    return new w(paramab);
  }

  public static ab b(Socket paramSocket)
    throws IOException
  {
    c localc = c(paramSocket);
    return new s(localc, a(paramSocket.getInputStream(), localc), paramSocket);
  }

  private static c c(Socket paramSocket)
  {
    return new t(paramSocket);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.o
 * JD-Core Version:    0.6.0
 */