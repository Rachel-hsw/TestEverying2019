package c.a;

import org.json.JSONArray;

public class j extends ba
{
  public j()
  {
  }

  public j(String paramString)
    throws Exception
  {
    a(new JSONArray(paramString));
  }

  public j(JSONArray paramJSONArray)
    throws Exception
  {
    a(paramJSONArray);
  }

  private void a(JSONArray paramJSONArray)
    throws Exception
  {
    a(paramJSONArray.getString(0));
    a(paramJSONArray.getInt(1));
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     c.a.j
 * JD-Core Version:    0.6.0
 */