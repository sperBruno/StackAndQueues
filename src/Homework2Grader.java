import java.io.PrintStream;

public class Homework2Grader
{
  public Homework2Grader() {}
  
  public static void main(String[] paramArrayOfString) {
    org.junit.runner.Result localResult = org.junit.runner.JUnitCore.runClasses(new Class[] { HtmlValidatorTest.class });
    
    int i = localResult.getFailureCount();
    int j = localResult.getRunCount() - i;
    
    if (j == 1) {
      System.out.println("1 test passed.");
    } else {
      System.out.println(j + " tests passed.");
    }
    if (i == 1)
      System.out.println("1 test failed."); else {
      System.out.println(i + " tests failed.");
    }
    
    if (i == 0) {
      System.out.println("Great job! Your score for this assignment would be 100%");
    }
    else {
      int k = (int)(j / (i + j) * 100.0D);
      int m = 1;
      for (org.junit.runner.notification.Failure localFailure : localResult.getFailures()) { Throwable localThrowable;
        if (localFailure.getMessage() == null) {
          localThrowable = localFailure.getException();
          System.out.println("#" + m + ". A test threw " + localThrowable + " at " + localThrowable.getStackTrace()[0]);

        }
        else
        {
          localThrowable = localFailure.getException();
          if ((localThrowable instanceof AssertionError)) {
            System.out.println("#" + m + ". " + localFailure.getMessage());
          }
          else {
            System.out.println("#" + m + ". " + localFailure.getException() + " occurs at " + localFailure.getException().getStackTrace()[0]);
          }
        }
        m++;
      }
      System.out.println("Your score for this assignment would be " + k + "%\n");
    }
  }
}
