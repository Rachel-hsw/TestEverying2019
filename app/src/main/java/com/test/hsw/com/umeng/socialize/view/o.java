package com.umeng.socialize.view;

import android.text.Editable;
import android.text.TextWatcher;

class o
  implements TextWatcher
{
  o(ShareActivity paramShareActivity)
  {
  }

  public void afterTextChanged(Editable paramEditable)
  {
  }

  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
  }

  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    ShareActivity.a(this.a, ShareActivity.m(this.a));
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.view.o
 * JD-Core Version:    0.6.0
 */