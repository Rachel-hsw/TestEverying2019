package com.withustudy.koudaizikao.activity;

import android.os.Bundle;
import com.withustudy.koudaizikao.a.b;
import com.withustudy.koudaizikao.a.c;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.req.Login;
import com.withustudy.koudaizikao.entity.req.LoginThird;
import com.withustudy.koudaizikao.g.h;
import com.withustudy.koudaizikao.g.i;
import com.withustudy.koudaizikao.g.n;

class bz extends Thread
{
  bz(WelcomeActivity.a parama, WelcomeActivity paramWelcomeActivity)
  {
  }

  public void run()
  {
    try
    {
      Thread.sleep(2000L);
      if (WelcomeActivity.access$3(this.b).i().equals(""))
      {
        h.a("配置文件中没有数据，手动登录");
        Bundle localBundle2 = new Bundle();
        localBundle2.putString("flag", "0");
        this.b.startNewActivity(LoginActivity.class, true, localBundle2);
      }
      while (true)
      {
        super.run();
        return;
        if ((WelcomeActivity.access$3(this.b).m().equals("")) || (WelcomeActivity.access$3(this.b).n().equals("")))
          break;
        Login localLogin = new Login();
        localLogin.setClientType(n.a());
        localLogin.setImei(n.d(this.b));
        localLogin.setNet(n.c(this.b));
        localLogin.setVersionName(WelcomeActivity.access$3(this.b).p());
        localLogin.setPhoneNumber(WelcomeActivity.access$3(this.b).m());
        localLogin.setPassWord(i.a(WelcomeActivity.access$3(this.b).n()));
        localLogin.setAccountType("INNER_TYPE");
        c.b().d().a(this.b, localLogin, 11);
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      while (true)
      {
        localInterruptedException.printStackTrace();
        continue;
        if ((!WelcomeActivity.access$3(this.b).A().equals("")) && (!WelcomeActivity.access$3(this.b).B().equals("")))
        {
          LoginThird localLoginThird = new LoginThird();
          localLoginThird.setVersionName(WelcomeActivity.access$3(this.b).p());
          localLoginThird.setClientType(n.a());
          localLoginThird.setImei(n.d(this.b));
          localLoginThird.setNet(n.c(this.b));
          localLoginThird.setAccountType(WelcomeActivity.access$3(this.b).B());
          localLoginThird.setThirdPartyToken(WelcomeActivity.access$3(this.b).A());
          localLoginThird.setNickname(WelcomeActivity.access$3(this.b).v());
          localLoginThird.setProfileUrl(WelcomeActivity.access$3(this.b).u());
          c.b().d().a(this.b, localLoginThird, 12);
          continue;
        }
        Bundle localBundle1 = new Bundle();
        localBundle1.putString("flag", "0");
        this.b.startNewActivity(LoginActivity.class, true, localBundle1);
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.bz
 * JD-Core Version:    0.6.0
 */