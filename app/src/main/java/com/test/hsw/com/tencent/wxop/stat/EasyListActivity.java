package com.tencent.wxop.stat;

import android.app.ListActivity;

public class EasyListActivity extends ListActivity
{
  protected void onPause()
  {
    super.onPause();
    e.m(this);
  }

  protected void onResume()
  {
    super.onResume();
    e.l(this);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.wxop.stat.EasyListActivity
 * JD-Core Version:    0.6.0
 */