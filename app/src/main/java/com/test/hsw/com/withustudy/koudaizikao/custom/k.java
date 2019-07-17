package com.withustudy.koudaizikao.custom;

import android.graphics.drawable.AnimationDrawable;

class k
  implements Runnable
{
  k(LoadingView paramLoadingView)
  {
  }

  public void run()
  {
    if (LoadingView.a(this.a).isRunning())
      LoadingView.a(this.a).stop();
    LoadingView.a(this.a).start();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.custom.k
 * JD-Core Version:    0.6.0
 */