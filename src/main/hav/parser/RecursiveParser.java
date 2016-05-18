package main.hav.parser;

public class RecursiveParser {

    public double evaluate(String expr) throws ParserException
    {
        return evaluateIntern(expr.replaceAll(" ", "").toLowerCase());
    }

    private int find(String s, char c)
    {
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--)
        {
            if (s.charAt(i) == '(') count++;
            if (s.charAt(i) == ')') count--;
            if (s.charAt(i) == c && count == 0) return i;
        }
        return -1;
    }

    private double evaluateIntern(String expr) throws ParserException
    {
        int index;
        
        // this should not happen...
        if (expr.isEmpty())
            throw new ParserException("Empty string");

        if (expr.charAt(0) == '-' || expr.charAt(0) == '+')
            expr = '0' + expr;

        if ((index = find(expr, '+')) >= 0)
        {
            return (evaluateIntern(expr.substring(0, index)) +
                    evaluateIntern(expr.substring(index+1, expr.length())));
        }
        else if ((index = find(expr, '-')) >= 0)
        {
            return (evaluateIntern(expr.substring(0, index)) -
                    evaluateIntern(expr.substring(index+1, expr.length())));
        }
        else if ((index = find(expr, '*')) >= 0)
        {
            return (evaluateIntern(expr.substring(0, index)) *
                    evaluateIntern(expr.substring(index+1, expr.length())));
        }
        else if ((index = find(expr, '/')) >= 0)
        {
            return (evaluateIntern(expr.substring(0, index)) /
                    evaluateIntern(expr.substring(index+1, expr.length())));
        }


        if (expr.charAt(0) == '(')
        {
            if (expr.charAt(expr.length()-1) == ')')
                return (evaluate(expr.substring(1, expr.length()-1)));
            else
                throw new ParserException("Invalid brackets: " + expr);
        }

        try {
            return Double.parseDouble(expr);
        } catch (NumberFormatException ex) {
            throw new ParserException("String to number parsing exception: " + expr);
        }

    }

}
