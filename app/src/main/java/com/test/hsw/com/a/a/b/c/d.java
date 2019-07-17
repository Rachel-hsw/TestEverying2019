package com.a.a.b.c;

import android.graphics.Bitmap;
import android.graphics.ComposeShader;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import com.a.a.b.a.f;
import com.a.a.b.e.a;
import com.a.a.b.e.b;

public class d extends c
{
  public d(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }

  public void a(Bitmap paramBitmap, a parama, f paramf)
  {
    if (!(parama instanceof b))
      throw new IllegalArgumentException("ImageAware should wrap ImageView. ImageViewAware is expected.");
    parama.a(new a(paramBitmap, this.a, this.b));
  }

  protected static class a extends c.a
  {
    a(Bitmap paramBitmap, int paramInt1, int paramInt2)
    {
      super(paramInt1, paramInt2);
    }

    protected void onBoundsChange(Rect paramRect)
    {
      super.onBoundsChange(paramRect);
      RadialGradient localRadialGradient = new RadialGradient(this.c.centerX(), 1.0F * this.c.centerY() / 0.7F, 1.3F * this.c.centerX(), new int[] { 0, 0, 2130706432 }, new float[] { 0.0F, 0.7F, 1.0F }, Shader.TileMode.CLAMP);
      Matrix localMatrix = new Matrix();
      localMatrix.setScale(1.0F, 0.7F);
      localRadialGradient.setLocalMatrix(localMatrix);
      this.f.setShader(new ComposeShader(this.e, localRadialGradient, PorterDuff.Mode.SRC_OVER));
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.a.a.b.c.d
 * JD-Core Version:    0.6.0
 */