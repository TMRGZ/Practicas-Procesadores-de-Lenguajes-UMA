package CalculadoraNPI;
//----------------------------------------------------
// The following code was generated by CUP v0.11a beta 20060608
// Sun Dec 16 17:05:22 GMT 2018
//----------------------------------------------------

import java_cup.runtime.*;

/** CUP v0.11a beta 20060608 generated parser.
  * @version Sun Dec 16 17:05:22 GMT 2018
  */
public class parser extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public parser() {super();}

  /** Constructor which sets the default scanner. */
  public parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\016\000\002\004\004\000\002\002\004\000\002\004" +
    "\003\000\002\005\004\000\002\005\003\000\002\002\005" +
    "\000\002\002\005\000\002\002\005\000\002\002\005\000" +
    "\002\006\002\000\002\002\006\000\002\002\003\000\002" +
    "\007\002\000\002\002\005" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\030\000\012\005\ufff5\010\ufff8\012\004\015\005\001" +
    "\002\000\016\004\ufff6\005\ufff6\006\ufff6\007\ufff6\011\ufff6" +
    "\015\ufff6\001\002\000\014\002\ufffd\005\ufffd\010\ufffd\012" +
    "\ufffd\015\ufffd\001\002\000\004\005\031\001\002\000\004" +
    "\010\026\001\002\000\014\002\025\005\ufff5\010\ufff8\012" +
    "\004\015\005\001\002\000\014\002\uffff\005\uffff\010\uffff" +
    "\012\uffff\015\uffff\001\002\000\014\004\014\005\015\006" +
    "\017\007\016\015\013\001\002\000\014\002\ufffe\005\ufffe" +
    "\010\ufffe\012\ufffe\015\ufffe\001\002\000\010\005\ufff5\010" +
    "\ufff8\012\004\001\002\000\010\005\ufff5\010\ufff8\012\004" +
    "\001\002\000\010\005\ufff5\010\ufff8\012\004\001\002\000" +
    "\010\005\ufff5\010\ufff8\012\004\001\002\000\016\004\ufffa" +
    "\005\ufffa\006\ufffa\007\ufffa\011\ufffa\015\ufffa\001\002\000" +
    "\016\004\ufff9\005\ufff9\006\ufff9\007\ufff9\011\ufff9\015\ufff9" +
    "\001\002\000\016\004\ufffb\005\ufffb\006\017\007\016\011" +
    "\ufffb\015\ufffb\001\002\000\016\004\ufffc\005\ufffc\006\017" +
    "\007\016\011\ufffc\015\ufffc\001\002\000\014\002\001\005" +
    "\001\010\001\012\001\015\001\001\002\000\004\002\000" +
    "\001\002\000\010\005\ufff5\010\ufff8\012\004\001\002\000" +
    "\014\004\014\005\015\006\017\007\016\011\030\001\002" +
    "\000\016\004\ufff7\005\ufff7\006\ufff7\007\ufff7\011\ufff7\015" +
    "\ufff7\001\002\000\010\005\ufff5\010\ufff8\012\004\001\002" +
    "\000\016\004\ufff4\005\ufff4\006\ufff4\007\ufff4\011\ufff4\015" +
    "\ufff4\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\030\000\014\002\011\004\007\005\010\006\006\007" +
    "\005\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\012\002\011\005\023\006" +
    "\006\007\005\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\010\002\022\006\006\007\005\001" +
    "\001\000\010\002\021\006\006\007\005\001\001\000\010" +
    "\002\020\006\006\007\005\001\001\000\010\002\017\006" +
    "\006\007\005\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\010\002\026\006\006\007\005\001\001" +
    "\000\002\001\001\000\002\001\001\000\010\002\031\006" +
    "\006\007\005\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 1;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}

}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$parser$actions {
  private final parser parser;

  /** Constructor */
  CUP$parser$actions(parser parser) {
    this.parser = parser;
  }

  /** Method with the actual generated action code. */
  public final java_cup.runtime.Symbol CUP$parser$do_action(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$parser$result;

      /* select the action based on the action number */
      switch (CUP$parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // exp ::= NT$1 MENOS exp 
            {
              String RESULT =null;
              // propagate RESULT from NT$1
                RESULT = (String) ((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int eleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String e = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		System.out.print("- "); RESULT = e; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("exp",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // NT$1 ::= 
            {
              String RESULT =null;
System.out.print("0 ");
              CUP$parser$result = parser.getSymbolFactory().newSymbol("NT$1",5, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // exp ::= NUMERO 
            {
              String RESULT =null;
		int nleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int nright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String n = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		System.out.print(n + " ");
              CUP$parser$result = parser.getSymbolFactory().newSymbol("exp",0, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // exp ::= NT$0 AP exp CP 
            {
              String RESULT =null;
              // propagate RESULT from NT$0
                RESULT = (String) ((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-3)).value;
		int eleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		String e = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		System.out.print(" "); RESULT = e;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("exp",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // NT$0 ::= 
            {
              String RESULT =null;
System.out.print(" ");
              CUP$parser$result = parser.getSymbolFactory().newSymbol("NT$0",4, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // exp ::= exp DIV exp 
            {
              String RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		String e1 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String e2 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		System.out.print("/ "); RESULT = e1; RESULT = e2;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("exp",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // exp ::= exp POR exp 
            {
              String RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		String e1 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String e2 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		System.out.print("* "); RESULT = e1; RESULT = e2;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("exp",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // exp ::= exp MENOS exp 
            {
              String RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		String e1 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String e2 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		System.out.print("- "); RESULT = e1; RESULT = e2;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("exp",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // exp ::= exp MAS exp 
            {
              String RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		String e1 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String e2 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		System.out.print("+ "); RESULT = e1; RESULT = e2;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("exp",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // linea ::= EOLN 
            {
              String RESULT =null;
		RESULT = "";
              CUP$parser$result = parser.getSymbolFactory().newSymbol("linea",3, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // linea ::= exp EOLN 
            {
              String RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		String e = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT = e;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("linea",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // lista ::= linea 
            {
              Object RESULT =null;
		int linleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int linright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String lin = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		System.out.println();
              CUP$parser$result = parser.getSymbolFactory().newSymbol("lista",2, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= lista EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT = start_val;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$parser$parser.done_parsing();
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // lista ::= lista linea 
            {
              Object RESULT =null;
		int lisleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int lisright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object lis = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int linleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int linright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String lin = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		System.out.println();
              CUP$parser$result = parser.getSymbolFactory().newSymbol("lista",2, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number found in internal parse table");

        }
    }
}

