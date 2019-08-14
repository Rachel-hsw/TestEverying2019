package com.himamis.retex.editor.android.a;

import android.view.View;
import android.view.View.OnFocusChangeListener;

public class b
  implements View.OnFocusChangeListener
{
  private com.himamis.retex.editor.a.d.b a;

  public b(com.himamis.retex.editor.a.d.b paramb)
  {
    this.a = paramb;
  }

  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.b();
      return;
    }
    this.a.a();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.editor.android.a.b
 * JD-Core Version:    0.6.0
 */