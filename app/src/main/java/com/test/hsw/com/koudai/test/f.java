package com.koudai.test;

import android.text.Editable;
import android.text.TextWatcher;
import com.withustudy.koudaizikao.entity.Exercises;
import com.withustudy.koudaizikao.g.h;
import java.util.HashMap;

class f
  implements TextWatcher
{
  f(BrushExcerciseDetailFragment paramBrushExcerciseDetailFragment)
  {
  }

  public void afterTextChanged(Editable paramEditable)
  {
  }

  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
  }

  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    String str = paramCharSequence.toString().trim();
    if ((str != null) && (!"".equals(str)))
    {
      BrushExcerciseDetailFragment.p(this.a).put(Integer.valueOf(0), str);
      if (!BrushExcerciseDetailFragment.q(this.a))
        break label301;
      if (paramCharSequence.length() <= 0)
        break label226;
      BrushExcerciseDetailFragment.b(this.a, true);
      BrushExcerciseDetailFragment.l(this.a).d.put(Integer.valueOf(BrushExcerciseDetailFragment.s(this.a)), "true");
      BrushExcerciseDetailFragment.l(this.a).e.put(Integer.valueOf(BrushExcerciseDetailFragment.s(this.a)), Boolean.valueOf(true));
      if (!BrushExcerciseDetailFragment.t(this.a))
        break label290;
      BrushExcerciseDetailFragment.a(this.a, BrushExcerciseDetailFragment.e(this.a).getScore());
      label151: BrushExcerciseDetailFragment.l(this.a).a(BrushExcerciseDetailFragment.e(this.a), BrushExcerciseDetailFragment.p(this.a), BrushExcerciseDetailFragment.t(this.a), true, BrushExcerciseDetailFragment.u(this.a), BrushExcerciseDetailFragment.e(this.a).getScore());
      h.a("插入currentInx=" + BrushExcerciseDetailFragment.s(this.a));
    }
    label226: Boolean localBoolean;
    label290: label301: 
    do
    {
      return;
      BrushExcerciseDetailFragment.b(this.a, false);
      BrushExcerciseDetailFragment.l(this.a).d.put(Integer.valueOf(BrushExcerciseDetailFragment.s(this.a)), null);
      BrushExcerciseDetailFragment.l(this.a).e.put(Integer.valueOf(BrushExcerciseDetailFragment.s(this.a)), Boolean.valueOf(false));
      break;
      BrushExcerciseDetailFragment.a(this.a, 0.0D);
      break label151;
      localBoolean = (Boolean)BrushExcerciseDetailFragment.l(this.a).e.get(Integer.valueOf(BrushExcerciseDetailFragment.s(this.a)));
    }
    while (((localBoolean != null) && (localBoolean.booleanValue())) || (BrushExcerciseDetailFragment.l(this.a).a));
    BrushExcerciseDetailFragment.b(this.a, false);
    BrushExcerciseDetailFragment.a(this.a, 0.0D);
    BrushExcerciseDetailFragment.l(this.a).a(BrushExcerciseDetailFragment.e(this.a), BrushExcerciseDetailFragment.p(this.a), BrushExcerciseDetailFragment.t(this.a), false, BrushExcerciseDetailFragment.u(this.a), BrushExcerciseDetailFragment.e(this.a).getScore());
    h.a("插入currentInx=" + BrushExcerciseDetailFragment.s(this.a));
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.koudai.test.f
 * JD-Core Version:    0.6.0
 */