import java.util.*;

class Solution
{
    
    public String solution(String s, String skip, int index)
    {
        String answer = "";
        
        // 1. validation
        // 1-1. range
        if( !validRange(s.length(), 5, 50) ) return "";
        if( !validRange(skip.length(), 1, 10) ) return "";
        if( !validRange(index, 1, 20) ) return "";
        // 1-2. lower case only
        if( !isLowerCase(s) ) return "";
        if( !isLowerCase(skip) ) return "";
        // 1-3. check duplicate
        if( isDuplicate(s, skip) ) return "";
        
        // 97~122 a~z
        ArrayList<String> arr = new ArrayList();
        for(int i = 0; i<=122-97; i++)
        {
            arr.add(((char)(97+i))+"");
        }
        
        // skip remove
        for( int i=0; i<skip.length(); i++ )
        {
            arr.remove(skip.charAt(i)+"");
        }
        
        // result
        for( int i=0; i<s.length(); i++ )
        {
            
            int result = arr.indexOf(s.charAt(i)+"") + index < arr.size()
                       ? arr.indexOf(s.charAt(i)+"") + index
                       : (arr.indexOf(s.charAt(i)+"") + index - arr.size()) % arr.size();
            
            answer += arr.get(result);
        }
        
        return answer;
        
    }
    
    public boolean validRange(int value, int start, int end)
    {
        return ( start <= value && value <= end ) ? true : false ;
    }
    
    public boolean isLowerCase(String value)
    {
        return value.equals(value.toLowerCase()) ? true : false ;
    }
    
    public boolean isDuplicate(String value1, String value2)
    {
        boolean isDuplicate = false;
        for( int i=0; i<value1.length(); i++ )
        {
            for( int j=0; j<value2.length(); j++)
            {
                if( value2.charAt(j) == value1.charAt(i) )
                    isDuplicate = true;
            }
        }
        return isDuplicate;
    }
}