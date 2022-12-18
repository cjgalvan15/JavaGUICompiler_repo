package compilerPrograms;

public class SyntaxAnalysis 
{
	private static String result="";
	public SyntaxAnalysis(String input)
	{
		setSyntax(input);
	}
	public void setSyntax(String input)
	{
		result = doesSyntaxCorrect(input);
	}
	public String getSyntax()
	{
		return result;
	}
	public static String doesSyntaxCorrect(String input)
	{
		String str = "<data_type><identifier><assignment_operator><value><delimiter>";
        String str1 = "<data_type><identifier><delimiter>";
        input = input.replace(" ", "");
        if(str.equals(input) || str1.equals(input))
        {
            result = "These are the corresponding lexemes: "+input+"\nTherefore, the syntax is correct!";
        }
        else if(!str.equals(input) || !str1.equals(input))
        {
            result = "These are the corresponding lexemes: "+input+"\nTherefore, the syntax is error!";
        }
        return result;
	}

}
