# Lexical Analyzer (Analisador Léxico)

A atividade consiste um projetar e construir um lexer/tokenizer simples para os tipos de tokens da gramática de aritmética básica. A linguagem de programação é de livre escolha e os arquivos com o código-fonte devem ser enviados através do Moodle. Esta atividade não é avaliativa.

A linguagem de aritmética tem os seguintes tokens e códigos:

Token	id	Comentário
IDENT	1	Nomes de variáveis
INT_LIT	2	Números inteiros
LPAREN	3	'('
RPAREN	4	')'
ADD_OP	5	'+'
SUB_OP	6	'-'
MUL_OP	7	'*'
DIV_OP	8	'/'
GT_OP	9	'>'
LT_OP	10	'<'
EQ_OP	11	'=='
ASSIGN_OP	12	':='

Considerações sobre a linguagem:
Variáveis não podem começar com dígitos mas podem ter dígitos e caracteres depois do segundo símbolo.
As expressões possuem apenas números inteiros.
Não há números negativos neste nível de análise ainda.
Considere que os lexemas relativos aos números terão tamanho menor 100 dígitos. A mesma restrição de tamanho se aplica aos nomes de variáveis.
A análise léxica consiste em estabelecer triplas do tipo (lexema, token, token_id) a partir de uma string de entrada. Por exemplo, supondo que a entrada seja:

a := (aux - 2) * 200 / 19
O analisador léxico deve produzir as seguintes triplas:

('a', IDENT, 1)
(':=', ASSIGN_OP, 12)
('(', LPAREN, 3)
('aux', IDENT, 1)
('-', SUB_OP, 6)
('2', INT_LIT, 2)
(')', RPAREN, 4)
('*', MUL_OP, 7)
('200', INT_LIT, 2)
('/', DIV_OP, 13)
('19', INT_LIT, 2)

Estratégia para a análise léxica:
A análise léxica extrai um caractere de cada vez da entrada.
Se este caractere fizer parte de um lexema do tipo variável ou um número, é necessário guardar esta informação ao ler o próximo símbolo.
Esta informação determina se a leitura do próximo símbolo a ser lido deve ser um dígito ou um caractere ou apenas um dígito.
Um novo lexema é iniciado quando o símbolo lido pertence a um token diferente do atual ou então através da leitura de um caractere de espaço em branco, quebra de linha '\n', tabulação '\t', retorno de cursor '\r'. Estes símbolos atuam como delimitadores e indicam que o lexema atual encerrou. O caractere de final de arquivo EOF também encerra um lexema assim como termina a execução do programa.