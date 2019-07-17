package org.android.agoo.c.a;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.umeng.message.b.ay;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.util.EntityUtils;

public class b
{
  private static final String a = "AsyncHttpResponseHandler";
  protected static final int c = 0;
  protected static final int d = 1;
  protected static final int e = 2;
  protected static final int f = 3;
  private volatile Handler b = null;

  private final Map<String, String> a(Header[] paramArrayOfHeader)
  {
    HashMap localHashMap = new HashMap();
    int i = paramArrayOfHeader.length;
    int j = 0;
    if (j < i)
    {
      Header localHeader = paramArrayOfHeader[j];
      String str1 = localHeader.getName();
      if (TextUtils.isEmpty(str1));
      while (true)
      {
        j++;
        break;
        String str2 = localHeader.getValue();
        if (TextUtils.isEmpty(str2))
          continue;
        localHashMap.put(str1.toLowerCase(), str2);
      }
    }
    return localHashMap;
  }

  private void a(Object paramObject)
  {
    try
    {
      if ((paramObject instanceof a))
      {
        a locala = (a)paramObject;
        int i = locala.a;
        Map localMap = locala.c;
        String str = locala.d;
        ay.b("AsyncHttpResponseHandler", "onHandleMessage[" + str + "]");
        if (i == 200)
        {
          a(localMap, str);
          return;
        }
        onFailure(new HttpResponseException(i, locala.b), localMap, str);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      ay.b("AsyncHttpResponseHandler", "onHandleMessage", localThrowable);
      onFailure(localThrowable, null, null);
      return;
    }
    ay.b("AsyncHttpResponseHandler", "onHandleMessage", new RuntimeException("!result instanceof IResponse"));
    onFailure(new RuntimeException("!result instanceof IResponse"), null, null);
  }

  Message a(int paramInt, Object paramObject)
  {
    try
    {
      if (this.b != null)
        return this.b.obtainMessage(paramInt, paramObject);
      Message localMessage = new Message();
      try
      {
        localMessage.what = paramInt;
        localMessage.obj = paramObject;
        return localMessage;
      }
      catch (Throwable localThrowable2)
      {
        return localMessage;
      }
    }
    catch (Throwable localThrowable1)
    {
    }
    return null;
  }

  public final void a()
  {
    b(a(2, null));
  }

  final void a(Message paramMessage)
  {
    try
    {
      switch (paramMessage.what)
      {
      case 0:
        a(paramMessage.obj);
        return;
      case 1:
        b((Throwable)paramMessage.obj);
        return;
      case 2:
        onStart();
        return;
      case 3:
        onFinish();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public final void a(Throwable paramThrowable)
  {
    b(a(1, paramThrowable));
  }

  protected void a(Map<String, String> paramMap, String paramString)
  {
    onSuccess(paramMap, paramString);
  }

  final void a(a parama)
  {
    b(a(0, parama));
  }

  public final void a(HttpResponse paramHttpResponse)
  {
    try
    {
      StatusLine localStatusLine = paramHttpResponse.getStatusLine();
      a locala = new a(null);
      locala.b = localStatusLine.getReasonPhrase();
      locala.c = a(paramHttpResponse.getAllHeaders());
      locala.a = localStatusLine.getStatusCode();
      HttpEntity localHttpEntity = paramHttpResponse.getEntity();
      if (localHttpEntity != null)
        locala.d = EntityUtils.toString(new BufferedHttpEntity(localHttpEntity), "UTF-8");
      a(locala);
      return;
    }
    catch (Throwable localThrowable)
    {
      a(localThrowable);
    }
  }

  public final void b()
  {
    b(a(3, null));
  }

  final void b(Message paramMessage)
  {
    try
    {
      if ((this.b != null) && (!Thread.currentThread().isInterrupted()))
      {
        this.b.sendMessage(paramMessage);
        return;
      }
      a(paramMessage);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  protected void b(Throwable paramThrowable)
  {
    onFailure(paramThrowable, null, null);
  }

  public void onFailure(Throwable paramThrowable)
  {
  }

  public void onFailure(Throwable paramThrowable, String paramString)
  {
    onFailure(paramThrowable);
  }

  public void onFailure(Throwable paramThrowable, Map<String, String> paramMap, String paramString)
  {
    onFailure(paramThrowable, paramString);
  }

  public final void onFinish()
  {
  }

  public final void onStart()
  {
  }

  public void onSuccess(String paramString)
  {
  }

  public void onSuccess(Map<String, String> paramMap, String paramString)
  {
    onSuccess(paramString);
  }

  class a
  {
    int a = -1;
    String b = "";
    Map<String, String> c = new HashMap();
    String d = "";

    private a()
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.android.agoo.c.a.b
 * JD-Core Version:    0.6.0
 */