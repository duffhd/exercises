#include <malloc.h>
#include <stdbool.h>
#include <stdio.h>

typedef struct Node
{
    int value;
    struct Node *next_node;
} Node;

Node *create_node(int value) 
{
    Node *n;
    n = (Node *)malloc(sizeof(Node));
    n->value = value;
    n->next_node = NULL;
    return n;
}

void free_all(Node *n) 
{
    Node* temp;
    while(n != NULL) 
    {
        temp = n;
        n = n->next_node;
        free(temp);
    }
}

void add_node(Node *n, int value)
{
    if (n->next_node == NULL)
    {
        n->next_node = create_node(value);
        return;
    }

    Node *current_node = n;
    while (current_node->next_node != NULL)
    {
        current_node = current_node->next_node;
    }

    current_node->next_node = create_node(value);
}

bool contains(Node *n, int v)
{
    Node *current_node = n;
    while(current_node->next_node != NULL)
    {
        if(current_node->value == v) 
        {
            return true;
        }
 
        current_node = current_node->next_node;
    }

    if(current_node->value == v) 
    {
        return true;
    }

    return false;
}

int main()
{
    Node *n = create_node(1);

    add_node(n, 2);
    add_node(n, 3);
    add_node(n, 4);
    add_node(n, 5);

    free_all(n);
    return 0;
}

