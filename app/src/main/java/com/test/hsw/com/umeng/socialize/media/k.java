package com.umeng.socialize.media;

import com.umeng.socialize.utils.i;
import java.io.File;
import java.io.IOException;

class k
  implements Runnable
{
  k(UMImage paramUMImage, byte[] paramArrayOfByte)
  {
  }

  public void run()
  {
    try
    {
      File localFile1 = UMImage.a(this.b, this.b.m());
      File localFile2 = UMImage.a(this.a, localFile1);
      UMImage.a(this.b, localFile2);
      return;
    }
    catch (IOException localIOException)
    {
      i.b(UMImage.p(), "Sorry cannot setImage..[" + localIOException.toString() + "]");
      return;
    }
    finally
    {
      UMImage.a(this.b);
    }
    throw localObject;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.media.k
 * JD-Core Version:    0.6.0
 */