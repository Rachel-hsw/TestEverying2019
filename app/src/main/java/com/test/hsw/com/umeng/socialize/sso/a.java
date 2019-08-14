package com.umeng.socialize.sso;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.widget.Toast;
import com.umeng.socialize.bean.UMShareMsg;
import com.umeng.socialize.bean.as;
import com.umeng.socialize.bean.ax;
import com.umeng.socialize.bean.ay;
import com.umeng.socialize.bean.p;
import com.umeng.socialize.controller.listener.SocializeListeners.SnsPostListener;
import com.umeng.socialize.controller.listener.SocializeListeners.UMAuthListener;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMVideo;
import com.umeng.socialize.media.UMWebPage;
import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.media.UMediaObject.a;
import com.umeng.socialize.media.UMusic;
import com.umeng.socialize.utils.i;
import com.umeng.socialize.utils.m;
import com.umeng.socialize.utils.n;
import java.io.ByteArrayOutputStream;

public abstract class a extends v
{
  protected SocializeListeners.SnsPostListener a = null;
  protected String b = "";
  protected UMediaObject c = null;
  protected String d = "";
  protected int e = 0;
  protected int f = 0;
  protected String g = "";
  protected String h = "";
  protected boolean i = false;
  protected String j = "";
  protected int k = 512;
  protected int l = 150;
  protected int m = 32768;
  protected int n = 1024;
  protected UMediaObject.a o = null;
  protected String p = getClass().getSimpleName();
  protected int q = -1;

  public a(Context paramContext)
  {
    this(paramContext, "");
  }

  public a(Context paramContext, String paramString)
  {
    super(paramContext);
    this.d = paramString;
  }

