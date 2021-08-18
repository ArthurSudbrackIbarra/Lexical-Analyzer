# Lexical Analyzer (Analisador Léxico)

A atividade consiste um projetar e construir um lexer/tokenizer simples para os tipos de tokens da gramática de aritmética básica. A linguagem de programação é de livre escolha e os arquivos com o código-fonte devem ser enviados através do Moodle. Esta atividade não é avaliativa.

A linguagem de aritmética tem os seguintes tokens e códigos:

#### Token	id	Comentário<br>
#### IDENT	1	Nomes de variáveis<br>
#### INT_LIT	2	Números inteiros<br>
#### LPAREN	3	'('<br>
#### RPAREN	4	')'<br>
#### ADD_OP	5	'+'<br>
#### SUB_OP	6	'-'<br>
#### MUL_OP	7	'*'<br>
#### DIV_OP	8	'/'<br>
#### GT_OP	9	'>'<br>
#### LT_OP	10	'<'<br>
#### EQ_OP	11	'=='<br>
#### ASSIGN_OP	12	':='<br>

Considerações sobre a linguagem:
Variáveis não podem começar com dígitos mas podem ter dígitos e caracteres depois do segundo símbolo.
As expressões possuem apenas números inteiros.
Não há números negativos neste nível de análise ainda.
Considere que os lexemas relativos aos números terão tamanho menor 100 dígitos. A mesma restrição de tamanho se aplica aos nomes de variáveis.
A análise léxica consiste em estabelecer triplas do tipo (lexema, token, token_id) a partir de uma string de entrada. Por exemplo, supondo que a entrada seja:

#### a := (aux - 2) * 200 / 19
O analisador léxico deve produzir as seguintes triplas:

#### ('a', IDENT, 1)<br>
#### (':=', ASSIGN_OP, 12)<br>
#### ('(', LPAREN, 3)<br>
#### ('aux', IDENT, 1)<br>
#### ('-', SUB_OP, 6)<br>
#### ('2', INT_LIT, 2)<br>
#### (')', RPAREN, 4)<br>
#### ('*', MUL_OP, 7)<br>
#### ('200', INT_LIT, 2)<br>
#### ('/', DIV_OP, 13)<br>
#### ('19', INT_LIT, 2)<br>

Estratégia para a análise léxica:
A análise léxica extrai um caractere de cada vez da entrada.
Se este caractere fizer parte de um lexema do tipo variável ou um número, é necessário guardar esta informação ao ler o próximo símbolo.
Esta informação determina se a leitura do próximo símbolo a ser lido deve ser um dígito ou um caractere ou apenas um dígito.
Um novo lexema é iniciado quando o símbolo lido pertence a um token diferente do atual ou então através da leitura de um caractere de espaço em branco, quebra de linha '\n', tabulação '\t', retorno de cursor '\r'. Estes símbolos atuam como delimitadores e indicam que o lexema atual encerrou. O caractere de final de arquivo EOF também encerra um lexema assim como termina a execução do programa.