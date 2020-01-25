package calculatorPackage;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.*;

import org.junit.Assert;
//import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTester {
	
   @InjectMocks 
   MathApplication mathApplication = new MathApplication();

   @Mock
   CalculatorService calcService;

   @Test
   public void testCommon(){
      //add the behavior of calc service to add two numbers
      when(calcService.add(10.0,20.0)).thenReturn(30.00);
      when(calcService.subtract(20.0,10.0)).thenReturn(10.0);
      
      //Multiplication
      when(calcService.multiply(10.0, 10.0)).thenReturn(100.00);
      when(calcService.multiply(11.0, 0.0)).thenReturn(0.0);
      //Division
      when(calcService.divide(200.0, 10.0)).thenReturn(20.0);
      when(calcService.divide(100.0, 0.0)).thenThrow(ArithmeticException.class);

		
      //test the add functionality
      Assert.assertEquals(calcService.add(10.0, 20.0),30.0,0);
      Assert.assertEquals(calcService.subtract(20.0, 10.0),10.0,0);
      Assert.assertEquals(calcService.multiply(10.0, 10.0),100.0,0);
      Assert.assertEquals(calcService.divide(200.0, 10.0),20.0,0);
      
      
      
      InOrder inOrder = inOrder(calcService);
      
      inOrder.verify(calcService).add(10.0,20.0);
      inOrder.verify(calcService).subtract(20.0,10.0);
      
      inOrder.verify(calcService).multiply(10.0,10.0);
      inOrder.verify(calcService).divide(200.0, 10.0);
      
      verify(calcService, times(1)).add(10.0, 20.0);
      verify(calcService, times(1)).divide(200.0, 10.0);

      //verify the behavior
      verify(calcService).add(10.0, 20.0);
      verify(calcService).subtract(20.0, 10.0);
      verify(calcService).multiply(10.0, 10.0);
      //verify(calcService).multiply(11.0, 0.0);
      verify(calcService).divide(200.0, 10.0);
   }
}
