package krelve.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.withustudy.koudaizikao.g.h;

class b
  implements View.OnClickListener
{
  b(Kanner.a parama, int paramInt)
  {
  }

  public void onClick(View paramView)
  {
    h.a(Kanner.a.a(this.a).getContext(), "pos=" + this.b);
    if (Kanner.h(Kanner.a.a(this.a)) != null)
      Kanner.h(Kanner.a.a(this.a)).b(this.b);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     krelve.view.b
 * JD-Core Version:    0.6.0
 */