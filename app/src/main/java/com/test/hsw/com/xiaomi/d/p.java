package com.xiaomi.d;

import com.xiaomi.d.c.g;
import com.xiaomi.d.c.h;
import java.io.PrintStream;
import java.io.PrintWriter;

public class p extends Exception
{
  private g a = null;
  private h b = null;
  private Throwable c = null;

  public p()
  {
  }

  public p(g paramg)
  {
    this.a = paramg;
  }

  public p(String paramString)
  {
    super(paramString);
  }

  public p(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    this.c = paramThrowable;
  }

  public p(Throwable paramThrowable)
  {
    this.c = paramThrowable;
  }

  public Throwable a()
  {
    return this.c;
  }

  public String getMessage()
  {
    String str = super.getMessage();
    if ((str == null) && (this.b != null))
      str = this.b.toString();
    do
      return str;
    while ((str != null) || (this.a == null));
    return this.a.toString();
  }

  public void printStackTrace()
  {
    printStackTrace(System.err);
  }

  public void printStackTrace(PrintStream paramPrintStream)
  {
    super.printStackTrace(paramPrintStream);
    if (this.c != null)
    {
      paramPrintStream.println("Nested Exception: ");
      this.c.printStackTrace(paramPrintStream);
    }
  }

  public void printStackTrace(PrintWriter paramPrintWriter)
  {
    super.printStackTrace(paramPrintWriter);
    if (this.c != null)
    {
      paramPrintWriter.println("Nested Exception: ");
      this.c.printStackTrace(paramPrintWriter);
    }
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str = super.getMessage();
    if (str != null)
      localStringBuilder.append(str).append(": ");
    if (this.b != null)
      localStringBuilder.append(this.b);
    if (this.a != null)
      localStringBuilder.append(this.a);
    if (this.c != null)
      localStringBuilder.append("\n  -- caused by: ").append(this.c);
    return localStringBuilder.toString();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.d.p
 * JD-Core Version:    0.6.0
 */