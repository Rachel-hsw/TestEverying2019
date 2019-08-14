package com.gensee.vod;

import com.gensee.entity.VodObject;
import com.gensee.net.IHttpHandler.StreamResponse;
import com.gensee.parse.VodAttrParse;
import java.io.InputStream;

class VodSite$1
  implements IHttpHandler.StreamResponse
{
  public void onConnectError(int paramInt, String paramString)
  {
    if (VodSite.access$0(this.this$0) != null)
      VodSite.access$0(this.this$0).onVodDetail(this.val$vodParam);
  }

  public void onRes(InputStream paramInputStream)
  {
    if (paramInputStream != null)
    {
      new VodAttrParse().vodParse(paramInputStream, this.val$vodParam);
      if (VodSite.access$0(this.this$0) != null)
        VodSite.access$0(this.this$0).onVodDetail(this.val$vodParam);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.vod.VodSite.1
 * JD-Core Version:    0.6.0
 */