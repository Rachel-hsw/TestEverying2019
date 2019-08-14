package com.umeng.socialize.weixin.a;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.modelmsg.SendAuth.Req;
import com.tencent.mm.sdk.modelmsg.SendAuth.Resp;
import com.tencent.mm.sdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.sdk.modelmsg.WXEmojiObject;
import com.tencent.mm.sdk.modelmsg.WXImageObject;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.modelmsg.WXMusicObject;
import com.tencent.mm.sdk.modelmsg.WXTextObject;
import com.tencent.mm.sdk.modelmsg.WXVideoObject;
import com.tencent.mm.sdk.modelmsg.WXWebpageObject;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.umeng.socialize.bean.UMShareMsg;
import com.umeng.socialize.bean.as;
import com.umeng.socialize.bean.ax;
import com.umeng.socialize.bean.ay;
import com.umeng.socialize.bean.j;
import com.umeng.socialize.bean.p;
import com.umeng.socialize.common.b.a;
import com.umeng.socialize.common.s;
import com.umeng.socialize.controller.listener.SocializeListeners.SnsPostListener;
import com.umeng.socialize.controller.listener.SocializeListeners.SocializeClientListener;
import com.umeng.socialize.controller.listener.SocializeListeners.UMAuthListener;
import com.umeng.socialize.controller.listener.SocializeListeners.UMDataListener;
import com.umeng.socialize.media.BaseShareContent;
import com.umeng.socialize.media.UMEmoji;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMVideo;
import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.media.UMusic;
import com.umeng.socialize.sso.v;
import com.umeng.socialize.utils.i;
import com.umeng.socialize.utils.k;
import com.umeng.socialize.utils.m;
import com.umeng.socialize.utils.n;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map<Ljava.lang.String;Ljava.lang.Object;>;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a extends v
{
  private static final String J = "video";
  private static final String K = "music";
  private static final String L = "emoji";
  private static final String U = "分享到";
  private static ay m;
  private static final String o = "text";
  private static final String p = "image";
  private static final String q = "text_image";
  private final int M = 1;
  private final int N = 2;
  private boolean O = true;
  private String P = "";
  private String Q;
  private WXMediaMessage R = null;
  private boolean S = false;
  private SocializeListeners.UMAuthListener T;
  private boolean V = false;
  private final Handler W = new c(this);
  private IWXAPIEventHandler X = new d(this);
  private final int a = 150;
  private final int b = 32768;
  private final int c = 512;
  private final int d = 1024;
  private final int e = 604800;
  private String f;
  private String g = "";
  private int h = 0;
  private int i = 0;
  private IWXAPI j;
  private boolean k = false;
  private boolean l = true;
  private final String n = "UMWXHandler";

  @Deprecated
  public a(Context paramContext, String paramString)
  {
    this(paramContext, paramString, null);
    i.e("UMWXHandler", "为了保证微信授权正常，请传递应用的secret");
  }

  public a(Context paramContext, String paramString1, String paramString2)
  {
    this.D = paramContext.getApplicationContext();
    this.f = paramString1;
    if (TextUtils.isEmpty(this.f))
      throw new NullPointerException("the weixin appid is null");
    this.j = WXAPIFactory.createWXAPI(this.D, this.f);
    this.j.registerApp(this.f);
    this.g = paramString2;
    this.H.put("wx_appid", this.f);
    if (TextUtils.isEmpty(this.g))
      this.g = "";
    this.H.put("wx_secret", this.g);
    if ((this.h == 0) || (this.i == 0))
    {
      this.h = com.umeng.socialize.common.b.a(paramContext, b.a.c, "umeng_socialize_wechat");
      this.i = com.umeng.socialize.common.b.a(paramContext, b.a.c, "umeng_socialize_wxcircle");
    }
  }

  private void a(BaseResp paramBaseResp)
  {
    if (paramBaseResp.errCode != 0)
    {
      if (paramBaseResp.errCode == -2)
      {
        SocializeListeners.UMAuthListener localUMAuthListener2 = this.T;
        if (this.k);
        for (p localp2 = p.j; ; localp2 = p.i)
        {
          localUMAuthListener2.a(localp2);
          return;
        }
      }
      SocializeListeners.UMAuthListener localUMAuthListener1 = this.T;
      com.umeng.socialize.a.a locala = new com.umeng.socialize.a.a("aouth error! error code :" + paramBaseResp.errCode);
      if (this.k);
      for (p localp1 = p.j; ; localp1 = p.i)
      {
        localUMAuthListener1.a(locala, localp1);
        return;
      }
    }
    String str = ((SendAuth.Resp)paramBaseResp).code;
    f("https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + this.f + "&secret=" + this.g + "&code=" + str + "&grant_type=authorization_code");
  }

  private byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    int i1 = 0;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= paramInt))
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      Bitmap localBitmap = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length);
      int i2 = 1;
      while ((i1 == 0) && (i2 <= 10))
      {
        int i3 = (int)(100.0D * Math.pow(0.8D, i2));
        i.c("UMWXHandler", "quality = " + i3);
        localBitmap.compress(Bitmap.CompressFormat.JPEG, i3, localByteArrayOutputStream);
        i.c("UMWXHandler", "WeiXin Thumb Size = " + localByteArrayOutputStream.toByteArray().length / 1024 + " KB");
        if ((localByteArrayOutputStream != null) && (localByteArrayOutputStream.size() < paramInt))
        {
          i1 = 1;
          continue;
        }
        localByteArrayOutputStream.reset();
        i2++;
      }
      if (localByteArrayOutputStream != null)
      {
        paramArrayOfByte = localByteArrayOutputStream.toByteArray();
        if (!localBitmap.isRecycled())
          localBitmap.recycle();
        if ((paramArrayOfByte != null) && (paramArrayOfByte.length <= 0))
          i.b("UMWXHandler", "### 您的原始图片太大,导致缩略图压缩过后还大于32KB,请将分享到微信的图片进行适当缩小.");
      }
    }
    return paramArrayOfByte;
  }

  private boolean b(Context paramContext)
  {
    if (!this.k);
    String str;
    do
    {
      return false;
      str = com.umeng.socialize.utils.c.b("com.tencent.mm", paramContext);
    }
    while (TextUtils.isEmpty(str));
    return str.startsWith("6.0.2.56");
  }

  private Bitmap c(String paramString)
  {
    boolean bool = com.umeng.socialize.utils.a.a(paramString);
    Bitmap localBitmap = null;
    if (bool)
    {
      if (com.umeng.socialize.utils.a.a(paramString, 32768))
        localBitmap = com.umeng.socialize.utils.a.b(paramString, 150, 150);
    }
    else
      return localBitmap;
    return com.umeng.socialize.utils.a.b(paramString);
  }

  private String e(String paramString)
  {
    if (paramString == null)
      return String.valueOf(System.currentTimeMillis());
    return paramString + System.currentTimeMillis();
  }

  private void f(String paramString)
  {
    new e(this, paramString).c();
  }

  private Bundle g(String paramString)
  {
    Bundle localBundle = new Bundle();
    if (TextUtils.isEmpty(paramString))
      return localBundle;
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      Iterator localIterator = localJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localBundle.putString(str, localJSONObject.optString(str));
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    while (true)
    {
      return localBundle;
      localBundle.putString("uid", localBundle.getString("openid"));
      localBundle.putLong("refresh_token_expires", 604800L);
    }
  }

  private Map<String, Object> h(String paramString)
  {
    Object localObject = new HashMap();
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      if (localJSONObject.has("errcode"))
      {
        i.b("UMWXHandler", paramString + "");
        ((Map)localObject).put("errcode", localJSONObject.getString("errcode"));
        return localObject;
      }
      ((Map)localObject).put("openid", localJSONObject.opt("openid"));
      ((Map)localObject).put("nickname", localJSONObject.opt("nickname"));
      ((Map)localObject).put("language", localJSONObject.opt("language"));
      ((Map)localObject).put("city", localJSONObject.opt("city"));
      ((Map)localObject).put("province", localJSONObject.opt("province"));
      ((Map)localObject).put("country", localJSONObject.opt("country"));
      ((Map)localObject).put("headimgurl", localJSONObject.opt("headimgurl"));
      ((Map)localObject).put("unionid", localJSONObject.opt("unionid"));
      ((Map)localObject).put("sex", localJSONObject.opt("sex"));
      JSONArray localJSONArray = localJSONObject.getJSONArray("privilege");
      int i1 = localJSONArray.length();
      if (i1 > 0)
      {
        String[] arrayOfString = new String[i1];
        for (int i2 = 0; i2 < i1; i2++)
          arrayOfString[i2] = localJSONArray.get(i2).toString();
        ((Map)localObject).put("privilege", arrayOfString);
        return localObject;
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      localObject = Collections.emptyMap();
    }
    return (Map<String, Object>)localObject;
  }

  private void l()
  {
    if ((this.F instanceof BaseShareContent))
    {
      BaseShareContent localBaseShareContent = (BaseShareContent)this.F;
      this.E = localBaseShareContent.k();
      this.F = localBaseShareContent.c();
      this.v = localBaseShareContent.j();
      this.w = localBaseShareContent.i();
    }
  }

  private void m()
  {
    if ((!TextUtils.isEmpty(this.E)) && (this.F == null))
      this.Q = "text";
    do
    {
      return;
      if ((this.F != null) && ((this.F instanceof UMEmoji)))
      {
        this.Q = "emoji";
        return;
      }
      if ((TextUtils.isEmpty(this.E)) && (this.F != null) && ((this.F instanceof UMImage)))
      {
        this.Q = "image";
        return;
      }
      if ((this.F != null) && ((this.F instanceof UMusic)))
      {
        this.Q = "music";
        return;
      }
      if ((this.F == null) || (!(this.F instanceof UMVideo)))
        continue;
      this.Q = "video";
      return;
    }
    while ((TextUtils.isEmpty(this.E)) || (this.F == null) || (!(this.F instanceof UMImage)));
    this.Q = "text_image";
  }

  private WXMediaMessage n()
  {
    UMEmoji localUMEmoji = (UMEmoji)this.F;
    UMImage localUMImage = localUMEmoji.i;
    String str = localUMImage.k();
    WXEmojiObject localWXEmojiObject = new WXEmojiObject();
    if (localUMEmoji.i.b())
    {
      str = com.umeng.socialize.utils.a.c(localUMImage.a());
      if (!new File(str).exists())
        com.umeng.socialize.utils.a.a(localUMImage.a(), 150, 150);
    }
    localWXEmojiObject.emojiPath = str;
    WXMediaMessage localWXMediaMessage = new WXMediaMessage();
    localWXMediaMessage.mediaObject = localWXEmojiObject;
    if (localUMEmoji.i() != null)
      localWXMediaMessage.thumbData = localUMEmoji.h.d_();
    while (true)
    {
      localWXMediaMessage.title = this.w;
      localWXMediaMessage.description = this.E;
      return localWXMediaMessage;
      if (!TextUtils.isEmpty(localUMEmoji.d()))
      {
        Bitmap localBitmap = com.umeng.socialize.utils.a.a(localUMEmoji.d(), 150, 150);
        localWXMediaMessage.thumbData = com.umeng.socialize.utils.a.a(localBitmap);
        localBitmap.recycle();
        continue;
      }
      localWXMediaMessage.thumbData = localUMEmoji.i.d_();
    }
  }

  private WXMediaMessage o()
  {
    f(this.F);
    String str = (String)this.H.get("audio_url");
    WXMusicObject localWXMusicObject = new WXMusicObject();
    localWXMusicObject.musicUrl = this.v;
    localWXMusicObject.musicDataUrl = str;
    WXMediaMessage localWXMediaMessage = t();
    localWXMediaMessage.mediaObject = localWXMusicObject;
    localWXMediaMessage.title = this.w;
    localWXMediaMessage.description = this.E;
    localWXMediaMessage.mediaObject = localWXMusicObject;
    return localWXMediaMessage;
  }

  private WXMediaMessage p()
  {
    WXTextObject localWXTextObject = new WXTextObject();
    localWXTextObject.text = this.E;
    WXMediaMessage localWXMediaMessage = new WXMediaMessage();
    localWXMediaMessage.mediaObject = localWXTextObject;
    localWXMediaMessage.description = this.E;
    localWXMediaMessage.title = this.w;
    return localWXMediaMessage;
  }

  private WXMediaMessage q()
  {
    e(this.F);
    WXImageObject localWXImageObject = new WXImageObject();
    WXMediaMessage localWXMediaMessage = t();
    if (!TextUtils.isEmpty((CharSequence)this.H.get("image_path_local")))
      localWXImageObject.imagePath = ((String)this.H.get("image_path_local"));
    while (true)
    {
      localWXMediaMessage.mediaObject = localWXImageObject;
      return localWXMediaMessage;
      localWXImageObject.imageUrl = ((String)this.H.get("image_path_url"));
    }
  }

  private WXMediaMessage r()
  {
    g(this.F);
    String str = (String)this.H.get("audio_url");
    WXVideoObject localWXVideoObject = new WXVideoObject();
    localWXVideoObject.videoUrl = str;
    WXMediaMessage localWXMediaMessage = t();
    localWXMediaMessage.mediaObject = localWXVideoObject;
    localWXMediaMessage.title = this.w;
    localWXMediaMessage.description = this.E;
    return localWXMediaMessage;
  }

  private WXMediaMessage s()
  {
    e(this.F);
    if (TextUtils.isEmpty(this.v))
      this.v = "http://www.umeng.com/social";
    WXWebpageObject localWXWebpageObject = new WXWebpageObject();
    localWXWebpageObject.webpageUrl = this.v;
    WXMediaMessage localWXMediaMessage = t();
    localWXMediaMessage.title = this.w;
    localWXMediaMessage.description = this.E;
    localWXMediaMessage.mediaObject = localWXWebpageObject;
    return localWXMediaMessage;
  }

  private WXMediaMessage t()
  {
    String str1 = (String)this.H.get("image_path_local");
    String str2 = (String)this.H.get("image_path_url");
    WXMediaMessage localWXMediaMessage = new WXMediaMessage();
    if (!TextUtils.isEmpty(str2))
      localWXMediaMessage.thumbData = com.umeng.socialize.utils.a.a(com.umeng.socialize.utils.a.a(str2, 150, 150));
    Bitmap localBitmap;
    do
    {
      do
        return localWXMediaMessage;
      while (TextUtils.isEmpty(str1));
      localBitmap = c(str1);
      localWXMediaMessage.thumbData = com.umeng.socialize.utils.a.a(localBitmap);
    }
    while ((localBitmap == null) || (localBitmap.isRecycled()));
    localBitmap.recycle();
    return localWXMediaMessage;
  }

  private void u()
  {
    Toast.makeText(this.D, "分享失败，详情见Logcat", 0).show();
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.k)
    {
      localStringBuilder.append("请添加朋友圈平台到SDK \n");
      localStringBuilder.append("添加方式：\nUMWXHandler wxCircleHandler = new UMWXHandler(getActivity(),\"你的AppID\",\"你的AppSecret\");\n");
      localStringBuilder.append("wxCircleHandler.setToCircle(true);\n");
      localStringBuilder.append("wxCircleHandler.addToSocialSDK();\n");
      localStringBuilder.append("参考文档：\nhttp://dev.umeng.com/social/android/share/quick-integration#social_weixin");
    }
    while (true)
    {
      i.b("UMWXHandler", localStringBuilder.toString());
      return;
      localStringBuilder.append("请添加微信平台到SDK \n");
      localStringBuilder.append("添加方式：\nUMWXHandler wxHandler = new UMWXHandler(getActivity(),\"你的AppID\",\"你的AppSecret\");\n");
      localStringBuilder.append("wxHandler.addToSocialSDK();\n");
      localStringBuilder.append("参考文档：\nhttp://dev.umeng.com/social/android/share/quick-integration#social_weixin");
    }
  }

  private void v()
  {
    if (!this.k)
    {
      ax.e(p.i);
      return;
    }
    ax.e(p.j);
  }

  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
  }

  public void a(Activity paramActivity, SocializeListeners.UMAuthListener paramUMAuthListener)
  {
    if ((TextUtils.isEmpty(this.f)) || (TextUtils.isEmpty(this.g)))
    {
      i.b("UMWXHandler", "Appid或者App secret为空，不能授权。请设置正确地Appid跟App Secret");
      return;
    }
    this.T = paramUMAuthListener;
    SocializeListeners.UMAuthListener localUMAuthListener = this.T;
    if (this.k);
    for (p localp = p.j; ; localp = p.i)
    {
      localUMAuthListener.b(localp);
      this.S = true;
      boolean bool = k.j(paramActivity, p.i);
      if (!bool)
        bool = k.j(paramActivity, p.j);
      if ((!bool) || (!this.l))
        break;
      String str = k.i(paramActivity, p.i);
      if (TextUtils.isEmpty(str))
        str = k.i(paramActivity, p.j);
      f("https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=" + this.f + "&grant_type=refresh_token&refresh_token=" + str);
      return;
    }
    SendAuth.Req localReq = new SendAuth.Req();
    localReq.scope = "snsapi_userinfo,snsapi_friend,snsapi_message";
    localReq.state = "none";
    this.j.sendReq(localReq);
  }

  protected void a(Context paramContext, com.umeng.socialize.bean.b paramb, ay paramay, SocializeListeners.SnsPostListener paramSnsPostListener)
  {
    if ("deault_id".equals(this.f))
      u();
    while (true)
    {
      return;
      UMShareMsg localUMShareMsg;
      if (paramay != null)
      {
        m = paramay;
        v();
        localUMShareMsg = paramay.p();
        if ((localUMShareMsg == null) || (m.j() != as.a))
          break label112;
        this.E = localUMShareMsg.a;
      }
      for (this.F = localUMShareMsg.a(); ; this.F = paramay.a())
      {
        m.a(as.b);
        this.C.b(paramSnsPostListener);
        if (e())
          break;
        Toast.makeText(this.D, "你还没有安装微信", 0).show();
        return;
        label112: this.E = paramay.d();
      }
      if (!this.j.isWXAppSupportAPI())
      {
        Toast.makeText(this.D, "你安装的微信版本不支持当前API", 0).show();
        return;
      }
      if ((this.F == null) && (TextUtils.isEmpty(this.E)))
        break;
      l();
      m();
      if ((this.Q == "emoji") && (this.k))
      {
        Toast.makeText(this.D, "微信朋友圈不支持表情分享...", 0).show();
        return;
      }
      if (TextUtils.isEmpty(this.Q))
        continue;
      new a(paramContext, null).c();
      return;
    }
    Toast.makeText(this.D, "请设置分享内容...", 0).show();
  }

  public void a(ay paramay, p paramp, SocializeListeners.SocializeClientListener paramSocializeClientListener)
  {
    k.g(this.D, paramp);
    if (paramSocializeClientListener != null)
    {
      paramSocializeClientListener.a();
      paramSocializeClientListener.a(200, paramay);
    }
  }

  protected void a(com.umeng.socialize.bean.b paramb, ay paramay, SocializeListeners.SnsPostListener paramSnsPostListener)
  {
  }

  public void a(SocializeListeners.UMDataListener paramUMDataListener)
  {
    String str1 = k.e(this.D, p.i);
    if (TextUtils.isEmpty(str1))
      str1 = k.e(this.D, p.j);
    String str2 = k.f(this.D, p.i)[0];
    if (TextUtils.isEmpty(str2))
      str2 = k.f(this.D, p.j)[0];
    if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)))
    {
      i.b("UMWXHandler", "please check had authed...");
      paramUMDataListener.a(40002, null);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://api.weixin.qq.com/sns/userinfo?access_token=");
    localStringBuilder.append(str2).append("&openid=").append(str1);
    if (ax.b().e() == j.a)
      localStringBuilder.append("&lang=zh_CN");
    new f(this, localStringBuilder, paramUMDataListener).c();
  }

  public void a(String paramString)
  {
    this.w = paramString;
  }

  public void a(boolean paramBoolean)
  {
    this.O = paramBoolean;
  }

  protected boolean a(Context paramContext)
  {
    if (this.D == null)
      return false;
    int i1 = 1;
    String str = this.D.getPackageName() + ".wxapi.WXEntryActivity";
    try
    {
      Class.forName(str);
      i.c("UMWXHandler", "### 微信或微信朋友圈回调类地址 : " + str);
      return i1;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      while (true)
      {
        i.b("UMWXHandler", str + " 类没有找到. 请把weixin文件夹中的wxapi目录拷贝到您的包目录下.");
        i1 = 0;
      }
    }
  }

  public void b(String paramString)
  {
    this.g = paramString;
  }

  protected void b(boolean paramBoolean)
  {
    int i1 = 5029;
    p localp;
    if (this.k)
      localp = p.j;
    while (true)
    {
      if (paramBoolean);
      try
      {
        n.a(this.D, localp, 17);
        label29: i1 = 200;
        Context localContext;
        String str1;
        String str2;
        UMediaObject localUMediaObject;
        if ((!a(this.D)) || (b(this.D)))
        {
          this.C.a(SocializeListeners.SnsPostListener.class, localp, i1, m);
          if ((paramBoolean) && (m != null))
          {
            localContext = this.D;
            str1 = m.c;
            str2 = this.P;
            localUMediaObject = this.F;
            if (!this.k)
              break label139;
          }
        }
        label139: for (String str3 = "wxtimeline"; ; str3 = "wxsession")
        {
          m.a(localContext, str1, str2, localUMediaObject, str3);
          return;
          localp = p.i;
          break;
        }
      }
      catch (Exception localException)
      {
        break label29;
      }
    }
  }

  public IWXAPIEventHandler c()
  {
    return this.X;
  }

  public final com.umeng.socialize.bean.b d()
  {
    int i1;
    String str1;
    label23: String str2;
    if (this.k)
    {
      i1 = this.i;
      if (!this.k)
        break label107;
      str1 = "weixin_circle";
      if (!this.k)
        break label114;
      str2 = "朋友圈";
      label34: this.G = new com.umeng.socialize.bean.b(str1, str2, i1);
      if (!this.k)
        break label121;
    }
    label107: label114: label121: for (int i2 = com.umeng.socialize.common.b.a(this.D, b.a.c, "umeng_socialize_wxcircle_gray"); ; i2 = com.umeng.socialize.common.b.a(this.D, b.a.c, "umeng_socialize_wechat_gray"))
    {
      this.G.d = i2;
      this.G.k = new b(this);
      return this.G;
      i1 = this.h;
      break;
      str1 = "weixin";
      break label23;
      str2 = "微信";
      break label34;
    }
  }

  public a d(boolean paramBoolean)
  {
    this.k = paramBoolean;
    return this;
  }

  public void e(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }

  public boolean e()
  {
    return this.j.isWXAppInstalled();
  }

  public boolean e_()
  {
    this.S = false;
    this.C.b(SocializeListeners.SnsPostListener.class);
    SendMessageToWX.Req localReq = new SendMessageToWX.Req();
    localReq.transaction = e(this.Q);
    localReq.message = this.R;
    if (this.V);
    int i1;
    for (localReq.scene = 2; ; localReq.scene = i1)
    {
      return this.j.sendReq(localReq);
      boolean bool = this.k;
      i1 = 0;
      if (!bool)
        continue;
      i1 = 1;
    }
  }

  public IWXAPI f()
  {
    return this.j;
  }

  public void f(boolean paramBoolean)
  {
    this.V = paramBoolean;
  }

  public int f_()
  {
    if (this.k)
      return 10085;
    return 10086;
  }

  private class a extends s<WXMediaMessage>
  {
    private ProgressDialog b;

    private a()
    {
    }

    private a(Context arg2)
    {
      Context localContext;
      if ((localContext instanceof Activity))
        a(localContext);
    }

    private void a(Context paramContext)
    {
      int i = com.umeng.socialize.common.b.a(a.k(a.this), b.a.d, "Theme.UMDialog");
      int j = com.umeng.socialize.common.b.a(a.l(a.this), b.a.e, "umeng_socialize_text_waitting");
      int k = com.umeng.socialize.common.b.a(a.m(a.this), b.a.e, "umeng_socialize_text_waitting_weixin");
      int m = com.umeng.socialize.common.b.a(a.n(a.this), b.a.e, "umeng_socialize_text_waitting_weixin_circle");
      this.b = new ProgressDialog(paramContext, i);
      String str = a.o(a.this).getString(j);
      if (p.i.toString().equals(ax.o().toString()))
        str = a.p(a.this).getString(k);
      while (true)
      {
        this.b.setMessage(str);
        return;
        if (!p.j.toString().equals(ax.o().toString()))
          continue;
        str = a.q(a.this).getString(m);
      }
    }

    protected void a()
    {
      m.b(this.b);
      super.a();
    }

    protected void a(WXMediaMessage paramWXMediaMessage)
    {
      boolean bool = false;
      m.a(this.b);
      if ((!TextUtils.isEmpty(paramWXMediaMessage.title)) && (paramWXMediaMessage.title.getBytes().length >= 512))
      {
        paramWXMediaMessage.title = new String(paramWXMediaMessage.title.getBytes(), 0, 512);
        if ((!TextUtils.isEmpty(paramWXMediaMessage.description)) && (paramWXMediaMessage.description.getBytes().length >= 1024))
          paramWXMediaMessage.description = new String(paramWXMediaMessage.description.getBytes(), 0, 1024);
        a.a(a.this, paramWXMediaMessage);
        if ((a.a(a.this) != "image") || (paramWXMediaMessage.thumbData != null))
          break label266;
        i.b("UMWXHandler", "share image doesn't exist");
      }
      while (true)
      {
        a.b(a.this, paramWXMediaMessage.description);
        a.this.b(bool);
        a.g().a(as.b);
        a.this.H.clear();
        a.this.H.put("wx_appid", a.i(a.this));
        a.this.H.put("wx_secret", a.j(a.this));
        super.a(paramWXMediaMessage);
        return;
        a.a(a.this, "分享到" + a.this.G.b);
        break;
        label266: bool = a.this.e_();
      }
    }

    protected WXMediaMessage d()
    {
      WXMediaMessage localWXMediaMessage;
      if (a.a(a.this).equals("emoji"))
        localWXMediaMessage = a.b(a.this);
      while (true)
      {
        byte[] arrayOfByte = localWXMediaMessage.thumbData;
        if ((arrayOfByte != null) && (arrayOfByte.length > 32768))
        {
          i.c("UMWXHandler", "原始缩略图大小 : " + localWXMediaMessage.thumbData.length / 1024 + " KB.");
          a.h(a.this).sendEmptyMessage(1);
          localWXMediaMessage.thumbData = a.a(a.this, arrayOfByte, 32768);
          i.c("UMWXHandler", "压缩之后缩略图大小 : " + localWXMediaMessage.thumbData.length / 1024 + " KB.");
        }
        return localWXMediaMessage;
        if (a.a(a.this).equals("image"))
        {
          localWXMediaMessage = a.c(a.this);
          continue;
        }
        if (a.a(a.this).equals("music"))
        {
          localWXMediaMessage = a.d(a.this);
          continue;
        }
        if (a.a(a.this).equals("text"))
        {
          localWXMediaMessage = a.e(a.this);
          continue;
        }
        if (a.a(a.this).equals("text_image"))
        {
          localWXMediaMessage = a.f(a.this);
          continue;
        }
        boolean bool = a.a(a.this).equals("video");
        localWXMediaMessage = null;
        if (!bool)
          continue;
        localWXMediaMessage = a.g(a.this);
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.weixin.a.a
 * JD-Core Version:    0.6.0
 */