  protected Bitmap a(Bitmap paramBitmap, float paramFloat)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      int i1 = paramBitmap.getWidth();
      int i2 = paramBitmap.getHeight();
      float f1 = 1.0F;
      if ((i1 < 200) || (i2 < 200))
      {
        if (i1 >= i2)
          break label79;
        f1 = paramFloat / i1;
      }
      Bitmap localBitmap;
      while (true)
      {
        localBitmap = Bitmap.createScaledBitmap(paramBitmap, (int)(f1 * i1), (int)(f1 * i2), true);
        if (localBitmap != null)
          break;
        return paramBitmap;
        label79: f1 = paramFloat / i2;
      }
      return localBitmap;
    }
    return null;
  }

  protected UMediaObject.a a(UMediaObject paramUMediaObject)
  {
    UMediaObject.a locala;
    if (paramUMediaObject != null)
    {
      locala = paramUMediaObject.g();
      if ((locala == UMediaObject.a.a) && (!TextUtils.isEmpty(this.b)))
        locala = UMediaObject.a.e;
    }
    boolean bool;
    do
    {
      return locala;
      bool = TextUtils.isEmpty(this.b);
      locala = null;
    }
    while (bool);
    return UMediaObject.a.d;
  }

  protected Object a(UMediaObject.a parama)
  {
    Object localObject;
    if (parama == UMediaObject.a.a)
      localObject = b(this.c);
    UMediaObject.a locala;
    do
    {
      return localObject;
      if (parama == UMediaObject.a.c)
        return a(this.c, this.b);
      if (parama == UMediaObject.a.d)
        return b(this.b);
      if (parama == UMediaObject.a.e)
        return b(this.b, this.c);
      locala = UMediaObject.a.b;
      localObject = null;
    }
    while (parama != locala);
    return b(this.c, this.b);
  }

  protected abstract Object a(UMediaObject paramUMediaObject, String paramString);

  public String a()
  {
    return this.d;
  }

  protected void a(int paramInt)
  {
    this.q = paramInt;
  }

  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
  }

  public void a(Activity paramActivity, SocializeListeners.UMAuthListener paramUMAuthListener)
  {
  }

  protected void a(ay paramay)
  {
    if (paramay != null)
    {
      B = paramay;
      if (B.j() != as.a)
        break label56;
      this.b = B.p().a;
    }
    for (this.c = B.p().a(); ; this.c = B.a())
    {
      B.a(as.b);
      return;
      label56: this.b = B.d();
    }
  }

  protected void a(com.umeng.socialize.bean.b paramb, ay paramay, SocializeListeners.SnsPostListener paramSnsPostListener)
  {
    this.a = paramSnsPostListener;
    f();
    a(paramay);
    if ((this.c != null) || (!TextUtils.isEmpty(this.b)))
    {
      b(paramb, paramay, paramSnsPostListener);
      this.c = c(this.c);
      a(this.b, this.c);
      return;
    }
    Toast.makeText(this.D, "请设置" + this.G.b + "的分享内容...", 0).show();
  }

  protected void a(p paramp, int paramInt, ay paramay)
  {
    if (this.a != null)
      this.a.a(paramp, paramInt, B);
    this.C.a(SocializeListeners.SnsPostListener.class, paramp, paramInt, B);
  }

  public void a(String paramString)
  {
    this.d = paramString;
  }

  protected void a(String paramString, UMediaObject paramUMediaObject)
  {
    this.o = a(paramUMediaObject);
    if (this.o != null)
    {
      e_();
      return;
    }
    Toast.makeText(this.D, "请设置分享内容...", 0).show();
    i.b(this.p, "您设置的分享内容为空,分享内容只支持文字、图片，图文、音乐、视频、网页类型...");
  }

  public void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }

  protected boolean a(Context paramContext)
  {
    return false;
  }

  protected abstract boolean a(Object paramObject, UMediaObject.a parama);

  protected byte[] a(byte[] paramArrayOfByte)
  {
    int i1 = 0;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= this.m))
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      Bitmap localBitmap = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length);
      int i2 = 1;
      while ((i1 == 0) && (i2 <= 10))
      {
        int i3 = (int)(100.0D * Math.pow(0.8D, i2));
        i.c(this.p, "quality = " + i3);
        localBitmap.compress(Bitmap.CompressFormat.JPEG, i3, localByteArrayOutputStream);
        i.c(this.p, "Thumb Size = " + localByteArrayOutputStream.toByteArray().length / 1024 + " KB");
        if ((localByteArrayOutputStream != null) && (localByteArrayOutputStream.size() < this.m))
        {
          i1 = 1;
          continue;
        }
        localByteArrayOutputStream.reset();
        i2++;
      }
      if (localByteArrayOutputStream != null)
      {
        paramArrayOfByte = localByteArrayOutputStream.toByteArray();
        if (!localBitmap.isRecycled())
          localBitmap.recycle();
        i.c(this.p, "### 分享" + this.h + "的缩略图大小 : " + paramArrayOfByte.length / 1024 + " KB");
        if (paramArrayOfByte.length == 0)
          i.b(this.p, "### 缩略图的原图太大,请设置小于64KB的缩略图");
      }
    }
    return paramArrayOfByte;
  }

  protected abstract Object b(UMediaObject paramUMediaObject);

  protected abstract Object b(UMediaObject paramUMediaObject, String paramString);

  protected abstract Object b(String paramString);

  protected abstract Object b(String paramString, UMediaObject paramUMediaObject);

  protected void b(com.umeng.socialize.bean.b paramb, ay paramay, SocializeListeners.SnsPostListener paramSnsPostListener)
  {
    if (paramSnsPostListener != null)
      paramSnsPostListener.a();
    g();
  }

  protected void b(boolean paramBoolean)
  {
    p localp = ax.o();
    int i1 = -1;
    if (paramBoolean)
    {
      m.a(this.D, B.c, this.b, this.c, localp.toString());
      n.a(this.D, localp, this.q);
      i1 = 200;
    }
    if (!a(this.D))
      a(localp, i1, B);
  }

  public boolean b()
  {
    return this.i;
  }

  protected abstract UMediaObject c(UMediaObject paramUMediaObject);

  protected String c(String paramString)
  {
    if (paramString == null)
      return String.valueOf(System.currentTimeMillis());
    return paramString + System.currentTimeMillis();
  }

  protected abstract void c();

  protected com.umeng.socialize.bean.b d()
  {
    c();
    this.G = new com.umeng.socialize.bean.b(this.g, this.h, this.e);
    this.G.d = this.f;
    this.G.k = new b(this);
    return this.G;
  }

  protected byte[] d(UMediaObject paramUMediaObject)
  {
    Object localObject;
    if (paramUMediaObject == null)
    {
      localObject = null;
      return localObject;
    }
    String str = "";
    UMImage localUMImage;
    if ((paramUMediaObject instanceof UMusic))
    {
      UMusic localUMusic = (UMusic)paramUMediaObject;
      str = localUMusic.d();
      localUMImage = localUMusic.j();
    }
    while (true)
    {
      if ((localUMImage != null) && (localUMImage.b()))
        str = localUMImage.a();
      byte[] arrayOfByte;
      if (!TextUtils.isEmpty(str))
      {
        Bitmap localBitmap = com.umeng.socialize.utils.a.b(str, this.l, this.l);
        if ((localBitmap != null) && (!localBitmap.isRecycled()))
        {
          arrayOfByte = com.umeng.socialize.utils.a.a(localBitmap);
          localBitmap.recycle();
        }
      }
      for (localObject = arrayOfByte; ; localObject = null)
      {
        if (((localObject != null) && (localObject.length != 0)) || (localUMImage == null) || (localUMImage.b()))
          break label236;
        return localUMImage.d_();
        if ((paramUMediaObject instanceof UMVideo))
        {
          UMVideo localUMVideo = (UMVideo)paramUMediaObject;
          str = localUMVideo.d();
          localUMImage = localUMVideo.i();
          break;
        }
        if ((paramUMediaObject instanceof UMWebPage))
        {
          UMWebPage localUMWebPage = (UMWebPage)paramUMediaObject;
          str = localUMWebPage.d();
          localUMImage = localUMWebPage.j();
          break;
        }
        if (!(paramUMediaObject instanceof UMImage))
          break label238;
        localUMImage = (UMImage)paramUMediaObject;
        if (!TextUtils.isEmpty(localUMImage.d()))
        {
          str = localUMImage.d();
          break;
        }
        if (!localUMImage.b())
          break;
        str = localUMImage.a();
        break;
      }
      label236: break;
      label238: localUMImage = null;
    }
  }

  public abstract boolean e();

  protected abstract void f();

  protected void g()
  {
    this.C.b(SocializeListeners.SnsPostListener.class);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.sso.a
 * JD-Core Version:    0.6.0
 */