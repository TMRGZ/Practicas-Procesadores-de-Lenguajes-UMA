int x;
x = 7;
int y;
y = 1;
int *p;
int **q;
int ***r;
int ****s;
p = &x;
q = &p;
r = &q;
s = &r;
y=2;
**q = y;
y=3;
**r = &y;
y=4;
***s = &y;
y=5;
****s = 6;
print (x);
print (y);
print (*p);
print (**q);
print (***r);
print (****s);
