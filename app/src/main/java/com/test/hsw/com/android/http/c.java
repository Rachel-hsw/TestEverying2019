package com.android.http;

import com.android.volley.a;
import com.android.volley.l;
import com.android.volley.o;
import com.android.volley.s;
import com.android.volley.s.a;
import com.android.volley.s.b;
import com.android.volley.toolbox.i;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map<Ljava.lang.String;Ljava.lang.String;>;
import org.apache.http.Header;
import org.apache.http.HttpEntity;

class c extends o<l>
{
  private final s.b<l> a;
  private Object b = null;
  private HttpEntity c = null;

  public c(int paramInt, String paramString, Object paramObject, s.b<l> paramb, s.a parama)
  {
    super(paramInt, paramString, parama);
    this.b = paramObject;
    this.a = paramb;
    if ((this.b != null) && ((this.b instanceof q)))
      this.c = ((q)this.b).a();
  }

  protected s<l> a(l paraml)
  {
    return s.a(paraml, i.a(paraml));
  }

  protected Map<String, String> a()
    throws a
  {
    if ((this.c == null) && (this.b != null) && ((this.b instanceof Map)))
      return (Map)this.b;
    return null;
  }

  public Map<String, String> b()
    throws a
  {
    Object localObject = super.b();
    if ((localObject == null) || (((Map)localObject).equals(Collections.emptyMap())))
      localObject = new HashMap();
    return (Map<String, String>)localObject;
  }

  protected void b(l paraml)
  {
    this.a.a(paraml);
  }

  public String c()
  {
    if (this.c != null)
      return this.c.getContentType().getValue();
    return null;
  }

  public byte[] d()
    throws a
  {
    if ((this.b != null) && ((this.b instanceof String)))
    {
      String str = (String)this.b;
      if (str.length() == 0)
        break label80;
      try
      {
        byte[] arrayOfByte = str.getBytes("UTF-8");
        return arrayOfByte;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
    }
    if (this.c != null)
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      try
      {
        this.c.writeTo(localByteArrayOutputStream);
        return localByteArrayOutputStream.toByteArray();
        label80: return null;
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        return null;
      }
    }
    return super.d();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.android.http.c
 * JD-Core Version:    0.6.0
 */