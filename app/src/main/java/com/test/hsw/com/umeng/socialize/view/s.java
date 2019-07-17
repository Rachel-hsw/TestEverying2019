package com.umeng.socialize.view;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class s
  implements DialogInterface.OnClickListener
{
  s(ShareActivity paramShareActivity)
  {
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.cancel();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.view.s
 * JD-Core Version:    0.6.0
 */