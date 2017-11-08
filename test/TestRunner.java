
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

  public static void main(String[] args) {
    Result result = JUnitCore.runClasses(FactoryCreatorTest.class);

    System.out.println("Test Details:");

    for(Failure failure: result.getFailures()){
      System.out.println("Failure: " + failure.toString());
    }

    System.out.println("\nFailed:" + result.getFailureCount() + "/" + result.getRunCount());
    System.out.println("Passed:" + (result.getRunCount() - result.getFailureCount()) + "/" + result.getRunCount());
  }
}
