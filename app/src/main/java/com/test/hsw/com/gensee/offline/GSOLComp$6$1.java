package com.gensee.offline;

import com.gensee.entity.VodObject;
import com.gensee.entity.VodParam;
import com.gensee.net.IHttpHandler;
import com.gensee.taskret.OnTaskRet;

class GSOLComp$6$1
  implements OnTaskRet
{
  public void onTaskRet(boolean paramBoolean, int paramInt, String paramString)
  {
    if (paramBoolean)
    {
      if (GSOLComp.access$0(GSOLComp.6.access$0(this.this$1)) != null)
        GSOLComp.access$0(GSOLComp.6.access$0(this.this$1)).onVodInited((VodObject)this.val$vodParam);
      if (!GSOLComp.access$7(GSOLComp.6.access$0(this.this$1)))
        GSOLComp.access$8(GSOLComp.6.access$0(this.this$1), this.val$vodParam);
      return;
    }
    GSOLComp.access$1(GSOLComp.6.access$0(this.this$1)).sendError("14");
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.offline.GSOLComp.6.1
 * JD-Core Version:    0.6.0
 */