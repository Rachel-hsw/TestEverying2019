package com.alipay.sdk.data;

import java.util.ArrayList;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

public final class c
{
  public static final String a = "application/octet-stream;binary/octet-stream";
  public Header[] b = null;
  public String c = null;
  public String d = null;

  private void a(String paramString)
  {
    this.c = paramString;
  }

  private void a(Header[] paramArrayOfHeader)
  {
    this.b = paramArrayOfHeader;
  }

  private void b(String paramString)
  {
    this.d = paramString;
  }

  private Header[] b()
  {
    return this.b;
  }

  private String c()
  {
    return this.c;
  }

  private String d()
  {
    return this.d;
  }

  private void e()
  {
    this.d = null;
    this.c = null;
  }

  public final ArrayList<BasicHeader> a()
  {
    ArrayList localArrayList;
    if ((this.b == null) || (this.b.length == 0))
      localArrayList = null;
    while (true)
    {
      return localArrayList;
      localArrayList = new ArrayList();
      for (Header localHeader : this.b)
        localArrayList.add(new BasicHeader(localHeader.getName(), localHeader.getValue()));
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.sdk.data.c
 * JD-Core Version:    0.6.0
 */