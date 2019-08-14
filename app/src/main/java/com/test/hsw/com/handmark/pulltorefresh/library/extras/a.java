package com.handmark.pulltorefresh.library.extras;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.View;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.b;
import com.handmark.pulltorefresh.library.PullToRefreshBase.d;
import com.handmark.pulltorefresh.library.PullToRefreshBase.j;
import java.util.HashMap;

public class a<V extends View>
  implements PullToRefreshBase.d<V>
{
  private final Context a;
  private final HashMap<PullToRefreshBase.j, Integer> b;
  private MediaPlayer c;

  public a(Context paramContext)
  {
    this.a = paramContext;
    this.b = new HashMap();
  }

  private void a(int paramInt)
  {
    if (this.c != null)
    {
      this.c.stop();
      this.c.release();
    }
    this.c = MediaPlayer.create(this.a, paramInt);
    if (this.c != null)
      this.c.start();
  }

  public void a()
  {
    this.b.clear();
  }

  public void a(PullToRefreshBase.j paramj, int paramInt)
  {
    this.b.put(paramj, Integer.valueOf(paramInt));
  }

  public final void a(PullToRefreshBase<V> paramPullToRefreshBase, PullToRefreshBase.j paramj, PullToRefreshBase.b paramb)
  {
    Integer localInteger = (Integer)this.b.get(paramj);
    if (localInteger != null)
      a(localInteger.intValue());
  }

  public MediaPlayer b()
  {
    return this.c;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.handmark.pulltorefresh.library.extras.a
 * JD-Core Version:    0.6.0
 */