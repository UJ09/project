/**
 * Class Memory .
 * This class is used to save results to memory
 */
public class Memory
{

private String[]  inp;
private double[] outp;
public Memory()
{
inp=new String[0];
outp=new double[0];
}
public void display()
{
System.out.println("INPUT\t\t\t\tOUTPUT");
for(int i=0;i<inp.length;i++)
{
System.out.println(inp[i]+"\t\t\t\t"+outp[i]);
}
}
public void append(String in, double out)
{
int l=inp.length;
String temp[]=new String[l+1];
for(int i=0;i<l;i++)
temp[i]=inp[i];
temp[l]=in;
inp=temp;
double tmp[]=new double[l+1];
for(int i=0;i<l;i++)
tmp[i]=outp[i];
tmp[l]=out;
outp=tmp;
}
public String getInp(int i) throws Exception
{
if(i<=inp.length)
return inp[i-1];
else
throw (new Exception("Mycalc:  \nResult not in memory"));
}
public String getOutp(int i) throws Exception
{
if(i<=inp.length)
return (""+outp[i-1]);
else
throw (new Exception("Mycalc: \nResult not in memory"));
}
public int getSize()
{
return(outp.length);
}
}
