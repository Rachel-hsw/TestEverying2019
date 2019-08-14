package c.a;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import com.umeng.a.a;
import com.umeng.a.j;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class ey
{
  private String a;
  private String b = "10.0.0.172";
  private int c = 80;
  private Context d;
  private ew e;

  public ey(Context paramContext)
  {
    this.d = paramContext;
    this.a = a(paramContext);
  }

  private String a(Context paramContext)
  {
    StringBuffer localStringBuffer1 = new StringBuffer();
    localStringBuffer1.append("Android");
    localStringBuffer1.append("/");
    localStringBuffer1.append("5.5.3");
    localStringBuffer1.append(" ");
    try
    {
      StringBuffer localStringBuffer2 = new StringBuffer();
      localStringBuffer2.append(bt.v(paramContext));
      localStringBuffer2.append("/");
      localStringBuffer2.append(bt.d(paramContext));
      localStringBuffer2.append(" ");
      localStringBuffer2.append(Build.MODEL);
      localStringBuffer2.append("/");
      localStringBuffer2.append(Build.VERSION.RELEASE);
      localStringBuffer2.append(" ");
      localStringBuffer2.append(ch.a(a.a(paramContext)));
      localStringBuffer1.append(URLEncoder.encode(localStringBuffer2.toString(), "UTF-8"));
      return localStringBuffer1.toString();
    }
    catch (Exception localException)
    {
      while (true)
        localException.printStackTrace();
    }
  }

  private boolean a()
  {
    if (this.d.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", this.d.getPackageName()) != 0)
      return false;
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)this.d.getSystemService("connectivity")).getActiveNetworkInfo();
      if ((localNetworkInfo != null) && (localNetworkInfo.getType() != 1))
      {
        String str = localNetworkInfo.getExtraInfo();
        if (str != null)
          if ((!str.equals("cmwap")) && (!str.equals("3gwap")))
          {
            boolean bool = str.equals("uniwap");
            if (!bool);
          }
          else
          {
            return true;
          }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }

  private byte[] a(byte[] paramArrayOfByte, String paramString)
  {
    HttpPost localHttpPost = new HttpPost(paramString);
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 10000);
    HttpConnectionParams.setSoTimeout(localBasicHttpParams, 30000);
    DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient(localBasicHttpParams);
    localHttpPost.addHeader("X-Umeng-UTC", String.valueOf(System.currentTimeMillis()));
    localHttpPost.addHeader("X-Umeng-Sdk", this.a);
    localHttpPost.addHeader("Msg-Type", "envelope");
    try
    {
      if (a())
      {
        HttpHost localHttpHost = new HttpHost(this.b, this.c);
        localDefaultHttpClient.getParams().setParameter("http.route.default-proxy", localHttpHost);
      }
      localHttpPost.setEntity(new InputStreamEntity(new ByteArrayInputStream(paramArrayOfByte), paramArrayOfByte.length));
      if (this.e != null)
        this.e.l();
      HttpResponse localHttpResponse = localDefaultHttpClient.execute(localHttpPost);
      if (this.e != null)
        this.e.m();
      int i = localHttpResponse.getStatusLine().getStatusCode();
      boolean bool = ch.a(localHttpResponse.getFirstHeader("Content-Type"), "application/thrift");
      bu.c("MobclickAgent", "status code : " + i);
      if ((i == 200) && (bool))
      {
        bu.a("MobclickAgent", "Send message to " + paramString);
        HttpEntity localHttpEntity = localHttpResponse.getEntity();
        if (localHttpEntity != null)
        {
          InputStream localInputStream = localHttpEntity.getContent();
          try
          {
            byte[] arrayOfByte = ch.b(localInputStream);
            return arrayOfByte;
          }
          finally
          {
            ch.c(localInputStream);
          }
        }
      }
    }
    catch (ClientProtocolException localClientProtocolException)
    {
      bu.b("MobclickAgent", "ClientProtocolException,Failed to send message.", localClientProtocolException);
      return null;
      return null;
      return null;
    }
    catch (IOException localIOException)
    {
      bu.b("MobclickAgent", "IOException,Failed to send message.", localIOException);
    }
    return null;
  }

  public void a(ew paramew)
  {
    this.e = paramew;
  }

  public byte[] a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = null;
    for (int i = 0; ; i++)
    {
      if (i < j.f.length)
      {
        arrayOfByte = a(paramArrayOfByte, j.f[i]);
        if (arrayOfByte == null)
          break label45;
        if (this.e != null)
          this.e.n();
      }
      return arrayOfByte;
      label45: if (this.e == null)
        continue;
      this.e.o();
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     c.a.ey
 * JD-Core Version:    0.6.0
 */