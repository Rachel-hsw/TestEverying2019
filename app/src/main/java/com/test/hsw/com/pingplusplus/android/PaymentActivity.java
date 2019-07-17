package com.pingplusplus.android;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.paysdk.api.BaiduPay;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.modelpay.PayReq;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.unionpay.UPPayAssistEx;
import com.unionpay.uppay.PayActivity;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class PaymentActivity extends Activity
  implements IWXAPIEventHandler
{
  public static final String EXTRA_CHARGE = "com.pingplusplus.android.PaymentActivity.CHARGE";
  public static final String EXTRA_CREDENTIAL = "com.pingplusplus.android.PaymentActivity.CREDENTIAL";
  private static String g = "https://m.jdpay.com/wepay/web/pay";
  WebViewClient a = new c(this);
  WebViewClient b = new d(this);
  WebViewClient c = new e(this);
  private String d = null;
  private ArrayList e = new ArrayList();
  private IWXAPI f = null;
  private int h = 0;
  private int i = 0;
  private ProgressDialog j = null;
  private String k = "cancel";
  private JSONObject l;
  private Handler m = new f(this);

  private void a(int paramInt, String paramString)
  {
    if (paramString == null)
    {
      a("cancel", "user_cancelled");
      return;
    }
    String str = paramString.substring(paramString.indexOf("statecode=") + "statecode={".length(), paramString.indexOf("};order_no="));
    if (str.equals("0"))
    {
      a("success");
      return;
    }
    if (str.equals("1"))
    {
      a("in_process");
      return;
    }
    if ((str.equals("2")) || (str.equals("7")))
    {
      a("cancel", "user_cancelled");
      return;
    }
    if (str.equals("3"))
    {
      a("fail", "bfb_not_supported_method");
      return;
    }
    if (str.equals("4"))
    {
      a("fail", "bfb_token_expired");
      return;
    }
    a("fail", "unknown_error");
  }

  private void a(String paramString)
  {
    a(paramString, "");
  }

  private void a(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, "");
  }

  private void a(String paramString1, String paramString2, String paramString3)
  {
    i.a().b(null);
    Intent localIntent = new Intent();
    localIntent.putExtra("pay_result", paramString1);
    localIntent.putExtra("error_msg", paramString2);
    localIntent.putExtra("extra_msg", paramString3);
    setResult(-1, localIntent);
    finish();
  }

  private void a(JSONObject paramJSONObject)
    throws JSONException
  {
    JSONObject localJSONObject = paramJSONObject.getJSONObject("alipay");
    PingppLog.d("PaymentActivity start alipay credential : " + paramJSONObject);
    new a(this, localJSONObject.getString("orderInfo")).start();
  }

  private boolean a(JSONObject paramJSONObject, String paramString1, String paramString2)
    throws JSONException
  {
    return ((paramString2 == null) || (paramString2.equals(paramString1))) && (paramJSONObject.has(paramString1)) && (!paramJSONObject.getString(paramString1).equals("[]")) && (!paramJSONObject.getString(paramString1).equals("{}"));
  }

  private void b(String paramString1, String paramString2)
  {
    PingppLog.d("模拟支付页面: 支付渠道" + paramString2);
    WebView localWebView = new WebView(this);
    localWebView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    setContentView(localWebView);
    WebSettings localWebSettings = localWebView.getSettings();
    localWebSettings.setJavaScriptEnabled(true);
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = localWebSettings.getUserAgentString();
    arrayOfObject[1] = "PingppAndroidSDK";
    arrayOfObject[2] = "2.0.6";
    localWebSettings.setUserAgentString(String.format("%s; %s/%s", arrayOfObject));
    localWebView.addJavascriptInterface(new g(this, this), "PingppAndroidSDK");
    localWebView.setWebViewClient(this.a);
    localWebView.loadUrl(String.format("http://sissi.pingxx.com/mock.php?ch_id=%s&channel=%s", new Object[] { paramString1, paramString2 }));
    this.j = ProgressDialog.show(this, "", "Loading", true);
  }

  private void b(JSONObject paramJSONObject)
    throws JSONException
  {
    JSONObject localJSONObject = paramJSONObject.getJSONObject("wx");
    PingppLog.d("PaymentActivity start wx credential : " + paramJSONObject);
    String str = localJSONObject.getString("appId");
    i.a().a(str);
    this.f = WXAPIFactory.createWXAPI(this, str);
    if (!this.f.isWXAppInstalled())
    {
      a("invalid", "wx_app_not_installed");
      return;
    }
    int n;
    PayReq localPayReq;
    if (this.f.getWXAppSupportAPI() >= 570425345)
    {
      n = 1;
      if (n == 0)
        break label284;
      this.h = 1;
      this.f.registerApp(str);
      this.f.handleIntent(getIntent(), this);
      localPayReq = new PayReq();
      localPayReq.appId = str;
      localPayReq.partnerId = localJSONObject.getString("partnerId");
      localPayReq.prepayId = localJSONObject.getString("prepayId");
      localPayReq.nonceStr = localJSONObject.getString("nonceStr");
      if (!(localJSONObject.get("timeStamp") instanceof String))
        break label251;
    }
    label251: for (localPayReq.timeStamp = localJSONObject.getString("timeStamp"); ; localPayReq.timeStamp = (localJSONObject.getInt("timeStamp") + ""))
    {
      localPayReq.packageValue = localJSONObject.getString("packageValue");
      localPayReq.sign = localJSONObject.getString("sign");
      this.f.sendReq(localPayReq);
      return;
      n = 0;
      break;
    }
    label284: a("fail", "wx_app_not_support");
  }

  private void c(JSONObject paramJSONObject)
    throws JSONException
  {
    JSONObject localJSONObject;
    if (paramJSONObject.has("upacp"))
    {
      localJSONObject = paramJSONObject.getJSONObject("upacp");
      PingppLog.d("PaymentActivity start upacp credential : " + paramJSONObject);
    }
    while (true)
    {
      UPPayAssistEx.startPayByJAR(this, PayActivity.class, null, null, localJSONObject.getString("tn"), localJSONObject.getString("mode"));
      return;
      localJSONObject = paramJSONObject.getJSONObject("upmp");
      PingppLog.d("PaymentActivity start upmp credential : " + paramJSONObject);
    }
  }

  private void d(JSONObject paramJSONObject)
    throws JSONException
  {
    JSONObject localJSONObject = paramJSONObject.getJSONObject("bfb");
    PingppLog.d("PaymentActivity start bfb credential : " + paramJSONObject);
    HashMap localHashMap = new HashMap();
    localHashMap.put("cashier_type", "0");
    ArrayList localArrayList1 = new ArrayList();
    Iterator localIterator = localJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      ArrayList localArrayList2 = new ArrayList();
      localArrayList2.add(str2);
      localArrayList2.add(localJSONObject.getString(str2));
      localArrayList1.add(TextUtils.join("=", localArrayList2));
    }
    if (localArrayList1.size() == 0)
    {
      a("fail", "invalid_credential");
      return;
    }
    String str1 = TextUtils.join("&", localArrayList1);
    this.i = 1;
    BaiduPay.getInstance().doPay(this, str1, new b(this), localHashMap);
  }

  // ERROR //
  private void e(JSONObject paramJSONObject)
    throws JSONException
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc_w 480
    //   4: invokevirtual 191	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   7: astore_2
    //   8: new 193	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   15: ldc_w 482
    //   18: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_1
    //   22: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 211	com/pingplusplus/android/PingppLog:d	(Ljava/lang/String;)V
    //   31: aload_2
    //   32: ldc_w 484
    //   35: invokevirtual 219	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   38: astore_3
    //   39: aload_2
    //   40: ldc_w 486
    //   43: invokevirtual 219	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   46: ldc_w 488
    //   49: invokestatic 494	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   52: astore 13
    //   54: aload 13
    //   56: astore 5
    //   58: aload_2
    //   59: ldc_w 496
    //   62: invokevirtual 219	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   65: ldc_w 488
    //   68: invokestatic 494	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   71: astore 14
    //   73: aload 14
    //   75: astore 7
    //   77: aload_2
    //   78: ldc_w 405
    //   81: invokevirtual 219	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   84: astore 8
    //   86: new 239	android/webkit/WebView
    //   89: dup
    //   90: aload_0
    //   91: invokespecial 242	android/webkit/WebView:<init>	(Landroid/content/Context;)V
    //   94: astore 9
    //   96: aload 9
    //   98: new 244	android/view/ViewGroup$LayoutParams
    //   101: dup
    //   102: iconst_m1
    //   103: iconst_m1
    //   104: invokespecial 247	android/view/ViewGroup$LayoutParams:<init>	(II)V
    //   107: invokevirtual 251	android/webkit/WebView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   110: aload_0
    //   111: aload 9
    //   113: invokevirtual 255	com/pingplusplus/android/PaymentActivity:setContentView	(Landroid/view/View;)V
    //   116: aload 9
    //   118: invokevirtual 259	android/webkit/WebView:getSettings	()Landroid/webkit/WebSettings;
    //   121: astore 10
    //   123: aload 10
    //   125: iconst_1
    //   126: invokevirtual 265	android/webkit/WebSettings:setJavaScriptEnabled	(Z)V
    //   129: iconst_3
    //   130: anewarray 267	java/lang/Object
    //   133: astore 11
    //   135: aload 11
    //   137: iconst_0
    //   138: aload 10
    //   140: invokevirtual 270	android/webkit/WebSettings:getUserAgentString	()Ljava/lang/String;
    //   143: aastore
    //   144: aload 11
    //   146: iconst_1
    //   147: ldc_w 272
    //   150: aastore
    //   151: aload 11
    //   153: iconst_2
    //   154: ldc_w 274
    //   157: aastore
    //   158: aload 10
    //   160: ldc_w 276
    //   163: aload 11
    //   165: invokestatic 280	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   168: invokevirtual 283	android/webkit/WebSettings:setUserAgentString	(Ljava/lang/String;)V
    //   171: aload 9
    //   173: new 498	com/pingplusplus/android/h
    //   176: dup
    //   177: aload_0
    //   178: invokespecial 499	com/pingplusplus/android/h:<init>	(Lcom/pingplusplus/android/PaymentActivity;)V
    //   181: ldc_w 272
    //   184: invokevirtual 292	android/webkit/WebView:addJavascriptInterface	(Ljava/lang/Object;Ljava/lang/String;)V
    //   187: aload 9
    //   189: aload_0
    //   190: getfield 73	com/pingplusplus/android/PaymentActivity:b	Landroid/webkit/WebViewClient;
    //   193: invokevirtual 296	android/webkit/WebView:setWebViewClient	(Landroid/webkit/WebViewClient;)V
    //   196: ldc_w 501
    //   199: aload 8
    //   201: invokevirtual 117	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   204: ifeq +71 -> 275
    //   207: ldc_w 503
    //   210: astore 12
    //   212: aload 9
    //   214: aload 12
    //   216: iconst_3
    //   217: anewarray 267	java/lang/Object
    //   220: dup
    //   221: iconst_0
    //   222: aload_3
    //   223: aastore
    //   224: dup
    //   225: iconst_1
    //   226: aload 5
    //   228: aastore
    //   229: dup
    //   230: iconst_2
    //   231: aload 7
    //   233: aastore
    //   234: invokestatic 280	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   237: invokevirtual 301	android/webkit/WebView:loadUrl	(Ljava/lang/String;)V
    //   240: aload_0
    //   241: aload_0
    //   242: ldc 153
    //   244: ldc_w 303
    //   247: iconst_1
    //   248: invokestatic 309	android/app/ProgressDialog:show	(Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Z)Landroid/app/ProgressDialog;
    //   251: putfield 57	com/pingplusplus/android/PaymentActivity:j	Landroid/app/ProgressDialog;
    //   254: return
    //   255: astore 4
    //   257: aconst_null
    //   258: astore 5
    //   260: aload 4
    //   262: astore 6
    //   264: aload 6
    //   266: invokevirtual 506	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   269: aconst_null
    //   270: astore 7
    //   272: goto -195 -> 77
    //   275: ldc_w 508
    //   278: astore 12
    //   280: goto -68 -> 212
    //   283: astore 6
    //   285: goto -21 -> 264
    //
    // Exception table:
    //   from	to	target	type
    //   39	54	255	java/io/UnsupportedEncodingException
    //   58	73	283	java/io/UnsupportedEncodingException
  }

  private void f(JSONObject paramJSONObject)
    throws JSONException
  {
    JSONObject localJSONObject = paramJSONObject.getJSONObject("jdpay_wap");
    PingppLog.d("PaymentActivity start jdpay_wap credential : " + paramJSONObject);
    WebView localWebView = new WebView(this);
    localWebView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    setContentView(localWebView);
    WebSettings localWebSettings = localWebView.getSettings();
    localWebSettings.setJavaScriptEnabled(true);
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = localWebSettings.getUserAgentString();
    arrayOfObject[1] = "PingppAndroidSDK";
    arrayOfObject[2] = "2.0.6";
    localWebSettings.setUserAgentString(String.format("%s; %s/%s", arrayOfObject));
    localWebView.addJavascriptInterface(new h(this), "PingppAndroidSDK");
    localWebView.setWebViewClient(this.c);
    ArrayList localArrayList1 = new ArrayList();
    Iterator localIterator = localJSONObject.keys();
    while (true)
      if (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        ArrayList localArrayList2 = new ArrayList();
        localArrayList2.add(str2);
        try
        {
          localArrayList2.add(URLEncoder.encode(localJSONObject.getString(str2), "UTF-8"));
          localArrayList1.add(TextUtils.join("=", localArrayList2));
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          while (true)
            localUnsupportedEncodingException.printStackTrace();
        }
      }
    if (localArrayList1.size() == 0)
    {
      a("fail", "invalid_credential");
      return;
    }
    String str1 = TextUtils.join("&", localArrayList1);
    PingppLog.d("jdPay orderInfo: " + str1);
    localWebView.postUrl(g, str1.getBytes());
    this.j = ProgressDialog.show(this, "", "Loading", true);
  }

  public static String getVersion()
  {
    return "2.0.6";
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((i.a().c() != null) && (!i.a().c().equalsIgnoreCase("upmp")) && (!i.a().c().equalsIgnoreCase("upacp")))
      return;
    if (paramIntent == null)
    {
      a("fail", "");
      return;
    }
    String str = paramIntent.getExtras().getString("pay_result");
    if (str == null)
    {
      a("fail");
      return;
    }
    if (str.equalsIgnoreCase("success"))
    {
      a("success");
      return;
    }
    if (str.equalsIgnoreCase("fail"))
    {
      a("fail", "channel_returns_fail");
      return;
    }
    if (str.equalsIgnoreCase("cancel"))
    {
      a("cancel", "user_cancelled");
      return;
    }
    a("fail", "unknown_error");
  }

  public void onBackPressed()
  {
    i.a().b(null);
    Intent localIntent = new Intent();
    localIntent.putExtra("pay_result", this.k);
    setResult(-1, localIntent);
    super.onBackPressed();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle != null);
    label343: String str3;
    do
    {
      return;
      this.l = null;
      Intent localIntent = getIntent();
      String str1 = localIntent.getStringExtra("com.pingplusplus.android.PaymentActivity.CHARGE");
      PingppLog.d("PaymentActivity receive charge: " + str1);
      JSONObject localJSONObject;
      if (str1 != null)
        try
        {
          this.l = new JSONObject(str1);
          this.e.add(this.l.getString("id"));
          if (this.l.has("credential"))
          {
            this.d = this.l.getString("channel");
            if ((this.l.has("livemode")) && (!this.l.getBoolean("livemode")))
            {
              b(this.l.getString("id"), this.d);
              return;
            }
          }
        }
        catch (JSONException localJSONException3)
        {
          a("fail", "invalid_charge_json_decode_fail");
          localJSONObject = null;
        }
      while (localJSONObject != null)
      {
        i.a().b(this.d);
        PingppLog.d("PaymentActivity receive channel: " + this.d);
        try
        {
          if ((!a(localJSONObject, "upmp", this.d)) && (!a(localJSONObject, "upacp", this.d)))
            break label343;
          c(localJSONObject);
          return;
        }
        catch (JSONException localJSONException1)
        {
          i.a().b(null);
          a("fail", "invalid_credential");
          return;
        }
        localJSONObject = this.l.getJSONObject("credential");
        continue;
        a("fail", "invalid_charge_no_credential");
        localJSONObject = null;
        continue;
        String str2 = localIntent.getStringExtra("com.pingplusplus.android.PaymentActivity.CREDENTIAL");
        if (str2 != null)
          try
          {
            localJSONObject = new JSONObject(str2);
          }
          catch (JSONException localJSONException2)
          {
            a("fail", "invalid_credential_json_decode_fail");
          }
        localJSONObject = null;
        continue;
        if (a(localJSONObject, "wx", this.d))
        {
          b(localJSONObject);
          return;
        }
        if (a(localJSONObject, "alipay", this.d))
        {
          a(localJSONObject);
          return;
        }
        if (a(localJSONObject, "bfb", this.d))
        {
          d(localJSONObject);
          return;
        }
        if (a(localJSONObject, "yeepay_wap", this.d))
        {
          e(localJSONObject);
          return;
        }
        if (a(localJSONObject, "jdpay_wap", this.d))
        {
          f(localJSONObject);
          return;
        }
        i.a().b(null);
        a("fail", "invalid_charge_no_such_channel");
        return;
      }
      str3 = i.a().b();
    }
    while (str3 == null);
    this.f = WXAPIFactory.createWXAPI(this, str3);
    this.f.handleIntent(getIntent(), this);
  }

  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if (this.f != null)
    {
      setIntent(paramIntent);
      this.f.handleIntent(paramIntent, this);
    }
  }

  protected void onPause()
  {
    super.onPause();
    if (this.h == 1)
      this.h = 2;
    do
      return;
    while ((this.i != 1) || (i.a().c() == null) || (!i.a().c().equalsIgnoreCase("bfb")));
    this.i = 2;
  }

  public void onReq(BaseReq paramBaseReq)
  {
  }

  public void onResp(BaseResp paramBaseResp)
  {
    if (paramBaseResp.getType() == 5)
    {
      PingppLog.d("PaymentActivity wx result errCode : " + paramBaseResp.errCode + " , errStr:" + paramBaseResp.errStr);
      this.h = 0;
      if (paramBaseResp.errCode == 0)
        a("success");
    }
    else
    {
      return;
    }
    if (paramBaseResp.errCode == -2)
    {
      a("cancel", "user_cancelled");
      return;
    }
    a("fail", "channel_returns_fail", "wx_err_code:" + paramBaseResp.errCode);
  }

  protected void onResume()
  {
    super.onResume();
    if ((this.h == 2) || (this.i == 2))
      a("cancel", "user_cancelled");
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.pingplusplus.android.PaymentActivity
 * JD-Core Version:    0.6.0
 */