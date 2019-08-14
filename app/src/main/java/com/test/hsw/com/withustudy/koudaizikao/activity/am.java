package com.withustudy.koudaizikao.activity;

import com.umeng.socialize.controller.listener.SocializeListeners.UMDataListener;
import com.withustudy.koudaizikao.a.b;
import com.withustudy.koudaizikao.a.c;
import com.withustudy.koudaizikao.d.a;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.req.LoginThird;
import com.withustudy.koudaizikao.g.h;
import com.withustudy.koudaizikao.g.n;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class am
  implements SocializeListeners.UMDataListener
{
  am(LoginActivity paramLoginActivity)
  {
  }

  public void a(int paramInt, Map<String, Object> paramMap)
  {
    StringBuilder localStringBuilder;
    Iterator localIterator;
    if (paramMap != null)
    {
      localStringBuilder = new StringBuilder();
      localIterator = paramMap.keySet().iterator();
      if (localIterator.hasNext())
        break label260;
      if (!LoginActivity.c(this.a).equals("WEIBO_TYPE"))
        break label311;
      LoginActivity.c(this.a, (String)paramMap.get("screen_name"));
      LoginActivity.d(this.a, (String)paramMap.get("profile_image_url"));
      h.a(LoginActivity.d(this.a) + ":" + LoginActivity.e(this.a));
    }
    while (true)
    {
      LoginThird localLoginThird = new LoginThird();
      localLoginThird.setVersionName(LoginActivity.a(this.a).p());
      localLoginThird.setClientType(n.a());
      localLoginThird.setImei(n.d(LoginActivity.g(this.a)));
      localLoginThird.setNet(n.c(LoginActivity.g(this.a)));
      localLoginThird.setAccountType(LoginActivity.c(this.a));
      localLoginThird.setThirdPartyToken(LoginActivity.b(this.a));
      localLoginThird.setNickname(LoginActivity.d(this.a));
      localLoginThird.setProfileUrl(LoginActivity.e(this.a));
      localLoginThird.setRegisterChannel(a.e);
      c.b().d().a(this.a, localLoginThird, 8);
      return;
      label260: String str = (String)localIterator.next();
      localStringBuilder.append(str + "::--" + paramMap.get(str));
      break;
      label311: if (LoginActivity.c(this.a).equals("WEIXIN_TYPE"))
      {
        LoginActivity.c(this.a, (String)paramMap.get("nickname"));
        LoginActivity.d(this.a, (String)paramMap.get("headimgurl"));
        h.a(LoginActivity.d(this.a) + ":" + LoginActivity.e(this.a));
        continue;
      }
      if (!LoginActivity.c(this.a).equals("QQ_TYPE"))
        continue;
      LoginActivity.c(this.a, (String)paramMap.get("screen_name"));
      LoginActivity.d(this.a, (String)paramMap.get("profile_image_url"));
      h.a(LoginActivity.d(this.a) + ":" + LoginActivity.e(this.a));
    }
  }

  public void b()
  {
    h.a("开始获取第三方账号信息");
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.am
 * JD-Core Version:    0.6.0
 */