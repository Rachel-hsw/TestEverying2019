package com.withustudy.koudaizikao.activity;

import com.umeng.message.IUmengRegisterCallback;

class bu
  implements IUmengRegisterCallback
{
  bu(WelcomeActivity paramWelcomeActivity)
  {
  }

  public void onRegistered(String paramString)
  {
    WelcomeActivity.access$0(this.a).post(new bv(this));
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.bu
 * JD-Core Version:    0.6.0
 */