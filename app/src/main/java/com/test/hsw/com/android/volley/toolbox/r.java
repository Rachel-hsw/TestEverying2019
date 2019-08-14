package com.android.volley.toolbox;

import com.android.volley.x;

class r
  implements l.d
{
  r(NetworkImageView paramNetworkImageView, boolean paramBoolean)
  {
  }

  public void a(l.c paramc, boolean paramBoolean)
  {
    if ((paramBoolean) && (this.b))
      this.a.post(new s(this, paramc));
    do
    {
      return;
      if (paramc.b() == null)
        continue;
      this.a.setImageBitmap(paramc.b());
      return;
    }
    while (NetworkImageView.b(this.a) == 0);
    this.a.setImageResource(NetworkImageView.b(this.a));
  }

  public void a(x paramx)
  {
    if (NetworkImageView.a(this.a) != 0)
      this.a.setImageResource(NetworkImageView.a(this.a));
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.android.volley.toolbox.r
 * JD-Core Version:    0.6.0
 */