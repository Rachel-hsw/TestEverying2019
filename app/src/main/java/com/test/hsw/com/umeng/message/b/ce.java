package com.umeng.message.b;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ce
{
  public static final long a(String paramString)
  {
    try
    {
      long l = new SimpleDateFormat("yyyyMMddHHmmss").parse(paramString).getTime();
      return l;
    }
    catch (Throwable localThrowable)
    {
    }
    return -1L;
  }

  public static final String a(long paramLong)
  {
    try
    {
      String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(paramLong));
      return str;
    }
    catch (Throwable localThrowable)
    {
    }
    return "none";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.ce
 * JD-Core Version:    0.6.0
 */