public class Scientific
{
/**
 * In this class all the math functions are evaluated.
 */
double sqrt(double a)
{
return(Math.sqrt(a));
}
double pow(double a,double b)
{
return(Math.pow(a,b));
}
double log(double a)
{
return(Math.log(a));
}
double abs(double a)
{
return(Math.abs(a));
}
double sin(double a)
{
double r = (22.0/(7*180))*a;
return(Math.sin(r));
}
double cos(double a)
{
double r = (22.0/(7*180))*a;
return(Math.cos(r));    
}
double tan(double a)
{
if(a!=90)
{
double r = (22.0/(7*180))*a;
return(Math.tan(r));
}
else
{
System.out.println("tan 90º is undefined");
return(1/0);
}
}
double exp(double a)
{
return(Math.exp(a));
}

}
