// $ANTLR 3.1.2 org/javaruntype/type/parser/Type.g 2010-02-02 00:25:32

/*
 * =============================================================================
 * 
 *   Copyright (c) 2009, The JAVARUNTYPE team (http://www.javaruntype.org)
 * 
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 * 
 * =============================================================================
 */
package org.javaruntype.type.parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class TypeParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ARRAY", "UNKNOWN", "BEGINTYPEPARAM", "ENDTYPEPARAM", "COMMA", "EXTENDS", "SUPER", "EXT", "SUP", "CLASSNAME", "WS"
    };
    public static final int WS=14;
    public static final int UNKNOWN=5;
    public static final int COMMA=8;
    public static final int EXT=11;
    public static final int ENDTYPEPARAM=7;
    public static final int SUPER=10;
    public static final int EOF=-1;
    public static final int EXTENDS=9;
    public static final int ARRAY=4;
    public static final int SUP=12;
    public static final int BEGINTYPEPARAM=6;
    public static final int CLASSNAME=13;

    // delegates
    // delegators


        public TypeParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public TypeParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return TypeParser.tokenNames; }
    public String getGrammarFileName() { return "org/javaruntype/type/parser/Type.g"; }


    public static class type_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "type"
    // org/javaruntype/type/parser/Type.g:100:1: type : typeExpression ;
    public final TypeParser.type_return type() throws RecognitionException {
        TypeParser.type_return retval = new TypeParser.type_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        TypeParser.typeExpression_return typeExpression1 = null;



        try {
            // org/javaruntype/type/parser/Type.g:101:5: ( typeExpression )
            // org/javaruntype/type/parser/Type.g:101:7: typeExpression
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_typeExpression_in_type160);
            typeExpression1=typeExpression();

            state._fsp--;

            adaptor.addChild(root_0, typeExpression1.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

            catch (RecognitionException e) {
            	throw e;
            }
        finally {
        }
        return retval;
    }
    // $ANTLR end "type"

    public static class typeExpression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "typeExpression"
    // org/javaruntype/type/parser/Type.g:105:1: typeExpression : ( CLASSNAME (arr+= ARRAY )* -> ^( CLASSNAME ( $arr)* ) | CLASSNAME BEGINTYPEPARAM typePar+= typeParameterization ( COMMA typePar+= typeParameterization )* ENDTYPEPARAM (arr+= ARRAY )* -> ^( CLASSNAME ( $arr)* ( $typePar)+ ) );
    public final TypeParser.typeExpression_return typeExpression() throws RecognitionException {
        TypeParser.typeExpression_return retval = new TypeParser.typeExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token CLASSNAME2=null;
        Token CLASSNAME3=null;
        Token BEGINTYPEPARAM4=null;
        Token COMMA5=null;
        Token ENDTYPEPARAM6=null;
        Token arr=null;
        List list_arr=null;
        List list_typePar=null;
        TypeParser.typeParameterization_return typePar = null;
         typePar = null;
        CommonTree CLASSNAME2_tree=null;
        CommonTree CLASSNAME3_tree=null;
        CommonTree BEGINTYPEPARAM4_tree=null;
        CommonTree COMMA5_tree=null;
        CommonTree ENDTYPEPARAM6_tree=null;
        CommonTree arr_tree=null;
        RewriteRuleTokenStream stream_ENDTYPEPARAM=new RewriteRuleTokenStream(adaptor,"token ENDTYPEPARAM");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_ARRAY=new RewriteRuleTokenStream(adaptor,"token ARRAY");
        RewriteRuleTokenStream stream_BEGINTYPEPARAM=new RewriteRuleTokenStream(adaptor,"token BEGINTYPEPARAM");
        RewriteRuleTokenStream stream_CLASSNAME=new RewriteRuleTokenStream(adaptor,"token CLASSNAME");
        RewriteRuleSubtreeStream stream_typeParameterization=new RewriteRuleSubtreeStream(adaptor,"rule typeParameterization");
        try {
            // org/javaruntype/type/parser/Type.g:106:5: ( CLASSNAME (arr+= ARRAY )* -> ^( CLASSNAME ( $arr)* ) | CLASSNAME BEGINTYPEPARAM typePar+= typeParameterization ( COMMA typePar+= typeParameterization )* ENDTYPEPARAM (arr+= ARRAY )* -> ^( CLASSNAME ( $arr)* ( $typePar)+ ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==CLASSNAME) ) {
                int LA4_1 = input.LA(2);

                if ( (LA4_1==BEGINTYPEPARAM) ) {
                    alt4=2;
                }
                else if ( (LA4_1==EOF||LA4_1==ARRAY||(LA4_1>=ENDTYPEPARAM && LA4_1<=COMMA)) ) {
                    alt4=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // org/javaruntype/type/parser/Type.g:106:7: CLASSNAME (arr+= ARRAY )*
                    {
                    CLASSNAME2=(Token)match(input,CLASSNAME,FOLLOW_CLASSNAME_in_typeExpression178);  
                    stream_CLASSNAME.add(CLASSNAME2);

                    // org/javaruntype/type/parser/Type.g:106:17: (arr+= ARRAY )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==ARRAY) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // org/javaruntype/type/parser/Type.g:106:18: arr+= ARRAY
                    	    {
                    	    arr=(Token)match(input,ARRAY,FOLLOW_ARRAY_in_typeExpression183);  
                    	    stream_ARRAY.add(arr);

                    	    if (list_arr==null) list_arr=new ArrayList();
                    	    list_arr.add(arr);


                    	    }
                    	    break;

                    	default :
                    	    break loop1;
                        }
                    } while (true);



                    // AST REWRITE
                    // elements: CLASSNAME, arr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: arr
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_arr=new RewriteRuleTokenStream(adaptor,"token arr", list_arr);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 106:36: -> ^( CLASSNAME ( $arr)* )
                    {
                        // org/javaruntype/type/parser/Type.g:106:39: ^( CLASSNAME ( $arr)* )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_CLASSNAME.nextNode(), root_1);

                        // org/javaruntype/type/parser/Type.g:106:51: ( $arr)*
                        while ( stream_arr.hasNext() ) {
                            adaptor.addChild(root_1, stream_arr.nextNode());

                        }
                        stream_arr.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // org/javaruntype/type/parser/Type.g:107:7: CLASSNAME BEGINTYPEPARAM typePar+= typeParameterization ( COMMA typePar+= typeParameterization )* ENDTYPEPARAM (arr+= ARRAY )*
                    {
                    CLASSNAME3=(Token)match(input,CLASSNAME,FOLLOW_CLASSNAME_in_typeExpression208);  
                    stream_CLASSNAME.add(CLASSNAME3);

                    BEGINTYPEPARAM4=(Token)match(input,BEGINTYPEPARAM,FOLLOW_BEGINTYPEPARAM_in_typeExpression210);  
                    stream_BEGINTYPEPARAM.add(BEGINTYPEPARAM4);

                    pushFollow(FOLLOW_typeParameterization_in_typeExpression214);
                    typePar=typeParameterization();

                    state._fsp--;

                    stream_typeParameterization.add(typePar.getTree());
                    if (list_typePar==null) list_typePar=new ArrayList();
                    list_typePar.add(typePar.getTree());

                    // org/javaruntype/type/parser/Type.g:107:62: ( COMMA typePar+= typeParameterization )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==COMMA) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // org/javaruntype/type/parser/Type.g:107:63: COMMA typePar+= typeParameterization
                    	    {
                    	    COMMA5=(Token)match(input,COMMA,FOLLOW_COMMA_in_typeExpression217);  
                    	    stream_COMMA.add(COMMA5);

                    	    pushFollow(FOLLOW_typeParameterization_in_typeExpression221);
                    	    typePar=typeParameterization();

                    	    state._fsp--;

                    	    stream_typeParameterization.add(typePar.getTree());
                    	    if (list_typePar==null) list_typePar=new ArrayList();
                    	    list_typePar.add(typePar.getTree());


                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);

                    ENDTYPEPARAM6=(Token)match(input,ENDTYPEPARAM,FOLLOW_ENDTYPEPARAM_in_typeExpression225);  
                    stream_ENDTYPEPARAM.add(ENDTYPEPARAM6);

                    // org/javaruntype/type/parser/Type.g:107:114: (arr+= ARRAY )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==ARRAY) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // org/javaruntype/type/parser/Type.g:107:115: arr+= ARRAY
                    	    {
                    	    arr=(Token)match(input,ARRAY,FOLLOW_ARRAY_in_typeExpression230);  
                    	    stream_ARRAY.add(arr);

                    	    if (list_arr==null) list_arr=new ArrayList();
                    	    list_arr.add(arr);


                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);



                    // AST REWRITE
                    // elements: arr, typePar, CLASSNAME
                    // token labels: 
                    // rule labels: retval
                    // token list labels: arr
                    // rule list labels: typePar
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_arr=new RewriteRuleTokenStream(adaptor,"token arr", list_arr);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_typePar=new RewriteRuleSubtreeStream(adaptor,"token typePar",list_typePar);
                    root_0 = (CommonTree)adaptor.nil();
                    // 107:133: -> ^( CLASSNAME ( $arr)* ( $typePar)+ )
                    {
                        // org/javaruntype/type/parser/Type.g:107:136: ^( CLASSNAME ( $arr)* ( $typePar)+ )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_CLASSNAME.nextNode(), root_1);

                        // org/javaruntype/type/parser/Type.g:107:148: ( $arr)*
                        while ( stream_arr.hasNext() ) {
                            adaptor.addChild(root_1, stream_arr.nextNode());

                        }
                        stream_arr.reset();
                        if ( !(stream_typePar.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_typePar.hasNext() ) {
                            adaptor.addChild(root_1, stream_typePar.nextTree());

                        }
                        stream_typePar.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

            catch (RecognitionException e) {
            	throw e;
            }
        finally {
        }
        return retval;
    }
    // $ANTLR end "typeExpression"

    public static class typeParameterization_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "typeParameterization"
    // org/javaruntype/type/parser/Type.g:111:1: typeParameterization : ( typeExpression | UNKNOWN | UNKNOWN EXTENDS typExp= typeExpression -> ^( EXT $typExp) | UNKNOWN SUPER typExp= typeExpression -> ^( SUP $typExp) );
    public final TypeParser.typeParameterization_return typeParameterization() throws RecognitionException {
        TypeParser.typeParameterization_return retval = new TypeParser.typeParameterization_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token UNKNOWN8=null;
        Token UNKNOWN9=null;
        Token EXTENDS10=null;
        Token UNKNOWN11=null;
        Token SUPER12=null;
        TypeParser.typeExpression_return typExp = null;

        TypeParser.typeExpression_return typeExpression7 = null;


        CommonTree UNKNOWN8_tree=null;
        CommonTree UNKNOWN9_tree=null;
        CommonTree EXTENDS10_tree=null;
        CommonTree UNKNOWN11_tree=null;
        CommonTree SUPER12_tree=null;
        RewriteRuleTokenStream stream_SUPER=new RewriteRuleTokenStream(adaptor,"token SUPER");
        RewriteRuleTokenStream stream_UNKNOWN=new RewriteRuleTokenStream(adaptor,"token UNKNOWN");
        RewriteRuleTokenStream stream_EXTENDS=new RewriteRuleTokenStream(adaptor,"token EXTENDS");
        RewriteRuleSubtreeStream stream_typeExpression=new RewriteRuleSubtreeStream(adaptor,"rule typeExpression");
        try {
            // org/javaruntype/type/parser/Type.g:112:5: ( typeExpression | UNKNOWN | UNKNOWN EXTENDS typExp= typeExpression -> ^( EXT $typExp) | UNKNOWN SUPER typExp= typeExpression -> ^( SUP $typExp) )
            int alt5=4;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==CLASSNAME) ) {
                alt5=1;
            }
            else if ( (LA5_0==UNKNOWN) ) {
                switch ( input.LA(2) ) {
                case EXTENDS:
                    {
                    alt5=3;
                    }
                    break;
                case SUPER:
                    {
                    alt5=4;
                    }
                    break;
                case ENDTYPEPARAM:
                case COMMA:
                    {
                    alt5=2;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 2, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // org/javaruntype/type/parser/Type.g:112:7: typeExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_typeExpression_in_typeParameterization291);
                    typeExpression7=typeExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, typeExpression7.getTree());

                    }
                    break;
                case 2 :
                    // org/javaruntype/type/parser/Type.g:113:7: UNKNOWN
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    UNKNOWN8=(Token)match(input,UNKNOWN,FOLLOW_UNKNOWN_in_typeParameterization299); 
                    UNKNOWN8_tree = (CommonTree)adaptor.create(UNKNOWN8);
                    adaptor.addChild(root_0, UNKNOWN8_tree);


                    }
                    break;
                case 3 :
                    // org/javaruntype/type/parser/Type.g:114:7: UNKNOWN EXTENDS typExp= typeExpression
                    {
                    UNKNOWN9=(Token)match(input,UNKNOWN,FOLLOW_UNKNOWN_in_typeParameterization307);  
                    stream_UNKNOWN.add(UNKNOWN9);

                    EXTENDS10=(Token)match(input,EXTENDS,FOLLOW_EXTENDS_in_typeParameterization309);  
                    stream_EXTENDS.add(EXTENDS10);

                    pushFollow(FOLLOW_typeExpression_in_typeParameterization313);
                    typExp=typeExpression();

                    state._fsp--;

                    stream_typeExpression.add(typExp.getTree());


                    // AST REWRITE
                    // elements: typExp
                    // token labels: 
                    // rule labels: retval, typExp
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_typExp=new RewriteRuleSubtreeStream(adaptor,"rule typExp",typExp!=null?typExp.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 114:45: -> ^( EXT $typExp)
                    {
                        // org/javaruntype/type/parser/Type.g:114:48: ^( EXT $typExp)
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(EXT, "EXT"), root_1);

                        adaptor.addChild(root_1, stream_typExp.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 4 :
                    // org/javaruntype/type/parser/Type.g:115:7: UNKNOWN SUPER typExp= typeExpression
                    {
                    UNKNOWN11=(Token)match(input,UNKNOWN,FOLLOW_UNKNOWN_in_typeParameterization330);  
                    stream_UNKNOWN.add(UNKNOWN11);

                    SUPER12=(Token)match(input,SUPER,FOLLOW_SUPER_in_typeParameterization332);  
                    stream_SUPER.add(SUPER12);

                    pushFollow(FOLLOW_typeExpression_in_typeParameterization336);
                    typExp=typeExpression();

                    state._fsp--;

                    stream_typeExpression.add(typExp.getTree());


                    // AST REWRITE
                    // elements: typExp
                    // token labels: 
                    // rule labels: retval, typExp
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_typExp=new RewriteRuleSubtreeStream(adaptor,"rule typExp",typExp!=null?typExp.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 115:43: -> ^( SUP $typExp)
                    {
                        // org/javaruntype/type/parser/Type.g:115:46: ^( SUP $typExp)
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(SUP, "SUP"), root_1);

                        adaptor.addChild(root_1, stream_typExp.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

            catch (RecognitionException e) {
            	throw e;
            }
        finally {
        }
        return retval;
    }
    // $ANTLR end "typeParameterization"

    // Delegated rules


 

    public static final BitSet FOLLOW_typeExpression_in_type160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CLASSNAME_in_typeExpression178 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ARRAY_in_typeExpression183 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_CLASSNAME_in_typeExpression208 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_BEGINTYPEPARAM_in_typeExpression210 = new BitSet(new long[]{0x0000000000002020L});
    public static final BitSet FOLLOW_typeParameterization_in_typeExpression214 = new BitSet(new long[]{0x0000000000000180L});
    public static final BitSet FOLLOW_COMMA_in_typeExpression217 = new BitSet(new long[]{0x0000000000002020L});
    public static final BitSet FOLLOW_typeParameterization_in_typeExpression221 = new BitSet(new long[]{0x0000000000000180L});
    public static final BitSet FOLLOW_ENDTYPEPARAM_in_typeExpression225 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ARRAY_in_typeExpression230 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_typeExpression_in_typeParameterization291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNKNOWN_in_typeParameterization299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNKNOWN_in_typeParameterization307 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_EXTENDS_in_typeParameterization309 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_typeExpression_in_typeParameterization313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNKNOWN_in_typeParameterization330 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_SUPER_in_typeParameterization332 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_typeExpression_in_typeParameterization336 = new BitSet(new long[]{0x0000000000000002L});

}