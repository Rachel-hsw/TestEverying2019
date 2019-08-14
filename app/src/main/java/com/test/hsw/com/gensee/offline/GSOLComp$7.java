package com.gensee.offline;

import com.gensee.entity.VodParam;
import com.gensee.net.IHttpHandler;
import com.gensee.net.IHttpHandler.StreamResponse;
import com.gensee.parse.VodAttrParse;
import java.io.InputStream;

class GSOLComp$7
  implements IHttpHandler.StreamResponse
{
  public void onConnectError(int paramInt, String paramString)
  {
    GSOLComp.access$1(this.this$0).onVodInitEnd(this.val$vodParam);
  }

  public void onRes(InputStream paramInputStream)
  {
    if (paramInputStream != null)
      new VodAttrParse().vodParse(paramInputStream, this.val$vodParam);
    GSOLComp.access$1(this.this$0).onVodInitEnd(this.val$vodParam);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.offline.GSOLComp.7
 * JD-Core Version:    0.6.0
 */