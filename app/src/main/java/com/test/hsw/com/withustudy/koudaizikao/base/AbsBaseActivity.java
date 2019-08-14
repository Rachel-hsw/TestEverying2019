package com.withustudy.koudaizikao.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import com.android.http.n.a;
import com.umeng.socialize.bean.ax;
import com.umeng.socialize.bean.p;
import com.umeng.socialize.controller.UMSocialService;
import com.umeng.socialize.media.QQShareContent;
import com.umeng.socialize.media.SinaShareContent;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.sso.v;
import com.umeng.socialize.weixin.media.CircleShareContent;
import com.umeng.socialize.weixin.media.WeiXinShareContent;
import java.util.Map;

public abstract class AbsBaseActivity extends FragmentActivity
  implements n.a
{
  protected Context mContext;
  protected Context mContextApp;
  protected UMSocialService mController;
  protected com.android.http.e mFileDownLoad;
  protected com.withustudy.koudaizikao.g.f mFileTools;
  protected FragmentManager mFragmentManager;
  protected com.withustudy.koudaizikao.g.l mProTools;
  protected com.withustudy.koudaizikao.d.f mSP;
  protected UMSocialService mShareController;

  private void addQZoneQQPlatform()
  {
    com.umeng.socialize.sso.l locall = new com.umeng.socialize.sso.l(this, "1104849186", "Td1yI6yjZR8vICkf");
    locall.d("http://www.umeng.com");
    locall.i();
    new com.umeng.socialize.sso.c(this, "1104849186", "Td1yI6yjZR8vICkf").i();
  }

  private void addWeiXinPlatform()
  {
    com.umeng.socialize.weixin.a.a locala = new com.umeng.socialize.weixin.a.a(this, "wx6f30ad5bcc7fbe40", "c808277cdf3c3ff291d16df71195ec6c");
    locala.e(false);
    locala.i();
  }

  private void initThirdData()
  {
    com.umeng.socialize.utils.i.a = true;
    initUMService();
    initUMShare();
    addWeiXinPlatform();
    addQZoneQQPlatform();
  }

  private void initUMService()
  {
    this.mController = com.umeng.socialize.controller.a.a("com.umeng.login");
    this.mController.c().a(new com.umeng.socialize.sso.j());
  }

  private void initUMShare()
  {
    this.mShareController = com.umeng.socialize.controller.a.a("com.umeng.share");
    com.umeng.socialize.sso.j localj = new com.umeng.socialize.sso.j();
    this.mShareController.c().a(localj);
    com.umeng.socialize.weixin.a.a locala1 = new com.umeng.socialize.weixin.a.a(this, "wx6f30ad5bcc7fbe40", "c808277cdf3c3ff291d16df71195ec6c");
    com.umeng.socialize.weixin.a.a locala2 = new com.umeng.socialize.weixin.a.a(this, "wx6f30ad5bcc7fbe40", "c808277cdf3c3ff291d16df71195ec6c");
    locala1.i();
    locala2.d(true);
    locala2.i();
    com.umeng.socialize.sso.l locall = new com.umeng.socialize.sso.l(this, "1104849186", "Td1yI6yjZR8vICkf");
    locall.d("http://www.umeng.com");
    locall.i();
    new com.umeng.socialize.sso.c(this, "1104849186", "Td1yI6yjZR8vICkf").i();
  }

  protected abstract void bindData();

  public void finish()
  {
    super.finish();
    overridePendingTransition(2130968588, 2130968592);
  }

  public void finish(int paramInt1, int paramInt2)
  {
    super.finish();
    overridePendingTransition(paramInt1, paramInt2);
  }

  protected abstract void initData();

  protected abstract void initListener();

  protected abstract void initView();

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    v localv = ax.b().a(paramInt1);
    if (localv != null)
      localv.a(paramInt1, paramInt2, paramIntent);
  }

  protected final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mContext = this;
    this.mContextApp = getApplicationContext();
    this.mFragmentManager = getSupportFragmentManager();
    this.mProTools = com.withustudy.koudaizikao.g.l.a(this.mContext);
    this.mFileTools = com.withustudy.koudaizikao.g.f.a(this.mContext);
    this.mFileDownLoad = com.android.http.e.a(this.mContext);
    this.mSP = com.withustudy.koudaizikao.d.f.a(this.mContextApp);
    initThirdData();
    setContentView();
    initView();
    initData();
    bindData();
    initListener();
  }

  protected void onDestroy()
  {
    super.onDestroy();
    if (this.mProTools != null)
      this.mProTools.b();
  }

  public void onError(String paramString1, String paramString2, int paramInt)
  {
    com.withustudy.koudaizikao.g.h.a("onError!");
    com.withustudy.koudaizikao.g.h.a("actionId----->" + paramInt);
    com.withustudy.koudaizikao.g.h.a(paramString1);
  }

  protected void onPause()
  {
    super.onPause();
    if (!com.withustudy.koudaizikao.g.h.a())
    {
      com.umeng.a.g.b("SplashScreen");
      com.umeng.a.g.a(this);
    }
  }

  public void onRequest()
  {
  }

  protected void onResume()
  {
    super.onResume();
    if (!com.withustudy.koudaizikao.g.h.a())
    {
      com.umeng.a.g.a("SplashScreen");
      com.umeng.a.g.b(this);
    }
  }

  public void onSuccess(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt)
  {
    com.withustudy.koudaizikao.g.h.a("OnSucess!");
    com.withustudy.koudaizikao.g.h.a("actionId----->" + paramInt);
    com.withustudy.koudaizikao.g.h.a("res----->" + paramString1);
  }

  protected abstract void setContentView();

  public void share(p paramp, String paramString)
  {
    try
    {
      switch ($SWITCH_TABLE$com$umeng$socialize$bean$SHARE_MEDIA()[paramp.ordinal()])
      {
      case 10:
        CircleShareContent localCircleShareContent = new CircleShareContent();
        localCircleShareContent.a("快来口袋自考学本科吧，20大专业全科讲解题目，刷刷题就过关哦~");
        localCircleShareContent.d("快来口袋自考学本科吧，20大专业全科讲解题目，刷刷题就过关哦~");
        localCircleShareContent.b(paramString);
        localCircleShareContent.a(new UMImage(this, 2130838078));
        this.mShareController.a(localCircleShareContent);
        this.mShareController.a(this, p.j, new a(this));
        return;
      case 9:
        WeiXinShareContent localWeiXinShareContent = new WeiXinShareContent();
        localWeiXinShareContent.a("口袋自考");
        localWeiXinShareContent.d("快来口袋自考学本科吧，20大专业全科讲解题目，刷刷题就过关哦~");
        localWeiXinShareContent.b(paramString);
        localWeiXinShareContent.a(new UMImage(this, 2130838078));
        this.mShareController.a(localWeiXinShareContent);
        this.mShareController.a(this, p.i, new e(this));
        return;
      case 5:
        SinaShareContent localSinaShareContent = new SinaShareContent();
        localSinaShareContent.a("口袋自考");
        localSinaShareContent.d("快来口袋自考学本科吧，20大专业全科讲解题目，刷刷题就过关哦~" + paramString);
        localSinaShareContent.b(paramString);
        localSinaShareContent.a(new UMImage(this, 2130838078));
        this.mShareController.a(localSinaShareContent);
        this.mShareController.a(this, p.e, new f(this));
        return;
      case 7:
        QQShareContent localQQShareContent = new QQShareContent();
        localQQShareContent.a("口袋自考");
        localQQShareContent.d("快来口袋自考学本科吧，20大专业全科讲解题目，刷刷题就过关哦~");
        localQQShareContent.b(paramString);
        localQQShareContent.a(new UMImage(this, 2130838078));
        this.mShareController.a(localQQShareContent);
        this.mShareController.a(this, p.g, new g(this));
      case 6:
      case 8:
      }
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public void share(p paramp, String paramString1, String paramString2, String paramString3)
  {
    if (paramString2 != null);
    try
    {
      if ((!paramString2.equals("")) && (!paramString2.equals("null")));
      while (true)
      {
        if ((paramString3 != null) && (!paramString3.equals("")) && (!paramString3.equals("null")));
        while (true)
          switch ($SWITCH_TABLE$com$umeng$socialize$bean$SHARE_MEDIA()[paramp.ordinal()])
          {
          case 10:
            CircleShareContent localCircleShareContent = new CircleShareContent();
            localCircleShareContent.a(paramString2);
            localCircleShareContent.d(paramString3);
            localCircleShareContent.b(paramString1);
            localCircleShareContent.a(new UMImage(this, 2130838078));
            this.mShareController.a(localCircleShareContent);
            this.mShareController.a(this, p.j, new h(this));
            return;
          case 9:
            WeiXinShareContent localWeiXinShareContent = new WeiXinShareContent();
            localWeiXinShareContent.a(paramString2);
            localWeiXinShareContent.d(paramString3);
            localWeiXinShareContent.b(paramString1);
            localWeiXinShareContent.a(new UMImage(this, 2130838078));
            this.mShareController.a(localWeiXinShareContent);
            this.mShareController.a(this, p.i, new i(this));
            return;
          case 5:
            SinaShareContent localSinaShareContent = new SinaShareContent();
            localSinaShareContent.a(paramString2);
            localSinaShareContent.d(paramString3 + paramString1);
            localSinaShareContent.b(paramString1);
            localSinaShareContent.a(new UMImage(this, 2130838078));
            this.mShareController.a(localSinaShareContent);
            this.mShareController.a(this, p.e, new j(this));
            return;
          case 7:
            QQShareContent localQQShareContent = new QQShareContent();
            localQQShareContent.a(paramString2);
            localQQShareContent.d(paramString3);
            localQQShareContent.b(paramString1);
            localQQShareContent.a(new UMImage(this, 2130838078));
            this.mShareController.a(localQQShareContent);
            this.mShareController.a(this, p.g, new k(this));
            return;
            paramString3 = "快来口袋自考学本科吧，20大专业全科讲解题目，刷刷题就过关哦~";
          case 6:
          case 8:
          }
        paramString2 = "口袋自考";
      }
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public void share(p paramp, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (paramString2 != null);
    try
    {
      if ((!paramString2.equals("")) && (!paramString2.equals("null")));
      while (true)
      {
        if ((paramString3 != null) && (!paramString3.equals("")) && (!paramString3.equals("null")));
        while (true)
          switch ($SWITCH_TABLE$com$umeng$socialize$bean$SHARE_MEDIA()[paramp.ordinal()])
          {
          case 10:
            CircleShareContent localCircleShareContent = new CircleShareContent();
            localCircleShareContent.a(paramString2);
            localCircleShareContent.d(paramString3);
            localCircleShareContent.b(paramString1);
            localCircleShareContent.a(new UMImage(this, paramInt));
            this.mShareController.a(localCircleShareContent);
            this.mShareController.a(this, p.j, new l(this));
            return;
          case 9:
            WeiXinShareContent localWeiXinShareContent = new WeiXinShareContent();
            localWeiXinShareContent.a(paramString2);
            localWeiXinShareContent.d(paramString3);
            localWeiXinShareContent.b(paramString1);
            localWeiXinShareContent.a(new UMImage(this, paramInt));
            this.mShareController.a(localWeiXinShareContent);
            this.mShareController.a(this, p.i, new b(this));
            return;
          case 5:
            SinaShareContent localSinaShareContent = new SinaShareContent();
            localSinaShareContent.a(paramString2);
            localSinaShareContent.d(paramString3 + paramString1);
            localSinaShareContent.b(paramString1);
            localSinaShareContent.a(new UMImage(this, paramInt));
            this.mShareController.a(localSinaShareContent);
            this.mShareController.a(this, p.e, new c(this));
            return;
          case 7:
            QQShareContent localQQShareContent = new QQShareContent();
            localQQShareContent.a(paramString2);
            localQQShareContent.d(paramString3);
            localQQShareContent.b(paramString1);
            localQQShareContent.a(new UMImage(this, paramInt));
            this.mShareController.a(localQQShareContent);
            this.mShareController.a(this, p.g, new d(this));
            return;
            paramString3 = "快来口袋自考学本科吧，20大专业全科讲解题目，刷刷题就过关哦~";
          case 6:
          case 8:
          }
        paramString2 = "口袋自考";
      }
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public final void startNewActivity(Class<? extends Activity> paramClass, int paramInt1, int paramInt2, boolean paramBoolean, Bundle paramBundle)
  {
    Intent localIntent = new Intent(this, paramClass);
    if (paramBundle != null)
      localIntent.putExtras(paramBundle);
    startActivity(localIntent);
    if (getParent() == null)
      overridePendingTransition(paramInt1, paramInt2);
    while (true)
    {
      if (paramBoolean)
        super.finish();
      return;
      getParent().overridePendingTransition(paramInt1, paramInt2);
    }
  }

  public final void startNewActivity(Class<? extends Activity> paramClass, boolean paramBoolean, Bundle paramBundle)
  {
    Intent localIntent = new Intent(this, paramClass);
    if (paramBundle != null)
      localIntent.putExtras(paramBundle);
    startActivity(localIntent);
    if (getParent() == null)
      overridePendingTransition(2130968591, 2130968589);
    while (true)
    {
      if (paramBoolean)
        super.finish();
      return;
      getParent().overridePendingTransition(2130968591, 2130968589);
    }
  }

  public final void startNewActivityForResult(Class<? extends Activity> paramClass, int paramInt1, int paramInt2, int paramInt3, Bundle paramBundle)
  {
    Intent localIntent = new Intent(this, paramClass);
    if (paramBundle != null)
      localIntent.putExtras(paramBundle);
    startActivityForResult(localIntent, paramInt3);
    if (getParent() == null)
    {
      overridePendingTransition(paramInt1, paramInt2);
      return;
    }
    getParent().overridePendingTransition(paramInt1, paramInt2);
  }

  public final void startNewActivityForResult(Class<? extends Activity> paramClass, int paramInt, Bundle paramBundle)
  {
    Intent localIntent = new Intent(this, paramClass);
    if (paramBundle != null)
      localIntent.putExtras(paramBundle);
    startActivityForResult(localIntent, paramInt);
    if (getParent() == null)
    {
      overridePendingTransition(2130968591, 2130968589);
      return;
    }
    getParent().overridePendingTransition(2130968591, 2130968589);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.base.AbsBaseActivity
 * JD-Core Version:    0.6.0
 */