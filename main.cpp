#include <stdio.h>
#include <stdlib.h>

int possible[5040], possible_cnt = 0;

void intToChar(char ca[], int ia)
{
    for(int i=0; i<4; i++) {
        ca[3-i] = '0' + ia % 10;
        ia /= 10;
    }
}

int judge(int ia, int ib)
{
    char ca[5], cb[5];
    intToChar(ca,ia);
    intToChar(cb,ib);
    int result = 0;
    for(int i=0;i<4;i++)
    {
        for(int j=0;j<4;j++)
        {
            if (ca[i] == cb[j])
                result += i == j ? 10 : 1;
        }
    }
    return result;
}

int main()
{
    for(int i=0;i<10;i++)
    {
        for(int j=0;j<10;j++)
        {
            if(i==j) continue;
            for(int k=0;k<10;k++)
            {
                if(i==k||j==k) continue;
                for(int l=0;l<10;l++) {
                    if(i==l||j==l||k==l) continue;
                    possible[possible_cnt++] = i*1000 + j*100 + k*10 + l;
                }

            }
        }
    }
    //printf("%d\n", possible_cnt);
    int result;
    int tmp;
    do {
        printf("(%04d) please enter %04d result: ", possible_cnt, possible[0]);
        scanf(" %d", &result);
        for(int i=1; i<possible_cnt; i++)
		{ // skip 0
			//printf(" %04d : %4d\n",i,possible[i]);
			//system("pause");
			if(possible_cnt==5040) possible_cnt--;
            if(judge(possible[0], possible[i]) != result)
            {
            	//printf(" %04d : %4d\n",i,possible[i]);
            	//system("pause");
            	//printf(" %04d : %4d\n",possible_cnt,possible[possible_cnt]);
            	//system("pause");
            	while( judge(possible[0], possible[possible_cnt]) != result )
            	{
            		
            		//printf(" %04d : %4d\n",possible_cnt,possible[possible_cnt]);
            		//system("pause");
            		possible_cnt--;
				}
                possible[i] = possible[possible_cnt--];
			}
        }
        if (result != 40)
            possible[0] = possible[possible_cnt--];
		else break;
    }while(possible_cnt > 1);
    if (possible_cnt == 1||result==40)
        printf("Answer is %04d\n", possible[0]);
	else
        printf("No Answer\n");
    return 0;
}

//int main()
//{
//    int ia, ib;
//    while(scanf(" %d %d", &ia, &ib) != EOF)
//        printf("(%04d, %04d) = %02d\n", ia, ib, judge(ia, ib));
//}
