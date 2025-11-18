public class MagpieRunner
{ 
public static void main(String[] args)
   {
     Magpie maggie = new Magpie();
     System.out.println(maggie.getGreeting());
     System.out.println(maggie.getResponse("My mother and I talked last night."));
     System.out.println(maggie.getResponse("I said no!"));
     System.out.println(maggie.getResponse("The weather is nice."));
     System.out.println(maggie.getResponse("Do you know my brother?"));
   }
   }