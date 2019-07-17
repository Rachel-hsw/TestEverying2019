package com.umeng.socialize.sso;

import android.os.Bundle;
import android.text.TextUtils;
import com.umeng.socialize.bean.UMShareMsg;
import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.media.UMediaObject.a;
import java.util.ArrayList;

class i
  implements UMTencentSsoHandler.ObtainImageUrlListener
{
  i(h paramh)
  {
  }

  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      ArrayList localArrayList = new ArrayList();
      this.a.b.remove("imageUrl");
      localArrayList.add(paramString);
      this.a.b.putStringArrayList("imageUrl", localArrayList);
      c.a(this.a.c, this.a.b);
    }
    UMediaObject localUMediaObject;
    int i;
    do
    {
      return;
      c.a(this.a.c, this.a.b);
      localUMediaObject = c.c(this.a.c).a();
      i = this.a.b.getInt("req_type");
    }
    while ((this.a.c.e()) || (localUMediaObject == null) || ((localUMediaObject.g() != UMediaObject.a.b) && (localUMediaObject.g() != UMediaObject.a.c) && (i != 1)));
    com.umeng.socialize.utils.i.b(c.c(), "QQ空间上传图片失败将导致无客户端分享失败，请设置缩略图为url类型或者较小的本地图片...");
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.sso.i
 * JD-Core Version:    0.6.0
 */