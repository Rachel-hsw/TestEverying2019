package org.android.agoo.c.a;

import android.content.Context;
import com.umeng.message.b.bl;
import com.umeng.message.b.bp;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HttpContext;

public class a extends bl
{
  private static final String c = "AsyncHttp.client";
  private final ThreadPoolExecutor a = (ThreadPoolExecutor)Executors.newFixedThreadPool(5);
  private final Map<Context, List<WeakReference<Future<?>>>> b = new WeakHashMap();

  private HttpEntity a(d paramd)
  {
    HttpEntity localHttpEntity = null;
    if (paramd != null)
      localHttpEntity = paramd.a();
    return localHttpEntity;
  }

  private void a(Context paramContext, DefaultHttpClient paramDefaultHttpClient, HttpContext paramHttpContext, HttpHost paramHttpHost, HttpUriRequest paramHttpUriRequest, String paramString, b paramb)
  {
    if (paramString != null)
      paramHttpUriRequest.addHeader("Content-Type", paramString);
    Future localFuture = this.a.submit(new bp(paramContext, paramDefaultHttpClient, paramHttpContext, paramHttpHost, paramHttpUriRequest, paramb));
    if (paramContext != null)
    {
      Object localObject = (List)this.b.get(paramContext);
      if (localObject == null)
      {
        localObject = new LinkedList();
        this.b.put(paramContext, localObject);
      }
      ((List)localObject).add(new WeakReference(localFuture));
    }
  }

  public final void a(Context paramContext, String paramString, b paramb)
  {
    a(paramContext, null, paramString, null, null, paramb);
  }

  public final void a(Context paramContext, String paramString1, d paramd, String paramString2, b paramb)
  {
    a(paramContext, paramString1, null, paramd, paramString2, paramb);
  }

  public final void a(Context paramContext, String paramString, d paramd, b paramb)
  {
    a(paramContext, null, paramString, null, paramd, paramb);
  }

  public final void a(Context paramContext, String paramString, HttpHost paramHttpHost, b paramb)
  {
    a(paramContext, paramHttpHost, paramString, null, null, paramb);
  }

  public final void a(Context paramContext, String paramString1, Header[] paramArrayOfHeader, d paramd, String paramString2, b paramb)
  {
    HttpPost localHttpPost = new HttpPost(paramString1);
    if (paramd != null)
      localHttpPost.setEntity(a(paramd));
    if (paramArrayOfHeader != null)
      localHttpPost.setHeaders(paramArrayOfHeader);
    a(paramContext, a(), b(), null, localHttpPost, paramString2, paramb);
  }

  public final void a(Context paramContext, HttpHost paramHttpHost, String paramString, d paramd, b paramb)
  {
    a(paramContext, paramHttpHost, paramString, null, paramd, paramb);
  }

  public final void a(Context paramContext, HttpHost paramHttpHost, String paramString, Header[] paramArrayOfHeader, d paramd, b paramb)
  {
    HttpGet localHttpGet = new HttpGet(a(paramString, paramd));
    if (paramArrayOfHeader != null)
      localHttpGet.setHeaders(paramArrayOfHeader);
    a(paramContext, a(), b(), paramHttpHost, localHttpGet, null, paramb);
  }

  public final void a(Context paramContext, boolean paramBoolean)
  {
    List localList = (List)this.b.get(paramContext);
    if (localList != null)
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        Future localFuture = (Future)((WeakReference)localIterator.next()).get();
        if (localFuture == null)
          continue;
        localFuture.cancel(paramBoolean);
      }
    }
    this.b.remove(paramContext);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.android.agoo.c.a.a
 * JD-Core Version:    0.6.0
 */