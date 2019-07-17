package com.koudai.test;

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
import com.withustudy.koudaizikao.b.i;
import com.withustudy.koudaizikao.b.i.b;
import com.withustudy.koudaizikao.custom.MyListView;
import com.withustudy.koudaizikao.custom.MyScrollView;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.Comments;
import com.withustudy.koudaizikao.entity.Exercises;
import com.withustudy.koudaizikao.entity.req.ExerciseIdList;
import com.withustudy.koudaizikao.entity.req.UserSubject;
import com.withustudy.koudaizikao.g.h;
import com.withustudy.koudaizikao.g.n;
import java.util.ArrayList;
import java.util.List;

class d extends Handler
{
  d(BrushExcerciseDetailFragment paramBrushExcerciseDetailFragment)
  {
  }

  public void handleMessage(Message paramMessage)
  {
    try
    {
      switch (paramMessage.what)
      {
      case 7:
        BrushExcerciseDetailFragment.a(this.a).toggleSoftInput(0, 2);
        BrushExcerciseDetailFragment.a(this.a, (i.b)paramMessage.obj);
        return;
      case 10:
        if ((BrushExcerciseDetailFragment.b(this.a) == null) || (BrushExcerciseDetailFragment.c(this.a) == null))
          BrushExcerciseDetailFragment.d(this.a);
        Comments localComments = BrushExcerciseDetailFragment.e(this.a).getComments();
        int i = 0;
        if (localComments != null)
          i = localComments.getTotalNum();
        String str1 = "共" + i + "条吐槽";
        BrushExcerciseDetailFragment.b(this.a).setText(str1);
        String str2 = "所有吐槽" + i + "条";
        BrushExcerciseDetailFragment.c(this.a).setText(str2);
        h.a("获取题目的详情更新UI ExcerciseCommentAdapter size=" + BrushExcerciseDetailFragment.f(this.a).size());
        if (BrushExcerciseDetailFragment.g(this.a) == null)
        {
          BrushExcerciseDetailFragment.a(this.a, new i(this.a.getActivity(), BrushExcerciseDetailFragment.f(this.a), BrushExcerciseDetailFragment.h(this.a)));
          BrushExcerciseDetailFragment.i(this.a).setAdapter(BrushExcerciseDetailFragment.g(this.a));
          if (BrushExcerciseDetailFragment.j(this.a))
          {
            BrushExcerciseDetailFragment.k(this.a).smoothScrollTo(0, 0);
            BrushExcerciseDetailFragment.a(this.a, false);
            return;
          }
        }
        else
        {
          BrushExcerciseDetailFragment.g(this.a).notifyDataSetChanged();
          return;
        }
      case 11:
        BrushExcerciseDetailFragment.l(this.a).f();
        return;
      case 6:
        try
        {
          BrushExcerciseDetailFragment.a(this.a).hideSoftInputFromWindow(this.a.getActivity().getCurrentFocus().getWindowToken(), 2);
          BrushExcerciseDetailFragment.m(this.a).setText("");
          ExerciseIdList localExerciseIdList = new ExerciseIdList();
          localExerciseIdList.setClientType(n.a());
          localExerciseIdList.setImei(n.d(this.a.d));
          localExerciseIdList.setNet(n.c(this.a.d));
          localExerciseIdList.setVersionName(BrushExcerciseDetailFragment.n(this.a).p());
          ArrayList localArrayList = new ArrayList();
          localExerciseIdList.setExerciseId(localArrayList);
          localArrayList.add(BrushExcerciseDetailFragment.e(this.a).getExerciseId());
          UserSubject localUserSubject = new UserSubject();
          localUserSubject.setUid(BrushExcerciseDetailFragment.n(this.a).i());
          localUserSubject.setSubjectId(BrushExcerciseDetailFragment.o(this.a));
          localExerciseIdList.setUserSubject(localUserSubject);
          c.b().U().a(this.a, localExerciseIdList, 10);
          return;
        }
        catch (Exception localException3)
        {
          return;
        }
      case 5:
        try
        {
          BrushExcerciseDetailFragment.a(this.a).hideSoftInputFromWindow(this.a.getActivity().getCurrentFocus().getWindowToken(), 2);
          return;
        }
        catch (Exception localException2)
        {
          return;
        }
      case 8:
        Toast.makeText(this.a.getActivity(), "发布失败", 0).show();
        return;
      case 9:
        Exercises localExercises = (Exercises)paramMessage.obj;
        BrushExcerciseDetailFragment.a(this.a, localExercises);
      }
      return;
    }
    catch (Exception localException1)
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.koudai.test.d
 * JD-Core Version:    0.6.0
 */