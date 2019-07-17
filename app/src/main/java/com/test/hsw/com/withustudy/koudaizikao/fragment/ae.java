package com.withustudy.koudaizikao.fragment;

import android.os.Handler;
import android.os.Message;
import android.widget.ListView;
import android.widget.Toast;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.withustudy.koudaizikao.b.af;
import java.util.List;

class ae extends Handler
{
  ae(ViedeoChongCiFragment paramViedeoChongCiFragment)
  {
  }

  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default:
      return;
    case 9:
      Toast.makeText(this.a.getActivity(), "还没有冲刺串讲!", 0).show();
      return;
    case 12:
      Toast.makeText(this.a.getActivity(), "没有更多了!", 0).show();
      return;
    case 10:
      ViedeoChongCiFragment.a(this.a).clear();
      ViedeoChongCiFragment.a(this.a).addAll((List)paramMessage.obj);
      ViedeoChongCiFragment.a(this.a, new af(ViedeoChongCiFragment.b(this.a), ViedeoChongCiFragment.a(this.a), this.a.e));
      ViedeoChongCiFragment.c(this.a).setAdapter(ViedeoChongCiFragment.d(this.a));
      return;
    case 11:
    }
    List localList = (List)paramMessage.obj;
    if ((localList != null) && (localList.size() > 0))
    {
      ViedeoChongCiFragment.a(this.a).addAll(localList);
      ViedeoChongCiFragment.d(this.a).notifyDataSetChanged();
      ((ListView)ViedeoChongCiFragment.c(this.a).getRefreshableView()).setSelection(ViedeoChongCiFragment.c(this.a).getBottom());
      return;
    }
    Toast.makeText(this.a.getActivity(), "没有更多了!", 0).show();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.fragment.ae
 * JD-Core Version:    0.6.0
 */