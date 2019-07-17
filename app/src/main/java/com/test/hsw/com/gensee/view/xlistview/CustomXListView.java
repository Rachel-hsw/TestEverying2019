package com.gensee.view.xlistview;

import android.content.Context;
import android.util.AttributeSet;
import com.gensee.rtmpresourcelib.R.id;
import com.gensee.rtmpresourcelib.R.layout;
import com.gensee.rtmpresourcelib.R.string;

public class CustomXListView extends XListView
{
  public CustomXListView(Context paramContext)
  {
    super(paramContext);
  }

  public CustomXListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public CustomXListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  protected XListViewFooter getFooterView(Context paramContext)
  {
    return new CustomXListViewFooter(paramContext);
  }

  protected int getHeadContentTvId()
  {
    return R.id.xlistview_header_content;
  }

  protected int getHeadTimeTvId()
  {
    return R.id.xlistview_header_time;
  }

  protected XListViewHeader getHeaderView(Context paramContext)
  {
    return new CustomXListViewHeader(paramContext);
  }

  private class CustomXListViewFooter extends XListViewFooter
  {
    public CustomXListViewFooter(Context arg2)
    {
      super();
    }

    public CustomXListViewFooter(Context paramAttributeSet, AttributeSet arg3)
    {
      super(localAttributeSet);
    }

    protected int getFooterContentTvId()
    {
      return R.id.xlistview_footer_content;
    }

    protected int getFooterHintNormalStrId()
    {
      return R.string.xlistview_footer_hint_normal;
    }

    protected int getFooterHintReadyStrId()
    {
      return R.string.xlistview_footer_hint_ready;
    }

    protected int getFooterHintTvId()
    {
      return R.id.xlistview_footer_hint_textview;
    }

    protected int getFooterProgressbarId()
    {
      return R.id.xlistview_footer_progressbar;
    }

    protected int getFooterViewLayoutId()
    {
      return R.layout.xlistview_footer;
    }
  }

  private class CustomXListViewHeader extends XListViewHeader
  {
    public CustomXListViewHeader(Context arg2)
    {
      super();
    }

    public CustomXListViewHeader(Context paramAttributeSet, AttributeSet arg3)
    {
      super(localAttributeSet);
    }

    protected int getHeaderArrowIvId()
    {
      return R.id.xlistview_header_arrow;
    }

    protected int getHeaderHintLoadingStrId()
    {
      return R.string.xlistview_header_hint_loading;
    }

    protected int getHeaderHintNormalStrId()
    {
      return R.string.xlistview_header_hint_normal;
    }

    protected int getHeaderHintReadyStrId()
    {
      return R.string.xlistview_header_hint_ready;
    }

    protected int getHeaderHintTvId()
    {
      return R.id.xlistview_header_hint_textview;
    }

    protected int getHeaderProgressbarId()
    {
      return R.id.xlistview_header_progressbar;
    }

    protected int getHeaderViewLayoutId()
    {
      return R.layout.xlistview_header;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.view.xlistview.CustomXListView
 * JD-Core Version:    0.6.0
 */