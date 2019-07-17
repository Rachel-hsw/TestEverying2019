package com.umeng.socialize.sso;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.umeng.socialize.controller.a.b;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.utils.i;
import com.umeng.socialize.utils.m;
import java.util.Map;

class z extends UMTencentSsoHandler.a<String>
{
  z(UMTencentSsoHandler paramUMTencentSsoHandler, Context paramContext, String paramString1, UMediaObject paramUMediaObject, b paramb, String paramString2, long paramLong, UMTencentSsoHandler.ObtainImageUrlListener paramObtainImageUrlListener)
  {
    super(paramContext, paramString1);
  }

  protected void a(String paramString)
  {
    super.a(paramString);
    i.a(UMTencentSsoHandler.o(), "upload image kill time: " + (System.currentTimeMillis() - this.d));
    m.a(this.f.b);
    this.e.a(this.f.h);
  }

  protected String d()
  {
    if ((this.a instanceof UMImage));
    for (UMImage localUMImage = (UMImage)this.a; ; localUMImage = null)
    {
      if (!localUMImage.n())
        localUMImage.o();
      String str1;
      if (localUMImage != null)
      {
        str1 = localUMImage.k();
        String str2 = (String)UMTencentSsoHandler.g.get(str1);
        if (TextUtils.isEmpty(str2))
          break label108;
        this.f.h = str2;
        i.a(UMTencentSsoHandler.o(), "obtain image url form cache..." + this.f.h);
      }
      while (true)
      {
        i.a(UMTencentSsoHandler.o(), "doInBackground end...");
        return "";
        label108: i.a(UMTencentSsoHandler.o(), "obtain image url form server...");
        String str3 = this.b.a(this.f.D, localUMImage, this.c);
        UMTencentSsoHandler.a(this.f, str1, str3);
        if ((this.f.D != null) && (TextUtils.isEmpty(str3)))
          Toast.makeText(this.f.D, "上传图片失败", 0).show();
        i.a(UMTencentSsoHandler.o(), "obtain image url form server..." + this.f.h);
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.sso.z
 * JD-Core Version:    0.6.0
 */