package com.umeng.socialize.view;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class t
  implements DialogInterface.OnClickListener
{
  t(ShareActivity paramShareActivity)
  {
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ShareActivity.a(this.a, null);
    ShareActivity.b(this.a, false);
    paramDialogInterface.cancel();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.view.t
 * JD-Core Version:    0.6.0
 */