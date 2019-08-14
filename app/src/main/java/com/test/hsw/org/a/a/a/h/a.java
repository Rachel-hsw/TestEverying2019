package org.a.a.a.h;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParseException;
import java.text.ParsePosition;

public class a extends Format
{
  private static final long a = -4329119827877627683L;
  private final Format b;
  private final Format c;

  public a(Format paramFormat1, Format paramFormat2)
  {
    this.b = paramFormat1;
    this.c = paramFormat2;
  }

  public String a(String paramString)
    throws ParseException
  {
    return format(parseObject(paramString));
  }

  public Format a()
  {
    return this.b;
  }

  public Format b()
  {
    return this.c;
  }

  public StringBuffer format(Object paramObject, StringBuffer paramStringBuffer, FieldPosition paramFieldPosition)
  {
    return this.c.format(paramObject, paramStringBuffer, paramFieldPosition);
  }

  public Object parseObject(String paramString, ParsePosition paramParsePosition)
  {
    return this.b.parseObject(paramString, paramParsePosition);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.h.a
 * JD-Core Version:    0.6.0
 */