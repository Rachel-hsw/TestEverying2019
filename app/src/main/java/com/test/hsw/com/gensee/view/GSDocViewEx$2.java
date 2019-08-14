package com.gensee.view;

import com.gensee.pdu.PduPage;
import com.gensee.swf.GLSwfRender;

class GSDocViewEx$2
  implements Runnable
{
  public void run()
  {
    GSDocViewEx.access$3(this.this$0).setDocPage(GSDocViewEx.access$4(this.this$0).getPath(), GSDocViewEx.access$4(this.this$0).getAnimationPath(), GSDocViewEx.access$4(this.this$0).getAniStep(), GSDocViewEx.access$4(this.this$0).hashCode());
    this.this$0.requestRender();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.view.GSDocViewEx.2
 * JD-Core Version:    0.6.0
 */