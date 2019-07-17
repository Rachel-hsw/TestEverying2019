package com.a.a.c;

import com.a.a.a.a.b;
import java.io.File;

public final class a
{
  public static File a(String paramString, b paramb)
  {
    File localFile = paramb.a(paramString);
    if ((localFile != null) && (localFile.exists()))
      return localFile;
    return null;
  }

  public static boolean b(String paramString, b paramb)
  {
    File localFile = paramb.a(paramString);
    return (localFile != null) && (localFile.exists()) && (localFile.delete());
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.a.a.c.a
 * JD-Core Version:    0.6.0
 */