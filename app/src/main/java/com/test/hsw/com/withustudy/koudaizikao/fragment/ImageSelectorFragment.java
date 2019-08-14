package com.withustudy.koudaizikao.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.android.http.e;
import com.withustudy.koudaizikao.activity.ImageSelectorActivity;
import com.withustudy.koudaizikao.base.AbsBaseFragment;
import com.withustudy.koudaizikao.entity.LocalImageFolder;
import java.util.List;

public class ImageSelectorFragment extends AbsBaseFragment
{
  private List<LocalImageFolder> a;
  private b b;
  private ListView c;
  private int d;
  private String e;
  private a f;

  public View a(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903158, null);
  }

  public void a()
  {
    this.f = new a();
  }

  public void a(int paramInt)
  {
    this.d = paramInt;
  }

  public void a(View paramView)
  {
    this.c = ((ListView)paramView.findViewById(2131296965));
  }

  public void a(String paramString)
  {
    this.e = paramString;
  }

  public void a(List<LocalImageFolder> paramList)
  {
    this.a = paramList;
    this.b = new b();
    this.c.setAdapter(this.b);
  }

  public void b()
  {
  }

  public void c()
  {
    this.c.setOnItemClickListener(this.f);
  }

  class a
    implements AdapterView.OnItemClickListener
  {
    a()
    {
    }

    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      if (paramInt == 0)
      {
        ((ImageSelectorActivity)ImageSelectorFragment.a(ImageSelectorFragment.this)).a("all");
        return;
      }
      ((ImageSelectorActivity)ImageSelectorFragment.a(ImageSelectorFragment.this)).a(((LocalImageFolder)ImageSelectorFragment.b(ImageSelectorFragment.this).getItem(paramInt)).getName());
    }
  }

  class b extends BaseAdapter
  {
    b()
    {
    }

    public int getCount()
    {
      return 1 + ImageSelectorFragment.c(ImageSelectorFragment.this).size();
    }

    public Object getItem(int paramInt)
    {
      if (paramInt == 0)
        return null;
      return ImageSelectorFragment.c(ImageSelectorFragment.this).get(paramInt - 1);
    }

    public long getItemId(int paramInt)
    {
      return paramInt;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      a locala;
      if (paramView == null)
      {
        locala = new a();
        paramView = LayoutInflater.from(ImageSelectorFragment.a(ImageSelectorFragment.this)).inflate(2130903198, null);
        locala.a = ((ImageView)paramView.findViewById(2131297284));
        locala.b = ((TextView)paramView.findViewById(2131297285));
        locala.c = ((TextView)paramView.findViewById(2131297286));
        paramView.setTag(locala);
      }
      while (paramInt == 0)
      {
        e.a(ImageSelectorFragment.a(ImageSelectorFragment.this)).b("file://" + ImageSelectorFragment.d(ImageSelectorFragment.this), locala.a);
        locala.b.setText("所有图片");
        locala.c.setText(ImageSelectorFragment.e(ImageSelectorFragment.this) + "张");
        return paramView;
        locala = (a)paramView.getTag();
      }
      e.a(ImageSelectorFragment.a(ImageSelectorFragment.this)).b("file://" + ((LocalImageFolder)ImageSelectorFragment.c(ImageSelectorFragment.this).get(paramInt - 1)).getFirst(), locala.a);
      locala.b.setText(((LocalImageFolder)ImageSelectorFragment.c(ImageSelectorFragment.this).get(paramInt - 1)).getName());
      locala.c.setText(((LocalImageFolder)ImageSelectorFragment.c(ImageSelectorFragment.this).get(paramInt - 1)).getCount() + "张");
      return paramView;
    }

    class a
    {
      public ImageView a;
      public TextView b;
      public TextView c;

      a()
      {
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.fragment.ImageSelectorFragment
 * JD-Core Version:    0.6.0
 */