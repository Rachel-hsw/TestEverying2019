package com.gensee.net;

public class AbsHttpAction
{
  protected static final String TAG = "AbsHttpAction";
  protected IHttpHandler mHttpHandler;

  public AbsHttpAction(IHttpHandler paramIHttpHandler)
  {
    this.mHttpHandler = paramIHttpHandler;
  }

  public static void getStream(String paramString, IHttpHandler.StreamResponse paramStreamResponse)
  {
    if (((paramString == null) || ("".equals(paramString))) && (paramStreamResponse != null))
      paramStreamResponse.onConnectError(3, "");
    new Thread(new AbsHttpAction.3(paramString, paramStreamResponse)).start();
  }

  protected void doGetRequest(String paramString, IHttpHandler.Response paramResponse)
  {
    new Thread(new AbsHttpAction.1(this, paramResponse, paramString)).start();
  }

  protected void doPostRequest(String paramString1, String paramString2, IHttpHandler.Response paramResponse)
  {
    new Thread(new AbsHttpAction.2(this, paramResponse, paramString1, paramString2)).start();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.net.AbsHttpAction
 * JD-Core Version:    0.6.0
 */