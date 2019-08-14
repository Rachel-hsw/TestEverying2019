package com.withustudy.koudaizikao.fragment;

import android.text.Editable;
import android.text.TextWatcher;
import com.withustudy.koudaizikao.activity.QuestionDetailActivity;
import com.withustudy.koudaizikao.entity.Exercises;
import com.withustudy.koudaizikao.g.h;
import java.util.HashMap;

class s
  implements TextWatcher
{
  s(QuestionDetailFragment paramQuestionDetailFragment)
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
      QuestionDetailFragment.p(this.a).put(Integer.valueOf(0), str);
      if (QuestionDetailFragment.q(this.a))
      {
        if (paramCharSequence.length() <= 0)
          break label225;
        QuestionDetailFragment.b(this.a, true);
        QuestionDetailFragment.l(this.a).a.put(Integer.valueOf(QuestionDetailFragment.s(this.a)), "true");
        QuestionDetailFragment.l(this.a).j.put(Integer.valueOf(QuestionDetailFragment.s(this.a)), Boolean.valueOf(true));
        if (!QuestionDetailFragment.t(this.a))
          break label289;
        QuestionDetailFragment.a(this.a, QuestionDetailFragment.e(this.a).getScore());
      }
    }
    while (true)
    {
      QuestionDetailFragment.l(this.a).a(QuestionDetailFragment.e(this.a), QuestionDetailFragment.p(this.a), QuestionDetailFragment.t(this.a), QuestionDetailFragment.u(this.a), QuestionDetailFragment.e(this.a).getScore());
      h.a("插入currentInx=" + QuestionDetailFragment.s(this.a));
      return;
      label225: QuestionDetailFragment.b(this.a, false);
      QuestionDetailFragment.l(this.a).a.put(Integer.valueOf(QuestionDetailFragment.s(this.a)), null);
      QuestionDetailFragment.l(this.a).j.put(Integer.valueOf(QuestionDetailFragment.s(this.a)), Boolean.valueOf(false));
      break;
      label289: QuestionDetailFragment.a(this.a, 0.0D);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.fragment.s
 * JD-Core Version:    0.6.0
 */