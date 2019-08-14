package com.android.http;

import android.os.Handler;
import android.os.Message;
import com.google.gson.Gson;
import com.withustudy.koudaizikao.activity.AddPostActivity.a;
import com.withustudy.koudaizikao.activity.PersonalSetActivity.b;
import com.withustudy.koudaizikao.activity.PostDetailActivity.b;
import com.withustudy.koudaizikao.entity.FileUploadEntity;
import com.withustudy.koudaizikao.g.h;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.a.b.a.a.a.e;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class k extends Thread
{
  private static final String a = "http://img.kdzikao.com/picture/upload";
  private List<File> b;
  private String[] c;
  private Handler d;
  private String[] e;

  public k(List<File> paramList, String[] paramArrayOfString, Handler paramHandler)
  {
    this.b = paramList;
    this.c = paramArrayOfString;
    this.d = paramHandler;
    this.e = new String[paramList.size()];
  }

  private String a(File paramFile, String[] paramArrayOfString)
    throws ClientProtocolException, IOException
  {
    DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient();
    HttpPost localHttpPost = new HttpPost("http://img.kdzikao.com/picture/upload");
    e locale = new e(paramFile);
    org.a.b.a.a.a.g localg = new org.a.b.a.a.a.g(paramArrayOfString[0]);
    org.a.b.a.a.g localg1 = new org.a.b.a.a.g();
    localg1.a("pictureFile", locale);
    localg1.a("category", localg);
    localHttpPost.setEntity(localg1);
    HttpResponse localHttpResponse = localDefaultHttpClient.execute(localHttpPost);
    if (200 == localHttpResponse.getStatusLine().getStatusCode())
    {
      HttpEntity localHttpEntity = localHttpResponse.getEntity();
      if (localg1 != null)
        return EntityUtils.toString(localHttpEntity);
    }
    localDefaultHttpClient.getConnectionManager().shutdown();
    return null;
  }

  private void a()
  {
    if (this.e.length == 1);
  }

  public void run()
  {
    super.run();
    int i = 0;
    try
    {
      while (true)
      {
        if (i >= this.b.size())
        {
          a();
          if (!(this.d instanceof AddPostActivity.a))
            break;
          Message localMessage3 = this.d.obtainMessage(5, this.e);
          this.d.sendMessage(localMessage3);
          return;
        }
        String str = a((File)this.b.get(i), this.c);
        h.a("ret------>" + str);
        FileUploadEntity localFileUploadEntity = (FileUploadEntity)new Gson().fromJson(str, FileUploadEntity.class);
        this.e[i] = localFileUploadEntity.getUrl();
        i++;
      }
      if ((this.d instanceof PostDetailActivity.b))
      {
        Message localMessage2 = this.d.obtainMessage(7, this.e);
        this.d.sendMessage(localMessage2);
        return;
      }
    }
    catch (ClientProtocolException localClientProtocolException)
    {
      localClientProtocolException.printStackTrace();
      return;
      if ((this.d instanceof PersonalSetActivity.b))
      {
        Message localMessage1 = this.d.obtainMessage(1, this.e);
        this.d.sendMessage(localMessage1);
        return;
      }
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.android.http.k
 * JD-Core Version:    0.6.0
 */