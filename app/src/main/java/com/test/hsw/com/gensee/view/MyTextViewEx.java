package com.gensee.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.gensee.chat.gif.GifDrawalbe;
import com.gensee.chat.gif.GifDrawalbe.UpdateUIListen;
import com.gensee.chat.gif.SpanResource;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

public class MyTextViewEx extends TextView
  implements GifDrawalbe.UpdateUIListen
{
  private static Map<Integer, Drawable> cache;
  private Context context = null;
  private Vector<Drawable> drawables;

  public MyTextViewEx(Context paramContext)
  {
    super(paramContext);
    this.context = paramContext;
    this.drawables = new Vector();
    if (cache == null)
      cache = new HashMap();
  }

  public MyTextViewEx(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
    this.drawables = new Vector();
    if (cache == null)
      cache = new HashMap();
  }

  public MyTextViewEx(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.context = paramContext;
    this.drawables = new Vector();
    if (cache == null)
      cache = new HashMap();
  }

  private void destroy()
  {
    this.drawables.clear();
    this.drawables = null;
  }

  private void insertGif(String paramString)
  {
    if (this.drawables == null)
      this.drawables = new Vector();
    setText(SpanResource.convetRichToExpression(this.context, paramString, 0, cache, this.drawables));
    Iterator localIterator = this.drawables.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      Drawable localDrawable = (Drawable)localIterator.next();
      ((GifDrawalbe)localDrawable).addListen(this);
      ((GifDrawalbe)localDrawable).readFrames(true);
    }
  }

  public static void putGifDrawableCache(int paramInt, Drawable paramDrawable)
  {
    if (cache == null)
      cache = new HashMap();
    cache.put(Integer.valueOf(paramInt), paramDrawable);
  }

  protected void onWindowVisibilityChanged(int paramInt)
  {
    super.onWindowVisibilityChanged(paramInt);
    Iterator localIterator;
    if ((paramInt == 8) && (this.drawables != null))
      localIterator = this.drawables.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
      {
        destroy();
        return;
      }
      ((GifDrawalbe)(Drawable)localIterator.next()).removeListen(this);
    }
  }

  public void setRichText(String paramString)
  {
    insertGif(paramString);
  }

  public void updateUI()
  {
    invalidate();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.view.MyTextViewEx
 * JD-Core Version:    0.6.0
 */