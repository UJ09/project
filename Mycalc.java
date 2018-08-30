import java.util.*;
public class Mycalc
{
private static void printHelp()
{
System.out.println("Mycalc help : \n_________________________________________________________________________________________________________");
System.out.println("This calculator has two modes: Standard and Scientific.To use stored results, type <1> for the first result,");
System.out.println("<2> for the second result and so on. For a mixed expression which has both scientific and standard operations,");
System.out.println("first evaluate the scientific operation in scientific mode and store its value in memory.Then in standard mode");
System.out.println("write the expression with the memory number of the evaluated scientifc expression to get the answer of full expression.");
System.out.println("DO NOT TYPE SPACE IN EXPRESSION.");
System.out.println("Example -");
System.out.println("          5 + 2*(sin³ 30)");
System.out.println("        1.Here first in scientific mode evaluate sin 30 and store its value. [Its memory number will be 1]");
System.out.println("        2.Then again in scientific mode find sin³ 30 ,i.e,math.pow(<1>,3)[The value of sin 30 is saved under");
System.out.println("          memory number 1], and store its value. [Its memory number will be 2]");
System.out.println("        3.Then in standard mode evaluate 5+2*<2>.[<2> is the memory number of sin³ 30] \n\n");
System.out.println("____________________________________________________________________________________________________________\n\n");
}
private static void printHeader()
{
System.out.println("\f");
System.out.println("       *************************************************** ");
System.out.println("       *************************************************** ");
System.out.println("       **                                               ** ");
System.out.println("       **              STANDARD AND                     ** ");
System.out.println("       **              SCIENTIFIC CALCULATOR            ** ");
System.out.println("       **              BY                               ** ");
System.out.println("       **              UDAY JUNEJA                      ** ");
System.out.println("       **                                               ** ");
System.out.println("       **                                               ** ");
System.out.println("       **                                               ** ");
System.out.println("       *************************************************** ");
System.out.println("       *************************************************** \n\n\n");
}  
/**
 * The Main Method uses three classes - Standard, Scientific,and Memory.
 */
public static void main(String args[]) throws Exception
{
Scanner sc = new Scanner(System.in);
String ans = "yes";
Memory mem = new Memory();
printHeader();
printHelp();
String ans2="";
do
{
System.out.println("Enter 1 for standard calculator");
System.out.println("Enter 2 for scientific calculator");
System.out.println("Enter 3 to view stored results: ");
System.out.print("Enter any other value to exit .\n Enter Your Choice : ");
int z = sc.nextInt();
try
{
switch(z)
{
case 1:
Standard ob=new Standard();
String msg="[You have "+mem.getSize()+" results in Memory.]";
System.out.println("Enter an expression: to use stored results, type <1> for the first result, <2> for the second result and so on. \n"+msg);
String expr = sc.next();
String s=expr;
int n, pos2, pos, pos1=s.lastIndexOf("<");
while(pos1>=0)
{
pos2=(s.substring(pos1+1)).indexOf(">");
pos=pos1+1+pos2;
String in, out;
n=Integer.parseInt(s.substring(pos1+1,pos));
s=s.substring(0,pos1)+mem.getOutp(n)+s.substring(pos+1);
pos1=s.lastIndexOf("<");
}
expr=s;
System.out.println("Result---:  "+ob.calculate(expr)+"\n Do you want to save this result to memory? Press Y or N");
ans2=sc.next();
if(ans2.equalsIgnoreCase("Y"))
mem.append(expr, ob.calculate(expr));
break;
case 2:
Scientific obj=new Scientific();
msg="[You have "+mem.getSize()+" results in Memory.]";
System.out.println("To use stored results, type <1> for the first result, <2> for the second result and so on. \n"+msg+"\n\n");
System.out.println("Enter 1 to find the square root of a number");
System.out.println("Enter 2 to find the power(a) of a number(x) [xª]");
System.out.println("Enter 3 to find the logarithimic value of a number");
System.out.println("Enter 4 to find the absolute value of a number");
System.out.println("Enter 5 to find the sin value of an angle");
System.out.println("Enter 6 to find the cos value of an angle");
System.out.println("Enter 7 to find the tan value of an angle");
System.out.println("Enter 8 to find the exponential value [eª]");
System.out.println("Enter 9 to view stored results: ");
System.out.print("Enter any other value to exit .\n Enter Your Choice : ");
int q = sc.nextInt();
double p;
int z0;
double a;
String a0="",a1="";
switch(q)
{
case 1:
System.out.println("Enter the number - ");
a0 = sc.next();
if(a0.charAt(0)=='<')
{
a1 = a0.substring(1,a0.indexOf('>'));

z0 = Integer.parseInt(a1);
 a= Double.parseDouble(mem.getOutp(z0));
}
else
a=Double.parseDouble(a0);
System.out.println("Square root = "+obj.sqrt(a)+"\n Do you want to save this result to memory? Press Y or N" );
 ans2=sc.next();
if(ans2.equalsIgnoreCase("Y"))
mem.append("sqrt("+a+")", obj.sqrt(a));
break;
case 2:
System.out.println("Enter the number - ");
a0 = sc.next();
if(a0.charAt(0)=='<')
{
a1 = a0.substring(1,a0.indexOf('>'));
z0 = Integer.parseInt(a1);
 a= Double.parseDouble(mem.getOutp(z0));
}
else
a=Double.parseDouble(a0);
System.out.println("Enter its power -");
a0 = sc.next();
if(a0.charAt(0)=='<')
{
a1 = a0.substring(1,a0.indexOf('>'));
z0 = Integer.parseInt(a1);
 p= Double.parseDouble(mem.getOutp(z0));
}
else
p=Double.parseDouble(a0);
System.out.println("Answer = "+obj.pow(a,p)+"\n Do you want to save this result to memory? Press Y or N");
 ans2=sc.next();
if(ans2.equalsIgnoreCase("Y"))
mem.append("pow("+a+","+p+")", obj.pow(a,p));
break;
case 3:
System.out.println("Enter the number - ");
a0 = sc.next();
if(a0.charAt(0)=='<')
{
a1 = a0.substring(1,a0.indexOf('>'));
z0 = Integer.parseInt(a1);
 a= Double.parseDouble(mem.getOutp(z0));
}
else
a=Double.parseDouble(a0);
System.out.println("Its logarithimic value = "+obj.log(a)+"\n Do you want to save this result to memory? Press Y or N");
 ans2=sc.next();
if(ans2.equalsIgnoreCase("Y"))
mem.append("log("+a+")", obj.log(a));
break;
case 4:
System.out.println("Enter the number - ");
a0 = sc.next();
if(a0.charAt(0)=='<')
{
a1 = a0.substring(1,a0.indexOf('>'));
z0 = Integer.parseInt(a1);
 a= Double.parseDouble(mem.getOutp(z0));
}
else
a=Double.parseDouble(a0);
System.out.println("Its absolute value = "+obj.abs(a)+"\n Do you want to save this result to memory? Press Y or N");
 ans2=sc.next();
if(ans2.equalsIgnoreCase("Y"))
mem.append("abs("+a+")", obj.abs(a));
break;
case 5:
System.out.println("Enter the angle in degrees: ");
a0 = sc.next();
if(a0.charAt(0)=='<')
{
a1 = a0.substring(1,a0.indexOf('>'));
z0 = Integer.parseInt(a1);
 a= Double.parseDouble(mem.getOutp(z0));
}
else
a=Double.parseDouble(a0);
System.out.println("sin("+a+") = "+obj.sin(a)+"\n Do you want to save this result to memory? Press Y or N");
 ans2=sc.next();
if(ans2.equalsIgnoreCase("Y"))
mem.append("sin("+a+")", obj.sin(a));
break;
case 6:
System.out.println("Enter the angle in degrees: ");
a0 = sc.next();
if(a0.charAt(0)=='<')
{
a1 = a0.substring(1,a0.indexOf('>'));
z0 = Integer.parseInt(a1);
a = Double.parseDouble(mem.getOutp(z0));
}
else
a=Double.parseDouble(a0);
System.out.println("cos("+a+") = "+obj.cos(a)+"\n Do you want to save this result to memory? Press Y or N");
ans2=sc.next();
if(ans2.equalsIgnoreCase("Y"))
mem.append("cos("+a+")", obj.cos(a));
break;
case 7:
System.out.println("Enter the angle in degrees: ");
a0 = sc.next();
if(a0.charAt(0)=='<')
{
a1 = a0.substring(1,a0.indexOf('>'));
z0 = Integer.parseInt(a1);
a= Double.parseDouble(mem.getOutp(z0));
}
else
a=Double.parseDouble(a0);
System.out.println("tan "+a+" = "+obj.tan(a)+"\n Do you want to save this result to memory? Press Y or N");
ans2=sc.next();
if(ans2.equalsIgnoreCase("Y"))
mem.append("tan("+a+")", obj.tan(a));
break;
case 8:
System.out.println("Enter the power of e");
a0 = sc.next();
if(a0.charAt(0)=='<')
{
a1 = a0.substring(1,a0.indexOf('>'));
z0 = Integer.parseInt(a1);
a= Double.parseDouble(mem.getOutp(z0));
}
else
a=Double.parseDouble(a0);
System.out.println("Exponential value = "+obj.exp(a)+"\n Do you want to save this result to memory? Press Y or N");
ans2=sc.next();
if(ans2.equalsIgnoreCase("Y"))
mem.append("exp("+a+")", obj.exp(a));
break;
case 9:
mem.display();
}
break;
case 3:
mem.display();
}
}
catch(Exception e)
{
System.out.println("Error in expression.");
}
System.out.println("Do you want to continue ? [yes or no]");
ans = sc.next();
}
while(ans.equalsIgnoreCase("yes"));
System.out.println("Thank you for using my Calculator");
    }
    }