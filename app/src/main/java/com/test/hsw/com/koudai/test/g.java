package com.koudai.test;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class g extends BroadcastReceiver
{
  g(BrushExcerciseDetailFragment paramBrushExcerciseDetailFragment)
  {
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    BrushExcerciseDetailFragment.c(this.a, false);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.koudai.test.g
 * JD-Core Version:    0.6.0
 */