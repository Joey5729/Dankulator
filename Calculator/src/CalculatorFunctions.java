public class CalculatorFunctions {
	
public static String operation;
public static double memory = 0;

public static double computation(String num1, String num2){
	double val1 = Double.parseDouble(num1), val2 = Double.parseDouble(num2), result = 0;
	if(operation.equals("plus"))
	 result = add(val1,val2);
	else if(operation.equals("minus"))
	 result = subtract(val1,val2);
	else if(operation.equals("times"))
	 result = multiply(val1,val2);
	else if(operation.equals("divide"))
		 result = divide(val1,val2);
	else if(operation.equals("percent"))
		 result = percent(val1,val2);
	else if(operation.equals("modulus"))
		 result = modulus(val1,val2);
	return result;
}

public static void setOperation(String set){
	operation = set;
}

public static String getOperation(){
	return operation;
}

public static void setMemory(double set){
	memory = set;
}

public static double getMemory(){
	return memory;
}

public static void memoryAdd(double num){
	memory += num;
}

public static void memorySubtract(double num){
	memory -= num;
}

public static double add(double num1, double num2){
	return num1 + num2;
}

public static double subtract(double num1, double num2){
	return num1 - num2;
}

public static double multiply(double num1, double num2){
	return num1 * num2;
}

public static double divide(double num1, double num2){
	return num1 / num2;
}

public static double oneOverX(double num){
	return 1.0 / num;
}

public static double percent(double num1, double num2){
	return (num1 * num2) / 100.0;
}

public static double modulus(double num1, double num2){
	return num1%num2;
}

public static double plusMinus(double num){
	return -1.0*num;
}

public static double secondRoot(double num){
	return Math.sqrt(num);
}

public static double thirdRoot(double num){
	return Math.cbrt(num);
}

public static double ePower(int power){
	return Math.pow(Math.E, power);
}

public static double xPower(double num, int power){
	return Math.pow(num, power);
}

public static double naturalLog(double num){
	return Math.log(num);
}

public static double log(double num){
	return Math.log10(num);
}

public static double xFactorial(double num){
	int result = 1;
	for(int r=1; r<= num; r++){
		result *= r;
	}
	return result;
}

public static int random(){
	return 1 + (int)(Math.random()*100);
}

public static double tenToTheX(double num){
	return Math.pow(10, num);
}

public static String binary(int num){
	return Integer.toBinaryString(num);
}

public static String hexadecimal(int num){
	return Integer.toHexString(num);
}

public static String octal(int num){
	return Integer.toOctalString(num);
}

public static double sine(double num, int type){
	if(type==1)
		return Math.toDegrees(Math.sin(num));
	else
		return Math.sin(num);
}

public static double cosine(double num, int type){
	if(type==1)
		return Math.toDegrees(Math.cos(num));
	else
		return Math.cos(num);
}

public static double tangent(double num, int type){
	if(type==1)
		return Math.toDegrees(Math.tan(num));
	else
		return Math.tan(num);
}

public static double sineInverse(double num, int type){
	if(type==1)
		return Math.toDegrees(Math.asin(num));
	else
		return Math.asin(num);
}

public static double cosineInverse(double num, int type){
	if(type==1)
		return Math.toDegrees(Math.acos(num));
	else
		return Math.acos(num);
}

public static double tangentInverse(double num, int type){
	if(type==1)
		return Math.toDegrees(Math.atan(num));
	else
		return Math.tan(num);
}

public static double pi(){
	return Math.PI;
}

public static double tau(){
	return (2.0*Math.PI);
}
}