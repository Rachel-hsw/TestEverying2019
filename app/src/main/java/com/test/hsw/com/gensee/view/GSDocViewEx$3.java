package com.gensee.view;

import android.graphics.RectF;
import com.gensee.swf.GLSwfRender;

class GSDocViewEx$3
  implements Runnable
{
  public void run()
  {
    GSDocViewEx.access$3(this.this$0).onDocBound(this.val$rectF, this.val$w, this.val$h);
    this.this$0.requestRender();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.view.GSDocViewEx.3
 * JD-Core Version:    0.6.0
 */