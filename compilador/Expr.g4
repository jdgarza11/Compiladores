grammar Expr;		

all: program;

program: 'program' ID ';' o_vars o_funcs 'main' body 'end' EOF;

o_vars: vars
    | 
    ;

o_funcs: funcs o_funcs
    |
    ;

vars: VAR variables;

variables: listid ':' type ';' listvar;

listvar: variables
    | 
    ;

listid: ID 
    | ID ',' listid
    ;


funcs: 'void' ID '(' input ')' '[' o_vars body ']' ';';

input: ID ':' type listinput
    | 
    ;

listinput: ',' input
    | 
    ;

body: '{' o_statement '}';

    
type: 'int' | 'float';

o_statement: statement o_statement
    |
    ;

    
statement: assign
    | condition
    | cycle
    | f_call
    | print
    ;

assign: ID '=' expresion ';';

condition: 'if' '(' expresion ')' body elses ';';

elses: 'else' body
    | 
    ;   

cycle: 'while' '(' expresion ')' 'do' body ';';

f_call: ID '(' list_exp ')' ';';

list_exp: expresion mas_exp
    | 
    ;

mas_exp: ',' list_exp
    | 
    ;

print: 'print' '(' exps ')' ';';

exps: expresion ext
    | STRING
    ;

ext: exps
    | 
    ;

expresion: exp op;

exp
    : termino mas_menos
    ;

mas_menos
    : '+' termino mas_menos
    | '-' termino mas_menos
    | // vacío
    ;

termino
    : factor por_div
    ;

por_div
    : '*' factor por_div
    | '/' factor por_div
    | // vacío
    ;
op: tokenop
    |
    ;

tokenop: '>' exp
    | '<' exp
    | '!=' exp
    | 
    ;

factor: opt;

opt: '(' expresion ')'
    | mas idcte
    ;

mas: '+'
    | '-'
    | 
    ;

idcte: ID
    | INT
    | FLOAT
    ;

IF       : 'if';
WHILE    : 'while';
DO       : 'do';
PRINT    : 'print';
PROGRAM  : 'program';
MAIN     : 'main';
END      : 'end';
VOID     : 'void';
VAR      : 'var';
ELSE     : 'else';


EQUAL     : '=';
LPAREN : '(';
RPAREN : ')';
LBRACE : '{';
RBRACE : '}';
LBRAQ  : '[';
RBRAQ  : ']';
COMMA  : ',';
SEMI   : ';';

ID     : [a-zA-Z_][a-zA-Z_0-9]*;
INT    : [0-9]+;
FLOAT  : [0-9]+'.'[0-9]+;
STRING : '"' (~["\\] | '\\' .)* '"' ;


WS     : [ \t\r\n]+ -> skip ;
COMMENT: '//' ~[\r\n]* -> skip;