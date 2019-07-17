package com.withustudy.koudaizikao.fragment;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.withustudy.koudaizikao.activity.ShowPictureActivity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class u
  implements View.OnClickListener
{
  u(QuestionDetailFragment paramQuestionDetailFragment, String paramString)
  {
  }

  public void onClick(View paramView)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("type", "online");
    localBundle.putInt("currentitem_key", 0);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.b);
    localBundle.putSerializable("image_name", (Serializable)localArrayList);
    QuestionDetailFragment.a(this.a, ShowPictureActivity.class, false, localBundle);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.fragment.u
 * JD-Core Version:    0.6.0
 */