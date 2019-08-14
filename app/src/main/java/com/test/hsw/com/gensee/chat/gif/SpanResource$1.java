package com.gensee.chat.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import android.text.Html.ImageGetter;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

class SpanResource$1
  implements Html.ImageGetter
{
  public Drawable getDrawable(String paramString)
  {
    Integer localInteger1 = Integer.valueOf(-1);
    Iterator localIterator = SpanResource.access$0().keySet().iterator();
    Integer localInteger2;
    if (!localIterator.hasNext())
    {
      localInteger2 = localInteger1;
      label31: if (localInteger2.intValue() <= 0)
        break label280;
      if (!paramString.endsWith(".gif"))
        break label198;
      if (!this.val$cache.containsKey(localInteger2))
        break label159;
    }
    label159: GifDrawalbe localGifDrawalbe;
    for (Object localObject = (Drawable)this.val$cache.get(localInteger2); ; localObject = localGifDrawalbe)
    {
      if ((this.val$drawables != null) && (!this.val$drawables.contains(localObject)))
        this.val$drawables.add(localObject);
      return localObject;
      String str = (String)localIterator.next();
      if (!paramString.endsWith(str.substring(1, -1 + str.length())))
        break;
      localInteger2 = (Integer)SpanResource.access$0().get(str);
      break label31;
      localGifDrawalbe = new GifDrawalbe(this.val$context, localInteger2.intValue());
      this.val$cache.put(localInteger2, localGifDrawalbe);
    }
    label198: Drawable localDrawable = this.val$context.getResources().getDrawable(localInteger2.intValue());
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeResource(this.val$context.getResources(), localInteger2.intValue(), localOptions);
    localDrawable.setBounds(0, 0, (int)(localOptions.outWidth * GifDrawalbe.ration), (int)(localOptions.outHeight * GifDrawalbe.ration));
    return localDrawable;
    label280: if (SpanResource.access$1() != null)
      return SpanResource.access$1().getDrawable(paramString);
    return (Drawable)null;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.chat.gif.SpanResource.1
 * JD-Core Version:    0.6.0
 */