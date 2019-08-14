package com.withustudy.koudaizikao.fragment;

import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.withustudy.koudaizikao.a.b;
import com.withustudy.koudaizikao.a.c;
import com.withustudy.koudaizikao.activity.QuestionDetailActivity;
import com.withustudy.koudaizikao.b.i;
import com.withustudy.koudaizikao.b.i.b;
import com.withustudy.koudaizikao.custom.MyListView;
import com.withustudy.koudaizikao.custom.MyScrollView;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.Comments;
import com.withustudy.koudaizikao.entity.Exercises;
import com.withustudy.koudaizikao.entity.req.ExerciseIdList;
import com.withustudy.koudaizikao.g.h;
import com.withustudy.koudaizikao.g.n;
import java.util.ArrayList;
import java.util.List;

class p extends Handler
{
  p(QuestionDetailFragment paramQuestionDetailFragment)
  {
  }

  public void handleMessage(Message paramMessage)
  {
    Comments localComments;
    switch (paramMessage.what)
    {
    case 2:
    case 3:
    case 4:
    default:
      return;
    case 7:
      QuestionDetailFragment.a(this.a).toggleSoftInput(0, 2);
      QuestionDetailFragment.a(this.a, (i.b)paramMessage.obj);
      return;
    case 10:
      if ((QuestionDetailFragment.b(this.a) == null) || (QuestionDetailFragment.c(this.a) == null))
        QuestionDetailFragment.d(this.a);
      localComments = QuestionDetailFragment.e(this.a).getComments();
      if (localComments == null)
        break;
    case 1:
    case 6:
    case 5:
    case 8:
    case 9:
    }
    for (int i = localComments.getTotalNum(); ; i = 0)
    {
      String str1 = "共" + i + "条吐槽";
      QuestionDetailFragment.b(this.a).setText(str1);
      String str2 = "所有吐槽" + i + "条";
      QuestionDetailFragment.c(this.a).setText(str2);
      h.a("获取题目的详情更新UI ExcerciseCommentAdapter size=" + QuestionDetailFragment.f(this.a).size());
      if (QuestionDetailFragment.g(this.a) == null)
      {
        QuestionDetailFragment.a(this.a, new i(this.a.getActivity(), QuestionDetailFragment.f(this.a), QuestionDetailFragment.h(this.a)));
        QuestionDetailFragment.i(this.a).setAdapter(QuestionDetailFragment.g(this.a));
        if (!QuestionDetailFragment.j(this.a))
          break;
        QuestionDetailFragment.k(this.a).smoothScrollTo(0, 0);
        QuestionDetailFragment.a(this.a, false);
        return;
      }
      QuestionDetailFragment.g(this.a).notifyDataSetChanged();
      return;
      QuestionDetailFragment.l(this.a).b();
      return;
      try
      {
        QuestionDetailFragment.a(this.a).hideSoftInputFromWindow(this.a.getActivity().getCurrentFocus().getWindowToken(), 2);
        QuestionDetailFragment.m(this.a).setText("");
        ExerciseIdList localExerciseIdList = new ExerciseIdList();
        localExerciseIdList.setClientType(n.a());
        localExerciseIdList.setImei(n.d(QuestionDetailFragment.n(this.a)));
        localExerciseIdList.setNet(n.c(QuestionDetailFragment.n(this.a)));
        localExerciseIdList.setVersionName(QuestionDetailFragment.o(this.a).p());
        ArrayList localArrayList = new ArrayList();
        localExerciseIdList.setExerciseId(localArrayList);
        localArrayList.add(QuestionDetailFragment.e(this.a).getExerciseId());
        localExerciseIdList.setUserSubject(QuestionDetailFragment.l(this.a).f);
        c.b().U().a(this.a, localExerciseIdList, 10);
        return;
      }
      catch (Exception localException2)
      {
        return;
      }
      try
      {
        QuestionDetailFragment.a(this.a).hideSoftInputFromWindow(this.a.getActivity().getCurrentFocus().getWindowToken(), 2);
        return;
      }
      catch (Exception localException1)
      {
        return;
      }
      Toast.makeText(this.a.getActivity(), "发布失败", 0).show();
      return;
      Exercises localExercises = (Exercises)paramMessage.obj;
      QuestionDetailFragment.a(this.a, localExercises);
      return;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.fragment.p
 * JD-Core Version:    0.6.0
 */