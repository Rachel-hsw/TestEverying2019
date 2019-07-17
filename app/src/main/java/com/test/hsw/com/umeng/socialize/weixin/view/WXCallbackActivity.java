package com.umeng.socialize.weixin.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import com.umeng.socialize.bean.ax;
import com.umeng.socialize.bean.p;
import com.umeng.socialize.sso.v;
import com.umeng.socialize.utils.i;
import com.umeng.socialize.weixin.a.a;

public abstract class WXCallbackActivity extends Activity
  implements IWXAPIEventHandler
{
  protected a a = null;
  private final String b = WXCallbackActivity.class.getSimpleName();

  protected void a()
  {
    ax localax = ax.b();
    p localp = ax.o();
    int i = 10086;
    if (localp == p.j)
      i = 10085;
    v localv = localax.a(i);
    if ((localv instanceof a))
      this.a = ((a)localv);
  }

  protected void a(Intent paramIntent)
  {
    i.c(this.b, "### WXCallbackActivity   handleIntent()");
    IWXAPI localIWXAPI = b();
    if (localIWXAPI != null)
    {
      localIWXAPI.handleIntent(getIntent(), this);
      return;
    }
    i.b(this.b, "### WXCallbackActivity   wxApi == null ");
  }

  protected IWXAPI b()
  {
    if (this.a != null)
      return this.a.f();
    return null;
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    i.c(this.b, "### WXCallbackActivity   onCreate");
    a();
    a(getIntent());
  }

  protected final void onNewIntent(Intent paramIntent)
  {
    i.c(this.b, "### WXCallbackActivity   onNewIntent");
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    a();
    a(paramIntent);
  }

  public void onReq(BaseReq paramBaseReq)
  {
    if (this.a != null)
      this.a.c().onReq(paramBaseReq);
    finish();
  }

  public void onResp(BaseResp paramBaseResp)
  {
    if (this.a != null)
      this.a.c().onResp(paramBaseResp);
    finish();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.weixin.view.WXCallbackActivity
 * JD-Core Version:    0.6.0
 */