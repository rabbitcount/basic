grammar Ape;

// ------------ expression
expression
    :	assignmentExpression
	;

assignmentExpression
	:	conditionalExpression
	|	assignment
	;

// ------ about assignment
assignment
	:	leftHandSide assignmentOperator expression
	;

leftHandSide
	:	expressionName
//	|	fieldAccess
//	|	arrayAccess
	;

assignmentOperator
	:	'='
//	|	'*='
//	|	'/='
//	|	'%='
//	|	'+='
//	|	'-='
//	|	'<<='
//	|	'>>='
//	|	'>>>='
//	|	'&='
//	|	'^='
//	|	'|='
	;

expressionName
	:	Identifier
	|	ambiguousName '.' Identifier
	;

ambiguousName
	:	Identifier
	|	ambiguousName '.' Identifier
	;


// ----------- statement
statement
	:	statementWithoutTrailingSubstatement
//	|	labeledStatement
	|	ifThenStatement
	|	ifThenElseStatement
//	|	whileStatement
//	|	forStatement
	;

statementWithoutTrailingSubstatement
	:
//	    block
//	|	emptyStatement
	|	expressionStatement
//	|	assertStatement
//	|	switchStatement
//	|	doStatement
//	|	breakStatement
//	|	continueStatement
//	|	returnStatement
//	|	synchronizedStatement
//	|	throwStatement
//	|	tryStatement
	;

expressionStatement
	:	statementExpression ';'
	;

statementExpression
	:	assignment
//	|	preIncrementExpression
//	|	preDecrementExpression
//	|	postIncrementExpression
//	|	postDecrementExpression
//	|	methodInvocation
//	|	classInstanceCreationExpression
	;

ifThenStatement
	:	'if' '(' expression ')' statement
	;

ifThenElseStatement
	:	'if' '(' expression ')' statementNoShortIf 'else' statement
	;

ifThenElseStatementNoShortIf
	:	'if' '(' expression ')' statementNoShortIf 'else' statementNoShortIf
	;

statementNoShortIf
	:	statementWithoutTrailingSubstatement
//	|	labeledStatementNoShortIf
	|	ifThenElseStatementNoShortIf
//	|	whileStatementNoShortIf
//	|	forStatementNoShortIf
	;


// ----------- condition expression
conditionalExpression
	:	conditionalOrExpression
//	|	conditionalOrExpression '?' expression ':' conditionalExpression
	;

conditionalOrExpression
	:	conditionalAndExpression
	|	conditionalOrExpression '||' conditionalAndExpression
	;

conditionalAndExpression
	:	inclusiveOrExpression
	|	conditionalAndExpression '&&' inclusiveOrExpression
	;

inclusiveOrExpression
	:	exclusiveOrExpression
	|	inclusiveOrExpression '|' exclusiveOrExpression
	;

exclusiveOrExpression
	:	andExpression
	|	exclusiveOrExpression '^' andExpression
	;

andExpression
	:	equalityExpression
	|	andExpression '&' equalityExpression
	;

equalityExpression
	:	relationalExpression
	|	equalityExpression '==' relationalExpression
	|	equalityExpression '!=' relationalExpression
	;

relationalExpression
	:	additiveExpression
	|	relationalExpression '<' additiveExpression
	|	relationalExpression '>' additiveExpression
	|	relationalExpression '<=' additiveExpression
	|	relationalExpression '>=' additiveExpression
//	|	relationalExpression 'instanceof' referenceType
	;

additiveExpression
	:	multiplicativeExpression
	|	additiveExpression '+' multiplicativeExpression
	|	additiveExpression '-' multiplicativeExpression
	;

multiplicativeExpression
	:	postfixExpression
	|	multiplicativeExpression '*' postfixExpression
	|	multiplicativeExpression '/' postfixExpression
	|	multiplicativeExpression '%' postfixExpression
	;

postfixExpression
	:	(
			expressionName
		)*
	;
