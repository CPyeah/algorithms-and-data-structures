两个栈：数字栈，和符号栈

从左往右遍历字符串，加入到栈中
如果当前符号，不大于top，把top符号计算掉

3 + 2 * 2 / 4

numStack: 3 2 2
sign:     + *     <- (/)

calculate top of signStack *

numStack: 3 4 4
sign:     + /

finally, calculate all num and sign
numStack: 3 1
sign:     + 

numStack: 4
sign:     