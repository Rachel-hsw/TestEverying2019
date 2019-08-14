package com.himamis.retex.renderer.android.d;

import com.himamis.retex.renderer.a.e.o;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

public class g
  implements com.himamis.retex.renderer.a.g.d.g
{
  private DocumentBuilderFactory a = DocumentBuilderFactory.newInstance();

  private Document a(InputStream paramInputStream)
    throws o
  {
    try
    {
      Document localDocument = this.a.newDocumentBuilder().parse(paramInputStream);
      return localDocument;
    }
    catch (Exception localException)
    {
    }
    throw new o("Could not parse resource", localException);
  }

  public com.himamis.retex.renderer.a.g.d.b a(Object paramObject)
    throws o
  {
    return new b(a((InputStream)paramObject));
  }

  public void a(boolean paramBoolean)
  {
    this.a.setIgnoringElementContentWhitespace(paramBoolean);
  }

  public void b(boolean paramBoolean)
  {
    this.a.setIgnoringComments(paramBoolean);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.android.d.g
 * JD-Core Version:    0.6.0
 */