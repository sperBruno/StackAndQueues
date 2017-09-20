import java.io.IOException;
import java.io.PrintStream;
import java.util.Queue;
import java.util.Stack;
import org.junit.Assert;
import org.junit.Test;


public class HtmlValidatorTest
{
  private String pathToTestFiles = "./";
  
  public HtmlValidatorTest() {}
  
  private Stack<HtmlTag> validateTestFile(String paramString) { try { Queue localQueue = HtmlReader.getTagsFromHtmlFile(pathToTestFiles + paramString);
      
      return HtmlValidator.isValidHtml(localQueue);
    }
    catch (IOException localIOException)
    {
      System.out.println("An exception (" + localIOException + ") occurred while trying to read " + paramString + ". Be sure it is in the root directory of your Eclipse project or in the directory where you ran Java."); }
    return null;
  }
  
  @Test
  public void testFile1()
  {
    try {
      Stack localStack = validateTestFile("test1.html");
      if (localStack == null)
        Assert.fail("isValidHtml returns null for a valid HTML file input.");
      Assert.assertTrue("isValidHtml should return an empty stack for a valid HTML file input.", localStack.isEmpty());
    }
    catch (Exception localException) {
      Assert.fail("isValidHtml throws " + localException + " for valid HTML file input");
    }
  }
  
  @Test
  public void testFile2() {
    try {
      Stack localStack1 = validateTestFile("test2.html");
      if (localStack1 == null) {
        Assert.fail("isValidHtml returns null when file ends without closing tags");
      }
      Stack localStack2 = new Stack();
      localStack2.push(new HtmlTag("html", true));
      localStack2.push(new HtmlTag("b", true));
      Assert.assertTrue("isValidHtml should return Stack with unmatched elements when file ends without closing tags", localStack2.equals(localStack1));
    }
    catch (Exception localException) {
      Assert.fail("isValidHtml throws " + localException + " when file ends without closing tags");
    }
  }
  
  @Test
  public void testFile3() {
    try {
      Stack localStack1 = validateTestFile("test3.html");
      if (localStack1 == null) {
        Assert.fail("isValidHtml returns null when tags are closed in incorrect order");
      }
      Stack localStack2 = new Stack();
      localStack2.push(new HtmlTag("b", true));
      localStack2.push(new HtmlTag("i", true));
      Assert.assertTrue("isValidHtml should return Stack with unmatched elements when tags are closed in incorrect order", localStack2.equals(localStack1));
    }
    catch (Exception localException) {
      Assert.fail("isValidHtml throws " + localException + " when tags are closed in incorrect order");
    }
  }
  
  @Test
  public void testFile4() {
    try {
      Stack localStack = validateTestFile("test4.html");
      Assert.assertNull("isValidHtml should return null when encountering closing tag without matching opening tag", localStack);
    }
    catch (Exception localException) {
      Assert.fail("isValidHtml throws " + localException + " when encountering closing tag without matching opening tag");
    }
  }
  
  @Test
  public void testFile5()
  {
    try {
      Stack localStack = validateTestFile("test5.html");
      if (localStack == null) {
        Assert.fail("isValidHtml returns null for a valid HTML file input.");
      }
      Assert.assertTrue("isValidHtml should return an empty stack for a valid HTML file input.", localStack.isEmpty());
    }
    catch (Exception localException) {
      Assert.fail("isValidHtml throws " + localException + " for a valid HTML file input.");
    }
  }
  
  @Test
  public void testFile6() {
    try {
      Stack localStack1 = validateTestFile("test6.html");
      if (localStack1 == null) {
        Assert.fail("isValidHtml returns null when some tags are not closed");
      }
      Stack localStack2 = new Stack();
      localStack2.push(new HtmlTag("html", true));
      localStack2.push(new HtmlTag("head", true));
      localStack2.push(new HtmlTag("title", true));
      localStack2.push(new HtmlTag("p", true));
      Assert.assertTrue("isValidHtml should return Stack with unmatched elements when some tags are not closed", localStack2.equals(localStack1));
    }
    catch (Exception localException) {
      Assert.fail("isValidHtml throws " + localException + " when some tags are not closed");
    }
  }
  
  @Test
  public void testFile7() {
    try {
      Stack localStack = validateTestFile("test7.html");
      Assert.assertNull("isValidHtml should return null for HTML file containing only closing tag", localStack);
    }
    catch (Exception localException) {
      Assert.fail("isValidHtml throws " + localException + " for HTML file containing only closing tag");
    }
  }
}
