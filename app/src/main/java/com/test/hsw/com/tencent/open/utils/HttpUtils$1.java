package com.tencent.open.utils;

import android.content.Context;
import android.os.Bundle;
import com.tencent.connect.auth.QQToken;
import com.tencent.open.a.f;
import com.tencent.tauth.IRequestListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

final class HttpUtils$1 extends Thread
{
  public void run()
  {
    try
    {
      JSONObject localJSONObject = HttpUtils.request(this.a, this.b, this.c, this.d, this.e);
      if (this.f != null)
      {
        this.f.onComplete(localJSONObject);
        f.b(f.d, "OpenApi onComplete");
      }
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      while (this.f == null);
      this.f.onMalformedURLException(localMalformedURLException);
      f.b(f.d, "OpenApi requestAsync MalformedURLException", localMalformedURLException);
      return;
    }
    catch (ConnectTimeoutException localConnectTimeoutException)
    {
      while (this.f == null);
      this.f.onConnectTimeoutException(localConnectTimeoutException);
      f.b(f.d, "OpenApi requestAsync onConnectTimeoutException", localConnectTimeoutException);
      return;
    }
    catch (SocketTimeoutException localSocketTimeoutException)
    {
      while (this.f == null);
      this.f.onSocketTimeoutException(localSocketTimeoutException);
      f.b(f.d, "OpenApi requestAsync onSocketTimeoutException", localSocketTimeoutException);
      return;
    }
    catch (HttpUtils.NetworkUnavailableException localNetworkUnavailableException)
    {
      while (this.f == null);
      this.f.onNetworkUnavailableException(localNetworkUnavailableException);
      f.b(f.d, "OpenApi requestAsync onNetworkUnavailableException", localNetworkUnavailableException);
      return;
    }
    catch (HttpUtils.HttpStatusException localHttpStatusException)
    {
      while (this.f == null);
      this.f.onHttpStatusException(localHttpStatusException);
      f.b(f.d, "OpenApi requestAsync onHttpStatusException", localHttpStatusException);
      return;
    }
    catch (IOException localIOException)
    {
      while (this.f == null);
      this.f.onIOException(localIOException);
      f.b(f.d, "OpenApi requestAsync IOException", localIOException);
      return;
    }
    catch (JSONException localJSONException)
    {
      while (this.f == null);
      this.f.onJSONException(localJSONException);
      f.b(f.d, "OpenApi requestAsync JSONException", localJSONException);
      return;
    }
    catch (Exception localException)
    {
      while (this.f == null);
      this.f.onUnknowException(localException);
      f.b(f.d, "OpenApi requestAsync onUnknowException", localException);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.open.utils.HttpUtils.1
 * JD-Core Version:    0.6.0
 */