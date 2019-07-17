package org.a.b.a.a;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;

public class g
  implements HttpEntity
{
  private static final char[] a = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
  private final c b;
  private final Header c;
  private long d;
  private volatile boolean e;

  public g()
  {
    this(d.a, null, null);
  }

  public g(d paramd)
  {
    this(paramd, null, null);
  }

  public g(d paramd, String paramString, Charset paramCharset)
  {
    if (paramString == null)
      paramString = a();
    if (paramd == null)
      paramd = d.a;
    this.b = new c("form-data", paramCharset, paramString, paramd);
    this.c = new BasicHeader("Content-Type", a(paramString, paramCharset));
    this.e = true;
  }

  protected String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Random localRandom = new Random();
    int i = 30 + localRandom.nextInt(11);
    for (int j = 0; j < i; j++)
      localStringBuilder.append(a[localRandom.nextInt(a.length)]);
    return localStringBuilder.toString();
  }

  protected String a(String paramString, Charset paramCharset)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("multipart/form-data; boundary=");
    localStringBuilder.append(paramString);
    if (paramCharset != null)
    {
      localStringBuilder.append("; charset=");
      localStringBuilder.append(paramCharset.name());
    }
    return localStringBuilder.toString();
  }

  public void a(String paramString, org.a.b.a.a.a.c paramc)
  {
    a(new a(paramString, paramc));
  }

  public void a(a parama)
  {
    this.b.a(parama);
    this.e = true;
  }

  public void consumeContent()
    throws IOException, UnsupportedOperationException
  {
    if (isStreaming())
      throw new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
  }

  public InputStream getContent()
    throws IOException, UnsupportedOperationException
  {
    throw new UnsupportedOperationException("Multipart form entity does not implement #getContent()");
  }

  public Header getContentEncoding()
  {
    return null;
  }

  public long getContentLength()
  {
    if (this.e)
    {
      this.d = this.b.f();
      this.e = false;
    }
    return this.d;
  }

  public Header getContentType()
  {
    return this.c;
  }

  public boolean isChunked()
  {
    return !isRepeatable();
  }

  public boolean isRepeatable()
  {
    Iterator localIterator = this.b.d().iterator();
    while (localIterator.hasNext())
      if (((a)localIterator.next()).b().g() < 0L)
        return false;
    return true;
  }

  public boolean isStreaming()
  {
    return !isRepeatable();
  }

  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    this.b.a(paramOutputStream);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.b.a.a.g
 * JD-Core Version:    0.6.0
 */