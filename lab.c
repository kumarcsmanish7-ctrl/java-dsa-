#include<stdio.h>
#include<stdlib.h>
#include<ctype.h>
#define size 20
typedef struct{
    char arr[size];
    int top;
}stack;

void push(stack *s, char c){
    s->arr[++s->top]=c;
}
int pop(stack*s){
    return s->arr[s->top--];
}
int preced(char op){
    switch(op){
        case'+':
        case'-':return 1;
        case'*':
        case'/':return 2;
        case'^':return 3;
        default:
            printf("invalid");
            exit(0);
    }
}
void inftopostf(char inf[]){
    stack s;
    char symbol,temp;
    int i  ; 
    s.top =-1;
    for(i=0;inf[i]!='\0';i++){
        symbol =inf[i];
        if(isalpha(symbol)){
            putchar(symbol);//check if alphabet it will print the alphabet 
        }
        else if ( symbol=='('){
            push(&s, symbol);
        }
        else if(symbol==')'){
            while((temp=pop(&s))!='(')
            putchar(temp);

        }
        else{
            while(s.top!=-1&&s.arr[s.top]!='('&&preced(symbol)<preced(s.arr[s.top])){
                putchar(pop(&s));

            }
            push(&s,symbol);
        }
        
        
    }

    while(s.top!=-1)
        putchar(pop(&s));
}
int main(){
    char inf[size];
    printf("enter infix expression");
    scanf("%s",inf);
    printf("post expression:");
    inftopostf(inf);
    return 0;
}
