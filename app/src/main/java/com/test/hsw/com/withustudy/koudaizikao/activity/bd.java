package com.withustudy.koudaizikao.activity;

import java.io.UnsupportedEncodingException;

class bd
  implements Runnable
{
  bd(bc parambc)
  {
  }

  public void run()
  {
    try
    {
      ShowCardActivity.a(bc.a(this.a), false, "");
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.bd
 * JD-Core Version:    0.6.0
 */