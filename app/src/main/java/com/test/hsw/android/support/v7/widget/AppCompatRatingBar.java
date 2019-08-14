package android.support.v7.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.support.v4.graphics.drawable.DrawableWrapper;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R.attr;
import android.support.v7.internal.widget.TintManager;
import android.support.v7.internal.widget.TintTypedArray;
import android.util.AttributeSet;
import android.widget.RatingBar;

public class AppCompatRatingBar extends RatingBar
{
  private static final int[] TINT_ATTRS = { 16843067, 16843068 };
  private Bitmap mSampleTile;

  public AppCompatRatingBar(Context paramContext)
  {
    this(paramContext, null);
  }

  public AppCompatRatingBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.ratingBarStyle);
  }

  public AppCompatRatingBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (TintManager.SHOULD_BE_USED)
    {
      TintTypedArray localTintTypedArray = TintTypedArray.obtainStyledAttributes(getContext(), paramAttributeSet, TINT_ATTRS, paramInt, 0);
      Drawable localDrawable1 = localTintTypedArray.getDrawableIfKnown(0);
      if (localDrawable1 != null)
        setIndeterminateDrawable(tileifyIndeterminate(localDrawable1));
      Drawable localDrawable2 = localTintTypedArray.getDrawableIfKnown(1);
      if (localDrawable2 != null)
        setProgressDrawable(tileify(localDrawable2, false));
      localTintTypedArray.recycle();
    }
  }

  private Shape getDrawableShape()
  {
    return new RoundRectShape(new float[] { 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F }, null, null);
  }

  private Drawable tileify(Drawable paramDrawable, boolean paramBoolean)
  {
    int i = 0;
    if ((paramDrawable instanceof DrawableWrapper))
    {
      Drawable localDrawable2 = ((DrawableWrapper)paramDrawable).getWrappedDrawable();
      if (localDrawable2 != null)
      {
        Drawable localDrawable3 = tileify(localDrawable2, paramBoolean);
        ((DrawableWrapper)paramDrawable).setWrappedDrawable(localDrawable3);
      }
    }
    do
    {
      Object localObject = paramDrawable;
      while (true)
      {
        return localObject;
        if (!(paramDrawable instanceof LayerDrawable))
          break;
        LayerDrawable localLayerDrawable = (LayerDrawable)paramDrawable;
        int j = localLayerDrawable.getNumberOfLayers();
        Drawable[] arrayOfDrawable = new Drawable[j];
        int k = 0;
        if (k < j)
        {
          int m = localLayerDrawable.getId(k);
          Drawable localDrawable1 = localLayerDrawable.getDrawable(k);
          if ((m == 16908301) || (m == 16908303));
          for (boolean bool = true; ; bool = false)
          {
            arrayOfDrawable[k] = tileify(localDrawable1, bool);
            k++;
            break;
          }
        }
        localObject = new LayerDrawable(arrayOfDrawable);
        while (i < j)
        {
          ((LayerDrawable)localObject).setId(i, localLayerDrawable.getId(i));
          i++;
        }
      }
    }
    while (!(paramDrawable instanceof BitmapDrawable));
    Bitmap localBitmap = ((BitmapDrawable)paramDrawable).getBitmap();
    if (this.mSampleTile == null)
      this.mSampleTile = localBitmap;
    ShapeDrawable localShapeDrawable = new ShapeDrawable(getDrawableShape());
    BitmapShader localBitmapShader = new BitmapShader(localBitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP);
    localShapeDrawable.getPaint().setShader(localBitmapShader);
    if (paramBoolean)
      return new ClipDrawable(localShapeDrawable, 3, 1);
    return (Drawable)localShapeDrawable;
  }

  private Drawable tileifyIndeterminate(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof AnimationDrawable))
    {
      AnimationDrawable localAnimationDrawable1 = (AnimationDrawable)paramDrawable;
      int i = localAnimationDrawable1.getNumberOfFrames();
      AnimationDrawable localAnimationDrawable2 = new AnimationDrawable();
      localAnimationDrawable2.setOneShot(localAnimationDrawable1.isOneShot());
      for (int j = 0; j < i; j++)
      {
        Drawable localDrawable = tileify(localAnimationDrawable1.getFrame(j), true);
        localDrawable.setLevel(10000);
        localAnimationDrawable2.addFrame(localDrawable, localAnimationDrawable1.getDuration(j));
      }
      localAnimationDrawable2.setLevel(10000);
      paramDrawable = localAnimationDrawable2;
    }
    return paramDrawable;
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    monitorenter;
    try
    {
      super.onMeasure(paramInt1, paramInt2);
      if (this.mSampleTile != null)
        setMeasuredDimension(ViewCompat.resolveSizeAndState(this.mSampleTile.getWidth() * getNumStars(), paramInt1, 0), getMeasuredHeight());
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     android.support.v7.widget.AppCompatRatingBar
 * JD-Core Version:    0.6.0
 */