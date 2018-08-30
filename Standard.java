public class Standard
{
/**
 * array op[] contains operators
 */
 char[] op;
 /**
  * array o[] contains operands
  */
 double[] o;
 /**
  * Checks whether the character entered is an operator or not
  */
 private  boolean isOperator(char ch)
   {
      boolean flag=false;
      if(ch=='+' || ch=='-'||ch=='*' || ch=='/')
      flag=true;
      return(flag);
    }
    /**
     * Evaluates an expression having no brackets.
     */
    private double compute(String s)
    {
        buildArrays(s);
        return(eval());
    }
    
    /**
     * Stores all operators and operands in two arrays
     */
private void buildArrays(String s)
{
String s1="";
int pos=0;
int count=0;
if(s.charAt(0)=='-')
s="0"+s;
int ln=s.length();

for(int i=pos;i<s.length()-1;i++)
{
char c=s.charAt(i);
char c1=s.charAt(i+1);
if(isOperator(c)&& c1=='-')
{
i++;
count++;
    }
    else if(isOperator(c))
    count++;
    }
    op=new char[count];
    o=new double[count+1];
    for(int i=0;i<=count;i++)
    o[i]=1;
   
    int k=0, k1=0;
    for(int i=0;i<s.length();i++)
{
char c=s.charAt(i);
char c1=' ';
if(i<ln-1)
c1=s.charAt(i+1);

if(i<s.length()-1 && isOperator(c)==true && isOperator(c1)==false)
{
op[k]=c;
o[k]=1;
k++;
o[k1]=o[k1]*Double.parseDouble(s1);
s1="";
k1++;
    }
    else if(i<s.length()-1 && isOperator(c)==true && c1=='-')
{
op[k]=c;
k++;
o[k1]=o[k1]*Double.parseDouble(s1);
s1="-";
k1++;
i++;
    }
   
   else
    {
        s1=s1+c;
    }
    }
    o[count]=Double.parseDouble(s1);
    for(int i=0;i<op.length;i++)
{
if(op[i]=='-')
{
op[i]='+';
o[i+1]=-o[i+1];
    }
    }
 
    
 
  double res= eval();
    }
    
    /**
     * Evaluates the result
     */
    
private double eval()
{

double s=o[0];
int pos=0;
for(int i=0;i<op.length;i++)
{
if(op[i]=='*')
{o[i+1]=o[i+1]*o[i];
o[i]=0;
op[i]=' ';}
else if(op[i]=='/')
{o[i+1]=o[i]/o[i+1];
o[i]=0;
op[i]=' ';
    }
    }
 
    
    double r=0;
for(int i=0;i<op.length;i++)
{
if(op[i]=='-')
{
int j=i;
while(o[j++]==0);
o[j]=-1*o[j];

    }
}

for(int i=0;i<o.length;i++)
{r=r+o[i];}
return(r);
    }
    
    /**
     * Calculate: this method evaluates an expression having brackets. Only
     * first bracket is allowed. Uses the "compute" method.
     */
    public   double calculate(String str)
    {
       double res=0.0;
       
        int p1;
        do{
        p1=str.lastIndexOf("(");
        if(p1<0) break;
         String st=str.substring(p1+1);
        int p2=st.indexOf(")");
        
        String s=st.substring(0,p2);
     
     
       str=str.substring(0,p1);
       str=str+compute(s);
       str=str+st.substring(p2+1);;
       str=str.replace("+-","-");
        str=str.replace("-+","-");
         str=str.replace("--","+");
       
    }
    
        while(p1>=0);
     res=compute(str);
     return(res);
    }
    }