package com.ta.utdid2.c.a;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import org.xmlpull.v1.XmlSerializer;

final class a
  implements XmlSerializer
{
  private static final String[] a = { null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "&quot;", null, null, null, "&amp;", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "&lt;", null, "&gt;", null };
  private final char[] b = new char[8192];
  private int c;
  private Writer d;
  private OutputStream e;
  private CharsetEncoder f;
  private ByteBuffer g = ByteBuffer.allocate(8192);
  private boolean h;

  private void a()
    throws IOException
  {
    int i = this.g.position();
    if (i > 0)
    {
      this.g.flip();
      this.e.write(this.g.array(), 0, i);
      this.g.clear();
    }
  }

  private void a(char paramChar)
    throws IOException
  {
    int i = this.c;
    if (i >= 8191)
    {
      flush();
      i = this.c;
    }
    this.b[i] = paramChar;
    this.c = (i + 1);
  }

  private void a(String paramString)
    throws IOException
  {
    a(paramString, 0, paramString.length());
  }

  private void a(String paramString, int paramInt1, int paramInt2)
    throws IOException
  {
    if (paramInt2 > 8192)
    {
      int j = paramInt1 + paramInt2;
      if (paramInt1 < j)
      {
        int k = paramInt1 + 8192;
        if (k < j);
        for (int m = 8192; ; m = j - paramInt1)
        {
          a(paramString, paramInt1, m);
          paramInt1 = k;
          break;
        }
      }
    }
    else
    {
      int i = this.c;
      if (i + paramInt2 > 8192)
      {
        flush();
        i = this.c;
      }
      paramString.getChars(paramInt1, paramInt1 + paramInt2, this.b, i);
      this.c = (i + paramInt2);
    }
  }

  private void a(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException
  {
    if (paramInt2 > 8192)
    {
      int j = paramInt1 + paramInt2;
      if (paramInt1 < j)
      {
        int k = paramInt1 + 8192;
        if (k < j);
        for (int m = 8192; ; m = j - paramInt1)
        {
          a(paramArrayOfChar, paramInt1, m);
          paramInt1 = k;
          break;
        }
      }
    }
    else
    {
      int i = this.c;
      if (i + paramInt2 > 8192)
      {
        flush();
        i = this.c;
      }
      System.arraycopy(paramArrayOfChar, paramInt1, this.b, i, paramInt2);
      this.c = (i + paramInt2);
    }
  }

  private void b(String paramString)
    throws IOException
  {
    int i = 0;
    int j = paramString.length();
    int k = (char)a.length;
    String[] arrayOfString = a;
    for (int m = 0; m < j; m++)
    {
      int n = paramString.charAt(m);
      if (n >= k)
        continue;
      String str = arrayOfString[n];
      if (str == null)
        continue;
      if (i < m)
        a(paramString, i, m - i);
      i = m + 1;
      a(str);
    }
    if (i < m)
      a(paramString, i, m - i);
  }

  public final XmlSerializer attribute(String paramString1, String paramString2, String paramString3)
    throws IOException, IllegalArgumentException, IllegalStateException
  {
    a(' ');
    if (paramString1 != null)
    {
      a(paramString1);
      a(':');
    }
    a(paramString2);
    a("=\"");
    b(paramString3);
    a('"');
    return this;
  }

  public final void cdsect(String paramString)
    throws IOException, IllegalArgumentException, IllegalStateException
  {
    throw new UnsupportedOperationException();
  }

  public final void comment(String paramString)
    throws IOException, IllegalArgumentException, IllegalStateException
  {
    throw new UnsupportedOperationException();
  }

  public final void docdecl(String paramString)
    throws IOException, IllegalArgumentException, IllegalStateException
  {
    throw new UnsupportedOperationException();
  }

  public final void endDocument()
    throws IOException, IllegalArgumentException, IllegalStateException
  {
    flush();
  }

  public final XmlSerializer endTag(String paramString1, String paramString2)
    throws IOException, IllegalArgumentException, IllegalStateException
  {
    if (this.h)
      a(" />\n");
    while (true)
    {
      this.h = false;
      return this;
      a("</");
      if (paramString1 != null)
      {
        a(paramString1);
        a(':');
      }
      a(paramString2);
      a(">\n");
    }
  }

  public final void entityRef(String paramString)
    throws IOException, IllegalArgumentException, IllegalStateException
  {
    throw new UnsupportedOperationException();
  }

  public final void flush()
    throws IOException
  {
    if (this.c > 0)
    {
      if (this.e == null)
        break label105;
      CharBuffer localCharBuffer = CharBuffer.wrap(this.b, 0, this.c);
      for (CoderResult localCoderResult = this.f.encode(localCharBuffer, this.g, true); ; localCoderResult = this.f.encode(localCharBuffer, this.g, true))
      {
        if (localCoderResult.isError())
          throw new IOException(localCoderResult.toString());
        if (!localCoderResult.isOverflow())
          break;
        a();
      }
      a();
      this.e.flush();
    }
    while (true)
    {
      this.c = 0;
      return;
      label105: this.d.write(this.b, 0, this.c);
      this.d.flush();
    }
  }

  public final int getDepth()
  {
    throw new UnsupportedOperationException();
  }

  public final boolean getFeature(String paramString)
  {
    throw new UnsupportedOperationException();
  }

  public final String getName()
  {
    throw new UnsupportedOperationException();
  }

  public final String getNamespace()
  {
    throw new UnsupportedOperationException();
  }

  public final String getPrefix(String paramString, boolean paramBoolean)
    throws IllegalArgumentException
  {
    throw new UnsupportedOperationException();
  }

  public final Object getProperty(String paramString)
  {
    throw new UnsupportedOperationException();
  }

  public final void ignorableWhitespace(String paramString)
    throws IOException, IllegalArgumentException, IllegalStateException
  {
    throw new UnsupportedOperationException();
  }

  public final void processingInstruction(String paramString)
    throws IOException, IllegalArgumentException, IllegalStateException
  {
    throw new UnsupportedOperationException();
  }

  public final void setFeature(String paramString, boolean paramBoolean)
    throws IllegalArgumentException, IllegalStateException
  {
    if (paramString.equals("http://xmlpull.org/v1/doc/features.html#indent-output"))
      return;
    throw new UnsupportedOperationException();
  }

  public final void setOutput(OutputStream paramOutputStream, String paramString)
    throws IOException, IllegalArgumentException, IllegalStateException
  {
    if (paramOutputStream == null)
      throw new IllegalArgumentException();
    try
    {
      this.f = Charset.forName(paramString).newEncoder();
      this.e = paramOutputStream;
      return;
    }
    catch (IllegalCharsetNameException localIllegalCharsetNameException)
    {
      throw ((UnsupportedEncodingException)new UnsupportedEncodingException(paramString).initCause(localIllegalCharsetNameException));
    }
    catch (UnsupportedCharsetException localUnsupportedCharsetException)
    {
    }
    throw ((UnsupportedEncodingException)new UnsupportedEncodingException(paramString).initCause(localUnsupportedCharsetException));
  }

  public final void setOutput(Writer paramWriter)
    throws IOException, IllegalArgumentException, IllegalStateException
  {
    this.d = paramWriter;
  }

  public final void setPrefix(String paramString1, String paramString2)
    throws IOException, IllegalArgumentException, IllegalStateException
  {
    throw new UnsupportedOperationException();
  }

  public final void setProperty(String paramString, Object paramObject)
    throws IllegalArgumentException, IllegalStateException
  {
    throw new UnsupportedOperationException();
  }

  public final void startDocument(String paramString, Boolean paramBoolean)
    throws IOException, IllegalArgumentException, IllegalStateException
  {
    StringBuilder localStringBuilder = new StringBuilder("<?xml version='1.0' encoding='utf-8' standalone='");
    if (paramBoolean.booleanValue());
    for (String str = "yes"; ; str = "no")
    {
      a(str + "' ?>\n");
      return;
    }
  }

  public final XmlSerializer startTag(String paramString1, String paramString2)
    throws IOException, IllegalArgumentException, IllegalStateException
  {
    if (this.h)
      a(">\n");
    a('<');
    if (paramString1 != null)
    {
      a(paramString1);
      a(':');
    }
    a(paramString2);
    this.h = true;
    return this;
  }

  public final XmlSerializer text(String paramString)
    throws IOException, IllegalArgumentException, IllegalStateException
  {
    if (this.h)
    {
      a(">");
      this.h = false;
    }
    b(paramString);
    return this;
  }

  public final XmlSerializer text(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException, IllegalArgumentException, IllegalStateException
  {
    if (this.h)
    {
      a(">");
      this.h = false;
    }
    int i = (char)a.length;
    String[] arrayOfString = a;
    int j = paramInt1 + paramInt2;
    int k = paramInt1;
    while (paramInt1 < j)
    {
      int m = paramArrayOfChar[paramInt1];
      if (m < i)
      {
        String str = arrayOfString[m];
        if (str != null)
        {
          if (k < paramInt1)
            a(paramArrayOfChar, k, paramInt1 - k);
          k = paramInt1 + 1;
          a(str);
        }
      }
      paramInt1++;
    }
    if (k < paramInt1)
      a(paramArrayOfChar, k, paramInt1 - k);
    return this;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.ta.utdid2.c.a.a
 * JD-Core Version:    0.6.0
 */