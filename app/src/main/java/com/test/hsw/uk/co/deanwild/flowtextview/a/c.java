package uk.co.deanwild.flowtextview.a;

import android.text.TextPaint;
import java.util.ArrayList;
import java.util.Iterator;

public class c
{
  private ArrayList<TextPaint> a = new ArrayList();

  public TextPaint a()
  {
    if (this.a.size() > 0)
      return (TextPaint)this.a.remove(0);
    return new TextPaint(1);
  }

  public void a(int paramInt)
  {
    Iterator localIterator = this.a.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      ((TextPaint)localIterator.next()).setColor(paramInt);
    }
  }

  public void a(TextPaint paramTextPaint)
  {
    this.a.add(paramTextPaint);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     uk.co.deanwild.flowtextview.a.c
 * JD-Core Version:    0.6.0
 */