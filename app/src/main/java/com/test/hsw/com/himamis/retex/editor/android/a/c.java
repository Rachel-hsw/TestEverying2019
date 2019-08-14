package com.himamis.retex.editor.android.a;

import android.os.Build.VERSION;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.himamis.retex.editor.a.d.d;

public class c
  implements View.OnKeyListener
{
  private d a;

  public c(d paramd)
  {
    this.a = paramd;
  }

  private static int a(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return 0;
    case 67:
      return 8;
    case 21:
      return 37;
    case 22:
      return 39;
    case 19:
      return 38;
    case 20:
    }
    return 40;
  }

  private static com.himamis.retex.editor.a.d.c a(KeyEvent paramKeyEvent)
  {
    int i = a(paramKeyEvent.getKeyCode());
    char c = c(paramKeyEvent);
    return new com.himamis.retex.editor.a.d.c(i, b(paramKeyEvent), c);
  }

  private static int b(KeyEvent paramKeyEvent)
  {
    if (Build.VERSION.SDK_INT >= 13)
      return paramKeyEvent.getModifiers();
    return 0;
  }

  private static char c(KeyEvent paramKeyEvent)
  {
    int i = paramKeyEvent.getUnicodeChar();
    int k;
    if ((paramKeyEvent.getAction() == 2) && (paramKeyEvent.getKeyCode() == 0))
      k = paramKeyEvent.getCharacters().charAt(0);
    do
    {
      int j;
      do
      {
        return k;
        j = 0x80000000 & i;
        k = 0;
      }
      while (j != 0);
      k = 0;
    }
    while (i == 0);
    return (char)i;
  }

  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool;
    switch (paramKeyEvent.getAction())
    {
    default:
      bool = false;
    case 0:
    case 1:
    case 2:
    }
    com.himamis.retex.editor.a.d.c localc;
    do
    {
      return bool;
      return this.a.a(a(paramKeyEvent));
      localc = a(paramKeyEvent);
      bool = this.a.b(localc);
    }
    while (localc.c() == 0);
    return bool | this.a.c(localc);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.editor.android.a.c
 * JD-Core Version:    0.6.0
 */