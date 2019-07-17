package com.withustudy.koudaizikao.fragment;

import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import com.withustudy.koudaizikao.custom.IrregularPercentRelativeLayout;
import com.withustudy.koudaizikao.d.a.a;
import com.withustudy.koudaizikao.entity.SubjectState;
import com.withustudy.koudaizikao.entity.SubjectStateW;
import java.util.List;

class z extends Handler
{
  z(SubjectFragment paramSubjectFragment)
  {
  }

  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default:
      return;
    case 0:
    }
    while (true)
    {
      try
      {
        if (SubjectFragment.a(this.a) == null)
          break;
        SubjectState localSubjectState = SubjectFragment.a(this.a).getSubjectState();
        if (SubjectFragment.b(this.a))
          continue;
        f = (float)(30.0D * (1.0D * SubjectFragment.c(this.a).getHeight() / 214.0D));
        if (f >= 38.0F)
        {
          f = 35.0F;
          break label263;
          a.a.a = f;
          SubjectFragment.a(this.a, true);
          if (localSubjectState == null)
            break;
          List localList = localSubjectState.getExamReminds();
          if ((localList == null) || (localList.size() <= 0))
            break;
          String str1 = (String)localList.get(0);
          SubjectFragment.d(this.a).setText(str1);
          String str2 = (String)localList.get(1);
          SubjectFragment.e(this.a).setTextSize(a.a.a);
          SubjectFragment.e(this.a).setText(str2);
          String str3 = (String)localList.get(2);
          SubjectFragment.f(this.a).setText(str3);
          return;
        }
      }
      catch (Exception localException)
      {
        return;
      }
      label263: if (f > 12.0F)
        continue;
      float f = 15.0F;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.fragment.z
 * JD-Core Version:    0.6.0
 */