package question4_lambda;

import java.util.function.BiConsumer;

//BiConsumer is a functional interface, it has a method accept() that retruns nothing.
//Consumer accept takes one arg. BiConsumer accept takes two args. 
// it applies the lambda expression that is passed to it (for exmple a/b)

public class lambda {
	
	//here it is unaware of the operation 'temp' and hence we cannot handle exceptions here.
	private static void myfucntion(int[] num,int val, BiConsumer<Integer,Integer> temp){
		for(int i: num) {
			temp.accept(i,val);
		}
	}
	public static void main(String[] args) {
		int [] num = {1,2,3,4,5,6,7,8,9};
		int val = 0;
		//int val = 2;
		
		myfucntion(num, val, wrapperLambda((a,b)-> System.out.println(a/b)));
	}
	
	//returning same thing that is received the original lambda function
//	private static BiConsumer<Integer,Integer> wrapperLambda(BiConsumer<Integer,Integer> consumer){
//		return temp;
//		}
	
	//overwiting the functionality of the original lambda function (this will print sum instead of division i.e. item+2)
//	private static BiConsumer<Integer,Integer> wrapperLambda(BiConsumer<Integer,Integer> consumer){
//		return ((a,b)-> System.out.println(a+b));
//		}
	
	
	//true Wrapper , performing same operations as original func (not usefull)
//	private static BiConsumer<Integer,Integer> wrapperLambda(BiConsumer<Integer,Integer> consumer){
//		return (a,b)->{
//			temp.accept(a, b);
//		};
//	}
	
	private static BiConsumer<Integer,Integer> wrapperLambda(BiConsumer<Integer,Integer> temp){
		return (a,b)->{
			try {
				temp.accept(a, b);
			}
			catch(ArithmeticException e) {
				System.out.println("ArithmeticException cacught inside wrapper lambda.");
			}
		};
	}
}