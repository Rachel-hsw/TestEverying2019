package com.withustudy.koudaizikao.activity;

import android.os.Bundle;
import android.text.TextUtils;
import com.umeng.socialize.a.a;
import com.umeng.socialize.bean.p;
import com.umeng.socialize.controller.listener.SocializeListeners.UMAuthListener;
import com.withustudy.koudaizikao.g.h;

class al
  implements SocializeListeners.UMAuthListener
{
  al(LoginActivity paramLoginActivity)
  {
  }

  public void a(Bundle paramBundle, p paramp)
  {
    LoginActivity.b(this.a, paramBundle.getString("uid"));
    h.a("thridUid", LoginActivity.b(this.a));
    if (!TextUtils.isEmpty(LoginActivity.b(this.a)))
    {
      LoginActivity.b(this.a, paramp);
      return;
    }
    LoginActivity.i(this.a).sendEmptyMessage(6);
    LoginActivity.i(this.a).sendMessage(LoginActivity.i(this.a).obtainMessage(5, "第三方登录失败，请重试"));
  }

  public void a(a parama, p paramp)
  {
    LoginActivity.i(this.a).sendEmptyMessage(6);
    LoginActivity.i(this.a).sendMessage(LoginActivity.i(this.a).obtainMessage(5, "第三方登录失败，请重试"));
  }

  public void a(p paramp)
  {
    LoginActivity.i(this.a).sendEmptyMessage(6);
    LoginActivity.i(this.a).sendMessage(LoginActivity.i(this.a).obtainMessage(5, "第三方登录失败，请重试"));
  }

  public void b(p paramp)
  {
    h.a("开始获取thridUid");
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.al
 * JD-Core Version:    0.6.0
 */