package org.a.b.a.a;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.util.ByteArrayBuffer;

public class c
{
  private static final ByteArrayBuffer a = a(e.f, ": ");
  private static final ByteArrayBuffer b = a(e.f, "\r\n");
  private static final ByteArrayBuffer c = a(e.f, "--");
  private final String d;
  private final Charset e;
  private final String f;
  private final List<a> g;
  private final d h;

  public c(String paramString1, String paramString2)
  {
    this(paramString1, null, paramString2);
  }

  public c(String paramString1, Charset paramCharset, String paramString2)
  {
    this(paramString1, paramCharset, paramString2, d.a);
  }

  public c(String paramString1, Charset paramCharset, String paramString2, d paramd)
  {
    if (paramString1 == null)
      throw new IllegalArgumentException("Multipart subtype may not be null");
    if (paramString2 == null)
      throw new IllegalArgumentException("Multipart boundary may not be null");
    this.d = paramString1;
    if (paramCharset != null);
    while (true)
    {
      this.e = paramCharset;
      this.f = paramString2;
      this.g = new ArrayList();
      this.h = paramd;
      return;
      paramCharset = e.f;
    }
  }

  private static ByteArrayBuffer a(Charset paramCharset, String paramString)
  {
    ByteBuffer localByteBuffer = paramCharset.encode(CharBuffer.wrap(paramString));
    ByteArrayBuffer localByteArrayBuffer = new ByteArrayBuffer(localByteBuffer.remaining());
    localByteArrayBuffer.append(localByteBuffer.array(), localByteBuffer.position(), localByteBuffer.remaining());
    return localByteArrayBuffer;
  }

  private static void a(String paramString, OutputStream paramOutputStream)
    throws IOException
  {
    a(a(e.f, paramString), paramOutputStream);
  }

  private static void a(String paramString, Charset paramCharset, OutputStream paramOutputStream)
    throws IOException
  {
    a(a(paramCharset, paramString), paramOutputStream);
  }

  private void a(d paramd, OutputStream paramOutputStream, boolean paramBoolean)
    throws IOException
  {
    ByteArrayBuffer localByteArrayBuffer = a(this.e, e());
    Iterator localIterator1 = this.g.iterator();
    if (localIterator1.hasNext())
    {
      a locala = (a)localIterator1.next();
      a(c, paramOutputStream);
      a(localByteArrayBuffer, paramOutputStream);
      a(b, paramOutputStream);
      b localb = locala.c();
      switch (1.a[paramd.ordinal()])
      {
      default:
      case 1:
      case 2:
      }
      while (true)
      {
        a(b, paramOutputStream);
        if (paramBoolean)
          locala.b().a(paramOutputStream);
        a(b, paramOutputStream);
        break;
        Iterator localIterator2 = localb.iterator();
        while (localIterator2.hasNext())
          a((f)localIterator2.next(), paramOutputStream);
        a(locala.c().a("Content-Disposition"), this.e, paramOutputStream);
        if (locala.b().d() == null)
          continue;
        a(locala.c().a("Content-Type"), this.e, paramOutputStream);
      }
    }
    a(c, paramOutputStream);
    a(localByteArrayBuffer, paramOutputStream);
    a(c, paramOutputStream);
    a(b, paramOutputStream);
  }

  private static void a(f paramf, OutputStream paramOutputStream)
    throws IOException
  {
    a(paramf.a(), paramOutputStream);
    a(a, paramOutputStream);
    a(paramf.b(), paramOutputStream);
    a(b, paramOutputStream);
  }

  private static void a(f paramf, Charset paramCharset, OutputStream paramOutputStream)
    throws IOException
  {
    a(paramf.a(), paramCharset, paramOutputStream);
    a(a, paramOutputStream);
    a(paramf.b(), paramCharset, paramOutputStream);
    a(b, paramOutputStream);
  }

  private static void a(ByteArrayBuffer paramByteArrayBuffer, OutputStream paramOutputStream)
    throws IOException
  {
    paramOutputStream.write(paramByteArrayBuffer.buffer(), 0, paramByteArrayBuffer.length());
  }

  public String a()
  {
    return this.d;
  }

  public void a(OutputStream paramOutputStream)
    throws IOException
  {
    a(this.h, paramOutputStream, true);
  }

  public void a(a parama)
  {
    if (parama == null)
      return;
    this.g.add(parama);
  }

  public Charset b()
  {
    return this.e;
  }

  public d c()
  {
    return this.h;
  }

  public List<a> d()
  {
    return this.g;
  }

  public String e()
  {
    return this.f;
  }

  public long f()
  {
    Iterator localIterator = this.g.iterator();
    long l1 = 0L;
    while (localIterator.hasNext())
    {
      long l2 = ((a)localIterator.next()).b().g();
      if (l2 >= 0L)
      {
        l1 = l2 + l1;
        continue;
      }
      return -1L;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      a(this.h, localByteArrayOutputStream, false);
      int i = localByteArrayOutputStream.toByteArray().length;
      return l1 + i;
    }
    catch (IOException localIOException)
    {
    }
    return -1L;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.b.a.a.c
 * JD-Core Version:    0.6.0
 */