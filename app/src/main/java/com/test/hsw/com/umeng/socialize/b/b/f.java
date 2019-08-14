package com.umeng.socialize.b.b;

import android.text.TextUtils;
import com.umeng.socialize.utils.i;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import java.util.zip.InflaterInputStream;
import org.a.b.a.a.a.b;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.json.JSONException;
import org.json.JSONObject;

public class f
{
  private static final String a = f.class.getName();
  private Map<String, String> b;
  private StringBuilder c;

  private static String a(InputStream paramInputStream)
  {
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream), 8192);
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      while (true)
      {
        String str = localBufferedReader.readLine();
        if (str == null)
          break;
        localStringBuilder.append(str + "\n");
      }
    }
    catch (IOException localIOException2)
    {
      i.b(a, "Caught IOException in convertStreamToString()", localIOException2);
      try
      {
        paramInputStream.close();
        return null;
        try
        {
          paramInputStream.close();
          return localStringBuilder.toString();
        }
        catch (IOException localIOException4)
        {
          i.b(a, "Caught IOException in convertStreamToString()", localIOException4);
          return null;
        }
      }
      catch (IOException localIOException3)
      {
        i.b(a, "Caught IOException in convertStreamToString()", localIOException3);
        return null;
      }
    }
    finally
    {
      try
      {
        paramInputStream.close();
        throw localObject;
      }
      catch (IOException localIOException1)
      {
        i.b(a, "Caught IOException in convertStreamToString()", localIOException1);
      }
    }
    return null;
  }

  private JSONObject a(g paramg)
  {
    int i = new Random().nextInt(1000);
    String str1 = paramg.e();
    while (true)
    {
      InputStream localInputStream;
      String str2;
      try
      {
        if (str1.length() > 1)
          continue;
        i.b(a, i + ":\tInvalid baseUrl.");
        return null;
        a(i + ":\tget: " + str1);
        localHttpGet = new HttpGet(str1);
        localHttpGet.addHeader("Accept-Encoding", "gzip");
        if ((this.b == null) || (this.b.size() <= 0))
          continue;
        Iterator localIterator = this.b.keySet().iterator();
        if (!localIterator.hasNext())
          continue;
        String str3 = (String)localIterator.next();
        localHttpGet.addHeader(str3, (String)this.b.get(str3));
        continue;
      }
      catch (ClientProtocolException localClientProtocolException)
      {
        HttpGet localHttpGet;
        i.c(a, i + ":\tClientProtocolException,Failed to send message." + str1, localClientProtocolException);
        return null;
        BasicHttpParams localBasicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 10000);
        HttpConnectionParams.setSoTimeout(localBasicHttpParams, 20000);
        HttpResponse localHttpResponse = new DefaultHttpClient(localBasicHttpParams).execute(localHttpGet);
        if (localHttpResponse.getStatusLine().getStatusCode() != 200)
          break label493;
        HttpEntity localHttpEntity = localHttpResponse.getEntity();
        if (localHttpEntity == null)
          break label522;
        localInputStream = localHttpEntity.getContent();
        Header localHeader = localHttpResponse.getFirstHeader("Content-Encoding");
        if ((localHeader == null) || (!localHeader.getValue().equalsIgnoreCase("gzip")))
          continue;
        i.a(a, i + "  Use GZIPInputStream get data....");
        localObject = new GZIPInputStream(localInputStream);
        str2 = a.b(a((InputStream)localObject), "UTF-8").trim();
        if (str2 == null)
        {
          return null;
          if ((localHeader == null) || (!localHeader.getValue().equalsIgnoreCase("deflate")))
            break label524;
          i.a(a, i + "  Use InflaterInputStream get data....");
          localObject = new InflaterInputStream(localInputStream);
          continue;
        }
      }
      catch (Exception localException)
      {
        i.c(a, i + ":\tIOException,Failed to send message." + str1, localException);
        return null;
      }
      return new JSONObject(str2);
      label493: i.c(a, i + ":\tFailed to get message." + str1);
      label522: return null;
      label524: Object localObject = localInputStream;
    }
  }

  private JSONObject a(String paramString, g paramg)
  {
    String str1;
    int i;
    HttpPost localHttpPost;
    DefaultHttpClient localDefaultHttpClient;
    if (paramg.d() == null)
    {
      str1 = "";
      i = new Random().nextInt(1000);
      System.getProperty("line.separator");
      localHttpPost = new HttpPost(paramString);
      BasicHttpParams localBasicHttpParams = new BasicHttpParams();
      HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 10000);
      HttpConnectionParams.setSoTimeout(localBasicHttpParams, 30000);
      localDefaultHttpClient = new DefaultHttpClient(localBasicHttpParams);
    }
    while (true)
    {
      InputStream localInputStream;
      try
      {
        Map localMap1 = paramg.b();
        if ((localMap1 == null) || (localMap1.size() <= 0))
          continue;
        localg = new org.a.b.a.a.g();
        Iterator localIterator1 = localMap1.keySet().iterator();
        if (!localIterator1.hasNext())
          continue;
        String str5 = (String)localIterator1.next();
        localg.a(str5, new org.a.b.a.a.a.g(localMap1.get(str5).toString(), Charset.defaultCharset()));
        continue;
      }
      catch (ClientProtocolException localClientProtocolException)
      {
        i.c(a, i + ":\tClientProtocolException,Failed to send message." + paramString, localClientProtocolException);
        return null;
        str1 = paramg.d().toString();
        break;
        Map localMap2 = paramg.c();
        if ((localMap2 == null) || (localMap2.size() <= 0))
          continue;
        Iterator localIterator2 = localMap2.keySet().iterator();
        if (!localIterator2.hasNext())
          continue;
        String str3 = (String)localIterator2.next();
        locala = (g.a)localMap2.get(str3);
        byte[] arrayOfByte = locala.b;
        if ((arrayOfByte == null) || (arrayOfByte.length < 1))
          continue;
        if (!TextUtils.isEmpty(locala.a))
          continue;
        str4 = "" + System.currentTimeMillis();
        b localb = new b(arrayOfByte, str4);
        localg.a(str3, localb);
        i.a(a, i + ":\tbody:  " + str3 + "=" + localb);
        a(i + ":\tbody:  " + str3 + "=[" + str4 + "]");
        continue;
      }
      catch (IOException localIOException)
      {
        org.a.b.a.a.g localg;
        g.a locala;
        i.c(a, i + ":\tIOException,Failed to send message." + paramString, localIOException);
        return null;
        String str4 = locala.a;
        continue;
        localHttpPost.setEntity(localg);
        HttpResponse localHttpResponse = localDefaultHttpClient.execute(localHttpPost);
        if (localHttpResponse.getStatusLine().getStatusCode() != 200)
          break label777;
        HttpEntity localHttpEntity = localHttpResponse.getEntity();
        if (localHttpEntity != null)
        {
          localInputStream = localHttpEntity.getContent();
          Header localHeader = localHttpResponse.getFirstHeader("Content-Encoding");
          if ((localHeader == null) || (!localHeader.getValue().equalsIgnoreCase("deflate")))
            break label810;
          localObject = new InflaterInputStream(localInputStream);
          str2 = a.b(a((InputStream)localObject), "UTF-8").trim();
          if (TextUtils.isEmpty(str2))
          {
            return null;
            ArrayList localArrayList = new ArrayList(1);
            localArrayList.add(new BasicNameValuePair("content", str1));
            localHttpPost.setEntity(new UrlEncodedFormEntity(localArrayList, "UTF-8"));
            continue;
          }
        }
      }
      catch (JSONException localJSONException)
      {
        String str2;
        i.c(a, i + ":\tIOException,Failed to send message." + paramString, localJSONException);
        localJSONException.printStackTrace();
        return null;
        JSONObject localJSONObject = new JSONObject(str2);
        return localJSONObject;
      }
      catch (Exception localException)
      {
        i.b(a, "### POST response decrypt Failed!  " + localException.toString());
        localException.printStackTrace();
        return null;
      }
      return null;
      label777: i.c(a, i + ":\tFailed to send message." + paramString);
      return null;
      label810: Object localObject = localInputStream;
    }
  }

  private void a(String paramString)
  {
    this.c.append(paramString);
  }

  private void b(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!(g.h.equals(paramString.trim()) ^ g.g.equals(paramString.trim()))))
      throw new RuntimeException("验证请求方式失败[" + paramString + "]");
  }

  public f a(Map<String, String> paramMap)
  {
    this.b = paramMap;
    return this;
  }

  public <T extends h> T a(g paramg, Class<T> paramClass)
  {
    String str = paramg.f().trim();
    b(str);
    this.c = new StringBuilder();
    JSONObject localJSONObject;
    if (g.h.equals(str))
      localJSONObject = a(paramg);
    while (true)
    {
      if (localJSONObject == null)
      {
        return null;
        if (g.g.equals(str))
        {
          localJSONObject = a(paramg.i, paramg);
          continue;
        }
      }
      else
      {
        try
        {
          h localh = (h)paramClass.getConstructor(new Class[] { JSONObject.class }).newInstance(new Object[] { localJSONObject });
          return localh;
        }
        catch (SecurityException localSecurityException)
        {
          i.b(a, "SecurityException", localSecurityException);
          return null;
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          while (true)
            i.b(a, "NoSuchMethodException", localNoSuchMethodException);
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          while (true)
            i.b(a, "IllegalArgumentException", localIllegalArgumentException);
        }
        catch (InstantiationException localInstantiationException)
        {
          while (true)
            i.b(a, "InstantiationException", localInstantiationException);
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          while (true)
            i.b(a, "IllegalAccessException", localIllegalAccessException);
        }
        catch (InvocationTargetException localInvocationTargetException)
        {
          while (true)
            i.b(a, "InvocationTargetException", localInvocationTargetException);
        }
      }
      localJSONObject = null;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.b.b.f
 * JD-Core Version:    0.6.0
 */